package com.brief.safetyNetAlerts.Service;

import com.brief.safetyNetAlerts.model.Alert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AlertService {
    List<Alert> list();
    Optional<Alert> listId(Long id);
    Alert add(Alert alert);
    Alert edit(Alert alert);
    void deleteAlert(Long id);
    List<Alert> listType();
}

package com.brief.safetyNetAlerts.Service.ServiceImpl;

import com.brief.safetyNetAlerts.Service.AlertService;
import com.brief.safetyNetAlerts.model.Alert;
import com.brief.safetyNetAlerts.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertRepository alertRepository;

    @Override
    public List<Alert> list() { return alertRepository.findAll(); }

    @Override
    public Optional<Alert> listId(Long id) { return alertRepository.findById(id); }

    @Override
    public Alert add(Alert alert) {
        return alertRepository.save(alert);
    }

    @Override
    public Alert edit(Alert alert) { return alertRepository.save(alert); }

    @Override
    public void deleteAlert(final Long id) {
        Optional<Alert>alert = alertRepository.findById(id);
        if(alert != null){
            alertRepository.delete(alert.get());
        }
    }

    @Override
    public List<Alert> listType() { return alertRepository.findAll(); }

}

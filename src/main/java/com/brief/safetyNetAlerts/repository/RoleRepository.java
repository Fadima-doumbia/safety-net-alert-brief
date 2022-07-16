package com.brief.safetyNetAlerts.repository;

import com.brief.safetyNetAlerts.model.Role;
import com.brief.safetyNetAlerts.model.emunModel.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}

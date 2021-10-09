package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
	Supervisor findSupervisorBySupervisorUsernameAndSupervisorPassword(String supervisorUsername, String supervisorPassword);
} 
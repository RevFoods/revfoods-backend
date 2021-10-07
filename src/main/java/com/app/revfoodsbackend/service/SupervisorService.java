package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Supervisor;

public interface SupervisorService {
	Supervisor addSupervisor(Supervisor supervisor);
	void deleteSupervisor(int supervisorId);
	List<Supervisor> getSupervisors();
	Supervisor getSupervisorBySupervisorId(int supervisorId);
	Supervisor updateSupervisor(Supervisor supervisor);
}

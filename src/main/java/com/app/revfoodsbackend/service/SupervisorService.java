package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Supervisor;

import java.util.List;

public interface SupervisorService {
    Supervisor addSupervisor(Supervisor supervisor);
    void deleteSupervisor(int supervisorId);
    List<Supervisor> getAllSupervisors();
    Supervisor getSupervisorBySupervisorId(int supervisorId);
    Supervisor updateSupervisor(Supervisor supervisor);
}

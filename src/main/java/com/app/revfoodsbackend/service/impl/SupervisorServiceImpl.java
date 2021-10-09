package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.Supervisor;
import com.app.revfoodsbackend.repository.SupervisorRepository;
import com.app.revfoodsbackend.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public Supervisor addSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public void deleteSupervisor(int supervisorId) {
        supervisorRepository.deleteById(supervisorId);
    }

    @Override
    public List<Supervisor> getAllSupervisors() {
        return supervisorRepository.findAll();
    }

    @Override
    public Supervisor updateSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    @Override
    public Supervisor getSupervisorByUsernameAndPassword(String supervisorUsername, String supervisorPassword) {
        return supervisorRepository.findSupervisorBySupervisorUsernameAndSupervisorPassword(supervisorUsername, supervisorPassword);
    }

    @Override
    public Supervisor getSupervisorBySupervisorId(int supervisorId) {
        return supervisorRepository.findById(supervisorId).get();
    }
}

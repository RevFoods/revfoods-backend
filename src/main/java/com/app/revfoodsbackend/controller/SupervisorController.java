package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Supervisor;
import com.app.revfoodsbackend.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @PostMapping("/supervisor")
    public Supervisor addSupervisor(@RequestBody Supervisor supervisor) {
        return supervisorService.addSupervisor(supervisor);
    }

    @GetMapping("/supervisors")
    public List<Supervisor> getSupervisors() {
        return supervisorService.getAllSupervisors();
    }


    @DeleteMapping("/supervisor/{supervisorId}")
    public void deleteSupervisor(@PathVariable int supervisorId) {
        supervisorService.deleteSupervisor(supervisorId);
    }

    @PutMapping("/supervisor")
    public Supervisor updateSupervisor(@RequestBody Supervisor supervisor) {
        return supervisorService.updateSupervisor(supervisor);
    }

    @GetMapping("/supervisor/{supervisorId}")
    public Supervisor getSupervisorById(@PathVariable int supervisorId) {
        return supervisorService.getSupervisorBySupervisorId(supervisorId);
    }

    @PostMapping("/supervisor/login")
    public Supervisor getSupervisorByUsernameAndPassword(@RequestBody Supervisor supervisor) {
        return  supervisorService.getSupervisorByUsernameAndPassword(supervisor.getSupervisorUsername(), supervisor.getSupervisorPassword());
    }
}

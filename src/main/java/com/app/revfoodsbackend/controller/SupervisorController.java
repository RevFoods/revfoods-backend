package com.app.revfoodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.revfoodsbackend.model.Supervisor;
import com.app.revfoodsbackend.service.SupervisorService;

@RestController
@CrossOrigin
public class SupervisorController {
	@Autowired
	private SupervisorService supervisorService;
	
	@PostMapping("/supervisor")
	public Supervisor addSupervisor(@RequestBody Supervisor supervisor)
	{
		return supervisorService.addSupervisor(supervisor);
	}
	
	@GetMapping("/supervisors")
	public List<Supervisor> getSupervisors(){
		return supervisorService.getSupervisors();
	}
	
	
	@DeleteMapping("/supervisor/{supervisorId}")
	public void deleteSupervisor(@PathVariable int supervisorId)
	{
		 supervisorService.deleteSupervisor(supervisorId);
	}
	
	@PutMapping("/supervisor")
	public Supervisor updateSupervisor(@RequestBody Supervisor supervisor)
	{
		return supervisorService.updateSupervisor(supervisor);
	}
	
	@GetMapping("/supervisor/{supervisorId}")
	public Supervisor getSupervisorById(@PathVariable int supervisorId)
	{
		return supervisorService.getSupervisorBySupervisorId(supervisorId);
	}
}
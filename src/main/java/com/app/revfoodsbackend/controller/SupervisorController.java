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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "Supervisor Operations")
@RestController
@CrossOrigin
public class SupervisorController {

	@Autowired
	private SupervisorService supervisorService;

	@ApiOperation(value = "To add a new supervisor")
	@PostMapping("/supervisor")
	public Supervisor addSupervisor(@RequestBody Supervisor supervisor) {
		return supervisorService.addSupervisor(supervisor);
	}

	@ApiOperation(value = "To get the list of all the supervisors")
	@GetMapping("/supervisors")
	public List<Supervisor> getSupervisors() {
		return supervisorService.getAllSupervisors();
	}

	@ApiOperation(value = "To delete the supervisor")
	@DeleteMapping("/supervisor/{supervisorId}")
	public void deleteSupervisor(@PathVariable int supervisorId) {
		supervisorService.deleteSupervisor(supervisorId);
	}

	@ApiOperation(value = "To update the supervisor")
	@PutMapping("/supervisor")
	public Supervisor updateSupervisor(@RequestBody Supervisor supervisor) {
		return supervisorService.updateSupervisor(supervisor);
	}

	@ApiOperation(value = "To get the supervisor by supervisor Id")
	@GetMapping("/supervisor/{supervisorId}")
	public Supervisor getSupervisorById(@PathVariable int supervisorId) {
		return supervisorService.getSupervisorBySupervisorId(supervisorId);
	}

	@ApiOperation(value = "For the supervisor login")
	@PostMapping("/supervisor/login")
	public Supervisor getSupervisorByUsernameAndPassword(@RequestBody Supervisor supervisor) {
		return supervisorService.getSupervisorByUsernameAndPassword(supervisor.getSupervisorUsername(),
				supervisor.getSupervisorPassword());
	}
}

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

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.service.HelpService;

@RestController
@CrossOrigin
public class HelpController {
	
	@Autowired
	private HelpService helpService;
	
	@PostMapping("/help")
	public Help addHelp(@RequestBody Help help) {
		
		return helpService.addHelp(help);
	}

	@PutMapping("/help")
	public Help updateHelp(@RequestBody Help help) {
		
		return helpService.updateHelp(help);
	}

	@GetMapping("/help/{helpId}")
	public Help getHelpById(@PathVariable int helpId) {
		
		return helpService.getHelpById(helpId);
	}

	@DeleteMapping("/help/{helpId}")
	public void deleteHelp(@PathVariable int helpId) {
		
		helpService.deleteHelp(helpId);
	}

	@GetMapping("/helps")
	public List<Help> getAllHelps() {
		
		return helpService.getAllHelps();
	}

}

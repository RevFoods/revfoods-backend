package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.service.HelpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Help Operations")
@RestController
@CrossOrigin
public class HelpController {

	@Autowired
	private HelpService helpService;

	@ApiOperation(value = "To add a help")
	@PostMapping("/help")
	public Help addHelp(@RequestBody Help help) {
		return helpService.addHelp(help);
	}

	@ApiOperation(value = "To update the help")
	@PutMapping("/help")
	public Help updateHelp(@RequestBody Help help) {
		return helpService.updateHelp(help);
	}

	@ApiOperation(value = "To get the help by help Id")
	@GetMapping("/help/{helpId}")
	public Help getHelpById(@PathVariable int helpId) {
		return helpService.getHelpById(helpId);
	}

	@ApiOperation(value = "To delete the help")
	@DeleteMapping("/help/{helpId}")
	public void deleteHelp(@PathVariable int helpId) {
		helpService.deleteHelp(helpId);
	}

	@ApiOperation(value = "To get the list of all the help")
	@GetMapping("/helps")
	public List<Help> getAllHelps() {
		return helpService.getAllHelps();
	}

	@ApiOperation(value = "To update the help status")
	@PutMapping("/help/{helpId}/helpStatus/{helpStatus}")
	public Help updateHelpStatus(@PathVariable int helpId, @PathVariable boolean helpStatus) {
		return helpService.updateHelpStatus(helpId, helpStatus);
	}
}

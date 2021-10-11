package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Chef;
import com.app.revfoodsbackend.service.ChefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Chef Operations")
@RestController
@CrossOrigin
public class ChefController {

	@Autowired
	private ChefService chefService;

	@ApiOperation(value = "To add a new chef")
	@PostMapping("/chef")
	public Chef addChef(@RequestBody Chef chef) {
		return chefService.addChef(chef);
	}

	@ApiOperation(value = "To update the chef information")
	@PutMapping("/chef")
	public Chef updateChef(@RequestBody Chef chef) {
		return chefService.updateChef(chef);
	}

	@ApiOperation(value = "To delete the chef")
	@DeleteMapping("/chef/{chefId}")
	public void deleteChef(@PathVariable int chefId) {
		chefService.deleteChef(chefId);
	}

	@ApiOperation(value = "To get all the chefs")
	@GetMapping("/chefs")
	public List<Chef> getAllChefs() {
		return chefService.getAllChefs();
	}

	@ApiOperation(value = "To get the chef by the id")
	@GetMapping("/chef/{chefId}")
	public Chef getChefById(@PathVariable int chefId) {
		return chefService.getChefById(chefId);
	}

	@ApiOperation(value = "For the chef login")
	@PostMapping("/chef/login")
	public Chef getChefByUsernameAndPassword(@RequestBody Chef chef) {
		return chefService.getChefByChefUsernameAndChefPassword(chef.getChefUsername(), chef.getChefPassword());
	}
}

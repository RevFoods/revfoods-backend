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

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.service.FoodService;




@RestController
@CrossOrigin
public class FoodController 
{
	@Autowired
	private FoodService service;

	@PostMapping("/Food")
	public Food addFood(@RequestBody Food food) {

		return service.addFood(food);
	}

	@PutMapping("/Food")
	public Food updateFood(@RequestBody Food food) {
		return service.updateFood(food);
	}

	@GetMapping("/Food")
	public List<Food> getAllFood() {
		return service.getAllFoods();
	}

	@GetMapping("/Food/{FoodId}")
	public Food getFoodById(@PathVariable int FoodId) {
		return service.getFoodByFoodId(FoodId);
	}

	@DeleteMapping("/Food/{FoodId}")
	public void deleteFood(@PathVariable int FoodId) {
		service.deleteFood(FoodId);
	}

}

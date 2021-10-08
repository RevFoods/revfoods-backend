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
	private FoodService foodService;

	@PostMapping("/food")
	public Food addFood(@RequestBody Food food) {
		return foodService.addFood(food);
	}

	@PutMapping("/food")
	public Food updateFood(@RequestBody Food food) {
		return foodService.updateFood(food);
	}

	@GetMapping("/food")
	public List<Food> getAllFoods() {
		return foodService.getAllFoods();
	}

	@GetMapping("/food/{foodId}")
	public Food getFoodById(@PathVariable int foodId) {
		return foodService.getFoodByFoodId(foodId);
	}

	@DeleteMapping("/food/{foodId}")
	public void deleteFood(@PathVariable int foodId) {
		foodService.deleteFood(foodId);
	}
}

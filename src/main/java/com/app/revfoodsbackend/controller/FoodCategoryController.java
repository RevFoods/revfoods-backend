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


import com.app.revfoodsbackend.model.FoodCategory;
import com.app.revfoodsbackend.service.FoodCategoryService;


@RestController
@CrossOrigin
public class FoodCategoryController {
	

	@Autowired
	private FoodCategoryService service;
	
	@GetMapping("/foodCategories")
	public List<FoodCategory> getAllFoodCategories() {
	
		return service.getAllFoodCategories();
	}
	
	@PostMapping("/foodCategory")
	public FoodCategory addFoodCategory(@RequestBody FoodCategory foodCategory) {
		
			return service.addFoodCategory(foodCategory);
	}
	
	@PutMapping("/foodCategory")
	public FoodCategory updateFoodCategory(@RequestBody FoodCategory foodCategory) {

		return service.updateFoodCategory(foodCategory);

	}
	
	@GetMapping("/foodCategory/{foodCategoryId}")
	public FoodCategory getFoodCategoryById(@PathVariable int foodCategoryId) {
			return service.getFoodCategoryById(foodCategoryId);	
		
	}

	@DeleteMapping("/foodCategory/{foodCategoryId}")
	public void deleteFoodCategory(@PathVariable int foodCategoryId) {

		service.deleteFoodCategory(foodCategoryId);
	}

	
	
}

package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.FoodCategory;
import com.app.revfoodsbackend.service.FoodCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Food category operations")
@RestController
@CrossOrigin
public class FoodCategoryController {

	@Autowired
	private FoodCategoryService foodCategoryService;

	@ApiOperation(value = "To get all the food categories")
	@GetMapping("/foodCategories")
	public List<FoodCategory> getAllFoodCategories() {
		return foodCategoryService.getAllFoodCategories();
	}

	@ApiOperation(value = "To add a new food category")
	@PostMapping("/foodCategory")
	public FoodCategory addFoodCategory(@RequestBody FoodCategory foodCategory) {
		return foodCategoryService.addFoodCategory(foodCategory);
	}

	@ApiOperation(value = "To update the food category")
	@PutMapping("/foodCategory")
	public FoodCategory updateFoodCategory(@RequestBody FoodCategory foodCategory) {
		return foodCategoryService.updateFoodCategory(foodCategory);
	}

	@ApiOperation(value = "To get the food category by the food category Id")
	@GetMapping("/foodCategory/{foodCategoryId}")
	public FoodCategory getFoodCategoryById(@PathVariable int foodCategoryId) {
		return foodCategoryService.getFoodCategoryById(foodCategoryId);
	}

	@ApiOperation(value = "To delete the food category")
	@DeleteMapping("/foodCategory/{foodCategoryId}")
	public void deleteFoodCategory(@PathVariable int foodCategoryId) {
		foodCategoryService.deleteFoodCategory(foodCategoryId);
	}
}

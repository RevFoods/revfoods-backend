package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.FoodCategory;

public interface FoodCategoryService {

	FoodCategory updateFoodCategory(FoodCategory foodCategory);
	FoodCategory getFoodCategoryById(int foodCategoryId);
	void deleteFoodCategory(int foodCategoryId);
	FoodCategory addFoodCategory(FoodCategory foodCategory);
	List<FoodCategory> getAllFoodCategories();
	
}

package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Food;



public interface FoodService 
{	
	Food addFood(Food food);
	Food updateFood(Food food);
	List<Food> getAllFoods();
	Food getFoodByFoodId(int FoodId);
	void deleteFood(int FoodId); 
}
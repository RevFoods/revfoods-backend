package com.app.revfoodsbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.repository.FoodRepository;
import com.app.revfoodsbackend.service.FoodService;



@Service
public class FoodServiceImpl implements FoodService
{
	@Autowired
	private FoodRepository repository;

	@Override
	public Food addFood(Food food) {
		return repository.save(food);
	}

	@Override
	public Food updateFood(Food food) {
		return repository.save(food);
	}

	@Override
	public List<Food> getAllFoods() {
		return repository.findAll();
	}

	@Override
	public Food getFoodByFoodId(int foodId) {
		return repository.findById(foodId).get();
	}

	@Override
	public void deleteFood(int foodId) {
		repository.deleteById(foodId);
		
	}
}
	
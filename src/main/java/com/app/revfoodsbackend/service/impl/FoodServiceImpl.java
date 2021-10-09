package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.repository.FoodRepository;
import com.app.revfoodsbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodByFoodId(int foodId) {
        return foodRepository.findById(foodId).get();
    }

    @Override
    public void deleteFood(int foodId) {
        foodRepository.deleteById(foodId);
    }
}
	

package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.FoodCategory;
import com.app.revfoodsbackend.repository.FoodCategoryRepository;
import com.app.revfoodsbackend.service.FoodCategoryService;
import com.app.revfoodsbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Override
    public List<FoodCategory> getAllFoodCategories() {
        return foodCategoryRepository.findAll();
    }

    @Override
    public FoodCategory updateFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }

    @Override
    public FoodCategory getFoodCategoryById(int foodCategoryId) {
        return foodCategoryRepository.findById(foodCategoryId).get();
    }

    @Override
    public void deleteFoodCategory(int foodCategoryId) {
        foodCategoryRepository.deleteById(foodCategoryId);
    }

    @Override
    public FoodCategory addFoodCategory(FoodCategory foodCategory) {
        return foodCategoryRepository.save(foodCategory);
    }
}

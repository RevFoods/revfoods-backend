package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.model.FoodCategory;

import java.util.List;

public interface FoodCategoryService {
    FoodCategory updateFoodCategory(FoodCategory foodCategory);
    FoodCategory getFoodCategoryById(int foodCategoryId);
    void deleteFoodCategory(int foodCategoryId);
    FoodCategory addFoodCategory(FoodCategory foodCategory);
    List<FoodCategory> getAllFoodCategories();
}

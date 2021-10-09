package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Food;
import com.app.revfoodsbackend.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FoodController {

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

    @GetMapping("/foods")
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

    @GetMapping("/foods/foodCategory/{foodCategoryId}")
    public List<Food> getFoodsByCategoryId(@PathVariable int foodCategoryId) {
        return foodService.getFoodsByCategoryId(foodCategoryId);
    }

    @GetMapping("/food/foodCategory/{foodCategoryId}")
    public Food addFoodToFoodCategory(@RequestBody Food food,@PathVariable int foodCategoryId) {
        return foodService.addFoodToFoodCategory(food, foodCategoryId);
    }

    @PutMapping("/food/{foodId}/foodStatus/{foodStatus}")
    public Food updateFoodStatus(@PathVariable int foodId,@PathVariable boolean foodStatus) {
        return foodService.updateFoodStatus(foodId, foodStatus);
    }
}

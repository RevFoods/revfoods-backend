package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.FoodOrder;

import java.util.List;

public interface FoodOrderService {
    FoodOrder addFoodOrder(FoodOrder foodOrder);
    FoodOrder updateFoodOrder(FoodOrder foodOrder);
    FoodOrder getFoodOrderById(int foodOrderId);
    void deleteFoodOrder(int foodOrderId);
    List<FoodOrder> getAllFoodOrders();
}

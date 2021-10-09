package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.FoodOrder;
import com.app.revfoodsbackend.repository.FoodOrderRepository;
import com.app.revfoodsbackend.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderServiceImpl implements FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Override
    public FoodOrder addFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    @Override
    public FoodOrder getFoodOrderById(int foodOrderId) {
        return foodOrderRepository.findById(foodOrderId).get();
    }

    @Override
    public void deleteFoodOrder(int foodOrderId) {
        foodOrderRepository.deleteById(foodOrderId);
    }

    @Override
    public List<FoodOrder> getAllFoodOrders() {
        return foodOrderRepository.findAll();
    }
}

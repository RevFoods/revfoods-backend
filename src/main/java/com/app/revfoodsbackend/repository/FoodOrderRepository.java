package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.revfoodsbackend.model.FoodOrder;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
    List<FoodOrder> findAllByOrderStatus(OrderStatus orderStatus);
    FoodOrder findFoodOrderByCart(Cart cart);
    boolean existsFoodOrderByCart(Cart cart);
}

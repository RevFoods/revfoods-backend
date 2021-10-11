package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.Cart;
import com.app.revfoodsbackend.model.Customer;
import com.app.revfoodsbackend.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findCartByFoodOrder(FoodOrder foodOrder);
    List<Cart> findCartsByCustomer(Customer customer);
}

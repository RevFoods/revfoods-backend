package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.Food;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
	List<Food> findAllByFoodCategory(FoodCategory foodCategory);
}
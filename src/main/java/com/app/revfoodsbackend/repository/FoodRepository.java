package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer>
{
	
}
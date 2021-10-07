package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.FoodCategory;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> { 

}

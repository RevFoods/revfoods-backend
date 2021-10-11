package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {

}

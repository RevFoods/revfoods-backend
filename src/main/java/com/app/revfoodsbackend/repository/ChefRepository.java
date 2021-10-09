package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {
    Chef findChefByChefUsernameAndChefPassword(String chefUsername, String chefPassword);
}

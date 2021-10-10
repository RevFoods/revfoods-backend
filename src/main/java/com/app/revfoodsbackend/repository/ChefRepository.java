package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {
    Chef findChefByChefUsernameAndChefPassword(String chefUsername, String chefPassword);
}

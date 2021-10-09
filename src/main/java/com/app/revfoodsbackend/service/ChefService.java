package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Chef;

import java.util.List;

public interface ChefService {
    Chef addChef(Chef chef);
    Chef updateChef(Chef chef);
    void deleteChef(int chefId);
    List<Chef> getAllChefs();
    Chef getChefById(int chefId);
    Chef getChefByChefUsernameAndChefPassword(String chefUsername, String chefPassword);
}

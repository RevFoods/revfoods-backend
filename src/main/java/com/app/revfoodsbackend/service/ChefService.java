package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Chef;

public interface ChefService {

	Chef addChef(Chef chef);

	Chef updateChef(Chef chef);

	void deleteChef(int chefId);

	List<Chef> getAllChefs();

	Chef getChefById(int chefId);

}

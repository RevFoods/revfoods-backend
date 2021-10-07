package com.app.revfoodsbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.Chef;
import com.app.revfoodsbackend.repository.ChefRepository;
import com.app.revfoodsbackend.service.ChefService;

@Service
public class ChefServiceImpl implements ChefService {

	@Autowired
	private ChefRepository chefRepository;

	@Override
	public Chef addChef(Chef chef) {

		return chefRepository.save(chef);
	}

	@Override
	public Chef updateChef(Chef chef) {

		return chefRepository.save(chef);
	}

	@Override
	public void deleteChef(int chefId) {

		chefRepository.deleteById(chefId);
	}

	@Override
	public List<Chef> getAllChefs() {

		return chefRepository.findAll();
	}

	@Override
	public Chef getChefById(int chefId) {

		return chefRepository.findById(chefId).get();
	}

}

package com.app.revfoodsbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.repository.HelpRepository;
import com.app.revfoodsbackend.service.HelpService;

@Service
public class HelpServiceImpl implements HelpService{

	@Autowired
	private HelpRepository helpRepository;
	
	@Override
	public Help addHelp(Help help) {
		return helpRepository.save(help);
	}

	@Override
	public Help updateHelp(Help help) {
		return helpRepository.save(help);
	}

	@Override
	public Help getHelpById(int helpId) {
		return helpRepository.findById(helpId).get();
	}

	@Override
	public void deleteHelp(int helpId) {
		helpRepository.deleteById(helpId);
		
	}

	@Override
	public List<Help> getAllHelps() {
		return helpRepository.findAll();
	}

}

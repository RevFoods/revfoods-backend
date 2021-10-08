package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.Help;

public interface HelpService {
	
	Help addHelp(Help help);
	Help updateHelp(Help help);
	Help getHelpById(int helpId);
	void deleteHelp(int helpId);
	List<Help> getAllHelps();

}

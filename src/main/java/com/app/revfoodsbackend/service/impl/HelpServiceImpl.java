package com.app.revfoodsbackend.service.impl;

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.repository.HelpRepository;
import com.app.revfoodsbackend.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpServiceImpl implements HelpService {

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

    @Override
    public Help updateHelpStatus(int helpId, boolean helpStatus) {
        Help help = helpRepository.getById(helpId);
        help.setHelpStatus(helpStatus);
        return helpRepository.save(help);
    }
}

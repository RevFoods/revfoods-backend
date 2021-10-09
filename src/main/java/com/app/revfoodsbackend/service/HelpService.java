package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.Help;

import java.util.List;

public interface HelpService {
    Help addHelp(Help help);
    Help updateHelp(Help help);
    Help getHelpById(int helpId);
    void deleteHelp(int helpId);
    List<Help> getAllHelps();
    Help updateHelpStatus(int helpId, boolean helpStatus);
}

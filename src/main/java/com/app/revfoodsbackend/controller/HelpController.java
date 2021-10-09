package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Help;
import com.app.revfoodsbackend.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HelpController {

    @Autowired
    private HelpService helpService;

    @PostMapping("/help")
    public Help addHelp(@RequestBody Help help) {
        return helpService.addHelp(help);
    }

    @PutMapping("/help")
    public Help updateHelp(@RequestBody Help help) {
        return helpService.updateHelp(help);
    }

    @GetMapping("/help/{helpId}")
    public Help getHelpById(@PathVariable int helpId) {
        return helpService.getHelpById(helpId);
    }

    @DeleteMapping("/help/{helpId}")
    public void deleteHelp(@PathVariable int helpId) {
        helpService.deleteHelp(helpId);
    }

    @GetMapping("/helps")
    public List<Help> getAllHelps() {
        return helpService.getAllHelps();
    }

    @PutMapping("/help/{helpId}/helpStatus/{helpStatus}")
    public Help updateHelpStatus(@PathVariable int helpId, @PathVariable boolean helpStatus) {
        return helpService.updateHelpStatus(helpId, helpStatus);
    }
}

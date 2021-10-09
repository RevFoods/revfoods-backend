package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.Chef;
import com.app.revfoodsbackend.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ChefController {

    @Autowired
    private ChefService chefService;

    @PostMapping("/chef")
    public Chef addChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @PutMapping("/chef")
    public Chef updateChef(@RequestBody Chef chef) {
        return chefService.updateChef(chef);
    }

    @DeleteMapping("/chef/{chefId}")
    public void deleteChef(@PathVariable int chefId) {
        chefService.deleteChef(chefId);
    }

    @GetMapping("/chefs")
    public List<Chef> getAllChefs() {
        return chefService.getAllChefs();
    }

    @GetMapping("/chef/{chefId}")
    public Chef getChefById(@PathVariable int chefId) {
        return chefService.getChefById(chefId);
    }

    @PostMapping("/chef/login")
    public Chef getChefByUsernameAndPassword(@RequestBody Chef chef) {
        return chefService.getChefByChefUsernameAndChefPassword(chef.getChefUsername(), chef.getChefPassword());
    }
}

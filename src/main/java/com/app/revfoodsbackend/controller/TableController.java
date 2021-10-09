package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.service.CustomerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TableController {

    @Autowired
    private CustomerTableService customerTableService;

    @PostMapping("/customerTable")
    public CustomerTable addTable(@RequestBody CustomerTable customerTable) {
        return customerTableService.addCustomerTable(customerTable);
    }

    @PutMapping("/customerTable")
    public CustomerTable updateTable(@RequestBody CustomerTable customerTable) {

        return customerTableService.updateCustomerTable(customerTable);
    }

    @DeleteMapping("/customerTable/{customerTableId}")
    public void deleteTable(@PathVariable int customerTableId) {
        customerTableService.deleteCustomerTable(customerTableId);
    }

    @GetMapping("/customerTable/{customerTableId}")
    public CustomerTable getTableById(@PathVariable int customerTableId) {
        return customerTableService.getCustomerTableById(customerTableId);
    }

    @GetMapping("/customerTables")
    public List<CustomerTable> getAllTables() {
        return customerTableService.getAllCustomerTables();
    }
}

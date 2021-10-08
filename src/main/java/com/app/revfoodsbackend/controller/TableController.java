package com.app.revfoodsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.service.CustomerTableService;

@RestController
@CrossOrigin
public class TableController {
	
	@Autowired
	private CustomerTableService customerTableService;
	
	@PostMapping("/customerTable")
	public CustomerTable addTable(@RequestBody CustomerTable customerTable)
	{
		return customerTableService.addCustomerTable(customerTable);
	}
	
	@PutMapping("/customerTable")
	public CustomerTable updateTable(@RequestBody CustomerTable customerTable) {
		
		return customerTableService.updateCustomerTable(customerTable);
	}
	
	
	@DeleteMapping("/customerTable/{customerTableId}")
	public void deleteTable(@PathVariable int customerTableId)
	{
		customerTableService.deleteCustomerTable(customerTableId);
	}
	
	@GetMapping("/customerTable/{customerTableId}")
	public CustomerTable getTableById(@PathVariable int customerTableId)
	{
		return customerTableService.getCustomerTableById(customerTableId);
		
	}
	@GetMapping("/customerTables")
	public List<CustomerTable> getAllTables(){
		return customerTableService.getAllCustomerTables();
	}

}

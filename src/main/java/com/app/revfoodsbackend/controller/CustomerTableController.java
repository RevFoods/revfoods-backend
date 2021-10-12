package com.app.revfoodsbackend.controller;

import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.service.CustomerTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "Customer Table Operations")
@RestController
@CrossOrigin
public class CustomerTableController {

	@Autowired
	private CustomerTableService customerTableService;

	@ApiOperation(value = "To add a new table")
	@PostMapping("/customerTable")
	public CustomerTable addCustomerTable(@RequestBody CustomerTable customerTable) {
		return customerTableService.addCustomerTable(customerTable);
	}

	@ApiOperation(value = "To update the table")
	@PutMapping("/customerTable")
	public CustomerTable updateCustomerTable(@RequestBody CustomerTable customerTable) {
		return customerTableService.updateCustomerTable(customerTable);
	}

	@ApiOperation(value = "To delete the table")
	@DeleteMapping("/customerTable/{customerTableId}")
	public void deleteCustomerTable(@PathVariable int customerTableId) {
		customerTableService.deleteCustomerTable(customerTableId);
	}

	@ApiOperation(value = "To get table by the Table Id")
	@GetMapping("/customerTable/{customerTableId}")
	public CustomerTable getCustomerTableById(@PathVariable int customerTableId) {
		return customerTableService.getCustomerTableById(customerTableId);
	}

	@ApiOperation(value = "To get all  the tables")
	@GetMapping("/customerTables")
	public List<CustomerTable> getAllCustomerTables() {
		return customerTableService.getAllCustomerTables();
	}

	@ApiOperation(value = "To get the tables by table status")
	@GetMapping("/customerTables/customerTableStatus/{customerTableStatus}")
	public List<CustomerTable> getAllCustomerTablesByCustomerTableStatus(@PathVariable boolean customerTableStatus) {
		return customerTableService.getAllCustomerTablesByCustomerTableStatus(customerTableStatus);
	}
}

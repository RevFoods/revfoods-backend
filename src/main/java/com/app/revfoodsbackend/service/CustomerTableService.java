package com.app.revfoodsbackend.service;

import java.util.List;

import com.app.revfoodsbackend.model.CustomerTable;

public interface CustomerTableService {
	CustomerTable addCustomerTable(CustomerTable customerTable);
	CustomerTable updateCustomerTable(CustomerTable customerTable);
	CustomerTable getCustomerTableById(int customerTableId);
	void deleteCustomerTable(int customerTableId);
	List<CustomerTable> getAllCustomerTables();
	}

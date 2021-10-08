package com.app.revfoodsbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.revfoodsbackend.model.CustomerTable;
import com.app.revfoodsbackend.repository.CustomerTableRepository;
import com.app.revfoodsbackend.service.CustomerTableService;

@Service
public class CustomerTableServiceImpl implements CustomerTableService {
	
	@Autowired
	private CustomerTableRepository customerTableRepository;

	@Override
	public CustomerTable addCustomerTable(CustomerTable customerTable) {
		
		return customerTableRepository.save(customerTable);
	}

	@Override
	public CustomerTable updateCustomerTable(CustomerTable customerTable) {
		
		return customerTableRepository.save(customerTable);
	}

	@Override
	public CustomerTable getCustomerTableById(int customerTableId) {
	
		return customerTableRepository.findById(customerTableId).get();
	}

	@Override
	public void deleteCustomerTable(int customerTableId) {
		
	       customerTableRepository.deleteById(customerTableId);
	}

	@Override
	public List<CustomerTable> getAllCustomerTables() {

		return customerTableRepository.findAll();
	}  

	
	
	
	
}

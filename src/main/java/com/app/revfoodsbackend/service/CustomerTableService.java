package com.app.revfoodsbackend.service;

import com.app.revfoodsbackend.model.CustomerTable;

import java.util.List;

public interface CustomerTableService {
    CustomerTable addCustomerTable(CustomerTable customerTable);
    CustomerTable updateCustomerTable(CustomerTable customerTable);
    CustomerTable getCustomerTableById(int customerTableId);
    void deleteCustomerTable(int customerTableId);
    List<CustomerTable> getAllCustomerTables();
}

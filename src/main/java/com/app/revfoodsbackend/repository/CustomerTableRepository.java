package com.app.revfoodsbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.CustomerTable;

import java.util.List;

@Repository
public interface CustomerTableRepository extends JpaRepository<CustomerTable, Integer> {
    List<CustomerTable> findAllByCustomerTableStatus(boolean customerTableStatus);
}



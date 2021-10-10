package com.app.revfoodsbackend.repository;


import com.app.revfoodsbackend.model.CustomerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerTableRepository extends JpaRepository<CustomerTable, Integer> {
    List<CustomerTable> findAllByCustomerTableStatus(boolean customerTableStatus);
}



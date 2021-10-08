package com.app.revfoodsbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.CustomerTable;

@Repository
public interface CustomerTableRepository extends JpaRepository<CustomerTable, Integer> {
	

}



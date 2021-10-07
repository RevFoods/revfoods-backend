package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.OrderStatus;
@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
	
	

}

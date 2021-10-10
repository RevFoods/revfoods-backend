package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
	
	

}

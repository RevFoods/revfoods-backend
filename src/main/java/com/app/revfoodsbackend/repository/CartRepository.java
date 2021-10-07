package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}

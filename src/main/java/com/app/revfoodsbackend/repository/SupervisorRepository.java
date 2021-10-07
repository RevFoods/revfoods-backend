package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.revfoodsbackend.model.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
	
} 
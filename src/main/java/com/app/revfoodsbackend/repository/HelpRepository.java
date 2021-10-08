package com.app.revfoodsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.revfoodsbackend.model.Help;

@Repository
public interface HelpRepository extends JpaRepository<Help,Integer>{

}

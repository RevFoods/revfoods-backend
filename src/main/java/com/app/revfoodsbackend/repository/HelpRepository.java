package com.app.revfoodsbackend.repository;

import com.app.revfoodsbackend.model.Help;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends JpaRepository<Help,Integer>{

}

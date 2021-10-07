package com.app.revfoodsbackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
@Entity
@Table
public class FoodCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodCategoryId;
	
	private String foodCategoryName;
	
	@OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
	private List<Food> foodList;


}

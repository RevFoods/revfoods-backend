package com.app.revfoodsbackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Food 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int foodId;
	private double foodPrice;
	private String foodName;
	private String foodAvatar;
    private int foodPrepTime;
	private String foodType;	
	private String foodStatus;
	
    @JsonIgnore
	@ManyToOne
	@JoinColumn("foodCategoryId")
	FoodCategory foodCategory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
	List<Cart> cartList;

}

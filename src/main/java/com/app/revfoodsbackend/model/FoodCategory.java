package com.app.revfoodsbackend.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class FoodCategory {
	@ApiModelProperty(value = "This is the auto generated food category Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodCategoryId;
	@ApiModelProperty(value = "This is for name of food category name")
	private String foodCategoryName;

	@OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Food> foodList;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		FoodCategory that = (FoodCategory) o;
		return Objects.equals(foodCategoryId, that.foodCategoryId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

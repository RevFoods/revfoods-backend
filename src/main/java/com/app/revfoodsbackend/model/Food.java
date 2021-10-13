package com.app.revfoodsbackend.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
@AllArgsConstructor
@ToString
public class Food {
	@ApiModelProperty(value = "This is the auto generated food Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	@ApiModelProperty(value = "This is for price of food")
	private double foodPrice;
	@ApiModelProperty(value = "This is for name of food")
	private String foodName;

	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	@ApiModelProperty(value = "This is for image of food")
	private String foodAvatar;
	@ApiModelProperty(value = "This is for preparation time of food")
	private int foodPrepTime;
	@ApiModelProperty(value = "This is for type of food")
	private String foodType;
	@ApiModelProperty(value = "This is for status of food")
	private boolean foodStatus;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "foodCategoryId", referencedColumnName = "foodCategoryId")
	private FoodCategory foodCategory;

	@OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Cart> cartList;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Food food = (Food) o;
		return Objects.equals(foodId, food.foodId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

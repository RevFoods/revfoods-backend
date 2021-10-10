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
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Chef {
	@ApiModelProperty(value = "This is the auto generated chefId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chefId;
	@ApiModelProperty(value = "This is for name of chef")
	private String chefName;
	@ApiModelProperty(value = "This is for username of chef")
	private String chefUsername;
	@ApiModelProperty(value = "This is for password of chef")
	private String chefPassword;

	@OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<FoodOrder> foodOrderList;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Chef chef = (Chef) o;
		return Objects.equals(chefId, chef.chefId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

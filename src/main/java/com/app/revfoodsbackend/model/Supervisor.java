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
@RequiredArgsConstructor
@Entity
@Table
@AllArgsConstructor
@ToString
public class Supervisor {
	@ApiModelProperty(value = "This is the auto generated supervisor Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supervisorId;
	@ApiModelProperty(value = "This is for username of supervisor")
	private String supervisorUsername;
	@ApiModelProperty(value = "This is for password of supervisor")
	private String supervisorPassword;

	@OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<FoodOrder> foodOrderList;

	@OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Help> helpList;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Supervisor that = (Supervisor) o;
		return Objects.equals(supervisorId, that.supervisorId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
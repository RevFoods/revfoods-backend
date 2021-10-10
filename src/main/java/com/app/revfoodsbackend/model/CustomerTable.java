package com.app.revfoodsbackend.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CustomerTable {
	@ApiModelProperty(value = "This is the auto generated customer table Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerTableId;
	@ApiModelProperty(value = "This is for customer table number")
	private int customerTableNumber;
	@ApiModelProperty(value = "This is for customer table status")
	private boolean customerTableStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		CustomerTable that = (CustomerTable) o;
		return Objects.equals(customerTableId, that.customerTableId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

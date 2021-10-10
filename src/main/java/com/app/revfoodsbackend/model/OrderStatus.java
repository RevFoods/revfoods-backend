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
public class OrderStatus {
	@ApiModelProperty(value = "This is the auto generated order Status Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderStatusId;
	@ApiModelProperty(value = "This is for order status")
	private String orderStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		OrderStatus that = (OrderStatus) o;
		return Objects.equals(orderStatusId, that.orderStatusId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

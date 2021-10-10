package com.app.revfoodsbackend.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
@Setter
@ToString
public class Cart {

	@ApiModelProperty(value = "This is the auto generated cartId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@ApiModelProperty(value = "This is for quantity of cart")
	private int cartQuantity;

	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;

	@OneToOne(mappedBy = "cart")
	private FoodOrder foodOrder;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Cart cart = (Cart) o;
		return Objects.equals(cartId, cart.cartId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

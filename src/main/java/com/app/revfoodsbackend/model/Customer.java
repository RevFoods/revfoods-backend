package com.app.revfoodsbackend.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Customer {
	@ApiModelProperty(value = "This is the auto generated customerId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@ApiModelProperty(value = "This is for name of customer")
	private String customerName;
	@ApiModelProperty(value = "This is for email of customer")
	private String customerEmail;
	@ApiModelProperty(value = "This is for phone number of customer")
	private long customerPhone;

	@OneToOne
	@JoinColumn(name = "customerTableId", referencedColumnName = "customerTableId")
	private CustomerTable customerTable;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Cart> cartList;

	@OneToOne
	@JoinColumn(name = "feedbackId", referencedColumnName = "feedbackId")
	private Feedback feedback;

	@OneToOne
	@JoinColumn(name = "helpId", referencedColumnName = "helpId")
	private Help help;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Customer customer = (Customer) o;
		return Objects.equals(customerId, customer.customerId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

package com.app.revfoodsbackend.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table
@Entity
@AllArgsConstructor
@ToString
public class Feedback {
	@ApiModelProperty(value = "This is the auto generated feedbackId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	@ApiModelProperty(value = "This is for customer's feeedback")
	private String feedback;
	@ApiModelProperty(value = "This is for rating of the hygiene")
	private int hygiene;
	@ApiModelProperty(value = "This is for rating of service")
	private int service;
	@ApiModelProperty(value = "This is for rating of ambience")
	private int ambience;

	@OneToOne(mappedBy = "feedback", cascade = CascadeType.ALL)
	private Customer customer;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Feedback feedback = (Feedback) o;
		return Objects.equals(feedbackId, feedback.feedbackId);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}

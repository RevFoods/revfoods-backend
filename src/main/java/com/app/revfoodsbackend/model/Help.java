package com.app.revfoodsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@javax.persistence.Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Help {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int helpId;

	private String help;

	@OneToOne
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	Customer customer;

	@ManyToOne
	@JoinColumn(name = "supervisorId", referencedColumnName = "supervisorId")
	Supervisor supervisor;
}

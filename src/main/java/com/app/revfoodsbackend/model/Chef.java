package com.app.revfoodsbackend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Chef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chefId;

	private String chefName;

	private String chefUsername;
	private String chefPassword;

	@OneToMany(mappedBy = "chef")
	List<Order> orderList;
}

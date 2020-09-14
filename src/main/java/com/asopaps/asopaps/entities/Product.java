package com.asopaps.asopaps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contador_id_product")
	private Long id_product;

	@NotNull
	private String name_product;

	@NotNull
	private String product_image;

	@ManyToOne
	private Association association;
	

	/********* GETTERS Y SETTERS *******/

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public String getName_product() {
		return name_product;
	}

	public void setName_product(String name_product) {
		this.name_product = name_product;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

}

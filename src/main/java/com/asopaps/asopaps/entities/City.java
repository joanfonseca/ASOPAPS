package com.asopaps.asopaps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contador_id_city")
	private Long id_city;

	@NotNull
	private String name_city;

	@NotNull
	private String postal_code;
	
	/********* GETTERS Y SETTERS *******/

	public Long getId_city() {
		return id_city;
	}

	public void setId_city(Long id_city) {
		this.id_city = id_city;
	}

	public String getName_city() {
		return name_city;
	}

	public void setName_city(String name_city) {
		this.name_city = name_city;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
}

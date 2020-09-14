package com.asopaps.asopaps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contador_id_address")
	private Long id_address;

	@NotNull
	private String address_description;

	@NotNull
	@OneToOne
	private City city;

	/********* GETTERS Y SETTERS *******/
	
	public Long getId_address() {
		return id_address;
	}

	public void setId_address(Long id_address) {
		this.id_address = id_address;
	}

	public String getAddress_description() {
		return address_description;
	}

	public void setAddress_description(String address_description) {
		this.address_description = address_description;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
		
	
}

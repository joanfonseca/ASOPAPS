package com.asopaps.asopaps.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Association {

	@Id
	private Long id_association;

	@NotNull
	private String name_association;

	@NotNull
	private String email_admin;

	@NotNull
	private String password_admin;

	private String image_profile_association;

	@NotNull
	@OneToOne
	private Address address;

	/********* GETTERS Y SETTERS *******/
	
	
	public Long getId_association() {
		return id_association;
	}

	public void setId_association(Long id_association) {
		this.id_association = id_association;
	}

	public String getName_association() {
		return name_association;
	}

	public void setName_association(String name_association) {
		this.name_association = name_association;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	public String getPassword_admin() {
		return password_admin;
	}

	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}

	public String getImage_profile_association() {
		return image_profile_association;
	}

	public void setImage_profile_association(String image_profile_association) {
		this.image_profile_association = image_profile_association;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

package com.asopaps.asopaps.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Member {
	
	
	@Id
	private Long cedula_member;
	
	@NotNull
	private String  first_name;
	
	private String  second_name;
	
	@NotNull
	private String  first_last_name;
	
	private String  second_last_name;
	
	@NotNull
	private String email_member;
	@NotNull
	private String password_member;
	
	private String image_profile_member;
	
	@NotNull
	private Character gender;
	
	@NotNull
	private boolean is_active_user;
	
	@NotNull
	private Long phone_number;
	
	@NotNull
	private Date dateOfBirth;
	
	@NotNull
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private Address address;

	@ManyToOne
	private Association association;

	public Long getCedula_member() {
		return cedula_member;
	}

	public void setCedula_member(Long cedula_member) {
		this.cedula_member = cedula_member;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getFirst_last_name() {
		return first_last_name;
	}

	public void setFirst_last_name(String first_last_name) {
		this.first_last_name = first_last_name;
	}

	public String getSecond_last_name() {
		return second_last_name;
	}

	public void setSecond_last_name(String second_last_name) {
		this.second_last_name = second_last_name;
	}

	public String getEmail_member() {
		return email_member;
	}

	public void setEmail_member(String email_member) {
		this.email_member = email_member;
	}

	public String getPassword_member() {
		return password_member;
	}

	public void setPassword_member(String password_member) {
		this.password_member = password_member;
	}

	public String getImage_profile_member() {
		return image_profile_member;
	}

	public void setImage_profile_member(String image_profile_member) {
		this.image_profile_member = image_profile_member;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public boolean isIs_active_user() {
		return is_active_user;
	}

	public void setIs_active_user(boolean is_active_user) {
		this.is_active_user = is_active_user;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}
	

	
}

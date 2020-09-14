package com.asopaps.asopaps.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

import com.duseni.duseni.entitiesPK.ContributionPK;

@Entity
@IdClass(value = ContributionPK.class)
public class Contribution {

	@Id
	private long id_member;

	@Id
	private long id_request;

	@NotNull
	private int quantity;

	@NotNull
	private Date create_contribution_date;

	/********* GETTERS Y SETTERS *******/

	public long getId_member() {
		return id_member;
	}

	public void setId_member(long id_member) {
		this.id_member = id_member;
	}

	public long getId_request() {
		return id_request;
	}

	public void setId_request(long id_request) {
		this.id_request = id_request;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreate_contribution_date() {
		return create_contribution_date;
	}

	public void setCreate_contribution_date(Date create_contribution_date) {
		this.create_contribution_date = create_contribution_date;
	}
}

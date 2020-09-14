package com.asopaps.asopaps.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Comentary {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "contador_id_comentario")
	private Long id_comentary;
	
	
	@NotNull
	private String details_comentary;
	
	@NotNull
	@ManyToOne
	private Member member;

	public Long getId_comentary() {
		return id_comentary;
	}

	public void setId_comentary(Long id_comentary) {
		this.id_comentary = id_comentary;
	}

	public String getDetails_comentary() {
		return details_comentary;
	}

	public void setDetails_comentary(String details_comentary) {
		this.details_comentary = details_comentary;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	

}

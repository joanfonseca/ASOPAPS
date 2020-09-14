package com.asopaps.asopaps.services;

import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duseni.duseni.entities.Member;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.MemberRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class MemberServices {

	@Autowired
	private  MemberRepository	memberRepository;

	// ****** CRUD MIEMBROS *******//
	
	/*
	 * AGREGA UN NUEVO MIEMBRO
	 */
	@PostMapping (value = "/addMember")
	public String addMember(@Valid @RequestBody Member member) {
		System.out.println(member.getFirst_last_name());
		return JsonManager.toJson(memberRepository.save(member));
	}
	
	/*
	 * BUSCAR MIEMBRO POR ID
	 */	
	@GetMapping(value = "/member/{id}")
	public String getMember(@PathVariable Long id) {
		Optional<Member> m =  memberRepository.findById(id);
		return JsonManager.toJson(m.get());
	}
	
	/*
	 * EDITA UN MIEMBRO
	 */
	@PutMapping(value = "/editMember")
	public String editMember(@Valid @RequestBody Member member) {
		return JsonManager.toJson(memberRepository.save(member));
	}
	
	/*
	 * ELIMINA UN MIEMBRO POR ID
	 */
	@DeleteMapping(value = "/removeMember/{id}")
	public void removeMember( @PathVariable Long id) {
		memberRepository.deleteById(id);
	}
	

	// ****** CONSULTAS DIFERENTES *******//

	/*
	 * OBTIENE TODOS LOS MIEMBROS
	 */	
	@GetMapping(value = "/allMembers")
	public String getAllMembers() {
		return JsonManager.toJson(memberRepository.findAll());
	}
	
}

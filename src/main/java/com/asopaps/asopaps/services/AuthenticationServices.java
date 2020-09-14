package com.asopaps.asopaps.services;

import java.util.Collection;
import java.util.Optional;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.duseni.duseni.entities.Association;
import com.duseni.duseni.entities.Member;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.AssociationRepository;
import com.duseni.duseni.repository.MemberRepository;


@CrossOrigin (origins = { "http://localhost:4200", "http://localhost:8100", "http://localhost:8200"  })
@RestController
public class AuthenticationServices {
	
	
	@Autowired
	private  MemberRepository	memberRepository;
	@Autowired
	private AssociationRepository associationRepository;
	
//	@GetMapping(value = "/authenticationMember/{email}/{password}")
//	public ResponseEntity<Collection<Member>> authenticateForumUser(@PathVariable String email,	@PathVariable String password) {
//		Optional<Member> member = memberRepository.authentication(email, password);
//		return ResponseEntity.ok().body(member);
//	}
	
	/*
	 * AUTENTICA AL ADMIN  
	 */
	@GetMapping(value = "/authenticationAdmin/{email}/{password}")
	public String  authenticationAdmin(@PathVariable String email,	@PathVariable String password) {
		Optional<Association> association = associationRepository.authenticationAdmin(email, password);
		return JsonManager.toJson(association.get());
	}
	
	@PutMapping(value = "/cambiarClave/{cedula}/{nuevaClave}")
	public @ResponseBody String cambiarClave(@PathVariable long cedula, @PathVariable String nuevaClave) {
		Optional<Member> member = memberRepository.getMember(cedula);
		Member m = member.get();
		m.setPassword_member(nuevaClave);
		System.out.println(m.getPassword_member());
		memberRepository.save(m);
	//	memberRepository.cambiarClave(cedula, nuevaClave);
		return "Updated";

	}

	/*
	 * AUTENTICA AL MIEMBRO
	 */
	@GetMapping(value = "/authenticationMember/{email}/{password}")
	public String authenticateMember(@PathVariable String email,	@PathVariable String password) {
		Optional<Member> member = memberRepository.authenticationMember(email, password);
		return JsonManager.toJson(member.get());
	}
	



}

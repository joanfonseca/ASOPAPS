package com.asopaps.asopaps.services;


import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.duseni.duseni.entities.Address;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.AddressRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class AddressServices {
	@Autowired
	private AddressRepository addressRepository;

	// ****** CRUD ADDRESS *******//

	/*
	 * AGREGA UNA NUEVO DIRECCION
	 */
	@PostMapping(value = "/addAddress")
	public String addAddress(@Valid @RequestBody Address address) {
		return JsonManager.toJson(addressRepository.save(address));
	}

	/*
	 * BUSCAR ADDRESS POR ID
	 */
	@GetMapping(value = "/address/{id}")
	public String getAddress(@PathVariable Long id) {
		Optional<Address> a = addressRepository.findById(id);
		return JsonManager.toJson(a.get());
	}
//
//	/*
//	 * EDITA UN MIEMBRO
//	 */
//	@PutMapping(value = "/editMember")
//	public String editMember(@Valid @RequestBody Member member) {
//		return JsonManager.toJson(memberRepository.save(member));
//	}
//
//	/*
//	 * ELIMINA UN MIEMBRO POR ID
//	 */
//	@DeleteMapping(value = "/removeMember/{id}")
//	public void removeMember(@PathVariable Long id) {
//		memberRepository.deleteById(id);
//	}

	// ****** CONSULTAS DIFERENTES *******//

	/*
	 * OBTIENE TODOS LAS DIRECCIONES
	 */
	@GetMapping(value = "/allAddresses")
	public String getallAddresses() {
		return JsonManager.toJson(addressRepository.findAll());
	}

}

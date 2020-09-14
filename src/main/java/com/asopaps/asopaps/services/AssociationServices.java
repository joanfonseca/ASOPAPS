package com.asopaps.asopaps.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.duseni.duseni.entities.Association;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.AssociationRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class AssociationServices {
	@Autowired
	private AssociationRepository associationRepository;

	// ****** CRUD ASOCIACION *******//

	/*
	 * AGREGA UNA NUEVA ASOCIACION
	 */
	@PostMapping(value = "/addAssociation")
	public String addAssociation(@Valid @RequestBody Association association) {
		return JsonManager.toJson(associationRepository.save(association));
	}

	/*
	 * BUSCAR ASOCIACION POR ID
	 */
	@GetMapping(value = "/association/{id}")
	public String getAssociation(@PathVariable Long id) {
		Optional<Association> m = associationRepository.findById(id);
		return JsonManager.toJson(m.get());
	}

	/*
	 * EDITA UNA ASOCIACION
	 */
	@PutMapping(value = "/editAssociation")
	public String editAssociation(@Valid @RequestBody Association member) {
		return JsonManager.toJson(associationRepository.save(member));
	}

	/*
	 * ELIMINA UNA ASOCIACION MIEMBRO POR ID
	 */
	@DeleteMapping(value = "/removeAssociation/{id}")
	public void removeAssociation(@PathVariable Long id) {
		associationRepository.deleteById(id);
	}

	// ****** CONSULTAS DIFERENTES *******//

	/*
	 * OBTIENE TODAS LAS ASOCIACIONES
	 */
	
	@GetMapping(value = "/allAssociations")
	public String getAllAssociations() {
		return JsonManager.toJson(associationRepository.findAll());
	}

}

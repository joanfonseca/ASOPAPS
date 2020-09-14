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

import com.duseni.duseni.entities.Contribution;
import com.duseni.duseni.entities.Member;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.ContributionRepository;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8100", "http://localhost:8200" })
@RestController
public class ContributionServices {
	@Autowired
	private ContributionRepository contributionRepository;

	// ****** CRUD MIEMBROS *******//

	/*
	 * AGREGA UN NUEVO MIEBRO [INCOMPLETOO]
	 */
	@PostMapping(value = "/addContribution")
	public String addContribution(@Valid @RequestBody Contribution contribution) {
		return JsonManager.toJson(contributionRepository.save(contribution));
	}

	
	@GetMapping(value = "/contribucion/{idMember}/{idPedido}")
	public String getContribucion(@PathVariable Long idMember,@PathVariable Long idPedido)  {
		try {
			Optional<Contribution> contribucion =  contributionRepository.findByCompositeId(idMember,idPedido);
			return JsonManager.toJson(contribucion.get());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("    ----- Error");
		}
		
		return "null";
	
		
	}
	
	
	/*
	 * ELIMINA UN Contribution POR ID
	 */
	@DeleteMapping(value = "/removeContribution/{idMember}/{idPedido}")
	public void removeContibution(@PathVariable Long idMember, @PathVariable Long idPedido) {
		contributionRepository.delete(idMember,idPedido);
	}
	
	

}

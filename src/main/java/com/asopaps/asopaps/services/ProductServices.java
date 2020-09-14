package com.asopaps.asopaps.services;

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

import com.duseni.duseni.entities.Product;
import com.duseni.duseni.persistence.JsonManager;
import com.duseni.duseni.repository.ProductRepository;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class ProductServices {
	@Autowired
	private ProductRepository productRepository;

	// ****** CRUD PRODUCTOS *******//

	/*
	 * CREA UN NUEVO PRODUCTO
	 */

	@PostMapping(value = "/addProduct")
	public String addProduct(@Valid @RequestBody Product product) {
		return JsonManager.toJson(productRepository.save(product));
	}

	/*
	 * BUSCA UN PRODUCTO POR ID
	 */
	@GetMapping(value = "/product/{id}")
	public String getProduct(@PathVariable Long id) {
		return JsonManager.toJson(productRepository.findById(id));
	}

	/*
	 * ELIMINA UN PRODUCTO POR ID
	 */
	@DeleteMapping(value = "/removeProduct/{id}")
	public void removeProduct(@PathVariable Long id) {
		productRepository.deleteById(id);
	}

	/*
	 * EDITA UN PRODUCTO
	 */

	@PutMapping(value = "/editProduct")
	public String editProduct(@Valid @RequestBody Product product) {
		return JsonManager.toJson(productRepository.save(product));
	}

	// ****** CONSULTAS DIFERENTES *******//

	/*
	 * OBTIENE TODOS LOS PRODUCTOS
	 */
	@GetMapping(value = "/allProducts")
	public String getallProducts() {
		return JsonManager.toJson(productRepository.findAll());
	}
}

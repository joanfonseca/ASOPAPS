package com.duseni.duseni.repository;

import org.springframework.data.repository.CrudRepository;

import com.duseni.duseni.entities.Product;


public interface  ProductRepository extends CrudRepository<Product, Long> {
	
	// insert into  duseni.product values (1,"nil","nil")
	
}

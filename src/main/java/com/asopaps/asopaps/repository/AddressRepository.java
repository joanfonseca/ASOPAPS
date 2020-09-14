package com.duseni.duseni.repository;

import org.springframework.data.repository.CrudRepository;

import com.duseni.duseni.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}

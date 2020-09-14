package com.duseni.duseni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.duseni.duseni.entities.Association;

public interface AssociationRepository extends CrudRepository<Association, Long> {

	@Query(value = "SELECT * FROM duseni.association a where a.email_admin=(:email) and a.password_admin = (:password)", nativeQuery = true)
	Optional<Association> authenticationAdmin(String  email, String password);

}

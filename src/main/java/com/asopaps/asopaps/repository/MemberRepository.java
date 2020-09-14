package com.duseni.duseni.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.duseni.duseni.entities.Member;

public interface MemberRepository extends CrudRepository<Member, Long> {
	
	@Query(value = "SELECT * FROM duseni.member m where m.email_member=(:email) and m.password_member = (:password)", nativeQuery = true)
	Optional<Member> authenticationMember(String  email, String password);
	
	
	@Query(value = "UPDATE duseni.member SET duseni.member.password_member = (:nuevaClave) where duseni.member.cedula_member = (:cedula)", nativeQuery = true)
	void  cambiarClave(Long cedula, String nuevaClave);
	
	@Query(value = "SELECT * FROM duseni.member  where duseni.member.cedula_member =(:cedula)", nativeQuery = true)
	Optional<Member> getMember(Long  cedula);
	
	
}

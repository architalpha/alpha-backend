package com.alpha.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.entity.AvxUser;

@Repository
public interface AvxUserRepository extends JpaRepository<AvxUser, Long> {

	@Query(value = "select SUM(u.amount) from AvxUser u where u.email= ?1")
	Long avxUserDetailsByEmail(String email);
	
}
package com.alpha.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.entity.AvxUserStaking;

@Repository
public interface AvxUserStakingRepository extends JpaRepository<AvxUserStaking, Long> {

	@Query(value = "select SUM(u.stakingAmount) from AvxUserStaking u where u.email= ?1")
	Long avxUserStakingDetailsByEmail(String email);
	
}
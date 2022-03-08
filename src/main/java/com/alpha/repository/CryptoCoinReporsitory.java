package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alpha.entity.CryptoCoins;

@Transactional
public interface CryptoCoinReporsitory extends JpaRepository<CryptoCoins, String> {

	@Query("select cd from CryptoCoins cd where cd.id LIKE '%:search%'")
	List<CryptoCoins> findCoin(@Param("search") String search);

	List<CryptoCoins> findByIdContainingIgnoreCase(String search);
	
	
//	@Query("select cd from CreditDetails cd where cd.applicationId=:applicationId and cd.directorId is null and cd.isActive = true")
//	List<CreditDetails> findByApplicationIdCoAppIdIsNullAndIsActive(@Param("applicationId") Long applicationId);

}

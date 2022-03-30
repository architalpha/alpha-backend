package com.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.entity.UserCrypto;

@Repository
public interface UserCryptoRepository extends JpaRepository<UserCrypto, Long> {

	UserCrypto findFirstByCoinIdAndProtfolioId(String coinId, Long id);

	UserCrypto findByCoinIdAndProtfolioId(String coinId, Long id);

	UserCrypto findFirstByCoinIdAndProtfolioIdAndUserEmail(String coinId, Long id, String email);

//	UserCrypto findbyCoinIdAndProtfolioId(String coinId, Long id);
//
//	UserCrypto findbyCoinIdAndProtfolioIdFindFirst(String coinId, Long id);
//	
	
}
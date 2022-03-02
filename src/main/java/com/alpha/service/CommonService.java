package com.alpha.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.alpha.entity.CryptoCoins;
import com.alpha.entity.Protfolio;
import com.alpha.entity.ProtfolioCoin;

/**
 * @author sandip.bhetariya
 *
 */
public interface CommonService {

	Page<CryptoCoins> fetchCryptoCoin() throws Exception;

	Protfolio saveUpdateProtfolio(Protfolio protfolio) throws Exception;

	ProtfolioCoin saveUpdateProtfolioCoin(ProtfolioCoin protfolioCoin) throws Exception;

	Protfolio getProtfolioById(Long id) throws Exception;
	
	ProtfolioCoin getProtfolioCoinById(Long id) throws Exception;

	List<ProtfolioCoin> getProtfolioCoinByProtfolioId(Long protfolioId) throws Exception;

	List<Protfolio> getProtfolioListByEmailId(String email);

}

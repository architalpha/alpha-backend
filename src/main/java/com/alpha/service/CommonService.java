package com.alpha.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.alpha.entity.CryptoCoins;
import com.alpha.entity.Protfolio;
import com.alpha.entity.ProtfolioCoin;
import com.alpha.entity.UserProtfolio;
import com.alpha.model.ProtfolioWeb;

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

	List<Protfolio> getProtfolioListByEmailId(String email) throws Exception;
	
	List<Protfolio>  getProtfolioListall() throws Exception;

	List<CryptoCoins> findCryptoCoin(String search) throws Exception;

	CryptoCoins cryptoCoinById(String id) throws Exception;

	List<ProtfolioWeb> getProtfolioFullDetailsListall() throws Exception;

	ProtfolioWeb getProtfolioFullDetailsById(Long id) throws Exception;

	UserProtfolio getUserProtfolioById(Long id) throws Exception;

	List<UserProtfolio> getUserProtfolioByEmail(String email) throws Exception;

	UserProtfolio saveUpdateUserProtfolio(UserProtfolio userProtfolio) throws Exception;

	Object getProtfolioFullDetailsListallAdmin() throws Exception;

	Object getProtfolioListallbyEmail(String email) throws Exception;

}

package com.alpha.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.entity.CryptoCoins;
import com.alpha.entity.Protfolio;
import com.alpha.entity.ProtfolioCoin;
import com.alpha.model.LoginWebModel;
import com.alpha.service.CommonService;

@CrossOrigin("*")
@RestController
@RequestMapping("/common")
public class CommonController {

//	@Autowired
//	private HttpServletRequest request;

	@Autowired
	private CommonService commonService;
	
	private static final Logger LOG  = Logger.getLogger(CommonController.class);

	@GetMapping("/crypto-coin-list")
	public ResponseEntity<?> fetchCryptoCoinweb() throws Exception {
		try {

			Page<CryptoCoins> fetchCryptoCoin = commonService.fetchCryptoCoin();

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(fetchCryptoCoin);
			userWebModel.setPath("/common/crypto-coin-list");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/crypto-coin-list");
			userWebModel.setMessage(e.getMessage());
			
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-crypto-coin-list/{search}")
	public ResponseEntity<?> findCryptoCoin(@PathVariable String search) throws Exception {
		try {

			List<CryptoCoins> fetchCryptoCoin = commonService.findCryptoCoin(search);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(fetchCryptoCoin);
			userWebModel.setPath("/common/find-crypto-coin-list");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/find-crypto-coin-list/{search}");
			userWebModel.setMessage(e.getMessage());
			
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/protfolio")
	public ResponseEntity<?> saveUpdateProtfolio(@RequestBody Protfolio protfolio) throws Exception {
		try {
			protfolio = commonService.saveUpdateProtfolio(protfolio);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(protfolio);
			userWebModel.setPath("/common/protfolio");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/protfolio/{id}")
	public ResponseEntity<?> getProtfolioById(@PathVariable Long id) throws Exception {
		try {

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(commonService.getProtfolioById(id));
			userWebModel.setPath("/common/protfolio");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/protfolio-list/{email}")
	public ResponseEntity<?> getProtfolioListByEmailId(@PathVariable String email) throws Exception {
		try {

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(commonService.getProtfolioListByEmailId(email));
			userWebModel.setPath("/common/protfolio-list/{email}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio-list/{email}");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/protfolio-list-all")
	public ResponseEntity<?> getProtfolioListall() throws Exception {
		try {

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(commonService.getProtfolioListall());
			userWebModel.setPath("/common/protfolio-list/{email}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio-list/{email}");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/protfolio-coin/{id}")
	public ResponseEntity<?> getProtfolioCoinById(@PathVariable Long id) throws Exception {
		try {

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(commonService.getProtfolioCoinById(id));
			userWebModel.setPath("/common/protfolio-coin/{id}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio-coin/{id}");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/protfolio-coin-list/{protfolioId}")
	public ResponseEntity<?> getProtfolioCoinByProtfolioId(@PathVariable Long protfolioId) throws Exception {
		try {

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(commonService.getProtfolioCoinByProtfolioId(protfolioId));
			userWebModel.setPath("/protfolio-coin-list/{protfolioId}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/protfolio-coin-list/{protfolioId}");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/protfolio-coin")
	public ResponseEntity<?> saveUpdateProtfolioCoin(@RequestBody ProtfolioCoin protfolioCoin) throws Exception {
		try {
			protfolioCoin = commonService.saveUpdateProtfolioCoin(protfolioCoin);
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(protfolioCoin);
			userWebModel.setPath("/common/protfolio-coin");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/common/protfolio-coin");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(),e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

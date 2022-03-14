package com.alpha.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.entity.UserWallet;
import com.alpha.model.LoginWebModel;
import com.alpha.model.UserWalletWeb;
import com.alpha.service.WalletService;

@CrossOrigin("*")
@RestController
@RequestMapping("/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;

	private static final Logger LOG = Logger.getLogger(WalletController.class);

	@PostMapping("/saveUpdate")
	public ResponseEntity<?> saveUpdateWallet(@RequestBody UserWalletWeb model) throws Exception {
		try {
			UserWallet saveUpdateWallet = walletService.saveUpdateWallet(model);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(saveUpdateWallet);
			userWebModel.setPath("/wallet/saveUpdate");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/wallet/saveUpdate");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/topup")
	public ResponseEntity<?> topUpWallet(@RequestBody UserWalletWeb model) throws Exception {
		try {
			UserWallet topUpWallet = walletService.topUpWallet(model);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(topUpWallet);
			userWebModel.setPath("/wallet/topup");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/wallet/topup");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/investment")
	public ResponseEntity<?> investmentWallet(@RequestBody UserWalletWeb model) throws Exception {
		try {
			UserWallet investmentWallet = walletService.investmentWallet(model);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(investmentWallet);
			userWebModel.setPath("/wallet/investment");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/wallet/investment");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{email}")
	public ResponseEntity<?> userWalletByEmail(@PathVariable String email) throws Exception {
		try {

			UserWallet userWallet = walletService.userWalletByEmail(email);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(userWallet);
			userWebModel.setPath("/wallet/{email}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/wallet/{email}");
			userWebModel.setMessage(e.getMessage());

			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

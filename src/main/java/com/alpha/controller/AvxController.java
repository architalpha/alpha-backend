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

import com.alpha.entity.AvxUser;
import com.alpha.model.LoginWebModel;
import com.alpha.service.AvxUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/avx")
public class AvxController {
	
	@Autowired
	private AvxUserService avxUserService;
	
	private static final Logger LOG = Logger.getLogger(AvxController.class);
	
	
	@PostMapping("/saveUpdate")
	public ResponseEntity<?> saveUpdateAvx(@RequestBody AvxUser model) throws Exception {
		try {
			model = avxUserService.saveUpdateAvx(model);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(model);
			userWebModel.setPath("/avx/saveUpdate");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/avx/saveUpdate");
			userWebModel.setMessage(e.getMessage());
			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/{email}")
	public ResponseEntity<?> avxUserDetailsByEmail(@PathVariable String email) throws Exception {
		try {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("successfully !");
			userWebModel.setData(avxUserService.avxUserDetailsByEmail(email));
			userWebModel.setPath("/avx/{email}");

			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/avx/{email}");
			userWebModel.setMessage(e.getMessage());

			LOG.error(userWebModel.getPath(), e);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

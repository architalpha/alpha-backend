package com.alpha.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.entity.User;
import com.alpha.model.LoginWebModel;
import com.alpha.model.UserDTO;
import com.alpha.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

//	@Autowired
//	private HttpServletRequest request;

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<User> create(@RequestBody User user) throws Exception {
		user = userService.save(user);
		user.setPassword(";(");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody User user) throws Exception {
		try {
			User userDB = userService.findById(user.getId());
			if (userDB == null)
				throw new Exception("User ID not found");
			userDB.setUsername(null != user.getUsername() ? user.getUsername() : userDB.getUsername());
			userDB.setPassword(null != user.getPassword() ? user.getPassword() : userDB.getPassword());
			userDB.setFirstname(null != user.getFirstname() ? user.getFirstname() : userDB.getFirstname());
			userDB.setLastname(null != user.getLastname() ? user.getLastname() : userDB.getLastname());
			userDB.setEmail(null != user.getEmail() ? user.getEmail() : userDB.getEmail());
			userDB.setIsactive(user.isIsactive());
			

			user = userService.save(userDB);

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("Update successfully !");
			userWebModel.setPath("/user/{id}");

			user.setPassword(";)");
			userWebModel.setUser(user);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/user/{id}");
			userWebModel.setMessage(e.getMessage());
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestBody UserDTO user) throws Exception {
		try {
			User userDB = userService.findByEmail(user.getEmail());
			if (userDB == null)
				throw new Exception("User not found");

			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(HttpStatus.OK.name());
			userWebModel.setStatus(HttpStatus.OK.toString());
			userWebModel.setMessage("user found !");
			userWebModel.setPath("/user/{id}");

			userDB.setPassword(";)");
			userWebModel.setUser(userDB);
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LoginWebModel userWebModel = new LoginWebModel();
			userWebModel.setTimestamp(new Timestamp(new Date().getTime()));
			userWebModel.setError(e.getMessage());
			userWebModel.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			userWebModel.setPath("/signin");
			userWebModel.setMessage(e.getMessage());
			return new ResponseEntity<LoginWebModel>(userWebModel, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

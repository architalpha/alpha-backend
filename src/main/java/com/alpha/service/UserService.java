package com.alpha.service;

import com.alpha.entity.User;

/**
 * @author sandip.bhetariya
 *
 */
public interface UserService {

	User findById(Long id) throws Exception;

	User save(User userDB) throws Exception;

	User findByEmail(String email) throws Exception;
	
}

package com.alpha.service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.entity.User;
import com.alpha.repository.UserRepository;
import com.alpha.service.UserService;

/**
 * @author sandip.bhetariya
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User save(User userDB) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.save(userDB);
	}

	@Override
	public User findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).orElse(null);
	}
	
	
}

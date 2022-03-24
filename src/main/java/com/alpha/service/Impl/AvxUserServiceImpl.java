package com.alpha.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.entity.AvxUser;
import com.alpha.repository.AvxUserRepository;
import com.alpha.service.AvxUserService;

/**
 * @author sandip.bhetariya
 *
 */
@Service
@Transactional
public class AvxUserServiceImpl implements AvxUserService {
	
	@Autowired
	private AvxUserRepository avxUserRepository;

	@Override
	public Object avxUserDetailsByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		Long total = avxUserRepository.avxUserDetailsByEmail(email);
		return total != null ? total  : 0.0;
	}

	@Override
	public AvxUser saveUpdateAvx(AvxUser model) throws Exception {
		// TODO Auto-generated method stub
		model.setCreatedon(new Date());
		return avxUserRepository.save(model);
	}

	
}

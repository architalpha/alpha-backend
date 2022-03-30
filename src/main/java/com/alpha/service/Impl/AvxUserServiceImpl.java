package com.alpha.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.entity.AvxUser;
import com.alpha.entity.AvxUserStaking;
import com.alpha.repository.AvxUserRepository;
import com.alpha.repository.AvxUserStakingRepository;
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
	
	@Autowired
	private AvxUserStakingRepository avxUserStakingRepository;

	@Override
	public Object avxUserDetailsByEmail(String email) throws Exception {
		Long total = avxUserRepository.avxUserDetailsByEmail(email);
		return total != null ? total - avxUserStakingRepository.avxUserStakingDetailsByEmail(email)  : 0.0;
	}

	@Override
	public AvxUser saveUpdateAvx(AvxUser model) throws Exception {
		model.setCreatedon(new Date());
		return avxUserRepository.save(model);
	}

	@Override
	public AvxUserStaking saveUpdateAvxStaking(AvxUserStaking model) throws Exception {
		model.setCreatedon(new Date());
		return avxUserStakingRepository.save(model);
	}

	@Override
	public Object avxUserStakingDetailsByEmail(String email) throws Exception {
		Long total = avxUserStakingRepository.avxUserStakingDetailsByEmail(email);
		return total != null ? total  : 0.0;
	}

	
}

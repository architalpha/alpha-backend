package com.alpha.service;

import com.alpha.entity.AvxUser;
import com.alpha.entity.AvxUserStaking;

/**
 * @author sandip.bhetariya
 *
 */
public interface AvxUserService {

	Object avxUserDetailsByEmail(String email) throws Exception;

	AvxUser saveUpdateAvx(AvxUser model) throws Exception;

	AvxUserStaking saveUpdateAvxStaking(AvxUserStaking model) throws Exception;

	Object avxUserStakingDetailsByEmail(String email) throws Exception;
}

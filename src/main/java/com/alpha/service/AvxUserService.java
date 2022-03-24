package com.alpha.service;

import com.alpha.entity.AvxUser;

/**
 * @author sandip.bhetariya
 *
 */
public interface AvxUserService {

	Object avxUserDetailsByEmail(String email) throws Exception;

	AvxUser saveUpdateAvx(AvxUser model) throws Exception;
}

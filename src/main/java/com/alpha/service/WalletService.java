package com.alpha.service;

import com.alpha.entity.UserWallet;
import com.alpha.model.UserWalletWeb;

/**
 * @author sandip.bhetariya
 *
 */
public interface WalletService {

	UserWallet saveUpdateWallet(UserWalletWeb userWallet) throws Exception;

	UserWallet userWalletByEmail(String email) throws Exception;

	UserWallet topUpWallet(UserWalletWeb userWallet) throws Exception;

	UserWallet investmentWallet(UserWalletWeb userWallet) throws Exception;

}

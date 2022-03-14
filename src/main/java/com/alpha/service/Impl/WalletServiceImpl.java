package com.alpha.service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.entity.UserWallet;
import com.alpha.model.UserWalletWeb;
import com.alpha.repository.UserWalletReporsitory;
import com.alpha.service.WalletService;

/**
 * @author sandip.bhetariya
 *
 */
@Service
@Transactional
public class WalletServiceImpl implements WalletService {

	@Autowired
	private UserWalletReporsitory userWalletReporsitory;

	@Override
	public UserWallet saveUpdateWallet(UserWalletWeb webModel) throws Exception {
		if (null != webModel && null != webModel.getEmail()) {
			Optional<UserWallet> findById = userWalletReporsitory.findById(webModel.getEmail());
			UserWallet entity = new UserWallet();
			if (findById.isPresent()) {
				entity = findById.get();
			}
			entity.setEmail(webModel.getEmail());
			entity.setAmount(webModel.getAmount());
			entity.setCreatedon(new Date());
			return userWalletReporsitory.save(entity);
		} else {
			throw new Exception("email is null");
		}

	}

	@Override
	public UserWallet userWalletByEmail(String email) throws Exception {
		if (null != email) {
			return userWalletReporsitory.findById(email).orElse(null);
		} else {
			throw new Exception("email is null");
		}
	}

	@Override
	public UserWallet topUpWallet(UserWalletWeb webModel) throws Exception {
		if (null != webModel && null != webModel.getEmail()) {

			Optional<UserWallet> findById = userWalletReporsitory.findById(webModel.getEmail());
			if (findById.isPresent()) {
				UserWallet userWallet = findById.get();
				userWallet.setUpdatedon(new Date());
				userWallet.setAmount(Double.sum(userWallet.getAmount(), webModel.getAmount()));

				return userWalletReporsitory.save(userWallet);
			}
			return null;
		} else {
			throw new Exception("email is null");
		}
	}

	@Override
	public UserWallet investmentWallet(UserWalletWeb webModel) throws Exception {
		if (null != webModel && null != webModel.getEmail()) {
			Optional<UserWallet> findById = userWalletReporsitory.findById(webModel.getEmail());
			if (findById.isPresent()) {
				UserWallet userWallet = findById.get();
				userWallet.setUpdatedon(new Date());
				userWallet.setAmount(BigDecimal.valueOf(userWallet.getAmount())
						.subtract(BigDecimal.valueOf(webModel.getAmount())).doubleValue());
				return userWalletReporsitory.save(userWallet);
			}
			return null;
		} else {
			throw new Exception("email is null");
		}
	}

}

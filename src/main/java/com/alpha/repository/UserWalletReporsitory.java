package com.alpha.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.UserWallet;

@Transactional
public interface UserWalletReporsitory extends JpaRepository<UserWallet, String> {

}

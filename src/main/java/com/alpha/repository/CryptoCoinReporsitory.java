package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.CryptoCoins;

@Transactional
public interface CryptoCoinReporsitory extends JpaRepository<CryptoCoins, String> {

}

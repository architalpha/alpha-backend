package com.alpha.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.DailyPriceTickers;

@Transactional
public interface DailyPriceTickersRepository extends JpaRepository<DailyPriceTickers, String> {
	
}

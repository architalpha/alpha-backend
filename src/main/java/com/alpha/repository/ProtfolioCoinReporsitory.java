package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.ProtfolioCoin;

@Transactional
public interface ProtfolioCoinReporsitory extends JpaRepository<ProtfolioCoin, Long> {

	List<ProtfolioCoin> findByProtfolioId(Long protfolioId);

}

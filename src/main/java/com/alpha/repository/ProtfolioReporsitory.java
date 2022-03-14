package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.Protfolio;

@Transactional
public interface ProtfolioReporsitory extends JpaRepository<Protfolio, Long> {

	List<Protfolio> findByUserEmail(String email);

	List<Protfolio> findByIsAdmin(Boolean isAdmin);

}

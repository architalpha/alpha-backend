package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.UserProtfolio;

@Transactional
public interface UserProtfolioReporsitory extends JpaRepository<UserProtfolio, Long> {

	List<UserProtfolio> findByUserEmail(String email);

}

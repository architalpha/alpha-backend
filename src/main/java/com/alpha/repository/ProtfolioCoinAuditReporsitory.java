package com.alpha.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.entity.ProtfolioCoinAudit;

@Transactional
public interface ProtfolioCoinAuditReporsitory extends JpaRepository<ProtfolioCoinAudit, Long> {

	List<ProtfolioCoinAudit> findByProtfolioId(Long protfolioId);

}

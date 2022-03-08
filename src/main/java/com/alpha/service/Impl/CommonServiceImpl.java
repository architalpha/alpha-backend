package com.alpha.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alpha.entity.CryptoCoins;
import com.alpha.entity.Protfolio;
import com.alpha.entity.ProtfolioCoin;
import com.alpha.repository.CryptoCoinReporsitory;
import com.alpha.repository.ProtfolioCoinReporsitory;
import com.alpha.repository.ProtfolioReporsitory;
import com.alpha.service.CommonService;

/**
 * @author sandip.bhetariya
 *
 */
@Service
@Transactional
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CryptoCoinReporsitory cryptoCoinReporsitory;

	@Autowired
	private ProtfolioReporsitory protfolioReporsitory;

	@Autowired
	private ProtfolioCoinReporsitory protfolioCoinReporsitory;

	@Override
	public Page<CryptoCoins> fetchCryptoCoin() throws Exception {
		// TODO Auto-generated method stub
		Page<CryptoCoins> findAll = cryptoCoinReporsitory
				.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "rank")));
		return findAll;
	}

	@Override
	public Protfolio saveUpdateProtfolio(Protfolio protfolio) throws Exception {
		// TODO Auto-generated method stub
		if (protfolio != null && protfolio.getId() != null) {
			Optional<Protfolio> findById = protfolioReporsitory.findById(protfolio.getId());
			if (findById.isPresent()) {
				protfolio.setCreatedon(findById.get().getCreatedon());
				return protfolioReporsitory.save(protfolio);
			} else {
				protfolio.setCreatedon(new Date());
				return protfolioReporsitory.save(protfolio);
			}
		} else {
			protfolio.setCreatedon(new Date());
			return protfolioReporsitory.save(protfolio);
		}
	}

	@Override
	public ProtfolioCoin saveUpdateProtfolioCoin(ProtfolioCoin protfolioCoin) throws Exception {
		// TODO Auto-generated method stub
		if (protfolioCoin != null && protfolioCoin.getId() != null) {
			Optional<ProtfolioCoin> findById = protfolioCoinReporsitory.findById(protfolioCoin.getId());
			if (findById.isPresent()) {
				protfolioCoin.setCreatedon(findById.get().getCreatedon());
				return protfolioCoinReporsitory.save(protfolioCoin);
			} else {
				protfolioCoin.setCreatedon(new Date());
				return protfolioCoinReporsitory.save(protfolioCoin);
			}
		} else {
			protfolioCoin.setCreatedon(new Date());
			return protfolioCoinReporsitory.save(protfolioCoin);
		}
	}

	@Override
	public Protfolio getProtfolioById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return protfolioReporsitory.findById(id).orElse(null);
	}

	@Override
	public ProtfolioCoin getProtfolioCoinById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return protfolioCoinReporsitory.findById(id).orElse(null);
	}

	@Override
	public List<ProtfolioCoin> getProtfolioCoinByProtfolioId(Long protfolioId) throws Exception {
		// TODO Auto-generated method stub
		return protfolioCoinReporsitory.findByProtfolioId(protfolioId);
	}

	@Override
	public List<Protfolio> getProtfolioListByEmailId(String email) {
		// TODO Auto-generated method stub
		return protfolioReporsitory.findByUserEmail(email);
	}

	@Override
	public List<Protfolio> getProtfolioListall() {
		// TODO Auto-generated method stub
		return protfolioReporsitory.findAll();
	}

	@Override
	public List<CryptoCoins> findCryptoCoin(String search) {
		// TODO Auto-generated method stub
		return cryptoCoinReporsitory.findByIdContainingIgnoreCase(search);
	}

}

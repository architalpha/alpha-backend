package com.alpha.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.alpha.entity.CryptoCoins;
import com.alpha.entity.Protfolio;
import com.alpha.entity.ProtfolioCoin;
import com.alpha.entity.ProtfolioCoinAudit;
import com.alpha.entity.UserCrypto;
import com.alpha.entity.UserProtfolio;
import com.alpha.model.ProtfolioCoinListWeb;
import com.alpha.model.ProtfolioCoinWeb;
import com.alpha.model.ProtfolioWeb;
import com.alpha.repository.CryptoCoinReporsitory;
import com.alpha.repository.ProtfolioCoinAuditReporsitory;
import com.alpha.repository.ProtfolioCoinReporsitory;
import com.alpha.repository.ProtfolioReporsitory;
import com.alpha.repository.UserCryptoRepository;
import com.alpha.repository.UserProtfolioReporsitory;
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

	@Autowired
	private UserProtfolioReporsitory userProtfolioReporsitory;

	@Autowired
	private UserCryptoRepository userCryptoRepository;

	@Autowired
	private ProtfolioCoinAuditReporsitory protfolioCoinAuditReporsitory;

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
				if (null != protfolio.getUserEmail()
						&& (protfolio.getUserEmail().equalsIgnoreCase("architarya@gmail.com")
								|| protfolio.getUserEmail().equalsIgnoreCase("vibhor@alphavault.io")))
					protfolio.setIsAdmin(Boolean.TRUE);
				
				return protfolioReporsitory.save(protfolio);
			} else {
				protfolio.setCreatedon(new Date());
				if (null != protfolio.getUserEmail()
						&& (protfolio.getUserEmail().equalsIgnoreCase("architarya@gmail.com")
								|| protfolio.getUserEmail().equalsIgnoreCase("vibhor@alphavault.io")))
					protfolio.setIsAdmin(Boolean.TRUE);

				return protfolioReporsitory.save(protfolio);
			}
		} else {
			protfolio.setCreatedon(new Date());
			if (null != protfolio.getUserEmail()
					&& (protfolio.getUserEmail().equalsIgnoreCase("architarya@gmail.com")
							|| protfolio.getUserEmail().equalsIgnoreCase("vibhor@alphavault.io")))
				protfolio.setIsAdmin(Boolean.TRUE);
			
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
				// (protfolioCoin.getCurrentPrice()/100)*protfolioCoin.getPercentage();
				// Double currentPrice = protfolioCoin.getCurrentPrice();
				Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
				// Double avg = protfolioCoin.getCurrentPrice() * (protfolioCoin.getPercentage()
				// / 100);
				protfolioCoin.setCurrentPrice(avg);
				return protfolioCoinReporsitory.save(protfolioCoin);
			} else {
				protfolioCoin.setCreatedon(new Date());
				Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
				protfolioCoin.setCurrentPrice(avg);
				return protfolioCoinReporsitory.save(protfolioCoin);
			}
		} else {
			protfolioCoin.setCreatedon(new Date());
			Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
			// value*(percentage/100.0f)
			protfolioCoin.setCurrentPrice(avg);
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
		return cryptoCoinReporsitory.findByIdContainingIgnoreCaseOrderByRankAsc(search);

	}

	@Override
	public CryptoCoins cryptoCoinById(String id) {
		// TODO Auto-generated method stub
		return cryptoCoinReporsitory.findById(id).orElse(null);
	}

	@Override
	public List<ProtfolioWeb> getProtfolioFullDetailsListall() throws Exception {
		// TODO Auto-generated method stub
		List<ProtfolioWeb> resList = new ArrayList<>();
		try {

			List<Protfolio> findAll = protfolioReporsitory.findAll();
			for (Protfolio protfolio : findAll) {
				ProtfolioWeb web = new ProtfolioWeb();
				Double totalCreatedPrice = 0.0;
				Double totalCurrentPrice = 0.0;

				BeanUtils.copyProperties(protfolio, web);
				List<ProtfolioCoinWeb> prrotfoliCoinLst = new ArrayList<>();
				List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory.findByProtfolioId(web.getId());
				for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
					ProtfolioCoinWeb coinWeb = new ProtfolioCoinWeb();
					BeanUtils.copyProperties(protfolioCoin, coinWeb);
					totalCreatedPrice = Double.sum(totalCreatedPrice, coinWeb.getCreatedPrice());

					UserCrypto userCrypto = userCryptoRepository.findFirstByCoinIdAndProtfolioId(coinWeb.getCoinId(),
							protfolio.getId());
					CryptoCoins crypto = cryptoCoinReporsitory.findById(coinWeb.getCoinId()).orElse(null);
					if (null != crypto && crypto.getTickers() != null && userCrypto != null) {
						totalCurrentPrice = Double.sum(totalCurrentPrice,
								crypto.getTickers().getUsd_price() * userCrypto.getCoinvalue());
					}
					coinWeb.setCoin(crypto);
					prrotfoliCoinLst.add(coinWeb);

				}
				web.setProtfolioCoin(prrotfoliCoinLst);
				web.setTotalCreatedPrice(totalCreatedPrice);
				web.setTotalCurrentPrice(totalCurrentPrice);

				web.setDifferentPercentage((totalCurrentPrice-totalCreatedPrice)/100);

				resList.add(web);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resList;
	}

	@Override
	public ProtfolioWeb getProtfolioFullDetailsById(Long id) throws Exception {
		// TODO Auto-generated method stub
		ProtfolioWeb res = new ProtfolioWeb();
		Optional<Protfolio> findById = protfolioReporsitory.findById(id);
		if (findById.isPresent()) {
			Protfolio protfolio = findById.get();
			Double totalCreatedPrice = 0.0;
			Double totalCurrentPrice = 0.0;

			BeanUtils.copyProperties(protfolio, res);

			List<ProtfolioCoinWeb> prrotfoliCoinLst = new ArrayList<>();
			List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory.findByProtfolioId(res.getId());
			for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
				ProtfolioCoinWeb coinWeb = new ProtfolioCoinWeb();

				BeanUtils.copyProperties(protfolioCoin, coinWeb);
				totalCreatedPrice = Double.sum(totalCreatedPrice, coinWeb.getCreatedPrice());

				CryptoCoins crypto = cryptoCoinReporsitory.findById(coinWeb.getCoinId()).orElse(null);
				if (null != crypto && crypto.getTickers() != null) {
					UserCrypto userCrypto = userCryptoRepository.findFirstByCoinIdAndProtfolioId(coinWeb.getCoinId(),
							protfolio.getId());
					totalCurrentPrice = Double.sum(totalCurrentPrice, crypto.getTickers().getUsd_price()*userCrypto.getCoinvalue());
				}
				coinWeb.setCoin(crypto);
				prrotfoliCoinLst.add(coinWeb);

			}
			res.setProtfolioCoin(prrotfoliCoinLst);
			res.setTotalCreatedPrice(totalCreatedPrice);
			res.setTotalCurrentPrice(totalCurrentPrice);

			
			res.setDifferentPercentage((totalCurrentPrice-totalCreatedPrice)/100);
		}
		return res;
	}

	@Override
	public UserProtfolio getUserProtfolioById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return userProtfolioReporsitory.findById(id).orElse(null);
	}

	@Override
	public List<UserProtfolio> getUserProtfolioByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return userProtfolioReporsitory.findByUserEmail(email);
	}

	@Override
	public UserProtfolio saveUpdateUserProtfolio(UserProtfolio userProtfolio) throws Exception {
		// TODO Auto-generated method stub
		userProtfolio = userProtfolioReporsitory.save(userProtfolio);
		List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory
				.findByProtfolioId(userProtfolio.getProtfolioId());
		for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
			// userCryptoRepository
			UserCrypto userCrypto = new UserCrypto();
			// Double avg = (protfolioCoin.getCreatedPrice() *
			// protfolioCoin.getPercentage()) / 100;
			Double avg = (userProtfolio.getInvestmentAmount() * protfolioCoin.getPercentage()) / 100;
			userCrypto.setProtfolioId(userProtfolio.getProtfolioId());
			protfolioCoin.setCreatedPrice(avg);
			userCrypto.setCoinId(protfolioCoin.getCoinId());

			Optional<CryptoCoins> findById = cryptoCoinReporsitory.findById(protfolioCoin.getCoinId());
			if (findById.isPresent()) {
				if (null != findById.get().getTickers()) {
					userCrypto.setCoinvalue(avg / findById.get().getTickers().getUsd_price());
				} else {
					userCrypto.setCoinvalue(avg);
				}
			} else {
				userCrypto.setCoinvalue(avg);
			}
			// userCrypto.setCoinvalue(avg);
			userCrypto.setUserEmail(userProtfolio.getUserEmail());
			userCrypto.setCreatedon(new Date());
			userCryptoRepository.save(userCrypto);
			protfolioCoinReporsitory.save(protfolioCoin);

		}
		return userProtfolio;
	}

	@Override
	public Object getProtfolioFullDetailsListallAdmin() throws Exception {
		// TODO Auto-generated method stub
		List<ProtfolioWeb> resList = new ArrayList<>();
		List<Protfolio> findAll = protfolioReporsitory.findByIsAdmin(Boolean.TRUE);
		for (Protfolio protfolio : findAll) {
			ProtfolioWeb web = new ProtfolioWeb();
			Double totalCreatedPrice = 0.0;
			Double totalCurrentPrice = 0.0;

			BeanUtils.copyProperties(protfolio, web);
			List<ProtfolioCoinWeb> prrotfoliCoinLst = new ArrayList<>();
			List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory.findByProtfolioId(web.getId());
			for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
				ProtfolioCoinWeb coinWeb = new ProtfolioCoinWeb();
				BeanUtils.copyProperties(protfolioCoin, coinWeb);
				totalCreatedPrice = Double.sum(totalCreatedPrice, coinWeb.getCreatedPrice());

				CryptoCoins crypto = cryptoCoinReporsitory.findById(coinWeb.getCoinId()).orElse(null);
				if (null != crypto && crypto.getTickers() != null) {
					totalCurrentPrice = Double.sum(totalCurrentPrice, crypto.getTickers().getUsd_price());
				}
				coinWeb.setCoin(crypto);
				prrotfoliCoinLst.add(coinWeb);

			}
			web.setProtfolioCoin(prrotfoliCoinLst);
			web.setTotalCreatedPrice(totalCreatedPrice);
			web.setTotalCurrentPrice(totalCurrentPrice);

			resList.add(web);

		}

		return resList;
	}

	@Override
	public Object getProtfolioListallbyEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		List<ProtfolioWeb> resList = new ArrayList<>();
		List<Long> userProtfoliList = new ArrayList<>();
		List<UserProtfolio> findByUserEmail = userProtfolioReporsitory.findByUserEmail(email);
		Boolean isProcess = Boolean.FALSE;
		for (UserProtfolio userProtfolio : findByUserEmail) {
			isProcess = Boolean.TRUE;
			userProtfoliList.add(userProtfolio.getProtfolioId());
		}
		if (!isProcess) {
			return resList;
		}
		try {

			List<Protfolio> findAll = protfolioReporsitory.findAllById(userProtfoliList);
			for (Protfolio protfolio : findAll) {
				ProtfolioWeb web = new ProtfolioWeb();
				Double totalCreatedPrice = 0.0;
				Double totalCurrentPrice = 0.0;

				BeanUtils.copyProperties(protfolio, web);
				List<ProtfolioCoinWeb> prrotfoliCoinLst = new ArrayList<>();
				List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory.findByProtfolioId(web.getId());
				for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
					ProtfolioCoinWeb coinWeb = new ProtfolioCoinWeb();
					BeanUtils.copyProperties(protfolioCoin, coinWeb);
					totalCreatedPrice = Double.sum(totalCreatedPrice, coinWeb.getCreatedPrice());

					UserCrypto userCrypto = userCryptoRepository.findFirstByCoinIdAndProtfolioId(coinWeb.getCoinId(),
							protfolio.getId());
					CryptoCoins crypto = cryptoCoinReporsitory.findById(coinWeb.getCoinId()).orElse(null);
					if (null != crypto && crypto.getTickers() != null && userCrypto != null) {
						totalCurrentPrice = Double.sum(totalCurrentPrice,
								crypto.getTickers().getUsd_price() * userCrypto.getCoinvalue());
					}
					coinWeb.setCoin(crypto);
					prrotfoliCoinLst.add(coinWeb);

				}
				web.setProtfolioCoin(prrotfoliCoinLst);
				web.setTotalCreatedPrice(totalCreatedPrice);
				web.setTotalCurrentPrice(totalCurrentPrice);

				web.setDifferentPercentage((totalCurrentPrice-totalCreatedPrice)/100);

				resList.add(web);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resList;
	}

	@Override
	public List<ProtfolioCoin> saveUpdateProtfolioCoinList(ProtfolioCoinListWeb protfolioCoinListWeb) {
		// TODO Auto-generated method stub
		List<ProtfolioCoin> resLst = new ArrayList<>();
		List<Long> protfolioIdLst = new ArrayList<>();

		if (null != protfolioCoinListWeb.getIsNew() && null != protfolioCoinListWeb.getProtfolioId()
				&& protfolioCoinListWeb.getIsNew() == false) {
			List<ProtfolioCoin> findByProtfolioId = protfolioCoinReporsitory.findByProtfolioId(protfolioCoinListWeb.getProtfolioId());

			for (ProtfolioCoin protfolioCoin : findByProtfolioId) {
				protfolioIdLst.add(protfolioCoin.getId());
				ProtfolioCoinAudit audit = new ProtfolioCoinAudit();
				BeanUtils.copyProperties(protfolioCoin, audit);
				audit.setProtfolioCoinId(protfolioCoin.getId());
				audit.setCreatedon(new Date());
				protfolioCoinAuditReporsitory.save(audit);
				protfolioCoinReporsitory.delete(protfolioCoin);
			}
		}

		List<ProtfolioCoin> protfolioCoinList = protfolioCoinListWeb.getProtfolioCoinList();
		try {
			for (ProtfolioCoin protfolioCoin : protfolioCoinList) {

				if (protfolioCoin != null && protfolioCoin.getId() != null) {
					Optional<ProtfolioCoin> findById = protfolioCoinReporsitory.findById(protfolioCoin.getId());
					if (findById.isPresent()) {
						protfolioCoin.setCreatedon(findById.get().getCreatedon());
						Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
						protfolioCoin.setCurrentPrice(avg);
						resLst.add(protfolioCoinReporsitory.save(protfolioCoin));
					} else {
						protfolioCoin.setCreatedon(new Date());
						Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
						protfolioCoin.setCurrentPrice(avg);
						resLst.add(protfolioCoinReporsitory.save(protfolioCoin));
					}
				} else {
					protfolioCoin.setCreatedon(new Date());
					Double avg = (protfolioCoin.getCreatedPrice() * protfolioCoin.getPercentage()) / 100;
					protfolioCoin.setCurrentPrice(avg);
					resLst.add(protfolioCoinReporsitory.save(protfolioCoin));
				}

			}

//			protfolioCoinReporsitory.deleteAll(protfolioCoinList);
		} catch (Exception e) {

		}

		return resLst;
	}

}

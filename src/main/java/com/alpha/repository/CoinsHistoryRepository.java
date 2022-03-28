package com.alpha.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alpha.entity.CoinsHistory;

@Transactional
public interface CoinsHistoryRepository extends JpaRepository<CoinsHistory, String>, JpaSpecificationExecutor<CoinsHistory> {

//	@Query(value = "select ch from CoinsHistory ch where ch.time_close BETWEEN  :startDate AND :endDate and ch.coin_id = :coin_id")
//	CoinsHistory fetchClosePriceYesterday(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("coin_id") String coin_id);
//
//	@Query(value = "select ch from CoinsHistory ch where ch.coin_id = :cryptoCoinId and ch.time_open >= :time_open")
//	List<CoinsHistory> fetchbyCoinidDate(@Param("cryptoCoinId") String cryptoCoinId ,@Param("time_open") Date time_open);
//	//List<CoinsHistory> fetchbyCoinidDate(String cryptoCoinId, Date date);
//
//	@Query(value = "select ch from CoinsHistory ch where ch.coin_id = :cryptoCoinId and ch.date > :date")
//	List<CoinsHistory>  fetchbyCoinidAll(@Param("cryptoCoinId") String cryptoCoinId,@Param("date") Date date);
//
//	@Query(value = "select ch from CoinsHistory ch where ch.coin_id = :cryptoCoinId and ch.date > :date and ch.odd = :odd")
//	List<CoinsHistory> fetchbyCoinidOdd(@Param("cryptoCoinId") String cryptoCoinId,@Param("date") Date date,@Param("odd") Boolean odd);
//
//	@Query(value = "select ch from CoinsHistory ch where ch.coin_id = :cryptoCoinId and ch.odd = :odd")
//	List<CoinsHistory> fetchbyCoinidAllTime(@Param("cryptoCoinId") String cryptoCoinId,@Param("odd") Boolean odd);

	@Query(value = "select ch from CoinsHistory ch where ch.coin_id in (:coinIdsList) and ch.date = :out ")
	List<CoinsHistory> getCoinHistoryByIdAndPastDate(@Param("coinIdsList") List<String> coinIdsList,@Param("out") Date out);

}

package com.alpha.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class DailyPriceTickersModel implements Serializable{

	
	private String coin_id;
	
	private String name;
	
	private String symbol;
	
	private Long rank;
	
	private Double circulating_supply;
	
	private Double total_supply;
	
	private Double max_supply;
	
	private Double beta_value;
	
	private Long volumerank;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_updated;
	
	//BTC
	private Double btc_price;
	
	private Double btc_volume_24h;
	
	private Double btc_volume_24h_change_24h;
	
	private Double btc_market_cap;
	
	private Double btc_market_cap_change_24h;
	
	private Double btc_percent_change_1h;
	
	private Double btc_percent_change_12h;
	
	private Double btc_percent_change_24h;
	
	private Double btc_percent_change_7d;
	
	private Double btc_percent_change_30d;
	
	private Double btc_percent_change_1y;
	
	private Double btc_ath_price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date btc_ath_date;
	
	private Double btc_percent_from_price_ath;
	
	//ETH
	private Double eth_price;
	
	private Double eth_volume_24h;
	
	private Double eth_volume_24h_change_24h;
	
	private Double eth_market_cap;
	
	private Double eth_market_cap_change_24h;
	
	private Double eth_percent_change_1h;
	
	private Double eth_percent_change_12h;
	
	private Double eth_percent_change_24h;
	
	private Double eth_percent_change_7d;
	
	private Double eth_percent_change_30d;
	
	private Double eth_percent_change_1y;
	
	private Double eth_ath_price;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date eth_ath_date;
	
	private Double eth_percent_from_price_ath;
	
	
	//USD
	private Double usd_price;
	
	private Double usd_volume_24h;
	
	private Double usd_volume_24h_change_24h;
	
	private Double usd_market_cap;
	
	private Double usd_market_cap_change_24h;
	
	private Double usd_percent_change_1h;
	
	private Double usd_percent_change_12h;
	
	private Double usd_percent_change_24h;
	
	private Double usd_percent_change_7d;
	
	private Double usd_percent_change_30d;
	
	private Double usd_percent_change_1y;
	
	private Double usd_ath_price;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date usd_ath_date;
	
	private Double usd_percent_from_price_ath;
	

}

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
public @Data class CryptoCoinsModel implements Serializable{

	
	private String id;
	
	private String name;
	
	private String symbol;
	
	private Long rank;
	
	private Boolean is_new;
	
	private Boolean is_active;
	
	private String type;
	
	private String description;
	
	private Boolean open_source;
	
	private Boolean hardware_wallet;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date started_at;
	 
	private String development_status;
	
	private String proof_type;
	
	private String org_structure;
	
	private String hash_algorithm;
	
	private String link;
	
	private String thumbnail;
	
	private String firstDataAt;
	
	private String lastDataAt;
	
	private DailyPriceTickersModel tickers;
	
	
}

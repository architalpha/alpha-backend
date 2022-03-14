package com.alpha.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProtfolioWeb {

	private Long id;
	private String name;	
	private Boolean isAdmin = false;
	private Date createdon;
	private String userEmail;	
	private String strategyType;
	private String rebalancing;
	private String holdTerm;
	private String buyType;	
	
	private String description;
	private String shortDesc;
	
	private Double totalCreatedPrice;
	private Double totalCurrentPrice;
	
	private List<ProtfolioCoinWeb> protfolioCoin;
	
}

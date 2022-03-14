package com.alpha.model;

import java.util.Date;

import com.alpha.entity.CryptoCoins;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProtfolioCoinWeb {

	private Long id;
	private Long protfolioId;
	private String coinId;
	private Double percentage;
	private Double createdPrice;
	private Double currentPrice;
	private Date createdon;
	
	private CryptoCoins coin;

}

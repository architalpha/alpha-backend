package com.alpha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_crypto")
@Getter
@Setter
@Data
public class UserCrypto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "coin_id")
	private String coinId;

	@Column(name = "coin_value")
	private Double coinvalue;
	
//	invest - 1000 
//	
//	ratio - 40/30/30
//	2000 - btc 
//	2000/400 = ivsent
//	
//	---------
//	0.2 * current price = 
	
	@Column(name = "protfolio_id")
	private Long protfolioId;
	
	private Date createdon;
	
	@Column(name="createdby")
	private String userEmail;

	
}

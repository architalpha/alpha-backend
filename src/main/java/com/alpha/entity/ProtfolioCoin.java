package com.alpha.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "protfolio_coin")
@Getter
@Setter
@Data
public class ProtfolioCoin {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "protfolio_id")
	private Long protfolioId;

	@Column(name = "coin_id")
	private String coinId;

	private Double percentage;

	@Column(name = "created_price")
	private Double createdPrice;

	@Column(name = "current_price")
	private Double currentPrice;

	private Date createdon;

}

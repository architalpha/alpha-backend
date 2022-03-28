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
@Table(name="protfolio")
@Getter
@Setter
@Data
public class Protfolio {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;	
	
	private Boolean isAdmin;
	
	private Date createdon;
	
	@Column(name="createdby")
	private String userEmail;	
	
	@Column(name="strategy_type")
	private String strategyType;
	
	private String description;
	
	@Column(name="short_desc")
	private String shortDesc;
	
	private String rebalancing;
	
	@Column(name="hold_term")
	private String holdTerm;
	
	@Column(name="buy_type")
	private String buyType;	
	
	private String color;
	
	
}

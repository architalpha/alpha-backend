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
@Table(name="user_protfolio")
@Getter
@Setter
@Data
public class UserProtfolio {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="protfolio_id")
	private Long protfolioId;	
		
	@Column(name="createdby")
	private String userEmail;	
	
	@Column(name="investment_amount")
	private Double investmentAmount;	

	private Date createdon;
	
}

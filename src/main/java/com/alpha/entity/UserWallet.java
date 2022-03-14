package com.alpha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_wallet")
@Getter
@Setter
public @Data class UserWallet implements Serializable{


	@Id
	private String email;
	
	private Double amount;
	
	private Date createdon;
	
	private Date updatedon;
		
}

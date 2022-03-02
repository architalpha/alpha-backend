package com.alpha.model;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.alpha.entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public @Data class LoginWebModel {
	
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp timestamp;
	private String status;
	private String error;
	private String message;
	private String path;
	private User user;
	private Object Data;
	
}

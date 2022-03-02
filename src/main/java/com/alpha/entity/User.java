package com.alpha.entity;

import java.util.Date;

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
@Table(name="user")
@Getter
@Setter
@Data
public class User {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String firstname;
	
	private String lastname;
	
	private String email;

	
	private boolean isactive = true;
	@JsonIgnore
	private Date createdon;
	
	@JsonIgnore
	private String createdby;
	
	
//	private String image_url;
//	
//	private String image_path;
//	
//	private String image_name;
	
	
	
}

package com.alpha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="coin_history")
@Getter
@Setter
@IdClass(CoinsHistoryPK.class)
public class CoinsHistory implements Serializable{
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;*/
	@Id
	private String coin_id;
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_open;
	
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date time_close;
	
	private Double open;
	
	private Double high;
	
	private Double low;
	
	private Double close;
	
	private Double volume;
	
	private Double market_cap;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private Boolean odd;
	
	private Boolean even;
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coin_id == null) ? 0 : coin_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoinsHistory other = (CoinsHistory) obj;
		if (coin_id == null) {
			if (other.coin_id != null)
				return false;
		} else if (!coin_id.equals(other.coin_id))
			return false;
		return true;
	}

	public CoinsHistory(String coin_id) {
		super();
		this.coin_id = coin_id;
	}

	public CoinsHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

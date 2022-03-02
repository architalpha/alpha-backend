package com.alpha.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Indexed;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="coins")
@Getter
@Setter
@Indexed
public @Data class CryptoCoins implements Serializable{

	@Id
	@Column(name="coin_id")
	private String id;
	
//	@Field(store = Store.NO)
	private String name;
	
//	@Field
	@Column(name="ticker")
	private String symbol;
	
	@Column(name="ranks")
	private Long rank;
	
	private Boolean is_new;
	
	private Boolean is_active;
	
	private String type;
	
	private String description;
	
	private Boolean open_source;
	
	private Boolean hardware_wallet;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date started_at;
	 
	private String development_status;
	
	private String proof_type;
	
	private String org_structure;
	
	private String hash_algorithm;
	
	@Column(name="whitepaper_link")
	private String link;
	
	@Column(name="whitepaper_thumbnail")
	private String thumbnail;
	
	@Column(name="first_data_at")
	private String firstDataAt;
	
	@Column(name="last_data_at")
	private String lastDataAt;
	
//	@OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "coin_tags",joinColumns=@JoinColumn(name="coin_id"),inverseJoinColumns=@JoinColumn(name="tag_id"))
//    private List<Tags> tagList;
	
	/*@OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coin_teams",joinColumns=@JoinColumn(name="coin_id"),inverseJoinColumns=@JoinColumn(name="team_id"))
    private List<Teams> teamList;*/
	
	/*@OneToMany(
	        mappedBy = "coin_id",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
    private List<CoinTags> coinTags;*/
	
	@OneToOne(cascade=CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="coin_id")
    private DailyPriceTickers tickers;

	
	/*@OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "coin_links",joinColumns=@JoinColumn(name="coin_id", referencedColumnName="api_id"),inverseJoinColumns=@JoinColumn(name="link_name",referencedColumnName="url"))
    private List<Links> linkList;*/
	
	/*@OneToMany(mappedBy="coin")
	private List<CoinTags> coinTag;*/
	
	
}

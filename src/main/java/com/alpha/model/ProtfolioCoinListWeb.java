package com.alpha.model;

import java.util.List;

import com.alpha.entity.ProtfolioCoin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProtfolioCoinListWeb {

	private Long protfolioId;
	private Boolean isNew;
	
	private List<ProtfolioCoin> protfolioCoinList;

}

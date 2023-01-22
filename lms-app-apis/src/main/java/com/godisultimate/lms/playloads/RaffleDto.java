package com.godisultimate.lms.playloads;

import javax.persistence.Column;

import lombok.Data;

@Data
public class RaffleDto {
private long id;
	
	@Column(name = "raffle_name", nullable = false, length = 100)
	private String raffleName;
	private String raffleCode;
	private int series;
	private String playDay;

}

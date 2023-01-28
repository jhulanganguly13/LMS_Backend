package com.godisultimate.lms.playloads;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaffleStockDto {
	
	private long rflStkId;

	private long userId;

	private long raffleId;

	private int draw;

	private LocalDate drawDate;

	private long rflStrFrom;

	private long rflEndTo;

	private long grpId;

	private double qty;

	private double rate;
}

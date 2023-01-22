package com.godisultimate.lms.playloads;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDetailsDto {

	private long prchDtlsId;
	
	private long prchId;
	
	private long raffleId;
	
	private String raffleCode;
	
	private String raffleName;
	
	private int draw;
	
	private LocalDate drawDate;
	
	private long rflStrFrom;
	
	private long rflEndTo;
	
	private long grpId;
	
	private String grpName;
	
	private double qty;
	
	private double rate;
}

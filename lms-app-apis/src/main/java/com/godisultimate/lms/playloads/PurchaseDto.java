package com.godisultimate.lms.playloads;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PurchaseDto {

	private long prchId;

	private long memoNo;
	
	private long userId;
	
	private String userCode;
	
	private String userName;
	
	private LocalDate prchDt;
}

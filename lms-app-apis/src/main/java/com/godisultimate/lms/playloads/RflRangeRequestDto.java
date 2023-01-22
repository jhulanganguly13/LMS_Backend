package com.godisultimate.lms.playloads;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RflRangeRequestDto {
	private long rflFrm;
	private long rflTo;
	private long grpId;
	private LocalDate drawDate; 
}

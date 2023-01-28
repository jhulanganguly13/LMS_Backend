package com.godisultimate.lms.services;

import java.util.HashMap;

import com.godisultimate.lms.playloads.AdvanceRequestRequestDto;
import com.godisultimate.lms.playloads.AdvanceReturnDtos;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;

public interface AdvanceReturnServices {
	
//	public HashMap<String, Object> addAdvReturn(AdvanceRequestRequestDto advanceRequestRequestDto) throws ApplicationExceptions, Exception;
	
	HashMap<String, Object> addAdvReturn(AdvanceReturnDtos advanceReturnDtos, long userId) throws ApplicationExceptions, Exception;

	Long getMaxAdvReturnId();

	CustomResponse getRflStkDtlsByMinDate(long raffleId) throws ApplicationExceptions, Exception;

	CustomResponse getRaffleStockByRflIdAndDraw(long raffleId, int draw, String drawDate)
			throws ApplicationExceptions, Exception;

	CustomResponse geGroupByRflIdDrawDrawDateAndRange(long raffleId, int draw, String drawDate, long rflStrFrom,
			long rflEndTo) throws ApplicationExceptions, Exception;

}

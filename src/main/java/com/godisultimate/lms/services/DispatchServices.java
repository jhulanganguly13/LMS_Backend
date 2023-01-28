package com.godisultimate.lms.services;

import java.util.HashMap;

import com.godisultimate.lms.playloads.DispatchDtos;
import com.godisultimate.lms.playloads.DispatchRequestDto;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;

public interface DispatchServices {
	public HashMap<String, Object> addDispatch(DispatchRequestDto dispatchRequestDto) throws ApplicationExceptions, Exception;
	//public List<PurchaseDto> getAllPurchase() throws ApplicationExceptions, Exception;
	//public PurchaseDtos getPurchaseById(Long prchId) throws ApplicationExceptions, Exception;
	//Purchase getPurchase(Long prchId);

	HashMap<String, Object> addDispatch(DispatchDtos dispatchDtos) throws ApplicationExceptions, Exception;

	/*
	 * CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long
	 * grpId) throws ApplicationExceptions, Exception;
	 */

	CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long grpId, String drawDate)
			throws ApplicationExceptions, Exception;

	Long getMaxDispatchId();

	CustomResponse getRflStkDtlsByMinDate(long raffleId) throws ApplicationExceptions, Exception;

	CustomResponse getRaffleStockByRflIdAndDraw(long raffleId, int draw, String drawDate)
			throws ApplicationExceptions, Exception;

	CustomResponse geGroupByRflIdDrawDrawDateAndRange(long raffleId, int draw, String drawDate, long rflStrFrom,
			long rflEndTo) throws ApplicationExceptions, Exception;
}

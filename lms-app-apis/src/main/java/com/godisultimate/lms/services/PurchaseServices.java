package com.godisultimate.lms.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.godisultimate.lms.model.Purchase;
import com.godisultimate.lms.model.PurchaseDetails;
import com.godisultimate.lms.playloads.PurchaseDto;
import com.godisultimate.lms.playloads.PurchaseDtos;
import com.godisultimate.lms.playloads.PurchaseRequestDto;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;

public interface PurchaseServices {
	public HashMap<String, Object> addPurchase(PurchaseRequestDto purchaseRequestDto) throws ApplicationExceptions, Exception;
	//public List<PurchaseDto> getAllPurchase() throws ApplicationExceptions, Exception;
	//public PurchaseDtos getPurchaseById(Long prchId) throws ApplicationExceptions, Exception;
	//Purchase getPurchase(Long prchId);

	HashMap<String, Object> addPurchase(PurchaseDtos purchaseDtos) throws ApplicationExceptions, Exception;

	/*
	 * CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long
	 * grpId) throws ApplicationExceptions, Exception;
	 */

	CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long grpId, String drawDate)
			throws ApplicationExceptions, Exception;

	Long getMaxPurchaseId();
}

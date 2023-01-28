package com.godisultimate.lms.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godisultimate.lms.playloads.GroupDto;
import com.godisultimate.lms.playloads.PurchaseDtos;
import com.godisultimate.lms.playloads.PurchaseRequestDto;
import com.godisultimate.lms.services.PurchaseServicesImpl;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.ApplicationURL;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;
import com.logging.LogExecutionTime;

@RestController
@CrossOrigin("*")
public class PurchaseController {
	@Autowired
	private PurchaseServicesImpl purchaseService;
	
	Logger logger = LoggerFactory.getLogger(PurchaseController.class);

	@LogExecutionTime
	@RequestMapping(method = RequestMethod.POST, value = ApplicationURL.addNewPurchase)
	public CustomResponse saveNewPurchase(
			@RequestBody PurchaseDtos purchaseDtos)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = purchaseService.addPurchase(purchaseDtos);
			meta = new Meta(ApplicationCode.OK, "added successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewPurchase ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewPurchase ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getMaxPurchaseId)
	public Long getMaxId() {
		return purchaseService.getMaxPurchaseId();
	}
	
	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.getPurchaseByPrchId, method = RequestMethod.GET)
	public CustomResponse getPurchaseByPrchId(@RequestParam("prchId") long prchId) throws ApplicationExceptions {
		return purchaseService.getPurchaseByPrchId(prchId);
	}

	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.getPurchaseListBycurrentDate, method = RequestMethod.GET)
	public CustomResponse getPurchaseByPrchId(@RequestParam("prchDt") String prchDt) throws ApplicationExceptions {
		return purchaseService.getPurchaseListByCurrentDate(prchDt);
	}
	
	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.getMemoNoWRTFromToRangeAndGrpId, method = RequestMethod.GET)
	public CustomResponse getMemoNoWRTFromToRangeAndGrpId(@RequestParam("rflFrm") long rflFrm,
			@RequestParam("rflTo") long rflTo, @RequestParam("grpId") long grpId, @RequestParam("drawDate") String drawDate) throws ApplicationExceptions, Exception {
		return purchaseService.getMemoNoWRTFromToRangeAndGrpId(rflFrm, rflTo, grpId, drawDate);
	}
}

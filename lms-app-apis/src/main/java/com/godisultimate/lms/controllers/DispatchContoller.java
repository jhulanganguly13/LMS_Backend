package com.godisultimate.lms.controllers;

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

import com.godisultimate.lms.playloads.DispatchDtos;
import com.godisultimate.lms.playloads.PurchaseDtos;
import com.godisultimate.lms.services.DispatchServicesImpl;
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
public class DispatchContoller {
	@Autowired
	private DispatchServicesImpl dispatchService;
	Logger logger = LoggerFactory.getLogger(DispatchContoller.class);
	
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.POST, value = ApplicationURL.addNewDispatch)
	public CustomResponse saveNewDispatch(
			@RequestBody DispatchDtos dispatchDtos)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = dispatchService.addDispatch(dispatchDtos);
			meta = new Meta(ApplicationCode.OK, "added successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewDispatch ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewDispatch ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.getRflStkDtlsByMinDate, method = RequestMethod.GET)
	public CustomResponse getRflStkDtlsByMinDate(@RequestParam("raffleId") long raffleId) throws ApplicationExceptions, Exception {
		return dispatchService.getRflStkDtlsByMinDate(raffleId);
	}
	
	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.getRaffleStockByRflIdAndDraw, method = RequestMethod.GET)
	public CustomResponse getRaffleStockByRflIdAndDraw(@RequestParam("raffleId") long raffleId, @RequestParam("draw") int draw, @RequestParam("drawDate") String drawDate) throws ApplicationExceptions, Exception {
		return dispatchService.getRaffleStockByRflIdAndDraw(raffleId, draw, drawDate);
	}
	
	@LogExecutionTime
	@RequestMapping(value = ApplicationURL.geGroupByRflIdDrawDrawDateAndRange, method = RequestMethod.GET)
	public CustomResponse geGroupByRflIdDrawDrawDateAndRange(@RequestParam("raffleId") long raffleId, @RequestParam("draw") int draw, @RequestParam("drawDate") String drawDate, @RequestParam("rflStrFrom") long rflStrFrom, @RequestParam("rflEndTo") long rflEndTo) throws ApplicationExceptions, Exception {
		return dispatchService.geGroupByRflIdDrawDrawDateAndRange(raffleId, draw, drawDate, rflStrFrom, rflEndTo);
	}
	
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getMaxDispatchId)
	public Long getMaxId() {
		return dispatchService.getMaxDispatchId();
	}
}

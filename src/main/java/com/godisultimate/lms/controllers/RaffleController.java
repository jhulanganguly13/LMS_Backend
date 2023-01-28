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

import com.godisultimate.lms.playloads.RaffleDto;
import com.godisultimate.lms.services.RaffleServicesImpl;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.ApplicationURL;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;
import com.logging.LogExecutionTime;

@RestController
@CrossOrigin("*")
public class RaffleController {
	
	@Autowired
	private RaffleServicesImpl raffleServicesImpl;
	
	Logger logger = LoggerFactory.getLogger(RaffleController.class);
	
	/**
	 * @author Anupam Das
	 * @throws Exception
	 * @throws ApplicationExceptions
	 * @used to save saveNewRaffle
	 **/
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.POST, value = ApplicationURL.addNewRaffle)
	public CustomResponse saveNewRaffle(
			@RequestBody RaffleDto raffleDto)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = raffleServicesImpl.addRaffle(raffleDto);
			meta = new Meta(ApplicationCode.OK, "added successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewRaffle ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewRaffle ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getRaffleById)
	public CustomResponse getRaffleById(@RequestParam Long raffleId){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("raffle",raffleServicesImpl.getRaffleById(raffleId));
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserById ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserById ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getRaffleByCode)
	public CustomResponse getRaffleByCode(@RequestParam String raffleCode){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("raffle", raffleServicesImpl.getRaffleByCode(raffleCode));
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getRaffleByCode ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getRaffleByCode ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	//Find all Users.
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getAllRaffle)
	public CustomResponse findAllRaffle() throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("raffles",raffleServicesImpl.getAllRaffle());
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllRaffle ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllRaffle ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
}

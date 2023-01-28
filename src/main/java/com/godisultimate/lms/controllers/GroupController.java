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

import com.godisultimate.lms.playloads.GroupDto;
import com.godisultimate.lms.services.GroupServicesImpl;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.ApplicationURL;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;
import com.logging.LogExecutionTime;

@RestController
@CrossOrigin("*")
public class GroupController {
	@Autowired
	private GroupServicesImpl groupServicesImpl;
	
	Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	/**
	 * @author Anupam Das
	 * @throws Exception
	 * @throws ApplicationExceptions
	 * @used to save saveNewGroup
	 **/
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.POST, value = ApplicationURL.addNewGroup)
	public CustomResponse saveNewGroup(
			@RequestBody GroupDto groupDto)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = groupServicesImpl.addGroup(groupDto);
			meta = new Meta(ApplicationCode.OK, "added successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewGroup ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewGroup ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getGroupById)
	public CustomResponse getGroupById(@RequestParam Long groupId){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("group",groupServicesImpl.getGroupById(groupId));
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
	

	//Find all Users.
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getAllGroup)
	public CustomResponse findAllGroup() throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("groups",groupServicesImpl.getAllGroup());
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllGroup ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllGroup ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
}

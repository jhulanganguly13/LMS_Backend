package com.godisultimate.lms.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godisultimate.lms.model.Role;
import com.godisultimate.lms.model.User;
import com.godisultimate.lms.model.UserRole;
import com.godisultimate.lms.playloads.UserDto;
import com.godisultimate.lms.services.UserServicesImpl;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.ApplicationURL;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;
import com.logging.LogExecutionTime;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired 
	UserServicesImpl userServicesImpl;
	
	@Autowired
	ModelMapper mapper;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * @author Anupam Das
	 * @throws Exception
	 * @throws ApplicationExceptions
	 * @used to save saveNewUser
	 **/
	@LogExecutionTime
	@RequestMapping(method = RequestMethod.POST, value = ApplicationURL.addNewUser)
	public CustomResponse saveNewUser(
			@RequestBody UserDto userDto)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			Set<UserRole> userRoles = new HashSet<>();
			Role role = new Role();
			role.setRoleId(45L);
			role.setRoleName("ADMIN");
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			//userRole.setUser(this.mapper.map(userDto, User.class));
			userRoles.add(userRole);
			hashMap = userServicesImpl.addUser(this.mapper.map(userDto, User.class), userRoles);
			meta = new Meta(ApplicationCode.OK, "added successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewUser ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method saveNewUser ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getUserById)
	public CustomResponse getUserById(@RequestParam Long id){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = userServicesImpl.getUserById(id);
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
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getUserByName)
	public CustomResponse getUserByName(@RequestParam String username){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = userServicesImpl.getUserByName(username);
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByName ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByName ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getUserByCode)
	public CustomResponse getUserByCode(@RequestParam String userCode){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("user", userServicesImpl.getUserByCode(userCode));
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByCode ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByCode ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getUsersByIdNotIn)
	public CustomResponse getUserByIdNotIn(@RequestParam long userId){
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap.put("users", userServicesImpl.getUserListByIdNotIn(userId));
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByCode ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method getUserByCode ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
	
	//Find all Users.
	@RequestMapping(method = RequestMethod.GET, value = ApplicationURL.getAllUser)
	public CustomResponse findAllUser() throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			hashMap = userServicesImpl.getAllUsers();
			meta = new Meta(ApplicationCode.OK, "fetch successfully");
		} catch (ApplicationExceptions aE) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllUser ERROR_WHILE_EXECUTION " + aE.getMessage());
			aE.printStackTrace();
			meta = new Meta(ApplicationCode.CANNOT_PROCEED, aE.getMessage());
		} catch (Exception e) {
			logger.info("CHECK TIME=" + LocalDateTime.now() + "\t"
					+ " check method findAllUser ERROR_WHILE_EXECUTION " + e.getMessage());

			e.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap);
	}
}

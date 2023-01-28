package com.godisultimate.lms.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.godisultimate.lms.model.User;
import com.godisultimate.lms.model.UserRole;
import com.godisultimate.lms.playloads.UserDto;
import com.godisultimate.lms.utils.ApplicationExceptions;

public interface UserServices {
	//public HashMap<String, Object> addUser(UserDto userDto) throws ApplicationExceptions, Exception;
	public HashMap<String, Object> getAllUsers() throws ApplicationExceptions, Exception;
	public HashMap<String, Object> getUserById(Long id) throws ApplicationExceptions, Exception;
	public UserDto getUserByCode(String userCode) throws ApplicationExceptions, Exception;
	//public HashMap<String, Object> addUser(UserDto userDto, Set<UserRole> userRoles) throws ApplicationExceptions, Exception;
	public HashMap<String, Object> addUser(User userEntity, Set<UserRole> userRoles) throws ApplicationExceptions, Exception;
	public HashMap<String, Object> getUserByName(String username) throws ApplicationExceptions, Exception;
	List<Map<String, Object>> getUserListByIdNotIn(long userId) throws ApplicationExceptions, Exception;
}

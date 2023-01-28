package com.godisultimate.lms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godisultimate.lms.model.Role;
import com.godisultimate.lms.model.User;
import com.godisultimate.lms.model.UserRole;
import com.godisultimate.lms.playloads.UserDto;
import com.godisultimate.lms.repositories.RoleRepo;
import com.godisultimate.lms.repositories.UserRepo;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private User userEntity1;
	@Override
	public HashMap<String, Object> addUser(User userEntity, Set<UserRole> userRoles) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		if (userEntity.getUsername().trim().equals("")
				|| userEntity.getEmail().trim().equals("")||userEntity.getUserCode().equals("")||userEntity.getPhoneNumber().equals("")) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.user_invalid_parameter);
		}
		User usr = userRepo.findByUsername(userEntity.getUsername());
		if(usr!=null) {
			System.out.println("User already exist!!");
			throw new ApplicationExceptions(ApplicationExceptionMsge.user_already_exist);
		}
		else {
			for(UserRole ur:userRoles) {
				Role rl=roleRepo.findByRoleName(ur.getRole().getRoleName());
				if(rl==null)
					roleRepo.save(ur.getRole());
			}
			System.out.println("UserRoles:: "+userRoles);
			System.out.println("User:: "+userEntity);
			userEntity.getUserRoles().addAll(userRoles);
			userEntity1 = userRepo.save(userEntity);
			hashMap.put("id", userEntity1.getId());
		}
		return hashMap;
	}

	public User DtoToEntity(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto EntityToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public HashMap<String, Object> getAllUsers() throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<User> users = userRepo.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for(User user:users) {
			userDtos.add(this.modelMapper.map(user, UserDto.class));
		}
		hashMap.put("user", userDtos);
		return hashMap;
	}

	@Override
	public HashMap<String, Object> getUserById(Long id) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			User usr=user.get();
			hashMap.put("user", usr);
			return hashMap;
		}
		throw new RuntimeException("User is not found for this user id:: "+id);
	}

	@Override
	public HashMap<String, Object> getUserByName(String username) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		User user = userRepo.findByUsername(username);
		if (user!=null) {
			hashMap.put("user", user);
			return hashMap;
		}
		throw new RuntimeException("User is not found for this user name:: "+username);
	}
	
	@Override
	public UserDto getUserByCode(String userCode) throws ApplicationExceptions, Exception {
		Map<String, Object> user = userRepo.findByUserCode(userCode);
		if (user!=null) {
			return this.modelMapper.map(user, UserDto.class);
		}
		throw new RuntimeException("User is not found for this user code:: "+userCode);
	}
	
	@Override
	public List<Map<String, Object>> getUserListByIdNotIn(long userId) throws ApplicationExceptions, Exception {
		List<Map<String, Object>> userLst = userRepo.findByUserListByIdNotIn(userId);
		if (userLst==null) {
			throw new RuntimeException("User id not exist:: "+userId);
		}
		return userLst;
	}

}

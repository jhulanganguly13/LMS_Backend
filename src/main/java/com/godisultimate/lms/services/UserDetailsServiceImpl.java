package com.godisultimate.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.User;
import com.godisultimate.lms.repositories.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usr = userRepo.findByUsername(username);
		if(usr==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user found!!");
		}
		return usr;
	}

}

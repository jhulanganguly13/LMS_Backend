package com.godisultimate.lms.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authority implements GrantedAuthority{

	private String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}

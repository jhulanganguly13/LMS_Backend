package com.godisultimate.lms.model;

import java.util.Set;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserRole {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	//User
	//@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	//@JoinColumn(name="user_id")
	//private User user;
	
	//Role
	@ManyToOne
	private Role role; 
}

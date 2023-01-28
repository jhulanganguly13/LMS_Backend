package com.godisultimate.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="roles")
public class Role {
	@Id
	private Long roleId;
	private String roleName;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="role")
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}

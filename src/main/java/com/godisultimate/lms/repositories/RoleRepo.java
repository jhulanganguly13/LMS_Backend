package com.godisultimate.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godisultimate.lms.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);

}

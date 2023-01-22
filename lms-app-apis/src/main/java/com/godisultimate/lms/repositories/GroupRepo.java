package com.godisultimate.lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godisultimate.lms.model.Group;

public interface GroupRepo extends JpaRepository<Group, Long> {
	//public List<Group> findByGroups(String groupName);//jpa
}

package com.godisultimate.lms.services;

import java.util.HashMap;
import java.util.List;

import com.godisultimate.lms.playloads.GroupDto;
import com.godisultimate.lms.utils.ApplicationExceptions;

public interface GroupServices {
	public HashMap<String, Object> addGroup(GroupDto groupDto) throws ApplicationExceptions, Exception;
	public List<GroupDto> getAllGroup() throws ApplicationExceptions, Exception;
	public GroupDto getGroupById(Long groupId) throws ApplicationExceptions, Exception;
}

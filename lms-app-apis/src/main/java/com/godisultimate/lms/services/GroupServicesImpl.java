package com.godisultimate.lms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.Group;
import com.godisultimate.lms.model.Raffle;
import com.godisultimate.lms.playloads.GroupDto;
import com.godisultimate.lms.playloads.RaffleDto;
import com.godisultimate.lms.repositories.GroupRepo;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;

@Service
public class GroupServicesImpl implements GroupServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private GroupRepo groupRepo;

	@Autowired
	private Group group;
	@Override
	public HashMap<String, Object> addGroup(GroupDto groupDto) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		group= DtoToEntity(groupDto);
		if (group.getGroupId() > 0 || group.getGroupName().trim().equals("")) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.raffle_invalid_parameter);
		}
		group = groupRepo.save(group);
		hashMap.put("Group Id::", group.getGroupId());
		return hashMap;	
	}

	private Group DtoToEntity(GroupDto groupDto) {
		return this.modelMapper.map(groupDto, Group.class);
	}

	@Override
	public List<GroupDto> getAllGroup() throws ApplicationExceptions, Exception {
		List<Group> groups = groupRepo.findAll();
		List<GroupDto> groupDtos = new ArrayList<GroupDto>();
		groups.forEach(e->groupDtos.add(this.modelMapper.map(e, GroupDto.class)));
		return groupDtos;
	}

	@Override
	public GroupDto getGroupById(Long groupId) throws ApplicationExceptions, Exception {
		return this.modelMapper.map(groupRepo.findById(groupId), GroupDto.class);
	}

}

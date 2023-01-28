package com.godisultimate.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.godisultimate.lms.utils.ApplicationConstant;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="raffle_group")
@Data 
@NoArgsConstructor
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.raffle_group_sequence)
	@SequenceGenerator(name=ApplicationConstant.raffle_group_sequence,sequenceName=ApplicationConstant.raffle_group_sequence,initialValue=1,allocationSize=1)
	private long groupId;
	
	@Column(name = "group_name", nullable = false, unique=true)
	private String groupName;
}

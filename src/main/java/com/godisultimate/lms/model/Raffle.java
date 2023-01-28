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
@Entity
@Table(name="raffle")
@Data
public class Raffle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.raffle_sequence)
	@SequenceGenerator(name=ApplicationConstant.raffle_sequence,sequenceName=ApplicationConstant.raffle_sequence,initialValue=1,allocationSize=1)
	private long raffleId;
	
	@Column(name = "raffle_name", nullable = false, unique=true)
	private String raffleName;
	
	@Column(name = "raffle_code", nullable = false, unique=true)
	private String raffleCode;
	
	private int series;
	
	private String playDay;

}

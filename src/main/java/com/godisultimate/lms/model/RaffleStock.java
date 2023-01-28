package com.godisultimate.lms.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.godisultimate.lms.utils.ApplicationConstant;

import lombok.Data;

@Entity
@Table(name="raffle_stock")
@Data
public class RaffleStock {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.rflStk_sequence)
	@SequenceGenerator(name=ApplicationConstant.rflStk_sequence,sequenceName=ApplicationConstant.rflStk_sequence,initialValue=1,allocationSize=1)
	private long rflStkId;
	
	private long prchId;

	private long userId;

	private long raffleId;

	private int draw;

	private LocalDate drawDate;

	private long rflStrFrom;

	private long rflEndTo;

	private long grpId;

	private double qty;

	private double rate;
}

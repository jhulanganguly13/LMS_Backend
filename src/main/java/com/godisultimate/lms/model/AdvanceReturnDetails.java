package com.godisultimate.lms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.godisultimate.lms.utils.ApplicationConstant;

import lombok.Data;

@Data
@Entity
@Table(name="advance_return_dtls")
public class AdvanceReturnDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.adv_return_dtls_sequence)
	@SequenceGenerator(name=ApplicationConstant.adv_return_dtls_sequence,sequenceName=ApplicationConstant.adv_return_dtls_sequence,initialValue=1,allocationSize=1)
	private long advanceReturnDtlsId;
	
	@Column(name="advReturn_Id")
	private long advReturnId;
	
	private long raffleId;
	
	private long userId;
	
	private int draw;
	
	private LocalDate drawDate;//draw_date
	
	private long rflStrFrom;
	
	private long rflEndTo;
	
	private long grpId;
	
	private double qty;
	
	private double rate;

}

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

@Entity
@Table(name="dsph_dtls")
@Data
public class DispatchDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.dsph_dtls_sequence)
	@SequenceGenerator(name=ApplicationConstant.dsph_dtls_sequence,sequenceName=ApplicationConstant.dsph_dtls_sequence,initialValue=1,allocationSize=1)
	private long dsphDtlsId;
	
	@Column(name="dsph_id")
	private long dsphId;
	
	private long raffleId;
	
	private int draw;
	
	
	private LocalDate drawDate;//draw_date
	
	private long rflStrFrom;
	
	private long rflEndTo;
	
	private long grpId;
	
	private double qty;
	
	private double rate;
	
}

package com.godisultimate.lms.model;

import java.io.Serializable;
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
@Table(name="prch_dtls")
@Data
public class PurchaseDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.prch_dtls_sequence)
	@SequenceGenerator(name=ApplicationConstant.prch_dtls_sequence,sequenceName=ApplicationConstant.prch_dtls_sequence,initialValue=1,allocationSize=1)
	private long prchDtlsId;
	@Column(name="prch_id")
	private long prchId;
	private long raffleId;
	private int draw;
	private LocalDate drawDate;
	private long rflStrFrom;
	
	private long rflEndTo;
	
	private long grpId;
	
	private double qty;
	
	private double rate;
	
}

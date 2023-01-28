package com.godisultimate.lms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.godisultimate.lms.utils.ApplicationConstant;

import lombok.Data;

@Data
@Entity
@Table(name="advance_return")
public class AdvanceReturn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.adv_return_sequence)
	@SequenceGenerator(name=ApplicationConstant.adv_return_sequence,sequenceName=ApplicationConstant.adv_return_sequence,initialValue=1,allocationSize=1)
	@Column(name="advReturn_Id", nullable=false)
	private long advReturnId;//This is Memo No

	@Column(name="memo_no", nullable=false)
	private long memoNo;
	
	private long userId;//Debitor Id
	
	private LocalDate advReturnDate;
	
	@OneToMany(targetEntity=AdvanceReturnDetails.class, cascade=CascadeType.ALL )
	@JoinColumn(name="advReturn_Id", referencedColumnName = "advReturn_Id")
	private List<AdvanceReturnDetails> advanceReturnDetailsList = new ArrayList<>();
	
}

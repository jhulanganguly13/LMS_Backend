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

@Entity
@Table(name="prch")
@Data
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.prch_sequence)
	@SequenceGenerator(name=ApplicationConstant.prch_sequence,sequenceName=ApplicationConstant.prch_sequence,initialValue=1,allocationSize=1)
	@Column(name="prch_id", nullable=false)
	private long prchId;//This is Memo No
	
	@Column(name="memo_no", nullable=false)
	private long memoNo;//NOW IT IS USELESS
	
	private long userId;
	
	private LocalDate prchDt;
	
	@OneToMany(targetEntity=PurchaseDetails.class, cascade=CascadeType.ALL )
	@JoinColumn(name="prch_id", referencedColumnName = "prch_id")
	private List<PurchaseDetails> purchaseDetailsList = new ArrayList<>();
}

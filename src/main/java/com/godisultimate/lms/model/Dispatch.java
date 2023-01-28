package com.godisultimate.lms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.godisultimate.lms.utils.ApplicationConstant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dsph")
public class Dispatch {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=ApplicationConstant.dsph_sequence)
	@SequenceGenerator(name=ApplicationConstant.dsph_sequence,sequenceName=ApplicationConstant.dsph_sequence,initialValue=1,allocationSize=1)
	@Column(name="dsph_id", nullable=false)
	private long dsphId;//This is Memo No
	
	@Column(name="memo_no", nullable=false)
	private long memoNo;
	
	private long userId;//Debitor Id
	
	private LocalDate dsphDt;
	
	@OneToMany(targetEntity=DispatchDetails.class, cascade=CascadeType.ALL )
	@JoinColumn(name="dsph_id", referencedColumnName = "dsph_id")
	private List<DispatchDetails> dispatchDetailsList = new ArrayList<>();
	
}

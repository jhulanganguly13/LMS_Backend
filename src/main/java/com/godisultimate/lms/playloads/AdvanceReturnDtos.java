package com.godisultimate.lms.playloads;

import java.util.ArrayList;
import java.util.List;

import com.godisultimate.lms.model.AdvanceReturn;
import com.godisultimate.lms.model.AdvanceReturnDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceReturnDtos {
	
	private AdvanceReturn advanceReturn=new AdvanceReturn();
	private List<AdvanceReturnDetails> advanceReturnDtlsLst =new ArrayList<AdvanceReturnDetails>();

}

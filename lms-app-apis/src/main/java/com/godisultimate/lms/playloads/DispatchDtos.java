package com.godisultimate.lms.playloads;

import java.util.ArrayList;
import java.util.List;

import com.godisultimate.lms.model.Dispatch;
import com.godisultimate.lms.model.DispatchDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispatchDtos {
	private Dispatch dsph=new Dispatch();
	private List<DispatchDetails> dsphDtlsLst =new ArrayList<DispatchDetails>();
}

package com.godisultimate.lms.playloads;

import java.util.ArrayList;
import java.util.List;

import com.godisultimate.lms.model.Purchase;
import com.godisultimate.lms.model.PurchaseDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDtos {
	private Purchase prch=new Purchase();
	private List<PurchaseDetails> prchDtlsLst =new ArrayList<PurchaseDetails>();
}

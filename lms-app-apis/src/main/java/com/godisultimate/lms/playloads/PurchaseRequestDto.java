package com.godisultimate.lms.playloads;

import org.springframework.beans.factory.annotation.Autowired;

import com.godisultimate.lms.model.Purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequestDto {
	@Autowired
	private Purchase purchase;
}

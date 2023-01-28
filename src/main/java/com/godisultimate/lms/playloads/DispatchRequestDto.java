package com.godisultimate.lms.playloads;

import org.springframework.beans.factory.annotation.Autowired;

import com.godisultimate.lms.model.Dispatch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DispatchRequestDto {
	@Autowired
	private Dispatch dispatch;
}

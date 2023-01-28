package com.godisultimate.lms.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.godisultimate.lms.model.AdvanceReturnDetails;

public interface AdvanceReturnDetailsRepo extends JpaRepository<AdvanceReturnDetails, Long> {
	
	
}

package com.godisultimate.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.godisultimate.lms.model.AdvanceReturn;

public interface AdvanceReturnRepo extends JpaRepository<AdvanceReturn, Long> {
	
	@Query(value="select max(advReturn_Id) as advReturnId from advance_return", nativeQuery = true)
	public Long getMaxAdvanceReturnId();

}

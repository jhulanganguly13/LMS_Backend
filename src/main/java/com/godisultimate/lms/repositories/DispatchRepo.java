package com.godisultimate.lms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.godisultimate.lms.model.Dispatch;

public interface DispatchRepo extends JpaRepository<Dispatch, Long> {
	
	@Query(value="select max(dsph_id) as dsphId from dsph", nativeQuery = true)
	public Long getMaxDispatchId();
	
}

package com.godisultimate.lms.repositories;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.godisultimate.lms.model.Purchase;
import com.godisultimate.lms.playloads.PurchaseDto;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {

	//"select pr.prch_id as prchId, pr.memo_no as memoNo, pr.user_id as id, u.user_code as userCode, u.user_name as userName, prchDt from prch pr inner join user u on pr.user_id=u.user_id where pr.prch_id=:prchId"
	
	  @Query(value="select pr.prch_id as prchId, pr.memo_no as memoNo, pr.user_id as id,"
	  		+ " u.user_code as userCode, u.username as username, pr.prch_dt as prchDt from prch pr inner join"
	  		+ " users u on pr.user_id=u.id where pr.prch_id=:prchId", nativeQuery = true)
	  public Map<String, Object> getPurchaseByPrchId(@Param("prchId") long prchId);
	  
	  @Query(value="select pr.prch_id as prchId, pr.memo_no as memoNo, pr.user_id as id,"
	  		+ " u.user_code as userCode, u.username as username, pr.prch_dt as prchDt from prch pr inner join"
	  		+ " users u on pr.user_id=u.id where pr.memo_no=:memoNo", nativeQuery = true)
	  public Map<String, Object> getPurchaseByMemoNo(@Param("memoNo") long memoNo);
	
	  @Query(value="select max(prch_id) as prchId from prch", nativeQuery = true)
	  public Long getMaxPurchaseId();

}

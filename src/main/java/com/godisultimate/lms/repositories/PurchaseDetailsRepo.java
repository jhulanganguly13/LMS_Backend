package com.godisultimate.lms.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.godisultimate.lms.model.PurchaseDetails;
import com.godisultimate.lms.playloads.PurchaseDetailsDto;

@Repository
public interface PurchaseDetailsRepo extends JpaRepository<PurchaseDetails, Long> {
	//public static final String select_r_from_Raffle_r_where = "select r from Raffle r where ";

	///**prchDtlsId, prchId, raffleId, raffleCode, raffleName, draw, drawDate, rflStrFrom, rflEndTo, grpId, grpName, qty, rate;**/
	///**prch_dtls_id, draw, draw_date, grp_id, prch_id, qty, raffle_id, rate, rfl_end_to, rfl_str_from**/
	@Query(value="SELECT prdtl.prch_dtls_id as prchDtlsId, prdtl.prch_id as prchId,"
			+ "prdtl.raffle_id as raffleId, R.raffle_code as raffleCode,"
			+ "R.raffle_name as raffleName, prdtl.draw as draw, prdtl.draw_date as drawDate,"
			+ "prdtl.rfl_str_from as rflStrFrom, prdtl.rfl_end_to as rflEndTo,"
			+ "prdtl.grp_id as grpId, RFLGRP.group_name as grpName, prdtl.qty as qty, prdtl.rate as rate"
			+ " FROM PRCH_DTLS prdtl INNER JOIN RAFFLE R"
			+ " ON R.RAFFLE_ID=prdtl.RAFFLE_ID INNER JOIN RAFFLE_GROUP RFLGRP"
			+ " ON RFLGRP.GROUP_ID=prdtl.GRP_ID WHERE prdtl.PRCH_ID=:prchId", nativeQuery = true)//sql....
	public List<Map<String, Object>> getPurchaseDetailsByPrchId(@Param("prchId") long prchId);

	@Query(value="SELECT PRCHDTL.prch_dtls_id as prchDtlsId, PRCHDTL.prch_id as prchId, U.USERNAME AS username,"
			+ "PRCHDTL.raffle_id as raffleId, R.raffle_code as raffleCode,"
			+ "R.raffle_name as raffleName, PRCHDTL.draw as draw, PRCHDTL.draw_date as drawDate,"
			+ "PRCHDTL.rfl_str_from as rflStrFrom, PRCHDTL.rfl_end_to as rflEndTo,"
			+ "PRCHDTL.grp_id as grpId, RFLGRP.group_name as groupName, PRCHDTL.qty as qty, PRCHDTL.rate as rate"
			+ " FROM PRCH_DTLS PRCHDTL INNER JOIN RAFFLE R"
			+ " ON R.RAFFLE_ID=PRCHDTL.RAFFLE_ID INNER JOIN RAFFLE_GROUP RFLGRP"
			+ " ON RFLGRP.GROUP_ID=PRCHDTL.GRP_ID  INNER JOIN PRCH PR"
			+ " ON PR.PRCH_ID = PRCHDTL.PRCH_ID INNER JOIN USERS U"
			+ " ON U.ID = PR.USER_ID"
			+ " WHERE PR.PRCH_DT=date(:prchDt)", nativeQuery = true)//sql....
	public List<Map<String, Object>> getAllPurchaseListByCurrentDate(@Param("prchDt") String prchDt);
	
	@Query("SELECT PD FROM PurchaseDetails PD WHERE PD.rflStrFrom <= :rflFrm AND PD.rflEndTo >= :rflTo AND PD.grpId = :grpId AND PD.drawDate = date(:drawDate)")//hql..
	public Optional<PurchaseDetails> getMemoNoWRTFromToRangeGrpIdAndDrawDate(@Param("rflFrm") long rflFrm, @Param("rflTo") long rflTo, @Param("grpId") long grpId, @Param("drawDate") String drawDate);

	
}

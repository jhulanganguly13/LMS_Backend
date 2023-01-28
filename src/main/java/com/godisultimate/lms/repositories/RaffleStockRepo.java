package com.godisultimate.lms.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.godisultimate.lms.model.Group;
import com.godisultimate.lms.model.RaffleStock;

@Repository
public interface RaffleStockRepo extends JpaRepository<RaffleStock, Long> {
	
	@Query(value="select * from raffle_stock rs where rs.draw_date = date(:drawDate) && rs.raffle_id = :raffleId && rs.draw = :draw && rs.grp_id = :grpId && rs.rfl_str_from <= :rflStrFrom AND rs.rfl_end_to >= :rflEndTo", nativeQuery = true)
	Optional<RaffleStock> getRflStkByRange(long raffleId, int draw, LocalDate drawDate, long grpId, long rflStrFrom,
			long rflEndTo);

	@Query(value="select * from raffle_stock rs where rs.draw_date = (select min(draw_date) from raffle_stock where qty>0 && raffle_id = :raffleId)", nativeQuery = true)
	public Optional<RaffleStock> getRflStkDtlsByMinDate(@Param("raffleId") long raffleId);
	
	@Query(value="select rg.group_name as groupName, rs.rfl_end_to as rflEndTo, rs.rfl_str_from as rflStrFrom, rs.qty as qty from raffle_stock rs inner join raffle_group rg on rs.grp_id = rg.group_id where rs.draw_date = date(:drawDate) && rs.raffle_id = :raffleId && rs.draw = :draw", nativeQuery = true)
	public List<Map<String, Object>> getRaffleStockByRflIdAndDraw(@Param("raffleId") long raffleId, int draw, String drawDate);
	
	@Query(value="select rg.group_id as groupId, rg.group_name as groupName from raffle_stock rs inner join raffle_group rg on rs.grp_id = rg.group_id where rs.draw_date = date(:drawDate) && rs.raffle_id = :raffleId && rs.draw = :draw && rs.rfl_str_from <= :rflStrFrom AND rs.rfl_end_to >= :rflEndTo", nativeQuery = true)
	public List<Map<String, Object>> geGroupByRflIdDrawDrawDateAndRange(@Param("raffleId") long raffleId, int draw, String drawDate, long rflStrFrom, long rflEndTo);

	@Query(value="SELECT * FROM raffle_stock RS"
			+"Where RS.user_id=:userId AND RS.rfl_str_from <= :rflStrFrom AND RS.rfl_end_to >= :rflEndTo AND RS.draw_date = date(:drawDate) AND RS.grp_id= :grpId ", nativeQuery = true)
	public Optional<RaffleStock> getStkDtlsByUsrIdFrmToRng(@Param("userId") long userId, @Param("rflStrFrom") long rflStrFrom, @Param("rflEndTo") long rflEndTo, @Param("drawDate") String drawDate, @Param("grpId") long grpId);
	
}

package com.godisultimate.lms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.AdvanceReturn;
import com.godisultimate.lms.model.RaffleStock;
import com.godisultimate.lms.playloads.AdvanceReturnDtos;
import com.godisultimate.lms.repositories.AdvanceReturnDetailsRepo;
import com.godisultimate.lms.repositories.AdvanceReturnRepo;
import com.godisultimate.lms.repositories.RaffleStockRepo;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;

@Service
public class AdvanceReturnServicesImpl implements AdvanceReturnServices {

	@Autowired
	private AdvanceReturnRepo advanceReturnRepo;
	@Autowired
	private AdvanceReturnDetailsRepo advanceReturnDetailsRepo;
	@Autowired
	private RaffleStockRepo raffleStockRepo;
	@Autowired
	private AdvanceReturn advanceReturn;

	@Override
	public HashMap<String, Object> addAdvReturn(AdvanceReturnDtos advanceReturnDtos, long userId)
			throws ApplicationExceptions, Exception {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<RaffleStock> rflStksForDeb = new ArrayList<RaffleStock>();
		List<RaffleStock> rflStksForCre = new ArrayList<RaffleStock>();
		advanceReturn = advanceReturnRepo.save(advanceReturnDtos.getAdvanceReturn());

		if (advanceReturn == null || advanceReturn.getAdvReturnId() <= 0) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.advance_return_invalid_parameter);
		} else {
			advanceReturnDtos.getAdvanceReturnDtlsLst().forEach(e -> {
				Optional<RaffleStock> rflStkForDebitor =  raffleStockRepo.getStkDtlsByUsrIdFrmToRng(e.getUserId(), e.getRflStrFrom(), e.getRflEndTo(), e.getDrawDate().toString(), e.getGrpId());
				Optional<RaffleStock> rflStkForCreditor = raffleStockRepo.getStkDtlsByUsrIdFrmToRng(userId, e.getRflStrFrom(), e.getRflEndTo(), e.getDrawDate().toString(), e.getGrpId());
				
				if(rflStkForDebitor.get()!=null) {
					rflStkForDebitor.get().setQty(rflStkForDebitor.get().getQty() - e.getQty());
					rflStksForDeb.add(rflStkForDebitor.get());
				}else {
					rflStksForCre.add(rflStkForDebitor.get());
				}

				if(rflStkForCreditor.get()!=null) {
					rflStkForCreditor.get().setQty(rflStkForCreditor.get().getQty() - e.getQty());
				}else {
					throw new RuntimeException("No data found");
					//throw new ApplicationExceptions(ApplicationExceptionMsge.No_data_found);
				}	
				
			});
			advanceReturnDetailsRepo.saveAll(advanceReturnDtos.getAdvanceReturnDtlsLst());
			raffleStockRepo.saveAll(rflStksForDeb);
			raffleStockRepo.saveAll(rflStksForCre);

		} 
		hashMap.put("advReturnId", advanceReturn.getAdvReturnId());
		return hashMap;
	}		

	@Override
	public Long getMaxAdvReturnId() {
		Long id = null;
		try {
			id = advanceReturnRepo.getMaxAdvanceReturnId();
			if (id == null) {
				return 0L;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return id;
	}

	@Override
	public CustomResponse getRflStkDtlsByMinDate(long raffleId) throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
			Optional<RaffleStock> rflStk = raffleStockRepo.getRflStkDtlsByMinDate(raffleId);
			if (rflStk.isPresent()) {
				meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
				hashMap1.put("raffleStock", rflStk.get());
				return new CustomResponse(meta, hashMap1);
			}
			throw new ApplicationExceptions("Stock is not found against raffleId");
		} catch (ApplicationExceptions applicationExceptions) {
			applicationExceptions.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

		} catch (Exception exception) {
			exception.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap1);
	}

	@Override
	public CustomResponse getRaffleStockByRflIdAndDraw(long raffleId, int draw, String drawDate)
			throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> rflStk = raffleStockRepo.getRaffleStockByRflIdAndDraw(raffleId, draw, drawDate);
			if (rflStk != null && rflStk.size() > 0) {
				meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
				hashMap1.put("raffleStockList", rflStk);
				return new CustomResponse(meta, hashMap1);
			}
			throw new ApplicationExceptions("No Stocks are found against raffleId, draw and drawDate");
		} catch (ApplicationExceptions applicationExceptions) {
			applicationExceptions.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

		} catch (Exception exception) {
			exception.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap1);
	}

	@Override
	public CustomResponse geGroupByRflIdDrawDrawDateAndRange(long raffleId, int draw, String drawDate, long rflStrFrom,
			long rflEndTo) throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> rflStk = raffleStockRepo.geGroupByRflIdDrawDrawDateAndRange(raffleId, draw,
					drawDate, rflStrFrom, rflEndTo);
			if (rflStk != null && rflStk.size() > 0) {
				meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
				hashMap1.put("groupList", rflStk);
				return new CustomResponse(meta, hashMap1);
			}
			throw new ApplicationExceptions("No groups are found against raffleId, draw, drawDate and range");
		} catch (ApplicationExceptions applicationExceptions) {
			applicationExceptions.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

		} catch (Exception exception) {
			exception.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}
		return new CustomResponse(meta, hashMap1);
	}

}

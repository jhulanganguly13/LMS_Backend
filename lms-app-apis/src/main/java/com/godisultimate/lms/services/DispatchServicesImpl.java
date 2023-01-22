package com.godisultimate.lms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.Dispatch;
import com.godisultimate.lms.model.DispatchDetails;
import com.godisultimate.lms.model.Group;
import com.godisultimate.lms.model.PurchaseDetails;
import com.godisultimate.lms.model.RaffleStock;
import com.godisultimate.lms.playloads.DispatchDtos;
import com.godisultimate.lms.playloads.DispatchRequestDto;
import com.godisultimate.lms.repositories.DispatchDetailsRepo;
import com.godisultimate.lms.repositories.DispatchRepo;
import com.godisultimate.lms.repositories.RaffleStockRepo;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;

@Service
public class DispatchServicesImpl implements DispatchServices{

	@Autowired
	private DispatchRepo dispatchRepo;
	
	@Autowired
	private DispatchDetailsRepo dispatchDetailsRepo;
	
	@Autowired
	private RaffleStockRepo raffleStockRepo;
	
	@Autowired
	private Dispatch dispatch;
	

	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public HashMap<String, Object> addDispatch(DispatchRequestDto dispatchRequestDto)
			throws ApplicationExceptions, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> addDispatch(DispatchDtos dispatchDtos) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<RaffleStock> rflStks = new ArrayList<RaffleStock>();
		/*
		 * userEntity= DtoToEntity(userDto); if (userEntity.getUserId() > 0 ||
		 * userEntity.getUserName().trim().equals("") ||
		 * userEntity.getEmail().trim().equals("")) { throw new
		 * ApplicationExceptions(ApplicationExceptionMsge.user_invalid_parameter); }
		 */
		dispatch = dispatchRepo.save(dispatchDtos.getDsph());
	
		if(dispatch==null||dispatch.getDsphId()<=0) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.dispatch_invalid_parameter); 
		}
		else {
			List<DispatchDetails> dispatchDetailsLst=dispatchDtos.getDsphDtlsLst();
			dispatchDetailsLst.forEach( e->{
				e.setDsphId(dispatch.getDsphId());
			Optional<RaffleStock> rflStk = raffleStockRepo.getRflStkByRange(e.getRaffleId(), e.getDraw(), e.getDrawDate(), e.getGrpId(), e.getRflStrFrom(), e.getRflEndTo());
				if(rflStk.get()!=null) {
					rflStk.get().setQty((rflStk.get().getQty()-e.getQty()));//Here stock is updated..
					rflStks.add(rflStk.get());
				}
			});
			dispatchDetailsRepo.saveAll(dispatchDtos.getDsphDtlsLst());
			raffleStockRepo.saveAll(rflStks);
			//purchaseDetails=(PurchaseDetails) purchaseDetailsRepo.saveAll(purchaseDtos.getPrchDtlsLst());
		}
		hashMap.put("dsphId", dispatch.getDsphId());
		return hashMap;
	}

	@Override
	public Long getMaxDispatchId() {
		Long id = null;
		try {
		id = dispatchRepo.getMaxDispatchId();
		if(id==null) {
			return 0L;
		}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return id;
	}

	@Override
	public CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long grpId, String drawDate)
			throws ApplicationExceptions, Exception {
		// TODO Auto-generated method stub
		return null;
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
	}catch (ApplicationExceptions applicationExceptions) {
		applicationExceptions.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

	} catch (Exception exception) {
		exception.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
	}
		return new CustomResponse(meta, hashMap1);
	}
	
	@Override
	public CustomResponse getRaffleStockByRflIdAndDraw(long raffleId, int draw, String drawDate) throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
		List<Map<String, Object>> rflStk = raffleStockRepo.getRaffleStockByRflIdAndDraw(raffleId, draw, drawDate);
		if (rflStk!=null&&rflStk.size()>0) {
			meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
			hashMap1.put("raffleStockList", rflStk);
			return new CustomResponse(meta, hashMap1);
		}
		throw new ApplicationExceptions("No Stocks are found against raffleId, draw and drawDate");
	}catch (ApplicationExceptions applicationExceptions) {
		applicationExceptions.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

	} catch (Exception exception) {
		exception.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
	}
		return new CustomResponse(meta, hashMap1);
	}
	
	@Override
	public CustomResponse geGroupByRflIdDrawDrawDateAndRange(long raffleId, int draw, String drawDate, long rflStrFrom, long rflEndTo) throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
		List<Map<String, Object>> rflStk = raffleStockRepo.geGroupByRflIdDrawDrawDateAndRange(raffleId, draw, drawDate, rflStrFrom, rflEndTo);
		if (rflStk!=null&&rflStk.size()>0) {
			meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
			hashMap1.put("groupList", rflStk);
			return new CustomResponse(meta, hashMap1);
		}
		throw new ApplicationExceptions("No groups are found against raffleId, draw, drawDate and range");
	}catch (ApplicationExceptions applicationExceptions) {
		applicationExceptions.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

	} catch (Exception exception) {
		exception.printStackTrace();
		meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
	}
		return new CustomResponse(meta, hashMap1);
	}
}

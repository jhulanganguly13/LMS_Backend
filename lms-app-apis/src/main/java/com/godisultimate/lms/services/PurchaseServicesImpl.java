package com.godisultimate.lms.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.godisultimate.lms.model.Purchase;
import com.godisultimate.lms.model.PurchaseDetails;
import com.godisultimate.lms.model.RaffleStock;
import com.godisultimate.lms.model.User;
import com.godisultimate.lms.playloads.PurchaseDetailsDto;
import com.godisultimate.lms.playloads.PurchaseDto;
import com.godisultimate.lms.playloads.PurchaseDtos;
import com.godisultimate.lms.playloads.PurchaseRequestDto;
import com.godisultimate.lms.playloads.UserDto;
import com.godisultimate.lms.repositories.PurchaseDetailsRepo;
import com.godisultimate.lms.repositories.PurchaseRepo;
import com.godisultimate.lms.repositories.RaffleStockRepo;
import com.godisultimate.lms.utils.ApplicationCode;
import com.godisultimate.lms.utils.ApplicationExceptionMsge;
import com.godisultimate.lms.utils.ApplicationExceptions;
import com.godisultimate.lms.utils.CustomResponse;
import com.godisultimate.lms.utils.Meta;

@Service
public class PurchaseServicesImpl implements PurchaseServices{

	@Autowired
	private PurchaseRepo purchaseRepo;
	
	@Autowired
	private PurchaseDetailsRepo purchaseDetailsRepo;
	
	@Autowired
	private RaffleStockRepo raffleStockRepo;
	
	@Autowired
	private Purchase purchase;
	

	
	@Autowired
	private ModelMapper mapper;
	
	//@Autowired
	//private PurchaseDetails purchaseDetails;
	
	//@Autowired
	//private PurchaseDtos purchaseDtos;
	@Override
	public HashMap<String, Object> addPurchase(PurchaseRequestDto purchaseRequestDto)
			throws ApplicationExceptions, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> addPurchase(PurchaseDtos purchaseDtos) throws ApplicationExceptions, Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<RaffleStock> rflStks = new ArrayList<RaffleStock>();
		/*
		 * userEntity= DtoToEntity(userDto); if (userEntity.getUserId() > 0 ||
		 * userEntity.getUserName().trim().equals("") ||
		 * userEntity.getEmail().trim().equals("")) { throw new
		 * ApplicationExceptions(ApplicationExceptionMsge.user_invalid_parameter); }
		 */
		purchase = purchaseRepo.save(purchaseDtos.getPrch());
	
		if(purchase==null||purchase.getPrchId()<=0) {
			throw new ApplicationExceptions(ApplicationExceptionMsge.purchase_invalid_parameter); 
		}
		else {		
			
			//List<PurchaseDetails> purchaseDetailsLst=purchaseDtos.getPrchDtlsLst();
			purchaseDtos.getPrchDtlsLst().forEach( e->{
				RaffleStock rflStk=new RaffleStock();
				e.setPrchId(purchase.getPrchId());
				rflStk.setDraw(e.getDraw());
				rflStk.setDrawDate(e.getDrawDate());
				rflStk.setGrpId(e.getGrpId());
				rflStk.setPrchId(e.getPrchId());
				rflStk.setQty(e.getQty());
				rflStk.setRaffleId(e.getRaffleId());
				rflStk.setRate(e.getRate());
				rflStk.setRflEndTo(e.getRflEndTo());
				rflStk.setRflStrFrom(e.getRflStrFrom());
				rflStk.setPrchId(purchase.getPrchId());
				rflStk.setUserId(purchase.getUserId());
				rflStks.add(rflStk);
			});
			purchaseDetailsRepo.saveAll(purchaseDtos.getPrchDtlsLst());
			raffleStockRepo.saveAll(rflStks);
			//purchaseDetails=(PurchaseDetails) purchaseDetailsRepo.saveAll(purchaseDtos.getPrchDtlsLst());
		}
		hashMap.put("prchId", purchase.getPrchId());
		return hashMap;
	}

	/*
	 * //To Find purchase history for particular Memo no.
	 * 
	 * @Override public Purchase getPurchase(Long prchId) {
	 * purchaseDtos.setPrchDto(purchaseRepo.getPurchaseByPrchId(0, null));
	 * purchaseDtos.setPrchDtlsLst(null); }
	 */

	public CustomResponse getPurchaseByPrchId(
			long prchId) throws ApplicationExceptions {
		Meta meta = null;
		List<Map<String, Object>> page = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		try {
			List<Map<String, Object>> map = new ArrayList<>();
			if (prchId <= 0) {
				throw new ApplicationExceptions(ApplicationExceptionMsge.purchase_id_invalid_parameter);
			}
			Map<String, Object> purchase = purchaseRepo.getPurchaseByPrchId(prchId);
			page = purchaseDetailsRepo.getPurchaseDetailsByPrchId(prchId);
			
			
			if (page == null || page.isEmpty()||purchase==null) {
				throw new ApplicationExceptions(ApplicationExceptionMsge.No_data_found);
			}
//			map = (List<Map<String, Object>>) page.get();
			
			hashMap1.put("prchDtlsLst", page);
		
			hashMap1.put("prch", purchase);
			
			//hashMap1.put("prch", this.mapper.map(purchase.get(), PurchaseDto.class));
			
//			hashMap1.put("numberOfElements", page.getNumberOfElements());

//			hashMap1.put("totalPages", page.getTotalPages());

//			hashMap1.put("totalElements", page.getTotalElements());

//			hashMap1.put("hasNext", page.hasNext());

//			hashMap1.put("hasPrevious", page.hasPrevious());

//			hashMap1.put("isFirst", page.isFirst());

//			hashMap1.put("isLast", page.isLast());
			meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
		} catch (ApplicationExceptions applicationExceptions) {
			applicationExceptions.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, applicationExceptions.getMessage());

		} catch (Exception exception) {
			exception.printStackTrace();
			meta = new Meta(ApplicationCode.ERROR_WHILE_EXECUTION, ApplicationExceptionMsge.ERROR_WHILE_EXECUTION);
		}

		return new CustomResponse(meta, hashMap1);
	}

	public CustomResponse getPurchaseListByCurrentDate(
			String prchDt) throws ApplicationExceptions {
		Meta meta = null;
		List<Map<String, Object>> page = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		try {
			List<Map<String, Object>> map = new ArrayList<>();
			if (prchDt =="" || prchDt == null) {
				throw new ApplicationExceptions(ApplicationExceptionMsge.purchase_date_invalid_parameter);
			}
//			Map<String, Object> purchase = purchaseRepo.getPurchaseByPrchId(prchId);
			page = purchaseDetailsRepo.getAllPurchaseListByCurrentDate(prchDt);
			
			
			if (page == null || page.isEmpty()||purchase==null) {
				throw new ApplicationExceptions(ApplicationExceptionMsge.No_data_found);
			}
//			map = page.getContent();
			
			hashMap1.put("purchaseList", page);
		
//			hashMap1.put("prch", purchase);
			
			//hashMap1.put("prch", this.mapper.map(purchase.get(), PurchaseDto.class));
			
//			hashMap1.put("numberOfElements", page.getNumberOfElements());

//			hashMap1.put("totalPages", page.getTotalPages());

//			hashMap1.put("totalElements", page.getTotalElements());
//
//			hashMap1.put("hasNext", page.hasNext());
//
//			hashMap1.put("hasPrevious", page.hasPrevious());
//
//			hashMap1.put("isFirst", page.isFirst());
//
//			hashMap1.put("isLast", page.isLast());
			meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
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
	public CustomResponse getMemoNoWRTFromToRangeAndGrpId(long rflFrm, long rflTo, long grpId, String drawDate) throws ApplicationExceptions, Exception {
		Meta meta = null;
		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		try {
		Optional<PurchaseDetails> purchaseDetails = purchaseDetailsRepo.getMemoNoWRTFromToRangeGrpIdAndDrawDate(rflFrm, rflTo, grpId, drawDate);
		if (purchaseDetails.isPresent()) {
			meta = new Meta(ApplicationCode.OK, ApplicationExceptionMsge.Information_fetch_successfully);
			hashMap1.put("purchaseDetails", purchaseDetails.get());
			return new CustomResponse(meta, hashMap1);
		}
		throw new ApplicationExceptions("Range is not present");
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
	public Long getMaxPurchaseId() {
		Long id = null;
		try {
		id = purchaseRepo.getMaxPurchaseId();
		if(id==null) {
			return 0L;
		}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return id;
	}

}

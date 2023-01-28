package com.godisultimate.lms.utils;

/**
 * @author Anupam Das Class is used to maintain all URL used in application.
 *         It will helpful for modification. Also maintaining URL versions.
 **/
public final class ApplicationURL {

	// PRIVATE //
	/**
	 * The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, and
	 * so on. Thus, the caller should be prevented from constructing objects of this
	 * class, by declaring this private constructor.
	 */
	private ApplicationURL() {
		// this prevents even the native class from
		// calling this ctor as well :
		throw new AssertionError();
	}


	public static final String addNewUser = "addNewUser";
	public static final String getUserById = "getUserById";
	public static final String getAllUser = "getAllUser";
	public static final String getUserByCode = "getUserByCode";
	public static final String addNewRaffle = "addNewRaffle";
	public static final String getRaffleById = "getRaffleById";
	public static final String getRaffleByCode = "getRaffleByCode";
	public static final String getAllRaffle = "getAllRaffle";
	public static final String getAllGroup = "getAllGroup";
	public static final String getGroupById = "getGroupById";
	public static final String addNewGroup = "addNewGroup";
	public static final String addNewPurchase = "addNewPurchase";
	public static final String getPurchaseByPrchId = "getPurchaseByPrchId";
	public static final String getMemoNoWRTFromToRangeAndGrpId = "getMemoNoWRTFromToRangeAndGrpId";
	public static final String getUserByName = "getUserByName";
	public static final String currentUser = "current_user";
	public static final String getUsersByIdNotIn = "getUsersByIdNotIn";
	public static final String getMaxPurchaseId = "getMaxPurchaseId";
	public static final String getPurchaseListBycurrentDate = "getPurchaseListBycurrentDate";
	public static final String getRflStkDtlsByMinDate = "getRflStkDtlsByMinDate";
	public static final String getRaffleStockByRflIdAndDraw = "getRaffleStockByRflIdAndDraw";
	public static final String geGroupByRflIdDrawDrawDateAndRange = "geGroupByRflIdDrawDrawDateAndRange";
	public static final String addNewDispatch = "addNewDispatch";
	public static final String getMaxDispatchId = "getMaxDispatchId";
	public static final String addNewAdvReturn = "addNewAdvReturn";
	public static final String getMaxAdvReturnId = "getMaxAdvReturnId";
	
}

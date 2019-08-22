/**
 * 
 */
package com.sci.services.util;

import com.sci.services.locker.model.Status;

/**
 * @author mn259
 *
 */
public class LockerServiceUtil {
	
	private static LockerServiceUtil userServiceUtil = null;

	private LockerServiceUtil() {

	}
	public static LockerServiceUtil getInstance() {
		if (userServiceUtil == null){
			userServiceUtil = new LockerServiceUtil();
		}
		return userServiceUtil;
	}
	
	/**
	 * @param statusCode
	 * @param statusDesc
	 */
	public Status prepareStatus(String statusCode,String statusDesc) {
		Status status = new Status();
		status.setStatusCode(statusCode);
		status.setStatusDesc(statusDesc);
		return status;
	} 
}

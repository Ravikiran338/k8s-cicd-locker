package com.sci.services.locker.model;

import java.io.Serializable;
import java.util.Date;

public class LockerInfoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long accountId;
	private String lockerNumber;
	private long lockerAssignedBy;
	private Date lockerAssignedDateTime;
	private String activeFlag;
	private Date lastModifiedDateTime;
	private String accountNum;
	
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	public long getLockerAssignedBy() {
		return lockerAssignedBy;
	}
	public void setLockerAssignedBy(long lockerAssignedBy) {
		this.lockerAssignedBy = lockerAssignedBy;
	}
	public Date getLockerAssignedDateTime() {
		return lockerAssignedDateTime;
	}
	public void setLockerAssignedDateTime(Date lockerAssignedDateTime) {
		this.lockerAssignedDateTime = lockerAssignedDateTime;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
}

package com.sci.services.locker.model;

import java.util.Date;

public class LockerOperationPojo {
	
	private long lockerOperationId;
	private long lockerInfoId;
	private long lockerModifiedBy;
	private String lockerOperationDateTime;
	private String lockerOperationInTime;
	private String lockerOperationOutTime;
	private String activeFlag;
	private Date lastModifiedDateTime;
	private String lockerNumber;
	
	public long getLockerOperationId() {
		return lockerOperationId;
	}
	public void setLockerOperationId(long lockerOperationId) {
		this.lockerOperationId = lockerOperationId;
	}
	public long getLockerInfoId() {
		return lockerInfoId;
	}
	public void setLockerInfoId(long lockerInfoId) {
		this.lockerInfoId = lockerInfoId;
	}
	public long getLockerModifiedBy() {
		return lockerModifiedBy;
	}
	public void setLockerModifiedBy(long lockerModifiedBy) {
		this.lockerModifiedBy = lockerModifiedBy;
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
	public String getLockerOperationDateTime() {
		return lockerOperationDateTime;
	}
	public void setLockerOperationDateTime(String lockerOperationDateTime) {
		this.lockerOperationDateTime = lockerOperationDateTime;
	}
	public String getLockerOperationInTime() {
		return lockerOperationInTime;
	}
	public void setLockerOperationInTime(String lockerOperationInTime) {
		this.lockerOperationInTime = lockerOperationInTime;
	}
	public String getLockerOperationOutTime() {
		return lockerOperationOutTime;
	}
	public void setLockerOperationOutTime(String lockerOperationOutTime) {
		this.lockerOperationOutTime = lockerOperationOutTime;
	}
	public String getLockerNumber() {
		return lockerNumber;
	}
	public void setLockerNumber(String lockerNumber) {
		this.lockerNumber = lockerNumber;
	}
	
	
	
}

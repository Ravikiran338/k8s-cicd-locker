package com.sci.services.locker.model;


import java.util.Date;

public class LockerOperations {
	
    private Integer lokcerOperationId;
    private Integer lockerInfoId;
    private Date lokcerOperationDate;
    private Date lockerOperationInTime;
    private Date lockerOperationOutTime;
    private String activeFlag;
    private Date lastModifiedDateTime;
    private Integer modifiedBy;
	public Integer getLokcerOperationId() {
		return lokcerOperationId;
	}
	public void setLokcerOperationId(Integer lokcerOperationId) {
		this.lokcerOperationId = lokcerOperationId;
	}
	public Integer getLockerInfoId() {
		return lockerInfoId;
	}
	public void setLockerInfoId(Integer lockerInfoId) {
		this.lockerInfoId = lockerInfoId;
	}
	public Date getLokcerOperationDate() {
		return lokcerOperationDate;
	}
	public void setLokcerOperationDate(Date lokcerOperationDate) {
		this.lokcerOperationDate = lokcerOperationDate;
	}
	public Date getLockerOperationInTime() {
		return lockerOperationInTime;
	}
	public void setLockerOperationInTime(Date lockerOperationInTime) {
		this.lockerOperationInTime = lockerOperationInTime;
	}
	public Date getLockerOperationOutTime() {
		return lockerOperationOutTime;
	}
	public void setLockerOperationOutTime(Date lockerOperationOutTime) {
		this.lockerOperationOutTime = lockerOperationOutTime;
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
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
    
    
    
}
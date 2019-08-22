package com.sci.services.locker.model;



import java.util.Date;

public class LockerInfo {
   
    private Integer lockerInfoId;
    private Integer accountId;
    private String lockerNum;
    private Integer lockerAssignedBy;
    private Date lockerAssignedDatetime;
    private String activeFlag;
    private Date lastModifiedDateTime;
	public Integer getLockerInfoId() {
		return lockerInfoId;
	}
	public void setLockerInfoId(Integer lockerInfoId) {
		this.lockerInfoId = lockerInfoId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getLockerNum() {
		return lockerNum;
	}
	public void setLockerNum(String lockerNum) {
		this.lockerNum = lockerNum;
	}
	public Integer getLockerAssignedBy() {
		return lockerAssignedBy;
	}
	public void setLockerAssignedBy(Integer lockerAssignedBy) {
		this.lockerAssignedBy = lockerAssignedBy;
	}
	public Date getLockerAssignedDatetime() {
		return lockerAssignedDatetime;
	}
	public void setLockerAssignedDatetime(Date lockerAssignedDatetime) {
		this.lockerAssignedDatetime = lockerAssignedDatetime;
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
   
    
    
}
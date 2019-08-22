package com.sci.services.locker.repository;



import java.util.Date;

import com.sci.services.locker.model.WebReportLocker;

import reactor.core.publisher.Flux;

public interface ReportLockerService {

	Flux<WebReportLocker> getLockerReport(String lockerNum,Date lockerOperationDate);
}

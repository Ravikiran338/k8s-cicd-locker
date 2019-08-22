package com.sci.services.locker.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sci.services.locker.model.LockerInfoBean;
import com.sci.services.locker.model.LockerInfoPojo;
import com.sci.services.locker.model.LockerOperationPojo;
import com.sci.services.locker.model.Status;
import com.sci.services.locker.model.WebReportLocker;
import com.sci.services.locker.repository.LockerService;
import com.sci.services.locker.repository.ReportLockerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LockerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LockerController.class);

	@Autowired
	ReportLockerService reportLockerService;
	@Autowired
	private LockerService lockerService;

	@PostMapping("/addLocker")
	public Mono<Integer> addLocker(@RequestBody LockerInfoBean lockerInfoBean) {
		LOGGER.info("create: {}", lockerInfoBean);
		Mono<LockerInfoBean> addLockerMono = Mono.just(lockerInfoBean);
		return lockerService.createLocker(addLockerMono);
	}

	@PostMapping("/addLockerOperations")
	public Mono<Integer> addLockerOperations(@RequestBody LockerOperationPojo lockerOperationPojo) {
		LOGGER.info("create: {}", lockerOperationPojo);
		Mono<LockerOperationPojo> addLockerOperationMono = Mono.just(lockerOperationPojo);
		return lockerService.createLockerOperation(addLockerOperationMono);
	}

	@DeleteMapping
	public Mono<Status> deactivateLocker(@RequestBody LockerInfoPojo lockerInfoPojo) {
		Mono<LockerInfoPojo> lockerMono = Mono.just(lockerInfoPojo);
		return lockerService.deactivateLocker(lockerMono);
	}

	@GetMapping
	public Flux<WebReportLocker> getReportLocker(@RequestParam String lockerNum,
			@RequestParam Date lockerOperationDate) {
		LOGGER.info("getReportLocker()");
		return reportLockerService.getLockerReport(lockerNum, lockerOperationDate);
	}
}

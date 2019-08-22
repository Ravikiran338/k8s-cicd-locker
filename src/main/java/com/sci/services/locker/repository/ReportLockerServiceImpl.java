package com.sci.services.locker.repository;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.sci.services.locker.constants.LockerQueryConstants;
import com.sci.services.locker.constants.LockerServiceConstants;
import com.sci.services.locker.model.WebReportLocker;
import com.sci.services.util.DatabaseUtil;

import io.reactivex.Flowable;
import reactor.core.publisher.Flux;

@Service
public class ReportLockerServiceImpl implements ReportLockerService {

	

	@Override
	public Flux<WebReportLocker> getLockerReport(String lockerNum, Date lockerOperationDate) {

		Flowable<WebReportLocker> employeeFlowable = null;

		if (!(lockerNum == null && lockerOperationDate == null)) {

			employeeFlowable = DatabaseUtil.getInstance().getDatabase().select(LockerQueryConstants.SELECT_REPORTLOCKER)
					.parameters(lockerNum, lockerOperationDate).get(rs -> {
						WebReportLocker webReportLocker = new WebReportLocker();

						webReportLocker.setLockerNum(rs.getString(LockerServiceConstants.LOCKER_NUMBER));
						webReportLocker.setLockerOperationInTime(
								rs.getString(LockerServiceConstants.LOCKER_OPERATION_IN_TIME));
						webReportLocker.setLockerOperationOutTime(
								rs.getString(LockerServiceConstants.LOCKER_OPERATION_OUT_TIME));
						return webReportLocker;
					});
			return Flux.from(employeeFlowable);
		} else {
			return null;
		}

	}
}

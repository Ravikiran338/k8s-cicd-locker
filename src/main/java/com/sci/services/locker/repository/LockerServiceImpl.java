package com.sci.services.locker.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sci.services.locker.constants.LockerQueryConstants;
import com.sci.services.locker.constants.LockerServiceConstants;
import com.sci.services.locker.model.LockerInfoBean;
import com.sci.services.locker.model.LockerInfoPojo;
import com.sci.services.locker.model.LockerOperationPojo;
import com.sci.services.locker.model.Status;
import com.sci.services.util.DatabaseUtil;
import com.sci.services.util.LockerServiceUtil;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author pr261
 *
 */
/**
 * @author pr261
 *
 */
@Service
public class LockerServiceImpl implements LockerService {

	private static LockerServiceUtil util = LockerServiceUtil.getInstance();

	@Override
	public Mono<Integer> createLocker(Mono<LockerInfoBean> lockerInfo) {

		Mono<Integer> newLockerInfo = lockerInfo.flatMap(newLocker -> {

			
			Flowable<Integer> updatedCount = DatabaseUtil.getInstance().getDatabase()
					.select(LockerQueryConstants.SELECT_BALANCE_BY_ACCOUNT_NUMBER).parameter(newLocker.getAccountNum())
					.getAs(Integer.class)
					.flatMap(accountId -> DatabaseUtil.getInstance().getDatabase()
							.update(LockerQueryConstants.ADD_LOCKER).parameters(accountId, newLocker.getLockerNumber(),
									newLocker.getLockerAssignedBy(), new Date(), "Y", new Date())
							.counts());
			return Mono.from(updatedCount);
		});
		
		return newLockerInfo;
	}

   
	@Override
	public Mono<Integer> createLockerOperation(Mono<LockerOperationPojo> lockerOperationInfo) {

		Mono<Integer> newLockerOperationInfo = lockerOperationInfo.flatMap(newLockerOperation -> {

			Flowable<Integer> lockerCount = DatabaseUtil.getInstance().getDatabase()
					.select(LockerQueryConstants.LOCKER_ID_BY_LOCKER_NUMBER)
					.parameter(newLockerOperation.getLockerNumber()).getAs(Integer.class)
					.flatMap(lockerInfoId -> DatabaseUtil.getInstance().getDatabase()
							.update(LockerQueryConstants.ADD_LOCKER_OPERATIONS)
							.parameters(lockerInfoId, new
									  Date(),newLockerOperation.getLockerOperationInTime() ,
									  newLockerOperation.getLockerOperationOutTime(),
									  "Y",newLockerOperation.getLockerOperationDateTime(),
									  newLockerOperation.getLockerModifiedBy())
							.counts());
			return Mono.from(lockerCount);
		});
		return newLockerOperationInfo;
	}

	@Override
	public Mono<Status> deactivateLocker(Mono<LockerInfoPojo> lockerInfoPojo) {

		Mono<Status> updateLockerInfo = lockerInfoPojo.flatMap(updateLocker -> {
			Flowable<Integer> updatedCount = DatabaseUtil.getInstance().getDatabase()
					.update(LockerQueryConstants.DEACTIVATE_LOCKER)
					.parameters("N", new Date(), updateLocker.getLockerInfoId()).counts();
			Flowable<Status> result = updatedCount.map(new Function<Integer, Status>() {
				@Override
				public Status apply(Integer count) throws Exception {
					Status status = null;
					if (count > 0) {
						status = util.prepareStatus("00", "Success");
					} else {
						status = util.prepareStatus("99", "Failed");
					}
					return status;
				}
			});
			return Mono.from(result);
		});
		return updateLockerInfo;
	}

	@Override
	public Flux<LockerInfoPojo> getAllLockers() {

		Flowable<LockerInfoPojo> allLockers = DatabaseUtil.getInstance().getDatabase()
				.select(LockerQueryConstants.GET_ALL_LOCKERS).get(rs -> {
					return getLockerInfo(rs);
				});
		return Flux.from(allLockers);
	}

	private LockerInfoPojo getLockerInfo(ResultSet rs) throws SQLException {
		LockerInfoPojo lockerInfoPojo = new LockerInfoPojo();

		lockerInfoPojo.setAccountId(rs.getLong(LockerServiceConstants.ACCOUNT_ID));
		lockerInfoPojo.setActiveFlag(rs.getString(LockerServiceConstants.ACTIVE_FLAG));
		lockerInfoPojo.setLastModifiedDateTime(rs.getDate(LockerServiceConstants.LAST_MODIFIED_DATE_TIME));
		lockerInfoPojo.setLockerAssignedBy(rs.getLong(LockerServiceConstants.LOCKER_ASSIGNED_BY));
		lockerInfoPojo.setLockerAssignedDateTime(rs.getDate(LockerServiceConstants.LOCKER_ASSIGNED_DATETIME));
		lockerInfoPojo.setLockerInfoId(rs.getLong(LockerServiceConstants.LOCKER_INFO_ID));
		lockerInfoPojo.setLockerNumber(rs.getString(LockerServiceConstants.LOCKER_NUM));
		return lockerInfoPojo;
	}

}

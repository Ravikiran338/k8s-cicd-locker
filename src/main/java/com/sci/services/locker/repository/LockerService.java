/**
 * 
 */
package com.sci.services.locker.repository;

import com.sci.services.locker.model.LockerInfoBean;
import com.sci.services.locker.model.LockerInfoPojo;
import com.sci.services.locker.model.LockerOperationPojo;
import com.sci.services.locker.model.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mn259
 *
 */
public interface LockerService {
	
	public Mono<Integer> createLocker(Mono<LockerInfoBean> lockerInfo);
	
	public Mono<Integer> createLockerOperation(Mono<LockerOperationPojo> lockerOperationInfo);
	
	public Mono<Status> deactivateLocker(Mono<LockerInfoPojo> lockerInfoPojo);
	
	public Flux<LockerInfoPojo> getAllLockers();
	
}

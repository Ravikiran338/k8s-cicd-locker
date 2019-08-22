/**
 * 
 */
package com.sci.services.locker.constants;

/**
 * @author mn259
 *
 */
public class LockerQueryConstants {

	public static final String SELECT_REPORTLOCKER = "SELECT a.locker_num,b.LOCKER_OPERATION_IN_TIME,b.LOCKER_OPERATION_OUT_TIME\r\n"
			+ "FROM locker_info_tbl a\r\n"
			+ "JOIN locker_operations_tbl b ON a.locker_info_id=b.locker_info_id where locker_num= ? and LOKCER_OPERATION_DATE= ?";

	
	public static final String ADD_LOCKER ="INSERT INTO locker_info_tbl (account_id, locker_num, locker_assigned_by, locker_assigned_datetime, "
			+ "active_flag, LAST_MODIFIED_DATE_TIME) VALUES (?, ?, ?, ?, ?, ?)";
	
	
	public static final String ADD_LOCKER_OPERATIONS = "INSERT INTO locker_operations_tbl (LOCKER_INFO_ID, LOKCER_OPERATION_DATE, LOCKER_OPERATION_IN_TIME, LOCKER_OPERATION_OUT_TIME, "
			+ "ACTIVE_FLAG, LAST_MODIFIED_DATE_TIME, MODIFIED_BY) VALUES (?, ?, ?, ?, ?, ?,?)";
	
	public static final String DEACTIVATE_LOCKER = "UPDATE locker_info_tbl set active_flag=?,LAST_MODIFIED_DATE_TIME=? where locker_info_id =?";
	
	public static final String GET_ALL_LOCKERS = "SELECT locker_info_id, account_id, locker_num, locker_assigned_by, locker_assigned_datetime, active_flag, LAST_MODIFIED_DATE_TIME FROM locker_info_tbl";

	public static final String SELECT_BALANCE_BY_ACCOUNT_NUMBER = "SELECT account_id FROM accounts_tbl where account_num = ?";

	

	public static final String LOCKER_ID_BY_LOCKER_NUMBER = "select locker_info_id from locker_info_tbl where locker_num= ?";


}

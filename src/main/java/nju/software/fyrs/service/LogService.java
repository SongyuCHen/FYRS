package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.data.dataobject.Log;

public interface LogService {
	// ≤È—Ø
 	public List<Log> listByTimeOperUser(String operUser,String operBeginTime,String operEndTime,String operType);
    public void login(Log log);
}

package nju.software.fyrs.service;

import java.util.Date;
import java.util.List;

import nju.software.fyrs.data.dataobject.RywhLog;

import org.aspectj.lang.JoinPoint;

public interface RywhLogService {
	public void dealAddMethod(JoinPoint joinPoint,Object returnValue);
	public void dealUpdateMethod(JoinPoint joinPoint,Object returnValue);
	public void dealDeleteMethod(JoinPoint joinPoint,Object returnValue);
	// ≤È—Ø
	public List<RywhLog> listByTimeOperUser(String operUser,String operBeginTime,String operEndTime,String operType);
	public void recoverSystem(String endTime);
	public Date[] findMaxAndMinDate();
}

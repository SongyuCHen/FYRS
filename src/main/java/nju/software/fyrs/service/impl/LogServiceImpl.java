package nju.software.fyrs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import nju.software.fyrs.data.dao.LogDAO;
import nju.software.fyrs.data.dataobject.Log;
import nju.software.fyrs.service.LogService;

public class LogServiceImpl implements LogService {
	private LogDAO logDAO;

	
	
	
	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}




	@Override
	public List<Log> listByTimeOperUser(String operUser, String operBeginTime,
			String operEndTime, String operType) {
		return logDAO.listByTimeOperUser(operUser, operBeginTime, operEndTime, operType);
	}
	@Override
	public void login(Log log) {
		log.setNId(logDAO.getMaxId().add(BigDecimal.valueOf(1)));
		System.out.println(log.getNId());
	    logDAO.save(log);
		
	}
     
	//  ≤È—Ø
	

}

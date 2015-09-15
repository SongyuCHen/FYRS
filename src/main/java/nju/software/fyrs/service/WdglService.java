package nju.software.fyrs.service;

import java.util.List;
import java.util.Map;

import nju.software.fyrs.biz.vo.WdVO;
import nju.software.fyrs.data.dataobject.Wdgl;

public interface WdglService {
	public List<WdVO> getAllWd();
	
	public void addWd(Wdgl wdgl);
	
	public void updateWd(Wdgl wdgl);
	
	public void deleteWd(Wdgl wdgl);

	public List<WdVO> getWdByQueryMap(Map<String, Object> queryMap);

	public Wdgl getWdById(Integer wdbh);
}

package nju.software.fyrs.service.impl;

import java.util.List;
import java.util.Map;

import nju.software.fyrs.biz.vo.WdVO;
import nju.software.fyrs.data.dao.WdglDAO;
import nju.software.fyrs.data.dataobject.Wdgl;
import nju.software.fyrs.service.WdglService;
import nju.software.fyrs.service.convertor.WdglConvertor;

public class WdglServiceImpl implements WdglService {
	
	private WdglDAO wdglDAO;
	
	public void setWdglDAO(WdglDAO wdglDAO){
		this.wdglDAO = wdglDAO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WdVO> getAllWd() {
		List<Wdgl> wdglList =  wdglDAO.findAll();
		return WdglConvertor.getWdVOList(wdglList);
	}

	@Override
	public void addWd(Wdgl wdgl) {
		wdglDAO.save(wdgl);
	}

	@Override
	public void updateWd(Wdgl wdgl) {
		wdglDAO.update(wdgl);
	}

	@Override
	public void deleteWd(Wdgl wdgl) {
		wdglDAO.delete(wdgl);
	}

	@Override
	public List<WdVO> getWdByQueryMap(Map<String, Object> queryMap) {
		List<Wdgl> wdglList =  wdglDAO.getWdByQueryMap(queryMap);
		return WdglConvertor.getWdVOList(wdglList);
	}

	@Override
	public Wdgl getWdById(Integer wdbh) {
		return wdglDAO.findById(wdbh);
	}
}

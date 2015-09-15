package nju.software.fyrs.service.impl;

import java.util.List;

import nju.software.fyrs.data.dao.McDAO;
import nju.software.fyrs.data.dataobject.Mc;
import nju.software.fyrs.service.McService;

public class McServieImpl implements McService {
	private McDAO mcDAO;
	public void setMcDAO(McDAO mcDAO) {
		this.mcDAO = mcDAO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mc> listAllMc() {
		return mcDAO.findAll();
	}
}

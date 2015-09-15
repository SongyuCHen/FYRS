package nju.software.fyrs.service.impl;

import nju.software.fyrs.data.dao.DwxxDAO;
import nju.software.fyrs.data.dataobject.Dwxx;
import nju.software.fyrs.service.DwxxService;

public class DwxxServiceImpl implements DwxxService {

    private DwxxDAO dwxxDAO;
	@Override
	public Dwxx findDwxxByFy(int fydm) {
		
		return dwxxDAO.findById(fydm);
	}
	@Override
	public void updateDwxxByFy(Dwxx dwxx) {
	     dwxxDAO.updateDwxxByFy(dwxx);
	}
	
	public void setDwxxDAO(DwxxDAO dwxxDAO) {
		this.dwxxDAO = dwxxDAO;
	} 
}

package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.DdTableVO;
import nju.software.fyrs.data.dao.DdTableDAO;
import nju.software.fyrs.data.dataobject.DdTable;
import nju.software.fyrs.service.DdTableService;

public class DdTableServiceImpl implements DdTableService{
    private DdTableDAO ddTableDAO;
    
	public void setDdTableDAO(DdTableDAO ddTableDAO)
	{
		this.ddTableDAO = ddTableDAO;
	}

	@Override
	public List<DdTableVO> listAllTable()
	{
		List<DdTableVO> vos = new ArrayList<DdTableVO>();
		List<DdTable> list = ddTableDAO.findAllTable();
		for(DdTable item : list)
		{
			DdTableVO vo = new DdTableVO();
			vo.setCCnname(item.getCCnname());
			vo.setCTablename(item.getCTablename());
			vos.add(vo);
		}
		return vos;
	}
  
}

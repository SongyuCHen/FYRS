package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.DdFieldCondtionVO;
import nju.software.fyrs.biz.vo.DdFieldVO;
import nju.software.fyrs.data.dao.DdFieldDAO;
import nju.software.fyrs.data.dataobject.DdField;
import nju.software.fyrs.service.DdFieldService;

public class DdFieldServiceImpl implements DdFieldService{
    private DdFieldDAO ddFieldDAO;
	@Override
	public List<DdFieldVO> listByTableName(String tableName)
	{
		List<DdFieldVO> vos = new ArrayList<DdFieldVO>();
		List<DdField> list = ddFieldDAO.listByTableNameShow(tableName);
		for(DdField item : list)
		{
		DdFieldVO vo = new DdFieldVO();
		vo.setCCnname(item.getCCnname());
		vo.setCFieldname(item.getCFieldname());
		vo.setNMaincode(item.getNMaincode()+"");
		vos.add(vo);
		}
		return vos;
	}
	public List<DdFieldCondtionVO> listByTableNameCondition(String tableName)
	{
		List<DdFieldCondtionVO> vos = new ArrayList<DdFieldCondtionVO>();
		List<DdField> list = ddFieldDAO.listByTableNameCondtion(tableName);
		for(DdField item : list)
		{
		DdFieldCondtionVO vo = new DdFieldCondtionVO();
		vo.setCCnname(item.getCCnname());
		vo.setNLogictype(item.getNLogictype()+"");
		vo.setNDatatype(item.getNDatatype()+"");
		vo.setNMaincode(item.getNMaincode()+"");
		vo.setCFieldname(item.getCFieldname());
		vos.add(vo);
		}
		return vos;
	}
	public void setDdFieldDAO(DdFieldDAO ddFieldDAO)
	{
		this.ddFieldDAO = ddFieldDAO;
	}
	@Override
	public Short getMaincodeByTableIdAndFieldName(String tableId,
			String fieldName) {
		return ddFieldDAO.getMaincodeByTableIdAndFieldName(tableId,fieldName);
	}
	@Override
	public String getCnnameByTableIdAndFieldName(String tableId,
			String fieldName) {
		return ddFieldDAO.getCnnameByTableIdAndFieldName(tableId,fieldName);
	}
	@Override
	public DdFieldVO getDdFieldByCName(String cName) {
		// TODO Auto-generated method stub
		DdField ddField= ddFieldDAO.getDdFieldByCName(cName);
		DdFieldVO vo = new DdFieldVO();
		vo.setCCnname(ddField.getCCnname());
		vo.setCFieldname(ddField.getCFieldname());
		vo.setNMaincode(ddField.getNMaincode()+"");
		return vo;
	}
	
  
}

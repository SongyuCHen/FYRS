package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.DmCommonVO2;
import nju.software.fyrs.data.dao.YjdaScbbDAO;
import nju.software.fyrs.data.dataobject.Ajjtxx;
import nju.software.fyrs.data.dataobject.Gryjda;
import nju.software.fyrs.service.YjdaScbbService;

public class YjdaScbbServiceImpl implements YjdaScbbService{
	
	private YjdaScbbDAO yjdaScbbDAO;
	
	public void setYjdaScbbDAO(YjdaScbbDAO yjdaScbbDAO) {
		this.yjdaScbbDAO = yjdaScbbDAO;
	}
	public int[] getXfShu(List<String> anHou)
	{
		return yjdaScbbDAO.getXfShu(anHou);
	}
	@Override
	public Gryjda getGryjda(Date dateFrom, Date dateTo,String yhmc) {
		
		Gryjda gryjda = yjdaScbbDAO.getGryjda(dateFrom,dateTo,yhmc);
		return gryjda;
	}
	public List<List<String>> getQuanYuanyjda(Date dateFrom, Date dateTo,String yhmc)
	{
		return yjdaScbbDAO.getQuanYuanyjda(dateFrom,dateTo,yhmc);
	}
	public List<List<String>> getXsspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getXsspYjda(bmdm,dateFrom,dateTo);
	}
	public List<List<String>> getXzspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getXzspYjda(bmdm,dateFrom,dateTo);
	}
	public List<List<String>> getMsspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getMsspYjda(bmdm,dateFrom,dateTo);
	}
	public List<List<String>> getZxspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getZxspYjda(bmdm,dateFrom,dateTo);
	}
	public List<List<String>> getLaspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getLaspYjda(bmdm,dateFrom,dateTo);
	}
	public List<List<String>> getSjspYjda(String bmdm,Date dateFrom, Date dateTo)
	{
		return yjdaScbbDAO.getSjspYjda(bmdm,dateFrom,dateTo);
	}
	@Override
	public List<Ajjtxx> getAjjtxx(String yhmc,String codeNum) {
		
		List<Ajjtxx> ajjtxxList= yjdaScbbDAO.getAjjtxx(yhmc,codeNum);
		return ajjtxxList;
	}
	public List<DmCommonVO2> getDmb(String selectType)
	{
		List<DmCommonVO2> vos = new ArrayList<DmCommonVO2>();
		List<Object[]> objs = yjdaScbbDAO.getBmZwZjList(Integer.valueOf(selectType));
		for(Object[] obj : objs)
		{
			DmCommonVO2 vo = new DmCommonVO2();
			vo.setNDm((String)obj[1]);
			vo.setCMc((String)obj[2]);
			vos.add(vo);
		}
		return vos;	
	}
	
	@Override
	public List<List<String>> getScbbZwZj(Date dateFrom, Date dateTo,String biaozhi, String dm) {
		
		return yjdaScbbDAO.getScbbZwZj(dateFrom,dateTo,biaozhi,dm);
	}
}

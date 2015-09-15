package nju.software.fyrs.service;

import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.DmCommonVO2;
import nju.software.fyrs.data.dataobject.Ajjtxx;
import nju.software.fyrs.data.dataobject.Gryjda;

public interface YjdaScbbService {
	public Gryjda getGryjda(Date dateFrom,Date dateTo,String yhmc);
	public int[] getXfShu(List<String> anHou);
	public List<List<String>> getQuanYuanyjda(Date dateFrom, Date dateTo,String yhmc);
	public List<List<String>> getXsspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<List<String>> getMsspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<List<String>> getXzspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<List<String>> getZxspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<List<String>> getLaspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<List<String>> getSjspYjda(String bmdm,Date dateFrom, Date dateTo);
	public List<DmCommonVO2> getDmb(String selectType);
	public List<Ajjtxx> getAjjtxx(String yhmc,String codeNum);
	
	public List<List<String>> getScbbZwZj(Date dateFrom,Date dateTo,String biaozhi,String dm);
}

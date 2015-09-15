package nju.software.fyrs.service;

import java.util.List;

import nju.software.fyrs.biz.vo.NdkhVO;
import nju.software.fyrs.biz.vo.NdkhjtxxVO;

public interface YjdaNdkhService {
	public List<NdkhVO> getNdByYhmc(String yhmc);
	
	public NdkhjtxxVO getNdkhjtxxByYhmc(String yhmc);
	
	public void addNdkhjtxx(NdkhjtxxVO vo);
	
	public NdkhjtxxVO getNdkhjtxxByYhmcAndKhnd(String yhmc,String khnd);
	
	public NdkhjtxxVO getNdkhjtxxByRybhAndKhnd(String rybh,String khnd);
	
	public byte[] getSignPic(String yhmc);
	
	public List<String> getYhQxByYhmc(String yhmc);
	
	public List<List<String>> getBmTjBg(String yhmc,String year);
	
	public List<List<String>> getGbccx(String year);
	
	public List<List<String>> getTjsc(String yhmc,String year);
	
	public List<List<String>> getLdspZc(String yhmc,String year);
	
	public List<String> getYhglBm(String yhmc);
	
	public List<List<String>> getLdspZcyx(String bmbh,String year);
	
	public byte[] getSign(String rybh,String nd,String pic);
	
	public void spNdkhjtxx(String rybh,String nd,String zgldpy,String select_jieguo);
	
	public void yldspNdkhjtxx(String rybh,String nd,String jgfzrhkhwyhyj);
}

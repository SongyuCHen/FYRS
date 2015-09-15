package nju.software.fyrs.biz.manager;

import java.util.List;

import nju.software.fyrs.biz.vo.NdkhVO;
import nju.software.fyrs.biz.vo.NdkhjtxxVO;

public interface YjdaNdkhManager {
	public List<NdkhVO> getNdByYhmc(String yhmc);
	
	public NdkhjtxxVO getNdkhjtxxByYhmc(String yhmc);
	
	public void addNdkhjtxx(NdkhjtxxVO vo);
	
	public NdkhjtxxVO getNdkhjtxxByYhmcAndKhnd(String yhmc,String khnd);
	
	public byte[] getSignPic(String yhmc);
	
	public List<String> getYhQxByYhmc(String yhmc);
	
	public NdkhjtxxVO getNdkhjtxxByRybhAndKhnd(String rybh,String khnd);
}

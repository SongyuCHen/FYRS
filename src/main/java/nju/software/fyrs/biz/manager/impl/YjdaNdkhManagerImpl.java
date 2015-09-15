package nju.software.fyrs.biz.manager.impl;

import java.util.List;

import nju.software.fyrs.biz.manager.YjdaNdkhManager;
import nju.software.fyrs.biz.vo.NdkhVO;
import nju.software.fyrs.biz.vo.NdkhjtxxVO;
import nju.software.fyrs.service.YjdaNdkhService;

public class YjdaNdkhManagerImpl implements YjdaNdkhManager{
	
	YjdaNdkhService yjdaNdkhService;
	
	public void setYjdaNdkhService(YjdaNdkhService yjdaNdkhService) {
		this.yjdaNdkhService = yjdaNdkhService;
	}
	
	@Override
	public List<NdkhVO> getNdByYhmc(String yhmc) {
		
		return yjdaNdkhService.getNdByYhmc(yhmc);
	}
	
	@Override
	public NdkhjtxxVO getNdkhjtxxByYhmc(String yhmc) {
		
		return yjdaNdkhService.getNdkhjtxxByYhmc(yhmc);
	}
	
	@Override
	public void addNdkhjtxx(NdkhjtxxVO vo) {
		
		yjdaNdkhService.addNdkhjtxx(vo);
	}
	
	@Override
	public NdkhjtxxVO getNdkhjtxxByYhmcAndKhnd(String yhmc, String khnd) {
		
		return yjdaNdkhService.getNdkhjtxxByYhmcAndKhnd(yhmc,khnd);
	}
	
	@Override
	public byte[] getSignPic(String yhmc) {
		
		return yjdaNdkhService.getSignPic(yhmc);
	}

	@Override
	public List<String> getYhQxByYhmc(String yhmc) {
		
		return yjdaNdkhService.getYhQxByYhmc(yhmc);
	}
	
	@Override
	public NdkhjtxxVO getNdkhjtxxByRybhAndKhnd(String rybh,String khnd){
		return yjdaNdkhService.getNdkhjtxxByRybhAndKhnd(rybh, khnd);
	}
}

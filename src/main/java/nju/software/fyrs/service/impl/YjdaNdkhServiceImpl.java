package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.NdkhVO;
import nju.software.fyrs.biz.vo.NdkhjtxxVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.DzrsRsNdkhbDAO;
import nju.software.fyrs.data.dao.KhjlYearDAO;
import nju.software.fyrs.data.dao.NdkhDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dataobject.DzrsRsNdkhb;
import nju.software.fyrs.data.dataobject.KhjlYear;
import nju.software.fyrs.service.YjdaNdkhService;

public class YjdaNdkhServiceImpl implements YjdaNdkhService {

	DzrsRsNdkhbDAO dzrsRsNdkhbDAO;
	KhjlYearDAO khjlYearDAO;
	DmDAO dmDAO;
	RyjbxxDAO ryjbxxDAO;
	NdkhDAO ndkhDAO;

	public void setNdkhDAO(NdkhDAO ndkhDAO) {
		this.ndkhDAO = ndkhDAO;
	}

	public void setDzrsRsNdkhbDAO(DzrsRsNdkhbDAO dzrsRsNdkhbDAO) {
		this.dzrsRsNdkhbDAO = dzrsRsNdkhbDAO;
	}

	public void setKhjlYearDAO(KhjlYearDAO khjlYearDAO) {
		this.khjlYearDAO = khjlYearDAO;
	}

	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}

	@Override
	public List<NdkhVO> getNdByYhmc(String yhmc) {
		
		// 通过用户名称获得用户编号（因为人事系统与年度考核的人员编号不一样，所以用人员名称过渡）
		KhjlYear khjlYear = khjlYearDAO.getKhjlYearByYhmc(yhmc);
		List<DzrsRsNdkhb> listDzrsRsNdkhb = new ArrayList<DzrsRsNdkhb>();
		if (khjlYear != null) {
			listDzrsRsNdkhb = dzrsRsNdkhbDAO.getNdByRybh(khjlYear
					.getJbxxjCode());
		}
		List<NdkhVO> listNdkhVO = new ArrayList<NdkhVO>();
		for (int i = 0; i < listDzrsRsNdkhb.size(); i++) {
			NdkhVO ndkhVO = new NdkhVO();
			if(listDzrsRsNdkhb.get(i).getJieg()!=null){
				ndkhVO.setKh(Integer.parseInt(listDzrsRsNdkhb.get(i).getJieg()));
			}
			ndkhVO.setNd(listDzrsRsNdkhb.get(i).getNd().toString());
			listNdkhVO.add(ndkhVO);
		}
		return listNdkhVO;
	}
	
	//填写考核
	@Override
	public NdkhjtxxVO getNdkhjtxxByYhmc(String yhmc) {
		
		NdkhjtxxVO ndkhjtxxVO = khjlYearDAO.getKhjlYear(yhmc);
		return ndkhjtxxVO;
	}

	@Override
	public void addNdkhjtxx(NdkhjtxxVO vo) {
		
		khjlYearDAO.save(vo);
	}

	@Override
	public NdkhjtxxVO getNdkhjtxxByYhmcAndKhnd(String yhmc, String khnd) {
		
		return  khjlYearDAO.getKhjlYear(yhmc, khnd);
		
	}

	public NdkhjtxxVO getNdkhjtxxByRybhAndKhnd(String rybh,String khnd){
		return khjlYearDAO.getNdkhjtxxByRybhAndKhnd(rybh,khnd);
	}
	
	@Override
	public byte[] getSignPic(String yhmc) {
		
		return khjlYearDAO.getSignPic(yhmc);
	}

	@Override
	public List<String> getYhQxByYhmc(String yhmc) {
		
		return ndkhDAO.getYhQxByYhmc(yhmc);
	}

	public List<List<String>> getBmTjBg(String yhmc, String year) {

		return ndkhDAO.getBmTjBg(yhmc, year);
	}

	@Override
	public List<List<String>> getGbccx(String year) {
		
		return ndkhDAO.getGbccx(year);
	}

	public List<List<String>> getTjsc(String yhmc, String year) {

		return ndkhDAO.getTjsc(yhmc,year);
	}
	
	public List<List<String>> getLdspZc(String yhmc,String year){
		return ndkhDAO.getLdspZc(yhmc,year);
	}
	
	public List<String> getYhglBm(String yhmc){
		return ndkhDAO.getYhglBm(yhmc);
	}
	
	public List<List<String>> getLdspZcyx(String bmbh,String year){
		return ndkhDAO.getLdspZcyx(bmbh,year);
	}
	
	public byte[] getSign(String rybh,String nd,String pic){
		return khjlYearDAO.getSign(rybh,nd,pic);
	}
	
	@Override
	public void spNdkhjtxx(String rybh, String nd, String zgldpy,
			String select_jieguo) {
		
		khjlYearDAO.spNdkhjtxx(rybh,nd,zgldpy,select_jieguo);
	}
	
	@Override
	public void yldspNdkhjtxx(String rybh, String nd, String jgfzrhkhwyhyj) {
		
		khjlYearDAO.yldspNdkhjtxx(rybh,nd,jgfzrhkhwyhyj);
	}
}

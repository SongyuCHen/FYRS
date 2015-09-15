package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import nju.software.fyrs.biz.vo.LdjcVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.LdjcService;

public class LdjcServiceImpl implements LdjcService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LdjcServiceImpl.class);
	
	private DmDAO dmDAO;
	private RyjbxxDAO ryjbxxDAO;

	@Override
	public List<LdjcVO> getFlzwFb(int fydm) {
		List<LdjcVO> flzwFbs = new ArrayList<LdjcVO>();
		List<Dm> flzwDms = dmDAO.listDmByNBxh("16"); 
		Map<Integer, Long> flzwDmFbs = ryjbxxDAO.getFlzwFb(fydm);
		for(Dm dm : flzwDms){
			Long count = flzwDmFbs.get(dm.getNDm());
			if(count!=null){
				LdjcVO vo = new LdjcVO();
				vo.setName(dm.getCMc());
				vo.setCount(count);
				flzwFbs.add(vo);
			}
		}
		return flzwFbs;
	}
	
	@Override
	public List<LdjcVO> getFgdjFb(int fydm) {
		List<LdjcVO> fgdjFbs = new ArrayList<LdjcVO>();
		List<Dm> fgdjDms = dmDAO.listDmByNBxh("20");
		Map<Integer, Long> fgzwDmFbs = ryjbxxDAO.getFgdjFb(fydm);
		for(Dm dm : fgdjDms){
			if(dm.getCMc().endsWith("·¨¹Ù")){
				Long count = fgzwDmFbs.get(dm.getNDm());
				if(count!=null){
					LdjcVO vo = new LdjcVO();
					vo.setName(dm.getCMc());
					vo.setCount(count);
					fgdjFbs.add(vo);
				}
			}
		}
		return fgdjFbs;
	}

	@Override
	public List<LdjcVO> getXzzwFb(int fydm) {
		List<LdjcVO> xzzwFbs = new ArrayList<LdjcVO>();
		List<Dm> xzzwDms = dmDAO.listDmByNBxh("15");
		Map<Integer, Long> xzzwDmFbs = ryjbxxDAO.getXzzwFb(fydm);
		for(Dm dm : xzzwDms){
			Long count = xzzwDmFbs.get(dm.getNDm());
			if(count!=null){
				LdjcVO vo = new LdjcVO();
				vo.setName(dm.getCMc());
				vo.setCount(count);
				xzzwFbs.add(vo);
			}
		}
		return xzzwFbs;
	}
	
	@Override
	public List<LdjcVO> getBmFb(int fydm) {
		List<LdjcVO> bmFbs = new ArrayList<LdjcVO>();
		List<Dm> bmDms = dmDAO.listDmByNBxh("2");
		Map<Integer, Long> bmDmFbs = ryjbxxDAO.getBmFb(fydm);
		for(Dm dm : bmDms){
			Long count = bmDmFbs.get(dm.getNDm());
			if(count!=null){
				LdjcVO vo = new LdjcVO();
				vo.setName(dm.getCMc());
				vo.setCount(count);
				bmFbs.add(vo);
			}
		}
		return bmFbs;
	}
	
	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}
}

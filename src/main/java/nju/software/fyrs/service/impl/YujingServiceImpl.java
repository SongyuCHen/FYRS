package nju.software.fyrs.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nju.software.fyrs.biz.vo.YujingVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.JgxxDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dao.YujingDAO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RysxYujing;
import nju.software.fyrs.service.YujingService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.StringUtil;

public class YujingServiceImpl implements YujingService{
	private YujingDAO yujingDAO;
	private RyjbxxDAO ryjbxxDAO;
	private JgxxDAO jgxxDAO;
	private RysxTablekeyDAO rysxTablekeyDAO;
	public void setJgxxDAO(JgxxDAO jgxxDAO) {
		this.jgxxDAO = jgxxDAO;
	}
	
	public void setDmDAO(DmDAO dmDAO) {
	}
	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}
	
	public void setYujingDAO(YujingDAO yujingDAO) {
		this.yujingDAO = yujingDAO;
	}
	
	@Override
	public List<YujingVO> getYujingByFy(String fydm) {
		// TODO Auto-generated method stub
		List<RysxYujing> yujings = yujingDAO.getRysxYujingByFy(fydm);
		List<YujingVO> vos = new ArrayList<YujingVO>();
		for(RysxYujing yujing:yujings){
			YujingVO vo = new YujingVO();
			int fy = yujing.getNFy();
			int rybh = yujing.getNRybh();
			Ryjbxx ry = ryjbxxDAO.getRyByFyAndRybh(fy, rybh);
			Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(fy,ry.getNBm());
			vo.setCXm(ry.getCXm());
			vo.setCBm(jgxx.getCName());
			vo.setNId(yujing.getNId().toString());
			vo.setNFy(yujing.getNFy().toString());
			vo.setNRybh(yujing.getNRybh().toString());
			vo.setDYjsj(DateUtil.format(yujing.getDYjsj(), DateUtil.webFormat));
			vo.setCYjsx(yujing.getCYjsx());
			vo.setCBz(yujing.getCBz());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public YujingVO getYujingById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		RysxYujing yujing = yujingDAO.getRysxYujingById(id, fydm, rybh);
		YujingVO vo = new YujingVO();
		int ify = yujing.getNFy();
		int irybh = yujing.getNRybh();
		Ryjbxx ry = ryjbxxDAO.getRyByFyAndRybh(ify, irybh);
		Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(ify,ry.getNBm());
		vo.setCXm(ry.getCXm());
		vo.setCBm(jgxx.getCName());
		vo.setNId(yujing.getNId().toString());
		vo.setNFy(yujing.getNFy().toString());
		vo.setNRybh(yujing.getNRybh().toString());
		vo.setDYjsj(DateUtil.format(yujing.getDYjsj(), DateUtil.webFormat));
		vo.setCYjsx(yujing.getCYjsx());
		vo.setCBz(yujing.getCBz());
		return vo;
	}

	@Override
	public YujingVO addYujing(YujingVO vo) {
		// TODO Auto-generated method stub
		RysxYujing yujing = new RysxYujing();
		int fydm = Integer.valueOf(vo.getNFy());
		yujing.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_YUJINGID"));
		yujing.setNFy(fydm);
		yujing.setNRybh(Integer.parseInt(vo.getNRybh()));
		if(! StringUtil.isBlank(vo.getDYjsj())){
			yujing.setDYjsj(DateUtil.parse(vo.getDYjsj(),DateUtil.webFormat));
		}
		yujing.setCYjsx(vo.getCYjsx());
		yujing.setCBz(vo.getCBz());
		yujingDAO.save(yujing);
		vo.setNId(yujing.getNId().toString());
		return vo;
	}

	@Override
	public YujingVO updateYujing(YujingVO vo) {
		// TODO Auto-generated method stub
		String id = vo.getNId();
		String fydm = vo.getNFy();
		String rybh = vo.getNRybh();
		RysxYujing yujing = yujingDAO.getRysxYujingById(id, fydm, rybh);
		if(! StringUtil.isBlank(vo.getDYjsj())){
			yujing.setDYjsj(DateUtil.parse(vo.getDYjsj(),DateUtil.webFormat));
		}
		yujing.setCYjsx(vo.getCYjsx());
		yujing.setCBz(vo.getCBz());
		yujingDAO.update(yujing);
		return vo;
	}

	@Override
	public boolean delYujingById(String id, String fydm, String rybh) {
		// TODO Auto-generated method stub
		return yujingDAO.delRysxYujingById(rybh, id);
	}

	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO) {
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}

	@Override
	public List<YujingVO> getYujingByFyAndDate(String fydm, Date begin, Date end) {
		// TODO Auto-generated method stub
		List<RysxYujing> yujings = yujingDAO.getRysxYujingByFyAndDate(fydm, begin, end);
		List<YujingVO> vos = new ArrayList<YujingVO>();
		for(RysxYujing yujing:yujings){
			YujingVO vo = new YujingVO();
			int fy = yujing.getNFy();
			int rybh = yujing.getNRybh();
			Ryjbxx ry = ryjbxxDAO.getRyByFyAndRybh(fy, rybh);
			Jgxx jgxx = jgxxDAO.bmByFyIdAndNcode(fy,ry.getNBm());
			vo.setCXm(ry.getCXm());
			vo.setCBm(jgxx.getCName());
			vo.setNId(yujing.getNId().toString());
			vo.setNFy(yujing.getNFy().toString());
			vo.setNRybh(yujing.getNRybh().toString());
			vo.setDYjsj(DateUtil.format(yujing.getDYjsj(), DateUtil.webFormat));
			vo.setCYjsx(yujing.getCYjsx());
			vo.setCBz(yujing.getCBz());
			vos.add(vo);
		}
		return vos;
	}
	
}

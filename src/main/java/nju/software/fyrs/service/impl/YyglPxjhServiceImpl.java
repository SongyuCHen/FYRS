package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.YyglPxjhVO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dao.YyglPxjhDAO;
import nju.software.fyrs.data.dataobject.YyglPxjh;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.YyglPxjhService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.StringUtil;

public class YyglPxjhServiceImpl implements YyglPxjhService {
	private YyglPxjhDAO pxjhDAO;
	private DmService dmService;
	private RysxTablekeyDAO rysxTablekeyDAO;
	@Override
	public List<YyglPxjhVO> getPxjhByFy(String fydm) {
		// TODO Auto-generated method stub
		List<YyglPxjh> pxjhList = pxjhDAO.getYyglPxjhByFy(fydm);
		List<YyglPxjhVO> vos = new ArrayList<YyglPxjhVO>();
		for(YyglPxjh pxjh:pxjhList){
			YyglPxjhVO vo = new YyglPxjhVO();
			vo.setNId(pxjh.getNId().toString());
			vo.setNFy(pxjh.getNFy().toString());
			vo.setNJglb(dmService.getDmByMc(pxjh.getNJglb(), "培训机构"));
			vo.setNPxfs(dmService.getDmByMc(pxjh.getNPxfs(), "培训方式"));
			vo.setNPxxs(dmService.getDmByMc(pxjh.getNPxxs(), "学习形式"));
			vo.setNPxzl(dmService.getDmByMc(pxjh.getNPxzl(), "培训种类"));
			vo.setNXz(dmService.getDmByMc(pxjh.getNXz(), "培训性质"));
			vo.setNZy(dmService.getDmByMc(pxjh.getNZy(), "专业"));
			vo.setCPxbmc(pxjh.getCPxbmc());
			vo.setCPxdd(pxjh.getNPxdd());
			vo.setCPxdx(pxjh.getNPxdx());
			vo.setCPxjg(pxjh.getCPxjg());
			vo.setDJsrq(DateUtil.format(pxjh.getDJsrq(), DateUtil.webFormat));
			vo.setDKsrq(DateUtil.format(pxjh.getDKsrq(), DateUtil.webFormat));
			if(pxjh.getmPxys() != null ) vo.setMPxys(pxjh.getmPxys().toString());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public YyglPxjhVO getPxjhById(String id, String fydm) {
		// TODO Auto-generated method stub
		YyglPxjh pxjh = pxjhDAO.getYyglPxjhById(id, fydm);
		YyglPxjhVO vo = new YyglPxjhVO();
		vo.setNId(pxjh.getNId().toString());
		vo.setNFy(pxjh.getNFy().toString());
		vo.setNJglb(dmService.getDmByMc(pxjh.getNJglb(), "培训机构"));
		vo.setNPxfs(dmService.getDmByMc(pxjh.getNPxfs(), "培训方式"));
		vo.setNPxxs(dmService.getDmByMc(pxjh.getNPxxs(), "学习形式"));
		vo.setNPxzl(dmService.getDmByMc(pxjh.getNPxzl(), "培训种类"));
		vo.setNXz(dmService.getDmByMc(pxjh.getNXz(), "培训性质"));
		vo.setNZy(dmService.getDmByMc(pxjh.getNZy(), "专业"));
		vo.setCPxbmc(pxjh.getCPxbmc());
		vo.setCPxdd(pxjh.getNPxdd());
		vo.setCPxdx(pxjh.getNPxdx());
		vo.setCPxjg(pxjh.getCPxjg());
		vo.setDJsrq(DateUtil.format(pxjh.getDJsrq(), DateUtil.webFormat));
		vo.setDKsrq(DateUtil.format(pxjh.getDKsrq(), DateUtil.webFormat));
		vo.setMPxys(pxjh.getmPxys().toString());
		return vo;
	}

	@Override
	public YyglPxjhVO addPxjh(YyglPxjhVO vo) {
		// TODO Auto-generated method stub
		YyglPxjh pxjh = new YyglPxjh();
		int fydm = Integer.valueOf(vo.getNFy());
		pxjh.setNFy(fydm);
		pxjh.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_PXJHID"));
		pxjh.setCPxbmc(vo.getCPxbmc());
		pxjh.setCPxjg(vo.getCPxjg());
		pxjh.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		pxjh.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		if(!StringUtil.isBlank(vo.getMPxys())) pxjh.setmPxys(Double.valueOf(vo.getMPxys()));
		if(!StringUtil.isBlank(vo.getNJglb())) pxjh.setNJglb(Integer.parseInt(vo.getNJglb()));
		pxjh.setNPxdd(vo.getCPxdd());
		pxjh.setNPxdx(vo.getCPxdx());
		if(!StringUtil.isBlank(vo.getNPxfs())) pxjh.setNPxfs(Integer.parseInt(vo.getNPxfs()));
		if(!StringUtil.isBlank(vo.getNPxxs())) pxjh.setNPxxs(Integer.parseInt(vo.getNPxxs()));
		if(!StringUtil.isBlank(vo.getNPxzl())) pxjh.setNPxzl(Integer.parseInt(vo.getNPxzl()));
		if(!StringUtil.isBlank(vo.getNXz())) pxjh.setNXz(Short.valueOf(vo.getNXz()));
		if(!StringUtil.isBlank(vo.getNZy())) pxjh.setNZy(Integer.parseInt(vo.getNZy()));
		pxjhDAO.save(pxjh);
		vo.setNId(pxjh.getNId().toString());
		if(vo.getNJglb() != null)
			vo.setNJglb(dmService.getDmByMc(pxjh.getNJglb(), "培训机构"));
		if(vo.getNPxfs() != null)
			vo.setNPxfs(dmService.getDmByMc(pxjh.getNPxfs(), "培训方式"));
		if(vo.getNPxxs() != null)
			vo.setNPxxs(dmService.getDmByMc(pxjh.getNPxxs(), "学习形式"));
		if(vo.getNPxzl() != null)
			vo.setNPxzl(dmService.getDmByMc(pxjh.getNPxzl(), "培训种类"));
		if(vo.getNXz() != null)
			vo.setNXz(dmService.getDmByMc(pxjh.getNXz(), "培训性质"));
		if(vo.getNZy() != null)
			vo.setNZy(dmService.getDmByMc(pxjh.getNZy(), "专业"));
		return vo;
	}

	@Override
	public YyglPxjhVO updatePxjh(YyglPxjhVO vo) {
		// TODO Auto-generated method stub
		String id = vo.getNId();
		String fydm = vo.getNFy();
		YyglPxjh pxjh = pxjhDAO.getYyglPxjhById(id, fydm);
		pxjh.setCPxbmc(vo.getCPxbmc());
		pxjh.setCPxjg(vo.getCPxjg());
		pxjh.setDJsrq(DateUtil.parse(vo.getDJsrq(), DateUtil.webFormat));
		pxjh.setDKsrq(DateUtil.parse(vo.getDKsrq(), DateUtil.webFormat));
		pxjh.setmPxys(Double.valueOf(vo.getMPxys()));
		if(vo.getNJglb() != null) pxjh.setNJglb(Integer.parseInt(vo.getNJglb()));
		pxjh.setNPxdd(vo.getCPxdd());
		pxjh.setNPxdx(vo.getCPxdx());
		if(vo.getNPxfs() != null) pxjh.setNPxfs(Integer.parseInt(vo.getNPxfs()));
		if(vo.getNPxxs() != null) pxjh.setNPxxs(Integer.parseInt(vo.getNPxxs()));
		if(vo.getNPxzl() != null) pxjh.setNPxzl(Integer.parseInt(vo.getNPxzl()));
		if(vo.getNXz() != null) pxjh.setNXz(Short.valueOf(vo.getNXz()));
		if(vo.getNZy() != null) pxjh.setNZy(Integer.parseInt(vo.getNZy()));
		pxjhDAO.update(pxjh);
		return vo;
	}

	@Override
	public boolean delPxjhById(String id, String fydm) {
		// TODO Auto-generated method stub
		return pxjhDAO.delYyglPxjhById(id);
	}


	public void setPxjhDAO(YyglPxjhDAO pxjhDAO) {
		this.pxjhDAO = pxjhDAO;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO) {
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}

}

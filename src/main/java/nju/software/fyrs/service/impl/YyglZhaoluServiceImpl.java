package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.YyglZhaoluVO;
import nju.software.fyrs.data.dao.RysxTablekeyDAO;
import nju.software.fyrs.data.dao.YyglZhaoluDAO;
import nju.software.fyrs.data.dataobject.YyglZhaolu;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.YyglZhaoluService;

public class YyglZhaoluServiceImpl implements YyglZhaoluService {
	private YyglZhaoluDAO zhaoluDAO;
	private DmService dmService;
	private RysxTablekeyDAO rysxTablekeyDAO;
	@Override
	public List<YyglZhaoluVO> getZhaoluByFy(String fydm) {
		// TODO Auto-generated method stub
		List<YyglZhaolu> zhaoluList = zhaoluDAO.getYyglZhaoluByFy(fydm);
		List<YyglZhaoluVO> vos = new ArrayList<YyglZhaoluVO>();
		for(YyglZhaolu zhaolu:zhaoluList){
			YyglZhaoluVO vo = new YyglZhaoluVO();
			vo.setNId(zhaolu.getNId().toString());
			vo.setNFy(zhaolu.getNFy().toString());
			vo.setNZpgw(dmService.getDmByMc(zhaolu.getNZpgw(), "行政职务"));
			vo.setNZprs(zhaolu.getNZprs().toString());
			vo.setCBh(zhaolu.getCBh());
			vo.setCPc(zhaolu.getCPc());
			vo.setCZplc(zhaolu.getCZplc());
			vo.setCZpyq(zhaolu.getCZpyq());
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public YyglZhaoluVO getZhaoluById(String id, String fydm) {
		// TODO Auto-generated method stub
		YyglZhaolu zhaolu = zhaoluDAO.getYyglZhaoluById(id, fydm);
		YyglZhaoluVO vo = new YyglZhaoluVO();
		vo.setNId(zhaolu.getNId().toString());
		vo.setNFy(zhaolu.getNFy().toString());
		vo.setNZpgw(dmService.getDmByMc(zhaolu.getNZpgw(), "行政职务"));
		vo.setNZprs(zhaolu.getNZprs().toString());
		vo.setCBh(zhaolu.getCBh());
		vo.setCPc(zhaolu.getCPc());
		vo.setCZplc(zhaolu.getCZplc());
		vo.setCZpyq(zhaolu.getCZpyq());
		return vo;
	}

	@Override
	public YyglZhaoluVO addZhaolu(YyglZhaoluVO vo) {
		// TODO Auto-generated method stub
		YyglZhaolu zhaolu = new YyglZhaolu();
		int fydm = Integer.valueOf(vo.getNFy());
		zhaolu.setNId(rysxTablekeyDAO.getMaxId(fydm, "N_ZHAOLUID"));
		zhaolu.setNFy(fydm);
		zhaolu.setCBh(vo.getCBh());
		zhaolu.setCPc(vo.getCPc());
		zhaolu.setCZplc(vo.getCZplc());
		zhaolu.setCZpyq(vo.getCZpyq());
		if(vo.getNZprs() != null) zhaolu.setNZprs(Integer.parseInt(vo.getNZprs()));
		if(vo.getNZpgw() != null) zhaolu.setNZpgw(Integer.parseInt(vo.getNZpgw()));
		zhaoluDAO.save(zhaolu);
		vo.setNId(zhaolu.getNId().toString());
		if(vo.getNZpgw() != null) vo.setNZpgw(dmService.getDmByMc(zhaolu.getNZpgw(), "行政职务"));
		return vo;
		
	}

	@Override
	public YyglZhaoluVO updateZhaolu(YyglZhaoluVO vo) {
		// TODO Auto-generated method stub
		String id = vo.getNId();
		String fydm = vo.getNFy();
		YyglZhaolu zhaolu = zhaoluDAO.getYyglZhaoluById(id, fydm);
		zhaolu.setCBh(vo.getCBh());
		zhaolu.setCZplc(vo.getCZplc());
		zhaolu.setCPc(vo.getCPc());
		zhaolu.setCZpyq(vo.getCZpyq());
		if(vo.getNZpgw() != null) zhaolu.setNZpgw(Integer.parseInt(vo.getNZpgw()));
		if(vo.getNZprs() != null) zhaolu.setNZprs(Integer.parseInt(vo.getNZprs()));
		zhaoluDAO.update(zhaolu);
		return vo;
	}

	@Override
	public boolean delZhaoluById(String id, String fydm) {
		// TODO Auto-generated method stub
		return zhaoluDAO.delYyglZhaoluById(id);
	}

	public void setZhaoluDAO(YyglZhaoluDAO zhaoluDAO) {
		this.zhaoluDAO = zhaoluDAO;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRysxTablekeyDAO(RysxTablekeyDAO rysxTablekeyDAO) {
		this.rysxTablekeyDAO = rysxTablekeyDAO;
	}

}

package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RykFzbDAO;
import nju.software.fyrs.data.dao.RykRcDAO;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RykFzb;
import nju.software.fyrs.data.dataobject.RykRc;
import nju.software.fyrs.service.RykService;
import nju.software.fyrs.service.convertor.RyviewConvertor;
import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.Ryklx;
import nju.software.fyrs.service.model.RyviewModel;

public class RykServiceImpl implements RykService {

	RyjbxxDAO ryjbxxDAO;
	RykRcDAO rykRcDAO;
	RykFzbDAO rykFzbDAO;
	RyviewConvertor ryviewConvertor;

	@Override
	public List<RyviewModel> getRyviewList(RykcxModel cx) {
		List<RyviewModel> ryList = new ArrayList<RyviewModel>();
		switch (cx.getCxlx()) {
		case Ryklx.ZZK:
			List<Ryjbxx> zzList = ryjbxxDAO.getRyListByFyAndBm(cx.getFydm(),
					cx.getBmdm());
			for (Ryjbxx ry : zzList) {
				ryList.add(ryviewConvertor.getViewByRy(ry));
			}
			return ryList;
		case Ryklx.LSK:
			if (cx.getLsklx() == 1) {
				List<Ryjbxx> lsList = ryjbxxDAO.getLsryListByFyAndBm(
						cx.getFydm(), cx.getBmdm());
				for (Ryjbxx ry : lsList) {
					ryList.add(ryviewConvertor.getViewByRy(ry));
				}
				return ryList;
			} else if (cx.getLsklx() < 4) { // 非在编人员历史库
				List<RykFzb> fzbList = rykFzbDAO.getFzbListByFyAndBm(
						cx.getFydm(), cx.getBmdm(), cx.getLsklx() - 1, 1);
				for (RykFzb fzb : fzbList) {
					ryList.add(ryviewConvertor.getViewByFzb(fzb));
				}
				return ryList;
			} else { // 人才库历史库
				List<RykRc> rcList = rykRcDAO.getRcListByFyAndBm(cx.getFydm(),
						cx.getBmdm(), cx.getLsklx() - 3, 1);
				for (RykRc rc : rcList) {
					ryList.add(ryviewConvertor.getViewByRc(rc));
				}
				return ryList;
			}
		case Ryklx.RCK:
			List<RykRc> rcList = rykRcDAO.getRcListByFyAndBm(cx.getFydm(),
					cx.getBmdm(), cx.getRcklx(), 0);
			for (RykRc rc : rcList) {
				ryList.add(ryviewConvertor.getViewByRc(rc));
			}
			return ryList;
		case Ryklx.FZBRYK:
			List<RykFzb> fzbList = rykFzbDAO.getFzbListByFyAndBm(cx.getFydm(),
					cx.getBmdm(), cx.getFzbrylx(), 0);
			for (RykFzb fzb : fzbList) {
				ryList.add(ryviewConvertor.getViewByFzb(fzb));
			}
			return ryList;
		default:
			// should not be here
		}
		return ryList;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}

	public void setRyviewConvertor(RyviewConvertor ryviewConvertor) {
		this.ryviewConvertor = ryviewConvertor;
	}

	public void setRykRcDAO(RykRcDAO rykRcDAO) {
		this.rykRcDAO = rykRcDAO;
	}

	public void setRykFzbDAO(RykFzbDAO rykFzbDAO) {
		this.rykFzbDAO = rykFzbDAO;
	}

	@Override
	public boolean swapOrder(Integer fydm, Integer rybh1, Integer rybh2) {
		Ryjbxx ry1 = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh1, fydm);
		Ryjbxx ry2 = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh2, fydm);
		int temp = ry1.getNXssx();
		ry1.setNXssx(ry2.getNXssx());
		ry2.setNXssx((short) temp);
		ryjbxxDAO.saveOrUpdate(ry1);
		ryjbxxDAO.saveOrUpdate(ry2);
		return ry1 != null && ry2 != null;
	}

	@Override
	public boolean swapRcOrder(Integer fydm, Integer rybh1, Integer rybh2,
			Integer rcklx) {
		RykRc ry1 = rykRcDAO.getRcxxByRybhFyRcklx(rybh1, fydm, rcklx);
		RykRc ry2 = rykRcDAO.getRcxxByRybhFyRcklx(rybh2, fydm, rcklx);
		int temp = ry1.getNXssx();
		ry1.setNXssx(ry2.getNXssx());
		ry2.setNXssx(temp);
		rykRcDAO.saveOrUpdate(ry1);
		rykRcDAO.saveOrUpdate(ry2);
		return ry1 != null && ry2 != null;
	}

//	@Override
//	public boolean addRc(int rybh, int fydm, int rcklx) {
//		Ryjbxx ry = ryjbxxDAO.getRyjbxxByRybhFyDm(rybh, fydm);
//		RykRc rc = rykRcDAO.getRcxxByRybhFyRcklx(rybh, fydm, rcklx);
//		if (rc != null) {
//			if (rc.getNSfls() == 1) {
//				rc.setNSfls(0);
//				rykRcDAO.saveOrUpdate(rc);
//			}
//		} else {
//			rc = new RykRc(rykRcDAO.getMaxNid(fydm).intValue(), fydm, rybh,
//					ry.getNBm(), rcklx, rykRcDAO.getMaxNXssx(fydm), 0);
//			rykRcDAO.save(rc);
//		}
//		return true;
//	}

	@Override
	public boolean moveToHistory(Integer fydm, Integer rybh, Integer rcklx) {
		RykRc rc = rykRcDAO.getRcxxByRybhFyRcklx(rybh, fydm, rcklx);
		rc.setNSfls(1);
		rykRcDAO.saveOrUpdate(rc);
		return true;
	}

	@Override
	public boolean addFzbry(Integer fydm, Integer rybh, Integer fzbrylx,
			Integer bm) {
		RykFzb fzb = rykFzbDAO.getFzbByRybhFyFzbrylx(rybh, fydm, fzbrylx);
		if (fzb != null) {
			if (fzb.getNSfls() == 1) {
				fzb.setNSfls(0);
				rykFzbDAO.update(fzb);
			}
		} else {
			fzb = new RykFzb(rykFzbDAO.getMaxNid(fydm), fydm, rybh, bm,
					fzbrylx, rykFzbDAO.getMaxNXssx(fydm), 0);
			rykFzbDAO.save(fzb);
		}
		return true;
	}

	@Override
	public boolean moveToFzbHistory(Integer fydm, Integer rybh, Integer bm,
			Integer fzbrylx) {
		RykFzb fzb = rykFzbDAO.getFzbByRybhFyFzbrylx(rybh, fydm, fzbrylx);
		fzb.setNSfls(1);
		rykFzbDAO.update(fzb);
		return true;
	}
}

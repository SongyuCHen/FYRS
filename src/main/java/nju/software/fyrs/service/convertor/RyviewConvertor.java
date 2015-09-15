package nju.software.fyrs.service.convertor;

import nju.software.fyrs.biz.vo.RyjbxxFzbVO;
import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.RyjbxxDAO;
import nju.software.fyrs.data.dao.RyjbxxFzbDAO;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.data.dataobject.RyjbxxFzb;
import nju.software.fyrs.data.dataobject.RykFzb;
import nju.software.fyrs.data.dataobject.RykRc;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.StringUtil;

/**
 * @author Admin convertor ryjbxx to ryviewmodel
 */
public class RyviewConvertor {

	DmDAO dmDAO;
	DmService dmService;
	RyjbxxDAO ryjbxxDAO;
	RyjbxxFzbDAO ryjbxxFzbDAO;

	public void setRyjbxxFzbDAO(RyjbxxFzbDAO ryjbxxFzbDAO) {
		this.ryjbxxFzbDAO = ryjbxxFzbDAO;
	}
	
	public RyviewModel getViewByRy(Ryjbxx ryjbxx) {
		RyviewModel ryView = new RyviewModel();
		ryView.setRybh(String.valueOf(ryjbxx.getNRybh()));
		ryView.setFy(String.valueOf(ryjbxx.getNFy()));
		ryView.setXm(ryjbxx.getCXm());
		if(ryjbxx.getNXb()!=null)ryView.setXb(dmService.findDmByNBxhNdm("3", ryjbxx.getNXb()).getCMc());
		if(ryjbxx.getNFy()!=null&&ryjbxx.getNRybh()!=null)ryView.setShowKey(NFyRybhCodeUtils.encode(ryjbxx.getNFy(),
				ryjbxx.getNRybh()));
		if(ryjbxx.getDCsrq()!=null)ryView.setNl(String.valueOf(DateUtil.getAge(ryjbxx.getDCsrq())));
		if(ryjbxx.getNXzzw()!=null)ryView.setXzzw(dmService.findDmByNBxhNdm("15", ryjbxx.getNXzzw())
				.getCMc());
		if(ryjbxx.getNZj()!=null)ryView.setZj(dmService.findDmByNBxhNdm("17", ryjbxx.getNZj()).getCMc());
		if(ryjbxx.getNXl()!=null)ryView.setXl(dmService.findDmByNBxhNdm("11", ryjbxx.getNXl()).getCMc());
																				// 此处学位用了文化程度
		return ryView;
	}

	public RyviewModel getViewByRc(RykRc rc) {
		Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(rc.getNRybh(),
				rc.getNFy());
		return getViewByRy(ryjbxx);
	}

	public RyviewModel getViewByFzb(RykFzb fzb) {
		if (fzb.getNFzblx() == 1) {
			Ryjbxx ryjbxx = ryjbxxDAO.getRyjbxxByRybhFyDm(fzb.getNRybh(),
					fzb.getNFy());
			return getViewByRy(ryjbxx);
		} else {
			RyjbxxFzb ryjbxxFzb = ryjbxxFzbDAO.getRyjbxxFzbByRybhFyDm(
					fzb.getNRybh(), fzb.getNFy());
			return getViewByRyFzb(ryjbxxFzb);
		}
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRyjbxxDAO(RyjbxxDAO ryjbxxDAO) {
		this.ryjbxxDAO = ryjbxxDAO;
	}

	public void setDmDAO(DmDAO dmDAO) {
		this.dmDAO = dmDAO;
	}

	private RyviewModel getViewByRyFzb(RyjbxxFzb ryjbxxFzb) {
		RyviewModel ryView = new RyviewModel();
		ryView.setRybh(String.valueOf(ryjbxxFzb.getNRybh()));
		ryView.setFy(String.valueOf(ryjbxxFzb.getNFy()));
		ryView.setXm(ryjbxxFzb.getCXm());
		ryView.setXb(dmService.findDmByNBxhNdm("3", ryjbxxFzb.getNXb())
				.getCMc());
		ryView.setShowKey(NFyRybhCodeUtils.encode(ryjbxxFzb.getNFy(),
				ryjbxxFzb.getNRybh()));
		ryView.setNl(String.valueOf(DateUtil.getAge(ryjbxxFzb.getDCsrq())));
		ryView.setXzzw(dmService.findDmByNBxhNdm("15", ryjbxxFzb.getNGz())
				.getCMc());
		ryView.setZj(" ");
		ryView.setXl(dmService.findDmByNBxhNdm("11", ryjbxxFzb.getNXl())
				.getCMc());// 此处学位用了文化程度
		return ryView;
	}
	
	
	//非在编人员基本信息的转换
	public RyjbxxFzbVO getfzbByDO(RyjbxxFzb fzb){
		RyjbxxFzbVO vo = new RyjbxxFzbVO();
		vo.setCCsd(fzb.getCCsd());
		vo.setCCym(fzb.getCCym());
		vo.setCJg(fzb.getCJg());
		vo.setCJly(fzb.getCJly());
		vo.setCJtj(fzb.getCJtj());
		vo.setCSfzh(fzb.getCSfzh());
		vo.setCXm(fzb.getCXm());
		vo.setCZyzs(fzb.getCZyzs());
		vo.setNRybh(String.valueOf(fzb.getNRybh()));
		
		vo.setDCrq(DateUtil.format(fzb.getDCrq(), DateUtil.webFormat));
		vo.setDCsrq(DateUtil.format(fzb.getDCsrq(), DateUtil.webFormat));
		vo.setDGzrq(DateUtil.format(fzb.getDGzrq(), DateUtil.webFormat));
		vo.setDHdxwrq(DateUtil.format(fzb.getDHdxwrq(), DateUtil.webFormat));
		vo.setDHdzsrq(DateUtil.format(fzb.getDHdzsrq(), DateUtil.webFormat));
		vo.setDJyrq(DateUtil.format(fzb.getDJyrq(), DateUtil.webFormat));
		vo.setDShrq(DateUtil.format(fzb.getDShrq(), DateUtil.webFormat));
		vo.setDZzmm(DateUtil.format(fzb.getDZzmm(), DateUtil.webFormat));

		vo.setNBm(dmDAO.getDmByMc(fzb.getNBm(), "内设机构"));
		vo.setNXb(dmDAO.getDmByMc(fzb.getNXb(), "性别"));
		vo.setNMz(dmDAO.getDmByMc(fzb.getNMz(), "民族"));
		vo.setNHyzk(dmDAO.getDmByMc(fzb.getNHyzk(), "婚姻状况"));
		vo.setNJkzk(dmDAO.getDmByMc(fzb.getNJkzk(), "健康状况"));
		vo.setNZzmm(dmDAO.getDmByMc(fzb.getNZzmm(), "政治面貌"));
		vo.setNGz(dmDAO.getDmByMc(fzb.getNGz(), "工种"));
		vo.setNXl(dmDAO.getDmByMc(fzb.getNXl(), "文化程度"));
		vo.setNXw(dmDAO.getDmByMc(fzb.getNXw(), "学位"));
		vo.setNZy(dmDAO.getDmByMc(fzb.getNZy(), "专业"));	
		if(fzb.getNCyy() != null){
			vo.setNCyy(dmDAO.getDmByMc(fzb.getNCyy(), "调离原因"));
		}else{
			vo.setNCyy("");
		}
		return vo;
	}
	public RyjbxxFzb getfzbByVO(RyjbxxFzbVO vo) {
		RyjbxxFzb fzb = new RyjbxxFzb();
		fzb.setCCsd(vo.getCCsd());
		fzb.setCCym(vo.getCCym());
		fzb.setCJg(vo.getCJg());
		fzb.setCJly(vo.getCJly());
		fzb.setCJtj(vo.getCJtj());
		fzb.setCSfzh(vo.getCSfzh());
		fzb.setCXm(vo.getCXm());
		fzb.setCZyzs(vo.getCZyzs());
		
		if(StringUtil.isNotBlank(vo.getDCrq())){
			fzb.setDCrq(DateUtil.parse(vo.getDCrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDCsrq())){
			fzb.setDCsrq(DateUtil.parse(vo.getDCsrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDGzrq())){
			fzb.setDGzrq(DateUtil.parse(vo.getDGzrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDHdxwrq())){
			fzb.setDHdxwrq(DateUtil.parse(vo.getDHdxwrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDHdzsrq())){
			fzb.setDHdzsrq(DateUtil.parse(vo.getDHdzsrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDJyrq())){
			fzb.setDJyrq(DateUtil.parse(vo.getDJyrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDShrq())){
			fzb.setDShrq(DateUtil.parse(vo.getDShrq(), DateUtil.webFormat));
		}
		if(StringUtil.isNotBlank(vo.getDZzmm())){
			fzb.setDZzmm(DateUtil.parse(vo.getDZzmm(), DateUtil.webFormat));
		}
		
		if(StringUtil.isNotBlank(vo.getNBm())){
			fzb.setNBm(Integer.valueOf(vo.getNBm()));
		}
		if(StringUtil.isNotBlank(vo.getNXb())){
			fzb.setNXb(Integer.valueOf(vo.getNXb()));
		}
		if(StringUtil.isNotBlank(vo.getNMz())){
			fzb.setNMz(Integer.valueOf(vo.getNMz()));
		}
		if(StringUtil.isNotBlank(vo.getNHyzk())){
			fzb.setNHyzk(Integer.valueOf(vo.getNHyzk()));
		}
		if(StringUtil.isNotBlank(vo.getNJkzk())){
			fzb.setNJkzk(Integer.valueOf(vo.getNJkzk()));
		}
		if(StringUtil.isNotBlank(vo.getNZzmm())){
			fzb.setNZzmm(Integer.valueOf(vo.getNZzmm()));
		}
		if(StringUtil.isNotBlank(vo.getNGz())){
			fzb.setNGz(Integer.valueOf(vo.getNGz()));
		}
		if(StringUtil.isNotBlank(vo.getNXl())){
			fzb.setNXl(Integer.valueOf(vo.getNXl()));
		}
		if(StringUtil.isNotBlank(vo.getNXw())){
			fzb.setNXw(Integer.valueOf(vo.getNXw()));
		}
		if(StringUtil.isNotBlank(vo.getNZy())){
			fzb.setNZy(Integer.valueOf(vo.getNZy()));
		}
		if(StringUtil.isNotBlank(vo.getNCyy())){
			fzb.setNCyy(Integer.valueOf(vo.getNCyy()));
		}
		return fzb;
	}
}

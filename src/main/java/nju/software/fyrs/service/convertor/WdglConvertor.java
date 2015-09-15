package nju.software.fyrs.service.convertor;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.WdVO;
import nju.software.fyrs.data.dataobject.Wdgl;
import nju.software.fyrs.util.DateUtil;

public class WdglConvertor {
	
	public static WdVO getWdVOByWdgl(Wdgl wdgl){
		WdVO vo = new WdVO();
		vo.setWdbh(wdgl.getWdbh());
		vo.setFwh(wdgl.getFwh());
		vo.setBt(wdgl.getBt());
		vo.setWdms(wdgl.getWdms());
		vo.setWdnr(wdgl.getWdnr());
		vo.setWdlj(wdgl.getWdlj());
		vo.setWdywjm(wdgl.getWdywjm());
		vo.setUserid(wdgl.getUserid());
		//”√ªß°£°£
		vo.setFwsj(DateUtil.format(wdgl.getFwsj(), DateUtil.chineseDtFormat));
		vo.setZjxgsj(DateUtil.format(wdgl.getZjxgsj(), DateUtil.chineseDtFormat));
		return vo;
	}
	
	public static List<WdVO> getWdVOList(List<Wdgl> wdglList){
		List<WdVO> wdVOList = new ArrayList<WdVO>();
		if(wdglList!=null && !wdglList.isEmpty()){
			for(Wdgl wdgl : wdglList){
				wdVOList.add(getWdVOByWdgl(wdgl));
			}
		}
		return wdVOList;
	}
}

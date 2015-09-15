package nju.software.fyrs.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.XtglMcDmVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DmService;

public class DmCommonList {
  public static String[] addNum = {"0000","000","00","0",""};
  public static List<DmCommonVO> listDmCommonVO(List<Dm> dms)
  {
	  List<DmCommonVO> vos = new ArrayList<DmCommonVO>();
	  for(Dm dm : dms)
	  {
		  DmCommonVO vo = new DmCommonVO(); 
		  vo.setNDm(dm.getNDm());
		  vo.setCMc(dm.getCMc());
		  vos.add(vo);
	  }
	  return vos;
  }
  public static List<DmCommonVO> listDmCommonVO(DmService dmService,String nbxh)
  {
	  List<Dm> dms = dmService.listDmByNBxh(nbxh);
	  return listDmCommonVO(dms);
  }
  public static List<DmCommonVO> listDmCommonVOHidden(DmService dmService,String nbxh)
  {
	  List<DmCommonVO> vos = new ArrayList<DmCommonVO>();
	  List<Dm> dms = dmService.listDmByNBxh(nbxh);
	  String[] strs = {"一","二","三","四","五","六","七","八","九","十","十一","十二","十三","十四","十五","十六","十七","十八","十九","二十","二十一","二十二","二十三","二十四","二十五","二十六","二十七","二十八","二十九","三十","三十一","三十二","三十三","三十四","三十五","三十六"};
	  for(Dm dm : dms)
	  {
		  // 
		  if(dm.getNDm() == 74 && dm.getNBxh() == 700)
		  {
			  for(int i = 0; i < 7;i++)
			  {
				  DmCommonVO vo = new DmCommonVO(); 
				  vo.setNDm(dm.getNDm()+i);
				  vo.setCMc("其他业务部门"+strs[i]);
				  vos.add(vo);
			  }
		  }
		  else if(dm.getNDm() == 81 && dm.getNBxh() == 700)
		  {
			  for(int i = 0; i < 7;i++)
			  {
				  DmCommonVO vo = new DmCommonVO(); 
				  vo.setNDm(dm.getNDm()+i);
				  vo.setCMc("其他行政后勤部门"+strs[i]);
				  vos.add(vo);
			  }
		  }
		  else if(dm.getNDm() == 88 && dm.getNBxh() == 700)
		  {
			  for(int i = 0; i < 36;i++)
			  {
				  DmCommonVO vo = new DmCommonVO(); 
				  vo.setNDm(dm.getNDm()+i);
				  vo.setCMc("第"+strs[i]+"人民法庭");
				  vos.add(vo);
			  }
		  }
		  else
		  {
			  DmCommonVO vo = new DmCommonVO(); 
			  vo.setNDm(dm.getNDm());
			  vo.setCMc(dm.getCMc());
			  vos.add(vo);
		  }
		  
		  
		  
	  }
	  return vos;
  }
  public static void listAllCommon(Model model,int[] types,String[] names,DmService dmService)
  {
  	  for(int i = 0; i < types.length; i++)
  	  {
  		  List<Dm> dms = dmService.listDmByNBxh(String.valueOf(types[i]));
			  List<XtglMcDmVO> vos = new ArrayList<XtglMcDmVO>();
		       for(Dm dm : dms)
		       {
		    	   XtglMcDmVO xtglMcDmVO = new XtglMcDmVO();
		    	   xtglMcDmVO.setCMc(dm.getCMc());
		    	   xtglMcDmVO.setNBxh(dm.getNBxh());
		    	   xtglMcDmVO.setNDm(dm.getNDm());
		    	   vos.add(xtglMcDmVO);
		       } 
		      model.addAttribute(names[i],vos);
  	  }
		 
  }
 
}

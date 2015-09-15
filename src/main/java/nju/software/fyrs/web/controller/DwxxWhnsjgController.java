package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.DmCommonVO;
import nju.software.fyrs.biz.vo.DwxxWhnsjgVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxWhnsjgController {
	  private RoleMenuService roleMenuService;
	  private JgxxService jgxxService; 
	  private DmService dmService;
	  
	 @RequestMapping(value="/whnsjg.do",method = RequestMethod.GET)
	    public String showWhnsjg(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	      
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"单位信息");
	       MenuShowUtils.leftMenu(request,model, roleMenuService, "dwxx");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","维护内设机构");
	       return "whnsjg/show";
	    }
	 @RequestMapping(value="/whnsjgDetail.aj",method = RequestMethod.POST)
	    public void whnsjgDetail(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  String fydm = request.getParameter("fydm");
		  String bmbh = request.getParameter("bmbh");
		  List<Jgxx> jgxxs = null;
		  if(!bmbh.trim().equals(""))
		  {
			  jgxxs = new ArrayList<Jgxx>();
			  jgxxs.add(jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh)));
		  }
		  else
		  {
			  jgxxs = jgxxService.bmByFyIdXssx(Integer.valueOf(fydm));
		  }
	      String fyMc = dmService.findFymc(Integer.valueOf(fydm));
	      List<DwxxWhnsjgVO> vos = new ArrayList<DwxxWhnsjgVO>();
	      for(Jgxx jg : jgxxs)
	      {
	    	  DwxxWhnsjgVO vo = new DwxxWhnsjgVO();
	    	  vo.setFydm(Integer.valueOf(fydm));
	    	  vo.setNFy(fyMc);
	    	  vo.setNCode(jg.getNCode());
	    	  if(jg.getCStname() == null)
	    	  {
	    		  vo.setCStname("");
	    	  }
	    	  else
	    	  {
	    		  vo.setCStname(jg.getCStname());
	    	  }	    	 
	    	  vo.setCName(jg.getCName());
	    	  vo.setNLevel(jg.getNLevel());
	    	  vo.setNZgldzw("");
	    	  // 行政职务的类别是 15 ，所以根据它来获得编码对象的名称
	    	  if(null != jg.getNZgldzw())
	    	  {
	    		  vo.setNZgldzw(dmService.findDmByNBxhNdm(ConstantsFyrs.NBXH_XZZW+"", jg.getNZgldzw()).getCMc());
	    	  }
	    	  vo.setNBmxz("");
	    	  if(null !=jg.getNBmxz()){
	    		  vo.setNBmxz(dmService.findDmByNBxhNdm(ConstantsFyrs.BMXZ+"", jg.getNBmxz()).getCMc());
	    	  }
	    	  
	    	  vos.add(vo);
	    	  // 获得最高领导职务
	      }
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response,vos);
	    }
	 @RequestMapping(value="/whnsjgBmPop.aj",method = RequestMethod.POST)
	    public String  whnsjgBmPop(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String lvlevel = request.getParameter("lvlevel");
		 String btnType = request.getParameter("btnType");
		 String nlevel = request.getParameter("nlevel");
		 String isOnlyBm = request.getParameter("isOnlyBm");
		 
         // 表示修改
		 if(btnType.equals("2"))
		 {
			 Jgxx jgxx = jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
			 model.addAttribute("jgxx",jgxx);
			 nlevel = jgxx.getNLevel()+"";
		 }
		 model.addAttribute("fydm",fydm);
		 model.addAttribute("bmbh",bmbh);
		 model.addAttribute("lvlevel",lvlevel);
		 model.addAttribute("btnType",btnType);
		 model.addAttribute("nlevel",nlevel);
		 model.addAttribute("isOnlyBm",isOnlyBm);
		 
		 List<DmCommonVO> zgldzw = DmCommonList.listDmCommonVOHidden(dmService, ConstantsFyrs.NBXH_ZGLDZW+"");
		 model.addAttribute("zgldzws", zgldzw);
		 List<DmCommonVO> bmbn = DmCommonList.listDmCommonVOHidden(dmService,ConstantsFyrs.NBXH_BMJC_NSJG+"");
		 model.addAttribute("bmbns", bmbn);
		 List<DmCommonVO> bmxz = DmCommonList.listDmCommonVO(dmService,ConstantsFyrs.BMXZ+"");
		 model.addAttribute("bmxz",bmxz);
		  return "/dwxx/pop/whnsjgBmPop";
	    }
	 
	 @RequestMapping(value="/whnsjgBmSave.aj",method = RequestMethod.POST)
	    public void whnsjgBmSave(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 String bzmcDm = request.getParameter("bzmcDm");
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String lvlevel = request.getParameter("lvlevel");
		 String bzmc = request.getParameter("bzmc");
		 String zgldzw = request.getParameter("zgldzw");
		 String bmxz = request.getParameter("bmxz");
		 String bmmc = request.getParameter("bmmc");
		 String btnType = request.getParameter("btnType");
		 String isOnlyBm = request.getParameter("isOnlyBm");
		 ResponseBuilder rb = new ResponseBuilder();
		 boolean isExist = false;
		 		
		 Jgxx jgxx = null;
		 //TempUtils.requestParameter(request);
		 // 表示添加,添加之前判断是否存在这个名称
         if(btnType.trim().equals("0"))
         {
        	 // 表示在法院下面添加部门，所以会包含标准名称
    		 if(isOnlyBm.equals("0"))
    		 {
    			 // 表示该标准部门已经存在
    			 isExist = jgxxService.isExistBzbm(Integer.valueOf(fydm),Integer.valueOf(bzmcDm));
    			 if(isExist)
    			 {
    				 // 标准名称存在
    				 rb.writeJsonResponse(response, "3");
    				 return;
    			 }
    			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,1,Integer.valueOf(bmxz));
    			 if(isExist)
    			 {
    				 // 部门名称存在
    				 rb.writeJsonResponse(response, "4");
    				 return;
    			 }
    		 }
    		 // 只是添加一个部门名称
    		 else
    		 {
    			 int level = -1;
    			 if(lvlevel.trim().substring(4).equals("00000000"))
    			 {
    				 level = 2;
    			 }
    			 if(!lvlevel.trim().substring(4).equals("00000000") && lvlevel.trim().substring(4).equals("0000"))
    			 {
    				 level = 3;
    			 }
    			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,level,Integer.valueOf(bmxz));
    			 if(isExist)
    			 {
    				 // 部门名称存在
    				 rb.writeJsonResponse(response, "4");
    				 return;
    			 }
    		 }
        	 jgxx =  new Jgxx();
        	 // 在法院下添加一个部门
        	if(isOnlyBm.equals("0"))
        	{
        		jgxx.setNFy(Integer.valueOf(fydm));
        		jgxx.setNCode(Integer.valueOf(bzmcDm));
        		jgxx.setNLevel((short)1);
        		jgxx.setCName(bmmc);
        		jgxx.setCStname(bzmc);
        		jgxx.setCLvlcode((DmCommonList.addNum[bzmcDm.trim().length()])+bzmcDm.trim()+"00000000");        		
        		jgxx.setNZgldzw(Integer.valueOf(zgldzw));
        		jgxx.setNBmxz(Integer.valueOf(bmxz));
        		// 表示这个部门的人数
        		jgxx.setNRysl(0);
        		jgxx.setNYx(1);
        		Jgxx re = jgxxService.addJgxxBzbm(jgxx);
        		rb.writeJsonResponse(response, "success"+"-"+re.getNCode()+"-"+re.getCLvlcode());
        	}
        	// 在当前部门添加一个子部门
        	else
        	{
        		jgxx.setNFy(Integer.valueOf(fydm));
        		jgxx.setCName(bmmc);
        		// 说明是二级节点
        		if(lvlevel.substring(4,8).equals("0000"))
        		{
        			jgxx.setNLevel((short)2);
        		}
        		// 说明是最后一级节点
        		else
        		{
        			jgxx.setNLevel((short)3);
        		}
        		jgxx.setCLvlcode(lvlevel);
        		Jgxx re = jgxxService.addJgxxOnlyBm(jgxx);
        		rb.writeJsonResponse(response, "success"+"-"+re.getNCode()+"-"+re.getCLvlcode());
        	}
         }
         // 表示修改
		 if(btnType.trim().equals("2")) 
		 {
			Jgxx jgxxUpdate = jgxxService.bmByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh)); 
			
			// 只是更新部门名称
			if(isOnlyBm.equals("1"))
			{
				if(jgxxUpdate.getNLevel() == 2)
				{
					lvlevel = lvlevel.substring(0,4)+"00000000";
				}
				if(jgxxUpdate.getNLevel() == 3)
				{
					lvlevel = lvlevel.substring(0,8)+"0000";
				}
				isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,jgxxUpdate.getNLevel(),Integer.valueOf(bmxz));
	   			 if(isExist)
	   			  {
	   				 // 部门名称存在
	   				 rb.writeJsonResponse(response, "4");
	   				 return;
	   			  }
				jgxxUpdate.setCName(bmmc);
			}
			// 表示更新法院下面部门的名称
			else
			{
			 isExist = jgxxService.isExistBm(Integer.valueOf(fydm), lvlevel, bmmc,1,Integer.valueOf(bmxz));
   			  if(isExist)
   			  {
   				 // 部门名称存在
   				 rb.writeJsonResponse(response, "4");
   				 return;
   			   }
				jgxxUpdate.setCName(bmmc);
				jgxxUpdate.setCStname(bzmc);
				jgxxUpdate.setNZgldzw(Integer.valueOf(zgldzw));
				jgxxUpdate.setNBmxz(Integer.valueOf(bmxz));
			}
			jgxxService.updateJgxx(jgxxUpdate);
		 }		  
		  rb.writeJsonResponse(response, "success");
	    }
	 
	 
	 @RequestMapping(value="/whnsjgDeleteBm.aj",method = RequestMethod.POST)
	    public void  whnsjgDeleteBm(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 String fydm = request.getParameter("fydm");
		 String bmbh = request.getParameter("bmbh");
		 String result = "1";
		 boolean canDelete =  jgxxService.deleteByFyIdAndNcode(Integer.valueOf(fydm),Integer.valueOf(bmbh));
		 if(!canDelete)
		 {
			 result = "-1";
		 }
		 ResponseBuilder rb = new ResponseBuilder();
		 rb.writeJsonResponse(response, result);
	    }
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	
	
	
}

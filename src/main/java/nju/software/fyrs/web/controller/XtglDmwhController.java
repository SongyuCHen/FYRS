package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.XtglMcDmVO;
import nju.software.fyrs.biz.vo.XtglMcVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Mc;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.McService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RoleService;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/xtgl")
public class XtglDmwhController {
	  private RoleMenuService roleMenuService;
	  private RoleService roleService;
	  private McService mcService;
	  private DmService dmService;
	  @RequestMapping(value="/dmwh.do",method = RequestMethod.GET)
	    public String showDmwh(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		  MenuShowUtils.headerMenu(request,model, roleMenuService,"系统管理");
	      MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","代码维护");
	       List<Role> roles = roleService.getAllRoles();
	       model.addAttribute("roles",roles);
	       // 加载代码名称
	       List<Mc> mcs = mcService.listAllMc();
	       List<XtglMcVO> vos = new ArrayList<XtglMcVO>();
	       for(Mc m : mcs)
	       {
	    	   XtglMcVO xtglMcVO = new XtglMcVO();
	    	   xtglMcVO.setCMc(m.getCMc());
	    	   xtglMcVO.setNBxh(m.getNBxh());
	    	   vos.add(xtglMcVO);
	       }
	       model.addAttribute("mcs",vos);
	       return "dmwh/show";
	    }
	  
	  @RequestMapping(value="/dmwhDetail.aj",method = RequestMethod.POST)
	    public void dmwhGetDetail(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		  String nBxh = request.getParameter("nBxh"); 
		  System.out.println("---->"+nBxh);
		  List<Dm> dms = dmService.listDmByNBxh(nBxh);
		  List<XtglMcDmVO> vos = new ArrayList<XtglMcDmVO>();
	       for(Dm dm : dms)
	       {
	    	   XtglMcDmVO xtglMcDmVO = new XtglMcDmVO();
	    	   xtglMcDmVO.setCMc(dm.getCMc());
	    	   xtglMcDmVO.setNBxh(dm.getNBxh());
	    	   xtglMcDmVO.setNDm(dm.getNDm());
	    	   xtglMcDmVO.setNSfzdy(dm.getNSfzdy()+"");
	    	   vos.add(xtglMcDmVO);
	       }
		  ResponseBuilder rb = new ResponseBuilder();
		  rb.writeJsonResponse(response, vos);
	    } 
	  @RequestMapping(value="/addCustomeDm.aj",method = RequestMethod.POST)
	    public String addCustomeDm(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		   String btnType = request.getParameter("btnType");
		   String nbxh = request.getParameter("nbxh");
		   String dm = request.getParameter("dm");
		   // 表示添加
		   if(btnType.trim().equals("0"))
		   {
			   model.addAttribute("btnType",btnType);
			   int maxDm = dmService.maxDmByNBxh(nbxh);
			   model.addAttribute("maxDm",maxDm+1);
		   }
		   // 表示修改
		   if(btnType.trim().equals("2"))
		   {
			  Dm dmGet =  dmService.dmByDmBxh(Integer.valueOf(dm),Integer.valueOf(nbxh));
			  model.addAttribute("dm",dmGet);
			  model.addAttribute("btnType",btnType);
		   }		  
		   return "xtgl/pop/addCustomeDm";
	    }
	  @RequestMapping(value="/saveCustomeDm.aj",method = RequestMethod.POST)
	    public void saveCustomeDm(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    { 
		  String nbxh = request.getParameter("nbxh");
		  String saveMc = request.getParameter("saveMc");
		  String saveDm = request.getParameter("saveDm");
		  String btnType = request.getParameter("btnType");
		  ResponseBuilder rb = new ResponseBuilder();
		  if(btnType.trim().equals("0"))
		  {
			  Dm dm = new Dm();
			  dm.setCMc(saveMc);
			  dm.setNBxh(Short.valueOf(nbxh));
			  dm.setNDm(Integer.valueOf(saveDm));
			  boolean saveSuc = dmService.addDmWithDmBxh(dm);
			 
			  if(saveSuc)
			  {
				  rb.writeJsonResponse(response, "1");
			  }
			  else
			  {
				  rb.writeJsonResponse(response, "-1");
			  } 
		  }
		  if(btnType.trim().equals("2"))
		  {
			  Dm dmGet = dmService.dmByDmBxh(Integer.valueOf(saveDm),Integer.valueOf(nbxh));
			  dmGet.setCMc(saveMc);
			  dmService.updateDm(dmGet);
			  rb.writeJsonResponse(response, "1");
		  }
		 
	    }
	  
	  @RequestMapping(value="/deleteCustomeDm.aj",method = RequestMethod.POST)
	    public void deleteCustomeDm(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    { 
		  
		  String nbxh = request.getParameter("nbxh");
		  String dm = request.getParameter("dm");
		  ResponseBuilder rb = new ResponseBuilder();		  
		  dmService.deleteDm(dm,nbxh);
		  rb.writeJsonResponse(response, "1");		 
	    }
	  
	  
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setMcService(McService mcService) {
		this.mcService = mcService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}	
	
}

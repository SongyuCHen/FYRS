package nju.software.fyrs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.RyjbxxRylhTimeShowVo;
import nju.software.fyrs.biz.vo.RyjbxxRylhVO;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmCommonList;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/rslh")
public class RslhRylhController {
	    private RoleMenuService roleMenuService;
	    private DmService dmService;
	    private RyjbxxService ryjbxxService;
	    @RequestMapping(value="/rylh.do",method = RequestMethod.GET)
	    public String showJdcx(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"人事留痕");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "rslh");
	       model.addAttribute("currentSelectLeftMenu","人员留痕");
	       model.addAttribute("kus",DmCommonList.listDmCommonVO(dmService,ConstantsFyrs.NBXH_GJCXTJ_RYK+""));
	       return "rylh/show";
	    }
	    @RequestMapping(value="/getNameList.aj",method = RequestMethod.POST)
	    public void getNameList(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String bmDm = request.getParameter("bmDm");
	    	String ku = request.getParameter("ku");
	    	String fyDm = request.getParameter("fyDm");
	    	
	        List<String> names = ryjbxxService.listNameByKuFydmBm(ku, fyDm, bmDm);
	    	ResponseBuilder rb = new ResponseBuilder();
		    rb.writeJsonResponse(response,names);
	    }
	    @RequestMapping(value="/getNameInfo.aj",method = RequestMethod.POST)
	    public void getNameInfo(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String bmDm = request.getParameter("bmDm");
	    	String ku = request.getParameter("ku");
	    	String name = request.getParameter("name");
	    	String fyDm = request.getParameter("fyDm");
	    	
	        RyjbxxRylhVO vo = ryjbxxService.getRyjbxxByKuFydmBmName(ku, fyDm, bmDm, name);
	    	ResponseBuilder rb = new ResponseBuilder();
		    rb.writeJsonResponse(response,vo);
	    }
	    
	    
	    @RequestMapping(value="/getNameEvent.aj",method = RequestMethod.POST)
	    public String getNameEvent(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String bmDm = request.getParameter("bmDm");
	    	String ku = request.getParameter("ku");
	    	String name = request.getParameter("name");
	    	String fyDm = request.getParameter("fyDm");
	    	List<RyjbxxRylhTimeShowVo> lists = ryjbxxService.listAllEventByByKuFydmBmName(ku, fyDm, bmDm, name);
	    	model.addAttribute("times",lists);
	        return "rslh/rylhEvent";
	    }
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		public void setDmService(DmService dmService)
		{
			this.dmService = dmService;
		}
		public void setRyjbxxService(RyjbxxService ryjbxxService)
		{
			this.ryjbxxService = ryjbxxService;
		}	
}

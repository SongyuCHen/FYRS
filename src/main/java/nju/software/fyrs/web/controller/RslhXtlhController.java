package nju.software.fyrs.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.service.RywhLogService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.InterceptThreadLocal;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/rslh")
public class RslhXtlhController {
	    private RoleMenuService roleMenuService;
	    private RywhLogService rywhLogService;
	  
	    @RequestMapping(value="/xtlh.do",method = RequestMethod.GET)
	    public String showJdcx(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"人事留痕");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "rslh");
	       model.addAttribute("currentSelectLeftMenu","系统留痕");
	       model.addAttribute("dataSource",RolesUtil.getUserContext(request).getCurrentDataSource());
	       return "xtlh/show";
	    }
	    @RequestMapping(value="/beginAndEndTime.aj",method = RequestMethod.POST)
	    public void beginAndEndTime(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		       String currentDataSource = request.getParameter("currentDataSource");
		       Map<String,String> times = new HashMap<String,String>();
		       // 表示需要切换到备份库
		       if(currentDataSource.trim().equals("false"))
		       {
		    	   // 设置数据源切换		    	  
		    	   RolesUtil.getUserContext(request).setCurrentDataSource("fyrsBackup");
		    	   
		    	   Date[] dates = rywhLogService.findMaxAndMinDate();
		    	   times.put("begin",dateString(dates[1]));
		    	   times.put("end",dateString(dates[0]));
		       }
		       else
		       {
		    	   // 设置数据源切换
		    	   RolesUtil.getUserContext(request).setCurrentDataSource("fyrs");
		    	   times.put("begin","");
		    	   times.put("end","");
		       }

	    	   ResponseBuilder rb = new ResponseBuilder();
		       rb.writeJsonResponse(response,times);
	    }
	    private String dateString(Date date)
	    {
	    	if(date == null)
	    	{
	    		return "";
	    	}
	    	return DateUtil.format(date,DateUtil.webFormat);	    	
	    }
	    @RequestMapping(value="/recover.aj",method = RequestMethod.POST)
	    public void recover(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	    	String timeEnd = request.getParameter("timeEnd");
	    	InterceptThreadLocal.setIsIntercept(false);
	    	rywhLogService.recoverSystem(timeEnd);
	       Thread.sleep(10000);
	       Map<String,String> times = new HashMap<String,String>();
	       Date[] dates = rywhLogService.findMaxAndMinDate();
    	   times.put("begin",dateString(dates[1]));
    	   times.put("end",dateString(dates[0]));
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response,times);
	    }
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		public void setRywhLogService(RywhLogService rywhLogService)
		{
			this.rywhLogService = rywhLogService;
		}	
}

package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.XtglLogVO;
import nju.software.fyrs.data.dataobject.Log;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.service.LogService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RoleService;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/xtgl")
public class XtglXtrzController {
	  private RoleMenuService roleMenuService;
	  private RoleService roleService;
	  private LogService logService;
	 @RequestMapping(value="/xtrz.do",method = RequestMethod.GET)
	    public String showXxxgrzDefault(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		  MenuShowUtils.headerMenu(request,model, roleMenuService,"系统管理");
	      MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","系统日志");
	       List<Role> roles = roleService.getAllRoles();
	       model.addAttribute("roles",roles);
	       return "xtrz/show";
	    }
	 @RequestMapping(value="/xtrzFind.aj",method = RequestMethod.POST)
	    public void find(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 try
		 {
			 String operUser = request.getParameter("operUser");
			 String operBeginTime = request.getParameter("operBeginTime");
			 String operEndTime = request.getParameter("operEndTime");
			 String operType = request.getParameter("operType");
			
			 List<Log> logs = logService.listByTimeOperUser(operUser, operBeginTime, operEndTime, operType);
			 List<XtglLogVO> vos = new ArrayList<XtglLogVO>();
			 for(Log log : logs)
			 {
				 XtglLogVO vo = new XtglLogVO();
				 vo.setCCzyh(log.getCCzyh().trim());
				 vo.setDCzsj(DateUtil.format(log.getDCzsj(),DateUtil.webFormat2));
				 vo.setCCznr(log.getCCznr().trim());
				 vo.setCIp(log.getCIp().trim());
				 vos.add(vo);
			 }
			  ResponseBuilder rb = new ResponseBuilder();
			  rb.writeJsonResponse(response, vos);
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		
	    }
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
    
	 
	 
}

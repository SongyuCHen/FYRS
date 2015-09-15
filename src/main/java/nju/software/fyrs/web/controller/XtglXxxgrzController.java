package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.XtglRywhLogVO;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.data.dataobject.RywhLog;
import nju.software.fyrs.service.RywhLogService;
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
public class XtglXxxgrzController {
	  private RoleMenuService roleMenuService;
	  private RoleService roleService;
	  private RywhLogService rywhLogService;
	 @RequestMapping(value="/xxxgrz.do",method = RequestMethod.GET)
	    public String showXxxgrzDefault(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		  MenuShowUtils.headerMenu(request,model, roleMenuService,"系统管理");
	      MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","信息修改日志");
	       List<Role> roles = roleService.getAllRoles();
	       model.addAttribute("roles",roles);
	       return "xxxgrz/show";
	    }
	 @RequestMapping(value="/xxxgrzFind.aj",method = RequestMethod.POST)
	    public void find(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
		 try
		 {
			 String operUser = request.getParameter("operUser");
			 String operBeginTime = request.getParameter("operBeginTime");
			 String operEndTime = request.getParameter("operEndTime");
			 String operType = request.getParameter("operType");
			
			 List<RywhLog> rywhLogs = rywhLogService.listByTimeOperUser(operUser, operBeginTime, operEndTime, operType);
			 List<XtglRywhLogVO> vos = new ArrayList<XtglRywhLogVO>();
			 for(RywhLog r : rywhLogs)
			 {
				 XtglRywhLogVO vo = new XtglRywhLogVO();
				 vo.setCCzyh(r.getCCzyh().trim());
				 vo.setDCzsj(DateUtil.format(r.getDCzsj(),DateUtil.webFormat2));
				 vo.setCCznr(r.getCCznr().trim());
				 vo.setCIp(r.getCIp().trim());
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
	public void setRywhLogService(RywhLogService rywhLogService) {
		this.rywhLogService = rywhLogService;
	}
	
	 
	 
}

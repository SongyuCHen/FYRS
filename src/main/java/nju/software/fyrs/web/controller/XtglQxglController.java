package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.RyjbxxQxglVO;
import nju.software.fyrs.data.dataobject.Log;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.service.LogService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RoleService;
import nju.software.fyrs.util.PasswordMd5Utils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/xtgl")
public class XtglQxglController {
	    private RoleMenuService roleMenuService;
	    private RoleService roleService;
	    private RyjbxxService ryjbxxService;
	    private LogService logService;
	    
	    @RequestMapping(value="/qxgl.do",method = RequestMethod.GET)
	    public String showQxglDefault(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       MenuShowUtils.headerMenu(request,model, roleMenuService,"ϵͳ����");
		   MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       model.addAttribute("currentSelectLeftMenu","Ȩ�޹���");
	       return "qxgl/show";
	    }
	    @RequestMapping(value="/getUsername.aj",method = RequestMethod.POST)
	    public void getUsername(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	      String fyDm = request.getParameter("fyDm");
	      String bmDm = request.getParameter("bmDm");
	      List<Ryjbxx> ryjbxxs =  null;
	      // -2 ��ǰ̨���壬��ʾû�в��ű�ţ�Ҳ����ʹ�� fyDm ��ѯ
	      if(Integer.valueOf(bmDm) == -2)
	      {
	    	  ryjbxxs = ryjbxxService.listByFyDm(Integer.valueOf(fyDm));
	      }
	      else
	      {
	    	  ryjbxxs = ryjbxxService.listByFyDmBmDm(Integer.valueOf(fyDm), Integer.valueOf(bmDm));
	      }
	      
	      List<RyjbxxQxglVO> vos = new ArrayList<RyjbxxQxglVO>();
	      for(Ryjbxx ryjbxx : ryjbxxs)
	      {
	    	  RyjbxxQxglVO ryjbxxQxglVO = new RyjbxxQxglVO();
	    	  ryjbxxQxglVO.setCBs(ryjbxx.getCBs());
	    	  ryjbxxQxglVO.setCXm(ryjbxx.getCXm());
	    	  ryjbxxQxglVO.setNFy(ryjbxx.getNFy());
	    	  ryjbxxQxglVO.setNRybh(ryjbxx.getNRybh());
	    	  ryjbxxQxglVO.setRoleNames("");
	    	  if(ryjbxx.getCQx() != null && !ryjbxx.getCQx().trim().equals(""))
	    	  {
	    		  ryjbxxQxglVO.setRoleNames(roleService.roleNamesByRoleIds(ryjbxx.getCQx().split(",")));
	    	  }
	    	  vos.add(ryjbxxQxglVO);
	      }
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response, vos);
	    }
	    @RequestMapping(value="/ownroles.aj",method = RequestMethod.POST)
	    public String  ownRoles(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
	       String fydm = request.getParameter("fydm");
	       String rybh = request.getParameter("rybh");
	       Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.valueOf(rybh),Integer.valueOf(fydm));
	       List<Role> roles = roleService.getAllRoles();
	       model.addAttribute("fydm",ryjbxx.getNFy());
	       model.addAttribute("rybh",ryjbxx.getNRybh());
	       model.addAttribute("username",ryjbxx.getCBs());
	       model.addAttribute("roles",roles);
	       return "xtgl/pop/ownRole";
	    }
	    /**
	     * �����û������û���ɫ
	     * @param model
	     * @param response
	     * @param request
	     * @throws Exception
	     */
	    @RequestMapping(value="/updateRoles.aj",method = RequestMethod.POST)
	    public void updateRoles(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	      String fydm = request.getParameter("fydm");
	      String rybh = request.getParameter("rybh");
	      String userName = request.getParameter("userName");
	      String roleIds = request.getParameter("roleIds");
	      String realName = request.getParameter("realName");
	      if(!roleIds.equals(""))
	      {
	    	  roleIds = roleIds.substring(0, roleIds.length() - 1);
	      }
	      // ����� -1 �û����Ѿ����ڣ������ 1 ��ʾ�޸ĳɹ�
	      int result = ryjbxxService.updateUserNameAndRoles(userName, roleIds, Integer.valueOf(rybh), Integer.valueOf(fydm));
	      // ��־
	      if(result == 1)
	      {
	    	  Log log = new Log();
	    	  log.setCCznr("�޸�"+realName+"���û�����Ȩ��");
	    	  log.setCCzyh(RolesUtil.getUserContext(request).getYhmc());
	    	  log.setCIp(request.getRemoteHost());
	    	  log.setNDwid(Integer.valueOf(fydm));
	    	  log.setDCzsj(new Date());
	    	  logService.login(log);
	      }
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response,String.valueOf(result));
	    }
	    
	    @RequestMapping(value="/ownRoleIds.aj",method = RequestMethod.POST)
	    public void ownRoleIds(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	      String fydm = request.getParameter("fydm");
	      String rybh = request.getParameter("rybh");
	      String roleIds = ryjbxxService.roleIdsByFydmRybh(Integer.valueOf(rybh),Integer.valueOf(fydm));
	      ResponseBuilder rb = new ResponseBuilder();
	      if(roleIds != null && !roleIds.trim().equals(""))
	      {
	    	  rb.writeJsonResponse(response,roleIds.trim()); 
	      }
	      else
	      {
	    	  rb.writeJsonResponse(response,"-1");
	      } 
	    }
	    @RequestMapping(value="/emptyPassword.aj",method = RequestMethod.POST)
	    public void emptyPassword(Model model,HttpServletResponse response,HttpServletRequest request) throws Exception
	    {
	      String fydm = request.getParameter("fydm");
	      String rybh = request.getParameter("rybh");
	      String realName = request.getParameter("realName");
	      ryjbxxService.updatePassword(PasswordMd5Utils.generatorPassword(""),Integer.valueOf(rybh), Integer.valueOf(fydm));
	      // ��־
	      Log log = new Log();
    	  log.setCCznr("���"+realName+"�ĵ�¼����");
    	  log.setCCzyh(RolesUtil.getUserContext(request).getYhmc());
    	  log.setCIp(request.getRemoteHost());
    	  log.setNDwid(Integer.valueOf(fydm));
    	  log.setDCzsj(new Date());
    	  logService.login(log);
    	  
	      ResponseBuilder rb = new ResponseBuilder();
	      rb.writeJsonResponse(response, "1");
	    }
	    
	    
		public void setRoleMenuService(RoleMenuService roleMenuService) {
			this.roleMenuService = roleMenuService;
		}
		public void setRyjbxxService(RyjbxxService ryjbxxService) {
			this.ryjbxxService = ryjbxxService;
		}
		public void setRoleService(RoleService roleService) {
			this.roleService = roleService;
		}
		public void setLogService(LogService logService) {
			this.logService = logService;
		}
		
        	
}

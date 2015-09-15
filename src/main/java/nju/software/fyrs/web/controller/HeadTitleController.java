package nju.software.fyrs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.RolesUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class HeadTitleController {
	  private RoleMenuService roleMenuService;
	  @RequestMapping(value="/ryxx/head.do",method = RequestMethod.GET)
	  public String ryxxHead(HttpServletRequest request)
	  {
		  return headCommon(request,"ryxx");
	  }
	  @RequestMapping(value="/dwxx/head.do",method = RequestMethod.GET)
	  public String dwxxHead(HttpServletRequest request)
	  {		 
		  return headCommon(request,"dwxx");		  
	  }
	  @RequestMapping(value="/cxtj/head.do",method = RequestMethod.GET)
	  public String cxtjHead(HttpServletRequest request)
	  {
		  return headCommon(request,"cxtj");
	  }
	  @RequestMapping(value="/yjda/head.do",method = RequestMethod.GET)
	  public String yjdaHead(HttpServletRequest request)
	  {
		  return headCommon(request,"yjda");
	  }
	  @RequestMapping(value="/rslh/head.do",method = RequestMethod.GET)
	  public String rslhHead(HttpServletRequest request)
	  {
		  return headCommon(request,"rslh");
	  }
	  @RequestMapping(value="/wdgl/head.do",method = RequestMethod.GET)
	  public String wdglHead(HttpServletRequest request)
	  {
		  return headCommon(request,"wdgl");
	  }
	  @RequestMapping(value="/yygl/head.do",method = RequestMethod.GET)
	  public String yyglHead(HttpServletRequest request)
	  {
		  return headCommon(request,"yygl");
	  }
	  @RequestMapping(value="/xtgl/head.do",method = RequestMethod.GET)
	  public String xtglHead(HttpServletRequest request)
	  {
		 return headCommon(request,"xtgl");
	  }
	private String headCommon(HttpServletRequest request,String headName)
	{
		 List<Menu> menus = roleMenuService.listMenuByRoleIdParentMenuName(RolesUtil.userGetRoleIds(request),headName);
		  if(menus.size() > 0)
		  {
			  return "redirect:"+menus.get(0).getHref();
		  }
	      return null;
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	  
}

package nju.software.fyrs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;

import org.springframework.ui.Model;

public class MenuShowUtils {
  /**
   * 
   * @param model 向客户端传递数据的 model
   * @param roleMenuService 获得菜单的对象
   * @param roleIds 角色ID 数组
   * @param currentHeaderMenuName 当前选中头标签的名字
   */
  public static void headerMenu(HttpServletRequest request,Model model,RoleMenuService roleMenuService,String currentHeaderMenuName)
  {
	  
	  // 头部的类型为 
	  List<Menu> headerMenus = roleMenuService.listMenuByRoleIdMenuType(roleIdsFromSession(request),ConstantsFyrs.HEADMENUTYPE);
	  model.addAttribute("currentUsername",RolesUtil.getUserContext(request).getYhmc());
	  model.addAttribute("headShowKey",NFyRybhCodeUtils.encode((int)RolesUtil.getUserContext(request).getFydm(), (int)RolesUtil.getUserContext(request).getYhbh()));
	  model.addAttribute("headIsOnlyLook",NFyRybhCodeUtils.encodeIsOnlyLook((int)RolesUtil.getUserContext(request).getFydm(), (int)RolesUtil.getUserContext(request).getYhbh(),false));
	  model.addAttribute("loginTime",RolesUtil.getUserContext(request).getLoginTime());
	  model.addAttribute("currentHeaderMenuName",currentHeaderMenuName);
	  model.addAttribute("headerMenus",headerMenus);
  }
  /**
   * 
   * @param model
   * @param roleMenuService
   * @param parentMenuName 父标签的名字
   * @param roleIds
   */
  public static void leftMenu(HttpServletRequest request,Model model,RoleMenuService roleMenuService,String parentMenuName)
  {
	  List<Menu> leftMenus = roleMenuService.listMenuByRoleIdParentMenuName(roleIdsFromSession(request), parentMenuName);
	  model.addAttribute("leftMenus",leftMenus);
  }
  private static int[] roleIdsFromSession(HttpServletRequest request)
  {
	  UserContext userContext = (UserContext)request.getSession().getAttribute("user");
	  return RolesUtil.stringToIntArray(userContext.getYhRoleIds());
  }
  /**
   * 
   * @param model
   * @param roleMenuService
   * @param parentMenuName 其实父标签与当前的标签是一样的
   * @param roleIds
   */
  public static void initAllMenu(Model model,RoleMenuService roleMenuService,String parentMenuName,int[] roleIds)
  {
	 
  }
}

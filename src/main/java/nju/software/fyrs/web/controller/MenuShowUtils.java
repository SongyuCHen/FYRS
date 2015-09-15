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
   * @param model ��ͻ��˴������ݵ� model
   * @param roleMenuService ��ò˵��Ķ���
   * @param roleIds ��ɫID ����
   * @param currentHeaderMenuName ��ǰѡ��ͷ��ǩ������
   */
  public static void headerMenu(HttpServletRequest request,Model model,RoleMenuService roleMenuService,String currentHeaderMenuName)
  {
	  
	  // ͷ��������Ϊ 
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
   * @param parentMenuName ����ǩ������
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
   * @param parentMenuName ��ʵ����ǩ�뵱ǰ�ı�ǩ��һ����
   * @param roleIds
   */
  public static void initAllMenu(Model model,RoleMenuService roleMenuService,String parentMenuName,int[] roleIds)
  {
	 
  }
}

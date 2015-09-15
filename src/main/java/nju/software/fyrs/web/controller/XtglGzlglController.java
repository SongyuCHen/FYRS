package nju.software.fyrs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.service.impl.RoleMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/xtgl")
public class XtglGzlglController {
	private RoleMenuService roleMenuService;

	@RequestMapping(value = "/gzlgl.do", method = RequestMethod.GET)
	public String showgzlglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "系统管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "xtgl");
		model.addAttribute("currentSelectLeftMenu", "工作流管理");
		return "gzlgl/show";
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
}

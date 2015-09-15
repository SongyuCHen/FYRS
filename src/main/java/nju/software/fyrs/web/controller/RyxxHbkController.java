package nju.software.fyrs.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.service.impl.RoleMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/ryxx")
public class RyxxHbkController {
	private RoleMenuService roleMenuService;

	@RequestMapping(value = "/hbk.do", method = RequestMethod.GET)
	public String showHbkDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "人员信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "ryxx");
		model.addAttribute("currentSelectLeftMenu", "后备库");
		return "hbk/show";
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
}

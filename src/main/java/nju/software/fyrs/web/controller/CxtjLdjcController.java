package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.LdjcVO;
import nju.software.fyrs.service.LdjcService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/cxtj")
public class CxtjLdjcController {
	private RoleMenuService roleMenuService;
	private LdjcService ldjcService;
	@RequestMapping(value="/ldjc.do",method = RequestMethod.GET)
	public String showLdjc(Model model,HttpServletResponse response,HttpServletRequest request)
	{
		MenuShowUtils.headerMenu(request,model, roleMenuService,"查询统计");
		MenuShowUtils.leftMenu(request,model, roleMenuService, "cxtj");
		model.addAttribute("currentSelectLeftMenu","领导决策");
		return "ldjc/show";
	}
	
	@RequestMapping(value="/flzwfb.aj",method = RequestMethod.POST)
	public void getFlzwFB(Model model,HttpServletResponse response,HttpServletRequest request){
		List<LdjcVO> flzwFbs = new ArrayList<LdjcVO>();
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		if(user!=null){
			int fydm = user.getFydm();
			flzwFbs = ldjcService.getFlzwFb(fydm);
		}
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, flzwFbs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/fgdjfb.aj",method = RequestMethod.POST)
	public void getFgdjFB(Model model,HttpServletResponse response,HttpServletRequest request){
		List<LdjcVO> fgdjFbs = new ArrayList<LdjcVO>();
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		if(user!=null){
			int fydm = user.getFydm();
			fgdjFbs = ldjcService.getFgdjFb(fydm);
		}
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, fgdjFbs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/xzzwfb.aj",method = RequestMethod.POST)
	public void getXzzwFB(Model model,HttpServletResponse response,HttpServletRequest request){
		List<LdjcVO> xzzwFbs = new ArrayList<LdjcVO>();
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		if(user!=null){
			int fydm = user.getFydm();
			xzzwFbs = ldjcService.getXzzwFb(fydm);
		}
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, xzzwFbs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/bmfb.aj",method = RequestMethod.POST)
	public void getBmFB(Model model,HttpServletResponse response,HttpServletRequest request){
		List<LdjcVO> bmFbs = new ArrayList<LdjcVO>();
		UserContext user = (UserContext) request.getSession().getAttribute("user");
		if(user!=null){
			int fydm = user.getFydm();
			bmFbs = ldjcService.getBmFb(fydm);
		}
		try {
			ResponseBuilder rb = new ResponseBuilder();
			rb.writeJsonResponse(response, bmFbs);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setLdjcService(LdjcService ldjcService) {
		this.ldjcService = ldjcService;
	}
}
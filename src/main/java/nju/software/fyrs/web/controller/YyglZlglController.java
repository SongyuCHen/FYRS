package nju.software.fyrs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.YyglZhaoluVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.YyglZhaoluService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/main/yygl")
public class YyglZlglController {
	private RoleMenuService roleMenuService;
	private YyglZhaoluService zlService;
	private DmService dmService;
	@RequestMapping(value = "/zlgl.do", method = RequestMethod.GET)
	public String showzlglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "招录管理");
		return "zlgl/show";
	}
	@RequestMapping(value = "/zlglDetail.aj", method = RequestMethod.POST)
	public void zlglDeDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<YyglZhaoluVO> pxjhVOs = zlService.getZhaoluByFy(fydm);		
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,pxjhVOs);
	}
	
	@RequestMapping(value = "/zlgl.aj", method = RequestMethod.POST)
	public String showPopzlgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		YyglZhaoluVO vo = new YyglZhaoluVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String fydm = request.getParameter("fydm");
			vo = zlService.getZhaoluById(keyid, fydm);			
		}
		List<Dm> listDmGw = dmService.getDmListByName("行政职务");
		model.addAttribute("listDmGw", listDmGw);
		model.addAttribute("zlgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_zlgl";
	}
	
	@RequestMapping(value = "/addzlgl.aj", method = RequestMethod.POST)
	public void addzlgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YyglZhaoluVO vo = new YyglZhaoluVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		YyglZhaoluVO zlglVO = new YyglZhaoluVO();
		zlglVO = zlService.addZhaolu(vo);		
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, zlglVO);
	}
	
	@RequestMapping(value = "/savezlgl.aj", method = RequestMethod.POST)
	public void savezlgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YyglZhaoluVO vo = new YyglZhaoluVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		zlService.updateZhaolu(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, vo);
	}
	
	@RequestMapping(value = "/deletezlgl.aj", method = RequestMethod.POST)
	public void deletezlgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		result = zlService.delZhaoluById(keyid, fydm) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setZlService(YyglZhaoluService zlService) {
		this.zlService = zlService;
	}
	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
}

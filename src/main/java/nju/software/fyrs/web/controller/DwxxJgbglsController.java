package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.JgbgVO;
import nju.software.fyrs.data.dataobject.Jgbg;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxJgbglsController {
	private RoleMenuService roleMenuService;
	private JgxxService jgxxService;
	@RequestMapping(value = "/jgbgls.do", method = RequestMethod.GET)
	public String showjgbglsDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "单位信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "dwxx");
		model.addAttribute("currentSelectLeftMenu", "结构变更历史");
		return "jgbgls/show";
	}
	
	@RequestMapping(value = "/jgbglsDetail.aj", method = RequestMethod.POST)
	public void jgbglsDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<Jgbg> jgbgs = jgxxService.getJgbgById(fydm);
		List<JgbgVO> jgbgVOs = new ArrayList<JgbgVO>();
		for(Jgbg jgbg:jgbgs){
			JgbgVO jgbgVO = new JgbgVO();
			jgbgVO.setNId(jgbg.getNId()+"");
			jgbgVO.setNFy(jgbg.getNFy().toString());
			jgbgVO.setCBbpfbh(jgbg.getCBbpfbh());
			jgbgVO.setDBbpfsj(DateUtil.format(jgbg.getDBbpfsj(), DateUtil.webFormat));
			jgbgVO.setDBgsj(DateUtil.format(jgbg.getDBgsj(), DateUtil.webFormat));
			jgbgVO.setCBgnr(jgbg.getCBgnr());
			jgbgVO.setCbgr(jgbg.getCBgr());
		}
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,jgbgVOs);
	}
	
	@RequestMapping(value = "/deleteJgbgls.aj", method = RequestMethod.POST)
	public void delJgbgls(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String result = "0";
		String htbh = request.getParameter("htbh");
		String fydm = request.getParameter("fydm");
		result = jgxxService.delJgbgById(Integer.parseInt(fydm), Integer.parseInt(htbh))? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}
	
	@RequestMapping(value = "/addJgbgls.aj", method = RequestMethod.POST)
	public void addJgbgls(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		Jgbg jgbg = new Jgbg();
		String fydm = request.getParameter("fydm");
		String bmbh = request.getParameter("bmbh");
		JgbgVO jgbgVO = new JgbgVO();
		jgbg.setNFy(Integer.valueOf(fydm));
		jgbgVO = jgxxService.addJgbg(jgbg);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jgbgVO);
	}
	
	@RequestMapping(value = "/saveJgbgls.aj", method = RequestMethod.POST)
	public void saveJgbgls(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		JgbgVO vo = new JgbgVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		JgbgVO jgbgVO = new JgbgVO();
		Jgbg jgbg = new Jgbg();
		jgbg.setNId(new BigDecimal(jgbgVO.getNFy()));
		jgbg.setNFy(Integer.parseInt(jgbgVO.getNFy()));
		jgbg.setCBbpfbh(jgbgVO.getCBbpfbh());
		jgbg.setCBgnr(jgbgVO.getCBgnr());
		jgbg.setCBgr(jgbgVO.getCbgr());
		jgbg.setDBbpfsj(DateUtil.parse(jgbgVO.getDBbpfsj(), DateUtil.webFormat));
		jgbg.setDBgsj(DateUtil.parse(jgbgVO.getDBgsj(), DateUtil.webFormat));
		jgxxService.updateJgbg(jgbg);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, jgbgVO);
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	
}

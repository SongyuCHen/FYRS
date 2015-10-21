package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.YyglPxjhVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.YyglPxjhService;
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
public class YyglPxglController {
	private RoleMenuService roleMenuService;
	private YyglPxjhService pxjhService;
	private DmService dmService;
	
	@RequestMapping(value = "/pxgl.do", method = RequestMethod.GET)
	public String showpxglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "培训管理");
		return "pxgl/show";
	}
	
	@RequestMapping(value = "/pxglDetail.aj", method = RequestMethod.POST)
	public void pxglDeDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<YyglPxjhVO> pxjhVOs = pxjhService.getPxjhByFy(fydm);
		if(null == pxjhVOs){
			pxjhVOs = new ArrayList<YyglPxjhVO>();
		}
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,pxjhVOs);
	}
	
	@RequestMapping(value = "/pxgl.aj", method = RequestMethod.POST)
	public String showPopPxgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		String fydm = request.getParameter("fydm");
		YyglPxjhVO vo = new YyglPxjhVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			vo = pxjhService.getPxjhById(keyid, fydm);			
		}else{
			vo.setNFy(fydm);;
		}
		List<Dm> listDmPxxs = dmService.getDmListByName("学习形式");
		List<Dm> listDmPxzl = dmService.getDmListByName("培训种类");
		List<Dm> listDmPxxz = dmService.getDmListByName("培训性质");
		List<Dm> listDmZy = dmService.getDmListByName("专业");
		List<Dm> listDmPxfs = dmService.getDmListByName("培训方式");
		List<Dm> listDmJgzl = dmService.getDmListByName("培训机构");
		model.addAttribute("listDmPxzl", listDmPxzl);
		model.addAttribute("listDmPxxz", listDmPxxz);
		model.addAttribute("listDmPxfs", listDmPxfs);
		model.addAttribute("listDmZy", listDmZy);
		model.addAttribute("listDmJgzl", listDmJgzl);
		model.addAttribute("listDmPxxs", listDmPxxs);
		model.addAttribute("pxgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_pxgl";
	}
	
	@RequestMapping(value = "/addPxgl.aj", method = RequestMethod.POST)
	public void addPxgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YyglPxjhVO vo = new YyglPxjhVO();
		String showKey = request.getParameter("showKey");
		BeanUtilsEx.populate(vo, request.getParameterMap());
		YyglPxjhVO pxjhVO = new YyglPxjhVO();
		pxjhVO = pxjhService.addPxjh(vo);		
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, pxjhVO);
	}
	
	@RequestMapping(value = "/savePxgl.aj", method = RequestMethod.POST)
	public void savePxgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YyglPxjhVO vo = new YyglPxjhVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		pxjhService.updatePxjh(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, vo);
	}
	
	@RequestMapping(value = "/deletePxgl.aj", method = RequestMethod.POST)
	public void deletePxgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		result = pxjhService.delPxjhById(keyid, fydm) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}



	public void setPxjhService(YyglPxjhService pxjhService) {
		this.pxjhService = pxjhService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	
	
}

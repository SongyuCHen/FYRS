package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.YujingVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.YujingService;
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
public class YyglYjglController {
	private RoleMenuService roleMenuService;
	private YujingService yujingService;
	private JgxxService jgxxService;
	@RequestMapping(value = "/yjgl.do", method = RequestMethod.GET)
	public String showyjglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "预警管理");
		return "yjgl/show";
	}
	
	@RequestMapping(value = "/yjglDetail.aj", method = RequestMethod.POST)
	public void yjglDeDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<YujingVO> vos = yujingService.getYujingByFy(fydm);	
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,vos);
	}
	@RequestMapping(value = "/yjgl.aj", method = RequestMethod.POST)
	public String showPopYjgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		String fydm = request.getParameter("fydm");
		YujingVO vo = new YujingVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String rybh = request.getParameter("rybh");
			vo = (YujingVO) yujingService.getYujingById(keyid, fydm, rybh);			
		}else{
			String rybh = request.getParameter("rybh");
			vo.setNFy(fydm);
			vo.setNRybh(rybh);
		}
		List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.valueOf(fydm));
		List<JgxxVO> vos = new ArrayList<JgxxVO>();
    	for(Jgxx jgxx : jgxxs)
    	{
    		JgxxVO jgxxVo = new JgxxVO();
    		jgxxVo.setNCode(jgxx.getNCode());
    		jgxxVo.setCName(jgxx.getCName());
    		vos.add(jgxxVo);
    	}
		model.addAttribute("listDmBm", vos);
		model.addAttribute("htgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_yjgl";
	}
	@RequestMapping(value = "/addYjgl.aj", method = RequestMethod.POST)
	public void addHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YujingVO vo = new YujingVO();
		String showKey = request.getParameter("showKey");
		String[] code = NFyRybhCodeUtils.decode(showKey);
		BeanUtilsEx.populate(vo, request.getParameterMap());
		vo.setNFy(code[0]);
		vo.setNRybh(code[1]);
		YujingVO yjvo = new YujingVO();
		yjvo = yujingService.addYujing(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, yjvo);
	}
	
	@RequestMapping(value = "/saveYjgl.aj", method = RequestMethod.POST)
	public void saveHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		YujingVO vo = new YujingVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		YujingVO yjvo = new YujingVO();
		yjvo = yujingService.updateYujing(vo);
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, yjvo);
	}
	
	@RequestMapping(value = "/deleteYjgl.aj", method = RequestMethod.POST)
	public void deleteHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = yujingService.delYujingById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setYujingService(YujingService yujingService) {
		this.yujingService = yujingService;
	}

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	
}

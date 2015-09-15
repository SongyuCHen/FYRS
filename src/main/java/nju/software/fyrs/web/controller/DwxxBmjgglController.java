package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.RykService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.Ryklx;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/dwxx")
public class DwxxBmjgglController {
	private RoleMenuService roleMenuService;
	private JgxxService jgxxService;
	private RykService rykService;
	private DmService dmService;
	@RequestMapping(value = "/bmjggl.do", method = RequestMethod.GET)
	public String showbmjgglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "单位信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "dwxx");
		model.addAttribute("currentSelectLeftMenu", "部门结构管理");
		return "bmjggl/show";
	}
	@RequestMapping(value = "/bmjgglDetail.aj", method = RequestMethod.POST)
	public void bmjgglDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		String fyMc = dmService.findFymc(Integer.valueOf(fydm));
		List<Jgxx> jgxxs = jgxxService.bmByFyId(Integer.parseInt(fydm));
		List<JgxxVO> vos = new ArrayList<JgxxVO>();
		JgxxVO vofy = new JgxxVO();
		vofy.setNCode(Integer.parseInt(fydm));
		vofy.setCName(fyMc);
		vos.add(vofy);
		for(Jgxx jgxx:jgxxs){
			JgxxVO vo = new JgxxVO();
			vo.setNCode(jgxx.getNCode());
			vo.setCName(jgxx.getCName());
			vos.add(vo);
		}
		
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,vos);
	}
	
	@RequestMapping(value = "/bmryfb.aj", method = RequestMethod.POST)
	public String showPopzgqk(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String fydm = request.getParameter("fydm");
		String bmdm = request.getParameter("bmdm");
		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fydm));
		cx.setBmdm(Integer.valueOf(bmdm));
		cx.setCxlx(Ryklx.ZZK);
		List<RyviewModel> ryList = rykService.getRyviewList(cx);
		System.out.println(""+fydm+"  "+bmdm);
		model.addAttribute("ryList", ryList);
		return "dwxx/pop/view_bmryfb";
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	
	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}
	public void setRykService(RykService rykService) {
		this.rykService = rykService;
	}
	
}

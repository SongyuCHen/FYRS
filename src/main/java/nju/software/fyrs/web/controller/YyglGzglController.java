package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.GzglVO;
import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.RysxFljlVO;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
@RequestMapping("/main/yygl")
public class YyglGzglController {
	private RoleMenuService roleMenuService;
	private RyjbxxService ryjbxxService;
	private JgxxService jgxxService;
	private DmService dmService;
//	private 
	@RequestMapping(value = "/gzgl.do", method = RequestMethod.GET)
	public String showGzglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "工资管理");
		return "gzgl/show";
	}
	
	@RequestMapping(value = "/gzglDetail.aj", method = RequestMethod.POST)
	public void gzglDeDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<RysxFljlVO> Fljlvos = ryjbxxService.getRysxFljlByFy(Integer.parseInt(fydm));
		List<GzglVO> vos = new ArrayList<GzglVO>();
		for(RysxFljlVO vo:Fljlvos){
			GzglVO gzglVO = new GzglVO();
			gzglVO.setNFy(vo.getNFy());
			gzglVO.setNId(vo.getNId());
			gzglVO.setNRybh(vo.getNRybh());
			gzglVO.setNKq(vo.getNKq());
			gzglVO.setCBz(vo.getCBz());
			gzglVO.setDFfsj(vo.getDFfsj());
			gzglVO.setMFlbt(vo.getMFlbt());
			gzglVO.setMJbxc(vo.getMJbxc());
			Double mXj = Double.parseDouble(vo.getMFlbt()) + Double.parseDouble(vo.getMJbxc());
			gzglVO.setMXj(mXj.toString());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
			gzglVO.setCXm(ryjbxx.getCXm());
			gzglVO.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
			vos.add(gzglVO);			
		}
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,vos);
	}
	
	
	@RequestMapping(value = "/gzgl.aj", method = RequestMethod.POST)
	public String showPopGzgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		String fydm = request.getParameter("fydm");
		GzglVO vo = new GzglVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String rybh = request.getParameter("rybh");
			RysxFljlVO Fljlvo = ryjbxxService.getRysxFljlById(keyid, fydm, rybh);
			vo.setNFy(Fljlvo.getNFy());
			vo.setNId(Fljlvo.getNId());
			vo.setNRybh(Fljlvo.getNRybh());
			vo.setNKq(Fljlvo.getNKq());
			vo.setCBz(Fljlvo.getCBz());
			vo.setDFfsj(Fljlvo.getDFfsj());
			vo.setMFlbt(Fljlvo.getMFlbt());
			vo.setMJbxc(Fljlvo.getMJbxc());
			Double mXj = Double.parseDouble(Fljlvo.getMFlbt()) + Double.parseDouble(Fljlvo.getMJbxc());
			vo.setMXj(mXj.toString());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(Fljlvo.getNRybh()),Integer.parseInt(Fljlvo.getNFy()));
			vo.setCXm(ryjbxx.getCXm());
			vo.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
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
		model.addAttribute("gzgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_gzgl";
	}
	
	@RequestMapping(value = "/addGzgl.aj", method = RequestMethod.POST)
	public void addGzgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RysxFljlVO vo = new RysxFljlVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxFljlVO Fljlvo = new RysxFljlVO();
		Fljlvo = ryjbxxService.addRysxFljl(vo);
		GzglVO gzglVO = new GzglVO();
		gzglVO.setNFy(Fljlvo.getNFy());
		gzglVO.setNId(Fljlvo.getNId());
		gzglVO.setNRybh(Fljlvo.getNRybh());
		gzglVO.setNKq(Fljlvo.getNKq());
		gzglVO.setCBz(Fljlvo.getCBz());
		gzglVO.setDFfsj(Fljlvo.getDFfsj());
		gzglVO.setMFlbt(Fljlvo.getMFlbt());
		gzglVO.setMJbxc(Fljlvo.getMJbxc());
		Double mXj = Double.parseDouble(Fljlvo.getMFlbt()) + Double.parseDouble(Fljlvo.getMJbxc());
		gzglVO.setMXj(mXj.toString());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(Fljlvo.getNRybh()),Integer.parseInt(Fljlvo.getNFy()));
		gzglVO.setCXm(ryjbxx.getCXm());
		gzglVO.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, gzglVO);
	}
	
	@RequestMapping(value = "/saveGzgl.aj", method = RequestMethod.POST)
	public void saveGzgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		GzglVO vo = new GzglVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxFljlVO fljlVOConvert = new RysxFljlVO();
		fljlVOConvert.setNFy(vo.getNFy());
		fljlVOConvert.setNId(vo.getNId());
		fljlVOConvert.setNRybh(vo.getNRybh());
		fljlVOConvert.setNKq(vo.getNKq());
		fljlVOConvert.setCBz(vo.getCBz());
		fljlVOConvert.setDFfsj(vo.getDFfsj());
		fljlVOConvert.setMFlbt(vo.getMFlbt());
		fljlVOConvert.setMJbxc(vo.getMJbxc());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
		ryjbxxService.updateRysxFljl(fljlVOConvert);
		Double mXj = Double.parseDouble(vo.getMFlbt()) + Double.parseDouble(vo.getMJbxc());
		vo.setMXj(mXj.toString());
		vo.setCXm(ryjbxx.getCXm());
		vo.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, vo);
	}
	
	@RequestMapping(value = "/deleteGzgl.aj", method = RequestMethod.POST)
	public void deleteGzgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxService.delRysxFljlById(keyid, fydm, rybh) ? "1" : "0";
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, new Gson().toJson(result));
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setJgxxService(JgxxService jgxxService) {
		this.jgxxService = jgxxService;
	}
	
	
}

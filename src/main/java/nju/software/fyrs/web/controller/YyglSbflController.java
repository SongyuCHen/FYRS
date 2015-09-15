package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.RysxShebaoVO;
import nju.software.fyrs.biz.vo.SbglVO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Jgxx;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.JgxxService;
import nju.software.fyrs.service.RyjbxxService;
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
public class YyglSbflController {
	private RoleMenuService roleMenuService;
	private RyjbxxService ryjbxxService;
	private DmService dmService;
	private JgxxService jgxxService;
	@RequestMapping(value = "/sbfl.do", method = RequestMethod.GET)
	public String showSbflDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "社保福利");
		return "sbfl/show";
	}
	
	@RequestMapping(value = "/sbflDetail.aj", method = RequestMethod.POST)
	public void sbflDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<RysxShebaoVO> Shebvos = ryjbxxService.getShebaoByFy(Integer.parseInt(fydm));
		List<SbglVO> vos = new ArrayList<SbglVO>();
		for(RysxShebaoVO vo:Shebvos){
			SbglVO sbglVO = new SbglVO();
			sbglVO.setNFy(vo.getNFy());
			sbglVO.setNId(vo.getNId());
			sbglVO.setNRybh(vo.getNRybh());
			sbglVO.setDJssj(vo.getDJssj());
			sbglVO.setDKssj(vo.getDKssj());
			sbglVO.setNType(vo.getNType());
			sbglVO.setMDwyj(vo.getMDwyj());
			sbglVO.setMFyhj(vo.getMFyhj());
			sbglVO.setMGryj(vo.getMGryj());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
			sbglVO.setCXm(ryjbxx.getCXm());
			sbglVO.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
			vos.add(sbglVO);			
		}
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,vos);
	}
	
	@RequestMapping(value = "/sbgl.aj", method = RequestMethod.POST)
	public String showPopSbgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		String fydm = request.getParameter("fydm");
		SbglVO vo = new SbglVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String rybh = request.getParameter("rybh");
			RysxShebaoVO Shebvo = ryjbxxService.getShebaoById(keyid, fydm, rybh);
			vo.setNFy(Shebvo.getNFy());
			vo.setNId(Shebvo.getNId());
			vo.setNRybh(Shebvo.getNRybh());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
			vo.setCXm(ryjbxx.getCXm());
			vo.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
			vo.setDJssj(Shebvo.getDJssj());
			vo.setDKssj(Shebvo.getDKssj());
			vo.setNType(Shebvo.getNType());
			vo.setMDwyj(Shebvo.getMDwyj());
			vo.setMFyhj(Shebvo.getMFyhj());
			vo.setMGryj(Shebvo.getMGryj());
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
		List<Dm> listDmSb= dmService.getDmListByName("保险类型");
		model.addAttribute("listDmBm", vos);
		model.addAttribute("listDmSb", listDmSb);
		model.addAttribute("sbgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_sbgl";
	}
	@RequestMapping(value = "/addSbgl.aj", method = RequestMethod.POST)
	public void addSbgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RysxShebaoVO vo = new RysxShebaoVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxShebaoVO ShebVO = new RysxShebaoVO();
		ShebVO = ryjbxxService.addShebao(vo);
		SbglVO sbglVO = new SbglVO();
		sbglVO.setNFy(ShebVO.getNFy());
		sbglVO.setNId(ShebVO.getNId());
		sbglVO.setNRybh(ShebVO.getNRybh());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
		sbglVO.setCXm(ryjbxx.getCXm());
		sbglVO.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
		sbglVO.setDJssj(ShebVO.getDJssj());
		sbglVO.setDKssj(ShebVO.getDKssj());
		sbglVO.setNType(ShebVO.getNType());
		sbglVO.setMDwyj(ShebVO.getMDwyj());
		sbglVO.setMFyhj(ShebVO.getMFyhj());
		sbglVO.setMGryj(ShebVO.getMGryj());
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, sbglVO);
	}
	
	@RequestMapping(value = "/saveSbgl.aj", method = RequestMethod.POST)
	public void saveSbgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RysxShebaoVO vo = new RysxShebaoVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxShebaoVO ShebVO = new RysxShebaoVO();
		ShebVO = ryjbxxService.updateShebao(vo);
		SbglVO sbglVO = new SbglVO();
		sbglVO.setNFy(ShebVO.getNFy());
		sbglVO.setNId(ShebVO.getNId());
		sbglVO.setNRybh(ShebVO.getNRybh());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
		sbglVO.setCXm(ryjbxx.getCXm());
		sbglVO.setNZj(dmService.getDmByMc(ryjbxx.getNZj(), "职级"));
		sbglVO.setDJssj(ShebVO.getDJssj());
		sbglVO.setDKssj(ShebVO.getDKssj());
		sbglVO.setNType(ShebVO.getNType());
		sbglVO.setMDwyj(ShebVO.getMDwyj());
		sbglVO.setMFyhj(ShebVO.getMFyhj());
		sbglVO.setMGryj(ShebVO.getMGryj());
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, sbglVO);
	}
	
	@RequestMapping(value = "/deleteSbgl.aj", method = RequestMethod.POST)
	public void deleteSbgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxService.delShebaoById(keyid, fydm, rybh) ? "1" : "0";
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

package nju.software.fyrs.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.HtglVO;
import nju.software.fyrs.biz.vo.JgxxVO;
import nju.software.fyrs.biz.vo.RysxHtVO;
import nju.software.fyrs.data.dataobject.Dm;
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
public class YyglHtglController {
	private RoleMenuService roleMenuService;
	private RyjbxxService ryjbxxService;
	private JgxxService jgxxService;
	private DmService dmService;
	
	@RequestMapping(value = "/htgl.do", method = RequestMethod.GET)
	public String showhtglDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "应用管理");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "yygl");
		model.addAttribute("currentSelectLeftMenu", "合同管理");
		return "htgl/show";
	}
	
	@RequestMapping(value = "/htglDetail.aj", method = RequestMethod.POST)
	public void htglDeDetail(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydm = request.getParameter("fydm");
		List<RysxHtVO> htVOs = ryjbxxService.getHtxxByFy(Integer.parseInt(fydm));
		List<HtglVO> vos = new ArrayList<HtglVO>();
		for(RysxHtVO ht:htVOs){
			HtglVO vo = new HtglVO();
			vo.setNId(ht.getNId());
			vo.setNFy(ht.getNFy());
			vo.setNRybh(ht.getNRybh());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
			vo.setCXm(ryjbxx.getCXm());
			vo.setNBm(dmService.getDmByMc(ryjbxx.getNBm(),"内设机构"));
			vo.setNHtlb(ht.getNHtlb());
			vo.setDQdrq(ht.getDQdrq());
			vo.setCHtbh(ht.getCHtbh());
			vo.setCHtqx(ht.getCHtqx());
			vo.setNPrzw(ht.getNPrzw());
			vo.setCBz(ht.getCBz());
			vos.add(vo);
		}
		ResponseBuilder rb = new ResponseBuilder();
	    rb.writeJsonResponse(response,vos);
	}
	@RequestMapping(value = "/htgl.aj", method = RequestMethod.POST)
	public String showPopHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String btnType = request.getParameter("btnType");
		String fydm = request.getParameter("fydm");
		HtglVO vo = new HtglVO();
		if (!btnType.equals("0")) {
			String keyid = request.getParameter("keyid");
			String rybh = request.getParameter("rybh");
			RysxHtVO Fljlvo = ryjbxxService.getRsHtxxById(keyid, fydm, rybh);
			vo.setNFy(Fljlvo.getNFy());
			vo.setNId(Fljlvo.getNId());
			vo.setNRybh(Fljlvo.getNRybh());
			Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
			vo.setCXm(ryjbxx.getCXm());
			vo.setNBm(dmService.getDmByMc(ryjbxx.getNBm(),"内设机构"));
			vo.setNHtlb(Fljlvo.getNHtlb());
			vo.setCHtbh(Fljlvo.getCHtbh());
			vo.setCHtqx(Fljlvo.getCHtqx());
			vo.setNPrzw(Fljlvo.getNPrzw());
			vo.setDQdrq(Fljlvo.getDQdrq());
			vo.setCBz(Fljlvo.getCBz());
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
		List<Dm> listDmHt= dmService.getDmListByName("合同类别");
		List<Dm> listDmPrzw= dmService.getDmListByName("行政职务");
		model.addAttribute("listDmBm", vos);
		model.addAttribute("listDmHt", listDmHt);
		model.addAttribute("listDmPrzw", listDmPrzw);
		model.addAttribute("htgl", vo);
		model.addAttribute("btnType", btnType);
		return "yygl/view_htgl";
	}
	@RequestMapping(value = "/addHtgl.aj", method = RequestMethod.POST)
	public void addHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RysxHtVO vo = new RysxHtVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxHtVO Htvo = new RysxHtVO();
		Htvo = ryjbxxService.addHtxx(vo);
		HtglVO htglVO = new HtglVO();
		htglVO.setNFy(Htvo.getNFy());
		htglVO.setNId(Htvo.getNId());
		htglVO.setNRybh(Htvo.getNRybh());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
		htglVO.setCXm(ryjbxx.getCXm());
		htglVO.setNBm(dmService.getDmByMc(ryjbxx.getNBm(),"内设机构"));
		htglVO.setNHtlb(Htvo.getNHtlb());
		htglVO.setCHtbh(Htvo.getCHtbh());
		htglVO.setCHtqx(Htvo.getCHtqx());
		htglVO.setNPrzw(Htvo.getNPrzw());
		htglVO.setDQdrq(Htvo.getDQdrq());
		htglVO.setCBz(Htvo.getCBz());
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, htglVO);
	}
	
	@RequestMapping(value = "/saveHtgl.aj", method = RequestMethod.POST)
	public void saveHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		RysxHtVO vo = new RysxHtVO();
		BeanUtilsEx.populate(vo, request.getParameterMap());
		RysxHtVO Htvo = new RysxHtVO();
		Htvo = ryjbxxService.updateRsHtxx(vo);
		HtglVO htglVO = new HtglVO();
		htglVO.setNFy(Htvo.getNFy());
		htglVO.setNId(Htvo.getNId());
		htglVO.setNRybh(Htvo.getNRybh());
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByRybhFyDm(Integer.parseInt(vo.getNRybh()),Integer.parseInt(vo.getNFy()));
		htglVO.setCXm(ryjbxx.getCXm());
		htglVO.setNBm(dmService.getDmByMc(ryjbxx.getNBm(),"内设机构"));
		htglVO.setNHtlb(Htvo.getNHtlb());
		htglVO.setCHtbh(Htvo.getCHtbh());
		htglVO.setCHtqx(Htvo.getCHtqx());
		htglVO.setNPrzw(Htvo.getNPrzw());
		htglVO.setDQdrq(Htvo.getDQdrq());
		htglVO.setCBz(Htvo.getCBz());
		ResponseBuilder builder = new ResponseBuilder();
		builder.writeJsonResponse(response, htglVO);
	}
	
	@RequestMapping(value = "/deleteHtgl.aj", method = RequestMethod.POST)
	public void deleteHtgl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String result = "0";
		String keyid = request.getParameter("keyid");
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		result = ryjbxxService.delRsHtxxById(keyid, fydm, rybh) ? "1" : "0";
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

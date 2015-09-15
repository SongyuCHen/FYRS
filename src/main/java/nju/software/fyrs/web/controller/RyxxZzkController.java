package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.manager.RyjbxxManager;
import nju.software.fyrs.biz.vo.CgxxVO;
import nju.software.fyrs.biz.vo.DjxxVO;
import nju.software.fyrs.biz.vo.FlzwVO;
import nju.software.fyrs.biz.vo.GwyjbVO;
import nju.software.fyrs.biz.vo.JliuxxVO;
import nju.software.fyrs.biz.vo.JlixxVO;
import nju.software.fyrs.biz.vo.JlxxVO;
import nju.software.fyrs.biz.vo.JtxxVO;
import nju.software.fyrs.biz.vo.KhxxVO;
import nju.software.fyrs.biz.vo.PxxxVO;
import nju.software.fyrs.biz.vo.RcxxVO;
import nju.software.fyrs.biz.vo.RyjbxxVO;
import nju.software.fyrs.biz.vo.WyxxVO;
import nju.software.fyrs.biz.vo.XlxxVO;
import nju.software.fyrs.biz.vo.XzzwVO;
import nju.software.fyrs.biz.vo.ZyjszwVO;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.RykService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.Ryklx;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.BeanUtilsEx;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DmMcCommon;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/ryxx")
public class RyxxZzkController {
	private RyjbxxManager ryjbxxManager;
	private RyjbxxService ryjbxxService;
	private RoleMenuService roleMenuService;
	private DmService dmService;
	private RykService rykService;
	private Map<String, String> mapNames = new HashMap<String, String>();

	@RequestMapping(value = "/zzk.do", method = RequestMethod.GET)
	public String showZzkDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "人员信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "ryxx");
		model.addAttribute("currentSelectLeftMenu", "在职库");
		model.addAttribute("dmbAddList", dmService.listDmByNBxh("705"));
		model.addAttribute("dmbRcList", dmService.listDmByNBxh("701"));
		return "zzk/show";
	}

	@RequestMapping(value = "/zzkTable.aj", method = RequestMethod.POST)
	public void zzkTable(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fyDm = request.getParameter("fydm");
		String bmDm = request.getParameter("bmdm");
		System.out.println("-->" + fyDm);

		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fyDm));
		cx.setBmdm(Integer.valueOf(bmDm));
		cx.setCxlx(Ryklx.ZZK);
		List<RyviewModel> ryList = rykService.getRyviewList(cx);
		List<Integer> canEdit = new ArrayList<Integer>();
		List<Integer> canLook = new ArrayList<Integer>();
		roleMenuService.findCanLookAndEditListFy(canLook, canEdit,
				RolesUtil.userGetRoleIds(request),
				RolesUtil.getUserContext(request).getFydm());
		System.out.println(canEdit.size() + "");
		List<RyviewModel> showList = new ArrayList<RyviewModel>();
		boolean isExist = false;
		for (RyviewModel rj : ryList) {
			isExist = false;
			for (Integer edit : canEdit) {
				if (rj.getFy().equals(String.valueOf(edit))) {
					rj.setIsOnlyLook(false);
					rj.setIsOnlyLookEncode(NFyRybhCodeUtils.encodeIsOnlyLook(
							Integer.valueOf(rj.getFy()),
							Integer.valueOf(rj.getRybh()), false));
					showList.add(rj);
					isExist = true;
					break;
				}

			}
			if (isExist) {
				continue;
			}
			for (Integer look : canLook) {
				if (rj.getFy().equals(String.valueOf(look))) {
					rj.setIsOnlyLook(true);
					rj.setIsOnlyLookEncode(NFyRybhCodeUtils.encodeIsOnlyLook(
							Integer.valueOf(rj.getFy()),
							Integer.valueOf(rj.getRybh()), true));
					showList.add(rj);
					isExist = true;
					break;
				}

			}
		}
		final int size = showList.size();
		RyviewModel[] ryviewArray = (RyviewModel[]) showList
				.toArray(new RyviewModel[size]);

		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, ryviewArray);
	}
	
	@RequestMapping(value = "/zzkRyList.aj", method = RequestMethod.POST)
	public void zzkRyList(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fyDm = request.getParameter("fydm");
		String bmDm = request.getParameter("bmdm");
		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fyDm));
		cx.setBmdm(Integer.valueOf(bmDm));
		cx.setCxlx(Ryklx.ZZK);
		List<RyviewModel> ryList = rykService.getRyviewList(cx);
		int index = 0;
		String[] xmsStrings = new String[ryList.size()];
		for(RyviewModel ry:ryList){
			xmsStrings[index] = ry.getXm();
			index++;
		}
		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, xmsStrings);
	}

	@RequestMapping(value = "/swap.aj", method = RequestMethod.GET)
	public void swapOrder(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fydm = request.getParameter("fydm");
		String rybh1 = request.getParameter("rybh1");
		String rybh2 = request.getParameter("rybh2");
		boolean isSuccess = rykService.swapOrder(Integer.valueOf(fydm),
				Integer.valueOf(rybh1), Integer.valueOf(rybh2));
		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, isSuccess);
	}

//	@RequestMapping(value = "/jrrck.aj", method = RequestMethod.POST)
//	public void jrrck(Model model, HttpServletResponse response,
//			HttpServletRequest request) throws IOException {
//		String s_fydm = request.getParameter("fydm");
//		String rybhList = request.getParameter("rybhList");
//		String s_rcklx = request.getParameter("rcklx");
//		String[] ryList = rybhList.split(",");
//		int fydm = Integer.valueOf(s_fydm);
//		int rcklx = Integer.valueOf(s_rcklx);
//		boolean isSuccess = true;
//		for (String ry : ryList) {
//			int rybh = Integer.valueOf(ry);
//			isSuccess = isSuccess && rykService.addRc(rybh, fydm, rcklx);
//		}
//		ResponseBuilder rb = new ResponseBuilder();
//		rb.writeJsonResponse(response, isSuccess);
//	}

	@RequestMapping(value = "/plxg.aj", method = RequestMethod.POST)
	public void plg(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException,
			IllegalAccessException, InvocationTargetException {
		String s_fydm = request.getParameter("fydm");
		String rybhList = request.getParameter("rybhList");
		String plxglx = request.getParameter("plxglx");
		String[] ryList = rybhList.split(",");
		ResponseBuilder builder = new ResponseBuilder();
		boolean isSuccess = true;
		int increment = 0;// 获取最大ID时需要，因为DAO拦截需要，无法做到session实时提交，需要以此防止ID重复
		for (String ry : ryList) {

			switch (Integer.valueOf(plxglx)) {

			case (1):
				XzzwVO xzzwVo = new XzzwVO();
				BeanUtilsEx.populate(xzzwVo, request.getParameterMap());
				xzzwVo.setNFy(s_fydm);
				xzzwVo.setNRybh(ry);
				xzzwVo.setNId(String.valueOf(increment));
				ryjbxxManager.addXzzw(xzzwVo);

				break;
			case (2):
				FlzwVO flzwVo = new FlzwVO();
				BeanUtilsEx.populate(flzwVo, request.getParameterMap());
				flzwVo.setNFy(s_fydm);
				flzwVo.setNRybh(ry);
				flzwVo.setNId(String.valueOf(increment));
				ryjbxxManager.addFlzw(flzwVo);

				break;
			case (3):
				DjxxVO djxxVo = new DjxxVO();
				BeanUtilsEx.populate(djxxVo, request.getParameterMap());
				djxxVo.setNFy(s_fydm);
				djxxVo.setNRybh(ry);
				djxxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addDjxx(djxxVo);

				break;
			case (4):
				GwyjbVO gwyjbVo = new GwyjbVO();
				BeanUtilsEx.populate(gwyjbVo, request.getParameterMap());
				gwyjbVo.setNFy(s_fydm);
				gwyjbVo.setNRybh(ry);
				gwyjbVo.setNId(String.valueOf(increment));
				ryjbxxManager.addGwyjb(gwyjbVo);

				break;
			case (5):
				PxxxVO pxxxVo = new PxxxVO();
				BeanUtilsEx.populate(pxxxVo, request.getParameterMap());
				pxxxVo.setNFy(s_fydm);
				pxxxVo.setNRybh(ry);
				pxxxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addPxxx(pxxxVo);

				break;
			case (6):
				KhxxVO khxxVo = new KhxxVO();
				BeanUtilsEx.populate(khxxVo, request.getParameterMap());
				khxxVo.setNFy(s_fydm);
				khxxVo.setNRybh(ry);
				khxxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addKhxx(khxxVo);

				break;
			case (7):
				JlixxVO jlixxVo = new JlixxVO();
				BeanUtilsEx.populate(jlixxVo, request.getParameterMap());
				jlixxVo.setNFy(s_fydm);
				jlixxVo.setNRybh(ry);
				jlixxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addJlixx(jlixxVo);

				break;
			case (8):
				JliuxxVO jliuxxVo = new JliuxxVO();
				BeanUtilsEx.populate(jliuxxVo, request.getParameterMap());
				jliuxxVo.setNFy(s_fydm);
				jliuxxVo.setNRybh(ry);
				jliuxxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addJliuxx(jliuxxVo);

				break;
			case (9):
				RcxxVO rcxxVo = new RcxxVO();
				BeanUtilsEx.populate(rcxxVo, request.getParameterMap());
				rcxxVo.setNFy(s_fydm);
				rcxxVo.setNRybh(ry);
				rcxxVo.setNId(String.valueOf(increment));
				ryjbxxManager.addRcxx(rcxxVo);

				break;

			default:
				// shouldn't be here

			}
			increment++;
		}

		builder.writeJsonResponse(response, isSuccess);
	}

	@RequestMapping(value = "/rysc.aj", method = RequestMethod.POST)
	public void jdcxDelete(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		// String fydm = request.getParameter("fydm");
		// String rybh = request.getParameter("rybh");
		// boolean isSuccess = ryjbxxManager.deleteRyjbxx(rybh, fydm);
		// ResponseBuilder rb = new ResponseBuilder();
		// rb.writeJsonResponse(response, isSuccess);

		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		UserContext userContext = RolesUtil.getUserContext(request);
		ResponseBuilder rb = new ResponseBuilder();
		if (fydm.trim().equals(String.valueOf(userContext.getFydm()))
				&& rybh.trim().equals(String.valueOf(userContext.getYhbh()))) {
			rb.writeJsonResponse(response, "deleteSelf");
		}
		boolean isSuccess = ryjbxxService.deleteRyjbxxAndAllSubTable(Integer.valueOf(fydm),Integer.valueOf(rybh));

		if (isSuccess) {
			rb.writeJsonResponse(response, "success");
		} else {
			rb.writeJsonResponse(response, "fail");
		}
	}

	@RequestMapping(value = "/jbbbxz.aj", method = RequestMethod.POST)
	public String ShowJbbb(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String showKey = request.getParameter("showKey");
		model.addAttribute("showKey", showKey);
		return "zzk/jbbbxz";
	}

	@RequestMapping(value = "/dyjbbb.do", method = RequestMethod.GET)
	public String printJbbb(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String showKey = request.getParameter("showKey");
		String numList = request.getParameter("numList");

		String[] code = NFyRybhCodeUtils.decode(showKey);
		int fydm = Integer.valueOf(code[0]);
		int rybh = Integer.valueOf(code[1]);
		// 根据法院代码和人员编号取出人员的信息
		RyjbxxVO ryjbxxVO = ryjbxxManager.getJbxxVOByRybhFy(rybh, fydm);
		if (!("中共党员").equals(ryjbxxVO.getNZzmm())) {
			ryjbxxVO.setDZzmm("无");
		}
		List<JlxxVO> jlxxList = ryjbxxManager.getJlxxByRybhFy(rybh, fydm);
		List<JlxxVO> jlxxVOs = splitLastThreeJlxx(jlxxList);
		List<JtxxVO> jtxxVOs = ryjbxxManager.getJtxxByRybhFy(rybh, fydm);
		List<PxxxVO> pxxxVOs = ryjbxxManager.getPxxxByRybhFy(rybh, fydm);
		List<CgxxVO> cgxxVOs = ryjbxxManager.getCgxxByRybhFy(rybh, fydm);
		List<JlixxVO> jlixxVOs = ryjbxxManager.getJlixxByRybhFy(rybh, fydm);
		List<ZyjszwVO> zyjszwVOs = ryjbxxManager.getZyjszwByRybhFy(rybh, fydm);
		List<XlxxVO> xlxxVOs = ryjbxxManager.getXlxxByRybhFy(rybh, fydm);
		List<WyxxVO> wyxxVOs = ryjbxxManager.getWyxxByRybhFy(rybh, fydm);
		List<KhxxVO> khxxList = ryjbxxManager.getKhxxByRybhFy(rybh, fydm);
		List<KhxxVO> khxxVOs = splitLastThree(khxxList);
		String dwmc = DmMcCommon.dmMc(Integer.valueOf(code[0]),
				ConstantsFyrs.NBXH_DWMC, mapNames, dmService);
		ZyjszwVO zyjszwVO = new ZyjszwVO();
		for (int i = 0; i < zyjszwVOs.size(); i++) {
			zyjszwVO = zyjszwVOs.get(zyjszwVOs.size() - 1);
		}
		XlxxVO xlxxVO = new XlxxVO();
		for (int i = 0; i < xlxxVOs.size(); i++) {
			xlxxVO = xlxxVOs.get(xlxxVOs.size() - 1);
		}
		String wyxx = "";
		if (wyxxVOs.size() == 0) {
			wyxx = "无";
		} else {
			wyxx = wyxxVOs.get(wyxxVOs.size() - 1).getNWyyz();
		}
		model.addAttribute("ryjbxxVO", ryjbxxVO);
		model.addAttribute("jtxxVOs", jtxxVOs);
		model.addAttribute("pxxxVOs", pxxxVOs);
		model.addAttribute("jlxxVOs", jlxxVOs);
		model.addAttribute("jlixxVOs", jlixxVOs);
		model.addAttribute("cgxxVOs", cgxxVOs);
		model.addAttribute("zyjszwVO", zyjszwVO);
		model.addAttribute("xlxxVO", xlxxVO);
		model.addAttribute("wyxx", wyxx);
		model.addAttribute("khxxVOs", khxxVOs);
		model.addAttribute("showkey", showKey);
		model.addAttribute("dwmc", dwmc);
		model.addAttribute("numList", numList);
		return "zzk/showjbbb";
	}

	public List<JlxxVO> splitLastThreeJlxx(List<JlxxVO> s){
		List<JlxxVO> jlxxVOList = new ArrayList<JlxxVO>();
		if(s.size()>=3){
			for(int i=3;i>0;i--){
				jlxxVOList.add(s.get(s.size()-i));
			}
		}else{
			jlxxVOList=s;
		}
		return jlxxVOList;
	}
	
	public List<KhxxVO> splitLastThree(List<KhxxVO> s){
		List<KhxxVO> khxxVOList = new ArrayList<KhxxVO>();
		if(s.size()>=3){
			for(int i=3;i>0;i--){
				khxxVOList.add(s.get(s.size()-i));
			}
		}else{
			khxxVOList=s;
		}
		return khxxVOList;
	}
	
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setRykService(RykService rykService) {
		this.rykService = rykService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRyjbxxManager(RyjbxxManager ryjbxxManager) {
		this.ryjbxxManager = ryjbxxManager;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	@RequestMapping(value = "/lskyr.aj", method = RequestMethod.POST)
	public void lskyr(Model model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String fydst = request.getParameter("fydst");
		String bmdst = request.getParameter("bmdst");
		String fysrc = request.getParameter("fysrc");
		String rybh = request.getParameter("rybh");
		boolean isSuccess = ryjbxxManager.addRyFromLsk(fysrc, rybh, fydst,
				bmdst);
		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, isSuccess);
	}

}

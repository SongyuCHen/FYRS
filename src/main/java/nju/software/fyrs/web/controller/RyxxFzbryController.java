package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.data.dao.RyjbxxFzbDAO;
import nju.software.fyrs.data.dataobject.RyjbxxFzb;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RykService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.Ryklx;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.util.StringUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/ryxx")
public class RyxxFzbryController {
	private RoleMenuService roleMenuService;
	private RykService rykService;
	private DmService dmService;
	private RyjbxxFzbDAO ryjbxxFzbDAO;

	public void setRyjbxxFzbDAO(RyjbxxFzbDAO ryjbxxFzbDAO) {
		this.ryjbxxFzbDAO = ryjbxxFzbDAO;
	}

	@RequestMapping(value = "/fzbry.do", method = RequestMethod.GET)
	public String showZzkDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "人员信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "ryxx");
		model.addAttribute("currentSelectLeftMenu", "非在编人员");
		model.addAttribute("dmbList", dmService.listDmByNBxh("703"));
		return "fzbry/show";
	}

	@RequestMapping(value = "/fzbrykTable.aj", method = RequestMethod.POST)
	public void zzkTable(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fyDm = request.getParameter("fyDm");
		String bmDm = request.getParameter("bmDm");
		String fzbryklx = request.getParameter("fzbryklx");

		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fyDm));
		cx.setBmdm(Integer.valueOf(bmDm));
		cx.setFzbrylx(Integer.valueOf(fzbryklx));
		cx.setCxlx(Ryklx.FZBRYK);
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

	@RequestMapping(value = "/yrlsry.aj", method = RequestMethod.POST)
	public void yrlsry(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		String bm = request.getParameter("bm");

		boolean isSuccess = true;
		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fydm));
		cx.setBmdm(Integer.valueOf(bm));
		cx.setFzbrylx(1);
		cx.setCxlx(Ryklx.FZBRYK);
		List<RyviewModel> ryList = rykService.getRyviewList(cx);
		for (RyviewModel ry : ryList) {
			if (ry.getRybh() == rybh) {
				isSuccess = false;
				break;
			}
		}
		if (isSuccess) {
			isSuccess = rykService.addFzbry(Integer.valueOf(fydm),
					Integer.valueOf(rybh), 1, Integer.valueOf(bm));
		}
		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, isSuccess);
	}

	@RequestMapping(value = "/fzbsc.aj", method = RequestMethod.POST)
	public void fzbsc(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fydm = request.getParameter("fydm");
		String rybh = request.getParameter("rybh");
		String bm = request.getParameter("bm");
		String fzbrylx = request.getParameter("fzbrylx");
		
		boolean isSuccess = rykService.moveToFzbHistory(Integer.valueOf(fydm), Integer.valueOf(rybh), Integer.valueOf(bm), Integer.valueOf(fzbrylx));
		if(StringUtil.equals("2", fzbrylx)){
				RyjbxxFzb fzb = ryjbxxFzbDAO.getRyjbxxFzbByRybhFyDm(Integer.valueOf(rybh), Integer.valueOf(fydm));
				fzb.setNCyy(255);
				fzb.setDCrq(DateUtil.today());
				ryjbxxFzbDAO.update(fzb);
		}
		ResponseBuilder rb = new ResponseBuilder();
		rb.writeJsonResponse(response, isSuccess);
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setDmService(DmService dmService) {
		this.dmService = dmService;
	}

	public void setRykService(RykService rykService) {
		this.rykService = rykService;
	}
}

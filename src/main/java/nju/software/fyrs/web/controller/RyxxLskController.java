package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RykService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.RykcxModel;
import nju.software.fyrs.service.model.Ryklx;
import nju.software.fyrs.service.model.RyviewModel;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.RolesUtil;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/ryxx")
public class RyxxLskController {
	private RoleMenuService roleMenuService;
	private RykService rykService;
	private DmService dmService;

	@RequestMapping(value = "/lsk.do", method = RequestMethod.GET)
	public String showZzkDefault(Model model, HttpServletResponse response,
			HttpServletRequest request) {
		MenuShowUtils.headerMenu(request, model, roleMenuService, "人员信息");
		MenuShowUtils.leftMenu(request, model, roleMenuService, "ryxx");
		model.addAttribute("currentSelectLeftMenu", "历史库");
		model.addAttribute("dmbList", dmService.listDmByNBxh("704"));
		
		return "lsk/show";
	}

	@RequestMapping(value = "/lskTable.aj", method = RequestMethod.POST)
	public void zzkTable(Model model, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String fyDm = request.getParameter("fyDm");
		String bmDm = request.getParameter("bmDm");
		String lsklx = request.getParameter("lsklx");

		RykcxModel cx = new RykcxModel();
		cx.setFydm(Integer.valueOf(fyDm));
		cx.setBmdm(Integer.valueOf(bmDm));
		cx.setLsklx(Integer.valueOf(lsklx));
		cx.setCxlx(Ryklx.LSK);
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

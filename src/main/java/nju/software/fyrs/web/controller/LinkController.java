package nju.software.fyrs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinkController {
	
	@RequestMapping(value = "/link.do", method = RequestMethod.GET)
	public String link(HttpServletRequest request,
			HttpServletResponse response, ModelMap model){
		String type=request.getParameter("type");
		String showKey = request.getParameter("showKey");
		return "redirect:/"+type+".do?showKey="+showKey;
	}
}

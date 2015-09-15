package nju.software.fyrs.web.controller;

import java.security.SignatureException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/init")
public class InitController {
	@RequestMapping(value = "/initMenu.do", method = RequestMethod.GET)
	public void initMenu(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws SignatureException {
		    // 直接初始化菜单
		    // menuService.init();
	}
	
}

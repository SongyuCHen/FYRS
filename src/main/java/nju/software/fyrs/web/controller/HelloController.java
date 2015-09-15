package nju.software.fyrs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * test controller
 * 
 * @author zym
 * 
 */
@Controller
public class HelloController {

	private static Logger logger = Logger.getLogger(HelloController.class);

	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public String hello(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		String s = request.getParameter("test");
		// testService.test();
		
		model.addAttribute("test", "²âÊÔ");
		//throw new RuntimeException("test");
		logger.info("²ÎÊýÎª:" + s);
		return "test";
	}

	@SuppressWarnings("unused")
	private static void printBytes(byte[] test) {
		for (byte b : test) {
			System.out.print(Integer.toBinaryString(b));
		}
		System.out.println();
	}
}

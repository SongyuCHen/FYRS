package nju.software.fyrs.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/alarm")
public class AlarmResetController {
	
	@RequestMapping(value="/reset.do",method = RequestMethod.POST)
	public void reset(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().setAttribute("alarm", "no");
		response.getWriter().write("ok");
	}

}

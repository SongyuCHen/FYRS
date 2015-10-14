package nju.software.fyrs.web.controller;

import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.FyVO;
import nju.software.fyrs.biz.vo.YujingVO;
import nju.software.fyrs.data.dataobject.Log;
import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.service.FyService;
import nju.software.fyrs.service.LogService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.YujingService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.ConstantsFyrs;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.NFyRybhCodeUtils;
import nju.software.fyrs.util.PasswordMd5Utils;
import nju.software.fyrs.util.RolesUtil;

import org.apache.poi.hssf.record.formula.functions.Today;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginController {
	
	private FyService fyService;
	private RyjbxxService ryjbxxService;
	private RoleMenuService roleMenuService;
	private LogService logService;
	private YujingService yujingService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showMain(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws SignatureException {
		    model.addAttribute("result","");
		    model.addAttribute("fymc","");
		    model.addAttribute("fydm","-1");
		    model.addAttribute("username","");
		    model.addAttribute("password","");
			return "login/login";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String showMainPage(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws Exception {
	    try
	    {
	    	
	    
        String fydm=request.getParameter("fybh");
        String fymc = request.getParameter("fymc");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean alarm = false;
		StringBuffer tipContent = new StringBuffer();
		Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByUserNamePassowrd(username,Integer.valueOf(fydm));
		if(ryjbxx  == null)
		{
			model.addAttribute("result","用户名不存在");
			model.addAttribute("fymc",fymc);
		    model.addAttribute("fydm",fydm);
		    model.addAttribute("username",username);
		    model.addAttribute("password",password);
			return "login/login";
		}
		if(!ryjbxx.getCMm().trim().equals(PasswordMd5Utils.generatorPassword(password.trim())))
		{
			model.addAttribute("result","密码不正确");
			model.addAttribute("fymc",fymc);
		    model.addAttribute("fydm",fydm);
		    model.addAttribute("username",username);
		    model.addAttribute("password",password);
			return "login/login";
		}
		request.getSession().removeAttribute("user");
		UserContext user = new UserContext();
		user.setFydm(ryjbxx.getNFy());
		user.setYhbh(ryjbxx.getNRybh());
		user.setYhbm(ryjbxx.getNBm());
		user.setYhmc(ryjbxx.getCXm());
		user.setYhdm(ryjbxx.getCBs());
		if(null == ryjbxx.getCQx())
		{
			user.setYhRoleIds("");
		}
		else
		{
			user.setYhRoleIds(ryjbxx.getCQx().trim());
		}		
		user.setLoginIp(request.getRemoteHost());
		user.setCurrentDataSource("fyrs");
		Date date = new Date();
		// 记住用户登录
		Log log = new Log();
		log.setCCznr("登录系统");
		log.setCCzyh(user.getYhmc());
		log.setCIp(request.getRemoteHost());
		log.setDCzsj(date);
		log.setNDwid(user.getFydm());
		logService.login(log);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日   E HH:mm",Locale.SIMPLIFIED_CHINESE);
		user.setLoginTime(dateFormat.format(date));
		request.getSession().setAttribute("user",user);
		
		if(user.getYhRoleIds().trim().equals(""))
		{
			String showKey = NFyRybhCodeUtils.encode(ryjbxx.getNFy(), ryjbxx.getNRybh());
			user.setHidden(true);
			// 表示默认的权限
			return "redirect:ryjbxx.do?showKey="+showKey; 
		}
		List<Menu> menus = roleMenuService.listMenuByRoleIdMenuType(RolesUtil.stringToIntArray(user.getYhRoleIds()), ConstantsFyrs.HEADMENUTYPE);
		if(menus.size() == 0)
		{
			// 这种情况不大可能
		    return "login/login";
		}else{
			for(Menu menu:menus){
				if(menu.getMenuName().equals("预警管理"))
					alarm = true;
			}
		}
		if(alarm){
			Date begin = new Date();
			Date end = DateUtil.addDays(begin, 3);
			List<YujingVO> yujingVOs = yujingService.getYujingByFyAndDate(fydm, begin, end);
			for(YujingVO vo:yujingVOs){
				tipContent.append(vo.getDYjsj()+":"+vo.getCXm()+" "+vo.getCBz()+"\n");
			}
		}
		request.getSession().setAttribute("alarm",alarm);
		request.getSession().setAttribute("tipContent",tipContent);
		Menu menu = menus.get(0);
		String path = menu.getHref();
        return "redirect:"+path;
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return null;
	}
	@RequestMapping(value = "getfylb.aj", method = RequestMethod.POST)
	public String getFylb(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		FyVO fyVO = fyService.getJsfyList();
		model.put("gylb", fyVO);
		return "login/pop/xzfy";
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login/login";
	}
	@RequestMapping(value = "/changePasswordShow.aj", method = RequestMethod.GET)
	public String changePasswordShow(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		
		return "login/pop/changePassword";
	}
	@RequestMapping(value = "/changePassword.aj", method = RequestMethod.POST)
	public void changePassword(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		  String oldPassworld = request.getParameter("oldPassworld");
		  String newPassworld = request.getParameter("newPassworld");
		  UserContext userContext = RolesUtil.getUserContext(request);
		  Ryjbxx ryjbxx = ryjbxxService.getRyjbxxByUserNamePassowrd(userContext.getYhdm(),userContext.getFydm());
		  String password = ryjbxx.getCMm();
		  if(password.equals(PasswordMd5Utils.generatorPassword(oldPassworld)))
		  {
			  ryjbxxService.updatePassword(PasswordMd5Utils.generatorPassword(newPassworld), ryjbxx.getNRybh(),ryjbxx.getNFy());
			  response.getWriter().write("1");	  
		  }
		  else
		  {
			  response.getWriter().write("-1");
		  }
	}
   
	@RequestMapping(value = "/adminUser.do", method = RequestMethod.GET)
	public String test(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		 return "test";
	}
	
	public void setFyService(FyService fyService) {
		this.fyService = fyService;
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setRyjbxxService(RyjbxxService ryjbxxService) {
		this.ryjbxxService = ryjbxxService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
}

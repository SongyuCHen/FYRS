package nju.software.fyrs.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.dynamicds.UserContextHolder;
import nju.software.fyrs.service.model.UserContext;
import nju.software.fyrs.util.LoginUserInfoThreadLocal;
import nju.software.fyrs.util.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




/**
 * ∑√Œ ¿πΩÿ∆˜
 * 
 * @author zym
 * 
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = Logger.getLogger(AccessInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
        // /fyrs/main/ryxx/zzk.do
		String requestURI = request.getRequestURI();
		if(requestURI.equals("/ryxx.do") || requestURI.equals("/adminUser.do")){
			UserContext u = new UserContext();
			request.getSession().setAttribute("user", u);
		}
		// http://localhost:8080/fyrs/main/ryxx/zzk.do
		String toLogin = request.getRequestURL().toString();
		String doName = request.getServletPath();
		if(StringUtil.contains(doName, "WEB-INF")){
			return true;
		}
		// http://localhost:8080/fyrs/login.do
		String cannotAccess = toLogin.substring(0,
				toLogin.length() - doName.length())
				+ "/login.do";
		UserContext user = (UserContext) request.getSession().getAttribute(
				"user");
		//  return true;
		UserContextHolder.setUserContext(user);
		if (user == null) {
			if (requestURI.endsWith("/login.do")||requestURI.endsWith("/xzfyShow.aj") || requestURI.endsWith("/xzfy.aj")) {
				return true;
			} else {
				
				log.warn("¥ÌŒÛµƒ∑√Œ “≥√Ê°£requestURI:" + requestURI);
				response.sendRedirect(cannotAccess);
				return false;
			}
		} else {
			LoginUserInfoThreadLocal.setUserIp(user.getLoginIp());
			LoginUserInfoThreadLocal.setUsername(user.getYhmc());
			return true;
		}
	}

}

package nju.software.fyrs.util;

import javax.servlet.http.HttpServletRequest;
import nju.software.fyrs.service.DmService;
import nju.software.fyrs.service.RyjbxxService;
import nju.software.fyrs.service.model.UserContext;
import org.springframework.ui.ModelMap;


public class RolesUtil {
  public static int[] stringToIntArray(String rolesString)
  {
	  String[] roleIds = rolesString.split(",");
	  int[] result = new int[roleIds.length];
	  for(int i = 0 ; i < roleIds.length; i++)
	  {
		  result[i] = Integer.valueOf(roleIds[i]);
	  }
	  return result;
  }
  public static int[] userGetRoleIds(HttpServletRequest request)
  {
	  UserContext userContext = (UserContext)request.getSession().getAttribute("user");
	  String roleIds = userContext.getYhRoleIds();
	  return RolesUtil.stringToIntArray(roleIds);
  }
  public static UserContext getUserContext(HttpServletRequest request)
  {
	  return (UserContext)request.getSession().getAttribute("user");
  }

  public static void ryjbxxCommon(HttpServletRequest request,ModelMap model,int fydm,int rybh,RyjbxxService ryjbxxService,DmService dmService)
  {
	  model.addAttribute("isHidden",getUserContext(request).isHidden());
	  System.out.println(getUserContext(request).isHidden());
	  model.addAttribute("cxm",ryjbxxService.getRyjbxxByRybhFyDm(rybh, fydm).getCXm());
	  model.addAttribute("fymc",dmService.dmByDmBxh(fydm,ConstantsFyrs.NBXH_DWMC).getCMc());
  }
  
}

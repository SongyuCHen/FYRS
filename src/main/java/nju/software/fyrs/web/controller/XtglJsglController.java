package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RoleService;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main/xtgl")
public class XtglJsglController {
	 private RoleMenuService roleMenuService;
	  private RoleService roleService;
	  
	  @RequestMapping(value="/jsgl.do",method = RequestMethod.GET)
	    public String showZzkDefault(Model model,HttpServletResponse response,HttpServletRequest request)
	    {
		  MenuShowUtils.headerMenu(request,model, roleMenuService,"系统管理");
	      MenuShowUtils.leftMenu(request,model, roleMenuService, "xtgl");
	       // 当调用这个方法时，显然是显示它这个标签，所以
	       model.addAttribute("currentSelectLeftMenu","角色管理");
	       List<Role> roles = roleService.getAllRoles();
	       model.addAttribute("roles",roles);
	       return "jsgl/show";
	    }
	  @RequestMapping(value="/roles.aj",method = RequestMethod.POST)
	    public String rolesPop(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	       System.out.println("ajax !");
	       String btnType= request.getParameter("btnType");
	       // 0 添加，1 查看
	       if(btnType != null && !btnType.equals("0"))
	       {
	    	   String id = request.getParameter("id");
	    	   Role role = roleService.getRoleById(Integer.valueOf(id));
	    	   model.addAttribute("role", role);
	       }
	       model.addAttribute("btnType",btnType);     
	       return "xtgl/pop/rolePop";
	    }
	  @RequestMapping(value="/rolesAdd.aj",method = RequestMethod.POST)
	    public void rolesAdd(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	       System.out.println("add roleName");
	       String result = "-1";
	       String roleName = request.getParameter("roleName");
	       if(roleName != null)
	       {
	    	   int id = roleService.saveRole(roleName);
	    	   result = String.valueOf(id);
	       }
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response,result);
	    }
	  @RequestMapping(value="/rolesUpdate.aj",method = RequestMethod.POST)
	    public void rolesUpdate(Model model,HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	      
	       String roleName = request.getParameter("roleName");
	       String id = request.getParameter("id");
	       Role role = new Role();
	       role.setId(Integer.valueOf(id));
	       role.setRoleName(roleName);
	       roleService.updateRole(role);
	       String result = "0";
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response,result);
	    }
	  @RequestMapping(value="/roleDelete.aj",method = RequestMethod.POST)
	    public void rolesDelete(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	       String result = "-1";
	       String id = request.getParameter("id");
	       if(null != id && !id.trim().equals(""))
	       {
	    	   roleService.deleteRole(Integer.valueOf(id));
	    	   result = "1";
	       }
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response,result);
	    }
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	  
	  
}

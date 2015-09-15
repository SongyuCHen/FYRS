package nju.software.fyrs.web.controller;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nju.software.fyrs.biz.vo.MenuTreeVO;
import nju.software.fyrs.biz.vo.MenusVO;
import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.service.impl.MenuService;
import nju.software.fyrs.service.impl.RoleMenuService;
import nju.software.fyrs.service.impl.RoleService;
import nju.software.fyrs.web.json.ResponseBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/main/xtgl/qxgl/")
public class AuthorityController {
	private MenuService menuService;
	private RoleService roleService;
	private RoleMenuService roleMenuService;
	@RequestMapping(value = "init.do", method = RequestMethod.GET)
	public void init(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws SignatureException {
		
	}
	@RequestMapping(value = "authority.do", method = RequestMethod.GET)
	public String showAuthority(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws SignatureException {
			return "authority/show";
	}
	
	@RequestMapping(value = "/{currentRoleId}/menuTree.do", method = RequestMethod.GET)
	public String showMenuTree(@PathVariable String currentRoleId,ModelMap model)
			throws SignatureException {
		    List<Integer> ids = menuService.getMenuTopIds();
		    model.addAttribute("ids",ids);
		    model.addAttribute("currentRoleId", currentRoleId);
			return "authority/menuTree";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "roleTreeJson.do", method = RequestMethod.GET)
	public void roleTreeJson(HttpServletResponse response, Model model)
			throws SignatureException, IOException {
		    List<Role> roles = roleService.getAllRoles();
		    List roleTreeVos = new ArrayList();
		    for(Role role : roles)
		    {
		    	Map roleTreeVo = new HashMap();
		    	roleTreeVo.put("data",role.getRoleName());
		    	Map attr = new HashMap();
		    	attr.put("id",role.getId());
		    	roleTreeVo.put("attr", attr);
		    	roleTreeVos.add(roleTreeVo);
		    }
		    ResponseBuilder rb = new ResponseBuilder();
		    rb.writeJsonResponse(response, roleTreeVos);
	}
	// 权限新修改
	@RequestMapping(value = "/menus.aj",method = RequestMethod.GET)
	public String menus(HttpServletRequest request,HttpServletResponse response, Model model)
	{
		List<MenusVO> vos = menuService.listAllMenus();
		List<Role> roles = roleService.getAllRoles();
		model.addAttribute("vos",vos);
		model.addAttribute("roles",roles);
		return "authority/menus";
	}
	@RequestMapping(value = "/menusByRolesId.aj",method = RequestMethod.POST)
	public void menusByRolesId(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception
	{
		String roleId = request.getParameter("roleId");
		List<Menu> menus = roleMenuService.listMenuByRoleId(Integer.valueOf(roleId));
	       Map<String,List<Menu>> map = new HashMap<String,List<Menu>>();
	       map.put("menus",menus);
	       List<Integer> ids = new ArrayList<Integer>();
	       for(Menu menu : menus)
	       {
	           ids.add(menu.getId());
	       }
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response, ids); 
	}
	@RequestMapping(value = "/saveMenuIdToRoleId.aj",method = RequestMethod.POST)
	public void saveMenuIdToRoleId(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception
	{
	        response.setCharacterEncoding("UTF-8");
	        String allIds = request.getParameter("menusId");
	        if(allIds == null || allIds.trim().equals(""))
	        {
	            return;
	        }
	        allIds = allIds.trim().substring(1,allIds.length() - 1);
	        String[] ids = allIds.split(",");
	        roleMenuService.saveRoleMenu(Integer.valueOf(request.getParameter("roleId")),ids);
	        response.getWriter().write("1");
	}
	// 权限新修改
	
	 @RequestMapping(value = "/everyMenuTree/permitIds.do",method = RequestMethod.POST)
	    public void permitIds(HttpServletResponse response,HttpServletRequest request) throws IOException
	    {
	        response.setCharacterEncoding("UTF-8");
	        String allIds = request.getParameter("allIds");
	        if(allIds == null || allIds.trim().equals(""))
	        {
	            return;
	        }
	        allIds = allIds.substring(0,allIds.length() - 1);
	        String[] ids = allIds.split(",");
	        roleMenuService.saveRoleMenu(Integer.valueOf(request.getParameter("roleId")),ids);
	        response.getWriter().write("save");
	    }
	
	 @RequestMapping(value = "/everyMenuTree/allIds/{roleId}/roleId.aj")
	    public void operation_7(@PathVariable String roleId,HttpServletResponse response) throws IOException 
	    {
	       List<Menu> menus = roleMenuService.listMenuByRoleId(Integer.valueOf(roleId));
	       Map<String,List<Menu>> map = new HashMap<String,List<Menu>>();
	       map.put("menus",menus);
	       List<Integer> ids = new ArrayList<Integer>();
	       for(Menu menu : menus)
	       {
	           ids.add(menu.getId());
	       }
	       ResponseBuilder rb = new ResponseBuilder();
	       rb.writeJsonResponse(response, ids); 
	    }
	
	 @RequestMapping(value = "/everyMenuTree/{topId}/tree.do")
		public void everyMenuTeeById(@PathVariable String topId,Model model,HttpServletResponse response)
		{
	         Menu menu =  menuService.menuById(Integer.valueOf(topId));
	         MenuTreeVO menuTreeVO = new MenuTreeVO(menu);
	         ResponseBuilder rb = new ResponseBuilder();
	         try
	         {
	        	 rb.writeJsonResponse(response, menuTreeVO); 
	         }
	         catch(Exception ex)
	         {
	        	 ex.printStackTrace();
	         }
	        
		}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	 
	
	
}

package nju.software.fyrs.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.software.fyrs.data.dao.RoleDAO;
import nju.software.fyrs.data.dataobject.Role;
import nju.software.fyrs.init.RoleName;

public class RoleService {
	private RoleDAO roleDAO;
    static Map<String,String> rolesMap = null;
	public void init()
	{
		 String[] roleNames = RoleName.roleNames;
		    for(String str : roleNames)
		    {
		    	Role role = new Role();
		    	role.setRoleName(str);
		    	int i = roleDAO.getMaxId();
		    	i++;
		    	role.setId(i);
		    	roleDAO.saveRightNow(role);
		    }
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles()
	{
		return roleDAO.findAll();
	}
	public Role getRoleById(int id)
	{
		return roleDAO.findById(id);
	}
	public void deleteRole(int id)
	{
		roleDAO.deleteRoleById(id);
	}
	public void updateRole(Role role)
	{
		Role roleSrc = roleDAO.findById(role.getId());
		roleSrc.setRoleName(role.getRoleName());
		roleDAO.save(roleSrc);
	}
	public int saveRole(String roleName)
	{
	  return this.roleDAO.saveRole(roleName);
	}
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	public String roleNamesByRoleIds(String roleIds[])
	{
		StringBuffer sb = new StringBuffer();
		if(null == rolesMap)
		{
			setUpMap();
		}
		for(int i = 0; i < roleIds.length; i++)
		{
			sb.append(rolesMap.get(roleIds[i])+" | ");
		}
		String result = sb.toString();
		if(result.length() > 3)
		{
			result = result.substring(0, result.length() - 3);
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	private void setUpMap()
	{
	  List<Role> roles = roleDAO.findAll();
	  rolesMap = new HashMap<String, String>();
	  for(Role role : roles)
	  {
		  rolesMap.put(String.valueOf(role.getId()),role.getRoleName());
	  }
	}
}

package nju.software.fyrs.service.impl;

import java.util.List;

import nju.software.fyrs.data.dao.DmDAO;
import nju.software.fyrs.data.dao.RoleMenuDAO;
import nju.software.fyrs.data.dataobject.Dm;
import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.data.dataobject.Ryjbxx;
import nju.software.fyrs.util.ConstantsFyrs;

public class RoleMenuService {
	private RoleMenuDAO roleMenuDAO;
	private DmDAO dmDAO;
	public void saveRoleMenu(int roleId,String[] menuIds)
	{
		this.roleMenuDAO.saveRoleMenu(roleId, menuIds);
	}
	public List<Menu> listMenuByRoleId(int roleId)
	{
	   return this.roleMenuDAO.listMenuByRoleId(roleId);
	}
	public List<Menu> listMenuByRoleIdMenuType(int[] roleIds,int menuType)
	{
	   return this.roleMenuDAO.listMenuByRoleIdMenuType(roleIds, menuType);
	}
	public List<Menu> listMenuByRoleIdParentMenuName(int[] roleIds,String parentMenuName)
	{
		return this.roleMenuDAO.listMenuByRoleIdParentMenuName(roleIds,parentMenuName);
	}
	public void setRoleMenuDAO(RoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}
	public void setDmDAO(DmDAO dmDAO)
	{
		this.dmDAO = dmDAO;
	}
	/**
	 * 
	 * @param roleIds ���ݽ�ɫ�� ID ���ж����ǲ��ǿ��Բ鿴�¼���Ժ
	 * @return
	 */
	public boolean findIsCkxjfy(int[] roleIds)
	{
		List<Menu> menus = roleMenuDAO.listMenuByRoleIdMenuType(roleIds,ConstantsFyrs.CKXJFY);
		if(null == menus)
		{
			return false;
		}
		for(Menu menu : menus)
		{
			if(menu.getUniqueName().equals("rsglqx-xjfyrsgl") || menu.getUniqueName().equals("rsglqx-ckbyjxjfyrsxx") )
			{
				return true;
			}
		}
		return false;
	}
	public void findCanLookAndEditListFy(List<Integer> look,List<Integer> edit,int[] roleIds,int loginFydm)
	{
		List<Menu> menus = roleMenuDAO.listMenuByRoleIdMenuType(roleIds,ConstantsFyrs.CKXJFY);
		if(null == menus)
		{
			return;
		}
		for(Menu menu : menus)
		{
			// ��ʾ���Ա༭��Ժ��Ժ������Ϣ
			if(menu.getUniqueName().trim().equals("rsglqx-byrsgl"))
			{
			  edit.add(loginFydm);
			}
			// ��ʾ���Բ鱾Ժ������Ϣ
			if(menu.getUniqueName().trim().equals("rsglqx-ckbyrsxx"))
			{
			  look.add(loginFydm);
			}
			// ��ʾ���Ա༭�¼���Ժ
			if(menu.getUniqueName().trim().equals("rsglqx-xjfyrsgl"))
			{
			  String fyFjm = getFjmByFydm(loginFydm);
			  if(!fyFjm.equals("-1"))
			  {
				  for(Dm dm : dmDAO.listDmByFyfjm(fyFjm))
				  {
					 // ��Ϊ���� fjm ����Լ��İ�����ȥ��������Ҫȥ���ظ�
					  if(dm.getNDm() != loginFydm)
					  {
						  edit.add(dm.getNDm());
					  }					  
				  }
			  }
			
			}
			// ��ʾ���Բ鿴�¼���Ժ
			if(menu.getUniqueName().equals("rsglqx-ckbyjxjfyrsxx"))
			{
				 String fyFjm = getFjmByFydm(loginFydm);
				  if(!fyFjm.equals("-1"))
				  {
					  for(Dm dm : dmDAO.listDmByFyfjm(fyFjm))
					  {
						  // ��Ϊ���� fjm ����Լ��İ�����ȥ��������Ҫȥ���ظ�
						  if(dm.getNDm() != loginFydm)
						  {
							  look.add(dm.getNDm());
						  }						  
					  }
				  }
			}
						
		}
		// ����༭�ķ�Ժ�����ˣ���ô�鿴��û�б�Ҫ������
		for(int i = 0; i < look.size(); i++)
		{
			for(Integer editInt : edit)
			{
				if((int)look.get(i) == (int)editInt)
				{
					look.remove(look.get(i));
					continue;
				}
			}
		}
		
	}
    private String getFjmByFydm(int fydm)
		{
			 Dm dm = dmDAO.dmByFydm(fydm);
			 String fjm = dm.getCBz();
		    	// ��ʾһ����Ժ
		    	if(fjm.endsWith("00"))
		    	{
		    		return fjm.substring(0,1)+"%";
		    	}
		    	// ��ʾ������Ժ
		    	if(!fjm.endsWith("00") && fjm.endsWith("0"))
		    	{
		    	    return fjm.substring(0,2)+"%";
		    	}
		    	// ��ʾ��ײ㷨Ժ
		    	return "-1";
		}
    /**
     * 
     * @param all
     * @param look
     * @param edit
     * @param editFydm
     */
    public void lookAndEdit(List<Ryjbxx> all,List<Ryjbxx> look,List<Ryjbxx> edit,List<Integer> editFydm)
	  {
		  for(Ryjbxx rj : all)
		  {
			  for(Integer editInt : editFydm)
			  {
				  if(rj.getNFy() == editInt)
				  {
					  edit.add(rj);
					  continue;
				  }
				  else
				  {
					  edit.add(rj);
				  }
			  }
		  }
	  }
	
}

package nju.software.fyrs.biz.vo;

import java.util.ArrayList;
import java.util.List;

public class MenusVO {
	private String id;
	private String menuName;
	private List<MenusVO> children = new ArrayList<MenusVO>();

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	public List<MenusVO> getChildren()
	{
		return children;
	}

	public void setChildren(List<MenusVO> children)
	{
		this.children = children;
	}

}

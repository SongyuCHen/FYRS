package nju.software.fyrs.service.impl;

import java.util.ArrayList;
import java.util.List;

import nju.software.fyrs.biz.vo.MenusVO;
import nju.software.fyrs.data.dao.MenuDAO;
import nju.software.fyrs.data.dataobject.Menu;
import nju.software.fyrs.init.InitMenu;

public class MenuService {

	private MenuDAO menuDAO;

	public void init() {
		InitMenu initmenu = new InitMenu();
		try {
			List<Menu> menus = initmenu.init();
			int i = menuDAO.getMaxId();
			for (Menu menu : menus) {
				i++;
				menu.setId(i);
				 menuDAO.save(menu);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
    public Menu menuById(int id)
    {
    	return menuDAO.findById(id);
    }
	public void save(Menu menu) {
		menuDAO.save(menu);
	}

	public void saveRightNow(Menu menu) {
		menuDAO.saveRightNow(menu);
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	public List<Integer> getMenuTopIds()
	{
		return menuDAO.getMenuTopIds();
	}
	// 权限新修改
	public List<MenusVO> listAllMenus()
	{
		List<MenusVO> vos = new ArrayList<MenusVO>();
		// 表示第一层
		List<Menu> lists = menuDAO.listAllByMenuType("(1,3)");
		for(Menu m : lists)
		{
			MenusVO vo = new MenusVO();
			beanToVO(vo, m);
			for(Menu menu : m.getMenus())
			{
				MenusVO voChildren = new MenusVO();
				beanToVO(voChildren, menu);
				vo.getChildren().add(voChildren);
			}
			vos.add(vo);
		}
		return vos;
	}
	private void beanToVO(MenusVO vo,Menu m)
	{
		vo.setId(m.getId()+"");
		vo.setMenuName(m.getMenuName());
	}
	// 权限新修改

}

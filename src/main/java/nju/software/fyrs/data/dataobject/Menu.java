package nju.software.fyrs.data.dataobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_menu")
public class Menu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8993932089099204772L;
	private Integer id;
	private Menu menu;
	private String href;
	private String menuName;
	private Integer menuType;
	private Integer orderNumber;
	private String uniqueName;
	private Set<Menu> menus = new HashSet<Menu>(0);
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>(0);

	// Constructors

	/** default constructor */
	public Menu()
	{
	}

	/** minimal constructor */
	public Menu(Integer id, Menu menu, String href, String menuName, Integer menuType, Integer orderNumber, String uniqueName)
	{
		this.id = id;
		this.menu = menu;
		this.href = href;
		this.menuName = menuName;
		this.menuType = menuType;
		this.orderNumber = orderNumber;
		this.uniqueName = uniqueName;
	}

	/** full constructor */
	public Menu(Integer id, Menu menu, String href, String menuName, Integer menuType, Integer orderNumber, String uniqueName, Set<Menu> menus, Set<RoleMenu> roleMenus)
	{
		this.id = id;
		this.menu = menu;
		this.href = href;
		this.menuName = menuName;
		this.menuType = menuType;
		this.orderNumber = orderNumber;
		this.uniqueName = uniqueName;
		this.menus = menus;
		this.roleMenus = roleMenus;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid")
	public Menu getMenu()
	{
		return this.menu;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	@Column(name = "href", nullable = false)
	public String getHref()
	{
		return this.href;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	@Column(name = "menuName", nullable = false)
	public String getMenuName()
	{
		return this.menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	@Column(name = "menuType", nullable = false)
	public Integer getMenuType()
	{
		return this.menuType;
	}

	public void setMenuType(Integer menuType)
	{
		this.menuType = menuType;
	}

	@Column(name = "orderNumber", nullable = false)
	public Integer getOrderNumber()
	{
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	@Column(name = "uniqueName", nullable = false)
	public String getUniqueName()
	{
		return this.uniqueName;
	}

	public void setUniqueName(String uniqueName)
	{
		this.uniqueName = uniqueName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<Menu> getMenus()
	{
		return this.menus;
	}

	public void setMenus(Set<Menu> menus)
	{
		this.menus = menus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "menu")
	public Set<RoleMenu> getRoleMenus()
	{
		return this.roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus)
	{
		this.roleMenus = roleMenus;
	}

}
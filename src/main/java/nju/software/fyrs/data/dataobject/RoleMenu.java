package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RoleMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role_menu")
public class RoleMenu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8813823544743621105L;
	private Integer id;
	private Menu menu;
	private Role role;

	// Constructors

	/** default constructor */
	public RoleMenu()
	{
	}

	/** full constructor */
	public RoleMenu(Integer id, Menu menu, Role role)
	{
		this.id = id;
		this.menu = menu;
		this.role = role;
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
	@JoinColumn(name = "menu_id", nullable = false)
	public Menu getMenu()
	{
		return this.menu;
	}

	public void setMenu(Menu menu)
	{
		this.menu = menu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole()
	{
		return this.role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

}
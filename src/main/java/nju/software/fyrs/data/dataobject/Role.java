package nju.software.fyrs.data.dataobject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role")
public class Role implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1810077652074848986L;
	private Integer id;
	private String roleName;
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	// Constructors

	/** default constructor */
	public Role()
	{
	}

	/** minimal constructor */
	public Role(Integer id, String roleName)
	{
		this.id = id;
		this.roleName = roleName;
	}

	/** full constructor */
	public Role(Integer id, String roleName, Set<RoleMenu> roleMenus, Set<UserRole> userRoles)
	{
		this.id = id;
		this.roleName = roleName;
		this.roleMenus = roleMenus;
		this.userRoles = userRoles;
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

	@Column(name = "roleName", nullable = false)
	public String getRoleName()
	{
		return this.roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleMenu> getRoleMenus()
	{
		return this.roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus)
	{
		this.roleMenus = roleMenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<UserRole> getUserRoles()
	{
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles)
	{
		this.userRoles = userRoles;
	}

}
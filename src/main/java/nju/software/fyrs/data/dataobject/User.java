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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5081330352633498186L;
	private Integer id;
	private Integer fy;
	private String password;
	private String rybh;
	private String username;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** minimal constructor */
	public User(Integer id, Integer fy, String password, String rybh, String username)
	{
		this.id = id;
		this.fy = fy;
		this.password = password;
		this.rybh = rybh;
		this.username = username;
	}

	/** full constructor */
	public User(Integer id, Integer fy, String password, String rybh, String username, Set<UserRole> userRoles)
	{
		this.id = id;
		this.fy = fy;
		this.password = password;
		this.rybh = rybh;
		this.username = username;
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

	@Column(name = "fy", nullable = false)
	public Integer getFy()
	{
		return this.fy;
	}

	public void setFy(Integer fy)
	{
		this.fy = fy;
	}

	@Column(name = "password", nullable = false)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "rybh", nullable = false)
	public String getRybh()
	{
		return this.rybh;
	}

	public void setRybh(String rybh)
	{
		this.rybh = rybh;
	}

	@Column(name = "username", nullable = false)
	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<UserRole> getUserRoles()
	{
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles)
	{
		this.userRoles = userRoles;
	}

}
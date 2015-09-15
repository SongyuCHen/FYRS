package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Mc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MC")
public class Mc implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6433639797165358357L;
	// Fields
	// ÏêÏ¸´úÂëÃû³Æ
	private Short NBxh;
	private String CMc;
	private Short NLx;
	private Short NZxz;
	private Short NZdz;
	private Short NDqz;

	// Constructors

	/** default constructor */
	public Mc()
	{
	}

	/** minimal constructor */
	public Mc(Short NBxh, String CMc)
	{
		this.NBxh = NBxh;
		this.CMc = CMc;
	}

	/** full constructor */
	public Mc(Short NBxh, String CMc, Short NLx, Short NZxz, Short NZdz, Short NDqz)
	{
		this.NBxh = NBxh;
		this.CMc = CMc;
		this.NLx = NLx;
		this.NZxz = NZxz;
		this.NZdz = NZdz;
		this.NDqz = NDqz;
	}

	// Property accessors
	@Id
	@Column(name = "N_BXH", unique = true, nullable = false)
	public Short getNBxh()
	{
		return this.NBxh;
	}

	public void setNBxh(Short NBxh)
	{
		this.NBxh = NBxh;
	}

	@Column(name = "C_MC", unique = true, nullable = false, length = 100)
	public String getCMc()
	{
		return this.CMc;
	}

	public void setCMc(String CMc)
	{
		this.CMc = CMc;
	}

	@Column(name = "N_LX")
	public Short getNLx()
	{
		return this.NLx;
	}

	public void setNLx(Short NLx)
	{
		this.NLx = NLx;
	}

	@Column(name = "N_ZXZ")
	public Short getNZxz()
	{
		return this.NZxz;
	}

	public void setNZxz(Short NZxz)
	{
		this.NZxz = NZxz;
	}

	@Column(name = "N_ZDZ")
	public Short getNZdz()
	{
		return this.NZdz;
	}

	public void setNZdz(Short NZdz)
	{
		this.NZdz = NZdz;
	}

	@Column(name = "N_DQZ")
	public Short getNDqz()
	{
		return this.NDqz;
	}

	public void setNDqz(Short NDqz)
	{
		this.NDqz = NDqz;
	}

}
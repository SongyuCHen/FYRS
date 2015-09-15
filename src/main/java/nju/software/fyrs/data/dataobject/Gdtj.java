package nju.software.fyrs.data.dataobject;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gdtj entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_GDTJ")
public class Gdtj implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7098569644357522475L;
	private short NBbh;
	private String CTjbbh;
	private String CTjbmc;

	// Constructors

	/** default constructor */
	public Gdtj()
	{
	}

	/** minimal constructor */
	public Gdtj(short NBbh)
	{
		this.NBbh = NBbh;
	}

	/** full constructor */
	public Gdtj(short NBbh, String CTjbbh, String CTjbmc)
	{
		this.NBbh = NBbh;
		this.CTjbbh = CTjbbh;
		this.CTjbmc = CTjbmc;
	}

	// Property accessors
	@Id
	@Column(name = "N_BBH", unique = true, nullable = false, precision = 4, scale = 0)
	public short getNBbh()
	{
		return this.NBbh;
	}

	public void setNBbh(short NBbh)
	{
		this.NBbh = NBbh;
	}

	@Column(name = "C_TJBBH", length = 10)
	public String getCTjbbh()
	{
		return this.CTjbbh;
	}

	public void setCTjbbh(String CTjbbh)
	{
		this.CTjbbh = CTjbbh;
	}

	@Column(name = "C_TJBMC", length = 100)
	public String getCTjbmc()
	{
		return this.CTjbmc;
	}

	public void setCTjbmc(String CTjbmc)
	{
		this.CTjbmc = CTjbmc;
	}

}
package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Dm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DM", uniqueConstraints = @UniqueConstraint(columnNames =
{ "N_BXH", "C_MC" }))
@IdClass(DmId.class)
public class Dm implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2416050888193393925L;
	// Fields
	// ´úÂëÖ÷¼ü
	private Integer NDm;
	private Short NBxh;
	private String CMc;
	private Integer NXssx;
	private Short NYx;
	private Integer NSfzdy;
	private Integer NSfyc;
	private Integer NDydm;
	private String CBz;

	// Constructors

	/** default constructor */
	public Dm()
	{
	}

	/** full constructor */
	public Dm(Integer nDm, Short nBxh, String cMc, Integer nXssx, Short nYx, Integer nSfzdy, Integer nSfyc, Integer nDydm, String cBz)
	{
		super();
		NDm = nDm;
		NBxh = nBxh;
		CMc = cMc;
		NXssx = nXssx;
		NYx = nYx;
		NSfzdy = nSfzdy;
		NSfyc = nSfyc;
		NDydm = nDydm;
	}

	// Property accessors

	@Id
	@Column(name = "N_DM", nullable = false)
	public Integer getNDm()
	{
		return this.NDm;
	}

	public void setNDm(Integer NDm)
	{
		this.NDm = NDm;
	}

	@Id
	@Column(name = "N_BXH", nullable = false)
	public Short getNBxh()
	{
		return this.NBxh;
	}

	public void setNBxh(Short NBxh)
	{
		this.NBxh = NBxh;
	}

	@Column(name = "C_MC", nullable = false, length = 240)
	public String getCMc()
	{
		return this.CMc;
	}

	public void setCMc(String CMc)
	{
		this.CMc = CMc;
	}

	@Column(name = "N_XSSX")
	public Integer getNXssx()
	{
		return this.NXssx;
	}

	public void setNXssx(Integer NXssx)
	{
		this.NXssx = NXssx;
	}

	@Column(name = "N_YX")
	public Short getNYx()
	{
		return this.NYx;
	}

	public void setNYx(Short NYx)
	{
		this.NYx = NYx;
	}

	@Column(name = "N_SFZDY")
	public Integer getNSfzdy()
	{
		return this.NSfzdy;
	}

	public void setNSfzdy(Integer NSfzdy)
	{
		this.NSfzdy = NSfzdy;
	}

	@Column(name = "N_SFYC")
	public Integer getNSfyc()
	{
		return this.NSfyc;
	}

	public void setNSfyc(Integer NSfyc)
	{
		this.NSfyc = NSfyc;
	}

	@Column(name = "N_DYDM")
	public Integer getNDydm()
	{
		return this.NDydm;
	}

	public void setNDydm(Integer NDydm)
	{
		this.NDydm = NDydm;
	}

	@Column(name = "C_BZ")
	public String getCBz()
	{
		return CBz;
	}

	public void setCBz(String cBz)
	{
		CBz = cBz;
	}

}

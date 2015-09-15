package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * PubDmb entity. @author MyEclipse Persistence Tools
 */
@Entity
@IdClass(Pub_DmbDOId.class)
@Table(name = "PUB_DMB", schema = "dbo", catalog = "JUDGE")
public class Pub_DmbDO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6053628658178542274L;
	// Fields
	private String lbbh;
	private String dmbh;
	private String dmms;
	private String xgdm;
	private String bz;

	// Constructors

	/** default constructor */
	public Pub_DmbDO()
	{
	}

	/** minimal constructor */
	public Pub_DmbDO(String lbbh, String dmbh)
	{
		this.lbbh = lbbh;
		this.dmbh = dmbh;
	}

	/** full constructor */
	public Pub_DmbDO(String lbbh, String dmbh, String dmms, String xgdm, String bz)
	{
		this.lbbh = lbbh;
		this.dmbh = dmbh;
		this.dmms = dmms;
		this.xgdm = xgdm;
		this.bz = bz;
	}

	@Id
	@Column(name = "LBBH", unique = true, nullable = false, length = 20)
	public String getLbbh()
	{
		return this.lbbh;
	}

	public void setLbbh(String lbbh)
	{
		this.lbbh = lbbh;
	}

	@Id
	@Column(name = "DMBH", unique = true, nullable = false, length = 20)
	public String getDmbh()
	{
		return this.dmbh;
	}

	public void setDmbh(String dmbh)
	{
		this.dmbh = dmbh;
	}

	@Column(name = "DMMS", length = 250)
	public String getDmms()
	{
		return this.dmms;
	}

	public void setDmms(String dmms)
	{
		this.dmms = dmms;
	}

	@Column(name = "XGDM", length = 250)
	public String getXgdm()
	{
		return this.xgdm;
	}

	public void setXgdm(String xgdm)
	{
		this.xgdm = xgdm;
	}

	@Column(name = "BZ", length = 250)
	public String getBz()
	{
		return this.bz;
	}

	public void setBz(String bz)
	{
		this.bz = bz;
	}

}

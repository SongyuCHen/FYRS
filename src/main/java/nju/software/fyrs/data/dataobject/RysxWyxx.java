package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxWyxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_WYXX")
@IdClass(RysxWyxxId.class)
public class RysxWyxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5313167173174989461L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NWyyz;
	private Integer NSlcd;
	private Integer NSpjb;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxWyxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nWyyz
	 * @param nSlcd
	 * @param nSpjb
	 * @param nXssx
	 */
	public RysxWyxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nWyyz, Integer nSlcd, Integer nSpjb, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NWyyz = nWyyz;
		NSlcd = nSlcd;
		NSpjb = nSpjb;
		NXssx = nXssx;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", nullable = false, scale = 0)
	public BigDecimal getNId()
	{
		return this.NId;
	}

	public void setNId(BigDecimal NId)
	{
		this.NId = NId;
	}

	@Id
	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Id
	@Column(name = "N_RYBH", nullable = false)
	public Integer getNRybh()
	{
		return this.NRybh;
	}

	public void setNRybh(Integer NRybh)
	{
		this.NRybh = NRybh;
	}

	@Column(name = "N_WYYZ")
	public Integer getNWyyz()
	{
		return this.NWyyz;
	}

	public void setNWyyz(Integer NWyyz)
	{
		this.NWyyz = NWyyz;
	}

	@Column(name = "N_SLCD")
	public Integer getNSlcd()
	{
		return this.NSlcd;
	}

	public void setNSlcd(Integer NSlcd)
	{
		this.NSlcd = NSlcd;
	}

	@Column(name = "N_SPJB")
	public Integer getNSpjb()
	{
		return this.NSpjb;
	}

	public void setNSpjb(Integer NSpjb)
	{
		this.NSpjb = NSpjb;
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

}
package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxBzxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_BZXX")
@IdClass(RysxBzxxId.class)
public class RysxBzxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2981371704168858327L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CBz;
	private Integer NXssx;

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cBz
	 * @param nXssx
	 */
	public RysxBzxx(BigDecimal nId, Integer nFy, Integer nRybh, String cBz, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CBz = cBz;
		NXssx = nXssx;
	}

	// Constructors

	/** default constructor */
	public RysxBzxx()
	{
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

	@Column(name = "C_BZ", length = 150)
	public String getCBz()
	{
		return this.CBz;
	}

	public void setCBz(String CBz)
	{
		this.CBz = CBz;
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
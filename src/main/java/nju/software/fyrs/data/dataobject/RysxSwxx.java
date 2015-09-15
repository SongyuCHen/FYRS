package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxSwxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_SWXX")
@IdClass(RysxSwxxId.class)
public class RysxSwxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6750947149683606503L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NSwcd;
	private Integer NSwyy;
	private Date DSwrq;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxSwxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nSwcd
	 * @param nSwyy
	 * @param dSwrq
	 * @param nXssx
	 */
	public RysxSwxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nSwcd, Integer nSwyy, Date dSwrq, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NSwcd = nSwcd;
		NSwyy = nSwyy;
		DSwrq = dSwrq;
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

	@Column(name = "N_SWCD")
	public Integer getNSwcd()
	{
		return this.NSwcd;
	}

	public void setNSwcd(Integer NSwcd)
	{
		this.NSwcd = NSwcd;
	}

	@Column(name = "N_SWYY")
	public Integer getNSwyy()
	{
		return this.NSwyy;
	}

	public void setNSwyy(Integer NSwyy)
	{
		this.NSwyy = NSwyy;
	}

	@Column(name = "D_SWRQ", length = 23)
	public Date getDSwrq()
	{
		return this.DSwrq;
	}

	public void setDSwrq(Date DSwrq)
	{
		this.DSwrq = DSwrq;
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
package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxZdxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_ZDXX")
@IdClass(RysxZdxxId.class)
public class RysxZdxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6924470487249415072L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Date DRxrq;
	private Integer NZdxl;
	private String CZdyx;
	private Integer NSxzy;
	private String CZdzy;
	private Integer NJyxs;
	private Integer NXxxs;
	private Short NXz;
	private Short NDqxx;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxZdxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param dRxrq
	 * @param nZdxl
	 * @param cZdyx
	 * @param nSxzy
	 * @param cZdzy
	 * @param nJyxs
	 * @param nXxxs
	 * @param nXz
	 * @param nDqxx
	 * @param nXssx
	 */
	public RysxZdxx(BigDecimal nId, Integer nFy, Integer nRybh, Date dRxrq, Integer nZdxl, String cZdyx, Integer nSxzy, String cZdzy, Integer nJyxs, Integer nXxxs, Short nXz, Short nDqxx,
			Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		DRxrq = dRxrq;
		NZdxl = nZdxl;
		CZdyx = cZdyx;
		NSxzy = nSxzy;
		CZdzy = cZdzy;
		NJyxs = nJyxs;
		NXxxs = nXxxs;
		NXz = nXz;
		NDqxx = nDqxx;
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

	@Column(name = "D_RXRQ", length = 23)
	public Date getDRxrq()
	{
		return this.DRxrq;
	}

	public void setDRxrq(Date DRxrq)
	{
		this.DRxrq = DRxrq;
	}

	@Column(name = "N_ZDXL")
	public Integer getNZdxl()
	{
		return this.NZdxl;
	}

	public void setNZdxl(Integer NZdxl)
	{
		this.NZdxl = NZdxl;
	}

	@Column(name = "C_ZDYX", length = 100)
	public String getCZdyx()
	{
		return this.CZdyx;
	}

	public void setCZdyx(String CZdyx)
	{
		this.CZdyx = CZdyx;
	}

	@Column(name = "N_SXZY")
	public Integer getNSxzy()
	{
		return this.NSxzy;
	}

	public void setNSxzy(Integer NSxzy)
	{
		this.NSxzy = NSxzy;
	}

	@Column(name = "C_ZDZY", length = 100)
	public String getCZdzy()
	{
		return this.CZdzy;
	}

	public void setCZdzy(String CZdzy)
	{
		this.CZdzy = CZdzy;
	}

	@Column(name = "N_JYXS")
	public Integer getNJyxs()
	{
		return this.NJyxs;
	}

	public void setNJyxs(Integer NJyxs)
	{
		this.NJyxs = NJyxs;
	}

	@Column(name = "N_XXXS")
	public Integer getNXxxs()
	{
		return this.NXxxs;
	}

	public void setNXxxs(Integer NXxxs)
	{
		this.NXxxs = NXxxs;
	}

	@Column(name = "N_XZ")
	public Short getNXz()
	{
		return this.NXz;
	}

	public void setNXz(Short NXz)
	{
		this.NXz = NXz;
	}

	@Column(name = "N_DQXX")
	public Short getNDqxx()
	{
		return this.NDqxx;
	}

	public void setNDqxx(Short NDqxx)
	{
		this.NDqxx = NDqxx;
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
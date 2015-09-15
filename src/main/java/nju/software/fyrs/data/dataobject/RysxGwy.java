package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxGwy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_GWY")
@IdClass(RysxGwyId.class)
public class RysxGwy implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5866142059428286454L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NGwyjb;
	private Date DQsrq;
	private String CDw;
	private Integer NGzdc;
	private Short NDqxx;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxGwy()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nGwyjb
	 * @param dQsrq
	 * @param cDw
	 * @param nGzdc
	 * @param nDqxx
	 * @param nXssx
	 */
	public RysxGwy(BigDecimal nId, Integer nFy, Integer nRybh, Integer nGwyjb, Date dQsrq, String cDw, Integer nGzdc, Short nDqxx, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NGwyjb = nGwyjb;
		DQsrq = dQsrq;
		CDw = cDw;
		NGzdc = nGzdc;
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

	@Column(name = "N_GWYJB")
	public Integer getNGwyjb()
	{
		return this.NGwyjb;
	}

	public void setNGwyjb(Integer NGwyjb)
	{
		this.NGwyjb = NGwyjb;
	}

	@Column(name = "D_QSRQ", length = 23)
	public Date getDQsrq()
	{
		return this.DQsrq;
	}

	public void setDQsrq(Date DQsrq)
	{
		this.DQsrq = DQsrq;
	}

	@Column(name = "C_DW", length = 50)
	public String getCDw()
	{
		return this.CDw;
	}

	public void setCDw(String CDw)
	{
		this.CDw = CDw;
	}

	@Column(name = "N_GZDC")
	public Integer getNGzdc()
	{
		return this.NGzdc;
	}

	public void setNGzdc(Integer NGzdc)
	{
		this.NGzdc = NGzdc;
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
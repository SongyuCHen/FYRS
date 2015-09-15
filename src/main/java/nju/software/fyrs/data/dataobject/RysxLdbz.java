package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxLdbz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_LDBZ")
@IdClass(RysxLdbzId.class)
public class RysxLdbz implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8274884628274908965L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CQgzdw;
	private String CQgzbm;
	private Integer NZw;
	private Short NZqdzyj;
	private Short NCjkc;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxLdbz()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cQgzdw
	 * @param cQgzbm
	 * @param nZw
	 * @param nZqdzyj
	 * @param nCjkc
	 * @param nXssx
	 */
	public RysxLdbz(BigDecimal nId, Integer nFy, Integer nRybh, String cQgzdw, String cQgzbm, Integer nZw, Short nZqdzyj, Short nCjkc, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CQgzdw = cQgzdw;
		CQgzbm = cQgzbm;
		NZw = nZw;
		NZqdzyj = nZqdzyj;
		NCjkc = nCjkc;
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

	@Column(name = "C_QGZDW", length = 100)
	public String getCQgzdw()
	{
		return this.CQgzdw;
	}

	public void setCQgzdw(String CQgzdw)
	{
		this.CQgzdw = CQgzdw;
	}

	@Column(name = "C_QGZBM", length = 100)
	public String getCQgzbm()
	{
		return this.CQgzbm;
	}

	public void setCQgzbm(String CQgzbm)
	{
		this.CQgzbm = CQgzbm;
	}

	@Column(name = "N_ZW")
	public Integer getNZw()
	{
		return this.NZw;
	}

	public void setNZw(Integer NZw)
	{
		this.NZw = NZw;
	}

	@Column(name = "N_ZQDZYJ")
	public Short getNZqdzyj()
	{
		return this.NZqdzyj;
	}

	public void setNZqdzyj(Short NZqdzyj)
	{
		this.NZqdzyj = NZqdzyj;
	}

	@Column(name = "N_CJKC")
	public Short getNCjkc()
	{
		return this.NCjkc;
	}

	public void setNCjkc(Short NCjkc)
	{
		this.NCjkc = NCjkc;
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
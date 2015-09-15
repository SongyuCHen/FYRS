package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxJialliuxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_JIAOLIUXX")
@IdClass(RysxJialliuxxId.class)
public class RysxJialliuxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2921662821778535699L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NJllb;
	private Integer NJlfs;
	private Integer NJlzwxz;
	private Date DKsrq;
	private Date DJsrq;
	private String CJlzwmc;
	private String CJlgzdw;
	private String CJlgzbm;
	private Short NTbjl;
	private String CJlid;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxJialliuxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nJllb
	 * @param nJlfs
	 * @param nJlzwxz
	 * @param dKsrq
	 * @param dJsrq
	 * @param cJlzwmc
	 * @param cJlgzdw
	 * @param cJlgzbm
	 * @param nTbjl
	 * @param cJlid
	 * @param nXssx
	 */
	public RysxJialliuxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nJllb, Integer nJlfs, Integer nJlzwxz, Date dKsrq, Date dJsrq, String cJlzwmc, String cJlgzdw, String cJlgzbm,
			Short nTbjl, String cJlid, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NJllb = nJllb;
		NJlfs = nJlfs;
		NJlzwxz = nJlzwxz;
		DKsrq = dKsrq;
		DJsrq = dJsrq;
		CJlzwmc = cJlzwmc;
		CJlgzdw = cJlgzdw;
		CJlgzbm = cJlgzbm;
		NTbjl = nTbjl;
		CJlid = cJlid;
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

	@Column(name = "N_JLLB")
	public Integer getNJllb()
	{
		return this.NJllb;
	}

	public void setNJllb(Integer NJllb)
	{
		this.NJllb = NJllb;
	}

	@Column(name = "N_JLFS")
	public Integer getNJlfs()
	{
		return this.NJlfs;
	}

	public void setNJlfs(Integer NJlfs)
	{
		this.NJlfs = NJlfs;
	}

	@Column(name = "N_JLZWXZ")
	public Integer getNJlzwxz()
	{
		return this.NJlzwxz;
	}

	public void setNJlzwxz(Integer NJlzwxz)
	{
		this.NJlzwxz = NJlzwxz;
	}

	@Column(name = "D_KSRQ", length = 23)
	public Date getDKsrq()
	{
		return this.DKsrq;
	}

	public void setDKsrq(Date DKsrq)
	{
		this.DKsrq = DKsrq;
	}

	@Column(name = "D_JSRQ", length = 23)
	public Date getDJsrq()
	{
		return this.DJsrq;
	}

	public void setDJsrq(Date DJsrq)
	{
		this.DJsrq = DJsrq;
	}

	@Column(name = "C_JLZWMC", length = 50)
	public String getCJlzwmc()
	{
		return this.CJlzwmc;
	}

	public void setCJlzwmc(String CJlzwmc)
	{
		this.CJlzwmc = CJlzwmc;
	}

	@Column(name = "C_JLGZDW", length = 50)
	public String getCJlgzdw()
	{
		return this.CJlgzdw;
	}

	public void setCJlgzdw(String CJlgzdw)
	{
		this.CJlgzdw = CJlgzdw;
	}

	@Column(name = "C_JLGZBM", length = 50)
	public String getCJlgzbm()
	{
		return this.CJlgzbm;
	}

	public void setCJlgzbm(String CJlgzbm)
	{
		this.CJlgzbm = CJlgzbm;
	}

	@Column(name = "N_TBJL")
	public Short getNTbjl()
	{
		return this.NTbjl;
	}

	public void setNTbjl(Short NTbjl)
	{
		this.NTbjl = NTbjl;
	}

	@Column(name = "C_JLID", length = 50)
	public String getCJlid()
	{
		return this.CJlid;
	}

	public void setCJlid(String CJlid)
	{
		this.CJlid = CJlid;
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
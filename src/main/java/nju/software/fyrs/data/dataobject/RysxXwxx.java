package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxXwxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_XWXX")
@IdClass(RysxXwxxId.class)
public class RysxXwxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733753614402684897L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NXw;
	private Integer NSxzy;
	private String CSxzy;
	private String CXxmc;
	private Integer NJyxs;
	private Integer NXxlb;
	private Integer NXxxs;
	private Date DRxrq;
	private Date DByrq;
	private Short NXz;
	private Date DSyrq;
	private Integer NSygj;
	private Short NDqxx;
	private Short NTbjl;
	private String CJlid;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxXwxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nXw
	 * @param nSxzy
	 * @param cSxzy
	 * @param cXxmc
	 * @param nJyxs
	 * @param nXxlb
	 * @param nXxxs
	 * @param dRxrq
	 * @param dByrq
	 * @param nXz
	 * @param dSyrq
	 * @param nSygj
	 * @param nDqxx
	 * @param nTbjl
	 * @param cJlid
	 * @param nXssx
	 */
	public RysxXwxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nXw, Integer nSxzy, String cSxzy, String cXxmc, Integer nJyxs, Integer nXxlb, Integer nXxxs, Date dRxrq, Date dByrq,
			Short nXz, Date dSyrq, Integer nSygj, Short nDqxx, Short nTbjl, String cJlid, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NXw = nXw;
		NSxzy = nSxzy;
		CSxzy = cSxzy;
		CXxmc = cXxmc;
		NJyxs = nJyxs;
		NXxlb = nXxlb;
		NXxxs = nXxxs;
		DRxrq = dRxrq;
		DByrq = dByrq;
		NXz = nXz;
		DSyrq = dSyrq;
		NSygj = nSygj;
		NDqxx = nDqxx;
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

	@Column(name = "N_XW")
	public Integer getNXw()
	{
		return this.NXw;
	}

	public void setNXw(Integer NXw)
	{
		this.NXw = NXw;
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

	@Column(name = "C_SXZY", length = 100)
	public String getCSxzy()
	{
		return this.CSxzy;
	}

	public void setCSxzy(String CSxzy)
	{
		this.CSxzy = CSxzy;
	}

	@Column(name = "C_XXMC", length = 100)
	public String getCXxmc()
	{
		return this.CXxmc;
	}

	public void setCXxmc(String CXxmc)
	{
		this.CXxmc = CXxmc;
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

	@Column(name = "N_XXLB")
	public Integer getNXxlb()
	{
		return this.NXxlb;
	}

	public void setNXxlb(Integer NXxlb)
	{
		this.NXxlb = NXxlb;
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

	@Column(name = "D_RXRQ", length = 23)
	public Date getDRxrq()
	{
		return this.DRxrq;
	}

	public void setDRxrq(Date DRxrq)
	{
		this.DRxrq = DRxrq;
	}

	@Column(name = "D_BYRQ", length = 23)
	public Date getDByrq()
	{
		return this.DByrq;
	}

	public void setDByrq(Date DByrq)
	{
		this.DByrq = DByrq;
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

	@Column(name = "D_SYRQ", length = 23)
	public Date getDSyrq()
	{
		return this.DSyrq;
	}

	public void setDSyrq(Date DSyrq)
	{
		this.DSyrq = DSyrq;
	}

	@Column(name = "N_SYGJ")
	public Integer getNSygj()
	{
		return this.NSygj;
	}

	public void setNSygj(Integer NSygj)
	{
		this.NSygj = NSygj;
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
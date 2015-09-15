package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxPxxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_PXXX")
@IdClass(RysxPxxxId.class)
public class RysxPxxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3196643939337496805L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NPxxs;
	private String CQtpxxs;
	private String CPxbmc;
	private Date DKsrq;
	private Date DJsrq;
	private Integer NJglb;
	private String CQtjglb;
	private String CPxjg;
	private Integer NZy;
	private Short NXz;
	private String CPxcj;
	private Integer NPxfs;
	private Integer NPxzl;
	private Short NTbjl;
	private String CJlid;
	private Short NSfqdzs;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxPxxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nPxxs
	 * @param cQtpxxs
	 * @param cPxbmc
	 * @param dKsrq
	 * @param dJsrq
	 * @param nJglb
	 * @param cQtjglb
	 * @param cPxjg
	 * @param nZy
	 * @param nXz
	 * @param cPxcj
	 * @param nPxfs
	 * @param nPxzl
	 * @param nTbjl
	 * @param cJlid
	 * @param nSfqdzs
	 * @param nXssx
	 */
	public RysxPxxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nPxxs, String cQtpxxs, String cPxbmc, Date dKsrq, Date dJsrq, Integer nJglb, String cQtjglb, String cPxjg,
			Integer nZy, Short nXz, String cPxcj, Integer nPxfs, Integer nPxzl, Short nTbjl, String cJlid, Short nSfqdzs, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NPxxs = nPxxs;
		CQtpxxs = cQtpxxs;
		CPxbmc = cPxbmc;
		DKsrq = dKsrq;
		DJsrq = dJsrq;
		NJglb = nJglb;
		CQtjglb = cQtjglb;
		CPxjg = cPxjg;
		NZy = nZy;
		NXz = nXz;
		CPxcj = cPxcj;
		NPxfs = nPxfs;
		NPxzl = nPxzl;
		NTbjl = nTbjl;
		CJlid = cJlid;
		NSfqdzs = nSfqdzs;
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

	@Column(name = "N_PXXS")
	public Integer getNPxxs()
	{
		return this.NPxxs;
	}

	public void setNPxxs(Integer NPxxs)
	{
		this.NPxxs = NPxxs;
	}

	@Column(name = "C_QTPXXS", length = 100)
	public String getCQtpxxs()
	{
		return this.CQtpxxs;
	}

	public void setCQtpxxs(String CQtpxxs)
	{
		this.CQtpxxs = CQtpxxs;
	}

	@Column(name = "C_PXBMC", length = 100)
	public String getCPxbmc()
	{
		return this.CPxbmc;
	}

	public void setCPxbmc(String CPxbmc)
	{
		this.CPxbmc = CPxbmc;
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

	@Column(name = "N_JGLB")
	public Integer getNJglb()
	{
		return this.NJglb;
	}

	public void setNJglb(Integer NJglb)
	{
		this.NJglb = NJglb;
	}

	@Column(name = "C_QTJGLB", length = 100)
	public String getCQtjglb()
	{
		return this.CQtjglb;
	}

	public void setCQtjglb(String CQtjglb)
	{
		this.CQtjglb = CQtjglb;
	}

	@Column(name = "C_PXJG", length = 100)
	public String getCPxjg()
	{
		return this.CPxjg;
	}

	public void setCPxjg(String CPxjg)
	{
		this.CPxjg = CPxjg;
	}

	@Column(name = "N_ZY")
	public Integer getNZy()
	{
		return this.NZy;
	}

	public void setNZy(Integer NZy)
	{
		this.NZy = NZy;
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

	@Column(name = "C_PXCJ", length = 10)
	public String getCPxcj()
	{
		return this.CPxcj;
	}

	public void setCPxcj(String CPxcj)
	{
		this.CPxcj = CPxcj;
	}

	@Column(name = "N_PXFS")
	public Integer getNPxfs()
	{
		return this.NPxfs;
	}

	public void setNPxfs(Integer NPxfs)
	{
		this.NPxfs = NPxfs;
	}

	@Column(name = "N_PXZL")
	public Integer getNPxzl()
	{
		return this.NPxzl;
	}

	public void setNPxzl(Integer NPxzl)
	{
		this.NPxzl = NPxzl;
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

	@Column(name = "N_SFQDZS")
	public Short getNSfqdzs()
	{
		return this.NSfqdzs;
	}

	public void setNSfqdzs(Short NSfqdzs)
	{
		this.NSfqdzs = NSfqdzs;
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
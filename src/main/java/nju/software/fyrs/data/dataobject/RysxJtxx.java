package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxJtxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_JTXX")
@IdClass(RysxJtxxId.class)
public class RysxJtxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662679102539039911L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CXm;
	private Integer NYbrgx;
	private Date DCsrq;
	private Integer NZzmm;
	private String CJtdh;
	private String CYzbm;
	private Integer NZfmj;
	private String CJtzz;
	private String CDwjzw;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxJtxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cXm
	 * @param nYbrgx
	 * @param dCsrq
	 * @param nZzmm
	 * @param cJtdh
	 * @param cYzbm
	 * @param nZfmj
	 * @param cJtzz
	 * @param cDwjzw
	 * @param nXssx
	 */
	public RysxJtxx(BigDecimal nId, Integer nFy, Integer nRybh, String cXm, Integer nYbrgx, Date dCsrq, Integer nZzmm, String cJtdh, String cYzbm, Integer nZfmj, String cJtzz, String cDwjzw,
			Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CXm = cXm;
		NYbrgx = nYbrgx;
		DCsrq = dCsrq;
		NZzmm = nZzmm;
		CJtdh = cJtdh;
		CYzbm = cYzbm;
		NZfmj = nZfmj;
		CJtzz = cJtzz;
		CDwjzw = cDwjzw;
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

	@Column(name = "C_XM", length = 50)
	public String getCXm()
	{
		return this.CXm;
	}

	public void setCXm(String CXm)
	{
		this.CXm = CXm;
	}

	@Column(name = "N_YBRGX")
	public Integer getNYbrgx()
	{
		return this.NYbrgx;
	}

	public void setNYbrgx(Integer NYbrgx)
	{
		this.NYbrgx = NYbrgx;
	}

	@Column(name = "D_CSRQ", length = 23)
	public Date getDCsrq()
	{
		return this.DCsrq;
	}

	public void setDCsrq(Date DCsrq)
	{
		this.DCsrq = DCsrq;
	}

	@Column(name = "N_ZZMM")
	public Integer getNZzmm()
	{
		return this.NZzmm;
	}

	public void setNZzmm(Integer NZzmm)
	{
		this.NZzmm = NZzmm;
	}

	@Column(name = "C_JTDH", length = 20)
	public String getCJtdh()
	{
		return this.CJtdh;
	}

	public void setCJtdh(String CJtdh)
	{
		this.CJtdh = CJtdh;
	}

	@Column(name = "C_YZBM", length = 6)
	public String getCYzbm()
	{
		return this.CYzbm;
	}

	public void setCYzbm(String CYzbm)
	{
		this.CYzbm = CYzbm;
	}

	@Column(name = "N_ZFMJ")
	public Integer getNZfmj()
	{
		return this.NZfmj;
	}

	public void setNZfmj(Integer NZfmj)
	{
		this.NZfmj = NZfmj;
	}

	@Column(name = "C_JTZZ", length = 100)
	public String getCJtzz()
	{
		return this.CJtzz;
	}

	public void setCJtzz(String CJtzz)
	{
		this.CJtzz = CJtzz;
	}

	@Column(name = "C_DWJZW", length = 100)
	public String getCDwjzw()
	{
		return this.CDwjzw;
	}

	public void setCDwjzw(String CDwjzw)
	{
		this.CDwjzw = CDwjzw;
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
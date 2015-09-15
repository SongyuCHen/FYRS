package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxGzxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_GZXX")
@IdClass(RysxGzxxId.class)
public class RysxGzxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 169808938449094815L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CZwgzdc;
	private Double MZwgze;
	private Date DZwgzdcsj;
	private String CXjb;
	private Double MJbgze;
	private Date DXjbsj;
	private Double MJcgz;
	private Double MGlgz;
	private Double MZwgwbt;
	private Double MJt;
	private Double MJhljt;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxGzxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cZwgzdc
	 * @param mZwgze
	 * @param dZwgzdcsj
	 * @param cXjb
	 * @param mJbgze
	 * @param dXjbsj
	 * @param mJcgz
	 * @param mGlgz
	 * @param mZwgwbt
	 * @param mJt
	 * @param mJhljt
	 * @param nXssx
	 */
	public RysxGzxx(BigDecimal nId, Integer nFy, Integer nRybh, String cZwgzdc, Double mZwgze, Date dZwgzdcsj, String cXjb, Double mJbgze, Date dXjbsj, Double mJcgz, Double mGlgz,
			Double mZwgwbt, Double mJt, Double mJhljt, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CZwgzdc = cZwgzdc;
		MZwgze = mZwgze;
		DZwgzdcsj = dZwgzdcsj;
		CXjb = cXjb;
		MJbgze = mJbgze;
		DXjbsj = dXjbsj;
		MJcgz = mJcgz;
		MGlgz = mGlgz;
		MZwgwbt = mZwgwbt;
		MJt = mJt;
		MJhljt = mJhljt;
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

	@Column(name = "C_ZWGZDC", length = 20)
	public String getCZwgzdc()
	{
		return this.CZwgzdc;
	}

	public void setCZwgzdc(String CZwgzdc)
	{
		this.CZwgzdc = CZwgzdc;
	}

	@Column(name = "M_ZWGZE", scale = 4)
	public Double getMZwgze()
	{
		return this.MZwgze;
	}

	public void setMZwgze(Double MZwgze)
	{
		this.MZwgze = MZwgze;
	}

	@Column(name = "D_ZWGZDCSJ", length = 23)
	public Date getDZwgzdcsj()
	{
		return this.DZwgzdcsj;
	}

	public void setDZwgzdcsj(Date DZwgzdcsj)
	{
		this.DZwgzdcsj = DZwgzdcsj;
	}

	@Column(name = "C_XJB", length = 20)
	public String getCXjb()
	{
		return this.CXjb;
	}

	public void setCXjb(String CXjb)
	{
		this.CXjb = CXjb;
	}

	@Column(name = "M_JBGZE", scale = 4)
	public Double getMJbgze()
	{
		return this.MJbgze;
	}

	public void setMJbgze(Double MJbgze)
	{
		this.MJbgze = MJbgze;
	}

	@Column(name = "D_XJBSJ", length = 23)
	public Date getDXjbsj()
	{
		return this.DXjbsj;
	}

	public void setDXjbsj(Date DXjbsj)
	{
		this.DXjbsj = DXjbsj;
	}

	@Column(name = "M_JCGZ", scale = 4)
	public Double getMJcgz()
	{
		return this.MJcgz;
	}

	public void setMJcgz(Double MJcgz)
	{
		this.MJcgz = MJcgz;
	}

	@Column(name = "M_GLGZ", scale = 4)
	public Double getMGlgz()
	{
		return this.MGlgz;
	}

	public void setMGlgz(Double MGlgz)
	{
		this.MGlgz = MGlgz;
	}

	@Column(name = "M_ZWGWBT", scale = 4)
	public Double getMZwgwbt()
	{
		return this.MZwgwbt;
	}

	public void setMZwgwbt(Double MZwgwbt)
	{
		this.MZwgwbt = MZwgwbt;
	}

	@Column(name = "M_JT", scale = 4)
	public Double getMJt()
	{
		return this.MJt;
	}

	public void setMJt(Double MJt)
	{
		this.MJt = MJt;
	}

	@Column(name = "M_JHLJT", scale = 4)
	public Double getMJhljt()
	{
		return this.MJhljt;
	}

	public void setMJhljt(Double MJhljt)
	{
		this.MJhljt = MJhljt;
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
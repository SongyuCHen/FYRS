package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxDjxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_DJXX")
@IdClass(RysxDjxxId.class)
public class RysxDjxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8783097734414045612L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NDjlb;
	private Integer NDjmc;
	private Date DQsrq;
	private String CPzwh;
	private Integer NBdlb;
	private Integer NBdyy;
	private String CPzdw;
	private String CZsbh;
	private Short NDqxx;
	private String CBdyj;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxDjxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nDjlb
	 * @param nDjmc
	 * @param dQsrq
	 * @param cPzwh
	 * @param nBdlb
	 * @param nBdyy
	 * @param cPzdw
	 * @param cZsbh
	 * @param nDqxx
	 * @param cBdyj
	 * @param nXssx
	 */
	public RysxDjxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nDjlb, Integer nDjmc, Date dQsrq, String cPzwh, Integer nBdlb, Integer nBdyy, String cPzdw, String cZsbh, Short nDqxx,
			String cBdyj, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NDjlb = nDjlb;
		NDjmc = nDjmc;
		DQsrq = dQsrq;
		CPzwh = cPzwh;
		NBdlb = nBdlb;
		NBdyy = nBdyy;
		CPzdw = cPzdw;
		CZsbh = cZsbh;
		NDqxx = nDqxx;
		CBdyj = cBdyj;
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

	@Column(name = "N_DJLB")
	public Integer getNDjlb()
	{
		return this.NDjlb;
	}

	public void setNDjlb(Integer NDjlb)
	{
		this.NDjlb = NDjlb;
	}

	@Column(name = "N_DJMC")
	public Integer getNDjmc()
	{
		return this.NDjmc;
	}

	public void setNDjmc(Integer NDjmc)
	{
		this.NDjmc = NDjmc;
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

	@Column(name = "C_PZWH", length = 50)
	public String getCPzwh()
	{
		return this.CPzwh;
	}

	public void setCPzwh(String CPzwh)
	{
		this.CPzwh = CPzwh;
	}

	@Column(name = "N_BDLB")
	public Integer getNBdlb()
	{
		return this.NBdlb;
	}

	public void setNBdlb(Integer NBdlb)
	{
		this.NBdlb = NBdlb;
	}

	@Column(name = "N_BDYY")
	public Integer getNBdyy()
	{
		return this.NBdyy;
	}

	public void setNBdyy(Integer NBdyy)
	{
		this.NBdyy = NBdyy;
	}

	@Column(name = "C_PZDW", length = 100)
	public String getCPzdw()
	{
		return this.CPzdw;
	}

	public void setCPzdw(String CPzdw)
	{
		this.CPzdw = CPzdw;
	}

	@Column(name = "C_ZSBH", length = 50)
	public String getCZsbh()
	{
		return this.CZsbh;
	}

	public void setCZsbh(String CZsbh)
	{
		this.CZsbh = CZsbh;
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

	@Column(name = "C_BDYJ", length = 150)
	public String getCBdyj()
	{
		return this.CBdyj;
	}

	public void setCBdyj(String CBdyj)
	{
		this.CBdyj = CBdyj;
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
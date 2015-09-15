package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxXzzw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_XZZW")
@IdClass(RysxXzzwId.class)
public class RysxXzzw implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6886363828490721613L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NRmlb;
	private Integer NXzzw;
	private Date DRmrq;
	private String CDw;
	private String CBm;
	private Integer NRmyy;
	private Date DPzrq;
	private String CPzdw;
	private String CPzwh;
	private Short NDqxx;
	private String CJlid;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxXzzw()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nRmlb
	 * @param nXzzw
	 * @param dRmrq
	 * @param cDw
	 * @param cBm
	 * @param nRmyy
	 * @param dPzrq
	 * @param cPzdw
	 * @param cPzwh
	 * @param nDqxx
	 * @param cJlid
	 * @param nXssx
	 */
	public RysxXzzw(BigDecimal nId, Integer nFy, Integer nRybh, Integer nRmlb, Integer nXzzw, Date dRmrq, String cDw, String cBm, Integer nRmyy, Date dPzrq, String cPzdw, String cPzwh,
			Short nDqxx, String cJlid, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NRmlb = nRmlb;
		NXzzw = nXzzw;
		DRmrq = dRmrq;
		CDw = cDw;
		CBm = cBm;
		NRmyy = nRmyy;
		DPzrq = dPzrq;
		CPzdw = cPzdw;
		CPzwh = cPzwh;
		NDqxx = nDqxx;
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

	@Column(name = "N_RMLB", nullable = false)
	public Integer getNRmlb()
	{
		return this.NRmlb;
	}

	public void setNRmlb(Integer NRmlb)
	{
		this.NRmlb = NRmlb;
	}

	@Column(name = "N_XZZW")
	public Integer getNXzzw()
	{
		return this.NXzzw;
	}

	public void setNXzzw(Integer NXzzw)
	{
		this.NXzzw = NXzzw;
	}

	@Column(name = "D_RMRQ", length = 23)
	public Date getDRmrq()
	{
		return this.DRmrq;
	}

	public void setDRmrq(Date DRmrq)
	{
		this.DRmrq = DRmrq;
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

	@Column(name = "C_BM", length = 50)
	public String getCBm()
	{
		return this.CBm;
	}

	public void setCBm(String CBm)
	{
		this.CBm = CBm;
	}

	@Column(name = "N_RMYY")
	public Integer getNRmyy()
	{
		return this.NRmyy;
	}

	public void setNRmyy(Integer NRmyy)
	{
		this.NRmyy = NRmyy;
	}

	@Column(name = "D_PZRQ", length = 23)
	public Date getDPzrq()
	{
		return this.DPzrq;
	}

	public void setDPzrq(Date DPzrq)
	{
		this.DPzrq = DPzrq;
	}

	@Column(name = "C_PZDW", length = 50)
	public String getCPzdw()
	{
		return this.CPzdw;
	}

	public void setCPzdw(String CPzdw)
	{
		this.CPzdw = CPzdw;
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

	@Column(name = "N_DQXX")
	public Short getNDqxx()
	{
		return this.NDqxx;
	}

	public void setNDqxx(Short NDqxx)
	{
		this.NDqxx = NDqxx;
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
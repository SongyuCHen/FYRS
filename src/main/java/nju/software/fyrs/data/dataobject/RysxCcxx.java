package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxCcxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_CCXX")
@IdClass(RysxCcxxId.class)
public class RysxCcxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8275271244815813786L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NCclb;
	private Integer NCcyy;
	private Date DCcrq;
	private Date DJcrq;
	private String CPzdw;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxCcxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nCclb
	 * @param nCcyy
	 * @param dCcrq
	 * @param dJcrq
	 * @param cPzdw
	 * @param nXssx
	 */
	public RysxCcxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nCclb, Integer nCcyy, Date dCcrq, Date dJcrq, String cPzdw, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NCclb = nCclb;
		NCcyy = nCcyy;
		DCcrq = dCcrq;
		DJcrq = dJcrq;
		CPzdw = cPzdw;
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

	@Column(name = "N_CCLB")
	public Integer getNCclb()
	{
		return this.NCclb;
	}

	public void setNCclb(Integer NCclb)
	{
		this.NCclb = NCclb;
	}

	@Column(name = "N_CCYY")
	public Integer getNCcyy()
	{
		return this.NCcyy;
	}

	public void setNCcyy(Integer NCcyy)
	{
		this.NCcyy = NCcyy;
	}

	@Column(name = "D_CCRQ", length = 23)
	public Date getDCcrq()
	{
		return this.DCcrq;
	}

	public void setDCcrq(Date DCcrq)
	{
		this.DCcrq = DCcrq;
	}

	@Column(name = "D_JCRQ", length = 23)
	public Date getDJcrq()
	{
		return this.DJcrq;
	}

	public void setDJcrq(Date DJcrq)
	{
		this.DJcrq = DJcrq;
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
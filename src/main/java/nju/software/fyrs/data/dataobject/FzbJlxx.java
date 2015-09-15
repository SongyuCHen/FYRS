package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxJlxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FZB_JLXX")
@IdClass(FzbJlxxId.class)
public class FzbJlxx implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 318514116215627780L;
	// Fields
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CSzdw;
	private String CSzbm;
	private Date DQsrq;
	private Date DJzrq;
	private String CZw;
	private String CZj;
	private String CZmr;
	private String CGlxx;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public FzbJlxx()
	{
	}

	/** full constructor */
	public FzbJlxx(BigDecimal NId, Integer NFy, Integer NRybh, String CSzdw, String CSzbm, Date DQsrq, Date DJzrq, String CZw, String CZj, String CZmr, String CGlxx, Integer NXssx)
	{
		this.NId = NId;
		this.NFy = NFy;
		this.NRybh = NRybh;
		this.CSzdw = CSzdw;
		this.CSzbm = CSzbm;
		this.DQsrq = DQsrq;
		this.DJzrq = DJzrq;
		this.CZw = CZw;
		this.CZj = CZj;
		this.CZmr = CZmr;
		this.CGlxx = CGlxx;
		this.NXssx = NXssx;
	}

	@Column(name = "C_SZDW", length = 200)
	public String getCSzdw()
	{
		return this.CSzdw;
	}

	public void setCSzdw(String CSzdw)
	{
		this.CSzdw = CSzdw;
	}

	@Column(name = "C_SZBM", length = 100)
	public String getCSzbm()
	{
		return this.CSzbm;
	}

	public void setCSzbm(String CSzbm)
	{
		this.CSzbm = CSzbm;
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

	@Column(name = "D_JZRQ", length = 23)
	public Date getDJzrq()
	{
		return this.DJzrq;
	}

	public void setDJzrq(Date DJzrq)
	{
		this.DJzrq = DJzrq;
	}

	@Column(name = "C_ZW")
	public String getCZw()
	{
		return this.CZw;
	}

	public void setCZw(String CZw)
	{
		this.CZw = CZw;
	}

	@Column(name = "C_ZJ", length = 50)
	public String getCZj()
	{
		return this.CZj;
	}

	public void setCZj(String CZj)
	{
		this.CZj = CZj;
	}

	@Column(name = "C_ZMR", length = 50)
	public String getCZmr()
	{
		return this.CZmr;
	}

	public void setCZmr(String CZmr)
	{
		this.CZmr = CZmr;
	}

	@Column(name = "C_GLXX", length = 100)
	public String getCGlxx()
	{
		return this.CGlxx;
	}

	public void setCGlxx(String CGlxx)
	{
		this.CGlxx = CGlxx;
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

	@Id
	@Column(name = "N_ID", nullable = false, scale = 0)
	public BigDecimal getNId()
	{
		return NId;
	}

	public void setNId(BigDecimal nId)
	{
		NId = nId;
	}

	@Id
	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return NFy;
	}

	public void setNFy(Integer nFy)
	{
		NFy = nFy;
	}

	@Id
	@Column(name = "N_RYBH", nullable = false)
	public Integer getNRybh()
	{
		return NRybh;
	}

	public void setNRybh(Integer nRybh)
	{
		NRybh = nRybh;
	}

}
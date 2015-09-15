package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_LOG")
public class Log implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -898033554831708346L;
	private BigDecimal NId;
	private String CCzyh;
	private Integer NDwid;
	private String CIp;
	private Date DCzsj;
	private String CCznr;

	// Constructors

	/** default constructor */
	public Log()
	{
	}

	/** minimal constructor */
	public Log(BigDecimal NId, String CCzyh)
	{
		this.NId = NId;
		this.CCzyh = CCzyh;
	}

	/** full constructor */
	public Log(BigDecimal NId, String CCzyh, Integer NDwid, String CIp, Date DCzsj, String CCznr)
	{
		this.NId = NId;
		this.CCzyh = CCzyh;
		this.NDwid = NDwid;
		this.CIp = CIp;
		this.DCzsj = DCzsj;
		this.CCznr = CCznr;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getNId()
	{
		return this.NId;
	}

	public void setNId(BigDecimal NId)
	{
		this.NId = NId;
	}

	@Column(name = "C_CZYH", nullable = false, length = 50)
	public String getCCzyh()
	{
		return this.CCzyh;
	}

	public void setCCzyh(String CCzyh)
	{
		this.CCzyh = CCzyh;
	}

	@Column(name = "N_DWID")
	public Integer getNDwid()
	{
		return this.NDwid;
	}

	public void setNDwid(Integer NDwid)
	{
		this.NDwid = NDwid;
	}

	@Column(name = "C_IP", length = 20)
	public String getCIp()
	{
		return this.CIp;
	}

	public void setCIp(String CIp)
	{
		this.CIp = CIp;
	}

	@Column(name = "D_CZSJ")
	public Date getDCzsj()
	{
		return DCzsj;
	}

	public void setDCzsj(Date dCzsj)
	{
		DCzsj = dCzsj;
	}

	@Column(name = "C_CZNR", length = 1000)
	public String getCCznr()
	{
		return this.CCznr;
	}

	public void setCCznr(String CCznr)
	{
		this.CCznr = CCznr;
	}

}
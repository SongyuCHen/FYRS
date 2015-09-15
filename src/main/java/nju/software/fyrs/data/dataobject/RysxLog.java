package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RysxLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYWH_LOG")
public class RysxLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2953752704215108100L;
	private BigDecimal NId;
	private String CCzyh;
	private Integer NDwid;
	private String CIp;
	private String DCzsj;
	private String CCznr;

	// Constructors

	/** default constructor */
	public RysxLog()
	{
	}

	/** minimal constructor */
	public RysxLog(BigDecimal NId, String CCzyh)
	{
		this.NId = NId;
		this.CCzyh = CCzyh;
	}

	/** full constructor */
	public RysxLog(BigDecimal NId, String CCzyh, Integer NDwid, String CIp, String DCzsj, String CCznr)
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
	public String getDCzsj()
	{
		return this.DCzsj;
	}

	public void setDCzsj(String DCzsj)
	{
		this.DCzsj = DCzsj;
	}

	@Column(name = "C_CZNR")
	public String getCCznr()
	{
		return this.CCznr;
	}

	public void setCCznr(String CCznr)
	{
		this.CCznr = CCznr;
	}

}
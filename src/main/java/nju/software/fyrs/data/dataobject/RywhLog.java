package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RywhLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYWH_LOG")
public class RywhLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947255484527067484L;
	private BigDecimal NId;  
	private String CCzyh;
	private Integer NDwid;
	private String CIp;
	private Date DCzsj;
	private String CCznr;
	private Integer NUsqltype;
	private byte[] imUsql;

	// Constructors

	/** default constructor */
	public RywhLog()
	{
	}

	/** minimal constructor */
	public RywhLog(BigDecimal NId, String CCzyh)
	{
		this.NId = NId;
		this.CCzyh = CCzyh;
	}

	/** full constructor */
	public RywhLog(BigDecimal NId, String CCzyh, Integer NDwid, String CIp, Date DCzsj, String CCznr, Integer NUsqltype, byte[] imUsql)
	{
		this.NId = NId;
		this.CCzyh = CCzyh;
		this.NDwid = NDwid;
		this.CIp = CIp;
		this.DCzsj = DCzsj;
		this.CCznr = CCznr;
		this.NUsqltype = NUsqltype;
		this.imUsql = imUsql;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false, precision = 21, scale = 0)
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

	@Column(name = "N_USQLTYPE")
	public Integer getNUsqltype()
	{
		return this.NUsqltype;
	}

	public void setNUsqltype(Integer NUsqltype)
	{
		this.NUsqltype = NUsqltype;
	}

	@Column(name = "IM_USQL")
	public byte[] getImUsql()
	{
		return this.imUsql;
	}

	public void setImUsql(byte[] imUsql)
	{
		this.imUsql = imUsql;
	}

}
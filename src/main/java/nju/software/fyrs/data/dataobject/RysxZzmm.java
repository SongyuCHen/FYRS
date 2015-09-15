package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxZzmm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_ZZMM")
@IdClass(RysxZzmmId.class)
public class RysxZzmm implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5226020621871955535L;
	// Fields
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NZzmm;
	private Date DJrrq;
	private Date DZzrq;
	private Short NDqxx;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxZzmm()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nZzmm
	 * @param dJrrq
	 * @param dZzrq
	 * @param nDqxx
	 * @param nXssx
	 */
	public RysxZzmm(BigDecimal nId, Integer nFy, Integer nRybh, Integer nZzmm, Date dJrrq, Date dZzrq, Short nDqxx, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NZzmm = nZzmm;
		DJrrq = dJrrq;
		DZzrq = dZzrq;
		NDqxx = nDqxx;
		NXssx = nXssx;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", nullable = false, scale = 0)
	public BigDecimal getNId()
	{
		return this.NId;
	}

	public void setNId(BigDecimal string)
	{
		this.NId = string;
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

	@Column(name = "N_ZZMM")
	public Integer getNZzmm()
	{
		return this.NZzmm;
	}

	public void setNZzmm(Integer NZzmm)
	{
		this.NZzmm = NZzmm;
	}

	@Column(name = "D_JRRQ", length = 23)
	public Date getDJrrq()
	{
		return DJrrq;
	}

	public void setDJrrq(Date dJrrq)
	{
		DJrrq = dJrrq;
	}

	@Column(name = "D_ZZRQ", length = 23)
	public Date getDZzrq()
	{
		return DZzrq;
	}

	public void setDZzrq(Date dZzrq)
	{
		DZzrq = dZzrq;
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
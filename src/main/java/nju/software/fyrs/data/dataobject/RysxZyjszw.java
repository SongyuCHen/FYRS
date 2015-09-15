package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxZyjszw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_ZYJSZW")
@IdClass(RysxZyjszwId.class)
public class RysxZyjszw implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 467842350852381718L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NQdmc;
	private Integer NQdtj;
	private Date DQdrq;
	private Integer NPrmc;
	private Date DPrrq;
	private Integer NZcdj;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxZyjszw()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nQdmc
	 * @param nQdtj
	 * @param dQdrq
	 * @param nPrmc
	 * @param dPrrq
	 * @param nZcdj
	 * @param nXssx
	 */
	public RysxZyjszw(BigDecimal nId, Integer nFy, Integer nRybh, Integer nQdmc, Integer nQdtj, Date dQdrq, Integer nPrmc, Date dPrrq, Integer nZcdj, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NQdmc = nQdmc;
		NQdtj = nQdtj;
		DQdrq = dQdrq;
		NPrmc = nPrmc;
		DPrrq = dPrrq;
		NZcdj = nZcdj;
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

	@Column(name = "N_QDMC")
	public Integer getNQdmc()
	{
		return this.NQdmc;
	}

	public void setNQdmc(Integer NQdmc)
	{
		this.NQdmc = NQdmc;
	}

	@Column(name = "N_QDTJ")
	public Integer getNQdtj()
	{
		return this.NQdtj;
	}

	public void setNQdtj(Integer NQdtj)
	{
		this.NQdtj = NQdtj;
	}

	@Column(name = "D_QDRQ", length = 23)
	public Date getDQdrq()
	{
		return this.DQdrq;
	}

	public void setDQdrq(Date DQdrq)
	{
		this.DQdrq = DQdrq;
	}

	@Column(name = "N_PRMC")
	public Integer getNPrmc()
	{
		return this.NPrmc;
	}

	public void setNPrmc(Integer NPrmc)
	{
		this.NPrmc = NPrmc;
	}

	@Column(name = "D_PRRQ", length = 23)
	public Date getDPrrq()
	{
		return this.DPrrq;
	}

	public void setDPrrq(Date DPrrq)
	{
		this.DPrrq = DPrrq;
	}

	@Column(name = "N_ZCDJ")
	public Integer getNZcdj()
	{
		return this.NZcdj;
	}

	public void setNZcdj(Integer NZcdj)
	{
		this.NZcdj = NZcdj;
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
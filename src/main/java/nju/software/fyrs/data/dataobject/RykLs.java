package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RykLs entity. @author MyEclipse Persistence Tools ¿˙ ∑ø‚DO
 */
@Entity
@Table(name = "T_RYK_LS")
public class RykLs implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1922626422357470992L;
	private Integer NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NBm;
	private Integer NLslx;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RykLs()
	{
	}

	/** minimal constructor */
	public RykLs(Integer NId, Integer NFy, Integer NRybh)
	{
		this.NId = NId;
		this.NFy = NFy;
		this.NRybh = NRybh;
	}

	/** full constructor */
	public RykLs(Integer NId, Integer NFy, Integer NRybh, Integer NBm, Integer NLslx, Integer NXssx)
	{
		this.NId = NId;
		this.NFy = NFy;
		this.NRybh = NRybh;
		this.NBm = NBm;
		this.NLslx = NLslx;
		this.NXssx = NXssx;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false)
	public Integer getNId()
	{
		return this.NId;
	}

	public void setNId(Integer NId)
	{
		this.NId = NId;
	}

	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Column(name = "N_RYBH", nullable = false)
	public Integer getNRybh()
	{
		return this.NRybh;
	}

	public void setNRybh(Integer NRybh)
	{
		this.NRybh = NRybh;
	}

	@Column(name = "N_BM")
	public Integer getNBm()
	{
		return this.NBm;
	}

	public void setNBm(Integer NBm)
	{
		this.NBm = NBm;
	}

	@Column(name = "N_LSLX")
	public Integer getNLslx()
	{
		return this.NLslx;
	}

	public void setNLslx(Integer NLslx)
	{
		this.NLslx = NLslx;
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
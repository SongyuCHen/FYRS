package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxKhxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_KHXX")
@IdClass(RysxKhxxId.class)
public class RysxKhxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212051306003635104L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NNd;
	private Integer NKhjg;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxKhxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nNd
	 * @param nKhjg
	 * @param nXssx
	 */
	public RysxKhxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nNd, Integer nKhjg, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NNd = nNd;
		NKhjg = nKhjg;
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

	@Column(name = "N_ND")
	public Integer getNNd()
	{
		return this.NNd;
	}

	public void setNNd(Integer NNd)
	{
		this.NNd = NNd;
	}

	@Column(name = "N_KHJG")
	public Integer getNKhjg()
	{
		return this.NKhjg;
	}

	public void setNKhjg(Integer NKhjg)
	{
		this.NKhjg = NKhjg;
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
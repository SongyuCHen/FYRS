package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxCgxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_CGXX")
@IdClass(RysxCgxxId.class)
public class RysxCgxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 838644283090635440L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NGb;
	private Integer NCgxz;
	private Date DKssj;
	private Date DJssj;
	private Integer NCgsf;
	private String CJfly;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxCgxx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nGb
	 * @param nCgxz
	 * @param dKssj
	 * @param dJssj
	 * @param nCgsf
	 * @param cJfly
	 * @param nXssx
	 */
	public RysxCgxx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nGb, Integer nCgxz, Date dKssj, Date dJssj, Integer nCgsf, String cJfly, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NGb = nGb;
		NCgxz = nCgxz;
		DKssj = dKssj;
		DJssj = dJssj;
		NCgsf = nCgsf;
		CJfly = cJfly;
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

	@Column(name = "N_GB")
	public Integer getNGb()
	{
		return this.NGb;
	}

	public void setNGb(Integer NGb)
	{
		this.NGb = NGb;
	}

	@Column(name = "N_CGXZ")
	public Integer getNCgxz()
	{
		return this.NCgxz;
	}

	public void setNCgxz(Integer NCgxz)
	{
		this.NCgxz = NCgxz;
	}

	@Column(name = "D_KSSJ", length = 23)
	public Date getDKssj()
	{
		return this.DKssj;
	}

	public void setDKssj(Date DKssj)
	{
		this.DKssj = DKssj;
	}

	@Column(name = "D_JSSJ", length = 23)
	public Date getDJssj()
	{
		return this.DJssj;
	}

	public void setDJssj(Date DJssj)
	{
		this.DJssj = DJssj;
	}

	@Column(name = "N_CGSF")
	public Integer getNCgsf()
	{
		return this.NCgsf;
	}

	public void setNCgsf(Integer NCgsf)
	{
		this.NCgsf = NCgsf;
	}

	@Column(name = "C_JFLY", length = 50)
	public String getCJfly()
	{
		return this.CJfly;
	}

	public void setCJfly(String CJfly)
	{
		this.CJfly = CJfly;
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
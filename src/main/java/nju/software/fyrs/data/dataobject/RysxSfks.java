package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxSfks entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_SFKS")
@IdClass(RysxSfksId.class)
public class RysxSfks implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1442307032553258865L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NZslx;
	private Date DBzrq;
	private String CZsbh;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxSfks()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nZslx
	 * @param dBzrq
	 * @param cZsbh
	 * @param nXssx
	 */
	public RysxSfks(BigDecimal nId, Integer nFy, Integer nRybh, Integer nZslx, Date dBzrq, String cZsbh, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NZslx = nZslx;
		DBzrq = dBzrq;
		CZsbh = cZsbh;
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

	@Column(name = "N_ZSLX")
	public Integer getNZslx()
	{
		return this.NZslx;
	}

	public void setNZslx(Integer NZslx)
	{
		this.NZslx = NZslx;
	}

	@Column(name = "D_BZRQ", length = 23)
	public Date getDBzrq()
	{
		return this.DBzrq;
	}

	public void setDBzrq(Date DBzrq)
	{
		this.DBzrq = DBzrq;
	}

	@Column(name = "C_ZSBH", length = 50)
	public String getCZsbh()
	{
		return this.CZsbh;
	}

	public void setCZsbh(String CZsbh)
	{
		this.CZsbh = CZsbh;
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
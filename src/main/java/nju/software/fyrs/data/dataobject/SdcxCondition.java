package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SdcxCondition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SDCX_CONDITION")
public class SdcxCondition implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694959722495613847L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String TConditon;
	private Integer NRyk;
	private Date DBcsj;
	private String CTjmc;

	// Constructors

	/** default constructor */
	public SdcxCondition()
	{
	}

	/** full constructor */
	public SdcxCondition(BigDecimal NId, Integer NFy, Integer NRybh, String TConditon, Integer NRyk, Date DBcsj, String CTjmc)
	{
		this.NId = NId;
		this.NFy = NFy;
		this.NRybh = NRybh;
		this.TConditon = TConditon;
		this.NRyk = NRyk;
		this.DBcsj = DBcsj;
		this.CTjmc = CTjmc;
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

	@Column(name = "T_CONDITON", nullable = false)
	public String getTConditon()
	{
		return this.TConditon;
	}

	public void setTConditon(String TConditon)
	{
		this.TConditon = TConditon;
	}

	@Column(name = "N_RYK", nullable = false)
	public Integer getNRyk()
	{
		return this.NRyk;
	}

	public void setNRyk(Integer NRyk)
	{
		this.NRyk = NRyk;
	}

	@Column(name = "D_BCSJ", nullable = false, length = 23)
	public Date getDBcsj()
	{
		return this.DBcsj;
	}

	public void setDBcsj(Date DBcsj)
	{
		this.DBcsj = DBcsj;
	}

	@Column(name = "C_TJMC", nullable = false, length = 50)
	public String getCTjmc()
	{
		return this.CTjmc;
	}

	public void setCTjmc(String CTjmc)
	{
		this.CTjmc = CTjmc;
	}

}
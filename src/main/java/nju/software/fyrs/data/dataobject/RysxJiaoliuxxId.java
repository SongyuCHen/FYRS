package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RysxJialliuxxId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class RysxJiaoliuxxId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4090840227802647759L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;

	// Constructors

	/** default constructor */
	public RysxJiaoliuxxId()
	{
	}

	/** full constructor */
	public RysxJiaoliuxxId(BigDecimal NId, Integer NFy, Integer NRybh)
	{
		this.NId = NId;
		this.NFy = NFy;
		this.NRybh = NRybh;
	}

	// Property accessors

	@Column(name = "N_ID", nullable = false, scale = 0)
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

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RysxJiaoliuxxId))
			return false;
		RysxJiaoliuxxId castOther = (RysxJiaoliuxxId) other;

		return ((this.getNId() == castOther.getNId()) || (this.getNId() != null && castOther.getNId() != null && this.getNId().equals(castOther.getNId())))
				&& ((this.getNFy() == castOther.getNFy()) || (this.getNFy() != null && castOther.getNFy() != null && this.getNFy().equals(castOther.getNFy())))
				&& ((this.getNRybh() == castOther.getNRybh()) || (this.getNRybh() != null && castOther.getNRybh() != null && this.getNRybh().equals(castOther.getNRybh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getNId() == null ? 0 : this.getNId().hashCode());
		result = 37 * result + (getNFy() == null ? 0 : this.getNFy().hashCode());
		result = 37 * result + (getNRybh() == null ? 0 : this.getNRybh().hashCode());
		return result;
	}

}
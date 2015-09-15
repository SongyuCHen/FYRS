package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;

/**
 * RysxPhotoId entity. @author MyEclipse Persistence Tools
 */

public class RysxPhotoId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6414188522751539662L;
	private Integer NFy;
	private Integer NRybh;

	// Constructors

	/** default constructor */
	public RysxPhotoId()
	{
	}

	/** full constructor */
	public RysxPhotoId(Integer NFy, Integer NRybh)
	{
		this.NFy = NFy;
		this.NRybh = NRybh;
	}

	// Property accessors

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
		if (!(other instanceof RysxPhotoId))
			return false;
		RysxPhotoId castOther = (RysxPhotoId) other;

		return ((this.getNFy() == castOther.getNFy()) || (this.getNFy() != null && castOther.getNFy() != null && this.getNFy().equals(castOther.getNFy())))
				&& ((this.getNRybh() == castOther.getNRybh()) || (this.getNRybh() != null && castOther.getNRybh() != null && this.getNRybh().equals(castOther.getNRybh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getNFy() == null ? 0 : this.getNFy().hashCode());
		result = 37 * result + (getNRybh() == null ? 0 : this.getNRybh().hashCode());
		return result;
	}

}
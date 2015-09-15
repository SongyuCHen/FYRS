package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DmId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DmId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3927177078487009116L;
	private Integer NDm;
	private Short NBxh;

	// Constructors

	/** default constructor */
	public DmId()
	{
	}

	/** full constructor */
	public DmId(Integer NDm, Short NBxh)
	{
		this.NDm = NDm;
		this.NBxh = NBxh;
	}

	// Property accessors

	@Column(name = "N_DM", nullable = false)
	public Integer getNDm()
	{
		return this.NDm;
	}

	public void setNDm(Integer NDm)
	{
		this.NDm = NDm;
	}

	@Column(name = "N_BXH", nullable = false)
	public Short getNBxh()
	{
		return this.NBxh;
	}

	public void setNBxh(Short NBxh)
	{
		this.NBxh = NBxh;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DmId))
			return false;
		DmId castOther = (DmId) other;

		return ((this.getNDm() == castOther.getNDm()) || (this.getNDm() != null && castOther.getNDm() != null && this.getNDm().equals(castOther.getNDm())))
				&& ((this.getNBxh() == castOther.getNBxh()) || (this.getNBxh() != null && castOther.getNBxh() != null && this.getNBxh().equals(castOther.getNBxh())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getNDm() == null ? 0 : this.getNDm().hashCode());
		result = 37 * result + (getNBxh() == null ? 0 : this.getNBxh().hashCode());
		return result;
	}

}
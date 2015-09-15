package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;

public class JgxxId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260856556863636986L;
	private Integer NFy;
	private Integer NCode;

	// Constructors

	/** default constructor */
	public JgxxId()
	{
	}

	/** full constructor */
	public JgxxId(Integer NFy, Integer NCode)
	{
		this.NFy = NFy;
		this.NCode = NCode;
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

	@Column(name = "N_CODE", nullable = false)
	public Integer getNCode()
	{
		return this.NCode;
	}

	public void setNCode(Integer NCode)
	{
		this.NCode = NCode;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JgxxId))
			return false;
		JgxxId castOther = (JgxxId) other;

		return ((this.getNFy() == castOther.getNFy()) || (this.getNFy() != null && castOther.getNFy() != null && this.getNFy().equals(castOther.getNFy())))
				&& ((this.getNCode() == castOther.getNCode()) || (this.getNCode() != null && castOther.getNCode() != null && this.getNCode().equals(castOther.getNCode())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getNFy() == null ? 0 : this.getNFy().hashCode());
		result = 37 * result + (getNCode() == null ? 0 : this.getNCode().hashCode());
		return result;
	}

}
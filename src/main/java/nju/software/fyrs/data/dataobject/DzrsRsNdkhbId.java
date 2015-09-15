package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DzrsRsNdkhbId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DzrsRsNdkhbId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6512846994232515748L;
	private String jbxxjCode;
	private Integer nd;

	// Constructors

	/** default constructor */
	public DzrsRsNdkhbId()
	{
	}

	/** full constructor */
	public DzrsRsNdkhbId(String jbxxjCode, Integer nd)
	{
		this.jbxxjCode = jbxxjCode;
		this.nd = nd;
	}

	// Property accessors

	@Column(name = "JBXXJ_CODE", nullable = false, length = 30)
	public String getJbxxjCode()
	{
		return this.jbxxjCode;
	}

	public void setJbxxjCode(String jbxxjCode)
	{
		this.jbxxjCode = jbxxjCode;
	}

	@Column(name = "ND", nullable = false)
	public Integer getNd()
	{
		return this.nd;
	}

	public void setNd(Integer nd)
	{
		this.nd = nd;
	}

	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DzrsRsNdkhbId))
			return false;
		DzrsRsNdkhbId castOther = (DzrsRsNdkhbId) other;

		return ((this.getJbxxjCode() == castOther.getJbxxjCode()) || (this.getJbxxjCode() != null && castOther.getJbxxjCode() != null && this.getJbxxjCode().equals(castOther.getJbxxjCode())))
				&& ((this.getNd() == castOther.getNd()) || (this.getNd() != null && castOther.getNd() != null && this.getNd().equals(castOther.getNd())));
	}

	public int hashCode()
	{
		int result = 17;

		result = 37 * result + (getJbxxjCode() == null ? 0 : this.getJbxxjCode().hashCode());
		result = 37 * result + (getNd() == null ? 0 : this.getNd().hashCode());
		return result;
	}

}
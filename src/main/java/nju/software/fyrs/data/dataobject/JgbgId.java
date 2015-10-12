package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class JgbgId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5260856556863636986L;
	private Integer NFy;
	private BigDecimal NId;

	// Constructors

	/** default constructor */
	public JgbgId()
	{
	}

	/** full constructor */
	private JgbgId(Integer nFy, BigDecimal nId) {
		NFy = nFy;
		NId = nId;
	}


	// Property accessors

	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	/**
	 * @param nFy
	 * @param nId
	 */

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Column(name = "N_ID", nullable = false)
	public BigDecimal getNId() {
		return NId;
	}

	public void setNId(BigDecimal nId) {
		NId = nId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NFy == null) ? 0 : NFy.hashCode());
		result = prime * result + ((NId == null) ? 0 : NId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JgbgId other = (JgbgId) obj;
		if (NFy == null) {
			if (other.NFy != null)
				return false;
		} else if (!NFy.equals(other.NFy))
			return false;
		if (NId == null) {
			if (other.NId != null)
				return false;
		} else if (!NId.equals(other.NId))
			return false;
		return true;
	}


	

}
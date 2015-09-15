package nju.software.fyrs.data.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class YyglZhaoluId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3885771116813985808L;
	private BigDecimal NId;
	private Integer NFy;
	public YyglZhaoluId(){
		
	}
	/**
	 * @param nId
	 * @param nFy
	 */
	public YyglZhaoluId(BigDecimal nId, Integer nFy) {

		NId = nId;
		NFy = nFy;
	}
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
		YyglZhaoluId other = (YyglZhaoluId) obj;
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

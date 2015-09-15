package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;

/**
 * JlwhId entity. @author MyEclipse Persistence Tools
 */
public class JlwhId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8555980005301181629L;
	private BigDecimal NId;
	private Integer NFy;

	// Constructors

	/** default constructor */
	public JlwhId()
	{
	}

	public JlwhId(BigDecimal nId, Integer nFy)
	{
		super();
		NId = nId;
		NFy = nFy;
	}

	@Column(name = "n_id", nullable = false, precision = 17, scale = 0)
	public BigDecimal getNId()
	{
		return NId;
	}

	public void setNId(BigDecimal nId)
	{
		NId = nId;
	}

	@Column(name = "n_fy", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NFy == null) ? 0 : NFy.hashCode());
		result = prime * result + ((NId == null) ? 0 : NId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JlwhId other = (JlwhId) obj;
		if (NFy == null)
		{
			if (other.NFy != null)
				return false;
		} else if (!NFy.equals(other.NFy))
			return false;
		if (NId == null)
		{
			if (other.NId != null)
				return false;
		} else if (!NId.equals(other.NId))
			return false;
		return true;
	}

}
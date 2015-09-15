package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;

public class Pub_DmbDOId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2818677737830175230L;
	// Fields
	private String lbbh;
	private String dmbh;

	// Constructors

	/** default constructor */
	public Pub_DmbDOId()
	{
	}

	/** minimal constructor */
	public Pub_DmbDOId(String lbbh, String dmbh)
	{
		this.lbbh = lbbh;
		this.dmbh = dmbh;
	}

	/** full constructor */
	public Pub_DmbDOId(String lbbh, String dmbh, String dmms, String xgdm, String bz, String modflag, String transflag)
	{
		this.lbbh = lbbh;
		this.dmbh = dmbh;
	}

	@Column(name = "LBBH", unique = true, nullable = false, length = 20)
	public String getLbbh()
	{
		return this.lbbh;
	}

	public void setLbbh(String lbbh)
	{
		this.lbbh = lbbh;
	}

	@Column(name = "DMBH", unique = true, nullable = false, length = 20)
	public String getDmbh()
	{
		return this.dmbh;
	}

	public void setDmbh(String dmbh)
	{
		this.dmbh = dmbh;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dmbh == null) ? 0 : dmbh.hashCode());
		result = prime * result + ((lbbh == null) ? 0 : lbbh.hashCode());
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
		Pub_DmbDOId other = (Pub_DmbDOId) obj;
		if (dmbh == null)
		{
			if (other.dmbh != null)
				return false;
		} else if (!dmbh.equals(other.dmbh))
			return false;
		if (lbbh == null)
		{
			if (other.lbbh != null)
				return false;
		} else if (!lbbh.equals(other.lbbh))
			return false;
		return true;
	}

}

package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * DzrsRsNdkhb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DZRS_RS_NDKHB")
@IdClass(DzrsRsNdkhbId.class)
public class DzrsRsNdkhb implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8288008089128388249L;
	// Fields
	private String jbxxjCode;
	private Integer nd;
	private String jieg;

	// Constructors

	/** default constructor */
	public DzrsRsNdkhb()
	{
	}

	/** full constructor */
	public DzrsRsNdkhb(String jbxxjCode, Integer nd, String jieg)
	{
		super();
		this.jbxxjCode = jbxxjCode;
		this.nd = nd;
		this.jieg = jieg;
	}

	@Column(name = "JIEG", length = 1)
	public String getJieg()
	{
		return this.jieg;
	}

	public void setJieg(String jieg)
	{
		this.jieg = jieg;
	}

	@Id
	@Column(name = "JBXXJ_CODE", nullable = false, length = 30)
	public String getJbxxjCode()
	{
		return this.jbxxjCode;
	}

	public void setJbxxjCode(String jbxxjCode)
	{
		this.jbxxjCode = jbxxjCode;
	}

	@Id
	@Column(name = "ND", nullable = false)
	public Integer getNd()
	{
		return this.nd;
	}

	public void setNd(Integer nd)
	{
		this.nd = nd;
	}
}
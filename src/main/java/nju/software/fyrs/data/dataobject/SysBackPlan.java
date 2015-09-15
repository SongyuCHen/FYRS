package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysBackPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SYSBACKPLAN")
public class SysBackPlan implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2216191201628592122L;
	private long NId;
	private short NFrequency;
	private short NBlfs;

	// Constructors

	/** default constructor */
	public SysBackPlan()
	{
	}

	/** full constructor */
	public SysBackPlan(long NId, short NFrequency, short NBlfs)
	{
		this.NId = NId;
		this.NFrequency = NFrequency;
		this.NBlfs = NBlfs;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false, precision = 17, scale = 0)
	public long getNId()
	{
		return this.NId;
	}

	public void setNId(long NId)
	{
		this.NId = NId;
	}

	@Column(name = "N_FREQUENCY", nullable = false)
	public short getNFrequency()
	{
		return this.NFrequency;
	}

	public void setNFrequency(short NFrequency)
	{
		this.NFrequency = NFrequency;
	}

	@Column(name = "N_BLFS", nullable = false)
	public short getNBlfs()
	{
		return this.NBlfs;
	}

	public void setNBlfs(short NBlfs)
	{
		this.NBlfs = NBlfs;
	}

}
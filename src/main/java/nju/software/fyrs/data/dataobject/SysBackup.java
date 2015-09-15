package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysBackup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SYSBACKUP")
public class SysBackup implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2820906662184390308L;
	private BigDecimal NId;
	private short NBacktype;
	private Date DBacktime;
	private String CFilename;
	private String CPath;

	// Constructors

	/** default constructor */
	public SysBackup()
	{
	}

	/** full constructor */
	public SysBackup(BigDecimal NId, short NBacktype, Date DBacktime,
			String CFilename, String CPath)
	{
		this.NId = NId;
		this.NBacktype = NBacktype;
		this.DBacktime = DBacktime;
		this.CFilename = CFilename;
		this.CPath = CPath;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false, precision = 17, scale = 0)
	public BigDecimal getNId()
	{
		return this.NId;
	}

	public void setNId(BigDecimal NId)
	{
		this.NId = NId;
	}

	@Column(name = "N_BACKTYPE", nullable = false)
	public short getNBacktype()
	{
		return this.NBacktype;
	}

	public void setNBacktype(short NBacktype)
	{
		this.NBacktype = NBacktype;
	}

	@Column(name = "D_BACKTIME", nullable = false, length = 23)
	public Date getDBacktime()
	{
		return this.DBacktime;
	}

	public void setDBacktime(Date DBacktime)
	{
		this.DBacktime = DBacktime;
	}

	@Column(name = "C_FILENAME", nullable = false)
	public String getCFilename()
	{
		return this.CFilename;
	}

	public void setCFilename(String CFilename)
	{
		this.CFilename = CFilename;
	}

	@Column(name = "C_PATH", nullable = false)
	public String getCPath()
	{
		return this.CPath;
	}

	public void setCPath(String CPath)
	{
		this.CPath = CPath;
	}

}
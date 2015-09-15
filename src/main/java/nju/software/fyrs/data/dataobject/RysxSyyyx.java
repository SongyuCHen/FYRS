package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxSyyyx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_SYYYX")
@IdClass(RysxSyyyxId.class)
public class RysxSyyyx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1576460789816664331L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CFilename;
	private String CPath;
	private String CMs;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxSyyyx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cFilename
	 * @param cPath
	 * @param cMs
	 * @param nXssx
	 */
	public RysxSyyyx(BigDecimal nId, Integer nFy, Integer nRybh, String cFilename, String cPath, String cMs, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CFilename = cFilename;
		CPath = cPath;
		CMs = cMs;
		NXssx = nXssx;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", nullable = false, scale = 0)
	public BigDecimal getNId()
	{
		return this.NId;
	}

	public void setNId(BigDecimal NId)
	{
		this.NId = NId;
	}

	@Id
	@Column(name = "N_FY", nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Id
	@Column(name = "N_RYBH", nullable = false)
	public Integer getNRybh()
	{
		return this.NRybh;
	}

	public void setNRybh(Integer NRybh)
	{
		this.NRybh = NRybh;
	}

	@Column(name = "C_FILENAME", length = 150)
	public String getCFilename()
	{
		return this.CFilename;
	}

	public void setCFilename(String CFilename)
	{
		this.CFilename = CFilename;
	}

	@Column(name = "C_PATH")
	public String getCPath()
	{
		return this.CPath;
	}

	public void setCPath(String CPath)
	{
		this.CPath = CPath;
	}

	@Column(name = "C_MS", length = 150)
	public String getCMs()
	{
		return this.CMs;
	}

	public void setCMs(String CMs)
	{
		this.CMs = CMs;
	}

	@Column(name = "N_XSSX")
	public Integer getNXssx()
	{
		return this.NXssx;
	}

	public void setNXssx(Integer NXssx)
	{
		this.NXssx = NXssx;
	}

}
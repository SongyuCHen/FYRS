package nju.software.fyrs.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Jgxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_JGXX")
@IdClass(JgxxId.class)
public class Jgxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466567180546739248L;
	private Integer NFy;
	private Integer NCode;
	private Integer NUnicode;
	private Short NLevel;
	private String CName;
	private String CStname;
	private String CLvlcode;
	private Integer NZgldzw;
	private Integer NRysl;
	private Integer NYx;
	private Short NSfxs;
	private Short NXssx;
	private Integer NRyxz;
	private Integer NBmxz;

	// Constructors

	/** default constructor */
	public Jgxx()
	{
	}

	/** full constructor */
	public Jgxx(Integer NFy, Integer NCode, Integer NUnicode, Short NLevel, String CName, String CStname, String CLvlcode, Integer NZgldzw, Integer NRysl, Integer NYx, Short NSfxs, Short NXssx,
			Integer NRyxz, Integer NBmxz)
	{
		this.NFy = NFy;
		this.NCode = NCode;
		this.NUnicode = NUnicode;
		this.NLevel = NLevel;
		this.CName = CName;
		this.CStname = CStname;
		this.CLvlcode = CLvlcode;
		this.NZgldzw = NZgldzw;
		this.NRysl = NRysl;
		this.NYx = NYx;
		this.NSfxs = NSfxs;
		this.NXssx = NXssx;
		this.NRyxz = NRyxz;
		this.NBmxz = NBmxz;
	}

	@Column(name = "N_UNICODE")
	public Integer getNUnicode()
	{
		return this.NUnicode;
	}

	public void setNUnicode(Integer NUnicode)
	{
		this.NUnicode = NUnicode;
	}

	@Column(name = "N_LEVEL")
	public Short getNLevel()
	{
		return this.NLevel;
	}

	public void setNLevel(Short NLevel)
	{
		this.NLevel = NLevel;
	}

	@Column(name = "C_NAME", length = 50)
	public String getCName()
	{
		return this.CName;
	}

	public void setCName(String CName)
	{
		this.CName = CName;
	}

	@Column(name = "C_STNAME", length = 50)
	public String getCStname()
	{
		return this.CStname;
	}

	public void setCStname(String CStname)
	{
		this.CStname = CStname;
	}

	@Column(name = "C_LVLCODE", length = 12)
	public String getCLvlcode()
	{
		return this.CLvlcode;
	}

	public void setCLvlcode(String CLvlcode)
	{
		this.CLvlcode = CLvlcode;
	}

	@Column(name = "N_ZGLDZW")
	public Integer getNZgldzw()
	{
		return this.NZgldzw;
	}

	public void setNZgldzw(Integer NZgldzw)
	{
		this.NZgldzw = NZgldzw;
	}

	@Column(name = "N_RYSL")
	public Integer getNRysl()
	{
		return this.NRysl;
	}

	public void setNRysl(Integer NRysl)
	{
		this.NRysl = NRysl;
	}

	@Column(name = "N_YX")
	public Integer getNYx()
	{
		return this.NYx;
	}

	public void setNYx(Integer NYx)
	{
		this.NYx = NYx;
	}

	@Column(name = "N_SFXS")
	public Short getNSfxs()
	{
		return this.NSfxs;
	}

	public void setNSfxs(Short NSfxs)
	{
		this.NSfxs = NSfxs;
	}

	@Column(name = "N_XSSX")
	public Short getNXssx()
	{
		return this.NXssx;
	}

	public void setNXssx(Short NXssx)
	{
		this.NXssx = NXssx;
	}

	@Column(name = "N_RYXZ")
	public Integer getNRyxz()
	{
		return this.NRyxz;
	}

	public void setNRyxz(Integer NRyxz)
	{
		this.NRyxz = NRyxz;
	}

	@Column(name = "N_BMXZ")
	public Integer getNBmxz()
	{
		return this.NBmxz;
	}

	public void setNBmxz(Integer NBmxz)
	{
		this.NBmxz = NBmxz;
	}

	@Id
	@Column(name = "N_Fy")
	public Integer getNFy()
	{
		return NFy;
	}

	public void setNFy(Integer nFy)
	{
		NFy = nFy;
	}

	@Id
	@Column(name = "N_Code")
	public Integer getNCode()
	{
		return NCode;
	}

	public void setNCode(Integer nCode)
	{
		NCode = nCode;
	}

}
package nju.software.fyrs.data.dataobject;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GdtjTjbtj entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_GDTJ_TJBTJ")
public class GdtjTjbtj implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6917801409269331459L;
	private Integer NTjbh;
	private Integer NBbh;
	private Integer NWz;
	private Integer NXh;
	private Integer NSpecial;
	private String CTjm;
	private String CJjhs;
	private String CTable;
	private String CWhere;

	// Constructors

	/** default constructor */
	public GdtjTjbtj()
	{
	}

	/** minimal constructor */
	public GdtjTjbtj(Integer NTjbh)
	{
		this.NTjbh = NTjbh;
	}

	/** full constructor */
	public GdtjTjbtj(Integer NTjbh, Integer NBbh, Integer NWz, Integer NXh, Integer NSpecial, String CTjm, String CJjhs, String CTable, String CWhere)
	{
		this.NTjbh = NTjbh;
		this.NBbh = NBbh;
		this.NWz = NWz;
		this.NXh = NXh;
		this.NSpecial = NSpecial;
		this.CTjm = CTjm;
		this.CJjhs = CJjhs;
		this.CTable = CTable;
		this.CWhere = CWhere;
	}

	// Property accessors
	@Id
	@Column(name = "N_TJBH", unique = true, nullable = false)
	public Integer getNTjbh()
	{
		return this.NTjbh;
	}

	public void setNTjbh(Integer NTjbh)
	{
		this.NTjbh = NTjbh;
	}

	@Column(name = "N_BBH")
	public Integer getNBbh()
	{
		return this.NBbh;
	}

	public void setNBbh(Integer NBbh)
	{
		this.NBbh = NBbh;
	}

	@Column(name = "N_WZ")
	public Integer getNWz()
	{
		return this.NWz;
	}

	public void setNWz(Integer NWz)
	{
		this.NWz = NWz;
	}

	@Column(name = "N_XH")
	public Integer getNXh()
	{
		return this.NXh;
	}

	public void setNXh(Integer NXh)
	{
		this.NXh = NXh;
	}

	@Column(name = "N_SPECIAL")
	public Integer getNSpecial()
	{
		return this.NSpecial;
	}

	public void setNSpecial(Integer NSpecial)
	{
		this.NSpecial = NSpecial;
	}

	@Column(name = "C_TJM", length = 128)
	public String getCTjm()
	{
		return this.CTjm;
	}

	public void setCTjm(String CTjm)
	{
		this.CTjm = CTjm;
	}

	@Column(name = "C_JJHS", length = 32)
	public String getCJjhs()
	{
		return this.CJjhs;
	}

	public void setCJjhs(String CJjhs)
	{
		this.CJjhs = CJjhs;
	}

	@Column(name = "C_TABLE", length = 32)
	public String getCTable()
	{
		return this.CTable;
	}

	public void setCTable(String CTable)
	{
		this.CTable = CTable;
	}

	@Column(name = "C_WHERE", length = 256)
	public String getCWhere()
	{
		return this.CWhere;
	}

	public void setCWhere(String CWhere)
	{
		this.CWhere = CWhere;
	}

}
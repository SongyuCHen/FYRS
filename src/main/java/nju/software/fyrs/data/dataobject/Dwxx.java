package nju.software.fyrs.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dwxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DWXX")
public class Dwxx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5600555692975901986L;
	private Integer NFy;
	private String CYzbm;
	private String CDwdz;
	private String CLldh;
	private String CDwczh;
	private String CRsfzr;
	private Date DCjsj;
	private Short NZyxzbzs;
	private Short NZysybzs;
	private Short NDfxzbzs;
	private Short NXzfsbzs;
	private Short NDfqesybzs;
	private Short NDfcesybzs;
	private Short NDfzczzsybzs;
	private Short NQybzs;
	private String CBgqk;
	private Integer NDqfy;
	private Integer NFkdq;

	// Constructors

	/** default constructor */
	public Dwxx()
	{
	}

	/** minimal constructor */
	public Dwxx(Integer NFy)
	{
		this.NFy = NFy;
	}

	/** full constructor */
	public Dwxx(Integer NFy, String CYzbm, String CDwdz, String CLldh, String CDwczh, String CRsfzr, Date DCjsj, Short NZyxzbzs, Short NZysybzs, Short NDfxzbzs, Short NXzfsbzs, Short NDfqesybzs,
			Short NDfcesybzs, Short NDfzczzsybzs, Short NQybzs, String CBgqk, Integer NDqfy, Integer NFkdq)
	{
		this.NFy = NFy;
		this.CYzbm = CYzbm;
		this.CDwdz = CDwdz;
		this.CLldh = CLldh;
		this.CDwczh = CDwczh;
		this.CRsfzr = CRsfzr;
		this.DCjsj = DCjsj;
		this.NZyxzbzs = NZyxzbzs;
		this.NZysybzs = NZysybzs;
		this.NDfxzbzs = NDfxzbzs;
		this.NXzfsbzs = NXzfsbzs;
		this.NDfqesybzs = NDfqesybzs;
		this.NDfcesybzs = NDfcesybzs;
		this.NDfzczzsybzs = NDfzczzsybzs;
		this.NQybzs = NQybzs;
		this.CBgqk = CBgqk;
		this.NDqfy = NDqfy;
		this.NFkdq = NFkdq;
	}

	// Property accessors
	@Id
	@Column(name = "N_FY", unique = true, nullable = false)
	public Integer getNFy()
	{
		return this.NFy;
	}

	public void setNFy(Integer NFy)
	{
		this.NFy = NFy;
	}

	@Column(name = "C_YZBM", length = 6)
	public String getCYzbm()
	{
		return this.CYzbm;
	}

	public void setCYzbm(String CYzbm)
	{
		this.CYzbm = CYzbm;
	}

	@Column(name = "C_DWDZ", length = 100)
	public String getCDwdz()
	{
		return this.CDwdz;
	}

	public void setCDwdz(String CDwdz)
	{
		this.CDwdz = CDwdz;
	}

	@Column(name = "C_LLDH", length = 30)
	public String getCLldh()
	{
		return this.CLldh;
	}

	public void setCLldh(String CLldh)
	{
		this.CLldh = CLldh;
	}

	@Column(name = "C_DWCZH", length = 30)
	public String getCDwczh()
	{
		return this.CDwczh;
	}

	public void setCDwczh(String CDwczh)
	{
		this.CDwczh = CDwczh;
	}

	@Column(name = "C_RSFZR", length = 40)
	public String getCRsfzr()
	{
		return this.CRsfzr;
	}

	public void setCRsfzr(String CRsfzr)
	{
		this.CRsfzr = CRsfzr;
	}

	@Column(name = "D_CJSJ")
	public Date getDCjsj()
	{
		return DCjsj;
	}

	public void setDCjsj(Date dCjsj)
	{
		DCjsj = dCjsj;
	}

	@Column(name = "N_ZYXZBZS")
	public Short getNZyxzbzs()
	{
		return this.NZyxzbzs;
	}

	public void setNZyxzbzs(Short NZyxzbzs)
	{
		this.NZyxzbzs = NZyxzbzs;
	}

	@Column(name = "N_ZYSYBZS")
	public Short getNZysybzs()
	{
		return this.NZysybzs;
	}

	public void setNZysybzs(Short NZysybzs)
	{
		this.NZysybzs = NZysybzs;
	}

	@Column(name = "N_DFXZBZS")
	public Short getNDfxzbzs()
	{
		return this.NDfxzbzs;
	}

	public void setNDfxzbzs(Short NDfxzbzs)
	{
		this.NDfxzbzs = NDfxzbzs;
	}

	@Column(name = "N_XZFSBZS")
	public Short getNXzfsbzs()
	{
		return this.NXzfsbzs;
	}

	public void setNXzfsbzs(Short NXzfsbzs)
	{
		this.NXzfsbzs = NXzfsbzs;
	}

	@Column(name = "N_DFQESYBZS")
	public Short getNDfqesybzs()
	{
		return this.NDfqesybzs;
	}

	public void setNDfqesybzs(Short NDfqesybzs)
	{
		this.NDfqesybzs = NDfqesybzs;
	}

	@Column(name = "N_DFCESYBZS")
	public Short getNDfcesybzs()
	{
		return this.NDfcesybzs;
	}

	public void setNDfcesybzs(Short NDfcesybzs)
	{
		this.NDfcesybzs = NDfcesybzs;
	}

	@Column(name = "N_DFZCZZSYBZS")
	public Short getNDfzczzsybzs()
	{
		return this.NDfzczzsybzs;
	}

	public void setNDfzczzsybzs(Short NDfzczzsybzs)
	{
		this.NDfzczzsybzs = NDfzczzsybzs;
	}

	@Column(name = "N_QYBZS")
	public Short getNQybzs()
	{
		return this.NQybzs;
	}

	public void setNQybzs(Short NQybzs)
	{
		this.NQybzs = NQybzs;
	}

	@Column(name = "C_BGQK", length = 150)
	public String getCBgqk()
	{
		return this.CBgqk;
	}

	public void setCBgqk(String CBgqk)
	{
		this.CBgqk = CBgqk;
	}

	@Column(name = "N_DQFY")
	public Integer getNDqfy()
	{
		return this.NDqfy;
	}

	public void setNDqfy(Integer NDqfy)
	{
		this.NDqfy = NDqfy;
	}

	@Column(name = "N_FKDQ")
	public Integer getNFkdq()
	{
		return this.NFkdq;
	}

	public void setNFkdq(Integer NFkdq)
	{
		this.NFkdq = NFkdq;
	}

}
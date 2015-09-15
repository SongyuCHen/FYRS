package nju.software.fyrs.data.dataobject;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wdxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_WDXX")
public class Wdxx implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -939256063522021960L;
	// Fields
	private Long NId;
	private String CFwh;
	private String CFwbt;
	private Date DFwrq;
	private String CWdms;
	private String CWdnr;

	// Constructors

	/** default constructor */
	public Wdxx()
	{
	}

	/** minimal constructor */
	public Wdxx(Long NId)
	{
		this.NId = NId;
	}

	/** full constructor */
	public Wdxx(Long NId, String CFwh, String CFwbt, Date DFwrq, String CWdms, String CWdnr)
	{
		this.NId = NId;
		this.CFwh = CFwh;
		this.CFwbt = CFwbt;
		this.DFwrq = DFwrq;
		this.CWdms = CWdms;
		this.CWdnr = CWdnr;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false, precision = 15, scale = 0)
	public Long getNId()
	{
		return this.NId;
	}

	public void setNId(Long NId)
	{
		this.NId = NId;
	}

	@Column(name = "C_FWH", length = 100)
	public String getCFwh()
	{
		return this.CFwh;
	}

	public void setCFwh(String CFwh)
	{
		this.CFwh = CFwh;
	}

	@Column(name = "C_FWBT", length = 100)
	public String getCFwbt()
	{
		return this.CFwbt;
	}

	public void setCFwbt(String CFwbt)
	{
		this.CFwbt = CFwbt;
	}

	@Column(name = "D_FWRQ", length = 23)
	public Date getDFwrq()
	{
		return this.DFwrq;
	}

	public void setDFwrq(Date DFwrq)
	{
		this.DFwrq = DFwrq;
	}

	@Column(name = "C_WDMS", length = 200)
	public String getCWdms()
	{
		return this.CWdms;
	}

	public void setCWdms(String CWdms)
	{
		this.CWdms = CWdms;
	}

	@Column(name = "C_WDNR")
	public String getCWdnr()
	{
		return this.CWdnr;
	}

	public void setCWdnr(String CWdnr)
	{
		this.CWdnr = CWdnr;
	}

}
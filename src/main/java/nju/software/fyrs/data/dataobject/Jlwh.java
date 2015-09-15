package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Jlwh entity. @author MyEclipse Persistence Tools
 */
@IdClass(JlwhId.class)
@Entity
@Table(name = "T_JLWH")
public class Jlwh implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7796606751403931337L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NQyjl;
	private Integer NJlbm;
	private Integer NJtjllb;
	private String CJlmc;
	private Integer NJlyy;
	private Integer NJljb;
	private String CPzdw;
	private String CPzwh;
	private Date DJlsj;
	private String CBz;

	// Constructors

	/** default constructor */
	public Jlwh()
	{
	}

	public Jlwh(BigDecimal nId, Integer nFy, Integer nQyjl, Integer nJlbm, Integer nJtjllb, String cJlmc, Integer nJlyy, Integer nJljb, String cPzdw, String cPzwh, Date dJlsj, String cBz)
	{
		super();
		NId = nId;
		NFy = nFy;
		NQyjl = nQyjl;
		NJlbm = nJlbm;
		NJtjllb = nJtjllb;
		CJlmc = cJlmc;
		NJlyy = nJlyy;
		NJljb = nJljb;
		CPzdw = cPzdw;
		CPzwh = cPzwh;
		DJlsj = dJlsj;
		CBz = cBz;
	}

	@Id
	public BigDecimal getNId()
	{
		return NId;
	}

	public void setNId(BigDecimal nId)
	{
		NId = nId;
	}

	@Id
	public Integer getNFy()
	{
		return NFy;
	}

	public void setNFy(Integer nFy)
	{
		NFy = nFy;
	}

	@Column(name = "n_qyjl", nullable = false)
	public Integer getNQyjl()
	{
		return this.NQyjl;
	}

	public void setNQyjl(Integer NQyjl)
	{
		this.NQyjl = NQyjl;
	}

	@Column(name = "n_jlbm", nullable = false)
	public Integer getNJlbm()
	{
		return this.NJlbm;
	}

	public void setNJlbm(Integer NJlbm)
	{
		this.NJlbm = NJlbm;
	}

	@Column(name = "n_jtjllb", nullable = false)
	public Integer getNJtjllb()
	{
		return this.NJtjllb;
	}

	public void setNJtjllb(Integer NJtjllb)
	{
		this.NJtjllb = NJtjllb;
	}

	@Column(name = "c_jlmc", nullable = false, length = 100)
	public String getCJlmc()
	{
		return this.CJlmc;
	}

	public void setCJlmc(String CJlmc)
	{
		this.CJlmc = CJlmc;
	}

	@Column(name = "n_jlyy", nullable = false)
	public Integer getNJlyy()
	{
		return this.NJlyy;
	}

	public void setNJlyy(Integer NJlyy)
	{
		this.NJlyy = NJlyy;
	}

	@Column(name = "n_jljb", nullable = false)
	public Integer getNJljb()
	{
		return this.NJljb;
	}

	public void setNJljb(Integer NJljb)
	{
		this.NJljb = NJljb;
	}

	@Column(name = "c_pzdw", nullable = false, length = 100)
	public String getCPzdw()
	{
		return this.CPzdw;
	}

	public void setCPzdw(String CPzdw)
	{
		this.CPzdw = CPzdw;
	}

	@Column(name = "c_pzwh", nullable = false, length = 100)
	public String getCPzwh()
	{
		return this.CPzwh;
	}

	public void setCPzwh(String CPzwh)
	{
		this.CPzwh = CPzwh;
	}

	@Column(name = "d_jlsj", nullable = false, length = 23)
	public Date getDJlsj()
	{
		return this.DJlsj;
	}

	public void setDJlsj(Date DJlsj)
	{
		this.DJlsj = DJlsj;
	}

	@Column(name = "c_bz", nullable = false, length = 1000)
	public String getCBz()
	{
		return this.CBz;
	}

	public void setCBz(String CBz)
	{
		this.CBz = CBz;
	}

}
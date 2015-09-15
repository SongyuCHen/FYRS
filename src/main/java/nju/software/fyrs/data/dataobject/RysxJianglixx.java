package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxJianglixx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_JIANGLIXX")
@IdClass(RysxJianglixxId.class)
public class RysxJianglixx implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2687931838961525940L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NJllb;
	private Integer NJlyy;
	private Integer NGrqk;
	private Integer NJljb;
	private String CPzdw;
	private String CPzwh;
	private Date DJlsj;
	private String CJlyyxx;
	private String CJllbsm;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxJianglixx()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nJllb
	 * @param nJlyy
	 * @param nGrqk
	 * @param nJljb
	 * @param cPzdw
	 * @param cPzwh
	 * @param dJlsj
	 * @param cJlyyxx
	 * @param cJllbsm
	 * @param nXssx
	 */
	public RysxJianglixx(BigDecimal nId, Integer nFy, Integer nRybh, Integer nJllb, Integer nJlyy, Integer nGrqk, Integer nJljb, String cPzdw, String cPzwh, Date dJlsj, String cJlyyxx,
			String cJllbsm, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NJllb = nJllb;
		NJlyy = nJlyy;
		NGrqk = nGrqk;
		NJljb = nJljb;
		CPzdw = cPzdw;
		CPzwh = cPzwh;
		DJlsj = dJlsj;
		CJlyyxx = cJlyyxx;
		CJllbsm = cJllbsm;
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

	@Column(name = "N_JLLB")
	public Integer getNJllb()
	{
		return this.NJllb;
	}

	public void setNJllb(Integer NJllb)
	{
		this.NJllb = NJllb;
	}

	@Column(name = "N_JLYY")
	public Integer getNJlyy()
	{
		return this.NJlyy;
	}

	public void setNJlyy(Integer NJlyy)
	{
		this.NJlyy = NJlyy;
	}

	@Column(name = "N_GRQK")
	public Integer getNGrqk()
	{
		return this.NGrqk;
	}

	public void setNGrqk(Integer NGrqk)
	{
		this.NGrqk = NGrqk;
	}

	@Column(name = "N_JLJB")
	public Integer getNJljb()
	{
		return this.NJljb;
	}

	public void setNJljb(Integer NJljb)
	{
		this.NJljb = NJljb;
	}

	@Column(name = "C_PZDW", length = 100)
	public String getCPzdw()
	{
		return this.CPzdw;
	}

	public void setCPzdw(String CPzdw)
	{
		this.CPzdw = CPzdw;
	}

	@Column(name = "C_PZWH", length = 50)
	public String getCPzwh()
	{
		return this.CPzwh;
	}

	public void setCPzwh(String CPzwh)
	{
		this.CPzwh = CPzwh;
	}

	@Column(name = "D_JLSJ")
	public Date getDJlsj()
	{
		return DJlsj;
	}

	public void setDJlsj(Date dJlsj)
	{
		DJlsj = dJlsj;
	}

	@Column(name = "C_JLYYXX", length = 100)
	public String getCJlyyxx()
	{
		return this.CJlyyxx;
	}

	public void setCJlyyxx(String CJlyyxx)
	{
		this.CJlyyxx = CJlyyxx;
	}

	@Column(name = "C_JLLBSM", length = 30)
	public String getCJllbsm()
	{
		return this.CJllbsm;
	}

	public void setCJllbsm(String CJllbsm)
	{
		this.CJllbsm = CJllbsm;
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
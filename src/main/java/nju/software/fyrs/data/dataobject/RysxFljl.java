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
@Table(name = "T_RYSX_FLJL")
@IdClass(RysxJianglixxId.class)
public class RysxFljl implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2687931838961525940L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Date DFfsj;
	private Double MJbxc;
	private Double MFlbt;
	private Integer NKq;
	private String Cbz;
	// Constructors

	/** default constructor */
	public RysxFljl()
	{
	}

	
	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param dFfsj
	 * @param mJbxc
	 * @param mFlbt
	 * @param cbz
	 */
	public RysxFljl(BigDecimal nId, Integer nFy, Integer nRybh, Date dFfsj,
			Double mJbxc, Double mFlbt, Integer nKq, String cbz) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		DFfsj = dFfsj;
		MJbxc = mJbxc;
		MFlbt = mFlbt;
		NKq = nKq;
		Cbz = cbz;
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

	@Column(name = "D_FFSJ")
	public Date getDFfsj() {
		return DFfsj;
	}


	public void setDFfsj(Date dFfsj) {
		DFfsj = dFfsj;
	}

	@Column(name = "M_JBXC")
	public Double getMJbxc() {
		return MJbxc;
	}


	public void setMJbxc(Double mJbxc) {
		MJbxc = mJbxc;
	}

	@Column(name = "M_FLBT")
	public Double getMFlbt() {
		return MFlbt;
	}


	public void setMFlbt(Double mFlbt) {
		MFlbt = mFlbt;
	}

	@Column(name = "C_BZ", length=50)
	public String getCbz() {
		return Cbz;
	}


	public void setCbz(String cbz) {
		Cbz = cbz;
	}

	@Column(name = "N_KQ")
	public Integer getNKq() {
		return NKq;
	}


	public void setNKq(Integer nKq) {
		NKq = nKq;
	}

	

}
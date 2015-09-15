package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxHbgb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_BMBD")
@IdClass(RysxHbgbId.class)
public class RysxBmbd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606803601433243841L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CPzwh;
	private Date DBgsj;
	private Integer NBdqbm;
	private Integer NBdhbm;
	private String CBz;

	// Constructors

	/** default constructor */
	public RysxBmbd()
	{
	}


	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nHtlb
	 * @param cHtbh
	 * @param dQdrq
	 * @param cHtqx
	 * @param iHtnr
	 */

	private RysxBmbd(BigDecimal nId, Integer nFy, Integer nRybh, String cPzwh,
			Date dBgsj, Integer cBmbefore, Integer cBmafter, String cBz) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CPzwh = cPzwh;
		DBgsj = dBgsj;
		NBdqbm = cBmbefore;
		NBdhbm = cBmafter;
		CBz = cBz;
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
	

	@Column(name = "C_PZWH", length = 50)
	public String getCPzwh() {
		return CPzwh;
	}


	public void setCPzwh(String cPzwh) {
		CPzwh = cPzwh;
	}


	@Column(name = "D_BGSJ")
	public Date getDBgsj() {
		return DBgsj;
	}


	public void setDBgsj(Date dBgsj) {
		DBgsj = dBgsj;
	}


	@Column(name = "N_BDQBM")
	public Integer getNBdqbm() {
		return NBdqbm;
	}


	public void setNBdqbm(Integer nBdqbm) {
		NBdqbm = nBdqbm;
	}

	@Column(name = "N_BDHBM")
	public Integer getNBdhbm() {
		return NBdhbm;
	}


	public void setNBdhbm(Integer nBdhbm) {
		NBdhbm = nBdhbm;
	}


	@Column(name = "C_BZ", length = 50)
	public String getCBz() {
		return CBz;
	}

	public void setCBz(String cBz) {
		CBz = cBz;
	}

	

}
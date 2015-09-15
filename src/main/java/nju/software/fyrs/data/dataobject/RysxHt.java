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
@Table(name = "T_RYSX_HT")
@IdClass(RysxHbgbId.class)
public class RysxHt implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606803601433243841L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NHtlb;
	private String CHtbh;
	private Integer NPrzw;
	private String CBz;
	private Date DQdrq;
	private String CHtqx;
	private byte[] IHtnr;

	// Constructors

	/** default constructor */
	public RysxHt()
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
	
	public RysxHt(BigDecimal nId, Integer nFy, Integer nRybh, Integer nHtlb,
			String cHtbh, Integer nPrzw, String cBz, Date dQdrq, String cHtqx,
			byte[] iHtnr) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NHtlb = nHtlb;
		CHtbh = cHtbh;
		NPrzw = nPrzw;
		CBz = cBz;
		DQdrq = dQdrq;
		CHtqx = cHtqx;
		IHtnr = iHtnr;
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
	
	@Column(name = "N_HTLB")
	public Integer getNHtlb() {
		return NHtlb;
	}

	public void setNHtlb(Integer nHtlb) {
		NHtlb = nHtlb;
	}
	
	@Column(name = "C_HTBH", length = 50)
	public String getCHtbh() {
		return CHtbh;
	}

	public void setCHtbh(String cHtbh) {
		CHtbh = cHtbh;
	}

	@Column(name = "D_QDRQ")
	public Date getDQdrq() {
		return DQdrq;
	}

	public void setDQdrq(Date dQdrq) {
		DQdrq = dQdrq;
	}

	@Column(name = "C_HTQX", length = 50)
	public String getCHtqx() {
		return CHtqx;
	}

	public void setCHtqx(String cHtqx) {
		CHtqx = cHtqx;
	}

	@Column(name = "I_HTNR")
	public byte[] getIHtnr() {
		return IHtnr;
	}

	public void setIHtnr(byte[] iHtnr) {
		IHtnr = iHtnr;
	}

	@Column(name = "N_PRZW")
	public Integer getNPrzw() {
		return NPrzw;
	}

	public void setNPrzw(Integer nPrzw) {
		NPrzw = nPrzw;
	}

	@Column(name = "C_BZ", length = 50)
	public String getCBz() {
		return CBz;
	}

	

	public void setCBz(String cBz) {
		CBz = cBz;
	}

	

}
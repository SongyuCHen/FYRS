package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Jgxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_JGBG")
@IdClass(JgxxId.class)
public class Jgbg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466567180546739248L;
	private BigDecimal NId;
	private Integer NFy;
	private Date DBgsj;
	private String CBbpfbh;
	private Date DBbpfsj;
	private String CBgnr;
	private String CBgr;
	private byte[] IBbpfnr;

	// Constructors

	/** default constructor */
	public Jgbg()
	{
	}

	/** full constructor */
	private Jgbg(BigDecimal nId, Integer nFy, Date dBgsj, String cBbpfbh,
			Date dBbpfsj, String cBgnr, String cBgr, byte[] iBbpfnr) {
		super();
		NId = nId;
		NFy = nFy;
		DBgsj = dBgsj;
		CBbpfbh = cBbpfbh;
		DBbpfsj = dBbpfsj;
		CBgnr = cBgnr;
		CBgr = cBgr;
		IBbpfnr = iBbpfnr;
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
	@Column(name = "N_Id")
	public BigDecimal getNId() {
		return NId;
	}

	public void setNId(BigDecimal nId) {
		NId = nId;
	}
	
	@Column(name = "d_bgsj")
	public Date getDBgsj() {
		return DBgsj;
	}

	public void setDBgsj(Date dBgsj) {
		DBgsj = dBgsj;
	}
	@Column(name = "c_bbpfbh", length = 100)
	public String getCBbpfbh() {
		return CBbpfbh;
	}

	public void setCBbpfbh(String cBbpfbh) {
		CBbpfbh = cBbpfbh;
	}
	@Column(name = "d_bbpfsj")
	public Date getDBbpfsj() {
		return DBbpfsj;
	}

	public void setDBbpfsj(Date dBbpfsj) {
		DBbpfsj = dBbpfsj;
	}
	@Column(name = "c_bgnr", length = 255)
	public String getCBgnr() {
		return CBgnr;
	}

	public void setCBgnr(String cBgnr) {
		CBgnr = cBgnr;
	}
	@Column(name = "c_bgr", length = 20)
	public String getCBgr() {
		return CBgr;
	}

	public void setCBgr(String cBgr) {
		CBgr = cBgr;
	}
	@Column(name = "i_bbpfnr")
	public byte[] getIBbpfnr() {
		return IBbpfnr;
	}

	public void setIBbpfnr(byte[] iBbpfnr) {
		IBbpfnr = iBbpfnr;
	}

	

}
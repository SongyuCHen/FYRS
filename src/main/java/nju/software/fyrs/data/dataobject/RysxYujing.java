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
@Table(name = "T_RYSX_YUJING")
@IdClass(RysxHbgbId.class)
public class RysxYujing implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606803601433243841L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CYjsx;
	private Date DYjsj;
	private String CBz;
	

	// Constructors

	/** default constructor */
	public RysxYujing()
	{
	}

	

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cYjsx
	 * @param dYjsj
	 * @param cBz
	 */
	public RysxYujing(BigDecimal nId, Integer nFy, Integer nRybh,
			String cYjsx, Date dYjsj, String cBz) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CYjsx = cYjsx;
		DYjsj = dYjsj;
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


	@Column(name = "C_YJSX", length = 50)
	public String getCYjsx() {
		return CYjsx;
	}



	public void setCYjsx(String cYjsx) {
		CYjsx = cYjsx;
	}


	@Column(name = "D_YJSJ")
	public Date getDYjsj() {
		return DYjsj;
	}



	public void setDYjsj(Date dYjsj) {
		DYjsj = dYjsj;
	}


	@Column(name = "C_BZ", length = 50)
	public String getCBz() {
		return CBz;
	}



	public void setCBz(String cBz) {
		CBz = cBz;
	}

}
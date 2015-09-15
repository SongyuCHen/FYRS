package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxZjxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_ZJBD")
@IdClass(RysxZjxxId.class)
public class RysxZjbg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 342904698396425602L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CPzwh;
	private Date DBdsj;
	private Integer NBdqzj;
	private Integer NBdhzj;
	private String CBz;
	

	// Constructors

	/** default constructor */
	public RysxZjbg()
	{
	}

	


	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cPzwh
	 * @param dBdsj
	 * @param nBdqzj
	 * @param nBdhzj
	 * @param cBz
	 */
	private RysxZjbg(BigDecimal nId, Integer nFy, Integer nRybh, String cPzwh,
			Date dBdsj, Integer nBdqzj, Integer nBdhzj, String cBz) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CPzwh = cPzwh;
		DBdsj = dBdsj;
		NBdqzj = nBdqzj;
		NBdhzj = nBdhzj;
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



	@Column(name = "D_BDSJ")
	public Date getDBdsj() {
		return DBdsj;
	}


	public void setDBdsj(Date dBdsj) {
		DBdsj = dBdsj;
	}



	@Column(name = "N_BDQZJ")
	public Integer getNBdqzj() {
		return NBdqzj;
	}


	public void setNBdqzj(Integer nBdqzj) {
		NBdqzj = nBdqzj;
	}



	@Column(name = "N_BDHZJ")
	public Integer getNBdhzj() {
		return NBdhzj;
	}



	public void setNBdhzj(Integer nBdhzj) {
		NBdhzj = nBdhzj;
	}



	@Column(name = "C_BZ", length=50)
	public String getCBz() {
		return CBz;
	}


	public void setCBz(String cBz) {
		CBz = cBz;
	}

	@Column(name = "C_PZWH")
	public String getCPzwh() {
		return CPzwh;
	}


	public void setCPzwh(String cPzwh) {
		CPzwh = cPzwh;
	}


}
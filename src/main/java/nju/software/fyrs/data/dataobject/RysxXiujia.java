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
@Table(name = "T_RYSX_XIUJIA")
@IdClass(RysxJianglixxId.class)
public class RysxXiujia implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2687931838961525940L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Date DKssj;
	private Date DJssj;
	private Integer NType;
	private String CXjsy;

	// Constructors

	/** default constructor */
	public RysxXiujia()
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
	public RysxXiujia(BigDecimal nId, Integer nFy, Integer nRybh, Date dKssj,
			Date dJssj, Integer nType, String cXjsy) {
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		DKssj = dKssj;
		DJssj = dJssj;
		NType = nType;
		CXjsy = cXjsy;
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

	@Column(name = "D_KSSJ")
	public Date getDKssj() {
		return DKssj;
	}

	public void setDKssj(Date dKssj) {
		DKssj = dKssj;
	}

	@Column(name = "D_JSSJ")
	public Date getDJssj() {
		return DJssj;
	}

	public void setDJssj(Date dJssj) {
		DJssj = dJssj;
	}

	@Column(name = "N_TYPE")
	public Integer getNType() {
		return NType;
	}

	public void setNType(Integer nType) {
		NType = nType;
	}

	@Column(name = "C_XJSY", length = 20)
	public String getCXjsy() {
		return CXjsy;
	}

	public void setCXjsy(String cXjsy) {
		CXjsy = cXjsy;
	}


}
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
@Table(name = "T_RYSX_HBGB")
@IdClass(RysxHbgbId.class)
public class RysxHbgb implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8606803601433243841L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private Integer NHbzw;
	private Integer NDlzw;
	private String CDldw;
	private Date DKssj;
	private Date DJssj;
	private String CJl;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxHbgb()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param nHbzw
	 * @param nDlzw
	 * @param cDldw
	 * @param dKssj
	 * @param dJssj
	 * @param cJl
	 * @param nXssx
	 */
	public RysxHbgb(BigDecimal nId, Integer nFy, Integer nRybh, Integer nHbzw, Integer nDlzw, String cDldw, Date dKssj, Date dJssj, String cJl, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		NHbzw = nHbzw;
		NDlzw = nDlzw;
		CDldw = cDldw;
		DKssj = dKssj;
		DJssj = dJssj;
		CJl = cJl;
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

	@Column(name = "N_HBZW")
	public Integer getNHbzw()
	{
		return this.NHbzw;
	}

	public void setNHbzw(Integer NHbzw)
	{
		this.NHbzw = NHbzw;
	}

	@Column(name = "N_DLZW")
	public Integer getNDlzw()
	{
		return this.NDlzw;
	}

	public void setNDlzw(Integer NDlzw)
	{
		this.NDlzw = NDlzw;
	}

	@Column(name = "C_DLDW", length = 100)
	public String getCDldw()
	{
		return this.CDldw;
	}

	public void setCDldw(String CDldw)
	{
		this.CDldw = CDldw;
	}

	@Column(name = "D_KSSJ", length = 23)
	public Date getDKssj()
	{
		return this.DKssj;
	}

	public void setDKssj(Date DKssj)
	{
		this.DKssj = DKssj;
	}

	@Column(name = "D_JSSJ", length = 23)
	public Date getDJssj()
	{
		return this.DJssj;
	}

	public void setDJssj(Date DJssj)
	{
		this.DJssj = DJssj;
	}

	@Column(name = "C_JL", length = 100)
	public String getCJl()
	{
		return this.CJl;
	}

	public void setCJl(String CJl)
	{
		this.CJl = CJl;
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
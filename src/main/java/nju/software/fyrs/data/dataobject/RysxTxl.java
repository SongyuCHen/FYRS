package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * RysxTxl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_TXL")
@IdClass(RysxTxlId.class)
public class RysxTxl implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8105087911665804098L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NRybh;
	private String CQh;
	private String CBgdh;
	private String CJtdh;
	private String CYddh;
	private String CYzbm;
	private String CTxdz;
	private Integer NXssx;

	// Constructors

	/** default constructor */
	public RysxTxl()
	{
	}

	/**
	 * @param nId
	 * @param nFy
	 * @param nRybh
	 * @param cQh
	 * @param cBgdh
	 * @param cJtdh
	 * @param cYddh
	 * @param cYzbm
	 * @param cTxdz
	 * @param nXssx
	 */
	public RysxTxl(BigDecimal nId, Integer nFy, Integer nRybh, String cQh, String cBgdh, String cJtdh, String cYddh, String cYzbm, String cTxdz, Integer nXssx)
	{
		super();
		NId = nId;
		NFy = nFy;
		NRybh = nRybh;
		CQh = cQh;
		CBgdh = cBgdh;
		CJtdh = cJtdh;
		CYddh = cYddh;
		CYzbm = cYzbm;
		CTxdz = cTxdz;
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

	@Column(name = "C_QH", length = 5)
	public String getCQh()
	{
		return this.CQh;
	}

	public void setCQh(String CQh)
	{
		this.CQh = CQh;
	}

	@Column(name = "C_BGDH", length = 20)
	public String getCBgdh()
	{
		return this.CBgdh;
	}

	public void setCBgdh(String CBgdh)
	{
		this.CBgdh = CBgdh;
	}

	@Column(name = "C_JTDH", length = 20)
	public String getCJtdh()
	{
		return this.CJtdh;
	}

	public void setCJtdh(String CJtdh)
	{
		this.CJtdh = CJtdh;
	}

	@Column(name = "C_YDDH", length = 30)
	public String getCYddh()
	{
		return this.CYddh;
	}

	public void setCYddh(String CYddh)
	{
		this.CYddh = CYddh;
	}

	@Column(name = "C_YZBM", length = 6)
	public String getCYzbm()
	{
		return this.CYzbm;
	}

	public void setCYzbm(String CYzbm)
	{
		this.CYzbm = CYzbm;
	}

	@Column(name = "C_TXDZ", length = 100)
	public String getCTxdz()
	{
		return this.CTxdz;
	}

	public void setCTxdz(String CTxdz)
	{
		this.CTxdz = CTxdz;
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
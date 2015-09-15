package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RysxTablekey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_TABLE_KEY")
public class RysxTablekey implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 789724252896742595L;
	private Integer NId;
	private BigDecimal NZzmmid;
	private BigDecimal NXzzwid;
	private BigDecimal NFlzwid;
	private BigDecimal NZjxxid;
	private BigDecimal NJzzwid;
	private BigDecimal NDjxxid;
	private BigDecimal NXlxxid;
	private BigDecimal NXwxxid;
	private BigDecimal NZdxxid;
	private BigDecimal NPxxxid;
	private BigDecimal NJlxxid;
	private BigDecimal NJtxxid;
	private BigDecimal NKhxxid;
	private BigDecimal NJianglixxid;
	private BigDecimal NCcxxid;
	private BigDecimal NCgxxid;
	private BigDecimal NWyxxid;
	private BigDecimal NJiaoliuxxid;
	private BigDecimal NSfksid;
	private BigDecimal NZyjszwid;
	private BigDecimal NSwxxid;
	private BigDecimal NBzxxid;
	private BigDecimal NSyyyxid;
	private BigDecimal NGzxxid;
	private BigDecimal NHbgbid;
	private BigDecimal NTxlid;
	private BigDecimal NLdbzid;
	private BigDecimal NGwyid;
	private BigDecimal NRcxxid;
	// Constructors

	/** default constructor */
	public RysxTablekey()
	{
	}

	/** full constructor */
	public RysxTablekey(Integer NId, BigDecimal NZzmmid, BigDecimal NXzzwid, BigDecimal NFlzwid, BigDecimal NZjxxid, BigDecimal NJzzwid, BigDecimal NDjxxid, BigDecimal NXlxxid, BigDecimal NXwxxid,
			BigDecimal NZdxxid, BigDecimal NPxxxid, BigDecimal NJlxxid, BigDecimal NJtxxid, BigDecimal NKhxxid, BigDecimal NJianglixxid, BigDecimal NCcxxid, BigDecimal NCgxxid, BigDecimal NWyxxid,
			BigDecimal NJiaoliuxxid, BigDecimal NSfksid, BigDecimal NZyjszwid, BigDecimal NSwxxid, BigDecimal NBzxxid, BigDecimal NSyyyxid, BigDecimal NGzxxid, BigDecimal NHbgbid, BigDecimal NTxlid,
			BigDecimal NLdbzid, BigDecimal NGwyid)
	{
		this.NId = NId;
		this.NZzmmid = NZzmmid;
		this.NXzzwid = NXzzwid;
		this.NFlzwid = NFlzwid;
		this.NZjxxid = NZjxxid;
		this.NJzzwid = NJzzwid;
		this.NDjxxid = NDjxxid;
		this.NXlxxid = NXlxxid;
		this.NXwxxid = NXwxxid;
		this.NZdxxid = NZdxxid;
		this.NPxxxid = NPxxxid;
		this.NJlxxid = NJlxxid;
		this.NJtxxid = NJtxxid;
		this.NKhxxid = NKhxxid;
		this.NJianglixxid = NJianglixxid;
		this.NCcxxid = NCcxxid;
		this.NCgxxid = NCgxxid;
		this.NWyxxid = NWyxxid;
		this.NJiaoliuxxid = NJiaoliuxxid;
		this.NSfksid = NSfksid;
		this.NZyjszwid = NZyjszwid;
		this.NSwxxid = NSwxxid;
		this.NBzxxid = NBzxxid;
		this.NSyyyxid = NSyyyxid;
		this.NGzxxid = NGzxxid;
		this.NHbgbid = NHbgbid;
		this.NTxlid = NTxlid;
		this.NLdbzid = NLdbzid;
		this.NGwyid = NGwyid;
	}

	// Property accessors
	@Id
	@Column(name = "N_ID", unique = true, nullable = false)
	public Integer getNId()
	{
		return this.NId;
	}

	public void setNId(Integer NId)
	{
		this.NId = NId;
	}

	@Column(name = "N_ZZMMID", nullable = false, scale = 0)
	public BigDecimal getNZzmmid()
	{
		return this.NZzmmid;
	}

	public void setNZzmmid(BigDecimal NZzmmid)
	{
		this.NZzmmid = NZzmmid;
	}

	@Column(name = "N_XZZWID", nullable = false, scale = 0)
	public BigDecimal getNXzzwid()
	{
		return this.NXzzwid;
	}

	public void setNXzzwid(BigDecimal NXzzwid)
	{
		this.NXzzwid = NXzzwid;
	}

	@Column(name = "N_FLZWID", nullable = false, scale = 0)
	public BigDecimal getNFlzwid()
	{
		return this.NFlzwid;
	}

	public void setNFlzwid(BigDecimal NFlzwid)
	{
		this.NFlzwid = NFlzwid;
	}

	@Column(name = "N_ZJXXID", nullable = false, scale = 0)
	public BigDecimal getNZjxxid()
	{
		return this.NZjxxid;
	}

	public void setNZjxxid(BigDecimal NZjxxid)
	{
		this.NZjxxid = NZjxxid;
	}

	@Column(name = "N_JZZWID", nullable = false, scale = 0)
	public BigDecimal getNJzzwid()
	{
		return this.NJzzwid;
	}

	public void setNJzzwid(BigDecimal NJzzwid)
	{
		this.NJzzwid = NJzzwid;
	}

	@Column(name = "N_DJXXID", nullable = false, scale = 0)
	public BigDecimal getNDjxxid()
	{
		return this.NDjxxid;
	}

	public void setNDjxxid(BigDecimal NDjxxid)
	{
		this.NDjxxid = NDjxxid;
	}

	@Column(name = "N_XLXXID", nullable = false, scale = 0)
	public BigDecimal getNXlxxid()
	{
		return this.NXlxxid;
	}

	public void setNXlxxid(BigDecimal NXlxxid)
	{
		this.NXlxxid = NXlxxid;
	}

	@Column(name = "N_XWXXID", nullable = false, scale = 0)
	public BigDecimal getNXwxxid()
	{
		return this.NXwxxid;
	}

	public void setNXwxxid(BigDecimal NXwxxid)
	{
		this.NXwxxid = NXwxxid;
	}

	@Column(name = "N_ZDXXID", nullable = false, scale = 0)
	public BigDecimal getNZdxxid()
	{
		return this.NZdxxid;
	}

	public void setNZdxxid(BigDecimal NZdxxid)
	{
		this.NZdxxid = NZdxxid;
	}

	@Column(name = "N_PXXXID", nullable = false, scale = 0)
	public BigDecimal getNPxxxid()
	{
		return this.NPxxxid;
	}

	public void setNPxxxid(BigDecimal NPxxxid)
	{
		this.NPxxxid = NPxxxid;
	}

	@Column(name = "N_JLXXID", nullable = false, scale = 0)
	public BigDecimal getNJlxxid()
	{
		return this.NJlxxid;
	}

	public void setNJlxxid(BigDecimal NJlxxid)
	{
		this.NJlxxid = NJlxxid;
	}

	@Column(name = "N_JTXXID", nullable = false, scale = 0)
	public BigDecimal getNJtxxid()
	{
		return this.NJtxxid;
	}

	public void setNJtxxid(BigDecimal NJtxxid)
	{
		this.NJtxxid = NJtxxid;
	}

	@Column(name = "N_KHXXID", nullable = false, scale = 0)
	public BigDecimal getNKhxxid()
	{
		return this.NKhxxid;
	}

	public void setNKhxxid(BigDecimal NKhxxid)
	{
		this.NKhxxid = NKhxxid;
	}

	@Column(name = "N_JIANGLIXXID", nullable = false, scale = 0)
	public BigDecimal getNJianglixxid()
	{
		return this.NJianglixxid;
	}

	public void setNJianglixxid(BigDecimal NJianglixxid)
	{
		this.NJianglixxid = NJianglixxid;
	}

	@Column(name = "N_CCXXID", nullable = false, scale = 0)
	public BigDecimal getNCcxxid()
	{
		return this.NCcxxid;
	}

	public void setNCcxxid(BigDecimal NCcxxid)
	{
		this.NCcxxid = NCcxxid;
	}

	@Column(name = "N_CGXXID", nullable = false, scale = 0)
	public BigDecimal getNCgxxid()
	{
		return this.NCgxxid;
	}

	public void setNCgxxid(BigDecimal NCgxxid)
	{
		this.NCgxxid = NCgxxid;
	}

	@Column(name = "N_WYXXID", nullable = false, scale = 0)
	public BigDecimal getNWyxxid()
	{
		return this.NWyxxid;
	}

	public void setNWyxxid(BigDecimal NWyxxid)
	{
		this.NWyxxid = NWyxxid;
	}

	@Column(name = "N_JIAOLIUXXID", nullable = false, scale = 0)
	public BigDecimal getNJiaoliuxxid()
	{
		return this.NJiaoliuxxid;
	}

	public void setNJiaoliuxxid(BigDecimal NJiaoliuxxid)
	{
		this.NJiaoliuxxid = NJiaoliuxxid;
	}

	@Column(name = "N_SFKSID", nullable = false, scale = 0)
	public BigDecimal getNSfksid()
	{
		return this.NSfksid;
	}

	public void setNSfksid(BigDecimal NSfksid)
	{
		this.NSfksid = NSfksid;
	}

	@Column(name = "N_ZYJSZWID", nullable = false, scale = 0)
	public BigDecimal getNZyjszwid()
	{
		return this.NZyjszwid;
	}

	public void setNZyjszwid(BigDecimal NZyjszwid)
	{
		this.NZyjszwid = NZyjszwid;
	}

	@Column(name = "N_SWXXID", nullable = false, scale = 0)
	public BigDecimal getNSwxxid()
	{
		return this.NSwxxid;
	}

	public void setNSwxxid(BigDecimal NSwxxid)
	{
		this.NSwxxid = NSwxxid;
	}

	@Column(name = "N_BZXXID", nullable = false, scale = 0)
	public BigDecimal getNBzxxid()
	{
		return this.NBzxxid;
	}

	public void setNBzxxid(BigDecimal NBzxxid)
	{
		this.NBzxxid = NBzxxid;
	}

	@Column(name = "N_SYYYXID", nullable = false, scale = 0)
	public BigDecimal getNSyyyxid()
	{
		return this.NSyyyxid;
	}

	public void setNSyyyxid(BigDecimal NSyyyxid)
	{
		this.NSyyyxid = NSyyyxid;
	}

	@Column(name = "N_GZXXID", nullable = false, scale = 0)
	public BigDecimal getNGzxxid()
	{
		return this.NGzxxid;
	}

	public void setNGzxxid(BigDecimal NGzxxid)
	{
		this.NGzxxid = NGzxxid;
	}

	@Column(name = "N_HBGBID", nullable = false, scale = 0)
	public BigDecimal getNHbgbid()
	{
		return this.NHbgbid;
	}

	public void setNHbgbid(BigDecimal NHbgbid)
	{
		this.NHbgbid = NHbgbid;
	}

	@Column(name = "N_TXLID", nullable = false, scale = 0)
	public BigDecimal getNTxlid()
	{
		return this.NTxlid;
	}

	public void setNTxlid(BigDecimal NTxlid)
	{
		this.NTxlid = NTxlid;
	}

	@Column(name = "N_LDBZID", nullable = false, scale = 0)
	public BigDecimal getNLdbzid()
	{
		return this.NLdbzid;
	}

	public void setNLdbzid(BigDecimal NLdbzid)
	{
		this.NLdbzid = NLdbzid;
	}

	@Column(name = "N_GWYID", nullable = false, scale = 0)
	public BigDecimal getNGwyid()
	{
		return this.NGwyid;
	}

	public void setNGwyid(BigDecimal NGwyid)
	{
		this.NGwyid = NGwyid;
	}

	@Column(name = "N_RCXXID", nullable = false, scale = 0)
	public BigDecimal getNRcxxid()
	{
		return NRcxxid;
	}

	public void setNRcxxid(BigDecimal nRcxxid)
	{
		NRcxxid = nRcxxid;
	}

}
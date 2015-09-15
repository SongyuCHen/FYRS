package nju.software.fyrs.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "T_RYJBXX_FZB")
@IdClass(RyjbxxFzbId.class)
public class RyjbxxFzb implements java.io.Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 101352475351749113L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	// Fields
	private Integer NFy;
	private Integer NRybh;
	private String CSfzh;
	private Integer NBm;
	private String CXm;
	private String CCym;
	private Integer NXb;
	private Integer NMz;
	private Integer NHyzk;
	private Integer NJkzk;
	private Date DCsrq;
	private String CJg;
	private String CCsd;
	private Integer NZzmm;
	private Date DZzmm;	
	private Integer NGz;//GZ
	private Integer NXl;
	private Integer NXw;
	private Date DHdxwrq;
	private Integer NZy;
	private String CZyzs;//
	private Date DHdzsrq;
	private Date DGzrq;
	private Date DJyrq;
	private String CJtj;//
	private String CJly;//
	private Date DShrq;
	private Integer NCyy;
	private Date DCrq;


	// Constructors

	/** default constructor */
	public RyjbxxFzb()
	{
	}

	@Column(name = "C_XM", length = 50)
	public String getCXm()
	{
		return this.CXm;
	}

	public void setCXm(String CXm)
	{
		this.CXm = CXm;
	}

	@Column(name = "C_CYM", length = 50)
	public String getCCym()
	{
		return this.CCym;
	}

	public void setCCym(String CCym)
	{
		this.CCym = CCym;
	}

	@Column(name = "N_XB")
	public Integer getNXb()
	{
		return this.NXb;
	}

	public void setNXb(Integer NXb)
	{
		this.NXb = NXb;
	}

	@Column(name = "N_BM")
	public Integer getNBm()
	{
		return this.NBm;
	}

	public void setNBm(Integer NBm)
	{
		this.NBm = NBm;
	}
	

	@Column(name = "C_JG", length = 50)
	public String getCJg()
	{
		return this.CJg;
	}

	public void setCJg(String CJg)
	{
		this.CJg = CJg;
	}

	@Column(name = "C_CSD", length = 50)
	public String getCCsd()
	{
		return this.CCsd;
	}

	public void setCCsd(String CCsd)
	{
		this.CCsd = CCsd;
	}

	@Column(name = "D_CSRQ")
	public Date getDCsrq()
	{
		return this.DCsrq;
	}

	public void setDCsrq(Date DCsrq)
	{
		this.DCsrq = DCsrq;
	}

	@Column(name = "N_JKZK")
	public Integer getNJkzk()
	{
		return this.NJkzk;
	}

	public void setNJkzk(Integer NJkzk)
	{
		this.NJkzk = NJkzk;
	}

	@Column(name = "N_HYZK")
	public Integer getNHyzk()
	{
		return this.NHyzk;
	}

	public void setNHyzk(Integer NHyzk)
	{
		this.NHyzk = NHyzk;
	}

	@Column(name = "N_MZ")
	public Integer getNMz()
	{
		return this.NMz;
	}

	public void setNMz(Integer NMz)
	{
		this.NMz = NMz;
	}

	@Column(name = "C_SFZH", length = 18)
	public String getCSfzh()
	{
		return this.CSfzh;
	}

	public void setCSfzh(String CSfzh)
	{
		this.CSfzh = CSfzh;
	}

	@Column(name = "N_XL")
	public Integer getNXl()
	{
		return this.NXl;
	}

	public void setNXl(Integer NXl)
	{
		this.NXl = NXl;
	}

	@Column(name = "N_ZY")
	public Integer getNZy()
	{
		return this.NZy;
	}

	public void setNZy(Integer NZy)
	{
		this.NZy = NZy;
	}

	@Column(name = "N_XW")
	public Integer getNXw()
	{
		return this.NXw;
	}

	public void setNXw(Integer NXw)
	{
		this.NXw = NXw;
	}

	@Column(name = "D_HDXWRQ")
	public Date getDHdxwrq()
	{
		return this.DHdxwrq;
	}

	public void setDHdxwrq(Date DHdxwrq)
	{
		this.DHdxwrq = DHdxwrq;
	}

	@Column(name = "D_GZRQ")
	public Date getDGzrq()
	{
		return this.DGzrq;
	}

	public void setDGzrq(Date DGzrq)
	{
		this.DGzrq = DGzrq;
	}

	@Column(name = "D_JYRQ")
	public Date getDJyrq()
	{
		return this.DJyrq;
	}

	public void setDJyrq(Date DJyrq)
	{
		this.DJyrq = DJyrq;
	}

	@Column(name = "C_ZYZS")
	public String getCZyzs()
	{
		return this.CZyzs;
	}

	public void setCZyzs(String CZyzs)
	{
		this.CZyzs = CZyzs;
	}

	@Column(name = "D_HDZSRQ")
	public Date getDHdzsrq()
	{
		return this.DHdzsrq;
	}

	public void setDHdzsrq(Date DHdzsrq)
	{
		this.DHdzsrq = DHdzsrq;
	}

	@Column(name = "N_ZZMM")
	public Integer getNZzmm()
	{
		return this.NZzmm;
	}

	public void setNZzmm(Integer NZzmm)
	{
		this.NZzmm = NZzmm;
	}

	@Column(name = "D_ZZMM")
	public Date getDZzmm()
	{
		return this.DZzmm;
	}

	public void setDZzmm(Date DZzmm)
	{
		this.DZzmm = DZzmm;
	}

	
	@Column(name = "N_GZ")
	public Integer getNGz()
	{
		return this.NGz;
	}

	public void setNGz(Integer NGz)
	{
		this.NGz = NGz;
	}


	@Column(name = "D_SHRQ")
	public Date getDShrq()
	{
		return this.DShrq;
	}

	public void setDShrq(Date DShrq)
	{
		this.DShrq = DShrq;
	}

	@Column(name = "N_CYY")
	public Integer getNCyy()
	{
		return this.NCyy;
	}

	public void setNCyy(Integer NCyy)
	{
		this.NCyy = NCyy;
	}

	@Column(name = "D_CRQ")
	public Date getDCrq()
	{
		return this.DCrq;
	}

	public void setDCrq(Date DCrq)
	{
		this.DCrq = DCrq;
	}

	@Id
	@Column(name = "N_FY")
	public Integer getNFy()
	{
		return NFy;
	}

	public void setNFy(Integer nFy)
	{
		NFy = nFy;
	}

	@Id
	@Column(name = "N_RYBH")
	public Integer getNRybh()
	{
		return NRybh;
	}

	public void setNRybh(Integer nRybh)
	{
		NRybh = nRybh;
	}

	@Column(name = "C_JTJ")
	public String getCJtj() {
		return CJtj;
	}

	public void setCJtj(String CJtj) {
		this.CJtj = CJtj;
	}

	@Column(name = "C_JLY")
	public String getCJly() {
		return CJly;
	}

	public void setCJly(String CJly) {
		this.CJly = CJly;
	}

}
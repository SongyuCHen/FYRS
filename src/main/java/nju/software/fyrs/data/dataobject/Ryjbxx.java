package nju.software.fyrs.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Ryjbxx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYJBXX")
@IdClass(RyjbxxId.class)
public class Ryjbxx implements java.io.Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7198700605124090866L;
	// Fields
	private Integer NFy;
	private Integer NRybh;
	private String CBs;
	private String CMm;
	private String CRybh;
	private String CCodeJg1;
	private String CCodeJg2;
	private String CCodeJg3;
	private String CXm;
	private String CCym;
	private Integer NXb;
	private Integer NBm;
	private Integer NUnicode;
	private Integer NGwxz;
	private String CJg;
	private String CCsd;
	private Date DCsrq;
	private Integer NJkzk;
	private Integer NHyzk;
	private Integer NMz;
	private String CSfzh;
	private Integer NBz;
	private Integer NZwlb;
	private Date DZwlbsj;
	private Integer NRyfs;
	private Integer NXl;
	private Integer NZy;
	private Integer NXw;
	private Date DHdxwrq;
	private Date DGzrq;
	private Date DJyrq;
	private Integer NZyzs;
	private Date DHdzsrq;
	private Integer NZzmm;
	private Date DZzmm;
	private Date DZfgzrq;
	private Integer NXzzw;
	private Date DXzzwRzrq;
	private Integer NFlzw;
	private Date DFlzwRzrq;
	private Short NJrtz;
	private Integer NDzzw;
	private Date DDzzwrq;
	private Date DFgzgrq;
	private Short NBcgl;
	private Short NKjgl;
	private Short NJyqfynx;
	private Integer NZj;
	private Date DZjrq;
	private Integer NDj;
	private Date DDjrq;
	private Integer NJtj;
	private Integer NJly;
	private Integer NYzw;
	private Integer NYzj;
	private String CYdw;
	private Date DShrq;
	private Integer NCyy;
	private Date DCrq;
	private Integer NQx;
	private Short NXssx;
	private Short NYx;
	private Integer NPjnl;
	private Short NYjxz;
	private Integer NSffg;
	private Date DQdfgzgzs;
	private Integer NGwyjb;
	private Date DGwyrq;
	private Integer NQdfgzgzs;
	private String CQx;
	private byte[] IMSign;
	private Integer NBiaozhi;

	// Constructors

	/** default constructor */
	public Ryjbxx()
	{
	}

	/** full constructor */
	public Ryjbxx(Integer NFy, Integer NRybh, String CBs, String CMm, String CRybh, String CCodeJg1, String CCodeJg2, String CCodeJg3, String CXm, String CCym, Integer NXb, Integer NBm,
			Integer NUnicode, Integer NGwxz, String CJg, String CCsd, Date DCsrq, Integer NJkzk, Integer NHyzk, Integer NMz, String CSfzh, Integer NBz, Integer NZwlb, Date DZwlbsj, Integer NRyfs,
			Integer NXl, Integer NZy, Integer NXw, Date DHdxwrq, Date DGzrq, Date DJyrq, Integer NZyzs, Date DHdzsrq, Integer NZzmm, Date DZzmm, Date DZfgzrq, Integer NXzzw, Date DXzzwRzrq,
			Integer NFlzw, Date DFlzwRzrq, Short NJrtz, Integer NDzzw, Date DDzzwrq, Date DFgzgrq, Short NBcgl, Short NKjgl, Short NJyqfynx, Integer NZj, Date DZjrq, Integer NDj, Date DDjrq,
			Integer NJtj, Integer NJly, Integer NYzw, Integer NYzj, String CYdw, Date DShrq, Integer NCyy, Date DCrq, Integer NQx, Short NXssx, Short NYx, Integer NPjnl, Short NYjxz, Integer NSffg,
			Date DQdfgzgzs, Integer NGwyjb, Date DGwyrq, Integer NQdfgzgzs, Integer NBiaozhi)
	{
		this.NFy = NFy;
		this.NRybh = NRybh;
		this.CBs = CBs;
		this.CMm = CMm;
		this.CRybh = CRybh;
		this.CCodeJg1 = CCodeJg1;
		this.CCodeJg2 = CCodeJg2;
		this.CCodeJg3 = CCodeJg3;
		this.CXm = CXm;
		this.CCym = CCym;
		this.NXb = NXb;
		this.NBm = NBm;
		this.NUnicode = NUnicode;
		this.NGwxz = NGwxz;
		this.CJg = CJg;
		this.CCsd = CCsd;
		this.DCsrq = DCsrq;
		this.NJkzk = NJkzk;
		this.NHyzk = NHyzk;
		this.NMz = NMz;
		this.CSfzh = CSfzh;
		this.NBz = NBz;
		this.NZwlb = NZwlb;
		this.DZwlbsj = DZwlbsj;
		this.NRyfs = NRyfs;
		this.NXl = NXl;
		this.NZy = NZy;
		this.NXw = NXw;
		this.DHdxwrq = DHdxwrq;
		this.DGzrq = DGzrq;
		this.DJyrq = DJyrq;
		this.NZyzs = NZyzs;
		this.DHdzsrq = DHdzsrq;
		this.NZzmm = NZzmm;
		this.DZzmm = DZzmm;
		this.DZfgzrq = DZfgzrq;
		this.NXzzw = NXzzw;
		this.DXzzwRzrq = DXzzwRzrq;
		this.NFlzw = NFlzw;
		this.DFlzwRzrq = DFlzwRzrq;
		this.NJrtz = NJrtz;
		this.NDzzw = NDzzw;
		this.DDzzwrq = DDzzwrq;
		this.DFgzgrq = DFgzgrq;
		this.NBcgl = NBcgl;
		this.NKjgl = NKjgl;
		this.NJyqfynx = NJyqfynx;
		this.NZj = NZj;
		this.DZjrq = DZjrq;
		this.NDj = NDj;
		this.DDjrq = DDjrq;
		this.NJtj = NJtj;
		this.NJly = NJly;
		this.NYzw = NYzw;
		this.NYzj = NYzj;
		this.CYdw = CYdw;
		this.DShrq = DShrq;
		this.NCyy = NCyy;
		this.DCrq = DCrq;
		this.NQx = NQx;
		this.NXssx = NXssx;
		this.NYx = NYx;
		this.NPjnl = NPjnl;
		this.NYjxz = NYjxz;
		this.NSffg = NSffg;
		this.DQdfgzgzs = DQdfgzgzs;
		this.NGwyjb = NGwyjb;
		this.DGwyrq = DGwyrq;
		this.NQdfgzgzs = NQdfgzgzs;
		this.NBiaozhi = NBiaozhi;
	}

	@Column(name = "C_BS", length = 50)
	public String getCBs()
	{
		return this.CBs;
	}

	public void setCBs(String CBs)
	{
		this.CBs = CBs;
	}

	@Column(name = "C_MM")
	public String getCMm()
	{
		return this.CMm;
	}

	public void setCMm(String CMm)
	{
		this.CMm = CMm;
	}

	@Column(name = "C_RYBH", length = 20)
	public String getCRybh()
	{
		return this.CRybh;
	}

	public void setCRybh(String CRybh)
	{
		this.CRybh = CRybh;
	}

	@Column(name = "C_CODE_JG1", length = 12)
	public String getCCodeJg1()
	{
		return this.CCodeJg1;
	}

	public void setCCodeJg1(String CCodeJg1)
	{
		this.CCodeJg1 = CCodeJg1;
	}

	@Column(name = "C_CODE_JG2", length = 12)
	public String getCCodeJg2()
	{
		return this.CCodeJg2;
	}

	public void setCCodeJg2(String CCodeJg2)
	{
		this.CCodeJg2 = CCodeJg2;
	}

	@Column(name = "C_CODE_JG3", length = 12)
	public String getCCodeJg3()
	{
		return this.CCodeJg3;
	}

	public void setCCodeJg3(String CCodeJg3)
	{
		this.CCodeJg3 = CCodeJg3;
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

	@Column(name = "N_UNICODE")
	public Integer getNUnicode()
	{
		return this.NUnicode;
	}

	public void setNUnicode(Integer NUnicode)
	{
		this.NUnicode = NUnicode;
	}

	@Column(name = "N_GWXZ")
	public Integer getNGwxz()
	{
		return this.NGwxz;
	}

	public void setNGwxz(Integer NGwxz)
	{
		this.NGwxz = NGwxz;
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

	@Column(name = "N_BZ")
	public Integer getNBz()
	{
		return this.NBz;
	}

	public void setNBz(Integer NBz)
	{
		this.NBz = NBz;
	}

	@Column(name = "N_ZWLB")
	public Integer getNZwlb()
	{
		return this.NZwlb;
	}

	public void setNZwlb(Integer NZwlb)
	{
		this.NZwlb = NZwlb;
	}

	@Column(name = "D_ZWLBSJ")
	public Date getDZwlbsj()
	{
		return this.DZwlbsj;
	}

	public void setDZwlbsj(Date DZwlbsj)
	{
		this.DZwlbsj = DZwlbsj;
	}

	@Column(name = "N_RYFS")
	public Integer getNRyfs()
	{
		return this.NRyfs;
	}

	public void setNRyfs(Integer NRyfs)
	{
		this.NRyfs = NRyfs;
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

	@Column(name = "N_ZYZS")
	public Integer getNZyzs()
	{
		return this.NZyzs;
	}

	public void setNZyzs(Integer NZyzs)
	{
		this.NZyzs = NZyzs;
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

	@Column(name = "D_ZFGZRQ")
	public Date getDZfgzrq()
	{
		return this.DZfgzrq;
	}

	public void setDZfgzrq(Date DZfgzrq)
	{
		this.DZfgzrq = DZfgzrq;
	}

	@Column(name = "N_XZZW")
	public Integer getNXzzw()
	{
		return this.NXzzw;
	}

	public void setNXzzw(Integer NXzzw)
	{
		this.NXzzw = NXzzw;
	}

	@Column(name = "D_XZZW_RZRQ")
	public Date getDXzzwRzrq()
	{
		return this.DXzzwRzrq;
	}

	public void setDXzzwRzrq(Date DXzzwRzrq)
	{
		this.DXzzwRzrq = DXzzwRzrq;
	}

	@Column(name = "N_FLZW")
	public Integer getNFlzw()
	{
		return this.NFlzw;
	}

	public void setNFlzw(Integer NFlzw)
	{
		this.NFlzw = NFlzw;
	}

	@Column(name = "D_FLZW_RZRQ")
	public Date getDFlzwRzrq()
	{
		return this.DFlzwRzrq;
	}

	public void setDFlzwRzrq(Date DFlzwRzrq)
	{
		this.DFlzwRzrq = DFlzwRzrq;
	}

	@Column(name = "N_JRTZ")
	public Short getNJrtz()
	{
		return this.NJrtz;
	}

	public void setNJrtz(Short NJrtz)
	{
		this.NJrtz = NJrtz;
	}

	@Column(name = "N_DZZW")
	public Integer getNDzzw()
	{
		return this.NDzzw;
	}

	public void setNDzzw(Integer NDzzw)
	{
		this.NDzzw = NDzzw;
	}

	@Column(name = "D_DZZWRQ")
	public Date getDDzzwrq()
	{
		return this.DDzzwrq;
	}

	public void setDDzzwrq(Date DDzzwrq)
	{
		this.DDzzwrq = DDzzwrq;
	}

	@Column(name = "D_FGZGRQ")
	public Date getDFgzgrq()
	{
		return this.DFgzgrq;
	}

	public void setDFgzgrq(Date DFgzgrq)
	{
		this.DFgzgrq = DFgzgrq;
	}

	@Column(name = "N_BCGL")
	public Short getNBcgl()
	{
		return this.NBcgl;
	}

	public void setNBcgl(Short NBcgl)
	{
		this.NBcgl = NBcgl;
	}

	@Column(name = "N_KJGL")
	public Short getNKjgl()
	{
		return this.NKjgl;
	}

	public void setNKjgl(Short NKjgl)
	{
		this.NKjgl = NKjgl;
	}

	@Column(name = "N_JYQFYNX")
	public Short getNJyqfynx()
	{
		return this.NJyqfynx;
	}

	public void setNJyqfynx(Short NJyqfynx)
	{
		this.NJyqfynx = NJyqfynx;
	}

	@Column(name = "N_ZJ")
	public Integer getNZj()
	{
		return this.NZj;
	}

	public void setNZj(Integer NZj)
	{
		this.NZj = NZj;
	}

	@Column(name = "D_ZJRQ")
	public Date getDZjrq()
	{
		return this.DZjrq;
	}

	public void setDZjrq(Date DZjrq)
	{
		this.DZjrq = DZjrq;
	}

	@Column(name = "N_DJ")
	public Integer getNDj()
	{
		return this.NDj;
	}

	public void setNDj(Integer NDj)
	{
		this.NDj = NDj;
	}

	@Column(name = "D_DJRQ")
	public Date getDDjrq()
	{
		return this.DDjrq;
	}

	public void setDDjrq(Date DDjrq)
	{
		this.DDjrq = DDjrq;
	}

	@Column(name = "N_JTJ")
	public Integer getNJtj()
	{
		return this.NJtj;
	}

	public void setNJtj(Integer NJtj)
	{
		this.NJtj = NJtj;
	}

	@Column(name = "N_JLY")
	public Integer getNJly()
	{
		return this.NJly;
	}

	public void setNJly(Integer NJly)
	{
		this.NJly = NJly;
	}

	@Column(name = "N_YZW")
	public Integer getNYzw()
	{
		return this.NYzw;
	}

	public void setNYzw(Integer NYzw)
	{
		this.NYzw = NYzw;
	}

	@Column(name = "N_YZJ")
	public Integer getNYzj()
	{
		return this.NYzj;
	}

	public void setNYzj(Integer NYzj)
	{
		this.NYzj = NYzj;
	}

	@Column(name = "C_YDW", length = 100)
	public String getCYdw()
	{
		return this.CYdw;
	}

	public void setCYdw(String CYdw)
	{
		this.CYdw = CYdw;
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

	@Column(name = "N_QX")
	public Integer getNQx()
	{
		return this.NQx;
	}

	public void setNQx(Integer NQx)
	{
		this.NQx = NQx;
	}

	@Column(name = "N_XSSX")
	public Short getNXssx()
	{
		return this.NXssx;
	}

	public void setNXssx(Short NXssx)
	{
		this.NXssx = NXssx;
	}

	@Column(name = "N_YX")
	public Short getNYx()
	{
		return this.NYx;
	}

	public void setNYx(Short NYx)
	{
		this.NYx = NYx;
	}

	@Column(name = "N_PJNL")
	public Integer getNPjnl()
	{
		return this.NPjnl;
	}

	public void setNPjnl(Integer NPjnl)
	{
		this.NPjnl = NPjnl;
	}

	@Column(name = "N_YJXZ")
	public Short getNYjxz()
	{
		return this.NYjxz;
	}

	public void setNYjxz(Short NYjxz)
	{
		this.NYjxz = NYjxz;
	}

	@Column(name = "N_SFFG")
	public Integer getNSffg()
	{
		return this.NSffg;
	}

	public void setNSffg(Integer NSffg)
	{
		this.NSffg = NSffg;
	}

	@Column(name = "D_QDFGZGZS")
	public Date getDQdfgzgzs()
	{
		return this.DQdfgzgzs;
	}

	public void setDQdfgzgzs(Date DQdfgzgzs)
	{
		this.DQdfgzgzs = DQdfgzgzs;
	}

	@Column(name = "N_GWYJB")
	public Integer getNGwyjb()
	{
		return this.NGwyjb;
	}

	public void setNGwyjb(Integer NGwyjb)
	{
		this.NGwyjb = NGwyjb;
	}

	@Column(name = "D_GWYRQ")
	public Date getDGwyrq()
	{
		return this.DGwyrq;
	}

	public void setDGwyrq(Date DGwyrq)
	{
		this.DGwyrq = DGwyrq;
	}

	@Column(name = "N_QDFGZGZS")
	public Integer getNQdfgzgzs()
	{
		return this.NQdfgzgzs;
	}

	public void setNQdfgzgzs(Integer NQdfgzgzs)
	{
		this.NQdfgzgzs = NQdfgzgzs;
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

	@Column(name = "C_QX")
	public String getCQx()
	{
		return CQx;
	}

	public void setCQx(String cQx)
	{
		CQx = cQx;
	}

	@Column(name = "IM_Sign")
	public byte[] getIMSign()
	{
		return IMSign;
	}

	public void setIMSign(byte[] iMSign)
	{
		IMSign = iMSign;
	}

	@Column(name = "N_BIAOZHI")
	public Integer getNBiaozhi()
	{
		return NBiaozhi;
	}

	public void setNBiaozhi(Integer nBiaozhi)
	{
		NBiaozhi = nBiaozhi;
	}

}
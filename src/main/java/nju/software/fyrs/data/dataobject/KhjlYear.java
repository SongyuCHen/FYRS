package nju.software.fyrs.data.dataobject;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * KhjlYear entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KHJL_YEAR")
public class KhjlYear implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -759951705494214675L;
	private Integer checkCode;
	private String jbxxjCode;
	private String xm;
	private String bm;
	private Integer khnd;
	private Date tbsj;
	private String xb;
	private Date cssj;
	private String zzmm;
	private String xl;
	private String spzw;
	private Date zwsj;
	private String fggz;
	private String rcgz;
	private String zdgz;
	private String dyzdgz;
	private String qtgz;
	private String grzj;
	private byte[] grqmimg;
	private Date qmsj;
	private String bmldyj;
	private byte[] bmldqmimg;
	private Date bmldqmsj;
	private String fgyldyj;
	private byte[] yldqmimg;
	private Date fgyldqmsj;
	private String bryj;
	private byte[] gryjqmimg;
	private Date brqmsj;
	private String explain;
	private Date explainSj;
	private String jieg;
	private Integer sfbp;
	private String jsdj;
	private Date jsdjsj;
	private String bz;
	private String zw;
	private String dwmc;
	private String grzj2;
	private Integer fontsize;

	// Constructors

	/** default constructor */
	public KhjlYear() {
		
	}

	/** minimal constructor */
	public KhjlYear(Integer checkCode, String jbxxjCode) {
		this.checkCode = checkCode;
		this.jbxxjCode = jbxxjCode;
	}

	/** full constructor */
	public KhjlYear(Integer checkCode, String jbxxjCode, String xm, String bm,
			Integer khnd, Date tbsj, String xb, Date cssj, String zzmm,
			String xl, String spzw, Date zwsj, String fggz, String rcgz,
			String zdgz, String dyzdgz, String qtgz, String grzj,
			byte[] grqmimg, Date qmsj, String bmldyj, byte[] bmldqmimg,
			Date bmldqmsj, String fgyldyj, byte[] yldqmimg, Date fgyldqmsj,
			String bryj, byte[] gryjqmimg, Date brqmsj, String explain,
			Date explainSj, String jieg, Integer sfbp, String jsdj,
			Date jsdjsj, String bz, String zw, String dwmc, String grzj2,
			Integer fontsize) {
		super();
		this.checkCode = checkCode;
		this.jbxxjCode = jbxxjCode;
		this.xm = xm;
		this.bm = bm;
		this.khnd = khnd;
		this.tbsj = tbsj;
		this.xb = xb;
		this.cssj = cssj;
		this.zzmm = zzmm;
		this.xl = xl;
		this.spzw = spzw;
		this.zwsj = zwsj;
		this.fggz = fggz;
		this.rcgz = rcgz;
		this.zdgz = zdgz;
		this.dyzdgz = dyzdgz;
		this.qtgz = qtgz;
		this.grzj = grzj;
		this.grqmimg = grqmimg;
		this.qmsj = qmsj;
		this.bmldyj = bmldyj;
		this.bmldqmimg = bmldqmimg;
		this.bmldqmsj = bmldqmsj;
		this.fgyldyj = fgyldyj;
		this.yldqmimg = yldqmimg;
		this.fgyldqmsj = fgyldqmsj;
		this.bryj = bryj;
		this.gryjqmimg = gryjqmimg;
		this.brqmsj = brqmsj;
		this.explain = explain;
		this.explainSj = explainSj;
		this.jieg = jieg;
		this.sfbp = sfbp;
		this.jsdj = jsdj;
		this.jsdjsj = jsdjsj;
		this.bz = bz;
		this.zw = zw;
		this.dwmc = dwmc;
		this.grzj2 = grzj2;
		this.fontsize = fontsize;
	}

	// Property accessors
	@Id
	@Column(name = "CHECK_CODE", unique = true, nullable = false)
	public Integer getCheckCode() {
		return this.checkCode;
	}

	public void setCheckCode(Integer checkCode) {
		this.checkCode = checkCode;
	}

	@Column(name = "JBXXJ_CODE", nullable = false, length = 30)
	public String getJbxxjCode() {
		return this.jbxxjCode;
	}

	public void setJbxxjCode(String jbxxjCode) {
		this.jbxxjCode = jbxxjCode;
	}

	@Column(name = "XM", length = 50)
	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Column(name = "BM", length = 20)
	public String getBm() {
		return this.bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	@Column(name = "KHND")
	public Integer getKhnd() {
		return this.khnd;
	}

	public void setKhnd(Integer khnd) {
		this.khnd = khnd;
	}

	@Column(name = "TBSJ", length = 23)
	public Date getTbsj() {
		return this.tbsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

	@Column(name = "XB", length = 1)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Column(name = "CSSJ", length = 23)
	public Date getCssj() {
		return this.cssj;
	}

	public void setCssj(Date cssj) {
		this.cssj = cssj;
	}

	@Column(name = "ZZMM", length = 2)
	public String getZzmm() {
		return this.zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	@Column(name = "XL", length = 2)
	public String getXl() {
		return this.xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	@Column(name = "SPZW", length = 2)
	public String getSpzw() {
		return this.spzw;
	}

	public void setSpzw(String spzw) {
		this.spzw = spzw;
	}

	@Column(name = "ZWSJ", length = 23)
	public Date getZwsj() {
		return this.zwsj;
	}

	public void setZwsj(Date zwsj) {
		this.zwsj = zwsj;
	}

	@Column(name = "FGGZ", length = 100)
	public String getFggz() {
		return this.fggz;
	}

	public void setFggz(String fggz) {
		this.fggz = fggz;
	}

	@Column(name = "RCGZ")
	public String getRcgz() {
		return this.rcgz;
	}

	public void setRcgz(String rcgz) {
		this.rcgz = rcgz;
	}

	@Column(name = "ZDGZ")
	public String getZdgz() {
		return this.zdgz;
	}

	public void setZdgz(String zdgz) {
		this.zdgz = zdgz;
	}

	@Column(name = "DYZDGZ")
	public String getDyzdgz() {
		return this.dyzdgz;
	}

	public void setDyzdgz(String dyzdgz) {
		this.dyzdgz = dyzdgz;
	}

	@Column(name = "QTGZ")
	public String getQtgz() {
		return this.qtgz;
	}

	public void setQtgz(String qtgz) {
		this.qtgz = qtgz;
	}

	@Column(name = "GRZJ")
	public String getGrzj() {
		return this.grzj;
	}

	public void setGrzj(String grzj) {
		this.grzj = grzj;
	}

	@Column(name = "QMSJ", length = 23)
	public Date getQmsj() {
		return this.qmsj;
	}

	public void setQmsj(Date qmsj) {
		this.qmsj = qmsj;
	}

	@Column(name = "BMLDYJ")
	public String getBmldyj() {
		return this.bmldyj;
	}

	public void setBmldyj(String bmldyj) {
		this.bmldyj = bmldyj;
	}

	@Column(name = "BMLDQMSJ", length = 23)
	public Date getBmldqmsj() {
		return this.bmldqmsj;
	}

	public void setBmldqmsj(Date bmldqmsj) {
		this.bmldqmsj = bmldqmsj;
	}

	@Column(name = "FGYLDYJ")
	public String getFgyldyj() {
		return this.fgyldyj;
	}

	public void setFgyldyj(String fgyldyj) {
		this.fgyldyj = fgyldyj;
	}

	@Column(name = "FGYLDQMSJ", length = 23)
	public Date getFgyldqmsj() {
		return this.fgyldqmsj;
	}

	public void setFgyldqmsj(Date fgyldqmsj) {
		this.fgyldqmsj = fgyldqmsj;
	}

	@Column(name = "BRYJ")
	public String getBryj() {
		return this.bryj;
	}

	public void setBryj(String bryj) {
		this.bryj = bryj;
	}

	@Column(name = "BRQMSJ", length = 23)
	public Date getBrqmsj() {
		return this.brqmsj;
	}

	public void setBrqmsj(Date brqmsj) {
		this.brqmsj = brqmsj;
	}

	@Column(name = "EXPLAIN")
	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Column(name = "EXPLAIN_SJ", length = 23)
	public Date getExplainSj() {
		return this.explainSj;
	}

	public void setExplainSj(Date explainSj) {
		this.explainSj = explainSj;
	}

	@Column(name = "JIEG", length = 1)
	public String getJieg() {
		return this.jieg;
	}

	public void setJieg(String jieg) {
		this.jieg = jieg;
	}

	@Column(name = "SFBP")
	public Integer getSfbp() {
		return this.sfbp;
	}

	public void setSfbp(Integer sfbp) {
		this.sfbp = sfbp;
	}

	@Column(name = "JSDJ", length = 10)
	public String getJsdj() {
		return this.jsdj;
	}

	public void setJsdj(String jsdj) {
		this.jsdj = jsdj;
	}

	@Column(name = "JSDJSJ", length = 23)
	public Date getJsdjsj() {
		return this.jsdjsj;
	}

	public void setJsdjsj(Date jsdjsj) {
		this.jsdjsj = jsdjsj;
	}

	@Column(name = "BZ", length = 250)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "ZW", length = 50)
	public String getZw() {
		return this.zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	@Column(name = "DWMC", length = 60)
	public String getDwmc() {
		return this.dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	@Column(name = "GRZJ2")
	public String getGrzj2() {
		return this.grzj2;
	}

	public void setGrzj2(String grzj2) {
		this.grzj2 = grzj2;
	}

	@Column(name = "FONTSIZE")
	public Integer getFontsize() {
		return this.fontsize;
	}

	public void setFontsize(Integer fontsize) {
		this.fontsize = fontsize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "GRQM_IMG")
	public byte[] getGrqmimg() {
		return grqmimg;
	}

	public void setGrqmimg(byte[] grqmimg) {
		this.grqmimg = grqmimg;
	}

	@Column(name = "BMLDQM_IMG")
	public byte[] getBmldqmimg() {
		return bmldqmimg;
	}

	public void setBmldqmimg(byte[] bmldqmimg) {
		this.bmldqmimg = bmldqmimg;
	}

	@Column(name = "YLDQM_IMG")
	public byte[] getYldqmimg() {
		return yldqmimg;
	}

	public void setYldqmimg(byte[] yldqmimg) {
		this.yldqmimg = yldqmimg;
	}

	@Column(name = "GRYJQM_IMG")
	public byte[] getGryjqmimg() {
		return gryjqmimg;
	}

	public void setGryjqmimg(byte[] gryjqmimg) {
		this.gryjqmimg = gryjqmimg;
	}

}
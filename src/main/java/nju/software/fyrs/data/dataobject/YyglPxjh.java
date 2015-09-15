package nju.software.fyrs.data.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@Table(name = "T_YYGL_PXJH")
@IdClass(YyglZhaoluId.class)
public class YyglPxjh implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3288311298325180198L;
	private BigDecimal NId;
	private Integer NFy;
	private Integer NPxxs;
	private String CPxbmc;
	private Date DKsrq;
	private Date DJsrq;
	private Integer NJglb;
	private String CPxjg;
	private Integer NZy;
	private Short NXz;
	private Integer NPxfs;
	private Integer NPxzl;
	private String NPxdd;
	private String NPxdx;
	private Double mPxys;
	
	public YyglPxjh(){
		
	}
	
	/**
	 * @param nId
	 * @param nFy
	 * @param nPxxs
	 * @param cPxbmc
	 * @param dKsrq
	 * @param dJsrq
	 * @param nJglb
	 * @param cPxjg
	 * @param nZy
	 * @param nXz
	 * @param nPxfs
	 * @param nPxzl
	 * @param nPxdd
	 * @param nPxdx
	 * @param mPxys
	 */
	public YyglPxjh(BigDecimal nId, Integer nFy, Integer nPxxs, String cPxbmc,
			Date dKsrq, Date dJsrq, Integer nJglb, String cPxjg, Integer nZy,
			Short nXz, Integer nPxfs, Integer nPxzl, String nPxdd,
			String nPxdx, Double mPxys) {
		NId = nId;
		NFy = nFy;
		NPxxs = nPxxs;
		CPxbmc = cPxbmc;
		DKsrq = dKsrq;
		DJsrq = dJsrq;
		NJglb = nJglb;
		CPxjg = cPxjg;
		NZy = nZy;
		NXz = nXz;
		NPxfs = nPxfs;
		NPxzl = nPxzl;
		NPxdd = nPxdd;
		NPxdx = nPxdx;
		this.mPxys = mPxys;
	}
	@Id
	@Column(name = "N_ID", nullable = false, scale = 0)
	public BigDecimal getNId() {
		return NId;
	}
	public void setNId(BigDecimal nId) {
		NId = nId;
	}
	@Id
	@Column(name = "N_FY", nullable = false)
	public Integer getNFy() {
		return NFy;
	}
	public void setNFy(Integer nFy) {
		NFy = nFy;
	}
	@Column(name = "N_PXXS")
	public Integer getNPxxs() {
		return NPxxs;
	}
	public void setNPxxs(Integer nPxxs) {
		NPxxs = nPxxs;
	}
	@Column(name = "C_PXBMC", length = 100)
	public String getCPxbmc() {
		return CPxbmc;
	}
	public void setCPxbmc(String cPxbmc) {
		CPxbmc = cPxbmc;
	}
	@Column(name = "D_KSRQ", length = 23)
	public Date getDKsrq() {
		return DKsrq;
	}
	public void setDKsrq(Date dKsrq) {
		DKsrq = dKsrq;
	}
	@Column(name = "D_JSRQ", length = 23)
	public Date getDJsrq() {
		return DJsrq;
	}
	public void setDJsrq(Date dJsrq) {
		DJsrq = dJsrq;
	}
	@Column(name = "N_JGLB")
	public Integer getNJglb() {
		return NJglb;
	}
	public void setNJglb(Integer nJglb) {
		NJglb = nJglb;
	}
	@Column(name = "C_PXJG", length = 100)
	public String getCPxjg() {
		return CPxjg;
	}
	public void setCPxjg(String cPxjg) {
		CPxjg = cPxjg;
	}
	@Column(name = "N_ZY")
	public Integer getNZy() {
		return NZy;
	}
	public void setNZy(Integer nZy) {
		NZy = nZy;
	}
	@Column(name = "N_XZ")
	public Short getNXz() {
		return NXz;
	}
	public void setNXz(Short nXz) {
		NXz = nXz;
	}
	@Column(name = "N_PXFS")
	public Integer getNPxfs() {
		return NPxfs;
	}
	public void setNPxfs(Integer nPxfs) {
		NPxfs = nPxfs;
	}
	@Column(name = "N_PXZL")
	public Integer getNPxzl() {
		return NPxzl;
	}
	public void setNPxzl(Integer nPxzl) {
		NPxzl = nPxzl;
	}
	@Column(name = "C_PXDD", length = 100)
	public String getNPxdd() {
		return NPxdd;
	}
	public void setNPxdd(String nPxdd) {
		NPxdd = nPxdd;
	}
	@Column(name = "C_PXDX", length = 50)
	public String getNPxdx() {
		return NPxdx;
	}
	public void setNPxdx(String nPxdx) {
		NPxdx = nPxdx;
	}
	@Column(name = "M_PXYS")
	public Double getmPxys() {
		return mPxys;
	}
	public void setmPxys(Double mPxys) {
		this.mPxys = mPxys;
	}
	

}

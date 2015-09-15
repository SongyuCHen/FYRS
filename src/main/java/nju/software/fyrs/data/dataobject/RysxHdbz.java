package nju.software.fyrs.data.dataobject;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * RysxHdbz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RYSX_HDBZ")
public class RysxHdbz implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2779490078575079821L;
	private Integer NId;
	private Integer NFy;
	private String CPzwh;
	private Date DRq;
	private byte[] imWj;
	private Integer NZyZfzxbzBmldZz;
	private Integer NZyZfzxbzBmldFz;
	private Integer NZyZfzxbzBmldQt;
	private String CZyZfzxbzBmldQtMx;
	private Integer NZyZfzxbzNsjgldZzFc;
	private Integer NZyZfzxbzNsjgldZzZk;
	private Integer NZyZfzxbzNsjgldFzZk;
	private Integer NZyZfzxbzNsjgldFzFk;
	private Integer NZyZfzxbzNsjgldQt;
	private String CZyZfzxbzNsjgldQtMx;
	private Integer NZyZfzxbzDyy;
	private Integer NZyZfzxbzFdyy;
	private Integer NZyZfzxbzZrky;
	private Integer NZyZfzxbzFzrky;
	private Integer NZyZfzxbzKybsy;
	private String CZyZfzxbzBhyy;
	private String CZyZfzxbzBz;
	private Integer NZySyKbs;
	private String CZySyBhyy;
	private String CZySyBz;
	private Integer NShengZfzxbzKbs;
	private String CShengZfzxbzBhyy;
	private String CShengZfzxbzBz;
	private Integer NShengQeKbs;
	private String CShengQeBhyy;
	private String CShengQeBz;
	private Integer NShengCeKbs;
	private String CShengCeBhyy;
	private String CShengCeBz;
	private Integer NShengZczzKbs;
	private String CShengZczzBhyy;
	private String CShengZczzBz;
	private Integer NShengFsKbs;
	private String CShengFsBhyy;
	private String CShengFsBz;
	private Integer NShiZfzxbzKbs;
	private String CShiZfzxbzBhyy;
	private String CShiZfzxbzBz;
	private Integer NShiQeKbs;
	private String CShiQeBhyy;
	private String CShiQeBz;
	private Integer NShiCeKbs;
	private String CShiCeBhyy;
	private String CShiCeBz;
	private Integer NShiZczzKbs;
	private String CShiZczzBhyy;
	private String CShiZczzBz;
	private Integer NShiFsKbs;
	private String CShiFsBhyy;
	private String CShiFsBz;
	private String CWjm;

	// Constructors

	/** default constructor */
	public RysxHdbz() {
	}

	/** minimal constructor */
	public RysxHdbz(Integer NId, Integer NFy) {
		this.NId = NId;
		this.NFy = NFy;
	}

	/** full constructor */
	public RysxHdbz(Integer NId, Integer NFy, String CPzwh, Date DRq,
			byte[] imWj, Integer NZyZfzxbzBmldZz, Integer NZyZfzxbzBmldFz,
			Integer NZyZfzxbzBmldQt, String CZyZfzxbzBmldQtMx,
			Integer NZyZfzxbzNsjgldZzFc, Integer NZyZfzxbzNsjgldZzZk,
			Integer NZyZfzxbzNsjgldFzZk, Integer NZyZfzxbzNsjgldFzFk,
			Integer NZyZfzxbzNsjgldQt, String CZyZfzxbzNsjgldQtMx,
			Integer NZyZfzxbzDyy, Integer NZyZfzxbzFdyy, Integer NZyZfzxbzZrky,
			Integer NZyZfzxbzFzrky, Integer NZyZfzxbzKybsy,
			String CZyZfzxbzBhyy, String CZyZfzxbzBz, Integer NZySyKbs,
			String CZySyBhyy, String CZySyBz, Integer NShengZfzxbzKbs,
			String CShengZfzxbzBhyy, String CShengZfzxbzBz,
			Integer NShengQeKbs, String CShengQeBhyy, String CShengQeBz,
			Integer NShengCeKbs, String CShengCeBhyy, String CShengCeBz,
			Integer NShengZczzKbs, String CShengZczzBhyy, String CShengZczzBz,
			Integer NShengFsKbs, String CShengFsBhyy, String CShengFsBz,
			Integer NShiZfzxbzKbs, String CShiZfzxbzBhyy, String CShiZfzxbzBz,
			Integer NShiQeKbs, String CShiQeBhyy, String CShiQeBz,
			Integer NShiCeKbs, String CShiCeBhyy, String CShiCeBz,
			Integer NShiZczzKbs, String CShiZczzBhyy, String CShiZczzBz,
			Integer NShiFsKbs, String CShiFsBhyy, String CShiFsBz, String CWjm) {
		this.NId = NId;
		this.NFy = NFy;
		this.CPzwh = CPzwh;
		this.DRq = DRq;
		this.imWj = imWj;
		this.NZyZfzxbzBmldZz = NZyZfzxbzBmldZz;
		this.NZyZfzxbzBmldFz = NZyZfzxbzBmldFz;
		this.NZyZfzxbzBmldQt = NZyZfzxbzBmldQt;
		this.CZyZfzxbzBmldQtMx = CZyZfzxbzBmldQtMx;
		this.NZyZfzxbzNsjgldZzFc = NZyZfzxbzNsjgldZzFc;
		this.NZyZfzxbzNsjgldZzZk = NZyZfzxbzNsjgldZzZk;
		this.NZyZfzxbzNsjgldFzZk = NZyZfzxbzNsjgldFzZk;
		this.NZyZfzxbzNsjgldFzFk = NZyZfzxbzNsjgldFzFk;
		this.NZyZfzxbzNsjgldQt = NZyZfzxbzNsjgldQt;
		this.CZyZfzxbzNsjgldQtMx = CZyZfzxbzNsjgldQtMx;
		this.NZyZfzxbzDyy = NZyZfzxbzDyy;
		this.NZyZfzxbzFdyy = NZyZfzxbzFdyy;
		this.NZyZfzxbzZrky = NZyZfzxbzZrky;
		this.NZyZfzxbzFzrky = NZyZfzxbzFzrky;
		this.NZyZfzxbzKybsy = NZyZfzxbzKybsy;
		this.CZyZfzxbzBhyy = CZyZfzxbzBhyy;
		this.CZyZfzxbzBz = CZyZfzxbzBz;
		this.NZySyKbs = NZySyKbs;
		this.CZySyBhyy = CZySyBhyy;
		this.CZySyBz = CZySyBz;
		this.NShengZfzxbzKbs = NShengZfzxbzKbs;
		this.CShengZfzxbzBhyy = CShengZfzxbzBhyy;
		this.CShengZfzxbzBz = CShengZfzxbzBz;
		this.NShengQeKbs = NShengQeKbs;
		this.CShengQeBhyy = CShengQeBhyy;
		this.CShengQeBz = CShengQeBz;
		this.NShengCeKbs = NShengCeKbs;
		this.CShengCeBhyy = CShengCeBhyy;
		this.CShengCeBz = CShengCeBz;
		this.NShengZczzKbs = NShengZczzKbs;
		this.CShengZczzBhyy = CShengZczzBhyy;
		this.CShengZczzBz = CShengZczzBz;
		this.NShengFsKbs = NShengFsKbs;
		this.CShengFsBhyy = CShengFsBhyy;
		this.CShengFsBz = CShengFsBz;
		this.NShiZfzxbzKbs = NShiZfzxbzKbs;
		this.CShiZfzxbzBhyy = CShiZfzxbzBhyy;
		this.CShiZfzxbzBz = CShiZfzxbzBz;
		this.NShiQeKbs = NShiQeKbs;
		this.CShiQeBhyy = CShiQeBhyy;
		this.CShiQeBz = CShiQeBz;
		this.NShiCeKbs = NShiCeKbs;
		this.CShiCeBhyy = CShiCeBhyy;
		this.CShiCeBz = CShiCeBz;
		this.NShiZczzKbs = NShiZczzKbs;
		this.CShiZczzBhyy = CShiZczzBhyy;
		this.CShiZczzBz = CShiZczzBz;
		this.NShiFsKbs = NShiFsKbs;
		this.CShiFsBhyy = CShiFsBhyy;
		this.CShiFsBz = CShiFsBz;
		this.CWjm = CWjm;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "identity")
	@Column(name = "N_ID", unique = true, nullable = false)
	public Integer getNId() {
		return this.NId;
	}

	public void setNId(Integer NId) {
		this.NId = NId;
	}

	@Column(name = "N_FY", nullable = false)
	public Integer getNFy() {
		return this.NFy;
	}

	public void setNFy(Integer NFy) {
		this.NFy = NFy;
	}

	@Column(name = "C_PZWH", length = 32)
	public String getCPzwh() {
		return this.CPzwh;
	}

	public void setCPzwh(String CPzwh) {
		this.CPzwh = CPzwh;
	}

	@Column(name = "D_RQ", length = 23)
	public Date getDRq() {
		return this.DRq;
	}

	public void setDRq(Date DRq) {
		this.DRq = DRq;
	}

	@Column(name = "IM_WJ")
	public byte[] getImWj() {
		return this.imWj;
	}

	public void setImWj(byte[] imWj) {
		this.imWj = imWj;
	}

	@Column(name = "N_ZY_ZFZXBZ_BMLD_ZZ")
	public Integer getNZyZfzxbzBmldZz() {
		return this.NZyZfzxbzBmldZz;
	}

	public void setNZyZfzxbzBmldZz(Integer NZyZfzxbzBmldZz) {
		this.NZyZfzxbzBmldZz = NZyZfzxbzBmldZz;
	}

	@Column(name = "N_ZY_ZFZXBZ_BMLD_FZ")
	public Integer getNZyZfzxbzBmldFz() {
		return this.NZyZfzxbzBmldFz;
	}

	public void setNZyZfzxbzBmldFz(Integer NZyZfzxbzBmldFz) {
		this.NZyZfzxbzBmldFz = NZyZfzxbzBmldFz;
	}

	@Column(name = "N_ZY_ZFZXBZ_BMLD_QT")
	public Integer getNZyZfzxbzBmldQt() {
		return this.NZyZfzxbzBmldQt;
	}

	public void setNZyZfzxbzBmldQt(Integer NZyZfzxbzBmldQt) {
		this.NZyZfzxbzBmldQt = NZyZfzxbzBmldQt;
	}

	@Column(name = "C_ZY_ZFZXBZ_BMLD_QT_MX", length = 32)
	public String getCZyZfzxbzBmldQtMx() {
		return this.CZyZfzxbzBmldQtMx;
	}

	public void setCZyZfzxbzBmldQtMx(String CZyZfzxbzBmldQtMx) {
		this.CZyZfzxbzBmldQtMx = CZyZfzxbzBmldQtMx;
	}

	@Column(name = "N_ZY_ZFZXBZ_NSJGLD_ZZ_FC")
	public Integer getNZyZfzxbzNsjgldZzFc() {
		return this.NZyZfzxbzNsjgldZzFc;
	}

	public void setNZyZfzxbzNsjgldZzFc(Integer NZyZfzxbzNsjgldZzFc) {
		this.NZyZfzxbzNsjgldZzFc = NZyZfzxbzNsjgldZzFc;
	}

	@Column(name = "N_ZY_ZFZXBZ_NSJGLD_ZZ_ZK")
	public Integer getNZyZfzxbzNsjgldZzZk() {
		return this.NZyZfzxbzNsjgldZzZk;
	}

	public void setNZyZfzxbzNsjgldZzZk(Integer NZyZfzxbzNsjgldZzZk) {
		this.NZyZfzxbzNsjgldZzZk = NZyZfzxbzNsjgldZzZk;
	}

	@Column(name = "N_ZY_ZFZXBZ_NSJGLD_FZ_ZK")
	public Integer getNZyZfzxbzNsjgldFzZk() {
		return this.NZyZfzxbzNsjgldFzZk;
	}

	public void setNZyZfzxbzNsjgldFzZk(Integer NZyZfzxbzNsjgldFzZk) {
		this.NZyZfzxbzNsjgldFzZk = NZyZfzxbzNsjgldFzZk;
	}

	@Column(name = "N_ZY_ZFZXBZ_NSJGLD_FZ_FK")
	public Integer getNZyZfzxbzNsjgldFzFk() {
		return this.NZyZfzxbzNsjgldFzFk;
	}

	public void setNZyZfzxbzNsjgldFzFk(Integer NZyZfzxbzNsjgldFzFk) {
		this.NZyZfzxbzNsjgldFzFk = NZyZfzxbzNsjgldFzFk;
	}

	@Column(name = "N_ZY_ZFZXBZ_NSJGLD_QT")
	public Integer getNZyZfzxbzNsjgldQt() {
		return this.NZyZfzxbzNsjgldQt;
	}

	public void setNZyZfzxbzNsjgldQt(Integer NZyZfzxbzNsjgldQt) {
		this.NZyZfzxbzNsjgldQt = NZyZfzxbzNsjgldQt;
	}

	@Column(name = "C_ZY_ZFZXBZ_NSJGLD_QT_MX", length = 32)
	public String getCZyZfzxbzNsjgldQtMx() {
		return this.CZyZfzxbzNsjgldQtMx;
	}

	public void setCZyZfzxbzNsjgldQtMx(String CZyZfzxbzNsjgldQtMx) {
		this.CZyZfzxbzNsjgldQtMx = CZyZfzxbzNsjgldQtMx;
	}

	@Column(name = "N_ZY_ZFZXBZ_DYY")
	public Integer getNZyZfzxbzDyy() {
		return this.NZyZfzxbzDyy;
	}

	public void setNZyZfzxbzDyy(Integer NZyZfzxbzDyy) {
		this.NZyZfzxbzDyy = NZyZfzxbzDyy;
	}

	@Column(name = "N_ZY_ZFZXBZ_FDYY")
	public Integer getNZyZfzxbzFdyy() {
		return this.NZyZfzxbzFdyy;
	}

	public void setNZyZfzxbzFdyy(Integer NZyZfzxbzFdyy) {
		this.NZyZfzxbzFdyy = NZyZfzxbzFdyy;
	}

	@Column(name = "N_ZY_ZFZXBZ_ZRKY")
	public Integer getNZyZfzxbzZrky() {
		return this.NZyZfzxbzZrky;
	}

	public void setNZyZfzxbzZrky(Integer NZyZfzxbzZrky) {
		this.NZyZfzxbzZrky = NZyZfzxbzZrky;
	}

	@Column(name = "N_ZY_ZFZXBZ_FZRKY")
	public Integer getNZyZfzxbzFzrky() {
		return this.NZyZfzxbzFzrky;
	}

	public void setNZyZfzxbzFzrky(Integer NZyZfzxbzFzrky) {
		this.NZyZfzxbzFzrky = NZyZfzxbzFzrky;
	}

	@Column(name = "N_ZY_ZFZXBZ_KYBSY")
	public Integer getNZyZfzxbzKybsy() {
		return this.NZyZfzxbzKybsy;
	}

	public void setNZyZfzxbzKybsy(Integer NZyZfzxbzKybsy) {
		this.NZyZfzxbzKybsy = NZyZfzxbzKybsy;
	}

	@Column(name = "C_ZY_ZFZXBZ_BHYY", length = 64)
	public String getCZyZfzxbzBhyy() {
		return this.CZyZfzxbzBhyy;
	}

	public void setCZyZfzxbzBhyy(String CZyZfzxbzBhyy) {
		this.CZyZfzxbzBhyy = CZyZfzxbzBhyy;
	}

	@Column(name = "C_ZY_ZFZXBZ_BZ", length = 64)
	public String getCZyZfzxbzBz() {
		return this.CZyZfzxbzBz;
	}

	public void setCZyZfzxbzBz(String CZyZfzxbzBz) {
		this.CZyZfzxbzBz = CZyZfzxbzBz;
	}

	@Column(name = "N_ZY_SY_KBS")
	public Integer getNZySyKbs() {
		return this.NZySyKbs;
	}

	public void setNZySyKbs(Integer NZySyKbs) {
		this.NZySyKbs = NZySyKbs;
	}

	@Column(name = "C_ZY_SY_BHYY", length = 64)
	public String getCZySyBhyy() {
		return this.CZySyBhyy;
	}

	public void setCZySyBhyy(String CZySyBhyy) {
		this.CZySyBhyy = CZySyBhyy;
	}

	@Column(name = "C_ZY_SY_BZ", length = 64)
	public String getCZySyBz() {
		return this.CZySyBz;
	}

	public void setCZySyBz(String CZySyBz) {
		this.CZySyBz = CZySyBz;
	}

	@Column(name = "N_SHENG_ZFZXBZ_KBS")
	public Integer getNShengZfzxbzKbs() {
		return this.NShengZfzxbzKbs;
	}

	public void setNShengZfzxbzKbs(Integer NShengZfzxbzKbs) {
		this.NShengZfzxbzKbs = NShengZfzxbzKbs;
	}

	@Column(name = "C_SHENG_ZFZXBZ_BHYY", length = 64)
	public String getCShengZfzxbzBhyy() {
		return this.CShengZfzxbzBhyy;
	}

	public void setCShengZfzxbzBhyy(String CShengZfzxbzBhyy) {
		this.CShengZfzxbzBhyy = CShengZfzxbzBhyy;
	}

	@Column(name = "C_SHENG_ZFZXBZ_BZ", length = 64)
	public String getCShengZfzxbzBz() {
		return this.CShengZfzxbzBz;
	}

	public void setCShengZfzxbzBz(String CShengZfzxbzBz) {
		this.CShengZfzxbzBz = CShengZfzxbzBz;
	}

	@Column(name = "N_SHENG_QE_KBS")
	public Integer getNShengQeKbs() {
		return this.NShengQeKbs;
	}

	public void setNShengQeKbs(Integer NShengQeKbs) {
		this.NShengQeKbs = NShengQeKbs;
	}

	@Column(name = "C_SHENG_QE_BHYY", length = 64)
	public String getCShengQeBhyy() {
		return this.CShengQeBhyy;
	}

	public void setCShengQeBhyy(String CShengQeBhyy) {
		this.CShengQeBhyy = CShengQeBhyy;
	}

	@Column(name = "C_SHENG_QE_BZ", length = 64)
	public String getCShengQeBz() {
		return this.CShengQeBz;
	}

	public void setCShengQeBz(String CShengQeBz) {
		this.CShengQeBz = CShengQeBz;
	}

	@Column(name = "N_SHENG_CE_KBS")
	public Integer getNShengCeKbs() {
		return this.NShengCeKbs;
	}

	public void setNShengCeKbs(Integer NShengCeKbs) {
		this.NShengCeKbs = NShengCeKbs;
	}

	@Column(name = "C_SHENG_CE_BHYY", length = 64)
	public String getCShengCeBhyy() {
		return this.CShengCeBhyy;
	}

	public void setCShengCeBhyy(String CShengCeBhyy) {
		this.CShengCeBhyy = CShengCeBhyy;
	}

	@Column(name = "C_SHENG_CE_BZ", length = 64)
	public String getCShengCeBz() {
		return this.CShengCeBz;
	}

	public void setCShengCeBz(String CShengCeBz) {
		this.CShengCeBz = CShengCeBz;
	}

	@Column(name = "N_SHENG_ZCZZ_KBS")
	public Integer getNShengZczzKbs() {
		return this.NShengZczzKbs;
	}

	public void setNShengZczzKbs(Integer NShengZczzKbs) {
		this.NShengZczzKbs = NShengZczzKbs;
	}

	@Column(name = "C_SHENG_ZCZZ_BHYY", length = 64)
	public String getCShengZczzBhyy() {
		return this.CShengZczzBhyy;
	}

	public void setCShengZczzBhyy(String CShengZczzBhyy) {
		this.CShengZczzBhyy = CShengZczzBhyy;
	}

	@Column(name = "C_SHENG_ZCZZ_BZ", length = 64)
	public String getCShengZczzBz() {
		return this.CShengZczzBz;
	}

	public void setCShengZczzBz(String CShengZczzBz) {
		this.CShengZczzBz = CShengZczzBz;
	}

	@Column(name = "N_SHENG_FS_KBS")
	public Integer getNShengFsKbs() {
		return this.NShengFsKbs;
	}

	public void setNShengFsKbs(Integer NShengFsKbs) {
		this.NShengFsKbs = NShengFsKbs;
	}

	@Column(name = "C_SHENG_FS_BHYY", length = 64)
	public String getCShengFsBhyy() {
		return this.CShengFsBhyy;
	}

	public void setCShengFsBhyy(String CShengFsBhyy) {
		this.CShengFsBhyy = CShengFsBhyy;
	}

	@Column(name = "C_SHENG_FS_BZ", length = 64)
	public String getCShengFsBz() {
		return this.CShengFsBz;
	}

	public void setCShengFsBz(String CShengFsBz) {
		this.CShengFsBz = CShengFsBz;
	}

	@Column(name = "N_SHI_ZFZXBZ_KBS")
	public Integer getNShiZfzxbzKbs() {
		return this.NShiZfzxbzKbs;
	}

	public void setNShiZfzxbzKbs(Integer NShiZfzxbzKbs) {
		this.NShiZfzxbzKbs = NShiZfzxbzKbs;
	}

	@Column(name = "C_SHI_ZFZXBZ_BHYY", length = 64)
	public String getCShiZfzxbzBhyy() {
		return this.CShiZfzxbzBhyy;
	}

	public void setCShiZfzxbzBhyy(String CShiZfzxbzBhyy) {
		this.CShiZfzxbzBhyy = CShiZfzxbzBhyy;
	}

	@Column(name = "C_SHI_ZFZXBZ_BZ", length = 64)
	public String getCShiZfzxbzBz() {
		return this.CShiZfzxbzBz;
	}

	public void setCShiZfzxbzBz(String CShiZfzxbzBz) {
		this.CShiZfzxbzBz = CShiZfzxbzBz;
	}

	@Column(name = "N_SHI_QE_KBS")
	public Integer getNShiQeKbs() {
		return this.NShiQeKbs;
	}

	public void setNShiQeKbs(Integer NShiQeKbs) {
		this.NShiQeKbs = NShiQeKbs;
	}

	@Column(name = "C_SHI_QE_BHYY", length = 64)
	public String getCShiQeBhyy() {
		return this.CShiQeBhyy;
	}

	public void setCShiQeBhyy(String CShiQeBhyy) {
		this.CShiQeBhyy = CShiQeBhyy;
	}

	@Column(name = "C_SHI_QE_BZ", length = 64)
	public String getCShiQeBz() {
		return this.CShiQeBz;
	}

	public void setCShiQeBz(String CShiQeBz) {
		this.CShiQeBz = CShiQeBz;
	}

	@Column(name = "N_SHI_CE_KBS")
	public Integer getNShiCeKbs() {
		return this.NShiCeKbs;
	}

	public void setNShiCeKbs(Integer NShiCeKbs) {
		this.NShiCeKbs = NShiCeKbs;
	}

	@Column(name = "C_SHI_CE_BHYY", length = 64)
	public String getCShiCeBhyy() {
		return this.CShiCeBhyy;
	}

	public void setCShiCeBhyy(String CShiCeBhyy) {
		this.CShiCeBhyy = CShiCeBhyy;
	}

	@Column(name = "C_SHI_CE_BZ", length = 64)
	public String getCShiCeBz() {
		return this.CShiCeBz;
	}

	public void setCShiCeBz(String CShiCeBz) {
		this.CShiCeBz = CShiCeBz;
	}

	@Column(name = "N_SHI_ZCZZ_KBS")
	public Integer getNShiZczzKbs() {
		return this.NShiZczzKbs;
	}

	public void setNShiZczzKbs(Integer NShiZczzKbs) {
		this.NShiZczzKbs = NShiZczzKbs;
	}

	@Column(name = "C_SHI_ZCZZ_BHYY", length = 64)
	public String getCShiZczzBhyy() {
		return this.CShiZczzBhyy;
	}

	public void setCShiZczzBhyy(String CShiZczzBhyy) {
		this.CShiZczzBhyy = CShiZczzBhyy;
	}

	@Column(name = "C_SHI_ZCZZ_BZ", length = 64)
	public String getCShiZczzBz() {
		return this.CShiZczzBz;
	}

	public void setCShiZczzBz(String CShiZczzBz) {
		this.CShiZczzBz = CShiZczzBz;
	}

	@Column(name = "N_SHI_FS_KBS")
	public Integer getNShiFsKbs() {
		return this.NShiFsKbs;
	}

	public void setNShiFsKbs(Integer NShiFsKbs) {
		this.NShiFsKbs = NShiFsKbs;
	}

	@Column(name = "C_SHI_FS_BHYY", length = 64)
	public String getCShiFsBhyy() {
		return this.CShiFsBhyy;
	}

	public void setCShiFsBhyy(String CShiFsBhyy) {
		this.CShiFsBhyy = CShiFsBhyy;
	}

	@Column(name = "C_SHI_FS_BZ", length = 64)
	public String getCShiFsBz() {
		return this.CShiFsBz;
	}

	public void setCShiFsBz(String CShiFsBz) {
		this.CShiFsBz = CShiFsBz;
	}

	@Column(name = "C_WJM", length = 64)
	public String getCWjm() {
		return this.CWjm;
	}

	public void setCWjm(String CWjm) {
		this.CWjm = CWjm;
	}

}
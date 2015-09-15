package nju.software.fyrs.data.dataobject;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "T_YYGL_ZHAOLU")
@IdClass(YyglZhaoluId.class)
public class YyglZhaolu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal NId;
	private Integer NFy;
	private String CBh;
	private String CPc;
	private Integer NZpgw;
	private Integer NZprs;
	private String CZpyq;
	private String CZplc;
	
	public YyglZhaolu(){
		
	}
	/**
	 * @param nId
	 * @param nFy
	 * @param cBh
	 * @param cPc
	 * @param nZpgw
	 * @param nZprs
	 * @param cZpyq
	 * @param cZplc
	 */
	private YyglZhaolu(BigDecimal nId, Integer nFy, String cBh, String cPc,
			Integer nZpgw, Integer nZprs, String cZpyq, String CZplc) {

		NId = nId;
		NFy = nFy;
		CBh = cBh;
		CPc = cPc;
		NZpgw = nZpgw;
		NZprs = nZprs;
		CZpyq = cZpyq;
		this.CZplc = CZplc;
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
	@Column(name = "N_ID", nullable = false, scale = 0)
	public Integer getNFy() {
		return NFy;
	}
	public void setNFy(Integer nFy) {
		NFy = nFy;
	}
	@Column(name = "C_BH", length = 20)
	public String getCBh() {
		return CBh;
	}
	public void setCBh(String cBh) {
		CBh = cBh;
	}
	@Column(name = "C_PC", length = 20)
	public String getCPc() {
		return CPc;
	}
	
	public void setCPc(String cPc) {
		CPc = cPc;
	}
	@Column(name = "N_ZPGW")
	public Integer getNZpgw() {
		return NZpgw;
	}
	
	public void setNZpgw(Integer nZpgw) {
		NZpgw = nZpgw;
	}
	@Column(name = "N_ZPRS")
	public Integer getNZprs() {
		return NZprs;
	}
	
	public void setNZprs(Integer nZprs) {
		NZprs = nZprs;
	}
	@Column(name = "T_ZPYQ")
	public String getCZpyq() {
		return CZpyq;
	}
	
	public void setCZpyq(String cZpyq) {
		CZpyq = cZpyq;
	}
	@Column(name = "T_ZPLC")
	public String getCZplc() {
		return CZplc;
	}
	public void setCZplc(String CZplc) {
		this.CZplc = CZplc;
	}
	

}

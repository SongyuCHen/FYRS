package nju.software.fyrs.biz.vo;

import java.math.BigDecimal;

public class XtglLogVO {
	private BigDecimal NId;
	private String CCzyh;
	private Integer NDwid;
	private String CIp;
	private String DCzsj;
	private String CCznr;
	public BigDecimal getNId() {
		return NId;
	}
	public void setNId(BigDecimal nId) {
		NId = nId;
	}
	public String getCCzyh() {
		return CCzyh;
	}
	public void setCCzyh(String cCzyh) {
		CCzyh = cCzyh;
	}
	public Integer getNDwid() {
		return NDwid;
	}
	public void setNDwid(Integer nDwid) {
		NDwid = nDwid;
	}
	public String getCIp() {
		return CIp;
	}
	public void setCIp(String cIp) {
		CIp = cIp;
	}
	
	public String getDCzsj() {
		return DCzsj;
	}
	public void setDCzsj(String dCzsj) {
		DCzsj = dCzsj;
	}
	public String getCCznr() {
		return CCznr;
	}
	public void setCCznr(String cCznr) {
		CCznr = cCznr;
	}
}

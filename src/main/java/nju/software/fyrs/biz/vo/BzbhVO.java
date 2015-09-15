package nju.software.fyrs.biz.vo;

public class BzbhVO {
	private int NId;
	private boolean hasWj;
	private int NYear;
	private int NMonth;
	private int NDate;
	private String CBhyy;
	private String CPzwh;
	private String NZbs;
	private String NJbs;
	private int NKbs;
	private String CBz;
	
	public int getNId() {
		return NId;
	}
	public void setNId(int nId) {
		NId = nId;
	}
	public boolean isHasWj() {
		return hasWj;
	}
	public void setHasWj(boolean hasWj) {
		this.hasWj = hasWj;
	}
	public int getNYear() {
		return NYear;
	}
	public void setNYear(int nYear) {
		NYear = nYear;
	}
	public int getNMonth() {
		return NMonth;
	}
	public void setNMonth(int nMonth) {
		NMonth = nMonth;
	}

	public int getNDate() {
		return NDate;
	}
	public void setNDate(int nDate) {
		NDate = nDate;
	}
	public String getCBhyy() {
		return CBhyy;
	}
	public void setCBhyy(String cBhyy) {
		CBhyy = cBhyy;
	}
	public String getCPzwh() {
		return CPzwh;
	}
	public void setCPzwh(String cPzwh) {
		CPzwh = cPzwh;
	}
	
	public String getNZbs() {
		return NZbs;
	}
	public void setNZbs(String nZbs) {
		NZbs = nZbs;
	}
	public String getNJbs() {
		return NJbs;
	}
	public void setNJbs(String nJbs) {
		NJbs = nJbs;
	}
	public int getNKbs() {
		return NKbs;
	}
	public void setNKbs(int nKbs) {
		NKbs = nKbs;
	}
	public String getCBz() {
		return CBz;
	}
	public void setCBz(String cBz) {
		CBz = cBz;
	}
}

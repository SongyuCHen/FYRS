package nju.software.fyrs.service.model;



/**
 * @author Admin
 * contain data shown in datatable
 */
public class RyviewModel {

	private String rybh;
	private String fy;
	private String xm;
	private String xb;
	private String nl;
	private String xzzw;
	private String zj;
	private String xl;
	private String showKey;
	private Boolean isOnlyLook;
	private String isOnlyLookEncode;
	
	/**
	 * @param xm
	 * @param xb
	 * @param nl
	 * @param xzzw
	 * @param zj
	 * @param xl
	 */
	public RyviewModel(String rybh, String fy, String xm, String xb, String nl, String xzzw, String zj,
			String xl, String showkey, boolean isOnlyLook) {
		super();
		this.rybh = rybh;
		this.fy = fy;
		this.xm = xm;
		this.xb = xb;
		this.nl = nl;
		this.xzzw = xzzw;
		this.zj = zj;
		this.xl = xl;
		this.showKey = showkey;
		this.isOnlyLook = isOnlyLook;
	}
	/**
	 * 
	 */
	public RyviewModel() {
		super();
	}
	public String getRybh() {
		return rybh;
	}
	public void setRybh(String rybh) {
		this.rybh = rybh;
	}
	public String getFy() {
		return fy;
	}
	public void setFy(String fy) {
		this.fy = fy;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getXzzw() {
		return xzzw;
	}
	public void setXzzw(String xzzw) {
		this.xzzw = xzzw;
	}
	public String getZj() {
		return zj;
	}
	public void setZj(String zj) {
		this.zj = zj;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getShowKey() {
		return showKey;
	}
	public void setShowKey(String showKey) {
		this.showKey = showKey;
	}
	public Boolean getIsOnlyLook() {
		return isOnlyLook;
	}
	public void setIsOnlyLook(Boolean isOnlyLook) {
		this.isOnlyLook = isOnlyLook;
	}
	public String getIsOnlyLookEncode()
	{
		return isOnlyLookEncode;
	}
	public void setIsOnlyLookEncode(String isOnlyLookEncode)
	{
		this.isOnlyLookEncode = isOnlyLookEncode;
	}
	
	
}

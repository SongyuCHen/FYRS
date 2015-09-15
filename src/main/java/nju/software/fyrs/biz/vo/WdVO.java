package nju.software.fyrs.biz.vo;

/**
 * 文档VO
 * @author xiaop
 *
 */
public class WdVO {
	/**
	 * 文档编号
	 */
	private Integer wdbh;
	/**
	 * 发文号
	 */
	private String fwh;
	/**
	 * 标题
	 */
	private String bt;
	/**
	 * 文档描述
	 */
	private String wdms;
	/**
	 * 文档内容
	 */
	private String wdnr;
	/**
	 * 文档路径
	 */
	private String wdlj;
	/**
	 * 文档原文件名
	 */
	private String wdywjm;
	/**
	 * 用户id
	 */
	private Integer userid;
	/**
	 * 发文时间
	 */
	private String fwsj;
	/**
	 * 最近修改时间
	 */
	private String zjxgsj;
	public Integer getWdbh() {
		return wdbh;
	}
	public void setWdbh(Integer wdbh) {
		this.wdbh = wdbh;
	}
	public String getFwh() {
		return fwh;
	}
	public void setFwh(String fwh) {
		this.fwh = fwh;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getWdms() {
		return wdms;
	}
	public void setWdms(String wdms) {
		this.wdms = wdms;
	}
	public String getWdnr() {
		return wdnr;
	}
	public void setWdnr(String wdnr) {
		this.wdnr = wdnr;
	}
	public String getWdlj() {
		return wdlj;
	}
	public void setWdlj(String wdlj) {
		this.wdlj = wdlj;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getFwsj() {
		return fwsj;
	}
	public void setFwsj(String fwsj) {
		this.fwsj = fwsj;
	}
	public String getZjxgsj() {
		return zjxgsj;
	}
	public void setZjxgsj(String zjxgsj) {
		this.zjxgsj = zjxgsj;
	}
	public String getWdywjm() {
		return wdywjm;
	}
	public void setWdywjm(String wdywjm) {
		this.wdywjm = wdywjm;
	}
}

package nju.software.fyrs.biz.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 法院的VO，主要用于传给页面的与法院列表相关的对象
 * 
 */
public class FyVO {

	/**
	 * 法院名称
	 */
	private String fymc;
	/**
	 * 法院类别代码
	 */
	private String fydm;
	/**
	 * 法院简称
	 */
	private String fyjc;
	/**
	 * 下一级法院列表
	 */
	private List<FyVO> xjfyList;
	
	public FyVO() {
		super();
	}
	
	public FyVO(String fymc, String fydm,String fyjc) {
		super();
		this.fymc = fymc;
		this.fydm = fydm;
		this.fyjc = fyjc;
	}
	
	public FyVO(String fymc, String fydm, String fyjc,List<FyVO> xjfyList) {
		super();
		this.fymc = fymc;
		this.fydm = fydm;
		this.fyjc = fyjc;
		this.xjfyList = xjfyList;
	}
	
	public String getFymc() {
		return fymc;
	}
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	
	public String getFydm() {
		return fydm;
	}
	public void setFydm(String fydm) {
		this.fydm = fydm;
	}
	public String getFyjc() {
		return fyjc;
	}

	public void setFyjc(String fyjc) {
		this.fyjc = fyjc;
	}
	
	public List<FyVO> getXjfyList() {
		return xjfyList;
	}
	public void setXjfyList(List<FyVO> xjfyList) {
		this.xjfyList = xjfyList;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
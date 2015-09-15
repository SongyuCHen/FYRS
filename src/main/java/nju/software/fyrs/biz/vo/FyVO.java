package nju.software.fyrs.biz.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ��Ժ��VO����Ҫ���ڴ���ҳ����뷨Ժ�б���صĶ���
 * 
 */
public class FyVO {

	/**
	 * ��Ժ����
	 */
	private String fymc;
	/**
	 * ��Ժ������
	 */
	private String fydm;
	/**
	 * ��Ժ���
	 */
	private String fyjc;
	/**
	 * ��һ����Ժ�б�
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
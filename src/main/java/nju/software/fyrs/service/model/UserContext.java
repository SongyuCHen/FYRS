package nju.software.fyrs.service.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 
 */
public class UserContext implements Serializable{

	
	private static final long serialVersionUID = 3781213350527130400L;
	
	/**
	 * �û����(����)
	 */
	private Integer yhbh;
	/**
	 * ��Ժ���
	 */
	private Integer fydm;
	/**
	 * �û�����(��¼��)
	 */
	private String yhdm;
	/**
	 * �û�����(����)
	 */
	private String yhmc;
	/**
	 * �û�����(���ű�� USR206-99)
	 */
	private Integer yhbm;
	/**
	 * �û�ӵ�еĽ�ɫ��ID�ַ����磺1��2��3��4
	 */
	private String yhRoleIds;
	
	private String loginTime;
    
	private String loginIp;
	/**
	 * ��ʾ�Ƿ���Ա༭��Ĭ�ϵ�¼�����ǿ��Ա༭�ģ���ʹ��Ĭ��Ȩ��ʱ�������ܱ༭����ʱ����Ϊ true.
	 */
	private boolean isHidden;
	/**
	 * ���ʹ�� ThreadLocal��ʵ������Դ���л���������״̬�ģ�ÿ�ζ��л�
	 */
	private String currentDataSource = "fyrs";
	
	public Integer getYhbh() {
		return yhbh;
	}




	public void setYhbh(Integer yhbh) {
		this.yhbh = yhbh;
	}




	public Integer getFydm() {
		return fydm;
	}




	public void setFydm(Integer fydm) {
		this.fydm = fydm;
	}




	public String getYhdm() {
		return yhdm;
	}




	public void setYhdm(String yhdm) {
		this.yhdm = yhdm;
	}




	public String getYhmc() {
		return yhmc;
	}




	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}




	public Integer getYhbm() {
		return yhbm;
	}




	public void setYhbm(Integer yhbm) {
		this.yhbm = yhbm;
	}




	public String getYhRoleIds() {
		return yhRoleIds;
	}




	public void setYhRoleIds(String yhRoleIds) {
		this.yhRoleIds = yhRoleIds;
	}




	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}




	public String getLoginTime() {
		return loginTime;
	}




	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}




	public boolean isHidden()
	{
		return isHidden;
	}

	public void setHidden(boolean isHidden)
	{
		this.isHidden = isHidden;
	}




	public String getCurrentDataSource()
	{
		return currentDataSource;
	}

	public void setCurrentDataSource(String currentDataSource)
	{
		this.currentDataSource = currentDataSource;
	}
	
}

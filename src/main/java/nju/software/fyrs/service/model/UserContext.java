package nju.software.fyrs.service.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 
 */
public class UserContext implements Serializable{

	
	private static final long serialVersionUID = 3781213350527130400L;
	
	/**
	 * 用户编号(主键)
	 */
	private Integer yhbh;
	/**
	 * 法院编号
	 */
	private Integer fydm;
	/**
	 * 用户代码(登录名)
	 */
	private String yhdm;
	/**
	 * 用户名称(姓名)
	 */
	private String yhmc;
	/**
	 * 用户部门(部门编号 USR206-99)
	 */
	private Integer yhbm;
	/**
	 * 用户拥有的角色的ID字符串如：1，2，3，4
	 */
	private String yhRoleIds;
	
	private String loginTime;
    
	private String loginIp;
	/**
	 * 表示是否可以编辑，默认登录进来是可以编辑的，当使用默认权限时，它不能编辑，此时设置为 true.
	 */
	private boolean isHidden;
	/**
	 * 如果使用 ThreadLocal来实现数据源的切换，它是无状态的，每次都切换
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

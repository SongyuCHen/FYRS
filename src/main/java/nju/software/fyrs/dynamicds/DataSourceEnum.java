/**
 * created by 2010-11-23
 */
package nju.software.fyrs.dynamicds;

/**
 * ����ԴEnum
 * @author zym
 * 
 */
public enum DataSourceEnum {
	/**
	 * ����Ժ
	 */
	FYRS("fyrs","fyrs"),
	FYRS_BACKUP("fyrsBackup","fyrsBackup");
	
	String fydm;
	
	String source;

	/**
	 * @param fydm
	 * @param source
	 */
	private DataSourceEnum(String fydm, String source) {
		this.fydm = fydm;
		this.source = source;
	}

	/**
	 * @return the fydm
	 */
	public String getFydm() {
		return fydm;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
}

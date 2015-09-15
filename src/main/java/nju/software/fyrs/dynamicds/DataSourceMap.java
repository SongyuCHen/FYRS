/**
 * created by 2010-11-4
 */
package nju.software.fyrs.dynamicds;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YZJ
 *
 */
public class DataSourceMap {
	
	public static final String NotDefined = "NotDefined";
	public static final String fyrs="fyrs";
	public static final String fyrsBackup = "fyrsBackup";
	
	private static final Map<String,String> dataSourceMap = new HashMap<String, String>();
	
	static{
		EnumSet<DataSourceEnum> enums = EnumSet.allOf(DataSourceEnum.class);
		for(DataSourceEnum dataSource:enums){
			dataSourceMap.put(dataSource.getFydm(), dataSource.getSource());
		}
	}
		
	public static String getDataSourceKey(String fydm){
		return dataSourceMap.get(fydm);
	}
	
}

package nju.software.fyrs.util;

import java.lang.reflect.Field;

public class SdcxUtil {
	public static String firstLetterUp(String name)
    {
      char[] cs = name.toCharArray();
      if(!(cs[0] >= 65 && cs[0] <= 90))
      {
    	  cs[0] -= 32;
      }
      return String.valueOf(cs);
    }
	/**
	 * ИзЈє T_RYJBXX  --- > Ryjbxx
	 * @param tableName
	 * @return
	 */
	public static String fyrsTableToObjectName(String tableName)
	{
		String[] strs = tableName.split("_");
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < strs.length; i++)
		{
			sb.append(firstLetterUp(strs[i].toLowerCase()));
		}
		return sb.toString();
	}
	public static Object getFieldValue(Object obj,String fieldName)
	{
		try
		{
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(obj);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public static String fyrsColumnNameToFiledName(String columnName)
	{
		String[] strs = columnName.split("_");
		StringBuilder sb = new StringBuilder();
		sb.append(strs[0]);
		for(int i = 1; i < strs.length; i++)
		{
			sb.append(firstLetterUp(strs[i].toLowerCase()));
		}
		return sb.toString();
	}
}

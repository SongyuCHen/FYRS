package nju.software.fyrs.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class NFyRybhCodeUtils {
	/**
	 * ֻ�� fydm rybh ����
	 * @param fydm
	 * @param rybh
	 * @return
	 */
	public static String encode(int fydm, int rybh)
	{
		String fydmRybh = fydm + "-" + rybh;
		String result = Base64.encode(fydmRybh.getBytes());
		return result;
	}

	public static String[] decode(String fydmRybh)
	{
		String[] code = null;
		try
		{
			String result = new String(Base64.decode(fydmRybh));
			code = result.split("-");
		} catch (Exception e)
		{

			e.printStackTrace();
		}
		return code;
	}
	/**
	 * �� fydm rybh ���Ƿ���Բ鿴һ�����
	 * @param fydm
	 * @param rybh
	 * @param isOnlyLook
	 * @return
	 */
	public static String encodeIsOnlyLook(int fydm, int rybh,boolean isOnlyLook)
	{
		String fydmRybh = fydm + "-" + rybh+"-"+isOnlyLook;
		String result = Base64.encode(fydmRybh.getBytes());
		return result;
	}
}

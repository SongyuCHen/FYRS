package nju.software.fyrs.dynamicds;

import nju.software.fyrs.service.model.UserContext;
/**
 * ʹ�� ThreadLocal ������һ���û�������
 * @author DELL
 *
 */
public class UserContextHolder
{
	private static ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>();

	public static void setUserContext(UserContext mUserContext)
	{
		userContext.set(mUserContext);
	}

	public static UserContext getUserContext()
	{
		return userContext.get();
	}

	public static void removeUserContext()
	{
		userContext.remove();
	}
}

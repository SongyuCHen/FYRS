package nju.software.fyrs.dynamicds;

import nju.software.fyrs.service.model.UserContext;
/**
 * 使用 ThreadLocal 来保存一个用户上下文
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

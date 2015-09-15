package nju.software.fyrs.util;

public class InterceptThreadLocal {
	private static ThreadLocal<Boolean> isIntercept = new ThreadLocal<Boolean>();

	public static void setIsIntercept(Boolean mIsIntercept)
	{
		isIntercept.set(mIsIntercept);
	}

	public static Boolean getIsIntercept()
	{
		return isIntercept.get();
	}

	public static void removeIsIntercept()
	{
		isIntercept.remove();
	}
}

package nju.software.fyrs.util;

public class LoginUserInfoThreadLocal {
	private static ThreadLocal<String> username = new ThreadLocal<String>();
	private static ThreadLocal<String> userIp = new ThreadLocal<String>();

	public static String getUsername() {
		return username.get();
	}

	public static void setUsername(String mUsername) {
		username.set(mUsername);
	}

	public static String getUserIp() {
		return userIp.get();
	}

	public static void setUserIp(String mUserIp) {
		userIp.set(mUserIp);
	}

	public static void usernameRemove() {
		username.remove();
	}

	public static void userIpRemove() {
		userIp.remove();
	}
}

package nju.software.fyrs.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class TempUtils {
	@SuppressWarnings("rawtypes")
	public static void requestParameter(HttpServletRequest request) {
		Map map = request.getParameterMap();
		Set set = map.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("String " + name + " = "
					+ "request.getParameter(\"" + name + "\");");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void addModelParameter(HttpServletRequest request) {
		Map map = request.getParameterMap();
		Set set = map.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.println("model.addAttribute(\"" + name + "\"," + name
					+ ");");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void htmlParameter(HttpServletRequest request) {
		Map map = request.getParameterMap();
		Set set = map.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			System.out.print("data-" + name + "=\"${" + name + "}\"" + "  ");
		}
		System.out.println();
	}

	@SuppressWarnings("rawtypes")
	public static void postDataParameter(HttpServletRequest request) {
		Map map = request.getParameterMap();
		Set set = map.keySet();
		StringBuffer sb = new StringBuffer();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			sb.append(name + ":" + "$(\"#bmPopContent\").attr(\"data-" + name
					+ "\")");
			sb.append(",");
		}
		System.out.println(sb.toString());
	}

	public static void start(HttpServletRequest request) {
		TempUtils.addModelParameter(request);
		System.out.println("-------------------------------------");
		TempUtils.htmlParameter(request);
		System.out.println("-------------------------------------");
		TempUtils.postDataParameter(request);
		System.out.println("-------------------------------------");
		TempUtils.requestParameter(request);
	}
}

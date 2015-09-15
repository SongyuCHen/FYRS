package nju.software.fyrs.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 数值相关的工具类
 * @author zym
 *
 */
public class NumberUtil {
	/**
	 * 数值保留两位小数
	 * 
	 * @param convert
	 *            转换前数值
	 * @return 转换后字符串
	 */
	public static String changeNumberType(BigDecimal big) {

		big.setScale(2, RoundingMode.HALF_UP);
		DecimalFormat format = new DecimalFormat("##0.00");
		return format.format(big);
	}
	public static String formatFloat(float value,String format)
	{
		DecimalFormat decimalFormat = new DecimalFormat(format);
		return decimalFormat.format(value);
	}
}

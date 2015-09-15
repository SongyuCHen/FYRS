package nju.software.fyrs.service.convertor;

import java.util.Date;
import nju.software.fyrs.util.DateUtil;
import nju.software.fyrs.util.StringUtil;

import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {
	@SuppressWarnings("rawtypes")
	public Object convert(Class arg0, Object arg1){
		if(arg1 == null){
			return null;
		}
		if(arg1 instanceof Date){
			return arg1;
		}
		if(StringUtil.isBlank(String.valueOf(arg1))){
			return null;
		}
		try {
			Date date = DateUtil.parse(String.valueOf(arg1), DateUtil.webFormat);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
}

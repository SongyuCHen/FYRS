package nju.software.fyrs.util;

import java.lang.reflect.InvocationTargetException;

import nju.software.fyrs.service.convertor.DateConverter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class BeanUtilsEx extends BeanUtils{
	static {
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
	}
	public static void copyProperties(Object dest, Object orig){
		try{
			BeanUtils.copyProperties(dest, orig);
		} catch(IllegalAccessException ex){
			ex.printStackTrace();
		} catch (InvocationTargetException ex){
			ex.printStackTrace();
		}
	}
}

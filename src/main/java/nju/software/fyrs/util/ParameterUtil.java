/**
 * created by 2010-6-28
 */
package nju.software.fyrs.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

/**
 * web请求参数工具类
 * 
 * @author zym
 *
 */
public class ParameterUtil {
	 /**
     * 获得输入参数
     * 
     * @param request web请求
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Properties getInputs(HttpServletRequest request) {
        Properties inputs = new Properties();

        Map<String,String[]> parameters =  request.getParameterMap();
        for(String name : parameters.keySet()){
        	String value = parameters.get(name)[0];
        	try {
				value = new String(value.getBytes("iso-8859-1"),"gb2312");
			} catch (UnsupportedEncodingException e) {
			}
        	if(value==null){
        		continue;
        	}
        	inputs.setProperty(name, value);
        }
        return inputs;
    }
    
    
    /**
     * 获得需要签名的数据，按照参数名字母升序的顺序将所有参数用&连接起来。
     * 
     * @param params 需要签名的所有参数
     * @return
     */
    @SuppressWarnings({ "unchecked" })
    public static  String getSignData(Properties params) {
        
        if (params == null) {
            return null;
        }
        StringBuffer content = new StringBuffer();
        @SuppressWarnings("rawtypes")
		List<String> keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.getProperty(key);
            content.append((i == 0 ? "" : "&") + key + "=" + value);
        }

        return content.toString();
    }
 
}

package nju.software.fyrs.util;

import javax.servlet.http.HttpServletResponse;

import com.sdicons.json.mapper.JSONMapper;

public class JSONUtils {
	 public static void toJSON(Object o,HttpServletResponse response){
	        try {
	            /**
	             * ֱ�Ӱ�һ������ת���� json ��ʽ
	             */
	            String s = JSONMapper.toJSON(o).render(false);
	            response.setCharacterEncoding("UTF-8");
	            response.getWriter().write(s);
	            System.out.println("json--->"+s);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}

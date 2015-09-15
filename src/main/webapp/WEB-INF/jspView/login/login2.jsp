<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.net.URLDecoder"%>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies == null)
        cookies = new Cookie[0];
    String name = "";
    String value = "";
    for(int i = 0; i < cookies.length; i ++)
    {
        Cookie cookie = cookies[i];
        if("KOAL_CERT_CN".equals(cookie.getName()))
        {
            name = "用户标识：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        }
        else if("KOAL_CERT_G".equals(cookie.getName()))
        {
            name = "姓名：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        }
        
        else if("KOAL_CERT_O".equals(cookie.getName()))
        {
            name = "组织：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        }        
        else if("KOAL_CERT_OU".equals(cookie.getName()))
        {
            name = "部门：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        }        
        else if("KOAL_CERT_E".equals(cookie.getName()))
        {
            name = "E-mail：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        } 
	else if("KOAL_CLIENT_IP".equals(cookie.getName()))
        {
            name = "客户IP：";
            value = cookie.getValue();
        }
else if("KOAL_CERT_ISSUER_CN ".equals(cookie.getName()))
        {
            name = "颁发者名称：";
            value = new String(URLDecoder.decode(cookie.getValue()).getBytes("ISO-8859-1"), "GBK");
        } 
		else if("KOAL_NOT_AFTER ".equals(cookie.getName()))
        {
            name = "证书失效期：";
            value = cookie.getValue();
        }
else if("KOAL_CERT ".equals(cookie.getName()))
        {
            name ="用户证书：";
            value = cookie.getValue();
        }                         
        else
        {
            continue;
        }
%>
<%= name %><%= value %>&nbsp;<BR>
<%     
    }
%>

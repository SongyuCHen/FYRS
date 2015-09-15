<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        #row-table
        {
            text-align:left;
        }

    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
    <script src="/resources/jstree/libs/jquery.js"></script>
    <script src="/resources/jstree/jquery.jstree.js"></script>
    <script language="javascript">
       
    </script>
</head>
<body>
  <button id="selectedCheckBox">获得所有的选中</button>
  <button id="getCheckBox">获得所有授权状态</button>
 <table>
     <tr>
         <c:forEach items="${ids}" var="menuTopId">
             <td id="row-table" style="vertical-align:top;"><div id="roleTree-${menuTopId}"></div></td>
         </c:forEach>
     </tr>
 </table>
</body>
</html>

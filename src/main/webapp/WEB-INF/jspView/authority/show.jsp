<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
    <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
    <script src="/resources/jstree/libs/jquery.js"></script>
    <script src="/resources/jstree/jquery.jstree.js"></script>
    <script language="javascript">
        $(function()
        {
            $("#roleTree").jstree({
                "json_data":{
                    "ajax":{
                        "url":"roleTreeJson.do"
                    }
                },
                "themes":{
                    "theme" : "classic"
                },
                "plugins" : [ "themes", "json_data" ,"ui"]
            });


            $("#roleTree").bind(
                    "loaded.jstree",
                    function(event){
                        $("#roleTree").jstree("open_all",-1); 
                    }
            );
            
            $("#roleTree").bind(
                    "select_node.jstree",
                    function(event,data){
                        //取li标记上的属性
                        var currentRoleId = data.rslt.obj.attr("id");
                        // alert(currentRoleId+"应该是空的--->");
                        $("#rightFrame").attr("src",currentRoleId+"/menuTree.do");
                    }
            );
            $("#roleTree").css("font-size","12px");
        });

        function refresh(){
            $("#roleTree").jstree("refresh","#roleTree");
        }
    </script>
</head>
<body>
<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
    <tr>
        <td width="150" valign="top"><div id="roleTree"></div></td>
        <td width="8" bgcolor="#add2da">&nbsp;</td>
        <td>
            <iframe src="1/menuTree.do"  width="100%" height="100%" frameborder="0" id="rightFrame" name="rightFrame"></iframe>
        </td>
        <td width="8" bgcolor="#add2da">&nbsp;</td>
    </tr>
</table>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <link href="/resources/jstree/themes/default/style.min.css" rel="stylesheet" type="text/css" />
   <script src="/resources/jstree/jquery.jstree.js"></script>
    <style type="text/css">
     #whdwxx_xzfy
     {
       text-align: center;
       padding: 15px;
	margin-bottom: 15px;
	color: black;
	background-color:#EDEDED;
	   font-size: 120%;
     }
       #whdwxx_table
       {
         margin-left: 40px;
       }
       #whdwxx_table textarea
       {
          width:433px;
          heigth:25px;
       }
       #whdwxx_table tr
       {
         height: 30px;
       }
       #whdwxx_table tr td
       {
       	padding-top:5px;
         width:150px;
       }
       #whdwxx_save
       {
         margin-top:10px;
         text-align: center;
       }   
       
    </style>
    <script type="text/javascript">
       $(function(){
    	   $("#whdwxx_btn_save").click(function(){
    		   updateDwxx();
           }); // save
    	   // 点击触发事件 
     	  $('.xzfy_ipt').click(function() {
   			$.ajax({
   				url : "/xzfyShow.aj",
   				type : 'post',
   				dataType : 'html',
   				data : {},
   				success : function(html) {
   				    $('.xzfy_dlg').html(html).dialog('open');
   				}
   			});
   		}); // 获得法院
   		// 当选择法院后
   		
       }); // jquery
      var selectFyAfter = function(){
    	   var fydm = $(".xzfy_fybh").val();
    	   $.ajax({
    		   url:"/main/dwxx/whdwxxPop.aj",
    		   type:"POST",
    		   data:{fydm:fydm},
    		   dataType:"html",
    		   success:function(html){
    			   $("#whdwxx_table_wrap #whdwxx_table,#whdwxx_table_wrap #whdwxx_save").remove();
    			   $("#whdwxx_table_wrap").html(html);
    		   }
    	   }); // ajax
       };
       
      var updateDwxx = function(){
    	  var content = "{";
		   content += '"NFy":"'+$("#whdwxx_table").data("fydm")+'",';
   	   $("#whdwxx_table tr td input").each(function(){
   		   content += '"'+$(this).attr("name")+'":"' + $(this).val()+'",';
   	   });
   	   $("#whdwxx_table tr td textarea").each(function(){
   		   content += '"'+$(this).attr("name")+'":"' + $(this).val()+'",';
   	   });
   	   content += '"NFkdq":"'+$("#select_NFkdq option:selected").val()+'"';
   	   content += "}";
   	   var jsonObj = JSON.parse(content);
   	   $.ajax({
   		   url : "/main/dwxx/updateDwxx.aj",
 				type : 'POST',
 				dataType : 'html',
 				data :jsonObj,
 				success : function(html) {
 					if(1 == html)
 						{
 						  alert("单位信息更新成功");
 						}
 				}
   	   });
      };
    </script>
</head>
<body>
   <div id="whdwxx_xzfy" class="form-horizontal">
	   	<div class="form-group">
	   		<label class="control-label" style="display:inline-block;width:90px;height:24px;text-align:center;">法院：</label>
	   		<div style="display:inline-block;width:250px;height:30px;">
	   			<input type="text" class="xzfy_ipt input-sm form-control" value="请选择一个法院" style="display:inline-block;"/>
	   			<input class="xzfy_fybh" name="fybh" value="320000 A00" type="hidden" />
			</div>	
		</div>
	</div>
   <div id="whdwxx_table_wrap">
   <table id="whdwxx_table"  data-fydm="${dwxx.NFy}">
     <tr>
        <td align="right">人事负责人：</td>
        <td><input type="text" name="CRsfzr" value="${dwxx.CRsfzr}"></td>
        <td align="right">联系电话:</td>
        <td class="even"><input type="text" name="CLldh" value="${dwxx.CLldh}"></td>
     </tr>
     <tr>
        <td align="right">邮政编码：</td>
        <td><input type="text" name="CYzbm" value="${dwxx.CYzbm}"></td>
        <td align="right">单位传真:</td>
        <td><input type="text" name="CDwczh" value="${dwxx.CDwczh}"></td>
     </tr>
     <tr>
        <td align="right">单位地址：</td>
        <td colspan="3"><textarea name="CDwdz" rows="2" cols="10">${dwxx.CDwdz}</textarea></td>
     </tr>
     <tr>
        <td align="right" >法院创建时间：</td>
        <td colspan="3"><input type="text" name="DCjsj" value="${dwxx.DCjsj}"></td>
     </tr>
     <tr>
        <td align="right">中央行政编制数：</td>
        <td><input type="text" name="NZyxzbzs" value="${dwxx.NZyxzbzs}"></td>
        <td align="right">中央事业编制数:</td>
        <td><input type="text" name="NZysybzs" value="${dwxx.NZysybzs}"></td>
     </tr>
     <tr>
       <td></td>
        <td>实有人数：${dwxx.NZyxzbzsCount}</td>
        <td></td>
        <td>实有人数：${dwxx.NZysybzsCount}</td>
     </tr>
      <tr>
        <td align="right">地方行政编制数：</td>
        <td><input type="text" name="NDfxzbzs" value="${dwxx.NDfxzbzs}"></td>
        <td align="right">行政附属编制数:</td>
        <td><input type="text" name="NXzfsbzs" value="${dwxx.NXzfsbzs}"></td>
     </tr>
     <tr>
        <td></td>
        <td>实有人数：${dwxx.NDfxzbzsCount}</td>
        <td></td>
        <td>实有人数：${dwxx.NXzfsbzsCount}</td>
     </tr>
      <tr>
        <td align="right">地方全额事业编制数：</td>
        <td><input type="text" name="NDfqesybzs" value="${dwxx.NDfqesybzs}"></td>
        <td align="right">地方差额事业编制数：</td>
        <td><input type="text" name="NDfcesybzs" value="${dwxx.NDfcesybzs}"></td>
     </tr>
     <tr>
        <td></td>
        <td>实有人数：${dwxx.NDfqesybzsCount}</td>
        <td></td>
        <td>实有人数：${dwxx.NDfcesybzsCount}</td>
     </tr>
     <tr>
        <td align="right">地方自筹自支事业编制数：</td>
        <td><input type="text" name="NDfzczzsybzs" value="${dwxx.NDfzczzsybzs}"></td>
        <td align="right">企业编制数:</td>
        <td><input type="text" name="NQybzs" value="${dwxx.NQybzs}"></td>
     </tr>
     <tr>
        <td></td>
        <td>实有人数：${dwxx.NDfzczzsybzsCount}</td>
        <td></td>
        <td>实有人数：${dwxx.NQybzsCount}</td>
     </tr>
      <tr>
        <td align="right">是否放宽地区：</td>
        <td colspan="3">
        <select id="select_NFkdq">
           <option value="1"  <c:if test="${dwxx.NFkdq == 1}">selected="selected"</c:if> >是</option>
           <option value="2" <c:if test="${dwxx.NFkdq == 2}">selected="selected"</c:if> >否</option>
        </select></td>
     </tr>
     <tr>
        <td align="right">变更情况：</td>
        <td colspan="3"><textarea name="CBgqk" rows="2" cols="10" >${dwxx.CBgqk}</textarea></td>
     </tr>
      <tr>
        <td align="right">内设机构总数：</td>
        <td>${dwxx.NNsjgzsCount}</td>
        <td align="right">其他人员实有人数：</td>
        <td>${dwxx.NQtyrsyrsCount}</td>
     </tr>
   </table>
 
    <div id="whdwxx_save">
    	<button type="button" class="btn btn-primary" id="whdwxx_btn_save">
    		<span class="glyphicon glyphicon-save"></span> 保存
    	</button>
    </div>
  </div>
    <div class="xzfy_dlg" isOnlyXzFy="0" isBmSelected="0"></div>
</body>
</html>

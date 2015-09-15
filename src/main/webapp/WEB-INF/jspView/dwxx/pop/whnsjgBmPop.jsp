<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
   #bmPop #bmPopContent
   {
     margin-top: 20px;
   }
   #bmPop #bmPopContent div
   {
     margin-top: 10px;
   }
</style>
<script type="text/javascript">
  $(function(){
	 var btnType = $("#bmPopContent").attr("data-btnType");
	 var bmbh = $("#bmPopContent").attr("data-bmbh");
	 var isOnlyBm = $("#bmPopContent").attr("data-isOnlyBm");
	 var nlevel =  $("#bmPopContent").attr("data-nlevel");
	 
	 // 没有部门号，说明是下级菜单
	 if( isOnlyBm == 1 && btnType == 0 )
     {
		 $("#bmPopContent #bzmc,#bmPopContent #zgldzw").css("display","none");
     }
	 if( isOnlyBm == 1 && btnType == 2 && nlevel != 1 )
     {
		 $("#bmPopContent #bzmc,#bmPopContent #zgldzw").css("display","none");
     }
	 
	 $("#bmPopFooter #i_save").click(function(){
		 var bmmc = $("#bmPopContent #bmmc input").val();
		 if(bmmc =="")
			 {
			   alert("请输入部门名称！");
			   return;
			 }
		 
		 var bzmc = $("#bmPopContent #bzmc select option:selected").text();
		 var bzmcDm = $("#bmPopContent #bzmc select option:selected").val();
		 var zgldzw = $("#bmPopContent #zgldzw select option:selected").val();
		 var bmxz = $("#bmPopContent #bmxz select option:selected").val();
		 $.ajax({
			 url:"/main/dwxx/whnsjgBmSave.aj",
			   type:"POST",
			   data:{isOnlyBm:isOnlyBm,bmmc:bmmc,bzmc:bzmc,bzmcDm:bzmcDm,zgldzw:zgldzw,bmxz:bmxz,fydm:$("#bmPopContent").attr("data-fydm"),bmbh:$("#bmPopContent").attr("data-bmbh"),lvlevel:$("#bmPopContent").attr("data-lvlevel"),btnType:$("#bmPopContent").attr("data-btnType")},
			   dataType:"html",
			   success:function(html){
				   if($.trim(html).match(/^success*/))
					   {
					     if(btnType == 0)
					    	 {
					    	   var result = html.trim().split("-");
					    	   $(".xzfy_bmbh").val(result[1]);
					    	   $(".xzfy_bmbh").attr("level",result[2]);
					    	   initDataTable($("#bmPopContent").attr("data-fydm"),result[1]);
						       $(".xzfy_ipt").val(bmmc);
					    	   alert("添加成功!");
					    	 }
					     if(btnType == 2)
				    	 {					    	 
					       initDataTable($("#bmPopContent").attr("data-fydm"),bmbh);
					       $(".xzfy_ipt").val(bmmc);
				    	   alert("更新成功！");
				    	 }
					     
					     $(".whnsjg_dlg").dialog("close");
					   }
				   if(html == 3)
					   {
					     alert("标准部门已经存在！");
					   }
				   if(html == 4)
					   {
					     alert("同一级别中已经存在这个部门！");
					   }
			   }
		 });
	 }); // save

	 $("#bmPopFooter #i_close").click(function(){
		 $(".whnsjg_dlg").dialog("close");
	 }); // close
  });
</script>
<div id="bmPop" class="popDialog">
<div id="bmPopContent" class="form-horizontal" data-fydm="${fydm}"  data-bmbh="${bmbh}"  data-lvlevel="${lvlevel}"  data-btnType="${btnType}"  data-nlevel="${nlevel}"  data-isOnlyBm="${isOnlyBm}">
    <div id="bmmc" class="form-group">
      <label class="control-label"><font color="red">*</font>部门名称：</label>
      <input class="form-control" type="text" name="bmName" value="${jgxx.CName}">
    </div>
    <div id="bzmc" class="form-group">
      <label class="control-label"><font color="red">*</font>标准名称：</label>
      <c:choose>
        <c:when test="${btnType == 0}">
           <select class="form-control">
            <c:forEach items="${bmbns}" var="bmbn">     
               <option value="${bmbn.NDm}">${bmbn.CMc}</option>
             </c:forEach>
            </select>
        </c:when>
        <c:otherwise>
           <p class="form-control-static">${jgxx.CStname}</p>
        </c:otherwise>
      </c:choose> 
    <div id="zgldzw" class="form-group">
        <label class="control-label"> 最高领导职务：</label>
	    <select class="form-control"> 
	       <c:forEach items="${zgldzws}" var="zgldzw">
	        <option value="${zgldzw.NDm}" <c:if test="${zgldzw.NDm == jgxx.NZgldzw}">selected="selected"</c:if> >${zgldzw.CMc}</option>
	      </c:forEach>
	    </select>
    </div>
    <div id="bmxz" class="form-group">
        <label class="control-label"><font color="red">*</font>部门性质：</label>
	    <select class="form-control"> 
	        <c:forEach items="${bmxz}" var="bmxz">
	        	<option value="${bmxz.NDm}" <c:if test="${bmxz.NDm == jgxx.NBmxz}">selected="selected"</c:if> >${bmxz.CMc}</option>
	      	</c:forEach>
	    </select>
    </div>
</div>
<div id="bmPopFooter" class="bottom-btn-bar">
	<div class="btn-group">
		<button id="i_save" class="btn btn-primary" data-type="${btnType}">
			<span class="glyphicon glyphicon-ok"></span> 保存
		</button>
		<button id="i_close" class="btn btn-default">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>
</div>
</div>
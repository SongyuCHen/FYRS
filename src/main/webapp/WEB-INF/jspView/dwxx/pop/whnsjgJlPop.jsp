<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
  .c-display
  {
    display: block;
  }
  .u-display
  {
    display: none;
  }
</style>
<script type="text/javascript">
  $(function(){
	  var btnType = $("#jl-content").data("btntype");
	  $("#jlsj-date").datepicker();	
	  if(btnType == 0)
		  {		    
		    $("#jlsj-date").datepicker("setDate",new Date());	  
		  }
	  var showJlbmOrNot = function()
	  {
		  var valSelcted = $("#qyjl select option:selected").val();
		  if(valSelcted == -1 || valSelcted == 2)
			  {
			     $("#jlbm").removeClass("u-display");
			     $("#jlbm").addClass("c-display");
			  }
		  if(valSelcted == 1)
			  {
			     $("#jlbm").removeClass("c-display");
			     $("#jlbm").addClass("u-display");
			  }
	  };
	  if(btnType == 2)
		  {		
		   //  $("#jlmc input:first").val($("#jl-content").data("cjlmc"));
		  $("#qyjl option:[value="+$("#jl-content").data("nqyjl")+"]").attr("selected",true);
		  $("#jlbm option:[value="+$("#jl-content").data("njlbm")+"]").attr("selected",true);
		  $("#jtjllb option:[value="+$("#jl-content").data("njtjllb")+"]").attr("selected",true);
		  $("#jlyy option:[value="+$("#jl-content").data("njlyy")+"]").attr("selected",true);
		  $("#jljb option:[value="+$("#jl-content").data("njljb")+"]").attr("selected",true);
		  $("#pzdw input:first").val($("#jl-content").data("cpzdw"));
		  $("#pzwh input:first").val($("#jl-content").data("cpzwh"));
		  var jlsj_g = $("#jl-content").data("djlsj");
		  if(jlsj_g.trim() != "")
			  {
			   $("#jlsj input:first").val(jlsj_g.trim().split(" ")[0]);
			  }		
		  $("#jl-bz textarea").val($("#jl-content").data("cbz"));
		  
		  showJlbmOrNot();
		  }
	 
	 
	  
	  $("#qyjl select").change(function(){
		  showJlbmOrNot();
	  });
	 
	  $("#jl-footer #i_save").click(function(){
		 var fydm = $(".xzfy_fybh").val().trim();
		 var qyjl = $("#qyjl option:selected").val().trim();
		 var jlbm = $("#jlbm option:selected").val().trim();
		 var unicode = $("#jl-content").data("unicode").trim();
		 if( unicode != "")
		 {
			 jlbm = unicode;
		 }	 
		 var jtjllb = $("#jtjllb option:selected").val().trim();
		 var jlyy = $("#jlyy option:selected").val().trim();
		 var jljb = $("#jljb option:selected").val().trim();
		 var jlmc = $("#jlmc input:first").val().trim();
		 var pzdw = $("#pzdw input:first").val().trim();
		 var pzwh = $("#pzwh input:first").val().trim();
		 var jlsj = $("#jlsj input:first").val().trim();
		 var jlbz = $("#jl-bz textarea").val().trim();
		 if(qyjl == -1)
			 {
			   alert("请选择是否为全院奖励！");
			   return;
			 }
		 $.ajax({
	   		   url : "/main/dwxx/saveJlxx.aj",
	 				type : 'POST',
	 				dataType : 'html',
	 				data :{fydm:fydm,qyjl:qyjl,jlbm:jlbm,jtjllb:jtjllb,jlyy:jlyy,jljb:jljb,pzdw:pzdw,pzwh:pzwh,jlsj:jlsj,jlbz:jlbz,jlmc:jlmc,btnType:btnType,nid:$("#jl-content").data("nid")},
	 				success : function(html) { 
	 					if(html.trim().match(/^success*/))
	 					{
	 						var jlbmText= $("#jlbm option:selected").text();
	 						if(qyjl == 1)
	 							{
	 							  jlbmText = "";
	 							  // 如果是全院奖励，那么部门编号是 0 
	 							  jlbm = 0;
	 							}
	 						var jtjllbText = $("#jtjllb option:selected").text();	 						
	 						var jlyyText = $("#jlyy option:selected").text();
	 						var jljbText = $("#jljb option:selected").text();
	 						
	 						if(btnType == 0)
	 							{
	 							var strs = html.trim().split("-");		 						
		 						var operHtml = '<a class="dlg_modify" data-btnType="2" href="javascript:void(0)">修改</a><span>|</span> <a class="i_delete" href="javascript:void(0)">删除</a>';
		 						var maxIndex = $("#dataTable").data("maxlength")+1;
		 						$roles_oTable.fnAddData([maxIndex,$(".xzfy_ipt").val(),$("#qyjl option:selected").text(),jlbmText,jtjllbText,jlyyText,jljbText,jlsj,operHtml]);
		 						var tr = $roles_oTable.$("tr:last");	 						
		 						tr.children("td:last").attr("data-fyDm",fydm);
		 						tr.children("td:last").attr("data-bmbh",jlbm);
		 						tr.children("td:last").attr("data-nid",strs[1]);
		 						alert("添加成功 ！");
	 							}
	 						if(btnType == 2)
	 							{
	 							 $current_node=$("#whjlxx_list #dataTable tbody .active");
								 $current_node.find("td:nth-child(2)").text($(".xzfy_ipt").val());
								 $current_node.find("td:nth-child(3)").text($("#qyjl option:selected").text());
								 $current_node.find("td:nth-child(4)").text(jlbmText);
								 $current_node.find("td:nth-child(5)").text(jtjllbText);
								 $current_node.find("td:nth-child(6)").text(jlyyText);
								 $current_node.find("td:nth-child(7)").text(jljbText);
								 $current_node.find("td:nth-child(8)").text(jlsj);
								 $current_node.find("td:nth-child(9)").attr("data-bmbh",jlbm);
	 							}
	 						
	 						
	 						$(".whnsjgJl_dlg").dialog('close');
	 					}		  
	 				}
	   	   });
	  });
	  $("#jl-footer #i_close").click(function(){
		 
	  });
  });
  
</script>
<div id="jlPop" class="popDialog">
  <div id="jl-content" class="form-horizontal" data-nid = "${jlwh.NId}"  data-nfy = "${jlwh.NFy}"  data-nqyjl = "${jlwh.NQyjl}"  data-njlbm = "${jlwh.NJlbm}"  data-njtjllb = "${jlwh.NJtjllb}"  data-cjlmc = "${jlwh.CJlmc}"  data-njlyy = "${jlwh.NJlyy}"  data-njljb = "${jlwh.NJljb}"  data-cpzdw = "${jlwh.CPzdw}"  data-cpzwh = "${jlwh.CPzwh}"  data-djlsj = "${jlwh.DJlsj}"  data-cbz = "${jlwh.CBz}" data-btnType="${btnType}" data-unicode="${unicode}">
     <div id="jlmc" class="form-group">
        <label class="control-label">奖励名称：</label>
        <input class="input-sm form-control" type="text" value="${jlwh.CJlmc}">
     </div>
     <div id="qyjl" class="form-group">
        <label class="control-label"><font color="red">*</font>全院奖励：</label>
        <select class="input-sm form-control">
           <option value="0"></option>
            <c:forEach items="${shqyjls}" var="shqyjl">     
               <option value="${shqyjl.NDm}">${shqyjl.CMc}</option>
             </c:forEach>
        </select>
     </div>
     <div id="jlbm" class="form-group">
        <label class="control-label"><font color="red">*</font>奖励部门：</label>
        <select class="input-sm form-control">
           <option value="0"></option>
            <c:forEach items="${jgxxs}" var="jgxx">     
               <option value="${jgxx.NCode}">${jgxx.CName}</option>
             </c:forEach>
        </select>
     </div>
      <div id="jtjllb" class="form-group">
          <label class="control-label">集体奖励类别：</label>
           <select class="input-sm form-control">
           <option value="0"></option>
            <c:forEach items="${jtjllbs}" var="jtjllb">     
               <option value="${jtjllb.NDm}">${jtjllb.CMc}</option>
             </c:forEach>
            </select>
     </div>
      <div id="jlyy" class="form-group">
            <label class="control-label">奖励原因：</label>
           <select class="input-sm form-control">
           <option value="0"></option>
            <c:forEach items="${jlyys}" var="jlyy">     
               <option value="${jlyy.NDm}">${jlyy.CMc}</option>
             </c:forEach>
            </select>
     </div>
      <div id="jljb" class="form-group">
        <label class="control-label"><font color="red">*</font>奖励级别：</label>
           <select class="input-sm form-control">
            <c:forEach items="${jljbs}" var="jljb">     
               <option value="${jljb.NDm}">${jljb.CMc}</option>
             </c:forEach>
            </select>
     </div>
     <div id="pzdw" class="form-group">
     	<label class="control-label">批准单位：</label>
     	<input class="input-sm form-control" type="text">
     </div>
     <div id="pzwh" class="form-group">
     	<label class="control-label">批准文号：</label>
     	<input class="input-sm form-control" type="text">
     </div>
     <div id="jlsj" class="form-group">
     	<label class="control-label"> 奖励时间：</label>
     	<input class="input-sm form-control" type="text" id="jlsj-date">
     </div>
     <div id="jl-bz" class="form-group">
     	<label class="control-label">备注 ：</label>
     	<textarea class="input-sm form-control" name="" rows="2" cols="10" ></textarea>
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
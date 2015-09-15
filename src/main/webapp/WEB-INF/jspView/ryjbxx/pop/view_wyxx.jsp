<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	$(function(){
		$type="${btnType}";
		if($type!=1){
			$zdybq.changeDateFromLabelToPicker();
			$zdybq.changeFromLabelToInput();
			$zdybq.changeToSelect();
			$zdybq.changeAreaToEdit();
			$zdybq.updateKeyValue($type);
			
			$("#i_save").parent().show();
			$("#i_close").parent().prop("colspan","2");
		}else {
			$(".my_input_s").css({
				"border" : "0px"
			});
			$(".my_input_s").show();
			$(".my_select_s").hide();
			$("#i_save").parent().hide();
			$(".my_input_s,.myLabel").attr("readonly", "readonly");
		};
	});
</script>
<table id="wyxx_table" data-keyid="${wyxx.NId}" data-fydm="${wyxx.NFy}" data-rybh="${wyxx.NRybh}">
	<tr>
		<td class="odd_td"><span style="color:red">*</span>外语语种：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmWyyz}" var="listDmWyyz">
						<option value="${listDmWyyz.NDm}" ${listDmWyyz.CMc==wyxx.NWyyz?'selected="selected"':""}>${listDmWyyz.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${wyxx.NWyyz }" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>熟练程度：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmSlcd}" var="listDmSlcd">
						<option value="${listDmSlcd.NDm}" ${listDmSlcd.CMc==wyxx.NSlcd?'selected="selected"':"" }>${listDmSlcd.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value=${wyxx.NSlcd } />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">水平级别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s">
					<c:forEach items="${listDmSpjb}" var="listDmSpjb">
						<option value="${listDmSpjb.NDm}" ${listDmSpjb.CMc==wyxx.NSpjb?'selected="selected"':""}>${listDmSpjb.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${wyxx.NSpjb }" />
			</div></td>
	</tr>
</table>
<div class="bottom-btn-bar">
	<div class="btn-group">
		<button id="i_save" class="btn btn-primary" data-type="${btnType}">
			<span class="glyphicon glyphicon-save"></span> 保存
		</button>
		<button id="i_close" class="btn btn-default">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>
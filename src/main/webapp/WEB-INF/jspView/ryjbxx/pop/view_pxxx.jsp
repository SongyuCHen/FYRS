<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/zdybq.js"></script>
<script type="text/javascript">
	//检查时间格式
	function checkTime(str){
		var reg = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/;
		return reg.test(str);
	}
	//检查为正整数
	function checkInteger(str){
		var reg = /^[0-9]*[1-9][0-9]*$/;
		return reg.test(str);
	}	
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
			$(".my_input_s,.myLabel,.myDate_label").attr("readonly","readonly");
		};
		
		$("#checkNum").change(function() {
			//检查必填项是否已经填写完整：true.填写完整 false.不完整
			if ($("#checkNum").val() != "") {
				if (!checkInteger($("#checkNum").val())) {
					$(".J_dlg").html('<p>学制必须为正整数</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}

			}
		});

		$("#checkDate1").change(function() {
			var str = $(this).val();
			if (str != "") {
				if (!checkTime(str)) {
					$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}
			}
		});
		
		$("#checkDate2").change(function() {
			var str = $(this).val();
			if (str != "") {
				if (!checkTime(str)) {
					$(".J_dlg").html('<p>时间格式不正确</p>').dialog({
						'buttons' : {
							'确定' : function() {
								$(".J_dlg").dialog("close");
							}
						}
					}).dialog("open");
				}
			}
		});
	});
</script>
<table id="pxxx_table" data-keyid="${pxxx.NId}" data-fydm="${pxxx.NFy}" data-rybh="${pxxx.NRybh}">
	<tr style="height:30px">
		<td class="odd_td"><span style="color:red">*</span>培训形式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NPxxs">
					<c:forEach items="${listDmPxxs}" var="listDmPxxs">
						<option value="${listDmPxxs.NDm}" ${listDmPxxs.CMc==pxxx.NPxxs?'selected="selected"':""}>${listDmPxxs.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${pxxx.NPxxs}" />
			</div></td>
		<td class="odd_td"></td>
		<td class="even_td"></td>
	</tr>
	<tr>
		<td class="odd_td"><span style="color:red">*</span>开始日期：</td>
		<td class="even_td"><input type="text" id="checkDate1" class="myDate_label keyValue plxgUp" name="DKsrq" value="${pxxx.DKsrq }" /></td>
		<td class="odd_td"><span style="color:red">*</span>结束日期：</td>
		<td class="even_td"><input type="text" id="checkDate2" class="myDate_label keyValue plxgUp" name="DJsrq" value="${pxxx.DJsrq }" /></td>
	</tr>
	<tr style="height:30px">
		<td class="odd_td">机构类别：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgup" name="NJglb">
					<c:forEach items="${listDmJgzl}" var="listDmJgzl">
						<option value="${listDmJgzl.NDm}" ${listDmJgzl.CMc==pxxx.NJglb?'selected="selected"':""}>${listDmJgzl.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${pxxx.NJglb }" />
			</div></td>
		<td class="odd_td"></td>
		<td class="even_td"></td>
	</tr>
	<tr>
		<td class="odd_td">培训机构：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CQtjglb"  value="${pxxx.CQtjglb }"/></td>
		<td class="odd_td">培训班名称：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPxbmc"  value="${pxxx.CPxbmc}"/></td>
	</tr>
	<tr>
		<td class="odd_td">专业：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NZy">
					<c:forEach items="${listDmZy}" var="listDmZy">
						<option value="${listDmZy.NDm}" ${listDmZy.CMc==pxxx.NZy?'selected="selected"':""}>${listDmZy.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${pxxx.NZy }" />
			</div></td>
		<td class="odd_td">学制：</td>
		<td class="even_td"><input type="text" id="checkNum" class="myLabel plxgUp" name="NXz"  value="${pxxx.NXz}"/></td>
	</tr>
	<tr>
		<td class="odd_td">培训成绩：</td>
		<td class="even_td"><input type="text" class="myLabel plxgUp" name="CPxcj"  value="${pxxx.CPxcj }"/></td>
		<td class="odd_td">培训方式：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NPxfs">
					 <c:forEach items="${listDmPxfs}" var="listDmPxfs">
				    	<option value="${listDmPxfs.NDm}" ${listDmPxfs.CMc==pxxx.NPxfs?'selected="selected"':"" }>${listDmPxfs.CMc}</option>
				    </c:forEach>
				</select> <input type="text" class="my_input_s" value="${pxxx.NPxfs }" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">培训种类：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NPxzl">
				   <c:forEach items="${listDmPxzl}" var="listDmPxzl">
						<option value="${listDmPxzl.NDm}" ${listDmPxzl.CMc==pxxx.NPxzl?'selected="selected"':"" }>${listDmPxzl.CMc}</option>
					</c:forEach>
				</select> <input type="text" class="my_input_s" value="${pxxx.NPxzl }" />
			</div></td>
		<td class="odd_td">取得合格证书：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NSfqdzs">
					<option value="1" ${pxxx.NSfqdzs=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${pxxx.NSfqdzs=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${pxxx.NSfqdzs }" />
			</div></td>
	</tr>
	<tr>
		<td class="odd_td">同步简历信息：</td>
		<td class="even_td"><div class="mySelect">
				<select class="my_select_s plxgUp" name="NTbjl">
					<option value="1" ${pxxx.NTbjl=="是"?'selected="selected"':"" }>是</option>
					<option value="2" ${pxxx.NTbjl=="否"?'selected="selected"':"" }>否</option>
				</select> <input type="text" class="my_input_s" value="${pxxx.NTbjl }" />
			</div></td>
		<td class="odd_td"></td>
		<td class="even_td"></td>
	</tr>
</table>
<div class="bottom-btn-bar">
	<div class="btn-group">
		<button id="i_save" class="btn btn-primary" data-type="${btnType}">
			<span class="glyphicon glyphicon-save"></span> 保存
		</button>
		<button id="i_close" class="btn btn-default" data-type="${btnType}">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<style>
<!--
.gf_table_6_info td {
	line-height: 18px;
	padding: 8px 0 8px 0px;
	white-space: nowrap;
}

.gf_huaming_left_info {
	padding: 5px 5px 5px 10px;
}
.gf_tijiao{
	text-align:center;
}
-->
</style>
<script type="text/javascript">
	$(function() {
		$(".gf_tijiao #i_close").die().live('click', function() {
			$("#jbbbxz_dlg").dialog("close");
		});
		$("#i_print").die().live('click', function() {
			var selectList = $("#reportCoverContent input:checkbox[checked]");
			var numList = new Array();
			for(var i=0;i<selectList.length;i++){
				numList[i]=selectList.eq(i).val();
			}
			
			if(numList.length!=0){
				window.open("/main/ryxx/dyjbbb.do?showKey="+$(".gf_tijiao").data("showkey")+"&&numList="+numList);
			}else{
				alert("请选择要生成的报表！");
			}
		});
	});
	var childChoose = function(childElement) {
		var parentId = $(childElement).attr("parentBox");
		if ($(childElement).attr("checked")) {
			$("#" + parentId).attr('checked', true);
		} else {
			var allFalse = true;
			$("input[parentBox=" + parentId + "]").each(function() {
				if ($(this).attr('checked')) {
					allFalse = false;
				}
			});
			if (allFalse) {
				$("#" + parentId).attr('checked', false);
			}
		}

	};
	var parentChoose = function(parentElement) {
		if ($(parentElement).attr('checked')) {
			$("input[parentBox=" + $(parentElement).attr("id") + "]").attr(
					'checked', true);
		} else {
			$("input[parentBox=" + $(parentElement).attr("id") + "]").attr(
					'checked', false);
		}

	};
</script>
<div id="reportCoverContent">
	<table width="99%" border="0" cellspacing="3" cellpadding="0"
		class="gf_table_6_info">
		<tr>
			<td rowspan="2"><p class="nbold">
					<input name="chooseBox" id='1' type="checkbox" value="1"
						onclick="parentChoose(this)" /> 干部信息表
				</p>
				<div class="gf_huaming_left_info">
					<p>
						<input name="chooseBox" type="checkbox" value="1_1" parentBox="1"
							onclick="childChoose(this)" /> 封面
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_2" parentBox="1"
							onclick="childChoose(this)" /> 说明
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_3" parentBox="1"
							onclick="childChoose(this)" /> 第一页 基本情况
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_4" parentBox="1"
							onclick="childChoose(this)" /> 第二页 主要家庭成员及社会关系
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_5" parentBox="1"
							onclick="childChoose(this)" /> 第三页 参加工作前后履历
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_6" parentBox="1"
							onclick="childChoose(this)" /> 第四页 奖惩情况及出国情况
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="1_7" parentBox="1"
							onclick="childChoose(this)" /> 第五页 其他需要说明的情况
					</p>
				</div>
			</td>
			<td valign="top"><p class="nbold">
					<input name="chooseBox" id='2' type="checkbox" value="2"
						onclick="parentChoose(this)" /> 干部任免审批表
				</p>
				<div class="gf_huaming_left_info">
					<p>
						<input name="chooseBox" type="checkbox" value="2_1" parentBox="2"
							onclick="childChoose(this)" /> 正面
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="2_2" parentBox="2"
							onclick="childChoose(this)" /> 背面
					</p>
				</div>
			</td>
		</tr>
		<tr>
			<td valign="top"><p class="nbold">
					<input name="chooseBox" id='3' type="checkbox" value="3"
						onclick="parentChoose(this)" /> 国家机关事业单位工作人员工资审核表
				</p>
				<div class="gf_huaming_left_info">
					<p>
						<input name="chooseBox" type="checkbox" value="3_1" parentBox="3"
							onclick="childChoose(this)" /> 正面
					</p>
				</div>
			</td>
		</tr>
		<tr>
			<td width="50%"><p class="nbold">
					<input name="chooseBox" id='4' type="checkbox" value="4"
						onclick="parentChoose(this)" /> 首次评定授予司法警察警衔审批表
				</p>
				<div class="gf_huaming_left_info">
					<p>
						<input name="chooseBox" type="checkbox" value="4_1" parentBox="4"
							onclick="childChoose(this)" /> 封面
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="4_2" parentBox="4"
							onclick="childChoose(this)" /> 第一页 基本情况及历任主要职务
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="4_3" parentBox="4"
							onclick="childChoose(this)" /> 第二页 组织鉴定
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="4_4" parentBox="4"
							onclick="childChoose(this)" /> 第三页 单位意见及备注
					</p>
				</div>
			</td>
			<td width="50%" valign="top"><p class="nbold">
					<input name="chooseBox" id='5' type="checkbox" value="5"
						onclick="parentChoose(this)" /> 司法警察警衔变动审批表
				</p>
				<div class="gf_huaming_left_info">
					<p>
						<input name="chooseBox" type="checkbox" value="5_1" parentBox="5"
							onclick="childChoose(this)" /> 正面
					</p>
					<p>
						<input name="chooseBox" type="checkbox" value="5_2" parentBox="5"
							onclick="childChoose(this)" /> 背面
					</p>
				</div>
			</td>
		</tr>
	</table>
	<div class="gf_tanchu_line"></div>
	<div class="gf_tijiao" data-showKey=${showKey}>
		<button type="button" class="btn btn-primary btn-sm" id="i_print">
			<span class="glyphicon glyphicon-print"></span> 打印
		</button>
		<button type="button" class="btn btn-primary btn-sm" id="i_close">
			<span class="glyphicon glyphicon-remove"></span> 关闭
		</button>
	</div>
</div>

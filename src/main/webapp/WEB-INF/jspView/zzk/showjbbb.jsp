<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="../../lib/spring.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<script type="text/javascript"
	src="/resources/js/jquery/jquery-1.7.1.min.js"></script>
<head>
<style type="text/css">
html,body {
	border: 0;
	margin: 0;
	overflow: auto;
}

* html {
	padding: 0;
}

.nright{
	float:right;
}

.ntextright{
	text-align:right;
}

.gf_dy_wai {
	width: 796px;
	margin: 0 auto;
}

.gf_dy_nei {
	width: 794px;
	height: 1125px;
	margin: 0 auto;
	border: 1px solid #000000;
}

.gf_dy_pad {
	padding: 37px 84px;
}

.gf_dy_table_1 {
	border: 1px solid #000000;
	border-collapse: collapse;
	margin: 0px auto;
	line-height: 25px;
}

.gf_dy_table_1 td {
	border: 1px #000000 solid;
	padding: 10px 8px 9px 8px;
	font-size: 19px;
	line-height: 25px;
}

.gf_dy_table_2 {
	margin: 0 auto;
}

.gf_dy_table_2 td {
	padding: 10px 8px 9px 8px;
	font-size: 21px;
}

.gf_dy_table_3 {
	margin: 0 auto;
}

.gf_dy_table_3 td {
	padding: 15px 8px 13px 8px;
	font-size: 19px;
	line-height: 42px;
}

.gf_dy_table_4 {
	border: 1px solid #000000;
	border-collapse: collapse;
	margin: 0px auto;
	line-height: 25px;
}

.gf_dy_table_4 td {
	border: 1px #000000 solid;
	padding: 2px 5px 2px 5px;
	font-size: 19px;
	line-height: 25px;
}

.gf_dy_table_5 {
	border: 1px solid #000000;
	border-collapse: collapse;
	margin: 0px auto;
	line-height: 25px;
}

.gf_dy_table_5 td {
	border: 1px #000000 solid;
	padding: 1px 5px 1px 5px;
	font-size: 14px;
	line-height: 22px;
}

.gf_dy_table_6 {
	border: 1px solid #000000;
	border-collapse: collapse;
	margin: 0px auto;
	line-height: 25px;
}

.gf_dy_table_6 td {
	border: 1px #000000 solid;
	padding: 5px 5px 5px 5px;
	font-size: 16px;
	line-height: 22px;
}

.gf_dy_line {
	border-bottom: 1px solid #000000;
}

.gf_biaoti_1 {
	font-size: 30px;
	text-align: center;
}

/*new-*/
.gf_head3_lf {
	height: 75px;
}

.gf_head3_lf1 {
	position: absolute;
	left: 25px;
	bottom: 16px;
	text-align: right;
	padding-left: 18px;
	color: #FFFFFF;
}

.gf_lianjie_hongcu2 a {
	color: #993400;
	font-weight: bold;
	text-decoration: underline;
}

.gf_lianjie_hongcu2 a:visited {
	color: #993400;
	font-weight: bold;
	text-decoration: underline;
}

.gf_lianjie_hongcu2 a:hover {
	color: #993400;
	font-weight: bold;
	text-decoration: underline;
}

.gf_lanmu11 {
	height: 32px;
	line-height: 32px;
}

.gf_tag5 {
	line-height: 32px;
	height: 32px;
	white-space: nowrap;
	text-align: left;
	padding: 0 0px;
}

.gf_tag5 a {
	float: left;
	padding: 0 10px 0 0px;
	color: #ffffff;
	text-decoration: none;
	margin-right: 3px;
}

.gf_tag5 a:visited {
	float: left;
	padding: 0 10px 0 0px;
	text-decoration: none;
	color: #465a72;
}

.gf_tag5 a:hover {
	float: left;
	padding: 0 10px 0 0px;
	color: #02659c;
	text-decoration: none;
}

.gf_tag5 a:hover span {
	color: #ffffff;
	font-weight: bold;
	padding: 10px 0px 10px 15px;
}

.gf_tag5 a span {
	padding: 10px 0px 10px 15px;
	font-weight: bold;
	color: #465a72;
	color: #a77447;
}

.gf_tag5 a.selected {
	float: left;
	padding: 0 10px 0 0px;
	color: #ffffff;
	text-decoration: none;
}

.gf_tag5 a.selected span {
	color: #ffffff;
	font-weight: bold;
	padding: 10px 0px 10px 15px;
}

.gf_bianji_main_xgxg {
	padding: 20px 40px;
	background: #f3eeda;
	font-size: 14px;
	line-height: 26px;
}

/*new-*/
/*djqr*/
.gf_bianji_djqr_wai {
	width: 960px;
	margin: 10px auto;
}

.gf_btn4_djqr {
	border-width: 0pt;
	color: #ffffff;
	height: 20px;
	margin: 0px 0pt 0pt 0px;
	padding-top: 0px;
	width: 68px;
	padding-right: 3px;
	cursor: pointer;
}
</style>
</head>
<script type="text/javascript">
	$(function(){
		var s = $(".gf_dy_wai").data("numlist");
		var strArray = new Array();
		strArray = s.split(",");
		var selectNums = new Array();
		for(var i=0,j=0;i<strArray.length;i++){
			if(strArray[i].match("_")!=null){
				selectNums[j]=strArray[i];
				j++;
			}
		}
		var $obj = $(".gf_dy_wai").children();
		$obj.hide();
		for(var i=0;i<selectNums.length;i++){
			$("#"+selectNums[i]).show();
		}
	});
</script>
<body>
	<div id="printDIV" class="gf_dy_wai" data-numlist="${numList}">

		<!--职工信息表-1（开始）-->
		<div class="gf_dy_nei" id="1_1" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:120px 0 235px 0">
					某市中级人民法院 <br />职工信息表
				</div>
				<table width="100" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_2" style="width:300px;">
					<tr>
						<td width="70" align="right" class="nbold">部门</td>
						<td width="200" class="gf_dy_line">${ryjbxxVO.NBm}</td>
					</tr>
					<tr>
						<td align="right" class="nbold">职务</td>
						<td class="gf_dy_line">${ryjbxxVO.NXzzw}</td>
					</tr>
					<tr>
						<td align="right" class="nbold">姓名</td>
						<td class="gf_dy_line">${ryjbxxVO.CXm}</td>
					</tr>
				</table>
				<table width="100" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_2" style="margin-top:148px;width:300px;">
					<tr>
						<td width="75" class="gf_dy_line">&nbsp;</td>
						<td width="38" align="right" class="nbold">年</td>
						<td width="47" class="gf_dy_line">&nbsp;</td>
						<td width="65" class="nbold">月制</td>
					</tr>
				</table>
			</div>
		</div>

		<!--职工信息表-1（结束）-->
		<!--职工信息表-2（开始）-->

		<div class="gf_dy_nei" id="1_2" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:83px 0 115px 0">说 明</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_3" style="">
					<tr>
						<td width="40" valign="top">一、</td>
						<td width="588">表内所列项目，要忠诚老实，实事求是地认真填写。如本人确实不能填写，可由别人代笔。</td>
					</tr>
					<tr>
						<td valign="top">二、</td>
						<td>表内项目，本人没有的，写“无”。书写时一律用钢笔，字迹要端正，清楚。填写时要参照《填写解释》。</td>
					</tr>
					<tr>
						<td valign="top">三、</td>
						<td>表内的年、月、日一律用公历。</td>
					</tr>
					<tr>
						<td valign="top">四、</td>
						<td>“相片”一律用近期一寸正面半身脱帽照。</td>
					</tr>
				</table>
			</div>
		</div>

		<!--职工信息表-2（结束）-->
		<!--职工信息表-3（开始） -->
		<div class="gf_dy_nei" id="1_3" name="PageBoder"
			style="page-break-after:always;">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:10px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_1" style="table-layout:fixed;">
					<tr>
						<td colspan="5" align="center">基本情况</td>
					</tr>
					<tr>
						<td width="87">姓    名</td>
						<td colspan="3">${ryjbxxVO.CXm}</td>
						<td width="109" rowspan="4"><img alt="个人图片"
							src="/photo.do?showKey=${showkey}" id="perPhoto" width="100px"
							height="140px"> <!-- 照片 --></td>
					</tr>
					<tr>
						<td>性    别</td>
						<td width="87">${ryjbxxVO.NXb}</td>
						<td width="88">出生日期</td>
						<td width="100">${ryjbxxVO.DCsrq}</td>
					</tr>
					<tr>
						<td>民    族</td>
						<td>${ryjbxxVO.NMz}</td>
						<td>工作日期</td>
						<td>${ryjbxxVO.DGzrq}</td>
					</tr>
					<tr>
						<td>政治面貌</td>
						<td>${ryjbxxVO.NZzmm}</td>
						<td>入党日期</td>
						<td>${ryjbxxVO.DZzmm}</td>
					</tr>
					<tr>
						<td>健康状况</td>
						<td colspan="2">${ryjbxxVO.NJkzk}</td>
						<td>婚姻状况</td>
						<td>${ryjbxxVO.NHyzk}</td>
					</tr>
					<tr>
						<td>职    务</td>
						<td colspan="2">${ryjbxxVO.NXzzw}</td>
						<td>现职日期</td>
						<td>${ryjbxxVO.DXzzwRzrq}</td>
					</tr>
					<tr>
						<td>级    别</td>
						<td colspan="2">${ryjbxxVO.NZj}</td>
						<td>现级日期</td>
						<td>${ryjbxxVO.DZjrq}</td>
					</tr>
					<tr>
						<td>专业职称</td>
						<td colspan="2">${zyjszwVO.NQdmc}</td>
						<td>评定日期</td>
						<td>${zyjszwVO.DPrrq}</td>
					</tr>
					<tr>
						<td>部    门</td>
						<td colspan="2">${ryjbxxVO.NBm}</td>
						<td>工作时间</td>
						<td>${ryjbxxVO.fygzhjnx}</td>
					</tr>
					<tr>
						<td>处（组室）</td>
						<td colspan="2"></td>
						<td>处（组室）日期</td>
						<td></td>
					</tr>
					<tr>
						<td>学    历</td>
						<td colspan="2">${ryjbxxVO.NXl}</td>
						<td>毕业日期</td>
						<td>${xlxxVO.DByrq}</td>
					</tr>
					<tr>
						<td>学    位</td>
						<td colspan="2">${ryjbxxVO.NXw}</td>
						<td>授予日期</td>
						<td>${ryjbxxVO.DHdxwrq}</td>
					</tr>
					<tr>
						<td>专    业</td>
						<td colspan="2">${ryjbxxVO.NZy}</td>
						<td>外    语</td>
						<td>${wyxx}</td>
					</tr>
					<tr>
						<td>毕业学校</td>
						<td colspan="4">${xlxxVO.CXxmc}</td>
					</tr>
					<tr>
						<td>社会兼职</td>
						<td colspan="4"></td>
					</tr>
					<tr>
						<td>籍    贯</td>
						<td colspan="4">${ryjbxxVO.CJg}</td>
					</tr>
					<tr>
						<td>出 生 地</td>
						<td colspan="4">${ryjbxxVO.CCsd}</td>
					</tr>
				</table>
			</div>
		</div>
		<!--职工信息表-3（结束） -->
		<!--职工信息表-4（开始）-->
		<div class="gf_dy_nei" id="1_4" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:10px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td colspan="8" align="center" style="font-size:24px;" width="600">主要家庭成员及社会关系</td>
					</tr>
					<tr>
						<td width="64" align="center">姓  名</td>
						<td width="31" align="center">性 别</td>
						<td width="73" align="center">出生<br /> 日期</td>
						<td width="64" align="center">与本人 关系</td>
						<td width="53" align="center">学历</td>
						<td width="52" align="center">政治 面貌</td>
						<td width="168" align="center">工作单位及职务</td>
						<td width="69" align="center">家庭住址</td>
					</tr>
					<c:forEach items="${jtxxVOs}" var="jtxxList">
						<tr>
							<td width="64" align="center">${jtxxList.CXm}</td>
							<td width="31" align="center"></td>
							<td width="73" align="center">${jtxxList.DCsrq}</td>
							<td width="64" align="center">${jtxxList.NYbrgx}</td>
							<td width="53" align="center"></td>
							<td width="52" align="center">${jtxxList.NZzmm}</td>
							<td width="168" align="center">${jtxxList.CDwjzw}</td>
							<td width="69" align="center">${jtxxList.CJtzz}</td>
						</tr>
					</c:forEach>


				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4" style="border-top:0px;">
					<tr>
						<td colspan="8" align="center"
							style="font-size:24px;border-top:0px;">学习培训简历</td>
					</tr>
					<tr>
						<td width="112" align="center">起始日期</td>
						<td width="71" align="center">学制</td>
						<td width="81" align="center">学历</td>
						<td width="81" align="center">专业</td>
						<td width="145" align="center">学校</td>
						<td width="91" align="center">学习形式</td>
					</tr>
					<c:forEach items="${pxxxVOs}" var="pxxxList">
						<tr>
							<td width="112" align="center">${pxxxList.DKsrq}-${pxxxList.DJsrq}</td>
							<td width="71" align="center">${pxxxList.NXz}</td>
							<td width="81" align="center"></td>
							<td width="81" align="center">${pxxxList.NZy}</td>
							<td width="145" align="center">${pxxxList.CPxjg}</td>
							<td width="91" align="center">${pxxxList.NPxfs}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!--职工信息表-4（结束）-->


		<!--职工信息表-5（开始）-->
		<div class="gf_dy_nei" id="1_5" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td colspan="5" align="center" style="font-size:24px;">参加工作前后履历</td>
					</tr>
					<tr>
						<td width="78" align="center">起止日期</td>
						<td width="252" align="center">单位</td>
						<td width="78" align="center">职务</td>
						<td width="78" align="center">职级</td>
						<td width="78" align="center">证明人</td>
					</tr>
					<c:forEach items="${jlxxVOs}" var="jlxxList">
						<tr>
							<td width="78" align="center">${jlxxList.DQsrq}-${jlxxList.DJzrq}</td>
							<td width="252" align="center">${jlxxList.CSzdw }</td>
							<td width="78" align="center">${jlxxList.CZw}</td>
							<td width="78" align="center">${jlxxList.CZj}</td>
							<td width="78" align="center">${jlxxList.CZmr}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!--职工信息表-5（结束）-->


		<!--职工信息表-6（开始）-->
		<div class="gf_dy_nei" id="1_6" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td colspan="5" align="center" style="font-size:24px;">奖惩情况</td>
					</tr>
					<tr>
						<td width="80" align="center">日   期</td>
						<td width="125" align="center">何种奖惩</td>
						<td width="223" align="center">原因</td>
						<td width="141" align="center">奖惩单位</td>
					</tr>
					<c:forEach items="${jlixxVOs}" var="jlixxList">
						<tr>
							<td width="80" align="center">${jlixxList.DJlsj}</td>
							<td width="125" align="center">${jlixxList.NJllb}</td>
							<td width="223" align="center">${jlixxList.NJlyy}</td>
							<td width="141" align="center">${jlixxList.CPzdw}</td>
						</tr>
					</c:forEach>

				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4" style=" border-top:0px;">
					<tr>
						<td colspan="6" align="center"
							style="font-size:24px; border-top:0px;">出国（境）情况</td>
					</tr>
					<tr>
						<td width="78" align="center">起止日期</td>
						<td width="72" align="center">国别</td>
						<td width="109" align="center">出国身份</td>
						<td width="97" align="center">经费来源</td>
						<td width="212" align="center">出国目的</td>
					</tr>
					<c:forEach items="${cgxxVOs}" var="cgxxList">
						<tr>
							<td width="78" align="center">${cgxxList.DKssj}-${cgxxList.DJssj}</td>
							<td width="72" align="center">${cgxxList.NGb}</td>
							<td width="109" align="center">${cgxxList.NCgsf}</td>
							<td width="97" align="center">${cgxxList.CJfly}</td>
							<td width="212" align="center">${cgxxList.NCgxz}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!--职工信息表-6（结束）-->


		<!--职工信息表-7（开始）-->
		<div class="gf_dy_nei" id="1_7" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td align="center" style="border-top:0px; border-bottom:0px;">
							<p>&nbsp;</p>
							<p>&nbsp;</p> <span
							style="font-size:24px; text-decoration:underline;">其他需要说明的问题</span>
							<p>&nbsp;</p>
							<p>&nbsp;</p></td>
					</tr>
					<tr>
						<td style="border-top:0px;border-bottom:0px;">

							<p></p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p></p></td>
					</tr>
					<tr>
						<td><span class="nright" style="font-size:19px;"><p>&nbsp;</p>
								年 月 日</span>
							<p>&nbsp;</p>填表人签名盖章
							<p>&nbsp;</p>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--职工信息表-7（结束）-->


		<!--干部任免审批表-1（开始）-->
		<div class="gf_dy_nei" id="2_1" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 20px 0">干 部 任 免 审
					批 表</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4" style="layout:fixed">
					<tr>
						<td width="72" align="center">姓  名</td>
						<td width="80" align="center">${ryjbxxVO.CXm }</td>
						<td width="80" align="center">性别</td>
						<td width="81" align="center">${ryjbxxVO.NXb}</td>
						<td width="75" align="center">出生年月(岁)</td>
						<td width="70" align="center">${ryjbxxVO.DCsrq}</td>

					</tr>
					<tr>
						<td align="center">民  族</td>
						<td align="center">${ryjbxxVO.NMz}</td>
						<td align="center">籍贯</td>
						<td align="center">${ryjbxxVO.CJg}</td>
						<td align="center">出生地</td>
						<td>${ryjbxxVO.CCsd }</td>
					</tr>
					<tr>
						<td align="center">入  党<br /> 时  间</td>
						<td>${ryjbxxVO.DZzmm}</td>
						<td align="center">参加工作<br />时间</td>
						<td>${ryjbxxVO.DGzrq}</td>
						<td align="center">健康状况</td>
						<td>${ryjbxxVO.NJkzk}</td>
					</tr>
					<tr>
						<td align="center">专业技<br /> 术职务</td>
						<td colspan="2">${zyjszwVO.NQdmc}</td>
						<td align="center">熟悉专业<br /> 有何特长</td>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td rowspan="2" align="center">学  历<br /> 学  位</td>
						<td align="center">全日制 <br /> 教  育</td>
						<td colspan="2">${ryjbxxVO.NXl}&nbsp;${ryjbxxVO.NXw}</td>
						<td align="center">毕业院校系及专业</td>
						<td colspan="2">${xlxxVO.CXxmc}--${xlxxVO.CSxzy}</td>
					</tr>
					<tr>
						<td align="center">在  职<br /> 教  育</td>
						<td colspan="2">&nbsp;</td>
						<td align="center">毕业院校系及专业</td>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" align="center">现任职务</td>
						<td colspan="5">${ryjbxxVO.NXzzw}</td>
					</tr>
					<tr>
						<td colspan="2" align="center">拟任职务</td>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2" align="center">拟免职务</td>
						<td colspan="5">&nbsp;</td>
					</tr>
					<tr>
						<td align="center">简<br /> <br /> <br /> <br /> 历</td>
						<td colspan="6" valign="top" height="300px"><c:forEach
								items="${jlxxVOs}" var="jlxxList">
								${jlxxList.DQsrq}-${jlxxList.DJzrq}&nbsp;${jlxxList.CSzdw }&nbsp;${jlxxList.CZw}&nbsp;${jlxxList.CZj}&nbsp;${jlxxList.CZmr}</br>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td align="center">奖惩<br /> 情况</td>
						<td colspan="6"><c:forEach items="${jlixxVOs}"
								var="jlixxList">
									${jlixxList.DJlsj}&nbsp;${jlixxList.NJllb}&nbsp;${jlixxList.NJlyy}&nbsp;${jlixxList.CPzdw}</br>
							</c:forEach></td>
					</tr>
				</table>
			</div>
		</div>
		<!--干部任免审批表-1（结束）-->


		<!--干部任免审批表-2（开始）-->
		<div class="gf_dy_nei" id="2_2" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td align="center">年度考</br>核结果</td>
						<td colspan="6"><c:forEach items="${khxxVOs}" var="khxxList">
									${khxxList.NNd}&nbsp;${khxxList.NKhjg}</br>
							</c:forEach></td>
						</td>
					</tr>
					<tr>
						<td align="center">任<br /> 免<br /> 理<br /> 由</td>
						<td colspan="6"><br /> <br /> <br /></td>
					</tr>
					<tr>
						<td width="85" rowspan="9" align="center">主要家庭成员及社会关系</td>
						<td colspan="1" align="center">称 谓</td>
						<td colspan="1" align="center">姓 名</td>
						<td colspan="1" align="center">出生年月</td>
						<td colspan="1" align="center">政治面貌</td>
						<td colspan="2" align="center">工作单位及职务</td>
					</tr>
					<c:forEach items="${jtxxVOs}" var="jtxxList">
						<tr>
							<td colspan="1" align="center">${jtxxList.NYbrgx}</td>
							<td colspan="1" align="center">${jtxxList.CXm}</td>
							<td colspan="1" align="center">${jtxxList.DCsrq}</td>
							<td colspan="1" align="center">${jtxxList.NZzmm}</td>
							<td colspan="2" align="center">${jtxxList.CDwjzw}</td>
						</tr>
					</c:forEach>


					<tr>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
					</tr>

					<tr>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="1">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
					</tr>



					<tr>
						<td align="center">呈<br /> 报<br /> 单<br /> 位</td>
						<td colspan="5"><br /> <br /> <br />
							<div class="ntextright" style=" font-size:19px;">年 月 日</div></td>
					</tr>
					<tr>
						<td align="center">审意<br /> 批机<br /> 关见</td>
						<td colspan="3"><br /> <br />
							<div class="ntextright" style=" font-size:19px;">年 月 日</div></td>
						<td align="center">行 机<br /> 政 关<br /> 任 意<br /> 免 见</td>
						<td><br /> <br />
							<div class="ntextright" style=" font-size:19px;">年 月 日</div></td>
					</tr>
				</table>
			</div>
		</div>
		<!--干部任免审批表-2（结束）-->


		<!--工资审批表-1（开始）-->
		<div class="gf_dy_nei" id="3_1" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<!--     	  <div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div> -->
				<div class="gf_biaoti_1" style="margin:0px 0 20px 0">国家机关事业单位工作人员工资审批表</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_5" style="border-bottom:0px;">
					<tr>
						<td width="32" align="center" style="border-bottom:0px;">姓<br />
							名</td>
						<td width="98" style="border-bottom:0px;">${ryjbxxVO.CXm}</td>
						<td width="32" align="center" style="border-bottom:0px;">性<br />
							别</td>
						<td width="45" style="border-bottom:0px;">${ryjbxxVO.NXb }</td>
						<td width="90" align="center" style="border-bottom:0px;">出生年月
						</td>
						<td width="92" style="border-bottom:0px;">${ryjbxxVO.DCsrq}</td>
						<td width="81" align="center" style="border-bottom:0px;">文化程度</td>
						<td width="135" style="border-bottom:0px;">${xlxxVO.NXl}</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_5" style="border-bottom:0px;">
					<tr>
						<td width="90" align="center" nowrap="nowrap">何时何校</br>毕&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</td>
						<td width="83">${xlxxVO.DByrq}&nbsp;${xlxxVO.CXxmc}</td>
						<td width="52" align="center">参加工作年月</td>
						<td width="81">${ryjbxxVO.DGzrq}</td>
						<td width="81" align="center">工作年限</br>(含连续工龄)</td>
						<td width="45">${ryjbxxVO.fygzhjnx}</td>
						<td width="70" align="center">从事教师、护士</br>工作年限</td>
						<td width="42">&nbsp;</td>
					</tr>
					<tr>
						<td align="center" style="border-bottom:0px;">现职务(含技术工种)</td>
						<td colspan="2" style="border-bottom:0px;">${ryjbxxVO.NXzzw}</td>
						<td align="center" style="border-bottom:0px;">任职年月</td>
						<td align="center" width="72" style="border-bottom:0px;">${ryjbxxVO.DXzzwRzrq}</td>
						<td width="70" align="center" style="border-bottom:0px;">原任职务<br />
							及时间</td>
						<td colspan="3" align="center" style="border-bottom:0px;"><br />
						</td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_5">
					<tr>
						<td width="26" rowspan="14" align="center">改<br /> 革<br />
							前<br /> 工<br /> 资</td>
						<td width="100" align="center">工资区类别</td>
						<td width="49" align="center">&nbsp;</td>
						<td width="26" rowspan="14" align="center">现<br /> 行<br />
							工<br /> 资</td>
						<td colspan="2" align="center">基础工资</td>
						<td width="52" align="center">&nbsp;</td>
						<td width="26" rowspan="14" align="center">变<br /> 动<br />
							后<br /> 工<br /> 资</td>
						<td colspan="2" align="center">基 础 工 资</td>
						<td width="42">&nbsp;</td>
					</tr>
					<tr>
						<td align="center">工资标准名称</td>
						<td align="center">&nbsp;</td>
						<td width="74" rowspan="3" align="center">职务<br /> (岗位)<br />
							工资</td>
						<td width="79">档 次</td>
						<td align="center">&nbsp;</td>
						<td width="74" rowspan="3" align="center">职务<br /> (岗位)<br />
							工资</td>
						<td width="76" align="center">档 次</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">等级</td>
						<td align="center">&nbsp;</td>
						<td>工资额</td>
						<td align="center">&nbsp;</td>
						<td align="center">工资额</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">基职(岗<br /> 位)工资</td>
						<td align="center">&nbsp;</td>
						<td>提高10%</td>
						<td align="center">&nbsp;</td>
						<td align="center">提高10%</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">工 龄 津 贴</td>
						<td align="center">&nbsp;</td>
						<td rowspan="2" align="center">级别<br /> 工资<br /> (技术<br />
							等级)</td>
						<td>级  别</td>
						<td align="center">&nbsp;</td>
						<td rowspan="2" align="center">级别<br /> 工资<br /> (技术<br />
							等级)</td>
						<td align="center">级  别</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">奖      金</td>
						<td align="center">&nbsp;</td>
						<td>工资额</td>
						<td align="center">&nbsp;</td>
						<td align="center">工资额</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">物价福利性<br /> 补 贴</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">工龄工资(奖金)</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">工龄工资(奖金)</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td align="center">其他津贴补贴</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">津       贴</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">津       贴</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">教、护龄津贴</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">教、护龄津贴</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">见习期熟练期工资</td>
						<td align="center">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>保 留 工 资</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">&nbsp;</td>
						<td align="center">&nbsp;</td>
						<td colspan="2">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>合     计</td>
						<td align="center">&nbsp;</td>
						<td colspan="2" align="center">合     计</td>
						<td align="center">&nbsp;</td>
						<td colspan="2">合     计</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5">单位意见：<br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:14px;">年 月 日</div></td>
						<td colspan="6">主管部门意见：<br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:14px;">年 月 日</div></td>
					</tr>
				</table>
			</div>
		</div>
		<!--工资审批表-1（结束）-->


		<!--首次评定授予司法警察警衔审批表-1（开始）-->
		<div class="gf_dy_nei" id="4_1" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:120px 0 235px 0">首次评定授予司法警察警衔审批表</div>
				<table width="100" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_2" style="width:400px;">
					<tr>
						<td width="108" align="right" class="nbold">姓 名</td>
						<td width="270" class="gf_dy_line">${ryjbxxVO.CXm }</td>
					</tr>
					<tr>
						<td align="right" class="nbold">工作单位</td>
						<td class="gf_dy_line">${dwmc}</td>
					</tr>
					<tr>
						<td align="right" class="nbold">职 务</td>
						<td class="gf_dy_line">${ryjbxxVO.NXzzw}</td>
					</tr>
				</table>
				<table width="100" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_2" style="margin-top:148px;width:225px;">
					<tr>
						<td width="84" class="gf_dy_line">&nbsp;</td>
						<td width="38" align="right" class="nbold">年</td>
						<td width="58" class="gf_dy_line">&nbsp;</td>
						<td width="45" class="nbold">月</td>
					</tr>
				</table>
			</div>
		</div>
		<!--首次评定授予司法警察警衔审批表-1（结束）-->


		<!--首次评定授予司法警察警衔审批表-2（开始）-->
		<div class="gf_dy_nei" id="4_2" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_6">
					<tr>
						<td width="160" align="center">姓 名</td>
						<td width="91">${ryjbxxVO.CXm}</td>
						<td width="60" align="center">性 别</td>
						<td width="39">${ryjbxxVO.NXb}</td>
						<td width="107" align="center">民 族</td>
						<td width="167">${ryjbxxVO.NMz}</td>
					</tr>
					<tr>
						<td align="center">出生年月</td>
						<td colspan="3">${ryjbxxVO.DCsrq}</td>
						<td align="center">文化程度</td>
						<td>${ryjbxxVO.NXl}</td>
					</tr>
					<tr>
						<td align="center">参加工作时间</td>
						<td colspan="3">${ryjbxxVO.DGzrq}</td>
						<td align="center">入党时间</td>
						<td>${ryjbxxVO.DZzmm}</td>
					</tr>
					<tr>
						<td align="center">现任职务<br /> (专业技术职务)</td>
						<td colspan="3">${ryjbxxVO.NXzzw}</td>
						<td align="center">担任现<br /> 职时间</td>
						<td>${ryjbxxVO.DXzzwRzrq}</td>
					</tr>
					<tr>
						<td align="center">专业技术职 <br /> 称及评定时间</td>
						<td colspan="5">${zyjszwVO.NQdmc}&nbsp;${zyjszwVO.DPrrq} </td>
					</tr>
					<tr>
						<td align="center">何时受何种<br /> 奖、惩</td>
						<td colspan="5"><c:forEach items="${jlixxVOs}"
								var="jlixxList">
									${jlixxList.DJlsj}&nbsp;${jlixxList.NJllb}&nbsp;${jlixxList.NJlyy}&nbsp;${jlixxList.CPzdw}</br>
							</c:forEach></td>
					</tr>
					<tr>
						<td align="center">历<br /> 任<br /> 主<br /> 要<br /> 职<br />
							务</td>
						<td colspan="5"><c:forEach items="${jlxxVOs}" var="jlxxList">
								${jlxxList.DQsrq}-${jlxxList.DJzrq}&nbsp;${jlxxList.CSzdw }&nbsp;${jlxxList.CZw}&nbsp;${jlxxList.CZj}&nbsp;${jlxxList.CZmr}</br>
							</c:forEach>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--首次评定授予司法警察警衔审批表-2（结束）-->


		<!--首次评定授予司法警察警衔审批表-3（开始）-->
		<div class="gf_dy_nei" id="4_3" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_4">
					<tr>
						<td align="center" style="border-top:0px; border-bottom:0px;"><p>&nbsp;</p>
							<p>&nbsp;</p> <span
							style="font-size:24px; text-decoration:underline;">组 织 鉴 定</span>
							<p>&nbsp;</p>
							<p>&nbsp;</p></td>
					</tr>
					<tr>
						<td style="border-top:0px;"><p></p>
							<p></p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p></p></td>
					</tr>
				</table>
			</div>
		</div>
		<!--首次评定授予司法警察警衔审批表-3（结束）-->


		<!--首次评定授予司法警察警衔审批表-4（开始）-->
		<div class="gf_dy_nei" id="4_4" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_6">
					<tr>
						<td width="160" align="center">所在单位<br /> 拟授警衔<br /> 意 见</td>
						<td width="464"><br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">审核单位 <br /> 拟授警衔 <br /> 意 见</td>
						<td><br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">呈报单位<br /> 拟授警衔<br /> 意 见</td>
						<td><br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">批准机关 <br /> 授予警衔 <br /> 意 见</td>
						<td><br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">警衔算起 <br /> 时 间</td>
						<td><br /> <br /> 授衔时间从 年 月 日起算</td>
					</tr>
					<tr>
						<td align="center">授衔命令 <br /> 编 号</td>
						<td><br /> <br /> 法衔令[ ] 号</td>
					</tr>
					<tr>
						<td align="center">备    注</td>
						<td><p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p>
							<p>&nbsp;</p></td>
					</tr>
				</table>
			</div>
		</div>
		<!--首次评定授予司法警察警衔审批表-4（结束）-->


		<!--司法警察警衔变动审批表-1（开始）-->
		<div class="gf_dy_nei" id="5_1" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_6">
					<tr>
						<td align="center">单 位</td>
						<td colspan="5">${dwmc}</td>
					</tr>
					<tr>
						<td width="134" align="center">姓 名</td>
						<td width="190">${ryjbxxVO.CXm}</td>
						<td width="79" align="center">性 别</td>
						<td width="62">${ryjbxxVO.NXb}</td>
						<td width="85" align="center">民族</td>
						<td width="74">${ryjbxxVO.NMz}</td>
					</tr>
					<tr>
						<td align="center">出生日期</td>
						<td>${ryjbxxVO.DCsrq}</td>
						<td align="center">文化程度</td>
						<td colspan="3">${ryjbxxVO.NXl}</td>
					</tr>
					<tr>
						<td align="center">参加工作时间</td>
						<td>${ryjbxxVO.DGzrq}</td>
						<td align="center">任职级<br /> 时间</td>
						<td colspan="3">${ryjbxxVO.NZj}</br>${ryjbxxVO.DZjrq}</td>
					</tr>
					<tr>
						<td align="center">现任专业<br /> 技术职务</td>
						<td>${zyjszwVO.NQdmc}</td>
						<td align="center">任职时间</td>
						<td colspan="3">${zyjszwVO.DQdrq}</td>
					</tr>
					<tr>
						<td align="center">何时受<br /> 何种奖、惩</td>
						<td colspan="5"><c:forEach items="${jlixxVOs}"
								var="jlixxList">
									${jlixxList.DJlsj}&nbsp;${jlixxList.NJllb}&nbsp;${jlixxList.NJlyy}&nbsp;${jlixxList.CPzdw}</br>
							</c:forEach>
						</td>
					</tr>
					<tr>
						<td align="center">现 警 衔</td>
						<td></td>
						<td align="center">授衔时间</td>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td align="center">拟变动警衔</td>
						<td>&nbsp;</td>
						<td align="center">变动警<br /> 衔原因</td>
						<td colspan="3">&nbsp;</td>
					</tr>
				</table>
			</div>
		</div>
		<!--司法警察警衔变动审批表-1（结束）-->


		<!--司法警察警衔变动审批表-2（开始）-->
		<div class="gf_dy_nei" id="5_2" style="page-break-after:always;"
			name="PageBoder">
			<div class="gf_dy_pad">
				<div class="gf_biaoti_1" style="margin:0px 0 10px 0"></div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="gf_dy_table_6">
					<tr>
						<td width="83" align="center">历<br /> 任<br /> 主<br /> 要<br />
							职<br /> 务</td>
						<td width="541"><c:forEach items="${jlxxVOs}" var="jlxxList">
								${jlxxList.DQsrq}-${jlxxList.DJzrq}&nbsp;${jlxxList.CSzdw }&nbsp;${jlxxList.CZw}&nbsp;${jlxxList.CZj}&nbsp;${jlxxList.CZmr}</br>
							</c:forEach></td>
					</tr>
					<tr>
						<td align="center">所<br /> 在<br /> 单<br /> 位<br /> 意<br />
							见</td>
						<td><br /> <br /> <br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">审<br /> 核<br /> 单<br /> 位<br /> 意<br />
							见</td>
						<td><br /> <br /> <br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
					<tr>
						<td align="center">呈<br /> 报<br /> 单<br /> 位<br /> 意<br />
							见</td>
						<td><br /> <br /> <br /> <br /> <br /> <br />
							<div class="ntextright" style=" font-size:16px;">年 月 日（盖章）</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--司法警察警衔变动审批表-2（结束）-->

	</div>
</body>
</html>

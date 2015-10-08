<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
	<div style="margin:0 auto;width:800px;">
		<div id="chart_flzw" style="height:400px"></div>
		<div id="chart_fgdj" style="height:400px"></div>
		<div id="chart_xzzw" style="height:400px"></div>
		<div id="chart_bm" style="height:400px"></div>
	</div>
</body>
<script src="/resources/js/echarts/echarts-plain.js"></script>
<script src="/resources/js/fusionCharts/FusionCharts.js"></script>
<script type="text/javascript">
	//法律职务人员分布
	$.ajax({
		url : "/main/cxtj/flzwfb.aj",
		type : 'post',
		success : function(data) {
			/*var names = new Array();
			var counts = new Array();
			for(var i=0; i<data.length; i++){
				names[i] = data[i].name;
				counts[i] = data[i].count;
 			}*/
			showChart2("法律职务人员分布图（单位：人）", "chart_flzw", data);
		}
	});
	//法官等级分布
	$.ajax({
		url : "/main/cxtj/fgdjfb.aj",
		type : 'post',
		success : function(data) {
			/*var names = new Array();
			var counts = new Array();
			for(var i=0; i<data.length; i++){
				names[i] = data[i].name;
				counts[i] = data[i].count;
 			}*/
			showChart2("法官等级分布图（单位：人）", "chart_fgdj", data);
		}
	});
	//行政职务人员分布
	$.ajax({
		url : "/main/cxtj/xzzwfb.aj",
		type : 'post',
		success : function(data) {
			/*var names = new Array();
			var counts = new Array();
			for(var i=0; i<data.length; i++){
				names[i] = data[i].name;
				counts[i] = data[i].count;
 			}*/
			showChart2("行政职务人员分布图（单位：人）", "chart_xzzw", data);
		}
	});
	//部门人员分布
	$.ajax({
		url : "/main/cxtj/bmfb.aj",
		type : 'post',
		success : function(data) {
			/*var names = new Array();
			var counts = new Array();
			for(var i=0; i<data.length; i++){
				names[i] = data[i].name;
				counts[i] = data[i].count;
 			}*/
			showChart2("部门人员分布图（单位：人）", "chart_bm", data);
		}
	});
	
	function showChart(title, div, names, counts){
		var myChart = echarts.init(document.getElementById(div));
		myChart.setOption({
			title: {
				text: title,
				textStyle: {
					fontSize: 14,
					fontWeight: 'bolder',
					color: '#4682B4'
				}
			},
			tooltip : {
	            trigger: 'axis'
	        },
	        toolbox : {
	            show : true,
	            feature : {
	                //mark : {show: true},
	                //dataView : {show: true, readOnly: false},
	                //magicType : {show: true, type: ['line', 'bar']},
	                //restore : {show: true},
	                saveAsImage : {show: true}
	            }
	        },
	        grid : {
	        	y2 : 125
	        },
	        //calculable : true,
	        xAxis : [
	            {
	                type : 'category',
	                axisLabel : {
	                	interval : 0,
	                	rotate : -55,
	                	textStyle : {
	                		baseline : 'top',
	                		fontFamily : '黑体'
	                	}
	                },
	                data : names
	            }
	        ],
	        yAxis : [
	            {
	                type : 'value',
	                splitArea : {show : true}
	            }
	        ],
	        series : [
	            {
	                name:'人数',
	                type:'bar',
	                itemStyle : {
	                	normal : {
	                		color : '#63B8FF',
	                		label : {
	                			show : true, 
	                			position : 'top',
	                			textStyle :{
	                				color : 'grey'
	                			}
	                		}
	                	}
	                },
	                data : counts
	            }
	        ]
		});
	}
	
	function showChart2(title, div, data){
		var colors = new Array("AFD8F8","F6BD0F","8BBA00","FF8E46","008E8E","D64646","8E468E","588526","B3AA00","008ED6","9D080D","A186BE");
		var chart = new FusionCharts("/resources/js/fusionCharts/Column3D.swf", title, "750", "400");
		var XML = "<graph caption='"+title+"' decimalPrecision='0' outCnvbaseFontSize='12' baseFontSize='11'>";
		for(var i=0; i<data.length; i++){
			XML+= "<set name='"+data[i].name+"' value='"+data[i].count+"' color='"+colors[(i%12)]+"'/>";
		}
		XML+= "</graph>";
		chart.setDataXML(XML);
		chart.render(div);
	}
</script>
</html>

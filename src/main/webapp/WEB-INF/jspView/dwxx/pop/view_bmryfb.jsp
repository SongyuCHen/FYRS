<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="mainScreen" style="height:450px;width:600px;"></div>
<div id="title" style="position:relative;top:-400px;left:520px">
	<select id="tjtype">
		<option value="xb">性别</option>
		<option value="xzzw">行政职务</option>
		<option value="zj">职级</option>
		<option value="xl">学历</option>
	</select>
</div>
<div id="catlist" style="display:none">
	${catlist}
</div>
<div id="statistic" style="display:none">
	${statistic}
</div>
<script type="text/javascript" src="/resources/js/echarts/echarts-all.js"></script>
<script type="text/javascript">
	$(function(){
		var fydm = '${fydm}';
		var bmdm = '${bmdm}';
		 $("#tjtype").find("option[value='${field}']").attr("selected",true);
		var catlist = $.parseJSON($("#catlist").text());
		var statistic = $.parseJSON($("#statistic").text().replace(/=/g,":"));
		var data = [];
		for(var i = 0 ; i < catlist.length ; i++){
			data.push({value:statistic[catlist[i]],name:catlist[i]});
		}
		
		var myChart = echarts.init(document.getElementById('mainScreen')); 
		var option = {
		    title : {
		        text: '${bmmc}',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data : catlist
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    series : [
		        {
		            name:'人员分布',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:data
		        }
		    ]
		};
		myChart.setOption(option); 
		
		$("#tjtype").change(function(){
			var field = $("#tjtype").val();
			$.ajax({
        		url:"/main/dwxx/bmryfb.aj",
        		type:"POST",
        		data:{fydm:fydm,bmdm:bmdm,field:field},
        		dataType:"html",
        		success:function(html){
					$(".bmryfb").html(html).dialog("open");            		
        		}
        	});
		});
	});
	
</script>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function(){
		var timeShowHeight = 0;
   		$("#time-show .time-line-time").each(function(){
   			timeShowHeight += $(this).height()+20;
   		});
   		$("#time-show .time-line-panel").each(function(){
   			timeShowHeight += $(this).height();
   		});
		$("#time-line-line").css("height",timeShowHeight);
		var h = timeShowHeight+400>screen.height-250?timeShowHeight+400:screen.height-250;
		$(".contentLeftWrap").height(h);
		$(".contentRightWrap").height(h);
		
		
	})
</script>
<div id="time-show" class="time-line-wrapper">
		<img id="time-line-line" src="/resources/images/time-line.png"/>
		<c:forEach items="${times}" var="time">
			<div class="time-line-day">
			<div class="time-line-time">${time.name}</div>
			<c:forEach items="${time.eventMonth}" var="mList">
				<div class="time-line-item">
				<div class="time-line-dot"></div>
				<div class="time-line-panel">
					<div class= "panel panel-default">				
  						<div class="panel-heading"></div>
  						<div class="panel-body">
    						${mList}
  						</div>
  					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		</c:forEach>
	</div>
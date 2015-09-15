<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function(){
	var html = '<img src="/resources/images/time-select.png" style="margin-left: 5px;vertical-align: middle;">';
	$("#time-left ul li:first").append(html);
	
	 // 滚动事件 
	    $("#time-right").scroll(function(){
	    	
	    	var i = 0;
	    	var currenSelect;
	    	$(".time-title").each(function(){
	    		if($(this).offset().top > $("#time-right").offset().top && i == 0)
	    			{
	    			  currenSelect = $(this);
	    			  i++;
	    			}
	    		
	    	});
	    	
	    	var html = '<img src="/resources/images/time-select.png" style="margin-left: 5px;vertical-align: middle;">';
	    	$("#time-left ul li").each(function(){
	    		$(this).children("img").remove();
	    		if($(this).children("span").text() == currenSelect.children("a").text())
	    			{
	    			   $(this).append(html);
	    			}
	    	});
	    });
});
</script>
<div id="time-left">
	      <ul>
	         <c:forEach items="${times}" var="time">
	            <li><span>${time.name}</span></li>
	         </c:forEach>
	       </ul>
	</div>
	<div id="time-right">
	    <ul id="time-right-ul">
	        <c:forEach items="${times}" var="time">
	         <li>
	           <span class="time-title"><a>${time.name}</a></span><span class="time-title-image">
	           <img src="/resources/images/time-show-circle.png" class="time-show-circle">
	           <img src="/resources/images/time-event-arrow.png" class="time-show-arrow"></span>
	           <ul id="time-right-content-ul">
	              <c:forEach items="${time.eventMonth}" var="mList">
	              <li><a><img src="/resources/images/time-event-icon.png"></a><a>${mList}</a></li>
	              </c:forEach>
	           </ul>
	         </li>
	          </c:forEach>
	       </ul>
</div>
$(function(){
	
	function clickIndex(node){
		node.prevAll(".list:first").click();
		node.prevAll('.sub_list').children('a').removeClass('menu_sub_clicked').children('span').addClass('clicked_a');
		node.nextAll('.sub_list').children('a').removeClass('menu_sub_clicked').children('span').addClass('clicked_a');
		node.children('a').addClass('menu_sub_clicked');
		node.children('a').children('.clicked_a').toggleClass('clicked_a');
		
	}
	
	function initIndex(){
		$(".sub_list").toggleClass("sublist_display");
		var current=$("#menu_title").data("current");
		if(current=="")
			return;
		$(".sub_list").each(function(){
			if($(this).data("type")==current){
				clickIndex($(this));
				return ;
			}
		});
	}
	
	
	$(".list").click(function(){
		var ck = $(this).siblings('.menu_title_clicked');
		ck.each(function(){
			$(this).addClass('list');
			$(this).removeClass('menu_title_clicked');
			$(this).nextUntil('.list,.menu_title_clicked').children('a').removeClass('menu_sub_clicked').children('span').addClass('clicked_a');
			$(this).nextUntil('.list,.menu_title_clicked').slideUp("fast").toggleClass("sublist_display");
		});
		$(this).toggleClass('list');
		$(this).toggleClass('menu_title_clicked');
		$(this).nextUntil('.list,.menu_title_clicked').children('a').removeClass('menu_sub_clicked').children('span').addClass('clicked_a');
		$(this).nextUntil('.list,.menu_title_clicked').slideToggle("fast").toggleClass("sublist_display");
	});
	
	$(".sub_list").click(function(){
		var type=$(this).data('type');
		var showKey = $(this).parent().data('showkey');
	    window.location.href="link.do?type="+type+"&&showKey="+showKey;
	});
	
	initIndex();
});
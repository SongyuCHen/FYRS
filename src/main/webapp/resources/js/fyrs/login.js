$(function() {
	$('body').append('<div id="empty_alert"></div>');
	$('#empty_alert').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		dialogClass : 'dlg-wrap',
		title : '<img src="resources/img/dlg_title_dot.png" />��ʾ��Ϣ'
	});
	$('#empty_alert')
			.append(
					'<div class="alertImg"></div><p></p><input type="button" value="ȷ��" class="j_ok" />');
	function alertDlg(html) {
		$("#empty_alert").html(html).dialog('open');
		$('#empty_alert .j_ok').on('click', function() {
			$alert.dialog('close');
		});
	}
	function alertEmpty(msg) {
		$('#empty_alert p').text(msg);
		$('#empty_alert').dialog('open');
		$('#empty_alert .j_ok').on('click', function() {
			$('#empty_alert').dialog('close');
		});
	}
	/*
	 * �û�ѡ��Ժ
	 */
	// jQuery treeview
	$('.xzfy_ul').treeview({
		collapsed : true,
		unique : true
	});
	var xzfy_nodeC = $('.xzfy_ul a:only-child');
	var xzfy_nodeP = $('.xzfy_ul a:not(only-child)');

	xzfy_nodeC.live('click', function() {
		xzfy_nodeP.removeClass('active');
		xzfy_nodeC.removeClass('active');
		xzfy_sFy = $(this).text();
		xzfy_sFydm = $(this).attr("data-fybh");
		$(this).addClass('active');
	});
	xzfy_nodeP.live('click', function() {
		$that = $(this);
		xzfy_nodeP.removeClass('active');
		xzfy_nodeC.removeClass('active');
		$(this).prev().click();
		xzfy_sFy = $(this).text();
		xzfy_sFydm = $(this).attr("data-fybh");
		$(this).addClass('active');
		var level = $(this).attr('class').split(' ')[0];
	});
	$('.xzfy_sqdq')
			.live(
					'click',
					function() {
						$current = $('a.active');
						if ($current.hasClass('level-1')
								&& $current.prev().hasClass(
										'expandable-hitarea')) {
							// ��ǰ�ڵ��Ƕ���ڵ㣬���ҽڵ�Ϊ����״̬ʱ
							return;
						} else {
							// ��ǰ�ڵ��Ƕ���ڵ㣬������ڵ�չ������ǰ�ڵ㲻�Ƕ���ڵ�
							if ($current.prev().hasClass('collapsable-hitarea')) {
								// ��ǰ�ڵ��к��ӽڵ㲢չ��ʱʱ�����ǰ�ڵ����¼�
								$current.click();
							} else {
								// ��ǰ�ڵ��޺��ӽڵ���ߺ��ӽڵ���չ��ʱ�����ǰ�ڵ�ĸ��ڵ�ĵ���¼�
								$current.closest('ul').parent().find('a:first')
										.click();
							}
						}
					});
	$('.xzfy_sqqb').live('click', function() {
		var aStack = $('.collapsable-hitarea').next('a');
		for ( var i = aStack.length - 1; i >= 0; i--) {
			aStack[i].click();
		}
	});
	$('.xzfy_ok').live('click', function() {
		$('.xzfy_ipt').val(xzfy_sFy);
		$('.xzfy_fybh').val(xzfy_sFydm);
		$('.xzfy_dlg').dialog('close');
	});
	$('.xzfy_cancel').live('click', function() {
		$('.xzfy_dlg').dialog('close');
	});
	$('.xzfy_dlg').dialog({
		autoOpen : false,
		bgiframe : true,
		modal : true,
		resizable : false,
		height : 436,
		width : 400,
		title : 'ѡ��Ժ'
	});
	$('.xzfy_ipt').click(function() {
		alert("click");
		$.ajax({
			url : "getfylb.aj",
			type : 'post',
			dataType : 'html',
			data : {},
			success : function(html) {
				$('.xzfy_dlg').html(html).dialog('open');
				$('.xzfy_ul').treeview({
					collapsed : true,
					unique : true
				});
				if (!$('.level-1').prev().hasClass('collapsable-hitarea')) {
					$('.level-1').click();
				}
			}
		});
	});
});
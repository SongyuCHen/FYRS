$(function() {
	$("#sjfw").hide();
	$("#niandu").hide();
	hideAllTable();

	function hideAllTable() {
		$("#tablenr").hide();
		$("#tablenrone").hide();
		$("#tablenrtwo").hide();
		$("#tablenrthree").hide();
		$("#tablenrfour").hide();
		$("#tablenrfive").hide();
		$("#tablenrsix").hide();
		$("#tablenrseven").hide();
		$("#tablenreight").hide();
		$("#tablenrnine").hide();
	}

	$("#select-sj").live("change", function() {
		if ($("#select-sj").val() == "1") {
			$("#sjfw").hide();
			document.getElementById("select-year").options.length = 0;
			document.getElementById("select-xuanze").options.length = 0;
			var date = new Date();
			var year = date.getFullYear();
			var selectObj = document.getElementById("select-year");
			for ( var i = 1990; i < year + 10; i++) {
				selectObj.options.add(new Option(i, i));
			}
			selectObj.value = year;
			var selectOb = document.getElementById("select-xuanze");
			selectOb.options.add(new Option("全年", 1));
			selectOb.options.add(new Option("上半年", 2));
			selectOb.options.add(new Option("下半年", 3));
			$("#niandu").show();
		}
		if ($("#select-sj").val() == "2") {
			$("#sjfw").hide();
			document.getElementById("select-year").options.length = 0;
			document.getElementById("select-xuanze").options.length = 0;
			var date = new Date();
			var year = date.getFullYear();
			var selectObj = document.getElementById("select-year");
			for ( var i = 1990; i < year + 10; i++) {
				selectObj.options.add(new Option(i, i));
			}
			selectObj.value = year;
			for ( var i = 1; i < 5; i++) {
				var selectOb = document.getElementById("select-xuanze");
				selectOb.options.add(new Option(i, i));
			}
			$("#niandu").show();
		}
		if ($("#select-sj").val() == "3") {
			$("#sjfw").hide();
			document.getElementById("select-year").options.length = 0;
			document.getElementById("select-xuanze").options.length = 0;
			var date = new Date();
			var year = date.getFullYear();
			var selectObj = document.getElementById("select-year");
			for ( var i = 1990; i < year + 10; i++) {
				selectObj.options.add(new Option(i, i));
			}
			selectObj.value = year;
			for ( var i = 1; i < 13; i++) {
				var selectOb = document.getElementById("select-xuanze");
				selectOb.options.add(new Option(i, i));
			}
			$("#niandu").show();
		}
		if ($("#select-sj").val() == "4") {
			$("#niandu").hide();
			$("#sjfw").show();
			$(".zdytj-datepicker").live("focus", function() {
				$(this).datepicker();
			});
		}

		if ($("#select-sj").val() == "-1" || $("#select-sj").val() == "5") {
			$("#niandu").hide();
			$("#sjfw").hide();
		}
	});

	$("#select-xx").live(
			"change",
			function() {
				document.getElementById("select-ry").options.length = 0;
				var selectType = $("#select-xx").val();
				if (selectType == -1) {
					alert("请选择类别！");
					return;
				}
				if (selectType == 1) {
					hideAllTable();
					$("#tablenr").show();
				}
				if (selectType == 2 || selectType == 3) {
					hideAllTable();
					$("#tablenrnine").show();
				}
				$.ajax({
					url : "/main/yjda/selectType.aj",
					type : "POST",
					dataType : "json",
					data : {
						selectType : selectType
					},
					success : function(json) {
						var options = '';
						if (selectType == 1) {
							options += '<option value="-1">本人</option>';
							options += '<option value="-2">全院</option>';
						}
						for ( var i = 0; i < json.length; i++) {
							options += '<option value="' + json[i].NDm + '">'
									+ json[i].CMc + '</option>';
						}
						$("#select-ry option").remove();
						$("#select-ry").html(options);
					}
				});

			});

	$("#select-ry").live("change", function() {
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "-1") {
			hideAllTable();
			$("#tablenr").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "-2") {
			hideAllTable();
			$("#tablenrone").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "03") {
			hideAllTable();
			$("#tablenrtwo").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "04") {
			hideAllTable();
			$("#tablenrtwo").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "06") {
			hideAllTable();
			$("#tablenrthree").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "10") {
			hideAllTable();
			$("#tablenrthree").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "11") {
			hideAllTable();
			$("#tablenrthree").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "13") {
			hideAllTable();
			$("#tablenrfour").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "14") {
			hideAllTable();
			$("#tablenrfive").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "16") {
			hideAllTable();
			$("#tablenrsix").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "17") {
			hideAllTable();
			$("#tablenrseven").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "18") {
			hideAllTable();
			$("#tablenreight").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "19") {
			hideAllTable();
			$("#tablenrthree").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "20") {
			hideAllTable();
			$("#tablenrsix").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "C1") {
			hideAllTable();
			$("#tablenrfive").show();
		}
		if ($("#select-xx").val() == "1" && $("#select-ry").val() == "C2") {
			hideAllTable();
			$("#tablenrfive").show();
		}
	});

	function checkAllSelect() {
		if (($("#select-sj").val() == "1" && $("#select-xx").val() != "-1")
				|| ($("#select-sj").val() == "2" && $("#select-xx").val() != "-1")
				|| ($("#select-sj").val() == "3" && $("#select-xx").val() != "-1")
				|| ($("#select-sj").val() == "4"
						&& $("#select-xx").val() != "-1"
						&& $("#fromDate").val() != "" && $("#toDate").val() != "")
				|| ($("#select-sj").val() == "5" && $("#select-xx").val() != "-1")) {
			return true;
		} else {
			return false;
		}
	}

	$("#bg_ge")
			.live(
					"click",
					function() {
						if (checkAllSelect()) {
							hideAllTable();
							$("#loadingSpinner").show();
							$("#line0").nextAll().remove();
							$("#line0").remove();
							if ($("#select-xx").val() == "1"
									&& $("#select-ry").val() == "-1") {
								$
										.ajax({
											url : "/main/yjda/scbbgr.aj",
											type : 'post',
											data : {
												'sjd' : $("#select-sj").val(),
												'year' : $("#select-year")
														.val(),
												'xz' : $("#select-xuanze")
														.val(),
												'selectone' : $("#select-xx")
														.val(),
												'selecttwo' : $("#select-ry")
														.val(),
												'selectthree' : $("#fromDate")
														.val(),
												'selectfour' : $("#toDate")
														.val()
											},
											dataType : 'json',
											success : function(json) {
												for ( var i in json) {
													$("#" + i + "").text(
															json[i]);
												}
												var tdContent = $("#tablenr span");
												for ( var i = 0; i < tdContent.length; i++) {
													if (tdContent.eq(i).text() == "") {
														tdContent.eq(i).text(
																"--");
													}
												}
												$("#loadingSpinner").hide();
												$("#tablenr").show();
											}
										});
							} else if ($("#select-xx").val() == "1"
									&& $("#select-ry").val() == "-2") {
								$.ajax({
									url : "/main/yjda/scbbqy.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#fgyjkp").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrone").show();
									}
								});
							} else if ($("#select-xx").val() == "2"
									|| $("#select-xx").val() == "3") {
								$.ajax({
									url : "/main/yjda/scbbzwzj.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#zwzj").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrnine").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& $("#select-ry").val() == "13") {
								$.ajax({
									url : "/main/yjda/scbbxz.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#xzspt").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrfour").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& ($("#select-ry").val() == "03" || $(
											"#select-ry").val() == "04")) {
								$.ajax({
									url : "/main/yjda/scbbxs.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#fgyjkpxst").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrtwo").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& ($("#select-ry").val() == "06"
											|| $("#select-ry").val() == "10"
											|| $("#select-ry").val() == "11"
											|| $("#select-ry").val() == "19" || $(
											"#select-ry").val() == "18")) {
								$.ajax({
									url : "/main/yjda/scbbms.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#fgyjkpmst").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrthree").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& ($("#select-ry").val() == "14" || $(
											"#select-ry").val() == "C1")
									|| $("#select-ry").val() == "C2") {
								$.ajax({
									url : "/main/yjda/scbbzx.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#zxj").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrfive").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& ($("#select-ry").val() == "16" || $(
											"#select-ry").val() == "20")) {
								$.ajax({
									url : "/main/yjda/scbbla.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#laj").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrsix").show();
									}
								});
							} else if ($("#select-xx").val() == "1"
									&& $("#select-ry").val() == "17") {
								$.ajax({
									url : "/main/yjda/scbbsj.aj",
									type : 'post',
									data : {
										'sjd' : $("#select-sj").val(),
										'year' : $("#select-year").val(),
										'xz' : $("#select-xuanze").val(),
										'selectone' : $("#select-xx").val(),
										'selecttwo' : $("#select-ry").val(),
										'selectthree' : $("#fromDate").val(),
										'selectfour' : $("#toDate").val()
									},
									dataType : 'json',
									success : function(json) {
										for ( var i = 0; i < json.length; i++) {
											var jsonobj = json[i];
											$("#spjdt").append(
													"<tr id=line" + i
															+ "></tr>");
											for ( var x in jsonobj) {
												$("#line" + i).append(
														"<td>" + jsonobj[x]
																+ "</td>");
											}
										}
										$("#loadingSpinner").hide();
										$("#tablenrseven").show();
									}
								});
							}
						} else {
							alert("请选择时间或选项！");
						}
					});

	$("#jcajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 0
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#xsajzs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 1
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#jazs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 2
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#fdsxnjas").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 3
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#tjs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 4
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#css").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 5
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#ysajpss").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 6
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#esktsljas").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 8
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#ssajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 9
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#bgpfhs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 10
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#sss").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 11
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#bywjas").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 12
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zzwjs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 13
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zdwjs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 14
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#ztjswjs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 15
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#ysajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 16
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#esajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 17
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zsajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 18
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#xftss").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 19
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#cjhytajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 20
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#ysjycxjas").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 21
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#xzsczxajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 22
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#xsfdmsajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 23
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zxajqzzxs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 24
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zxajzdlxs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 25
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zxhjajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 26
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#zjajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 27
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#sxnwja").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 28
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#csxwjs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 29
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});

	$("#jxajs").live("click", function() {
		$.ajax({
			url : "/main/yjda/ajjtxx.aj",
			type : 'post',
			data : {
				'codeNum' : 30
			},
			dataType : 'html',
			success : function(html) {
				$("#ajjtxx_dlg").html(html).dialog('open');
			}
		});
	});
});

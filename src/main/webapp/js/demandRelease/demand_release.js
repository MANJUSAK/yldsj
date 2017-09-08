var html = '';

function gettype(a) {
	var curl_ = '';
	var mydata = null;
	//根据标识 设置请求路径   分类
	switch(a) {
		case 0:
			if($.session.get('uid')) {
				curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/equipment';
				mydata = {
					uid: $.session.get('uid'),
					page: 0
				};
				getdata_(html, curl_, mydata);
			} else {
				$("#niYaler").css({
					"display": "block",
					"position": "fixed"
				});
				$("#nyBox").hide();
				$("#nyBt").show();
				$("#itemInner").click(function() {
					$("#niYaler").css("display", "none");
				});
				$("#fcAim").click(function() {
					$("#niYaler").css("display", "none");
				});
				$("#niClose").click(function() {
					$("#niYaler").css("display", "none");
				});
			}
			break;
	}
}

$(function() {
	var curl_ = window.sessionStorage.getItem("Host") + '/xqfb/find/equipment';
	getdata_(html, curl_, {
		page: 0
	});
	//检测是否登录
	$('#aFirst').click(function() {
		isloginMinMax();
	})
	if($.session.get('uid')) {
		//添加表单UID
		$('#uid').val($.session.get('uid'));
	}
	/*******************表单验证*************************/
	var but = false;
	var needregEXP = true;
	/** 输入手机号码正则 **/
	var phones = /^1[3|4|5|8][0-9]\d{4,8}$/;
	var phones_2 = /^0\d{2,3}-?\d{7,8}$/;
	//点击发布信息
	$(".bf-submit > .bf-submit-center > span").click(function() {
		needregEXP = true;
		but = true;
		DR_regExp();
		Ajax_tj();
	});
	//当键盘按下的时候调用这个事件
	$(".bf-input_input").keyup(function() {
		if(but == true) {
			DR_regExp();
		}
	});
	$("bf-input_input").change(function() {
		if(but == true) {
			DR_regExp();
		}
	});
	//textarea的键盘按下事件
	$(".bf-textarea-center > textarea").keyup(function() {
		if(but == true) {
			DR_regExp();
		}
	});
	//获取图片时调用事件
	$(".bf-is-item2 > .bfis-item2_center >input").change(function() {
		if(but == true) {
			DR_regExp();
		}
	});

	function DR_regExp() {
		//var Binput=$(".bf-input > input");
		for(var i = 0; i < $(".bf-input_input").length; i++) {
			if($.trim($(".bf-input_input:eq(" + i + ")").val()) == '') {
				$(".bf-input_input:eq(" + i + ")").parent().next(".bf-input_nextSpan").css("visibility", "visible");
				needregEXP = false;
			} else {
				$(".bf-input_input:eq(" + i + ")").parent().next(".bf-input_nextSpan").css("visibility", "hidden");
			}
		}
		//判断图片是否选择
		if($(".bf-is-item2 > .bfis-item2_center >input").val() == "") {
			$(".bf-is-item2 > .bfis-item2_center >input").parent().parent().parent().parent().next(".bf-input_nextSpan").css("visibility", "visible");
			needregEXP = false;
		} else {
			$(".bf-is-item2 > .bfis-item2_center >input").parent().parent().parent().parent().next(".bf-input_nextSpan").css("visibility", "hidden");
		}
		//输入内容的部分
		if($.trim($(".bf-textarea-center > textarea").val()) == '') {
			$(".bf-textarea-center > textarea").parent().parent().parent().next(".bf-input_nextSpan").css("visibility", "visible");
			needregEXP = false;
		} else {
			$(".bf-textarea-center > textarea").parent().parent().parent().next(".bf-input_nextSpan").css("visibility", "hidden");
		}
		//判断电话号码(移动电话和固定电话))
		phonesExpIf();
		if(but == true) {
			phonesExp();
		}
		//console.log("这里是needregEXP的类型:"+needregEXP);
		return needregEXP;
	}
	//电话号码（点击提交按钮后，在输入内容的textare文本框里输入内容，调用此方法）
	function phonesExp() {
		$('.bf-input_phoneInput').keyup(function() {
			phonesExpIf();
		});
	}
	//电话号码
	function phonesExpIf() {
		if(phones.test($(".bf-input_phoneInput").val()) || phones_2.test($(".bf-input_phoneInput").val())) {
			$(".bf-input_phoneInput").parent().next(".bf-input_nextSpan").css("visibility", "hidden");
			console.log("这里是判断电话格式0000正确")
		} else {
			$(".bf-input_phoneInput").parent().next(".bf-input_nextSpan").css("visibility", "visible");
			needregEXP = false;
			//console.log("这里是判断电话格式11111错误")
		}
	}
	/** 输入手机号码正则 结束 **/
	function Ajax_tj() {
		//debugger;
		if(needregEXP == true) {
			//改变按钮的颜色和变为不可点击
			$(".bf-submit > .bf-submit-center > span").text("正在发布...");
			$(".bf-submit > .bf-submit-center > span").css({
				"pointer-events": "none",
				"background-color": "#a0a0a0"
			});
			var form = new FormData(document.getElementById("myform"));
			$.ajax({
				url: window.sessionStorage.getItem("Host") + "/xqfb/release/equipment",
				type: "post",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {
					if(data.status > 0) {
						$(".bf-submit > .bf-submit-center > span").text("发       布");
						$(".bf-submit > .bf-submit-center > span").css({
							"pointer-events": "auto",
							"background-color": "#0096FD"
						});
						$('#show_error_').text(data.msg);
					} else {
						location.replace(location.href);
					}
				},
				error: function(e) {
					$(".bf-submit > .bf-submit-center > span").text("发       布");
					$(".bf-submit > .bf-submit-center > span").css({
						"pointer-events": "auto",
						"background-color": "#0096FD"
					});
					$('#show_error_').text('错误代码：' + e.status);
				}
			});
		}
	};
	/*********************** ni-yaler 点击我要发布，蒙层的高度铺满下面的屏幕 高度到底部 ************************/
	window.onload = function() {
		var bodyHeight = $(document.body).height();
		$(".ni-yaler").css("height", bodyHeight + "px");

	}

	//添加时间
	window.onload = function() {

		setInterval(function() {
			var time = new Date();
			// 程序计时的月从0开始取值后+1
			var m = time.getMonth() + 1;
			var t = time.getFullYear() + "-" + m + "-" +
				time.getDate() + " " + time.getHours() + ":" +
				time.getMinutes();
			$('#dates').val(t)
		}, 1000);
	};

})
//数据呈现
function getdata_(html, curl_, mydata) {

	var div_ = $('#mycontent'); //数据呈现位置
	var pagesize = 10; //页面数据长度
	var count = pagesize; //循环数据长度
	var sizeof = 0; //最大页码
	var pagenum = 0; //初始化起始页码数据起始值
	var page = 1; //初始化页码长度
	var page_count = 9; //显示页码最大值		只能为奇数
	var this_page = 0; //当前页码值
	var html_more = '';
	//设置请求路径

	//初始化页面内容
	$.ajax({
		type: "get",
		url: curl_,
		async: true,
		data: mydata,
		success: function(result) {
			if(result.errorCode == 0) {
				//提前数据
				var data = result.data;
				//获取数据长度
				var len = data.length;
				//获取图片路径
				//var path = result.path;
				//初始化变量
				var html_page = '';
				//数据绑定

				if(len % sizeof == 0) {
					sizeof = len / pagesize;
				} else {
					sizeof = ((len - len % pagesize) / pagesize) + 1;
				}
				//动态数组长度
				if(len <= count) {
					count = len;
				}

				function show_data() {
					$.each(data, function(pagenum) {
						html += '<div class="dc-item">' +
							'<div class="dc-item-center">' +
							'<div class="dc-ic-left">' +
							'<div class="dc-ic-left_center">';
						if(data[pagenum].picture != null) {
							html += '<img src="' + data[pagenum].picture[0] + '" />';
						} else {
							html += '<img src="" />';
						}
						html += '</div>' +
							'</div>' +
							'<div class="dc-ti-right">' +
							'<div class="dc-right-title">' +
							'<div class="dc-rt-left">' +
							'<p class="p1">' +
							'<a href="">' + data[pagenum].titleName + '</a>' +
							'</p>' +
							'<p class="p2">' +
							'<span><i class="fa fa-user"></i> <a>' + data[pagenum].contact + '</a></span>' +
							'<span><i class="fa fa-clock-o"></i> <a>' + data[pagenum].time + '</a></span>' +
							'</p>' +
							'</div>' +
							'<div class="dc-rt-right">' +
							'<div class="dc-rt-right-center">' +
							'<span><i class="fa fa-volume-control-phone"></i> <a>联系电话</a></span>' +
							'</div>' +
							'</div>' +
							'</div>' +
							'<div class="dc-right-content">' +
							'<p>' + data[pagenum].content + '</p>' +
							'</div>' +
							'<div class="dc-right-inner">' +
							'<div class="dc-inner-content">' +
							'<span hidden="hidden">' + pagenum + ',</span>' +
							'<a>查看详情</a>' +
							'</div>' +
							'</div>' +
							'</div>' +
							'</div>' +
							'</div>';
					});
					div_.html(html);
					//详情信息
					$('.dc-inner-content').click(function() {
						var num = $(this).parent().parent().parent().parent().index();
						if($.session.get('uid')) {
							window.sessionStorage.setItem('dem_data', JSON.stringify(data[num]));
							window.open('demand-release-details.html', '_blank');
						} else {
							$("#niYaler").css({
								"display": "block",
								"position": "fixed"
							});
							$("#nyBox").hide();
							$("#nyBt").show();
							$("#itemInner").click(function() {
								$("#niYaler").css("display", "none");
							});
							$("#fcAim").click(function() {
								$("#niYaler").css("display", "none");
							});
							$("#niClose").click(function() {
								$("#niYaler").css("display", "none");
							});
						}

					})

					html_more += '<div class="more_whole" style="padding-top: 40px;"><div class="more_L"></div><div class="more" id="more">加载更多</div><div class="more_R"></div></div><div style="clear: both;"></div>';
					$('.dc-pages').html(html_more);
					//加载更多
					$('#more').click(function() {
						if(len < 20) {
							alert('已经没有更多数据了')
						} else {
							mydata.page = mydata.page + 1;
							getdata_(html, curl_, mydata);
						}

					})

				}
				/*第一次进入时*/
				if(pagenum == 0) {
					//首次进入直接使用初始参数
					show_data();
				}

			} else {
				/*var str = '暂无数据';
				div_.html(str);*/
				alert('没有更多数据了')
			}
		},
		error: function(err) {
			//console.log(err);
		}
	});
}
//检测登录
function isloginMinMax() {
	//var islogin = document.getElementById('islogin').value;
	//alert(islogin);
	$(".li-qm").mouseover(function() {
		$(".ni-li2-item").css("display", "block");
	});
	$(".li-qm").mouseout(function() {
		$(".ni-li2-item").css("display", "none");
	});
	$(".ni-li2-item").mouseover(function() {
		$(".ni-li2-item").css("display", "block");
	});
	$(".ni-li2-item").mouseout(function() {
		$(".ni-li2-item").css("display", "none");
	});
	if($.session.get('uid')) {
		// 返回的值大于零为
		$("#niYaler").css("display", "block");
		$("#nyBt").css("display", "none");

		$("#nyBox").css("display", "block");
		$("#faTimes2").click(function() {
			$("#nyBox").css("display", "none");
			$("#niYaler").css("display", "none");
		});
		$("#niClose").click(function() {

			$("#niYaler").css("display", "none");
		});
	} else {
		// 还没有登录的时候显示进入登录页面
		$("#niYaler").css("display", "block");
		$("#nyBox").hide();
		$("#nyBt").show();
		$("#itemInner").click(function() {
			$("#niYaler").css("display", "none");
		});
		$("#fcAim").click(function() {
			$("#niYaler").css("display", "none");
		});
		$("#niClose").click(function() {
			$("#niYaler").css("display", "none");
		});
	}
}
//提交发布
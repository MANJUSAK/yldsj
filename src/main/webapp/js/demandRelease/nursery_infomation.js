var pagex = 0;
var html = '';

function gettype(a) {
	var myurl = window.sessionStorage.getItem("Host") + '';
	var curl_ = myurl + '/xqfb/find/seedling';
	var mydata = null;

	//根据标识 设置请求路径   分类
	switch(a) {
		case 0:
			mydata = {
				page: 0,
				breed: '乔木信息'
			};
			getdata_(html, curl_, mydata);
			break;
		case 1:
			mydata = {
				page: 0,
				breed: '乔木信息',
				sub: '普通乔木'
			};
			getdata_(html, curl_, mydata);
			break;
		case 2:
			mydata = {
				page: 0,
				breed: '乔木信息',
				sub: '造型乔木'
			};
			getdata_(html, curl_, mydata);
			break;
		case 3:
			mydata = {
				page: 0,
				breed: '地栽灌木',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 4:
			mydata = {
				page: 0,
				breed: '藤',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 5:
			mydata = {
				page: 0,
				breed: '草本植物',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 6:
			mydata = {
				page: 0,
				breed: '草本植物',
				sub: '花卉'
			};
			getdata_(curl_, mydata);
			break;
		case 7:
			getdata_(html, curl_, {
				page: 0,
				breed: '草本植物',
				sub: '地被'
			});
			break;
		case 8:
			mydata = {
				page: 0,
				breed: '草本植物',
				sub: '袋袋草本'
			};
			getdata_(html, curl_, mydata);
			break;
		case 9:
			mydata = {
				page: 0,
				breed: '竹',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 10:
			mydata = {
				page: 0,
				breed: '棕榈植物',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 11:
			mydata = {
				page: 0,
				breed: '水生植物',
				sub: ''
			};
			getdata_(html, curl_, mydata);
			break;
		case 12:
			if($.session.get('uid')) {
				mydata = {
					page: 0,
					uid: $.session.get('uid')
				};
				getdata_(html, curl_, mydata);
			} else {
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
			break;
	}

}

$(function() {
	var curl_ = window.sessionStorage.getItem("Host") + '/xqfb/find/seedling';
	getdata_(html, curl_, {
		page: 0
	});
})
//****************请求数据***********************//
function getdata_(html, curl_, mydata) {
	var div_ = $('#mycontent'); //数据呈现位置

	//查阅更多内容指导
	var html_more = '';
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
				//初始化变量
				var html_page = '';
				//数据绑定
				$.each(data, function(pagenum) {
					html += '<div class="ni-cotents sfiltrate1">' +
						'<div class="nc-item">' +
						'<div class="nc-item-left">' +
						'<div class="dc-ic-left_center">';
					var pic = data[pagenum].picture;
					if(pic != null) {
						html += '<img src="' + data[pagenum].picture[0] + '" />';
					} else {
						html += '<img src="' + data[pagenum].picture + '" />';

					}
					html += '</div>' +
						'</div>' +
						'<div class="nc-item-right">' +
						'<div class="nc-ir-topbar">' +
						'<div class="ir-topbar-left">' +
						'<a target="_blank" >' + data[pagenum].titleName + '</a>' +
						'<div class="ir-left-inner">' +
						'<span><i class="fa fa-map-marker"></i> 【' + data[pagenum].address + '】' + data[pagenum].supplier + '</span>' +
						'<span><i class="fa fa-clock-o"></i>' + data[pagenum].date + '</span>' +
						'</div>' +
						'</div>' +
						'<div class="ir-topbar-right">' +
						'<div class="ir-tr-item">' +
						'<i class="fa fa-qq"></i>' +
						'</div>' +
						'<div class="ir-tr-item">' +
						'<i class="fa fa-volume-control-phone"></i>' +
						'</div>' +
						'<div class="ir-tr-item">' +
						'<i class="fa fa-envelope"></i>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'<div class="nc-ir-center">' +
						'<p>' + data[pagenum].content +
						'</p>' +
						'</div>' +
						'<div class="nc-ir-footer">' +
						'<div class="nc-ir-aim">' +
						'<span  style="display: none;">' + pagenum + '</span>' +
						'<a >阅读全文</a>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>';
				});
				//绑定页面数据
				div_.html(html);
				//查看更多
				html_more += '<div class="more_whole"><div class="more_L"></div><div class="more" id="more">加载更多</div><div class="more_R"></div></div><div style="clear: both;"></div>';
				$('.ni-pages').html(html_more);

				$('#more').click(function() {
					if(len < 20) {
						alert('已经没有更多数据了')
					} else {
						mydata.page = mydata.page + 1;
						getdata_(html, curl_, mydata);
					}

				})

				////进入详情
				$('.nc-ir-aim').click(function() {
					debugger;
					if($.session.get('uid')) {
						window.sessionStorage.setItem('datax', JSON.stringify(data[$(this).index()]))
						window.open('nursery-details.html', '_blank');
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

			} else if(result.errorCode == 404) {
				//alert(result.msg)
				div_.html(result.msg);
			} else {
				div_.html(result.msg);
			}
		},
		error: function(err) {
			//console.log(err);
		}
	});
}

/*********************** 动态的苗木信息导航 **********************/
//种类筛选点击事件
$('.ni-lc-left > ul > li > a').click(function() {
	//获取到当前点击的li
	var c = $('.ni-lc-left > ul > li');
	//获取Li的长度
	var c_length = c.length;
	//用一个变量来储存当前选择的下标
	var this_click = $(this).parent('li').index();
	for(var i = 1; i <= c_length - 1; i++) {
		//对所有的a标签移除已选择的样式
		$('.ni-lc-left > ul > li:eq(' + i + ') > a').removeClass("ni-lis-a")
	}
	//对前面已选择并储存的下标值来添加已选择样式
	$('.ni-lc-left > ul > li:eq(' + this_click + ') > a').addClass("ni-lis-a")
	//PS:把this_click进行动态获取即可添加当前已选择的样式
})
/*********************** 动态的苗木信息导航 结束 **********************/

/*************************** 苗木信息 我要发布 做正则判断 ***************************/
//capture('dc-right-content', 80);
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
	//Ajax_tj();
});
//当键盘按下的时候调用这个事件
$(".bf-input_input").keyup(function() {
	if(but == true) {
		DR_regExp();
	}
});
//当值发生改变时
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
//console.log($(".bf-input_input").length); 
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
		///	console.log("这里是判断电话格式0000正确")
	} else {
		$(".bf-input_phoneInput").parent().next(".bf-input_nextSpan").css("visibility", "visible");
		needregEXP = false;
		//console.log("这里是判断电话格式11111错误")
	}
}
/** 输入手机号码正则 结束 **/
/*************************** 苗木信息 我要发布 做正则判断 ***************************/

/************************发布信息填入********************************************/
$(function() {
	var list = [
		["乔木信息", "普通乔木", "造型乔木"],
		["地栽灌木", ''],
		["藤", ''],
		["草本植物", "花卉", "地被", "袋袋草本"],
		["竹", ''],
		["棕榈植物", ''],
		["水生植物", '']

	];
	var city_one = document.getElementById('select_one');
	var city_two = document.getElementById('select_two');

	//默认添加的第一个数据
	for(var i = 0; i < list.length; i++) {
		op = new Option();
		op.text = list[i][0];
		city_one.options.add(op);
	}
	$('#select_one').change(function cityChange() {
		//获取一级菜单的第一个值
		var cityName = city_one.options[city_one.selectedIndex].text;
		city_two.options.length = 0;
		for(var i = 0; i < list.length; i++) {
			if(cityName == list[i][0]) {
				//找到当前的子数组
				for(var j = 1; j < list[i].length; j++) {
					op = new Option();
					op.text = list[i][j];
					city_two.options.add(op);
					city_two.options.valueOf(op);
				}
				break;
			}
		}
	})

})
window.onload = function() {
	//var show = document.getElementById("dates");

	setInterval(function() {
		var time = new Date();
		// 程序计时的月从0开始取值后+1
		var m = time.getMonth() + 1;
		var t = time.getFullYear() + "-" + m + "-" +
			time.getDate() + " " + time.getHours() + ":" +
			time.getMinutes(); //+ ":" + time.getSeconds();
		//show.innerHTML = t;
		$('#dates').val(t)
	}, 1000);
};

/*******************信息发布***************************************/
$(function() {
	$('#aFirst').click(function() {
		isloginMinMax();
	})
	$('#uid').val($.session.get('uid'))
	$('#submit_nu').click(function Ajax_tj() {
		//alert(0)
		console.log()
		if(needregEXP == true) {
			$(".bf-submit > .bf-submit-center > span").text("正在发布...");
			$(".bf-submit > .bf-submit-center > span").css({
				"pointer-events": "none",
				"background-color": "#a0a0a0"
			});
			var form = new FormData(document.getElementById("myform"));
			console.log(form)
			$.ajax({
				url: window.sessionStorage.getItem("Host") + "/xqfb/release/seedling",
				type: "post",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {

					if(data.errorCode > 0) {
						$(".bf-submit > .bf-submit-center > span").text("发       布");
						$(".bf-submit > .bf-submit-center > span").css({
							"pointer-events": "auto",
							"background-color": "#0096FD"
						});
						console.log(data)
						$('#show_error_').text(data.msg);
					} else {
						//location.replace(location.href = "index.php?c=need&m=device");
						$(".bf-submit > .bf-submit-center > span").text("发       布");
						$(".bf-submit > .bf-submit-center > span").css({
							"pointer-events": "auto",
							"background-color": "#0096FD"
						});
						location.replace(location.href);
					}
				},
				error: function(e) {

					$(".bf-submit > .bf-submit-center > span").text("发       布");
					$(".bf-submit > .bf-submit-center > span").css({
						"pointer-events": "auto",
						"background-color": "#0096FD"
					});
					//alert(e.status)
					$('#show_error_').val('错误代码：' + e.status);
				}
			});

		}
	});
	//信息发布
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
})
var result = true;
//初始化页面内容
var html = '';

function gettype(a) {
	var url = window.sessionStorage.getItem("Host");
	var curl_ = '';
	var mydata = null;
	var div_num = 0;
	//根据标识 设置请求路径   分类
	switch(a) {
		case 0:
			if($.session.get('uid')) {
				curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
				mydata = {
					uid: $.session.get('uid'),
					page: 0
				};
				div_num = 0;
				getdata_(html, curl_, mydata, div_num);
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
		case 2:
			curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
			mydata = {
				tp: 1,
				cts: 1,
				page: 0
			};
			div_num = 0;
			getdata_(html, curl_, mydata, div_num);
			break;
		case 3:
			curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
			mydata = {
				tp: 1,
				cts: 2,
				page: 0
			};
			div_num = 1;
			getdata_(html, curl_, mydata, div_num);
			break;
		case 4:
			curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
			mydata = {
				tp: 2,
				cts: 1,
				page: 0,
			};
			div_num = 2;
			getdata_(html, curl_, mydata, div_num, 1);
			break;
		case 5:
			curl_ += window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
			mydata = {
				tp: 2,
				cts: 2,
				page: 0
			};
			div_num = 3;
			getdata_(html, curl_, mydata, div_num, 1);
			break;
	}

}
$(function() {
	var curl_ = window.sessionStorage.getItem("Host") + '/xqfb/find/recruit';
	getdata_(html, curl_, {
		page: 0,
		cts: 1,
		tp: 1
	}, 0);

	if($.session.get('uid')) {
		//添加表单UID
		$('#uid').val($.session.get('uid'));
	}
	//检测是否登录
	$('#aFirst').click(function() {
		isloginMinMax();
	})

	/*********************** ni-yaler 点击我要发布，蒙层的高度铺满下面的屏幕 高度到底部 ************************/
	window.onload = function() {
		var bodyHeight = $(document.body).height();
		$(".ni-yaler").css("height", bodyHeight + "px");

	}

	//添加时间
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

	$('#fabu,#qiuzhi').click(function() {
		Ajax_tj();
	});

	//提交发布
	function Ajax_tj() {

		var form;
		if(window.sessionStorage.getItem('zp_qz') == 1) {
			validate();
			form = new FormData(document.getElementById("myform"));
		} else {
			validate1();
			form = new FormData(document.getElementById("myform0"));
		}
		if(result) {
			//改变按钮的颜色和变为不可点击
			$(".bf-submit > .bf-submit-center > span").text("正在发布...");
			$(".bf-submit > .bf-submit-center > span").css({
				"pointer-events": "none",
				"background-color": "#a0a0a0"
			});

			$.ajax({
				url: window.sessionStorage.getItem("Host") + "/xqfb/release/recruit",
				type: "post",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {

					//alert(data)
					console.log(data)
					if(data.errorCode > 0) {
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

					alert(e.status)
				}
			});
		}
	}

})
//数据呈现			数据内容      请求地址	请求参数	数据呈现位置	数据类型
function getdata_(html, curl_, mydata, div_num, tynum) {
	var div_arr = [$('#mycontent'), $('#mycontent2'), $('#mycontent3'), $('#mycontent4')]; //数据呈现位置
	var html_more = '';
	//设置请求路径
	var pagesize = 10; //页面数据长度
	var count = pagesize; //循环数据长度
	var sizeof = 0; //最大页码
	var pagenum = 0; //初始化起始页码数据起始值
	var page = 1; //初始化页码长度
	var page_count = 9; //显示页码最大值		只能为奇数
	var this_page = 0; //当前页码值
	$.ajax({
		type: "get",
		//url: "http://172.16.13.113/Garden/release/querySeedlingmessage",
		url: curl_,
		async: true,
		data: mydata,
		success: function(result) {
			console.log(result)
			if(result.errorCode == 0) {
				//提前数据
				var data = result.data;
				//获取数据长度
				var len = data.length;
				//获取图片路径
				var path = result.path;
				//初始化变量
				//var html = '';
				var html_page = '';
				//数据绑定

				function show_data() {
					for(pagenum; pagenum < len; pagenum++) {
						if(tynum == null) {
							html += '<div class="pi-item">' +
								'<div class="item-content">' +
								'<span hidden="hidden">' + pagenum + ',</span>' +
								'<div class="ic-left">' +
								'<a>' + data[pagenum].companyName + '</a>' +
								'</div>' +
								'<div class="ic-center">' +
								'<a>' + data[pagenum].positions + '</a>' +
								'</div>' +
								'<div class="ic-right">' +
								'<a>' + data[pagenum].date + '</a>' +
								'</div>' +
								'</div>' +
								'</div>';
						} else {
							html += '<div class="pi-item">' +
								'<div class="item-content">' +
								'<span hidden="hidden">' + pagenum + ',</span>' +
								'<div class="ic-left">' +
								'<a> ' + data[pagenum].contact + '</a>' +
								'</div>' +
								'<div class="ic-center">' +
								'<a>' + data[pagenum].positions + '</a>' +
								'</div>' +
								'<div class="ic-right">' +
								'<a>' + data[pagenum].money + '</a>' +
								'</div>' +
								'</div>' +
								'</div>';
						}
					}
					div_arr[div_num].html(html);

					$('.item-content').click(function() {
						if(mydata.tp == 2) {
							if($.session.get('uid')) {
								var num = $(this).text().split(',')[0];
								var textx = data[num];
								var arr = [];
								var str = '';
								var i = 0;
								var numner = /^\+?[1-9][0-9]*$/;
								//将数据对象转换为json格式 储存到session中
								$.each(textx, function(k) {
									if(i == 0) {
										if(numner.test(textx[k])) {
											str += '' + k + ':' + textx[k] + '';
										} else {
											str += '' + k + ':' + textx[k] + '';
										}
										i++;
									} else {
										if(numner.test(textx[k])) {
											str += ',' + k + ':' + textx[k] + '';
										} else {
											str += ',' + k + ':' + textx[k] + '';
										}
									}
								});
								str += ''
								window.sessionStorage.setItem('per_datax' + num, str)

								window.open('recruit-details-2.html?num=' + num + '&tp=2', '_blank');

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
						} else {
							if($.session.get('uid')) {
								var num = $(this).text().split(',')[0];
								var textx = data[num];
								var arr = [];
								var str = '';
								var i = 0;
								var numner = /^\+?[1-9][0-9]*$/;
								//将数据对象转换为json格式 储存到session中
								$.each(textx, function(k) {
									if(i == 0) {
										if(numner.test(textx[k])) {
											str += '' + k + ':' + textx[k] + '';
										} else {
											str += '' + k + ':' + textx[k] + '';
										}
										i++;
									} else {
										if(numner.test(textx[k])) {
											str += ',' + k + ':' + textx[k] + '';
										} else {
											str += ',' + k + ':' + textx[k] + '';
										}
									}
								});
								str += ''
								window.sessionStorage.setItem('per_data' + num, str)

								window.open('recruit-details.html?num=' + num + '&tp=1', '_blank');

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
						}

					})

					//查看更多
					html_more += '<div class="more_whole"><div class="more_L"></div><div class="more" id="more">加载更多</div><div class="more_R"></div></div><div style="clear: both;"></div>';
					$('.dc-pages').html(html_more);

					$('#more').click(function() {
						if(len < 20) {
							alert('已经没有更多数据了')
						} else {
							mydata.page = mydata.page + 1;
							getdata_(html, curl_, mydata, div_num, tynum);
						}

					})
					//进入详情

				}
				/*第一次进入时*/
				if(pagenum == 0) {
					//首次进入直接使用初始参数
					show_data();
				}

			} else {
				alert('已经没有更多数据了')
			}
		},
		error: function(err) {
			console.log(err);
		}
	});
}
//检测登录
function isloginMinMax() {

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
		$("#faTimes3").click(function() {
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
/*************************** 苗木信息 我要发布 做正则判断(招聘发布) ***************************/

function validate() {
	result = true;
	//公司名称
	var userName = $('#Cname').val();
	//	招聘职位 
	var job = $('#job').val();
	//邮箱
	var enterprise = $('#enterprise').val();
	//内容
	var content = $('#content').val();
	//公司简介
	var companyIntro = $('#companyIntro').val();
	//企业地址
	var address = $('#address').val();
	//联系人
	var telpersonal = $('#telpersonal').val();
	//联系方式
	var tel = $('#tel').val();
	//工作地点
	var work = $('#work').val();
	//公司名称
	userName = $.trim(userName);
	if(userName == '') {
		document.getElementById('CnameTip').innerHTML = '<img src="../img/err.png"/><font color="red">公司名称不能为空！</font>'
		result = false;
	} else {
		document.getElementById('CnameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//招聘职位
	job = $.trim(job);
	if(job == '') {
		document.getElementById('jobTip').innerHTML = '<img src="../img/err.png"/><font color="red">招聘职位不能为空！</font>'
		result = false;
	} else {
		document.getElementById('jobTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//邮箱
	if(enterprise == ''){
		document.getElementById("enterpriseTip").innerHTML = '<img src="../img/err.png"/><font color="red">邮箱不能为空！</font>'
		result = false;
	}else if(!/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/.test(enterprise)) {
		document.getElementById('enterpriseTip').innerHTML = '<img src="../img/err.png"/><font color="red">请输入正确的邮箱地址！</font>'
		result = false;
	} else {
		document.getElementById('enterpriseTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//内容
	content = $.trim(content);
	if(content == '') {
		document.getElementById('contentTip').innerHTML = '<img src="../img/err.png"/><font color="red">内容不能为空！</font>'
		result = false;
	} else {
		document.getElementById('contentTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//公司简介
	companyIntro = $.trim(companyIntro);
	if(companyIntro == '') {
		document.getElementById('companyIntroTip').innerHTML = '<img src="../img/err.png"/><font color="red">公司简介不能为空！</font>'
		result = false;
	} else {
		document.getElementById('companyIntroTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//企业地址
	address = $.trim(address);
	if(address == '') {
		document.getElementById('addressTip').innerHTML = '<img src="../img/err.png"/><font color="red">企业地址不能为空！</font>'
		result = false;
	} else {
		document.getElementById('addressTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//联系人
	telpersonal = $.trim(telpersonal);
	if(telpersonal == '') {
		document.getElementById('telpersonalTip').innerHTML = '<img src="../img/err.png"/><font color="red">联系人不能为空！</font>'
		result = false;
	} else {
		document.getElementById('telpersonalTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//工作地点
	work = $.trim(work);
	if(work == '') {
		document.getElementById('workTip').innerHTML = '<img src="../img/err.png"/><font color="red">工作地点不能为空！</font>'
		result = false;
	} else {
		document.getElementById('workTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//	}
	//联系方式
	tel = $.trim(tel);
	if(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel) || /^0\d{2,3}-?\d{7,8}$/.test(tel)){
		//错误的提示
		document.getElementById('telTip').innerHTML = '<img src="../img/ok.png"/>';
	} else {
		document.getElementById('telTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的电话号码！</font>';
		result = false;
	}
	//alert("这是测试状态"+result);
	return result;
}

/*************************** 苗木信息 求职 做正则判断(求职发布) ***************************/
function validate1() {

	result = true;
	//姓名
	var telpersonal1 = $('#telpersonal1').val();
	var telpersonal1 = $('#telpersonal1').val();
	//职位
	var Cname1 = $('#Cname1').val();
	//工作经历
	var content1 = $('#content1').val();
	//联系方式
	var tel1 = $('#tel1').val();
	//邮箱
	var enterprise1 = $('#enterprise1').val();
	//自我评价
	var companyIntro1 = $('#companyIntro1').val();
	/*姓名*/
	if(telpersonal1 == '') {
		$('#telpersonal1Tip').html('<img src="../img/err.png"/><font color="red">姓名不能为空！</font>');
		result = false;
	} else {
		$('#telpersonal1Tip').html('<img src=""../img/ok.png"">');
	}
	/*职位*/
	if(Cname1 == '') {
		$('#Cname1Tip').html('<img src="../img/err.png"/><font color="red">职位不能为空！</font>');
		result = false;
	} else {
		$('#Cname1Tip').html('<img src=""../img/ok.png"">');
	}
	/*求职经历*/
	if(content1 == '') {
		$('#content1Tip').html('<img src="../img/err.png"/><font color="red">求职经历不能为空！</font>');
		result = false;
	} else {
		$('#content1Tip').html('<img src=""../img/ok.png"">');
	}
	/*联系方式*/
	if(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel1) || /^0\d{2,3}-?\d{7,8}$/.test(tel1)) {
		$('#tel1Tip').html('<img src=""../img/ok.png"">');
		
	} else {
		$('#tel1Tip').html('<img src="../img/err.png"/><font color="red">联系方式不能为空！</font>');
		result = false;
	}
	/*邮箱*/
	if(enterprise1 == '') {
		$('#enterprise1Tip').html('<img src="../img/err.png"/><font color="red">邮箱不能为空！</font>');
		result = false;
	} else if(!/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/.test(enterprise1)) {
		document.getElementById('enterpriseTip').innerHTML = '<img src="../img/err.png"/><font color="red">请输入正确的邮箱地址！</font>'
		result = false;
	}
	else {
		$('#enterprise1Tip').html('<img src=""../img/ok.png"">');
	}
	/*自我评价*/
	if(companyIntro1 == '') {
		$('#companyIntro1Tip').html('<img src="../img/err.png"/><font color="red">自我评价不能为空！</font>');
		result = false;
	} else {
		$('#companyIntro1Tip').html('<img src=""../img/ok.png"">');
	}
	return result;
};
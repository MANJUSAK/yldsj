/*---------------------------------- 需求发布-苗木信息js(部分js已经写到了页面里) ---------------------------------*/
$(function() {
	//鼠标移入
	$(".li-qm").mouseover(function() {
		$(".ni-li2-item").css("display", "block");
	});
	//鼠标移除
	$(".ni-li2-item").mouseover(function() {
		$(".ni-li2-item").css("display", "block");
	});
	//点击我要发布
	$("#aFirst").click(function() {
		$("#niYaler").css({"display": "block","position": "absolute","height":$("body").height() + "px"});
	});
	//没有登录时，右上角的叉
	$("#itemInner").click(function() {
		$("#niYaler").css("display", "none");
	});
	//取消按钮
	$("#fcAim").click(function() {
		$("#niYaler").css("display", "none");
	});
	//所以的右上角的叉
	$("#niClose").click(function() {
		$("#niYaler").css("display", "none");
	});
	//信息发布右上角的叉
	$("#faTimes2").click(function() {
		$("#niYaler").css("display", "none");
	});

	//获取浏览器宽度
	var winWidth;
	if(window.innerWidth) {
		winWidth = window.innerWidth;
	} else if((document.body) && (document.body.clientWidth)) {
		winWidth = document.body.clientWidth
	}
	if(winWidth > 1024) {
		$(window).scroll(function() {
			if($('#niYaler').css("display") == "block") {
				var scrollTop = $(document).scrollTop();
				if(scrollTop >= 150) {
					$(document).scrollTop()
				}
			}
		});

	} else {
		$('.ny-box').css('margin-top', '33px');
	}
})
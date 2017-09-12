/***----------------------------------- 点击返回到顶部 -------------------------------------*/
var returnTop = $('#goTop');
returnTop.click(function() {
	/*var id = setInterval(function() {
		var scrollTop = $(document).scrollTop();
		var speed = scrollTop / -20;
		scrollBy(0, Math.floor(speed));
		if (scrollTop <= 0) {
			clearInterval(id);
		}
	}, 40);*/
	$("html,body").animate({
		scrollTop: 0
	}, 500);
});
$(window).scroll(function() {
	var scrollTop = $(document).scrollTop();
	var topBar = $('#myp');
	if(scrollTop >= 250) {
		topBar.fadeIn('slow');
	} else {
		topBar.fadeOut('slow');
	}
});
$(window).scroll(function() {
	var scrollTop = $(document).scrollTop();
	var myicon = $("#myIcon");
	if(scrollTop >= 350) {
		myicon.fadeIn('slow');
	} else {
		myicon.fadeOut('slow');
	}
});
/***----------------------------------- 点击返回到顶部  结束 -------------------------------------*/
/********************************* 我的（个人中心） 切换卡 ********************************/

$("#tc-rtl_manage1").click(function() {
	$("#mb-footer_pact").css({
		"display": "none"
	});
	$("#mb-footer_nom").css({
		"display": "block"
	});
	$("#tc-rtl_manage2").css({
		"background-color": "#67BCFA"
	})
	$("#tc-rtl_manage1").css({
		"background-color": "#0096FD"
	})
});
$("#tc-rtl_manage2").click(function() {
	$("#mb-footer_nom").css({
		"display": "none"
	});
	$("#mb-footer_pact").css({
		"display": "block"
	});
	$("#tc-rtl_manage1").css({
		"background-color": "#67BCFA"
	})
	$("#tc-rtl_manage2").css({
		"background-color": "#0096FD"
	})
});

/********************************* 我的 （个人中心）切换卡 结束 ********************************/
/******************************* my（个人中心）里的蒙层 *********************************/
mymc();

function mymc() {
	$(".mymc_err").click(function() {
		$(".mymc_content").hide();
	});
	$(".mypact").click(function() {
		$(".mymc_content").show();
	});

	/******* 点击的时候遍历下面的图片 *******/
	$(".mypact").click(function() {
		var str = [];
		$(".mymc_center").children().remove();
		$(this).siblings().children("img").each(function(index) {
			//获取图片的路径
			str[index] = $(this).attr("src");
		});
		for(var i = 0; i < str.length; i++) {
			var imgstr = $("<img src='" + str[i] + "'/>");
			imgstr.appendTo($(".mymc_center"));
		}
		str = [];
		var ct = $(document.body).height();
		$(".mymc_center").css("min-height", ct + "px");
	});
	/******* 点击的时候遍历下面的图片 结束 *******/
}

/******************************* my（个人中心）里的蒙层 结束 *********************************/

/******* 需求发布-苗木信息：获取屏幕为移动端的时候，阻止乔木信息和草本植物的href （nursery_information.php）********/
//var ssls = window.screen.width;
window.onresize = function() {
	phone_width();
}
phone_width();

function phone_width() {
	//获取浏览器的宽度
	var phoneWidth = window.screen.width;
	if(phoneWidth < 500) {
		//阻止a标签的点击事件
		$(".ni-lc-left > ul > li:eq(1) > a").attr("href", "JavaScript:");
		$(".ni-lc-left > ul > li:eq(4) > a").attr("href", "JavaScript:");
	}
}

/******* 需求发布-苗木信息：获取屏幕为移动端的时候，阻止乔木信息和草本植物的href （nursery_information.php） 结束 ********/
/*------------------------------ 使用在forms文件下的php文件 ，获取图片的高度，控制，因为在每个页面添加的 ------------------------------*/
//因为页面不一样，使用的样式不一样，所以会获取多个的点击样式
window.onload=function(){
	//选择最大和最小的时间
	timeMin_Max();
}

$(".mengcheng_center_absolute").click(function() {
	$(".mengcheng").hide();
});
/*******************************
 * 因为ul之前的class名不一样，所以会使用多个js
 * **********************************/
//找到需要的图片
$(".ci-content > ul > li >img").click(function() {
	var lujing;
	lujing = $(this).attr("src");
	$(".mengcheng").show();
	//改变图片的路径
	$(".mengcheng_center_img").prop("src", lujing);
	var height1 = $(document.body).height();
	var height2 = $(".mengcheng_center_img").height();

	if (height1 > height2) {
		$(".mengcheng").css("height", height1 - 200 + "px");
	}
	if (height1 < height2) {
		$(".mengcheng").css("height", height2 + "px");
	}
	//	$(".mengcheng").css("","");
});

$(".cii-content > ul > li >img").click(function() {
	var lujing;
	lujing = $(this).attr("src");
	$(".mengcheng").show();
	//改变图片的路径
	$(".mengcheng_center_img").prop("src", lujing);
	var height1 = $(document.body).height();
	var height2 = $(".mengcheng_center_img").height();

	if (height1 > height2) {
		$(".mengcheng").css("height", height1 - 200 + "px");
	}
	if (height1 < height2) {
		$(".mengcheng").css("height", height2 + "px");
	}
	//	$(".mengcheng").css("","");
});

$(".ao-content > ul > li >img").click(function() {
	var lujing;
	lujing = $(this).attr("src");
	$(".mengcheng").show();
	$(".mengcheng_center_img").prop("src", lujing);
	var height1 = $(document.body).height();
	var height2 = $(".mengcheng_center_img").height();

	if (height1 > height2) {
		$(".mengcheng").css("height", height1 - 200 + "px");
	}
	if (height1 < height2) {
		$(".mengcheng").css("height", height2 + "px");
	}
	//	$(".mengcheng").css("","");
});

$(".pp-content > ul > li >img").click(function() {
	var lujing;
	lujing = $(this).attr("src");
	$(".mengcheng").show();
	$(".mengcheng_center_img").prop("src", lujing);
	var height1 = $(document.body).height();
	var height2 = $(".mengcheng_center_img").height();
	if (height1 > height2) {
		$(".mengcheng").css("height", height1 - 200 + "px");
	}
	if (height1 < height2) {
		$(".mengcheng").css("height", height2 + "px");
	}
	//	$(".mengcheng").css("","");
});
/*******************************
 * 因为ul之前的class名不一样，所以会使用多个js,  结束
 * **********************************/

/*************************选择最大和最小的时间**************************/
function timeMin_Max() {
	var date = new Date();
	var seperator1 = "-";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	//
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	$(".dateMax").prop("max", currentdate);
	$(".dateMin").prop("min", currentdate);
}
/*************************选择最大和最小的时间 结束**************************/
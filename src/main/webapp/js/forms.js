/*--------------------------forms 文件下的页面js；点击添加按钮动态的 --------------------------*/
$(function() {
	//点击添加按钮显示和隐藏下面需要填写并提交的表单
	$("#iirRight").click(function() {
		$("#iiForms").slideToggle();
	});
	
	var winWidth;
	if(window.innerWidth) {
		winWidth = window.innerWidth;
	} else if((document.body) && (document.body.clientWidth)) {
		winWidth = document.body.clientWidth
	}
	if(winWidth <= 1024) {
		//响应表单菜单显示隐藏
		$(".iisc-left-content").css('display', 'none');
		var il = 1;
		$(".iisc-left").click(function() {
			if(il == 1) {
				$(this).css("width", "218.55px");
				$(".iisc-left-content").css('display', 'block');
				il = 0;
			} else {
				$(this).css("width", "50px");
				$(".iisc-left-content").css('display', 'none');
				il++;
			}
		})
	}
});
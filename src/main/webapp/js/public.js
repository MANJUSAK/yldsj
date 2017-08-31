$(function() {

	var login_ = '';
	/*用户登录信息替换*/
	if($.session.get('uname')) {
		login_ += '<div class="rl-box2" style="display:block">' +
			'<div class="box2-left">' +
			'<span id="show_uname">欢迎您：' + $.session.get('uname') + '</span>' +
			'' +
			'</div>' +
			'<div class="box2-right">' +
			'<span>退出</span>' +
			'</div>' +
			'</div>';
		$('#rb_login').html(login_);

	} else {
		login_ += '<div class="rl-box">' +
			'<div class="rl-left">' +
			'<a href="../login/login.html">' +
			'<i class="fa fa-user"></i> <span>登录&nbsp;&nbsp;&nbsp;</span>' +
			'</a>' +
			'</div>' +
			'<div class="rl-right">' +
			'<a href="../login/register_user.html">' +
			'&nbsp;&nbsp;&nbsp;<i class="fa fa-pencil-square-o"></i> <span>注册</span>' +
			'</a>' +
			'</div>' +
			'</div>';
		$('#rb_login').html(login_);
	}

	/******导航*******/

	$('.hn-nav2 .hn-nav2-item').click(function() {
		$.session.set('xq_num', $(this).index());
		$.session.get('xq_num');
	})
	if($.session.get('header_num') == 1) {
		//$.session.set('xq_num', 0);
		$('.hn-nav2 .hn-nav2-item').removeClass("hni_active");
		$('.hn-nav2 .hn-nav2-item').eq($.session.get('xq_num')).addClass("hni_active");
	} else {
		$.session.set('xq_num', 0);
		$('.hn-nav2 .hn-nav2-item').removeClass("hni_active");
		$('.hn-nav2 .hn-nav2-item').eq(0).addClass("hni_active");
	}
})
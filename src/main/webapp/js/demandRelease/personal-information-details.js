$(function() {
	//获取区分参数
	var num = GetQueryString('num');
	var tp = GetQueryString('tp');
	var html = '';
	var html_ = '';
	var data;
	var arr_one = [];
	//拼接sessionStorage key		获取该页数据
	if(tp==1){
		data = sessionStorage.getItem('per_data' + num);
	}else{
		data = sessionStorage.getItem('per_datax' + num);
	}
	
	if(data == null) {
		window.location.href = "personal-information.html";
	}
	if(data != null) {
		arr_frist = data.split(',');
	}
	var arr_len = arr_frist.length;

	for(var i = 0; i < arr_len; i++) {
		var arr_ = arr_frist[i].split(':');
		if(arr_[0] == 'picture') {
			arr_[1] = arr_[2];
		}
		arr_one[arr_[0]] = arr_[1];
	}
	var characters = arr_one['characters'] > 1 ? '兼职' : '全职';
	if(tp == 1) {
		html += '<div class="Rdt-left">' +
			'<div class="Rdtl-content">' +
			'<p>' + arr_one['positions'] + '</p>' +
			'<p>' + arr_one['companyName'] + '&nbsp;&nbsp;&nbsp;&nbsp;招聘</p>' +
			'<p>' +
			'<span>待遇：' + arr_one['money'] + '&nbsp;&nbsp;/&nbsp;&nbsp;</span>' +
			'<span>工作地点： ' + arr_one['workAdress'] + '&nbsp;&nbsp;/&nbsp;&nbsp;</span>' +
			/*'<span>从业经历要求： ' + arr_one['experience'] + '&nbsp;&nbsp;/&nbsp;&nbsp;</span>' +*/
			'<span>类型：' + characters + '</span>' +
			'</p>' +
			'<p>发布时间：' + arr_one['date'] + '</p>' +
			'</div>' +
			'</div>' +
			'<div class="Rdt-right">' +
			'<span>投个简历</span>' +
			'</div>';
		$('#PID_cL_tenter_one').html(html)

		html_ += '<div class="Rdb-left">' +
			'<div class="Rdbl-content">' +
			'<span>职位描述：</span>' +
			'<p>' + arr_one['content'] + '</p>' +
			/*'<span>任职要求：</span>' +
			'<p></p>' +
			'<p></p>' +
			'<p></p>' +*/
			'<span>职位发布者：</span>' +
			'<p>' + arr_one['contact'] + '</p>' +
			'<span>联系方式：</span>' +
			'<p>' + arr_one['tel'] + '</p>' +
			'</div>' +
			'</div>' +
			'<div class="Rdb-right">' +
			'<span>公司简介：</span>' +
			'<p>' + arr_one['companyIntro'] + '</p>' +
			'</div>';
		$('#PID_cL_tenter_two').html(html_)
	} else {
		var htmlx = '<div class="RD2_center">' +
			'<p class="RD2_center_title">求职职位</p>' +
			'<p>姓名：<span>'+arr_one['contact']+'</span></p>' +
			'<p>求职类型：<span>'+characters+'</span></p>' +
			'<p>职位月薪：<span>'+arr_one['money']+'</span></p>' +
			'<p>联系电话：<span>'+arr_one['tel']+'</span></p>' +
			'<p>邮箱：<span>'+arr_one['email']+'</span></p>' +
			'<p class="text_index">工作经历：<br /><span>'+arr_one['experience']+'</span></p>' +
			'<p class="text_index"> 自我评价：<br /><span>'+arr_one['evaluate']+'</span></p>' +
			'</div>';
			$('.RD2_content').html(htmlx);
	}

	//获取区分参数
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	}
})
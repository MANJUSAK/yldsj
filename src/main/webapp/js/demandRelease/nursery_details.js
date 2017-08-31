$(function() {
	//获取区分参数
	//var num = GetQueryString('num');
	var html = '';
	var html_ = '';
	var arr_one;
	//拼接sessionStorage key		获取该页数据
	var data = sessionStorage.getItem('datax')
	console.log(data)

	if(data == null) {
		window.location.href = "nursery-information.html";
	}
	arr_one = JSON.parse(data);

	html += '<div class="nds-topbar-content">' +
		'<div class="nds-tc-left">' +
		'<div class="nds-tc-left_center">' +
		'<img src="' + arr_one.picture + '" />' +
		'</div>' +
		'						</div>' +
		'						<div class="nds-tc-center">' +
		'							<div class="nds-tcc-aim">' +
		'								<h3>' + arr_one.titleName + '</h3>' +
		'								<div class="tcc-ul">' +
		'									<ul>' +
		'										<li>供应商：' + arr_one.supplier + '</li>' +
		'										<li>发布时间：' + arr_one.date + '</li>' +
		'										<li>供应地点：' + arr_one.address + '</li>' +
		'									</ul>' +
		'								</div>' +
		'								<div class="tcc-inner">' +
		'</div>' +
		'</div>' +
		'<div class="nds-tc-right">' +
		'<div class="nds-tcr-title">' +
		'	<span>供应商信息</span>' +
		'</div>' +
		'<p>' + arr_one.supplier + '</p>' +
		'<ul>' +
		'<li>联系人：' + arr_one.contact + '</li>' +
		//'<li>所在地：浙江 萧山</li>' +
		'<li>地址：' + arr_one.address + '</li>' +
		//'<li>手机：12345678912</li>' +
		'<li>电话：' + arr_one.tel + '</li>' +
		'<li>认证：已认证</li>' +
		'</ul>' +
		'</div>' +
		'</div>';
	$('.nds-topbar').html(html);

	html_ += '<div class="nds-fc-title">' +
		'<span><a href="">详细说明</a></span>' +
		'</div>' +
		'<p>&nbsp;&nbsp;' + arr_one.content + '</p>' +
		'<div class="fc-footer">' +
		'<div class="ff-box">' +
		'<div class="ffb-title">' +
		'<span>' + arr_one.supplier + '提供，致电了解详情</span>' +
		'</div>' +
		'<div class="ffb-content">' +
		'<div class="ffb-icon">' +
		'<i class="fa fa-volume-control-phone"></i>' +
		'</div>' +
		'<div class="ffb-text">' +
		'<h2>' + arr_one.tel + '</h2>' +
		'<h2></h2><br />' +
		'<p>联系时请说明是在园林诚信平台上看到的，谢谢。</p>' +
		'</div>' +
		'</div>' +
		'</div>' +
		'</div>' +
		'<div class="ffb-inner">' +
		'<span><a href="../demandRelease/nursery-information.html"><i class="fa fa-angle-double-left"></i>&nbsp;&nbsp;&nbsp;返回列表</a></span>' +
		'</div>';
	$('#xxsm').html(html_);
	//获取区分参数
	function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串
		if(url.indexOf("?") != -1) { //判断是否有参数
			var str = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
			strs = str.split("="); //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
			return strs[1]; //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
		}
	}

	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if(r != null) return unescape(r[2]);
		return null;
	}
})
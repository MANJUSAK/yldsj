$(function() {
	//获取区分参数
	var html = '';
	var html_ = '';
	var arr_one;
	//拼接sessionStorage key		获取该页数据
	var data = sessionStorage.getItem('dem_data');
	if(data==null){
		window.location.href="demand-release.html";
	}
	console.log(data)
	arr_one = JSON.parse(data);
	html += '<div class="nds-topbar-content">' +
		'<div class="nds-tc-left">' +
		'<div class="nds-tc-left_center">' +
		'<img src="'+ arr_one.picture + '" />' +
		'</div>' +
		'</div>' +
		'<div class="nds-tc-center">' +
		'<div class="nds-tcc-aim">' +
		'<h3>' + arr_one.titleName + '</h3>' +
		'<div class="tcc-ul">' +
		'<ul>' +
		'<li>联系人：&nbsp;' + arr_one.contact + '</li>' +
		'<li>联系电话：&nbsp;' + arr_one.tel + '</li>' +
		'<li>发布时间：&nbsp;' + arr_one.date + '</li>' +
		'<li>认证：&nbsp;已认证</li>' +
		'</ul>' +
		'</div>' +
		'<div class="tcc-inner">' +
		'</div>' +
		'</div>' +
		'</div>' +
		'<div class="nds-tc-right" style="display: none">' + 
		'<div class="nds-tcr-title">' +
		'<span>供应商信息</span>' +
		'</div>' +
		'<p>' + arr_one.titleName + '</p>' +
		'<ul>' +
		'<li>联系人：' + arr_one.contact['date'] + '</li>' +
		'<li>电话：' + arr_one['tel'] + '</li>' +
		'<li>认证：已认证</li>' +
		'</ul>' +
		'</div>' +
		'</div>';
	$('.nds-topbar').html(html);
	html_ += '<div class="nds-fc-title">' +
		'<span><a href="">详细说明</a></span>' +
		'</div>' +
		'<p>' +
		'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + arr_one.content + '' +
		'</p>' +
		'<div class="fc-footer">' +
		'<div class="ff-box">' +
		'<div class="ffb-title">' +
		'<span>' + arr_one.contact + '提供，致电了解详情</span>' +
		'</div>' +
		'<div class="ffb-content">' +
		'<div class="ffb-icon">' +
		'<i class="fa fa-volume-control-phone"></i>' +
		'</div>' +
		'<div class="ffb-text">' +
		'<h2>12345678912</h2>' +
		'<h2>4001-123-123</h2><br />' +
		'<p>联系时请说明实在园林诚信平台上看到的，谢谢。</p>' +
		'</div>' +
		'</div>' +
		'</div>' +
		'</div>' +
		'<div class="ffb-inner">' +
		'<span><a href="../demandRelease/demand-release.html"><i class="fa fa-angle-double-left"></i>&nbsp;&nbsp;&nbsp;返回列表</a></span>' +
		'</div>';

	$('.nds-fc-left').html(html_);
	
})
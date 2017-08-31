$(function() {
	var host = window.sessionStorage.getItem('Host');
	var page = 0;
	//行业协会默认信息
	var url_guild = [];
	url_guild[0] = host + '/hyxh/find/dtzx?page=' + page + '&tp=1'; //协会动态
	url_guild[1] = host + '/hyxh/find/dtzx?page=' + page + '&tp=2'; //行业动态
	url_guild[2] = host + '/hyxh/find/dtzx?page=' + page + '&tp=3'; //媒体报道
	url_guild[3] = host + '/hyxh/find/hf?page=' + page + ''; //会员展示
	url_guild[4] = host + '/hyxh/find/yzgc?page=' + page + ''; //优质工程
	url_guild[5] = host + '/hyxh/find/hyhf?page=' + page + '&member=0'; //会费展示
	url_guild[6] = host + '/hyxh/find/cont/xhpx?page=' + page + ''; //培训信息
	url_guild[7] = host + '/hyxh/find/dtzx?page=' + page + '&tp=4'; //公告通知
	url_guild[8] = host + '/hyxh/find/zcfg?page=' + page + ''; //政策法规
	url_guild[9] = host + '/hyxh/find/zlxz?page=' + page + ''; //资料下载

	//数据绑定位置获取
	var dtzx1 = $('#dtzx1'), //协会动态
		dtzx2 = $('#dtzx2'), //行业动态
		dtzx3 = $('#dtzx3'), //媒体报道
		dtzx4 = $('#dtzx4'), //公告通知
		hyhf = $('#hyhf'); //会费展示

	var yzgc = $('#yzgc'), //优质工程
		hf = $('#hf'), //会员展示
		xhpx = $('#xhpx'), //培训信息
		zcfg = $('#zcfg'), //政策法规
		zlxz = $('#zlxz'); //资料下载
	//列表页
	$('#dtzx123').html(get_list_page('?first=1&second=0')); //协会动态
	$('#hf1').html(get_list_page('?first=2')); //会员展示
	$('#yzgc1').html(get_list_page('?first=3')); //优质工程
	$('#hyhf1').html(get_list_page('?first=4')); //会费展示
	$('#xhpx1').html(get_list_page('?first=5')); //培训信息
	$('#dtzx44').html(get_list_page('?first=6')); //公告通知
	$('#zcfg1').html(get_list_page('?first=7')); //政策法规
	$('#zlxz1').html(get_list_page('?first=8')); //资料下载
	$('.GCmL_tabLi').click(function() {
		switch($(this).index()) {
			case 0:
				$('#dtzx123').html(get_list_page('?first=1&second=0')); //协会动态
				break;
			case 1:
				$('#dtzx123').html(get_list_page('?first=1&second=1')); //行业动态
				break;
			case 2:
				$('#dtzx123').html(get_list_page('?first=1&second=2')); //媒体报道
				break;
		}
	})
	//页面绑定参数
	var url_guild_parameter = [];
	url_guild_parameter0 = ['title', 'date']; //协会动态
	url_guild_parameter1 = ['title', 'date']; //行业动态
	url_guild_parameter2 = ['title', 'date']; //媒体报道
	url_guild_parameter3 = ['name', 'date']; //会员展示
	url_guild_parameter4 = ['engName', 'date']; //优质工程
	url_guild_parameter5 = ['name', 'project', 'date']; //会费展示
	url_guild_parameter6 = ['traName', 'date']; //培训信息
	url_guild_parameter7 = ['title', 'date']; //公告通知
	url_guild_parameter8 = ['date']; //政策法规
	url_guild_parameter9 = ['date']; //资料下载

	//详情页面
	//格式     dues-show/detail?source=0&page='+page+'&number=
	//source 区分请求来源与列表页或者是首页	page 数据页码	number 数据下标
	var html_detail_url = [];
	html_detail_url[0] = 'guild-details.html?first=1&second=0&num='; //协会动态
	html_detail_url[1] = 'guild-details.html?first=1&second=1&num='; //行业动态
	html_detail_url[2] = 'guild-details.html?first=1&second=2&num='; //媒体报道
	html_detail_url[3] = 'member_show_details.html?first=2&num='; //会员展示
	html_detail_url[4] = 'qe-details.html?first=3&num='; //优质工程
	html_detail_url[5] = 'dues_show_details.html?first=4&num='; //会费展示
	html_detail_url[6] = 'Association-Training-details.html?first=5&num='; //培训信息
	html_detail_url[7] = 'dynamic-information-details.html?first=6&num='; //公告通知
	html_detail_url[8] = '?first=7&num='; //政策法规
	html_detail_url[9] = '?first=8&num='; //资料下载
	//请求数据
	get_data(url_guild[0], null, dtzx1, url_guild_parameter0, html_detail_url[0], 0); //协会动态
	get_data(url_guild[1], null, dtzx2, url_guild_parameter1, html_detail_url[1], 0); //行业动态
	get_data(url_guild[2], null, dtzx3, url_guild_parameter2, html_detail_url[2], 0); //媒体报道
	get_data(url_guild[3], null, hf, url_guild_parameter3, html_detail_url[3], 3); //会员展示
	get_data(url_guild[4], null, yzgc, url_guild_parameter4, html_detail_url[4], 4); //优质工程
	get_data(url_guild[5], null, hyhf, url_guild_parameter5, html_detail_url[5], 5); //会费展示
	get_data(url_guild[6], null, xhpx, url_guild_parameter6, html_detail_url[6], 6); //培训信息 
	get_data(url_guild[7], null, dtzx4, url_guild_parameter7, html_detail_url[7], 7); //公告通知

});

//数据请求	       请求地址	请求参数	 绑定位置    绑定参数	详情地址
function get_data(url_g, datax, htmlx, html_data, html_detail, click_position) {
	$.ajax({
		type: "post",
		url: url_g,
		data: datax,
		async: true,
		success: function(result) {
			//
			if(result.errorCode != 0) {
				console.log(url_g)
			}
			if(result.errorCode == 404) {
				htmlx.html('还没有此类数据');
			} else if(result.errorCode == 0) {
				var data = result.data;
				var len = data.length;
				var html = '';
				if(len > 9) {
					len = 9;
				}
				//遍历数据
				$.each(data, function(i) {
					html += '<li class="GCmLc_li">' +
						'<i class="fa fa-square"></i><a><span class="GCmRc_liName">'; //拼接进入详情页参数
					$.each(html_data, function(n) {
						if(n == html_data.length - 1) {
							html += '</span><span class="GCmRc_liDate">' + data[i][html_data[n]] + '</span>';
						} else {
							html += data[i][html_data[n]] + '&nbsp;&nbsp;&nbsp;&nbsp;';
						}
					});
					html += '</a></li>';
				});
				//绑定数据
				htmlx.html(html);
				//进入详情页
				switch(click_position) {
					case 0:
						//动态资讯
						$('.GC_mL').on('click', '.GCmL_content ul li', function() {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num, '_blank');
						})
						break;
					case 3:
						//会员展示 
						/*$('.GC_mR').on('click', '.GCmR_content ul li', function() {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num, '_blank');
						})*/
						//会有展示---->转会费展示页面
						$('.GC_mR').on('click', '.GCmR_content ul li', function() {
							if($.session.get('uid') && $.session.get('umember') == 0) {
								var num = $(this).index();
								window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
								window.open(html_detail + num, '_blank');
							} else {
								alert('您没有登录不能查看该项详细内容')
							}
						})
						break;
					case 4:
						//优质工程
						$('.GC_show').on('click', '.GCaL_content ul li', function() {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num, '_blank');
						})
						break;
					case 5:
						//会费展示
						$('.GC_project').on('click', '.GCaR_content ul li', function() {
							if($.session.get('uid') && $.session.get('umember') == 0) {
								var num = $(this).index();
								window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
								window.open(html_detail + num, '_blank');
							} else {
								alert('您没有权限查看该项详细内容')
							}
						})

						break;
					case 6:
						//培训信息 
						$('.GC_train').on('click', '.GCtL_content ul li', function() {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num, '_blank');
						})
						break;
					case 7:
						//公告通知
						$('.GC_inform').on('click', '.GCtR_content ul li', function() {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num, '_blank');
						})
						break;
				}
			}
		},
		error: function(e) {
			//
			console.log(e.status)
		}
	});
}

//列表页跳转url绑定  	跳转参数
function get_list_page(url_para) {
	var html = '<a target="_blank" href="listx.html' + url_para + '">更多>></a>';
	return html;
}
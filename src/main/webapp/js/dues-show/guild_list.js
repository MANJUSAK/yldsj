var html = '';
$(function() {
	
	//设置请求地址
	var host = window.sessionStorage.getItem('Host');
	//设置条目信息
	var pages = 0;
	//设置导航路径
	var modular = ['会员展示', '优质工程', '会费展示', '培训信息', '公告通知', '政策法规', '资料下载'];
	var modulars = ['协会动态', '行业动态', '媒体报道'];
	//获取url参数判断展示信息
	var parament = 0;
	var paraments = 0;
	//行业协会默认信息
	var url_guild = [];
	url_guild[0] = host + '/hyxh/find/dtzx'; //协会动态
	url_guild[1] = host + '/hyxh/find/dtzx'; //行业动态
	url_guild[2] = host + '/hyxh/find/dtzx'; //媒体报道
	url_guild[3] = host + '/hyxh/find/hf'; //会员展示
	url_guild[4] = host + '/hyxh/find/yzgc'; //优质工程
	url_guild[5] = host + '/hyxh/find/hyhf'; //会费展示
	url_guild[6] = host + '/hyxh/find/cont/xhpx'; //培训信息
	url_guild[7] = host + '/hyxh/find/dtzx'; //公告通知
	url_guild[8] = host + '/hyxh/find/zcfg'; //政策法规
	url_guild[9] = host + '/hyxh/find/zlxz'; //资料下载
	//页面绑定参数
	var url_guild_parameter = [];
	url_guild_parameter[0] = ['title', 'date']; //协会动态
	url_guild_parameter[1] = ['title', 'date']; //行业动态
	url_guild_parameter[2] = ['title', 'date']; //媒体报道
	url_guild_parameter[3] = ['name', 'date']; //会员展示
	url_guild_parameter[4] = ['engName', 'date']; //优质工程
	url_guild_parameter[5] = ['name', 'project', 'date']; //会费展示
	url_guild_parameter[6] = ['traName', 'date']; //培训信息
	url_guild_parameter[7] = ['title', 'date']; //公告通知
	url_guild_parameter[8] = ['date']; //政策法规
	url_guild_parameter[9] = ['date']; //资料下载

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
	//设置请求参数
	var datax = [];
	datax[0] = {
		page: pages,
		tp: 1
	}; //协会动态
	datax[1] = {
		page: pages,
		tp: 2
	}; //行业动态
	datax[2] = {
		page: pages,
		tp: 3
	}; //媒体报道
	datax[3] = {
		page: pages
	}; //会员展示
	datax[4] = {
		page: pages
	}; //优质工程
	datax[5] = {
		page: pages,
		member: 0
	}; //会费展示
	datax[6] = {
		page: pages
	}; //培训信息
	datax[7] = {
		page: pages,
		tp: 4
	}; //公告通知
/*	var show_id = ['#show_xhdt', '#show_hydt', '#show_mtbd', '#show_hyzs', '#show_yzgc', '#show_hfzs', '#show_pxxx', '#show_ggtz'];

	function refresh() {
		$.each(show_id, function(i) {
			console.log(i)
		});
	}*/
	$('#zixun,#xhdt').click(function() {
		var index = 0;
		
		htmlxx = '#show_xhdt';
		get_data(html, url_guild[index], datax[index], '#show_xhdt', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#hydt').click(function() {
		var index = 1;
		
		htmlxx = '#show_hydt';
		get_data(html, url_guild[index], datax[index], '#show_hydt', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#mtbd').click(function() {
		var index = 2;
		
		htmlxx = '#show_mtbd';
		get_data(html, url_guild[index], datax[index], '#show_mtbd', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#hyzs').click(function() {
		var index = 3;
		
		htmlxx = '#show_hyzs';
		get_data(html, url_guild[index], datax[index], '#show_hyzs', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#yzgc').click(function() {
		var index = 4;
		
		htmlxx = '#show_yzgc';
		get_data(html, url_guild[index], datax[index], '#show_yzgc', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#hfzs').click(function() {
		var index = 5;
		
		htmlxx = '#show_hfzs';
		get_data(html, url_guild[index], datax[index], '#show_hfzs', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#pxxx').click(function() {
		var index = 6;
		
		htmlxx = '#show_pxxx';
		get_data(html, url_guild[index], datax[index], '#show_pxxx', url_guild_parameter[index], html_detail_url[index], index);
	})
	$('#ggtz').click(function() {
		var index = 7;
		
		htmlxx = '#show_ggtz';
		get_data(html, url_guild[index], datax[index], '#show_ggtz', url_guild_parameter[index], html_detail_url[index], index);
	})

	/*$(htmlxx).on('click','ul li',function(){
		console.log($(this).index());
	})*/
})

//数据请求	      请求内容	请求地址	请求参数	 绑定位置    绑定参数	详情地址		判断页面
function get_data(html, url_g, datax, htmlx, html_data, html_detail, numbers) {
	
	var div_li = $(htmlx + ' ul');
	var div_more = $(htmlx + ' div');
	$.ajax({
		type: "post",
		url: url_g,
		data: datax,
		cache: false,
		async: true,
		success: function(result) {
			if(result.errorCode == 0) {
				var data = result.data;
				var len = data.length;
				//遍历数据
				$.each(data, function(i) {
					html += '<li class="li_deatail">' +
						'<i></i><a><span>'; //拼接进入详情页参数
					$.each(html_data, function(n) {
						if(n == html_data.length - 1) {
							html += '</span><span style="float:right;padding-right:10px;">' + data[i][html_data[n]] + '</span></a>';
						} else {
							html += data[i][html_data[n]] + '&nbsp;&nbsp;&nbsp;&nbsp;';
						}
					});
					html += '</a></li>';
				});
				div_li.html(html);
				var html_ = '';
				html_ += '<div class="more" id="more">' +
					'<div class="more-left"></div>' +
					'<div class="more-item">加载更多</div>' +
					'<div class="more-left"></div>' +
					'</div>';

				//绑定数据
				div_more.html(html_);
				//展示更多数据
				$(htmlx + ' #more').click(function() {

					if(len < 20) {
						alert('没有更多数据了')
					} 
					else {
						datax.page = datax.page + 1;
						get_data(html, url_g, datax, htmlx, html_data, html_detail, numbers);
					}

				})
				//进入详情
			
					$(".li_deatail").click(function(){
					//判断是否登录	不登录则不能查看详情
					if($.session.get('uid')) {
						//判断是否未会员查看项	非会员不能查看详情
						if(numbers == 5 || numbers == 3) {
							if($.session.get('umember') == 0) {
								var num = $(this).index();
								window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
								window.open(html_detail + num + '&page=' + datax.page, '_blank');
							}
							 else {
								alert('您还不是会员，不能查看本项更多内容');
							}
						} else {
							var num = $(this).index();
							window.sessionStorage.setItem('detail_data', JSON.stringify(result.data[num]));
							window.open(html_detail + num + '&page=' + datax.page, '_blank');
						}

					} 
					else {
						alert('查看详情需要登录')
						//window.location.href="../login/login.html";

					}
				});

			} 
			else {
				$(htmlx).html(result.msg);
			}
		},
		error: function(e) {

			//
			console.log(e.status)
		}
	});
}

//获取url参数
/*function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}*/
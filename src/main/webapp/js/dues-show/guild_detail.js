$(function() {

	if(!window.sessionStorage.getItem('detail_data')) {
		//window.open('guild.html');
		window,
		location.href = "guild.html";
	}

	//设置请求地址
	var detail_data = window.sessionStorage.getItem('detail_data');
	console.log(detail_data)
	var data = JSON.parse(detail_data);
	//设置导航路径
	var modular = ['会员展示', '优质工程', '会费展示', '培训信息', '公告通知', '政策法规', '资料下载'];
	var modulars = ['协会动态', '行业动态', '媒体报道'];
	//获取url参数判断展示信息
	var parament = 0;
	var paraments = 0;
	//动态标题参数
	var url_guild_parameter = [];
	url_guild_parameter[0] = ['title']; //协会动态
	url_guild_parameter[1] = ['title']; //行业动态
	url_guild_parameter[2] = ['title']; //媒体报道
	url_guild_parameter[3] = ['name']; //会员展示
	url_guild_parameter[4] = ['engName']; //优质工程
	url_guild_parameter[5] = ['project']; //会费展示
	url_guild_parameter[6] = ['traName']; //培训信息
	url_guild_parameter[7] = ['title']; //公告通知
	url_guild_parameter[8] = ['date']; //政策法规
	url_guild_parameter[9] = ['date']; //资料下载
	//判断参数生成导航信息
	parament = parseInt(GetQueryString('first'));
	if(parament == 1) {
		paraments = parseInt(GetQueryString('second'));
		var html = '';
		html += '<a>当前位置：</a>' +
			'<a href="guild.html">行业协会 > </a>' +
			'<a href="guild.html">动态资讯 > </a>' +
			'<a href="guild.html">' + modulars[paraments] + ' > </a>' +
			'<a>' + data.title + ' </a>';
		$('.Gd-topbar').html(html);
	} else {
		var html = '';
		var title = '';
		switch(parament) {
			case 2:
				title = data.name;
				break;
			case 3:
				title = data.engName;
				break;
			case 4:
				title = data.project;
				break;
			case 5:
				title = data.traName;
				break;
			case 6:
				title = data.title;
				break;
		}
		html += '<span>当前位置：</span>' +
			'<a href="guild.html">行业协会</a>&nbsp;>&nbsp;' +
			'<a href="guild.html">' + modular[parament - 2] + '</a>&nbsp;>&nbsp;' +
			'<a>' + title + '</a>';

		if(parament == 3) {
			$('.Gd-topbar').html(html);
		} else {
			$('.TD_subNav').html(html);
		}
	}
	//动态页面参数
	var data_paraments = [];
	data_paraments[0] = ['content', 'date', 'infoType', 'title']; //协会动态
	data_paraments[1] = ['content', 'date', 'infoType', 'title']; //行业动态
	data_paraments[2] = ['content', 'date', 'infoType', 'title']; //媒体报道
	data_paraments[3] = ['address', 'compScale', 'compType', 'date', 'name', 'qlifLevel', 'project', 'registerCapital']; //会员展示
	data_paraments[4] = ['company', 'date', 'engName', 'selectYear']; //优质工程
	data_paraments[5] = ['address', 'compScale', 'compType', 'date', 'name', 'qlifLevel', 'project', 'registerCapital']; //会费展示
	data_paraments[6] = ['content', 'date', 'filesId', 'traName', 'traType', 'trainFile']; //培训信息
	data_paraments[7] = ['content', 'date', 'infoType', 'title']; //公告通知
	data_paraments[8] = []; //政策法规
	data_paraments[9] = []; //资料下载
	var show_html = [];
	show_html[0] = ['#content', '#date', '#infoType', '#title']; //协会动态
	show_html[1] = ['#content', '#date', '#infoType', '#title']; //行业动态
	show_html[2] = ['#content', '#date', '#infoType', '#title']; //媒体报道
	show_html[3] = ['#address', '#compScale', '#compType', '#date', '#name', '#qlifLevel', '#project', '#registerCapital']; //会员展示
	show_html[4] = ['#company', '#date', '#engName', '#selectYear']; //优质工程
	show_html[5] = ['#address', '#compScale', '#compType', '#date', '#name', '#qlifLevel', '#project', '#registerCapital']; //会费展示
	show_html[6] = ['#content', '#date', '#filesId', '#traName', '#traType', '#trainFile']; //培训信息
	show_html[7] = ['#content', '#date', '#infoType', '#title']; //公告通知
	show_html[8] = []; //政策法规
	show_html[9] = []; //资料下载

	console.log(data_paraments[parament + 1])

	if(parament == 1) {
		$.each(show_html[paraments], function(i) {
			$(show_html[paraments][i]).html(data[data_paraments[paraments][i]])
		});
	} else {

		if(parament + 1 == 4) {
			$('#show_tiele').html(data.engName);
		}
		if(parament + 1 == 7) {
			$('#show_tiele').html(data.title);
		}
		//培训信息
		if(parament+1  == 6) {
			switch(parseInt(data.traType)) {
				case 1:
					data.traType = '施工员';
					break;
				case 2:
					data.traType = '研修班';
					break;
				case 3:
					data.traType = '草坪工';
					break;
				case 4:
					data.traType = '绿化工';
					break;
			}
		}
		$.each(show_html[parament + 1], function(i) {
			$(show_html[parament + 1][i]).html(data[data_paraments[parament + 1][i]]);
		});
	}

})

//获取url参数
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}
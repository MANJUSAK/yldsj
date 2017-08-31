$(function() {
	var host = window.sessionStorage.getItem('Host') + '/xqfb/find/seedling';
	var html_show = $('#index_seedling'); //苗木信息展示
	get_seedling(host, {
		page: 0
	}, html_show);
})

function get_seedling(url_seed, seed_data, show_position) {
	$.ajax({
		type: "get",
		url: url_seed,
		data: seed_data,
		async: true,
		success: function(result) {

			if(result.errorCode == 0) {
				var data = result.data;
				var html = '';
				var len = 3;
				//debugger;
				$.each(data, function(i) {
					if(i > 2) {
						return;
					}
					html += '<div class="pc-item">' +
						'<div class="pc-show">' +
						'<img src="' + data[i].picture[0] + '" alt="' + data[i].titleName + '" />' +
						'</div>' +
						'<div class="pc-text">' +
						'<div class="text-inner">' +
						'<div id="test" class="ti-topbar">' +
						'<p>' + data[i].titleName + '</p>' +
						'<p>' + data[i].content + '</p>' +
						'</div>' +
						'<div class="ti-footer">' +
						'<div class="ti-title">' +
						'<a href="">' + data[i].address + '</a><span>' + data[i].date + '</span>' +
						'</div>' +
						'<div class="ti-icon">' +
						'<div class="icon-right">' +
						'<div class="ir-item">' +
						'<a><i class="fa fa-envelope"></i></a>' +
						'</div>' +
						'<div class="ir-item">' +
						'<a><i class="fa fa-tty"></i></a>' +
						'</div>' +
						'<div class="ir-item">' +
						'<a><i class="fa fa-qq"></i></a>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>' +
						'</div>';
				});
				//绑定数据显示
				show_position.html(html);
				$('#index_seedling').on('click', '.pc-item .pc-text', function() {
					//console.log($(this).index())
					window.open('demandRelease/nursery-information.html');
				})
			}
		},
		error: function(e) {
			console.log(e.status)
		}
	});
}
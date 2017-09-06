var html = '';

$(function() {
	var div_ = $('.Pib-content'); //数据呈现位置
	var url_ = window.sessionStorage.getItem('Host') + '/offer/find/mmckbj';
	var para_data = {
		page: 0
	};
	get_data(html, url_, para_data, div_);
})

function get_data(html, url_, para_data, div_) {
	$.ajax({
		type: "get",
		url: url_,
		data: para_data,
		async: true,
		success: function(result) {

			if(result.errorCode == 0) {
				var data = result.data;
				var len = result.data.length;

				$.each(data, function(i) {
					var spec = data[i].specification == null ? '无' : data[i].specification;
					html += '<ul>' +
						'<li>' + data[i].material + '</li>' +
						'<li>' + spec + '</li>' +
						'<li>' + data[i].unit + '</li>' +
						'<li>' + data[i].price + '</li>' +
						'<li>' + data[i].types + '</li>' +
						'<li>' + data[i].date + '</li>' +
						'</ul>';
				});
				div_.html(html);
				//查看更多
				/*var html_more = '';
				html_more += '<div class="Pib-inner" id="more">加载更多</div>';
				$('#more_show').html(html_more);*/
				//加载更多
				$('#more').click(function() {
					if(len < 20) {
						alert('已经没有更多数据了')
					} else {
						para_data.page = para_data.page + 1;
						get_data(html, url_, para_data, div_);
					}

				})
			}/* else {
				div_.html('暂时没有该项数据');
			}*/
		},
		error: function() {
			return null;
		}
	});
}
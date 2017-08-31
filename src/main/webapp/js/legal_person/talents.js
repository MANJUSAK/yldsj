var html = '';
$(function() {
	var host = window.sessionStorage.getItem('Host') + '/rck/find/frk';
	var div_ = $('#show'); //数据呈现位置

	get_data(html, host, {
		page: 0
	}, div_)
})

function get_data(html, url_, para_data, div_) {
	$.ajax({
		type: "get",
		url: url_,
		data: para_data,
		async: true,
		success: function(result) {
			console.log(result)
			if(result.errorCode == 0) {
				var data = result.data;
				var len = result.data.length;
				$.each(data, function(i) {
					html += '<div class="show_details"><div class="TCC_content">' +
						'<span hidden="hidden">' + i + ',</span>' +
						'<div class="TCC_content_1">' +
						'<a  >' + data[i].company + '</a>' +
						'</div>' +
						'<div class="TCC_content_1">' +
						'<a  >' + data[i].nature + '</a>' +
						'</div>' +
						'<div class="TCC_content_1">' +
						'<a  >' + data[i].detailAddress + '</a>' +
						'</div>' +
						'<div class="TCC_content_1">' +
						'<a  >' + data[i].registerAddress + '</a>' +
						'</div>' +
						'<div class="TCC_content_1">' +
						'<a  >' + data[i].registerCap + '</a>' +
						'</div>' +
						'</div></div>';
				});
				div_.html(html);
				//查看更多
				var html_more = '';
				html_more += '<div class="more_whole"><div class="more_L"></div><div class="more" id="more">加载更多</div><div class="more_R"></div></div><div style="clear: both;"></div>';
				$('#more_show').html(html_more);
				//加载更多
				$('#more').click(function() {
					if(len < 20) {
						alert('已经没有更多数据了')
					} else {
						para_data.page = para_data.page + 1;
						get_data(html, url_, para_data, div_);
					}

				})
				//查看详情
				$('#show').on('click', '.show_details', function() {
					if($.session.get('uid')) {
						window.sessionStorage.setItem('talents_details', JSON.stringify(data[$(this).index()]));
						window.open('../legal_person/talents_details.html', '_blank');
					}else{
						alert('未登录不能查看')
					}
				})
			} else {
				div_.html('暂时没有该项数据');
			}
		},
		error: function() {
			return null;
		}
	});
}
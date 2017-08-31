$(function() {
	get_data()

	function get_data() {
		$.ajax({
			type: "post",
			url: "http://172.16.13.113/Garden/projectManage/queryKgReportMsg",
			async: true,
			data: {
				uid: $.session.get('uid')
			},
			success: function(result) {
				console.log(result.data)
				var html = '';
				var html_ = '';
				var img = '';
				var data = result.data;
				var pid = $.session.get('pid');
				if(result.status == 0 && result.data != null) {
					$.each(data, function(n) {
						if(data[n].pid == pid) {
							html += '<ul>' +
								'<li>' + $.session.get('pname') + '</li>' +
								'<li>' + data[n].kgTime + '</li>' +
								'<li><a href="' + result.path + data[n].kgDocument + '" download>点击下载</a></li>' +
								'</ul>';
							/*img += '<div class="mengcheng_center">' +
								'<img class="mengcheng_center_img" src="' + result.path + data[n].url + '" />' +
								'<img class="mengcheng_center_absolute" src="../img/err_s.png" />' +
								'</div>';*/
						}
					});
				} else {
					html = '暂无项目或未选择项目';
					html_ = '';
				}
				$('#one').html(html);
				$('.mengcheng').html(img);
			},
			error: function(e) {
				alert(e)
			}
		});
	}
	//表单赋值
	$('#uid').val($.session.get('uid'));
	$('#pid').val($.session.get('pid'));

	/*************阻止无项目人员查看其他信息****************/
	$('.iisc-left-content ul li').click(function() {
		if($(this).index() !== 0) {
			if(!$.session.get('pid')) {
				alert('未选择项目或者你还没有建立项目');
				event.preventDefault();
			}
		}
	})
})
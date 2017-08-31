$(function() {
	get_data()

	function get_data() {
		$.ajax({
			type: "get",
			url: "http://172.16.0.253:8080//project/find/xmxx",
			async: true,
			data: {
				uid: $.session.get('uid')
			},
			success: function(result) {
				
				var html = '';
				var html_ = '';
				var data = result.data;
				var pid = $.session.get('pid');
				if(result.status == 0 && result.data != null) {
				$.each(data, function(n) {
					if(data[n].pid == pid) {
						html += '<ul>' +
							'<li>' + data[n]. name + '</li>' +
							'<li>' + data[n]. startTime + '</li>' +
							'<li>' + data[n]. endTime + '</li>' +
							'<li>' + data[n]. company + '</li>' +
							'</ul>';
						html_ += '<ul>' +
							'<li>' + data[n]. address + '</li>' +
							'<li>' + data[n]. principal + '</li>' +
							'<li>' + data[n]. contact + '</li>' +
							'<li>' + data[n]. xmPersonNum + '</li>' +
							'</ul>';
					}
				});
				}else{
					html='暂无项目或未选择项目';
					html_='';
				}
				$('#one').html(html);
				$('#two').html(html_);

			},
			error: function(e) {
				alert(e)
			}
		});
	}

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
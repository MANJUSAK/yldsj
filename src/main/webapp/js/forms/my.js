$(function() {

	$.ajax({
		type: "get",
		url: "http://172.16.0.253:8080//project/find/xmxx",
		async: true,
		data: {
			page:0,
			uid: $.session.get('uid')
		},
		success: function(result) {
			
			if(result.status == 0) {
				var data = result.data;
				var options = '';
				var select_p = $('#select_p');
				var nunber = /^\+?[1-9][0-9]*$/;
				if($.session.get('pid')) {
					$.each(data, function(n) {
						if(data[n].pid == $.session.get('pid')) {
							options += '<option>' + data[n].name + '</option>';
							$.session.set('pname', data[n].name);
						}
					});
				} else {
					options += '<option>__________请选择__________</option>'
				}

				$.each(data, function(d) {
					options += '<option value="' + data[d].pid + '">' + data[d].name + '</option>'
				});
				select_p.html(options);
				select_p.change(function() {
					if(nunber.test(select_p.val())) {
						if($.session.get('pid')) {
							$.session.remove('pid');
							$.session.set('pid', select_p.val());
						} else {
							$.session.set('pid', select_p.val());
						}
					}
				})

			} else {
				var select_p = $('#select_p');
				var options = '';
				options += '<option>__________无项目__________</option>';
				select_p.html(options);
				alert('sorry,load item error，error code ：' + result.status);
			}
		},
		error: function(e) {
			alert('sorry，load item error~！')
		}
	});
})

$('.mb2-box .mb2-li1 ul li').click(function(event) {
	if($(this).index() !== 0) {
		if(!$.session.get('pid')) {
			alert('未选择项目或者你还没有建立项目');
			event.preventDefault();
		}
		/*else{
			alert($.session.get('pid'))
		}*/
	} else {
		if($(this).text().split(',', 1) == 1) {
			alert('未选择项目或者你还没有建立项目');
			event.preventDefault();
		}
	}
})
/****************合同管理******************/
$(function() {
	var nunber = /^\+?[1-9][0-9]*$/;
	$('#contract').change(function() {
		if(nunber.test($('#contract').val())) {
			get_contract($('#contract').val() - 1)
		}
	})
})

function get_contract(num) {
	var contracts = ['http://172.16.13.113/Garden/compact/queryBuildCompact',
		'http://172.16.13.113/Garden/compact/queryGardenCompact',
		'http://172.16.13.113/Garden/compact/queryEngineeringCompact',
		'http://172.16.13.113/Garden/compact/queryLandscapeCompact'
	];
	if(num > 0 && num < 5) {
		$.ajax({
			type: "post",
			url: contracts[num - 1],
			async: true,
			data: {
				uid: $.session.get('uid')
			},
			success: function(result) {
				if(result != null && result.status == 0) {
					
					var html_contract = '';
					var data = result.data;
					$.each(data, function(n) {
						html_contract += '<li class="mb-footer_CCo_li">' +
							'<div class="mb-footer_CCo_li_tu">' +
							'<img class="mypact" src="' + result.path + data[n].url[0] + '" />' +
							'<div class="my_img">';
						$.each(data[n].url, function(m) {
							html_contract += '<img src="' + result.path + data[n].url[m] + '" />';
						})
						html_contract += '</div>' +
							'</div>' +
							'<div class="mb-footer_CCo_li_curtain"><span>' + data[n].compactId + '   ' + data[n].genre + '    ' + data[n].dates + '</span></div>' +
							'</li>';
					});

					$('#contract_show').html(html_contract);
				} else {
					
					alert('对不起，' + result.result + '！！错误代码 ：' + result.status);
				}
			},
			error: function(e) {
				alert(e)
			}
		});
	}

}
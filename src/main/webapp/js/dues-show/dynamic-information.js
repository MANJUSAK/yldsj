$(function() {
	$('#button').click(function() {
		//调用表单验证
		var is_validate = validate();
		var url_ = window.sessionStorage.getItem("Host") + "/hyxh/add/dtzx";
		//表单验证符合条件则执行提交
		if(is_validate) {
			var form = new FormData(document.getElementById("myform"));
			$.ajax({
				url: url_,
				type: "post",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {
					
					if(data.errorCode > 0) {
						console.log(data)
						$('#show_error_').text('       ' + data.msg + '!      错误代码：' + data.errorCode);
					} else {
						location.replace(location.href);
					}
				},
				error: function(e) {
					
					console.log(e.status)
					$('#show_error_').val('错误代码：' + e.status);
				}
			});

			//验证不通过时
		} else {
			alert('请正确填写表单')
		}

	})
})

function validate() {
	result = true;
	//标题
	var userName = document.getElementById("userName").value;
	//内容
	var dates = document.getElementById("date").value;
	//类别
	var address = document.getElementById('address').value;
	//姓名
	userName = $.trim(userName);
	if(userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">标题不能为空！</font>'
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//成立时间
	dates = $.trim(dates);
	if(dates == '') {
		document.getElementById('dateTip').innerHTML = '<img src="../img/err.png"/><font color="red">内容不能为空！</font>'
		result = false;
	} else {
		document.getElementById('dateTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//所在地
	address = $.trim(address);
	if(address == '') {
		document.getElementById('addressTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择类别！</font>'
		result = false;
	} else {
		document.getElementById('addressTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	return result;
}
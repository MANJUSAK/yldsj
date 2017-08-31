$(function() {
	$('#button').click(function() {
		//调用表单验证
		var is_validate = validate();
		var url_ = window.sessionStorage.getItem("Host") + "/hyxh/add/yzgc";
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
	//优质工程名称
	var userName = document.getElementById("userName").value;
	//发布日期
	var dates = document.getElementById("date").value;
	//评选年度
	var address = document.getElementById('address').value;
	//施工企业
	var project = document.getElementById('project').value;
	//优质工程名称
	userName = $.trim(userName);
	if(userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">优质工程名称不能为空！</font>'
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//发布日期
	dates = $.trim(dates);
	if(dates == '') {
		document.getElementById('dateTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择发布日期！</font>'
		result = false;
	} else {
		document.getElementById('dateTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//评选年度
	address = $.trim(address);
	if(address == '') {
		document.getElementById('addressTip').innerHTML = '<img src="../img/err.png"/><font color="red">评选年度不能为空！</font>'
		result = false;
	} else {
		document.getElementById('addressTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//施工企业
	project = $.trim(project);
	if(project == '') {
		document.getElementById('projectTip').innerHTML = '<img src="../img/err.png"/><font color="red">施工企业不能为空！</font>'
		result = false;
	} else {
		document.getElementById('projectTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	return result;
}
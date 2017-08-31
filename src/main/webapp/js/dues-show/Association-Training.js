$(function() {
	$('#button').click(function() {
		//调用表单验证
		var is_validate = validate();
		var url_ = window.sessionStorage.getItem("Host") + "/hyxh/add/xhpx";
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
	//培训名称
	var userName = document.getElementById("userName").value;
	//培训日期
	var dates = document.getElementById("date").value;
	//培训内容
	var address = document.getElementById('address').value;
	//培训类型
	var project = document.getElementById('project').value;
	//文件类型
	var scale = document.getElementById('scale').value;
	//文件
	var grade = document.getElementById("grade").value;
	//培训名称
	userName = $.trim(userName);
	if(userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">培训名称不能为空！</font>'
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//培训时间
	dates = $.trim(dates);
	if(dates == '') {
		document.getElementById('dateTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择培训时间！</font>'
		result = false;
	} else {
		document.getElementById('dateTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//培训内容
	address = $.trim(address);
	if(address == '') {
		document.getElementById('addressTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择填写内容！</font>'
		result = false;
	} else {
		document.getElementById('addressTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//培训类型
	project = $.trim(project);
	if(project == '') {
		document.getElementById('projectTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择培训类型！</font>'
		result = false;
	} else {
		document.getElementById('projectTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//文件类型
	scale = $.trim(scale);
	if(scale == '') {
		document.getElementById('scaleTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择文件类型！</font>'
		result = false;
	} else {
		document.getElementById('scaleTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//文件
	grade = $.trim(grade);
	if(grade == '') {
		document.getElementById('gradeTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择需要上传的文件！</font>'
		result = false;
	} else {
		document.getElementById('gradeTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	return result;
}
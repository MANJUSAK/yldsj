$(function() {
	$('#buttonx').click(function() {
		//调用表单验证
		var is_validate = validate();
		var url_ = window.sessionStorage.getItem("Host") + "/hyxh/add/hf";
		//表单验证符合条件则执行提交
		if(is_validate) {
			var form = new FormData(document.getElementById("myform"));
			$.ajax({
				url:url_,
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
	//姓名
	var userName = document.getElementById("userName").value;
	//成立时间
	var dates = document.getElementById("date").value;
	//所在地
	var address = document.getElementById('address').value;
	//主经营项目
	var project = document.getElementById('project').value;
	//企业规模
	var scale = document.getElementById('scale').value;
	//资质等级
	var grade = document.getElementById("grade").value;
	//企业类型
	var type = document.getElementById("type").value;
	//注册资金
	var money = document.getElementById("money").value;
	//姓名
	if(userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">姓名不能为空！</font>'
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//成立时间
	if(dates == '') {
		document.getElementById('dateTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择成立时间！</font>'
		result = false;
	} else {
		document.getElementById('dateTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//所在地
	if(address == '') {
		document.getElementById('addressTip').innerHTML = '<img src="../img/err.png"/><font color="red">所在地不能为空！</font>'
		result = false;
	} else {
		document.getElementById('addressTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//主经营项目
	if(project == '') {
		document.getElementById('projectTip').innerHTML = '<img src="../img/err.png"/><font color="red">主经营项目不能为空！</font>'
		result = false;
	} else {
		document.getElementById('projectTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//企业规模
	if(scale == '') {
		document.getElementById('scaleTip').innerHTML = '<img src="../img/err.png"/><font color="red">企业规模不能为空！</font>'
		result = false;
	} else {
		document.getElementById('scaleTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//资质等级
	if(grade == '') {
		document.getElementById('gradeTip').innerHTML = '<img src="../img/err.png"/><font color="red">资质等级不能为空！</font>'
		result = false;
	} else {
		document.getElementById('gradeTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//企业类型
	if(type == '') {
		document.getElementById('typeTip').innerHTML = '<img src="../img/err.png"/><font color="red">企业类型不能为空！</font>'
		result = false;
	} else {
		document.getElementById('typeTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//注册资金
	if(type == '') {
		document.getElementById('moneyTip').innerHTML = '<img src="../img/err.png"/><font color="red">注册资金不能为空！</font>'
		result = false;
	} else {
		document.getElementById('moneyTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	return result;
}
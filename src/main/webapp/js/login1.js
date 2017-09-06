/*
 * 描述：登录页面的正则、ajax提交数据
 * */
/*------------------------- 登录页面（login.js）的js 该js暂不使用 -------------------------*/
$(function() {
	$("#lsSubmit").click(function() {
		$("#loginYaler").css("display", "block");
	});
	$("#loginCloose").click(function() {
		$("#loginYaler").css("display", "none");
	});
	var islogin = GetQueryString('relogin')
	if(islogin) {
		$.session.clear();
		window.location.href = "login.html";
	}
});

/*------------------------- 登录页面（login.js）的js 该js暂不使用 结束 -------------------------*/

var input_keyup = false;//当点击登录按钮之后该值变为true，变为true之后，用户名和密码的输入框的keyup事件则起作用。

/*****登录页面的正则，判断用户名和密码不能为空*******/
var resultExp; //为true的时候，进入ajax提交（表示密码和账号不为空）
function validate() {
	resultExp = true;
	var username = document.getElementById("username").value;
	var passwords = document.getElementById("passwords").value;
	if(username == '') {
		document.getElementById("userNameTip").innerHTML = '<img src="../img/err.png"/><font color="red">用户名不能为空！</font>'
		resultExp = false;
	} else {
		document.getElementById("userNameTip").innerHTML = '';
	}
	if(passwords == '') {
		document.getElementById("passwordTip").innerHTML = '<img src="../img/err.png"/><font color="red">密码不能为空！</font>'
		resultExp = false;
	} else {
		document.getElementById("passwordTip").innerHTML = '';
	}
	return resultExp;
}
$(".input,.input3").keyup(function() {
	$('#show_error').html("");
	if(input_keyup == true) {
		validate();
	}

});

/*****登录页面的正则，判断用户名和密码不能为空  结束*******/
/******* 登录页面判断显示器为高像素分辨率的时候，注册页面中间的框 距离顶部的距离增大 ********/
window.onresize = function() {
	d_width();
}
d_width();

function d_width() {
	var d_widths = $(document).width();
	if(d_widths > 1800) {
		$(".L-container").css("margin-top", "220px")
	}
}
/******* 登录页面判断显示器为高像素分辨率的时候，注册页面中间的框 距离顶部的距离增大  结束 ********/
/************************用户登录***********************/
$(function() {
	var code;
	var is_sbm = false;
	//$('#get_code').html('<img style="width: 100%;height: 100%;" src="http://172.16.13.113//authCode" />');
	$('#submit_').click(function() {
		$('#show_error').html(""); //清空提示的值
		input_keyup = true; //当点击登录按钮之后该值变为true，变为true之后，用户名和密码的输入框的keyup事件则起作用。
		validate();
		if(resultExp == true) {
			if(is_sbm) {
				submit_login();
			} else {
				validateCode();
			}
		}
	})
	//用户名、密码、验证码，按下回车键进入登录
	$("#username,#passwords,#code").keyup(function(e){
		if(e.keyCode == 13){
			$('#show_error').html(""); //清空提示的值
			input_keyup = true; //当点击登录按钮之后该值变为true，变为true之后，用户名和密码的输入框的keyup事件则起作用。
			validate();
			if(resultExp == true) {
				if(is_sbm) {
					submit_login();
				} else {
					validateCode();
				}
			}
		}
	});
	
	
	//提交登录信息
	function submit_login() {
		var uname = $('#username').val();
		var upwd = $('#passwords').val();
		var ucode = $('#code').val();
		if(upwd == '' || uname == '') {
			return 0;
		}
		$.ajax({
			type: "post",
			url: window.sessionStorage.getItem("Host") + "/login",
			async: true,
			data: {
				'userName': uname,
				'passWord': upwd,
				'userCode': ucode
			},
			success: function(result) {

				if(result.errorCode == 0) {
					//console.log(result)
					data = result.data;
					$.session.clear();
					$.session.set('name', data.name);
					$.session.set('uname', data.userName);
					$.session.set('uid', data.uid);
					$.session.set('umember', data.member);
					$.session.set('uidCard', data.idCard);
					$.session.set('utel', data.tel);
					$.session.set('uemail', data.email);
					$.session.set('ucomp', data.comp);
					$.session.set('udept', data.dept);
					if(data.sex == 0) {
						$.session.set('usex', '男');
					} else {
						$.session.set('usex', '女');
					}
					window.location.href = '../index.html';
				} else {
					if(result.errorCode == 402) {
						$('#show_error').html(result.msg + '    请点击验证码图片更换验证码！');
					} else {
						$('#show_error').html(result.msg);
					}
				}
			},
			error: function(error) {
				console.log(error)
			}
		});
	}
	//生成验证码
	createCode();
	//更新验证码
	$('#show_code').click(function() {
		createCode();
	})
	//生成验证码
	function createCode() {
		code = "";
		var codeLength = 4; //验证码的长度
		//var checkCode = document.getElementById("checkCode");
		var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
		//所有候选组成验证码的字符，当然也可以用中文的
		for(var i = 0; i < codeLength; i++) {
			var charNum = Math.floor(Math.random() * 52);
			code += codeChars[charNum];
		}
		$('#show_code').html('' + code);
	}
	//验证验证码
	function validateCode() {
		var inputCode = $('#code').val();
		if(inputCode.length <= 0) {
			$('#show_error').html('请输入验证码');
		} else if(inputCode.toUpperCase() != code.toUpperCase()) {
			$('#show_error').html('验证码错误，请重新输入');
			createCode();
		} else {
			submit_login();
		}
	}

})

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}
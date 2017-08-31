/* 注释说明：
 * 注册的页面字段发生改变，固正则中没有用到的字段注释掉
 * 期中使用的注释为 “//”
 **/
/*---------------------------  这是注册页面的正则表达式，ajax提交  -------------------------*/
var result = true;
var buttonClick = true;

function validate() {
	//	var yesNo = 0;
	result = true;
	//用户名
	var userName = document.getElementById("userName").value;
	//	姓名 
	var name = document.getElementById("name").value;
	//  密码
	var passwd = document.getElementById('password').value;
	//验证码
	var code = document.getElementById('code').value;
	//电话号码
	var phone = document.getElementById('phone').value;
	//个人身份证号码
	var idCardOne = document.getElementById("idCardOne").value;
	//身份证正反面上传
	var xdaTanFileImg1 = document.getElementById("xdaTanFileImg1").value;
	var xdaTanFileImg2 = document.getElementById("xdaTanFileImg2").value;
	//   邮箱
	var email = document.getElementById("email").value;
	//企业名称
	var enterpriname = document.getElementById("enterpriseName").value;
	//密码验证。当密码为空的时候进入该判断
	if(passwd == '') {
		document.getElementById('passwordTip').innerHTML = '<img src="../img/err.png"/><font color="red">密码不能为空！</font>'
		result = false;
		//当输入的密码长度在小于6或大于12时进入该判断
	} else if(passwd.length < 6 || passwd.length > 12) {
		document.getElementById('passwordTip').innerHTML = '<img src="../img/err.png"/><font color="red">密码的长度必须在6~12之间！</font>'
		result = false;
	} else {
		document.getElementById('passwordTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}

	//用户名
	userName = $.trim(userName);
	if(userName == '') {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">用户名不能为空！</font>'
		result = false;
		//当输入的用户名长度在小于3或大于10时进入该判断
	} else if(userName.length < 3 || userName.length > 10) {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">用户名的长度必须在3~10之间！</font>'
		result = false;
	} else {
		document.getElementById('userNameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//姓名
	name = $.trim(name);
	if(name == '') {
		document.getElementById('nameTip').innerHTML = '<img src="../img/err.png"/><font color="red">姓名不能为空！</font>'
		result = false;
		//当输入的用户名长度在小于3或大于10时进入该判断
	} else if(userName.length < 3 || userName.length > 10) {
		document.getElementById('nameTip').innerHTML = '<img src="../img/err.png"/><font color="red">用户名的长度必须在3~10之间！</font>'
		result = false;
	} else {
		document.getElementById('nameTip').innerHTML = '<img src="../img/ok.png"/>';
		//result = true;
	}
	//个人身份证号码idCardOne
	idCardOne = $.trim(idCardOne);
	if(!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(idCardOne)) {
		//错误的提示
		document.getElementById('idCardOneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的身份证号码！</font>'
		result = false;
	} else if (idCardOne.length!==18) {
		document.getElementById('idCardOneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的身份证号码！</font>'
		result = false;
	}
	else {
		document.getElementById('idCardOneTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//	}
	//电话号码
	phone = $.trim(phone);
	if(!/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(phone)) {
		//错误的提示
		document.getElementById('phoneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的电话号码！</font>'
		result = false;
	} else if (phone.length > 11 || phone.length < 7) {
		document.getElementById('phoneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的电话号码！</font>'
		result = false;
	}
	else {
		document.getElementById('phoneTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//身份证正面上传
	if(xdaTanFileImg1 == '') {
		document.getElementById('xdaTanFileImgTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择图片！</font>'
		result = false;
	}
	else {
		document.getElementById('xdaTanFileImgTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//身份证反面上传
	if(xdaTanFileImg2 == '') {
		document.getElementById('xdaTanFileImgTip2').innerHTML = '<img src="../img/err.png"/><font color="red">请选择图片！</font>'
		result = false;
	} else {
		document.getElementById('xdaTanFileImgTip2').innerHTML = '<img src="../img/ok.png"/>';
	}
	//   验证码
	if(code == '') {
		document.getElementById('codeTip').innerHTML = '<img src="../img/err.png"/><font color="red">请输入正确的验证码！</font>'
		result = false;
	} else {
		document.getElementById('codeTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//  邮箱
	if(!/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/.test(email)) {
		document.getElementById('emailTip').innerHTML = '<img src="../img/err.png"/><font color="red">请输入正确的邮箱地址！</font>'
		result = false;
	} else {
		document.getElementById('emailTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	// 企业名称
	if(enterpriname == '') {
		document.getElementById('enterpriseNameTip').innerHTML = '<img src="../img/err.png"/><font color="red">请输入正确的企业名称！</font>'
		result = false;
	} else {
		document.getElementById('enterpriseNameTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	return result;
}
//当键盘按下的时候调用方法
$('input').keyup(function() {
	//当点击一次注册按钮时buttonClick = false；则可以通过该判断
	if(buttonClick == false) {
		validate();
	}
});

//当键盘按下的时候调用方法
$('.xuanze1,.xuanze2,.xuanze3').change(function() {
	//当点击一次注册按钮时buttonClick = false；则可以通过该判断
	if(buttonClick == false) {
		validate();
		console.log("8520");
	}
});

/*************** 点击注册按钮时，通过ajax提交相关信息 ****************/
$(function() {
	$("#submit_").click(function() {
		validate();
		validateCode()
		buttonClick = false;
		
		console.log("是否点击过：" + buttonClick);
		var form = new FormData(document.getElementById("myform"));
		console.log(form);
		var url_reg = '';
		/*if(result == true) {
			console.log('这是验证完整后的ajax提交');
			//改变文字
			$.ajax({
				url: "http://172.16.13.113//register",
				type: "post",
				data: form,
				processData: false,
				contentType: false,
				success: function(data) {
					debugger;
					if(data.errorCode > 0) {
						console.log(data)

						if(data.errorCode == 402) {
							$('#show_error').html(data.msg + '    请点击验证码图片更换验证码！');
						} else {
							$('#show_error').html(data.msg);
						}
					} else {
						alert('注册成功')
						//$.session.set('uname', $('#userName').val())
						location.replace(location.href = "../login/login.html");
					}
				},
				error: function(e) {
					debugger;
					alert(e.errorCode)

				}
			});
		}*/

	});

	var code;

	function createCode() {
		code = "";
		var codeLength = 4; //验证码的长度
		//var checkCode = document.getElementById("checkCode");
		var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
		for(var i = 0; i < codeLength; i++) {
			var charNum = Math.floor(Math.random() * 52);
			code += codeChars[charNum];
		}
		/*if(checkCode) {
			checkCode.className = "code";
			checkCode.innerHTML = code;
		}*/
		$('.img-code').html('' + code);
		console.log(code)
	}
	createCode();

	function validateCode() {
		var inputCode = document.getElementById("inputCode").value;
		if(inputCode.length <= 0) {
			alert("请输入验证码！");
		} else if(inputCode.toUpperCase() != code.toUpperCase()) {
			alert("验证码输入有误！");
			createCode();
		} else {
			alert("验证码正确！");
		}
	}


})
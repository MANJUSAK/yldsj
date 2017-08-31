/* 注释说明：
 * 注册的页面字段发生改变，固正则中没有用到的字段注释掉
 * 期中使用的注释为 “//”
 **/
//企业注册
/*---------------------------  这是注册页面的正则表达式，ajax提交  -------------------------*/
var result = true;
var buttonClick = true;

function validate() {
	//	var yesNo = 0;
	result = true;
	//用户名
	var userName = document.getElementById("userName").value;

	//单位名称
	//	var nameUnit = document.getElementById("nameUnit").value;

	//联系人名称
	//	var contactName = document.getElementById("contactName").value;

	//法人名称
	//	var legalPersonName = document.getElementById("legalPersonName").value;
	//密码
	var passwd = document.getElementById('password').value;
	//确认密码
	var confirmPasswd = document.getElementById('confirmPassword').value;
	//电话号码
	var phone = document.getElementById('phone').value;
	//	var email = document.getElementById('email').value;
	//法人身份证号码
	//	var IDCard = document.getElementById('IDCard').value;
	//个人身份证号码
	var idCardOne = document.getElementById("idCardOne").value;
	//input 图片上传 
	var xdaTanFileImg1 = document.getElementById("xdaTanFileImg1").value;
	var xdaTanFileImg2 = document.getElementById("xdaTanFileImg2").value;

	//单位名称
	//	if(nameUnit == '') {
	//		document.getElementById('nameUnitTip').innerHTML = '<img src="img/err.png"/><font color="red">单位名称不能为空！</font>'
	//		result = false;
	//	} else if(nameUnit.length < 3 || nameUnit.length > 50) {
	//		document.getElementById('nameUnitTip').innerHTML = '<img src="img/err.png"/><font color="red">单位名称的长度必须在3~50之间！</font>'
	//		result = false;
	//	} else {
	//		document.getElementById('nameUnitTip').innerHTML = '<img src="img/ok.png"/>';
	//		result = true;
	//	}
	//联系人名称
	//	if(contactName == '') {
	//		document.getElementById('contactNameTip').innerHTML = '<img src="img/err.png"/><font color="red">联系人名称不能为空！</font>'
	//		result = false;
	//	} else if(contactName.length < 2 || contactName.length > 10) {
	//		document.getElementById('contactNameTip').innerHTML = '<img src="img/err.png"/><font color="red">联系人名称的长度必须在2~10之间！</font>'
	//		result = false;
	//	} else {
	//		document.getElementById('contactNameTip').innerHTML = '<img src="img/ok.png"/>';
	//		result = true;
	//	}

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
	if(confirmPasswd == '') {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="../img/err.png"/><font color="red">确认密码不能为空！</font>'
		result = false;
	} else if(passwd != confirmPasswd) {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="../img/err.png"/><font color="red">两次密码输入不一致！</font>'
		result = false;
	} else {
		document.getElementById('confirmPasswordTip').innerHTML = '<img src="../img/ok.png"/>';
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

	//判断是否传图片了
	if(xdaTanFileImg1 == '' || xdaTanFileImg2 == '') {
		document.getElementById('xdaTanFileImgTip').innerHTML = '<img src="../img/err.png"/><font color="red">请选择图片！</font>'
		result = false;
	} else {
		document.getElementById('xdaTanFileImgTip').innerHTML = '<img src="../img/ok.png"/>';
	}

	//	var radio1 = document.getElementById("register_user_radio1");
	//	if(radio1.checked) {
	//		//法人身份证号码
	//		if(!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(IDCard)) {
	//			document.getElementById('IDCardTip').innerHTML = '<img src="img/err.png"/><font color="red">必须填写正确的身份证号码！</font>'
	//			result = false;
	//		} else {
	//			document.getElementById('IDCardTip').innerHTML = '<img src="img/ok.png"/>';
	//		}
	//		//法人人名称
	//		if(legalPersonName == '') {
	//			document.getElementById('legalPersonNameTip').innerHTML = '<img src="img/err.png"/><font color="red">法人名称不能为空！</font>'
	//			result = false;
	//		} else if(legalPersonName.length < 2 || legalPersonName.length > 10) {
	//			document.getElementById('legalPersonNameTip').innerHTML = '<img src="img/err.png"/><font color="red">法人名称的长度必须在2~10之间！</font>'
	//			result = false;
	//		} else {
	//			document.getElementById('legalPersonNameTip').innerHTML = '<img src="img/ok.png"/>';
	//			result = true;
	//		}
	//	} else {
	//个人身份证号码idCardOne
	idCardOne = $.trim(idCardOne);
	if(!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(idCardOne)) {
		//错误的提示
		document.getElementById('idCardOneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的身份证号码！</font>'
		result = false;
	} else {
		document.getElementById('idCardOneTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//	}
	//电话号码
	if(!/^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/.test(phone)) {
		//错误的提示
		document.getElementById('phoneTip').innerHTML = '<img src="../img/err.png"/><font color="red">必须填写正确的电话号码！</font>'
		result = false;
	} else {
		document.getElementById('phoneTip').innerHTML = '<img src="../img/ok.png"/>';
	}
	//邮箱验证
	//	
	//	if(!/^\w+@\w+[.]{1}\w+$/.test(email)) {
	//		document.getElementById('emailTip').innerHTML = '<img src="img/err.png"/><font color="red">必须填写正确的邮箱格式！</font>'
	//		result = false;
	//	} else {
	//		document.getElementById('emailTip').innerHTML = '<img src="img/ok.png"/>';
	//	}
	return result;
}
//当键盘按下的时候调用方法
$('input').keyup(function() {
	//当点击一次注册按钮时buttonClick = false；则可以通过该判断
	if(buttonClick == false) {
		validate();
	}
});

//个人注册的正则表达式
/*
function validate1() {

	var result1 = false;
	//用户名
	var account = document.getElementById('account').value;
	//密码
	var passwd1 = document.getElementById('password1').value;
	//确认密码
	var confirmPasswd1 = document.getElementById('confirmPassword1').value;
	//电话号码
	var phone1 = document.getElementById('phone1').value;

	var IDCard1 = document.getElementById('IDCard1').value;
	if(account == '') {
		document.getElementById('accountTip').innerHTML = '<img src="img/err.png"/><font color="red">用户名不能为空！</font>'
		result1 = false;
	} else if(account.length < 3 || account.length > 12) {
		document.getElementById('accountTip').innerHTML = '<img src="img/err.png"/><font color="red">用户名的长度必须在3~12之间！</font>'
		result1 = false;
	} else {
		document.getElementById('accountTip').innerHTML = '<img src="img/ok.png"/>';
		result1 = true;
	}
	if(passwd1 == '') {
		document.getElementById('passwordTip1').innerHTML = '<img src="img/err.png"/><font color="red">密码不能为空！</font>'
		result1 = false;
	} else if(passwd1.length < 6 || passwd1.length > 12) {
		document.getElementById('passwordTip1').innerHTML = '<img src="img/err.png"/><font color="red">密码的长度必须在6~12之间！</font>'
		result1 = false;
	} else {
		document.getElementById('passwordTip1').innerHTML = '<img src="img/ok.png"/>';
		result1 = true;
	}
	if(confirmPasswd1 == '') {
		document.getElementById('confirmPasswordTip1').innerHTML = '<img src="img/err.png"/><font color="red">确认密码不能为空！</font>'
		result1 = false;
	} else if(passwd1 != confirmPasswd1) {
		document.getElementById('confirmPasswordTip1').innerHTML = '<img src="img/err.png"/><font color="red">两次密码输入不一致！</font>'
		result1 = false;
	} else {
		document.getElementById('confirmPasswordTip1').innerHTML = '<img src="img/ok.png"/>';
		result1 = true;
	}
	if(!/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(IDCard1)) {
		document.getElementById('IDCardTip1').innerHTML = '<img src="img/err.png"/><font color="red">必须填写正确的身份证号码！</font>'
		result1 = false;
	} else {
		document.getElementById('phoneTip1').innerHTML = '<img src="img/ok.png"/>';
	}

	if(!/^(13|14|15|17|18)\d{9}/.test(phone1)) {
		document.getElementById('phoneTip1').innerHTML = '<img src="img/err.png"/><font color="red">必须填写正确的电话号码！</font>'
		result1 = false;
	} else {
		document.getElementById('phoneTip1').innerHTML = '<img src="img/ok.png"/>';
	}

	return result1;
}

*/
/*************** 点击注册按钮时，通过ajax提交相关信息 ****************/
$("#reg_submit_").click(function() {
	validate();

	buttonClick = false;
	
	console.log("是否点击过：" + buttonClick);
	var form = new FormData(document.getElementById("myform"));
	var url_reg = window.sessionStorage.getItem('Host')+'/register';
	if(result == true) {
		console.log('这是验证完整后的ajax提交');
		//改变文字
		$(".RU_center_firm_one_input_register").text("正在注册...");
		$(".RU_center_firm_one_input_register").css({
			"pointer-events": "none",
			"background-color": "#a0a0a0"
		});
		$.ajax({
			url: url_reg,
			type: "post",
			data: form,
			processData: false,
			contentType: false,
			success: function(data) {
				//alert("正在提交");
				if(data !== null) {
					console.log(data)
				}

				if(data.status > 0) {
					$(".bf-submit > .bf-submit-center > span").text("发       布");
					$(".bf-submit > .bf-submit-center > span").css({
						"pointer-events": "auto",
						"background-color": "#0096fe"
					});
					document.getElementById("error_show").innerHTML = data.result;
				} else {
					alert('注册成功')
					$.session.set('uname',$('#userName').val())
					location.replace(location.href = "../login/login.html");
				}
			},
			error: function(e) {
				$(".RU_center_firm_one_input_register").text("注       册");
				$(".RU_center_firm_one_input_register").css({
					"pointer-events": "auto",
					"background-color": "#0096fe"
				});
				document.getElementById("error_show").innerHTML = "系统繁忙";
				/*alert(e.status)
				alert("系统繁忙");*/
				//window.clearInterval(timer);
			}
		});
	}
});
/*---------------------------  这是注册页面的正则表达式，ajax提交  结束  -------------------------*/
/*--------------------------- 该js原为注册页面和登录页面的切换卡代码，现因不使用切换卡功能，这里的代码js则无用---------------------------*/
window.onload = function() {
//	cardid_showHide();
	register_titleTab();
	login_titleTab();
}

/*注册页面  是不是法人时的单选按钮切换*/
/*
 *注释说明：注册页面修改字段，固先注释
 * */
/*
function cardid_showHide() {
	$(".RU_center_firm_cardid_no").hide();
	$(".RU_radio_userYes").click(function() {
		$(".RU_center_firm_cardid_no").hide();
		$(".RU_center_firm_cardid_yes").show();
	});
	$(".RU_radio_userNo").click(function() {
		$(".RU_center_firm_cardid_yes").hide();
		$(".RU_center_firm_cardid_no").show();
	});
}
*/
//点击获取验证码 input框获得焦点 (注册页面)
function register_focus() {
	$(".RU_center_firm_one_input_verify").focus();
}

function register_focus2() {
	$(".RU_center_firm_one_input_verify2").focus();
}

//点击上传图片 （注册页面）

//点击显示图片的时候，图片显示出      图片上传
/*
function xmTanUploadImg() {
	var preview = document.querySelector('#xmTanImg');
	var file = document.querySelector('input[type=file]').files[0];
	var reader = new FileReader();
	reader.onloadend = function() {
		preview.src = reader.result;
	}
	if(file) {
		reader.readAsDataURL(file);
	} else {
		preview.src = "";
	}
}
*/

/*********选择图片，马上预览  上传图片 (苗木信息、设备租赁的图片) ************/
function uploadImg(obj, ID) {
	var file = obj.files[0];
	var reader = new FileReader();
	reader.onload = function(e) {
		var qq = document.getElementById(ID);
		qq.src = e.target.result;
		//或者 img.src = this.result;  //e.target == this
	}
	reader.readAsDataURL(file);
}
/*********选择图片，马上预览  上传图片 (苗木信息、设备租赁的图片) 结束 ************/

/**企业注册和个人注册的切换卡**/
function register_titleTab() {
	$("#RU_center_nom").hide();
	$("#RU_center_switch_L").click(function() {
		//先隐藏在显示
		$("#RU_center_nom").hide();
		$("#RU_center_firm").show();
		$("#RU_center_switch_R").css({
			"background-color": "#0196fd",
			"background-image": "none"
		});
		$("#RU_center_switch_L").css({
			"background-color": "#0080d8",
			"background-image": "url('../img/register_tab.png')"
		});
		$(".RU_center_firm_errOk").empty();
		var tp=document.getElementById("RU_center_switch_L");
	});
	$("#RU_center_switch_R").click(function() {
		$("#RU_center_firm").hide();
		$("#RU_center_nom").show();
		$("#RU_center_switch_L").css({
			"background-color": "#0196fd",
			"background-image": "none"
		});
		$("#RU_center_switch_R").css({
			"background-color": "#0080d8",
			"background-image": "url('../img/register_tab.png')"
		});
		//empty清除内容
		$(".RU_center_firm_errOk").empty();
	});
}

/**企业注册和个人注册的切换卡 结束**/


/** 登录页面  企业登录和个人登录的切换卡**/
function login_titleTab() {
	$("#ls-left-topbar_right").hide();
	$("#ls-left-title-L").click(function() {
		$("#ls-left-topbar_right").hide();
		$("#ls-left-topbar_left").show();
		$("#ls-left-title-R").css({
			"background-color": "#0196fd",
			"background-image": "none"
		});
		$("#ls-left-title-L").css({
			"background-color": "#0080d8",
			"background-image": "url('../img/register_tab.png')"
		});
	});
	$("#ls-left-title-R").click(function() {
		$("#ls-left-topbar_left").hide();
		$("#ls-left-topbar_right").show();
		$("#ls-left-title-L").css({
			"background-color": "#0196fd",
			"background-image": "none"
		});
		$("#ls-left-title-R").css({
			"background-color": "#0080d8",
			"background-image": "url('../img/register_tab.png')"
		});
	});
}

/**企业注册和个人注册的切换卡 结束**/


/*--------------------------- 该js原为注册页面和登录页面的切换卡代码，现因不使用切换卡功能，这里的代码js则无用  结束---------------------------*/




$(".L-yaler").height($("body").height());

function validate() {
    result = true;
    var username = document.getElementById("username").value;
    var passwords = document.getElementById("passwords").value;
    var code = document.getElementById("code").value;
    debugger;
    if (username == '') {
        document.getElementById("userNameTip").innerHTML = '<img src="../img/err.png"/><font color="red">用户名不能为空！</font>'
        result = false;
    } else {
        document.getElementById("userNameTip").innerHTML = '<img src="../img/ok.png"/>';
    }
    if (passwords == '') {
        document.getElementById("passwordTip").innerHTML = '<img src="../img/err.png"/><font color="red">密码不能为空！</font>'
        result = false;
    } else {
        document.getElementById("passwordTip").innerHTML = '<img src="../img/ok.png"/>';
    }
    if (code == '') {
        document.getElementById("codeTip").innerHTML = '<img src="../img/err.png"/><font color="red">验证码不能为空！</font>'
        result = false;
    } else {
        document.getElementById("codeTip").innerHTML = '<img src="../img/ok.png"/>';
    }
    return result;
}
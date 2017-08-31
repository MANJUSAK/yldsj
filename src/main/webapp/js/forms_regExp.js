/**---------------------------- forms文件下所以页面的ajax提交和正则验证 ---------------------------**/
$('.input-item_span').css('visibility', 'hidden');
var myurl = $('#myurl').val();
var item = $('#item').val();

var resajax = true;
//点击提交调用的方法
function regExpFF() {
    detection();
    detection_2();
    console.log("resajax的状态为："+resajax);
    if (resajax == true) {
//		alert('已通过AJAX提交');
        var form = new FormData(document.getElementById("myform"));
        $.ajax({
            url: myurl,
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function(data) {
                if (data.status == 0) {
                    alert("添加成功~！");
                    if (item == 1) {
                        location.replace(location.href = "../my.html");
                    } else {
                        location.replace(location.href);
                    }
                } else {
                    alert(data.result+'错误代码：'+data.status);
                }
                console.log("over..");
            },
            error: function(e) {
                alert("系统繁忙,请稍后重试");
                console.log(e)
            }
        });
    } else {
        alert('提交失败，验证为通过，请重填表单');
    }
    resajax = true;
}

$('input').keyup(function() {
    if ($(this).val() == '') {
//		return resajax = false;
    } else {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
    }
    //当出现日期不能为空，然时间已经选择时，在别的输入框输入相关内容时就会隐藏
    for(var y=0;y<$('input[type="date"]').length;y++){
        if ($('input[type="date"]:eq('+y+')').val() == '') {
//			return resajax = false;
        } else {
            //隐藏提示
            $('input[type="date"]:eq('+y+')').parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        }
    }
    //当出现上传文件文件不能为空，然时间已经选择时，在别的输入框输入相关内容时就会隐藏
    for(var y=0;y<$('input[type="file"]').length;y++){
        if ($('input[type="file"]:eq('+y+')').val() == '') {
//			return resajax = false;
        } else {
            //隐藏提示
            $('input[type="file"]:eq('+y+')').parent().parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        }
    }
});


function detection() {
    resajax = true;
    var cc = $('form input').length;
    for (var i = 0; i <= cc; i++) {
        var i_val = $('form input:eq(' + i + ')').val();
        //console.log('i:'+i+'   内容：'+i_val)
        if (i_val == '') {
            //显示提示内容
            $('form input:eq(' + i + ')').parent('.input-item').next('.input-item_span').css('visibility', 'visible');
            resajax = false;
        } else {
            $('form input:eq(' + i + ')').parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        }
    }
}
//keyup方法用于输入时做提示
//单独判断身份证号。给需要输入身份证的input框相应的class名
var regExpID = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
$('.regExpID').keyup(function() {
    if (regExpID.test($(this).val())) {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        $(this).parent('.input-item').next('.input-item_span').text('內容不能为空');
    } else {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'visible');
        $(this).parent('.input-item').next('.input-item_span').text('身份证号错误,请输入正确的身份证号');
    }
});
//单独判断数字。给需要输入数字的input框相应的class名
var regNumber = /^[0-9]*$/;
$('.regNumber').keyup(function() {
    if (regNumber.test($(this).val())) {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        $(this).parent('.input-item').next('.input-item_span').text('內容不能为空');
    }else {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'visible');
        $(this).parent('.input-item').next('.input-item_span').text('只能为纯数字');
    }
});
//判断电话号码(移动电话和固定电话)).给需要输入电话号码的input框相应的class名
var phones = /^1[3|4|5|7|8][0-9]{9}$/;
var phones_2=/^0\d{2,3}-?\d{7,8}$/;
$('.phones').keyup(function() {
    if (phones.test($(this).val())||phones_2.test($(this).val())) {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
        $(this).parent('.input-item').next('.input-item_span').text('內容不能为空');

    } else {
        $(this).parent('.input-item').next('.input-item_span').css('visibility', 'visible');
    }
    //console.log(resajax);
});

//正则判断手机号码，身份证号，数字（先判断有没有某个class，然后在判断值是否符合标准，点击提交按钮的时候调用这个方法）
function detection_2(){
    //手机号码验证
    if($("input").hasClass("phones")){
        if (phones.test($(".phones").val())||phones_2.test($(".phones").val())) {
            $(".phones").parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
            $(".phones").parent('.input-item').next('.input-item_span').text('內容不能为空');
            //console.log("手机号码验证1:"+resajax);
        } else {
            $(".phones").parent('.input-item').next('.input-item_span').css('visibility', 'visible');
            $(".phones").parent('.input-item').next('.input-item_span').text('请填写正确格式的有机号码');
            resajax = false;
            //console.log("手机号码验证2:"+resajax);
        }
    }

    //单独的数字验证
    if($("input").hasClass("regNumber")){
        if (regNumber.test($('.regNumber').val())) {
            $('.regNumber').parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
            $('.regNumber').parent('.input-item').next('.input-item_span').text('內容不能为空');
            //console.log("数字验证1:"+resajax);
        }else {
            $('.regNumber').parent('.input-item').next('.input-item_span').css('visibility', 'visible');
            $('.regNumber').parent('.input-item').next('.input-item_span').text('只能为纯数字');
            resajax = false;
            //console.log("数字验证2:"+resajax);
        }
    }

    //单独身份证验证
    if($("input").hasClass("regExpID")){
        if (regExpID.test($('.regExpID').val())) {
            $('.regExpID').parent('.input-item').next('.input-item_span').css('visibility', 'hidden');
            $('.regExpID').parent('.input-item').next('.input-item_span').text('內容不能为空');
            //console.log("身份证验证1:"+resajax);
        } else {
            $('.regExpID').parent('.input-item').next('.input-item_span').css('visibility', 'visible');
            $('.regExpID').parent('.input-item').next('.input-item_span').text('身份证号错误,请输入正确的身份证号');
            resajax = false;
            //console.log("身份证验证2:"+resajax);
        }
    }
}








/**---------------------------- forms文件下所以页面的ajax提交和正则验证   结束  ---------------------------**/



/***************************** 判断选择时间只能是今天之前和今天之后 ***************************/
timeMax();
/*timeMin();*/
//最大为当天时间可选
function timeMax() {
    var time = new Date();
    //获取到年
    var year = time.getFullYear();
    //获取月
    var month = time.getMonth() + 1;
    //获取日
    var day = time.getDay();
    //当获取的时间为一位数的时候就在前面加一个零，以两位数的形式展现
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    $(".dateMax").prop("max", year + "-" + month + "-" + day);
}
//最小为当天时间可选
/*function timeMin() {
 var time = new Date();
 var year = time.getFullYear();
 var month = time.getMonth() + 1;
 var day = time.getDay();
 //当获取的时间为一位数的时候就在前面加一个零
 if (month < 10) {
 month = "0" + month;
 }
 if (day < 10) {
 day = "0" + day;
 }
 $(".dateMin").prop("min", year + "-" + month + "-" + day);
 }*/

/***************************** 判断选择时间只能是今天之前和今天之后  结束 ***************************/
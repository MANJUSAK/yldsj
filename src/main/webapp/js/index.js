//banner轮播图
//window.onload = loadshow(1);

var t;
/******************************* 首页图图片轮播 ********************************/
//鼠标移除时调用的方法
$(function() {
	var host = window.sessionStorage.getItem("index_host_img");
	/*if(host==null){
		location.reload();
	}*/
	var i = 0;
	var timing;
	$.ajax({
		type: "get",
		url: host + "/carousel",
		async: true,
		success: function(result) {
			data = result.data.picture;
			$(".benner_img").attr("src", data[0]);
			//动态的添加class名(ahover)
			$(".four_benner_ul a").eq(0).addClass("ahover");
			$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
			//动态的删除class名(ahover)
			$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
			var d = data.length;
			timing = window.setInterval(function() {
				i++;
				if(i > d) {
					//动态的改变图片
					$(".benner_img").attr("src", data[d]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(d).addClass("ahover");
					$(".four_benner_ul a").eq(d).siblings().removeClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(d).siblings().removeClass("ahover");
					i = 0;
				} else {
					//动态的改变图片
					$(".benner_img").attr("src", data[i]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(i).addClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(i).siblings().removeClass("ahover");
				}
				if(i == 0) {
					$(".benner_img").attr("src", data[0]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(0).addClass("ahover");
					$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
				}
			}, 3000);
			//鼠标移入时调用的方法
			$(".four_benner_ul_a").mouseover(function() {

				var q = $(this).index();
				$(".benner_img").attr("src", data[q]);
				//动态的添加class名(ahover)
				$(this).addClass("ahover").siblings().removeClass("ahover");
				//动态的删除class名(ahover)
				$(".four_benner_ul a").eq(q).siblings().removeClass("ahover");
				i = $(this).index();
				clearInterval(timing);
			});

			//鼠标移出时调用的方法
			$(".four_benner_ul_a").mouseout(function() {
				/*window.setInterval(function() {
				i++;
				if(i > d) {
					//动态的改变图片
					$(".benner_img").attr("src", data[d]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(d).addClass("ahover");
					$(".four_benner_ul a").eq(d).siblings().removeClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(d).siblings().removeClass("ahover");
					i = 0;
				} else {
					//动态的改变图片
					$(".benner_img").attr("src", data[i]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(i).addClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(i).siblings().removeClass("ahover");
				}
				if(i == 0) {
					$(".benner_img").attr("src", data[0]);
					//动态的添加class名(ahover)
					$(".four_benner_ul a").eq(0).addClass("ahover");
					$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
					//动态的删除class名(ahover)
					$(".four_benner_ul a").eq(0).siblings().removeClass("ahover");
				}
			}, 3000);*/
			})
			
		},
		error: function(e) {
			console.log(e.status)
		}
	});
})

//banner轮播图
//window.onload=function(){
//	loadshow();

//}
//window.onload = loadshow(1);
//
//
//									
//var t;
///******************************* 首页图图片轮播 ********************************/

/******************************* 首页图图片轮播 结束 ********************************/

//行业协会轮播图
var iaLeft = document.getElementById("iaLeft");
var pics = ['21.jpg', '22.jpg', '23.jpg', '24.jpg', '25.jpg'];
var i = 0;
var id = setInterval(change, 3000);

function change() {
	i++;
	if(i == 5) {
		i = 0;
	}
	//设置背景图片样式
	iaLeft.style.background = 'url("img/' + pics[i] + '") no-repeat';
	iaLeft.style.backgroundSize = '100% ' + 375 + 'px';
	changePoint();
}

function changePoint() {
	for(var j = 0; j < 5; j++) {
		//更改class名
		document.getElementById('point' + j).className = 'ia-points-a';
	}
	//更改class名
	document.getElementById('point' + i).className = 'ia-points-a ia-ahover';

}
for(var j = 0; j < 5; j++) {
	document.getElementById('point' + j).onmouseover = function(j) {
		return function() {
			iaLeft.style.background = 'url("img/' + pics[j] + '")';
			iaLeft.style.backgroundSize = '100% ' + 375 + 'px';
			i = j;
			changePoint();
		}
	}(j);
}
//行业协会轮播图   结束

//获取浏览器宽度
var winWidth;
if(window.innerWidth) {
	winWidth = window.innerWidth;
} else if((document.body) && (document.body.clientWidth)) {
	winWidth = document.body.clientWidth
}

//企业推荐滚动
var gcBox = document.getElementById("gcBox");
var qiyechange = function(sgw) {
	var gw = $('#gcBox').width();
	var h = parseInt(gw / sgw);
	var w = 1;
	$(".groom-container").css('width', '' + sgw + 'px');
	setInterval(function() {
		gcBox.style.marginLeft = '-' + sgw * w + 'px';
		w++;
		if(w == h) {
			w = 0;
		} else {
			//过渡动画，过渡的时间为1秒
			gcBox.style.transition = 'all 1s';
		}
	}, 2000);

}
if(winWidth > 1024) {
	//过渡的过渡时间为1秒
	gcBox.style.transition = 'transform 1s';
	var positions = ['0px', -1080 * 1 + 'px', -1080 * 2 + 'px', -1080 * 3 + 'px'];
	var q = 0;
	setInterval(function() {
		gcBox.style.transform = 'translate(' + positions[q] + ', 0px)'
		q++;
		if(q == 4) {
			q = 0;
		}
	}, 4500);
} else {
	var sgw = 269.750;
	qiyechange(sgw);
	//苗木信息
	var ip = 1;
	$('.groom-container').css('height', '269.750px');
	var pi = setInterval(function() {
		for(var c = 0; c <= 2; c++) {
			$(".plant-content > div:eq(" + c + ")").css('display', 'none');
		};
		$(".plant-content > div:eq(" + ip + ")").css('display', 'block');
		ip++;
		if(ip == 3) {
			ip = 0;
		}
	}, 2000);
}

//企业推荐滚动  结束
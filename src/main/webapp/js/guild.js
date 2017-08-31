/*---------------------------------- 行业协会的图片轮播（guild.html） ----------------------------------------*/
var blContent = document.getElementById("blContent");
var pics = ['g1.jpg', 'g2.jpg', 'g3.jpg', 'g4.jpg'];
var i = 0;
var id = setInterval(change, 4000);

function change() {
	i++;
	if(i > 3) {
		i = 0;
	}
//	blContent.style.background = 'url("img/' + pics[i] + '")';
	//改变背景图片路径，设置图片不平铺
	$("#blContent").css({"background-repeat":"no-repeat","background-image":"url(img/"+pics[i]+")","background-size":"100% 100%"});
	changePoint();
}

function changePoint() {
	for(var j = 0; j < 4; j++) {
		//动态的改变class名
		document.getElementById('point' + j).className = 'bp-item';
	}
	//动态的改变class名。添加class名
	document.getElementById('point' + i).className = 'bp-item bp-active';

}
var biNext = document.getElementById("biNext");
biNext.onclick = function() {
	change();
	//1s的过度的时间
	blContent.style.transition = '1s';
}
var biPrev = document.getElementById("biPrev");
biPrev.onclick = function() {
	i--;
	if(i < 0) {
		i = 3;
	}
	//改变背景图
	blContent.style.background = 'url("img/' + pics[i] + '")';
	//设置图片宽和高都铺满
	blContent.style.backgroundSize = '100% 100%';
	changePoint();
}
for(var j = 0; j < 4; j++) {
	document.getElementById('point' + j).onclick = function(j) {
		return function() {
			//改变背景图
			blContent.style.background = 'url("img/' + pics[j] + '")';
			//设置图片宽和高都铺满
			blContent.style.backgroundSize = '100% 100%';
			i = j;
			changePoint();
		}
	}(j);
}
var winWidth;
if(window.innerWidth) {
	winWidth = window.innerWidth;
} else if((document.body) && (document.body.clientWidth)) {
	winWidth = document.body.clientWidth
}

if (winWidth <= 1024) {
	var gnh = $('.gbl-none').height();

	$('#blContent').css('height',gnh)
}
//切换卡
var tabs = {
	tabs: function(ID, span, body, main) {
		var ID = document.getElementById(ID);
		var span = document.getElementById(span);
		var body = document.getElementById(body);
		var main = document.getElementById(main);
		ID.onclick = function() {
			ID.className = 'gs2-a';
			span.className = 'none';
			body.style.display = 'block';
			main.style.display = 'none';
		}
		span.onclick = function() {
			span.className = 'gs2-a';
			ID.className = 'none';
			main.style.display = 'block';
			body.style.display = 'none';
		}
	}
}
/*---------------------------------- 行业协会的图片轮播（guild.html）   结束 ----------------------------------------*/
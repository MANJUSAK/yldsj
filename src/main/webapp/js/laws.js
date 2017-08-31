/**------------------------------ 法律法规的图片轮播（laws.html） ---------------------------------**/
var blContent = document.getElementById("blContent");
var pics = ['f1.jpg', 'f2.jpg', 'f3.jpg', 'f4.jpg'];
var i = 0;

var id = setInterval(change, 4000);
function change() {
	i++;
	if(i > 3) {
		i = 0;
	}
	//改变背景图片路径，设置图片不平铺
	blContent.style.background = 'url("img/' + pics[i] + '") no-repeat';
	//设置图片宽和高都铺满
	blContent.style.backgroundSize = '100% 100%';
	changePoint();
}

function changePoint() {
	for(var j = 0; j < 4; j++) {
		//动态的改变ID名
		document.getElementById('point' + j).className = 'bp-item';
	}
	//添加类名
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
	blContent.style.backgroundSize = '100% 100%px';
	changePoint();
}
for(var j = 0; j < 4; j++) {
	document.getElementById('point' + j).onclick = function(j) {
		return function() {
			//改变背景图
			blContent.style.background = 'url("img/' + pics[j] + '")';
			//设置图片宽和高都铺满
			blContent.style.backgroundSize = '100% 100%px';
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
//winWidth <= 1024时设置#blContent的高度
if (winWidth <= 1024) {
	var gnh = $('.gbl-none').height();

	$('#blContent').css('height',gnh)
}

/**------------------------------ 法律法规的图片轮播（laws.html）  结束 ---------------------------------**/
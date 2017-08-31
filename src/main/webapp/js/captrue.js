/*--------------------------  该方法暂不使用，这是动态的控制显示文字的数量，在页面中调用方法，传入先关的值即可  -------------------------------*/
var capture = function(cName,ttextLeng) {
//	var count = $('.dc-right-content').length;
	//获取长度
	var count = $('.'+cName+'').length;
	for(var i = 0; i <= count - 1; i++) {
		//遍历
		var textconten = $('.'+cName+' > p:eq(' + i + ')');
		var str = textconten.text();
		var textLeng = ttextLeng;
		//传入设置的值
		var sstr = str.substring(0, textLeng);
		if(str.length > textLeng) {
			//在最后面添加省略号
			textconten.text(sstr + '....');
		}
	}
}

var capture_user = function(cName,ttextLeng) {
//	var count = $('.dc-right-content').length;
	var count = $('.'+cName+'').length;
	for(var i = 0; i <= count - 1; i++) {
		var textconten = $('.'+cName+' > a:eq(' + i + ')');
		var str = textconten.text();
		var textLeng = ttextLeng;
		var sstr = str.substring(0, textLeng);
		if(str.length > textLeng) {
			textconten.text(sstr + '....');
		}
	}
}
/*--------------------------  该方法暂不使用，这是动态的控制显示文字的数量，在页面中调用方法，传入先关的值即可  结束  -------------------------------*/
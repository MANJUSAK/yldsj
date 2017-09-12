$(function() {
	function post(URL, PARAMS) {
		var temp = document.createElement("form");
		temp.action = URL;
		temp.method = "post";
		temp.style.display = "none";
		for(var x in PARAMS) {
			var opt = document.createElement("input");
			opt.name = x;
			opt.value = PARAMS[x];
			temp.appendChild(opt);
		}
		document.body.appendChild(temp);
		temp.submit();
		return temp;
	}
	$("#tc-rtl_manage1,#tc-rtl_manage2").click(function() {
		//调用方法 如        
		post(window.sessionStorage.getItem("Host1") + $.session.get('ucomp') + '/horizon/basics/getBasics.wf', {
			loginName: $.session.get('uname'),
			isNo: 1
		});
	})
})
$(function(){
	var data = window.sessionStorage.getItem("worker_detail");
	if(data==null){
		window.location.href="worker.html";
	}
	data = JSON.parse(data);
	$('#show_tiele').html(data.name);
	$('#name').html(data.name);
	$('#sex').html(data.gender);
	$('#education').html(data.education);
	$('#companyname').html(data.company);
	$('#experience').html(data.experience);

})
$(function() {

	var data = window.sessionStorage.getItem('talents_details');
	if(data == null) {
		window.location.href = "talents.html";
	}
	console.log(data)
	data = JSON.parse(data);
	$('#show_title').html(data.company);
	$('#company').html(data.company);
	$('#detailAddress').html(data.detailAddress);
	$('#registerAddress').html(data.registerAddress);
	$('#registerCap').html(data.registerCap);
	$('#nature').html(data.nature);
	$('#companyIntro').html(data.companyIntro);
})
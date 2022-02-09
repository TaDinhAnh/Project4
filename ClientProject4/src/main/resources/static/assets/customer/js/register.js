$(function() {
	$("#datepicker").datepicker({
		dateFormat: 'dd/mm/yy'
	}).val();
});
$(document).ready(function() {
	$("#register").submit(function(e) {
		var currentTime = new Date();
		var year = currentTime.getFullYear();
		var from = $("#datepicker").val().split("/")
		var dateRegister = new Date(from[2], from[1] - 1, from[0])
		var yearRegister = dateRegister.getFullYear();
		if(year - yearRegister < 18){
			alert("Please enter dob again!!");
			e.preventDefault();
		}
		var fullname = $("#fullname").val();
		var gmail = $("#gmail").val();
		var pass = $("#pass").val();
		var rePass = $("#rePass").val();
		var birthday = $("#birthday").val();
		var role = $("#role").val();
		var phone = $("#phone").val();
		if (pass != rePass) {
			alert("Pass and Repeat your password not match");
			$('#pass').val("");
			$('#rePass').val("");
			return false;
		}
		$.ajax({
			type
				: "POST",
			data: {
				fullname: fullname,
				gmail: gmail,
				pass: pass,
				birthday: birthday,
				role: role,
				phone: phone,
			},
			url: '${pageContext.request.contextPath }/customer/account/register'
		});

	})
});

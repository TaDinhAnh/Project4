
$(document)
	.ready(
		function() {
			$(function() {
				$("#datepicker").datepicker({
					dateFormat: 'dd/mm/yy'
				}).val();
			});
			$("#register")
				.submit(
					function(e) {
						var fullname = $("#fullname").val();
						var gmail = $("#gmail").val();
						var pass = $("#pass").val();
						var rePass = $("#rePass").val();
						var birthday = $("#birthday").val();
						var role = $("#role").val();
						var phone = $("#phone").val();
						if (pass != rePass) {
							alert("Pass and Repeat your password not match");
							 e.preventDefault();
							 $("#rePass").focus();
							  $("#rePass").val("");
						}

						$
							.ajax({
								type: "POST",
								data: {
									fullname: fullname,
									gmail: gmail,
									pass: pass,
									rePass: rePass,
									birthday: birthday,
									role: role,
									phone: phone,
								},
								url: '${pageContext.request.contextPath }/customer/account/register',

							});

					})
		});
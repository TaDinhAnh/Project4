$(document).ready(function() {
	var images = $('#avatarOld').attr("src");
	$("#closeModal").click(function() {
		var data = $(this).val();
		var rs = data.split(",");
		$("#name").val(rs[0]);
		$("#phone").val(rs[1]);
	})
	$("#register").submit(function(e) {
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
		$.ajax({
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
	$("#updateAccount").click(function() {
		var id = $("#id").val();
		var gmail = $("#gmail").val();
		var fullname = $("#name").val();
		var phone = $("#phone").val();
		var dob = $("#dob").val();
		if (fullname === "") {
			alert("Please enter fullname !");
			return;
		} else if (phone === "") {
			alert("Please enter phone !");
			return;
		} else if (dob === "") {
			alert("Please enter dob !");
			return;
		}
		$.ajax({
			type: "PUT",
			url: "http://localhost:9799/api/account/"
				+ id,
			contentType: "application/json; charset=utf-8",
			data: JSON
				.stringify({
					"id": id,
					"gmail": gmail,
					"fullname": fullname,
					"phone": phone,
					"dob": dob,
				}),
			dataType: "json",
			error: function(xhr) {
				if (xhr.status === 401) {
					window.location.href = "http://localhost:8088/account/login";
				} else {
					window.location.href = "http://localhost:8088/error/400page";
				}
			},
			success: function() {
				window.location.href = "http://localhost:8088/customer/account/changeInfor";
			},
		});
	});

	$("#updatePassword").click(
		function() {
			var id = $("#id").val();
			var oldpass = $("#oldpass").val();
			var newpass = $("#newpass").val();
			var repeatpass = $("#repeatpass")
				.val();
			if (oldpass === "") {
				alert("Please enter old password!");
				return;
			} else if (newpass === "") {
				alert("Please enter new password !");
				return;
			} else if (repeatpass === "") {
				alert("Please enter repeat password !");
				return;
			} else if (newpass != repeatpass) {
				alert("New password and Repeat Password not match!");
				$("#repeatpass").val("");
				return;
			}
			$.ajax({
				type: "PUT",
				url: "http://localhost:9799/api/account/changePass/" + id,
				contentType: "application/json; charset=utf-8",
				data: JSON.stringify({
					"passOld": oldpass,
					"passNew": repeatpass,
				}),
				dataType: "json",
				error: function(xhr) {
					switch (xhr.status) {
						case 401:
							window.location.href = "http://localhost:8088/account/login";
							breack;
						case 409:
							alert("Password old invalid")
							breack;
						default:
							window.location.href = "http://localhost:8088/error/400page";
					}
				},
				success: function() {
					window.location.assign("http://localhost:8088/customer/account/changeInfor");
				},
			});
		});

	$("#inputupdateAvatar").change(function() {
		const file = this.files[0];
		if (file) {
			let reader = new FileReader();
			reader.onload = function(event) {
				$("#avatarOld")
					.attr("src", event.target.result);
			};
			reader.readAsDataURL(file);
		}
	});
	$("#updateAvatar").on('submit', (function(e) {
		e.preventDefault();
		var formData = new FormData();
		var id = $("#idAccount").val()
		avatarOld = images.slice(57, images.lenght)
		formData.append("fileImg", $('#inputupdateAvatar')[0].files[0]);
		$.ajax({
			type: 'POST',
			url: "http://localhost:9799/api/account/changeAvatar/" + id + "/" + avatarOld,
			data: formData,
			processData: false,
			contentType: false,
			success: function() {
				window.location.href = "http://localhost:8088/customer/account/changeInfor";
			},
			error: function(xhr) {
				if (xhr.status === 401) {
					window.location.href = "http:/localhost:8088/customer/account/signIn";
				}
				else {
					window.location.href = "http://localhost:8088/error/400page";
				}
			}
		});
	}));
});
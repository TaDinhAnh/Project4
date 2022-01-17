$(document).ready(function() {
	$("#saveCate").click(function() {
		var name = $("#nameCate").val();
		if (name === "") {
			alert("Please enter name category!");
			return;
		}
		var presentid = $('#presentCate').find(":selected").val();
		$.ajax({
			type: "POST",
			url: "http://localhost:9799/api/category",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				"presentid": presentid,
				"name": name
			}),
			dataType: "json",
			success: function() {
				window.location.href = "http://localhost:8088/admin/category";
			},
			error: function(xhr) {
				if (xhr.status === 401) {
					window.location.href = "http://localhost:8088/account/login";
				}
				else {
					window.location.href = "http://localhost:8088/requesterror/400page";
				}
			}
		});

	});
});
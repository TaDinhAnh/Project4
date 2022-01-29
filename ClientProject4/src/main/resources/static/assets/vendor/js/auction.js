$(document).ready(function() {
	$("#createAuction").click(function() {
		var id = $("#accountid").val();
		var start = $("#hstart").val();
		var end = $("#hend").val();
		var date = $("#date").val();
		var description = $("#description").val();
		if (start === "") {
			alert("Please enter start time!");
			return;
		} else if (end === "") {
			alert("Please enter end time !");
			return;
		} else if (date === "") {
			alert("Please enter date !");
			return;
		} else if (description === "") {
			alert("Please enter description !");
			return;
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:9799/api/auction",
			contentType: "application/json; charset=utf-8",
			data: JSON
				.stringify({
					"vendorId": id,
					"hourStart": start,
					"hourEnd": end,
					"eventdate": date,
					"description": description,
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
				window.location.href = "http://localhost:8088/customer/view/auction/vendor";
			},
		});
	});
});
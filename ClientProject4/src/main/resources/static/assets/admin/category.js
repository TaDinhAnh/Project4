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

	$("#tableCate").on('click', '.updateCate', function() {
		var currentRow = $(this).closest("tr");
		var idCate = currentRow.find("td:eq(0)").text();
		var name = currentRow.find("td:eq(1)").text();
		var presentCate = currentRow.find("td:eq(2)").text();
		$("#idCateUpdate").val(idCate.trim(``));
		$("#nameCateUpdate").val(name.trim());
		$("select option").filter(function() {
			return $(this).text() == presentCate.trim();
		}).prop('selected', true);
	});
	$("#saveUpdate").click(function() {
		var id = $("#idCateUpdate").val();
		var name = $("#nameCateUpdate").val();
		if (name === "") {
			alert("Please enter name category!");
			return;
		}
		var presentid = $('#presentCateUpdate').find(":selected").val();
		$.ajax({
			type: "PUT",
			url: "http://localhost:9799/api/category/" + id,
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
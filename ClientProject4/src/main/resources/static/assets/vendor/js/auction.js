$(document).ready(function() {
	$("#createAuction").click(function() {
		var id = $("#accountid").val();
		var start = $("#hstart").val();
		var end = $("#hend").val();
		var date = $("#createdate").val();
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
	
	$("#tableNAuction").on('click', '.upAuction', function() {
			var currentRow = $(this).closest("tr");
			var des = currentRow.find("td:eq(0)").text().trim();
			var evdate = currentRow.find("td:eq(1)").text().trim();
			var hs = currentRow.find("td:eq(2)").text().trim();
			var he = currentRow.find("td:eq(3)").text().trim();
			var id = currentRow.find("td:eq(5)").text().trim();
			$("#updateDate").val(evdate);
			$("#updateDescription").val(des);
			$("#updateHstart").val(hs);
			$("#updateHend").val(he);
			$("#updateId").val(id);
			
		});
		
		$("#updateAuction").click(function() {
			var id = $("#updateId").val();
			var accountid = $("#accountid").val();
			var start = $("#updateHstart").val();
			var end = $("#updateHend").val();
			var date = $("#updateDate").val();
			var description = $("#updateDescription").val();
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
				type: "PUT",
				url: "http://localhost:9799/api/auction/" +id,
				contentType: "application/json; charset=utf-8",
				data: JSON
					.stringify({
						"vendorId": accountid,
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
		
		$("#createAuctionProduct").on('submit', (function(e) {
		e.preventDefault(); 
			var id = $("#updateId").val();
			var productid = $('#currentPro').find(":selected").val();	
			$.ajax({
				type: "POST",
				url: "http://localhost:9799/api/auctionProduct",
				contentType: "application/json; charset=utf-8",
				data: JSON
				.stringify({
					"auctionId": id,
					"proId": productid,
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
		}));
});
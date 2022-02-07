$(document).ready(function() {
	var imgold;
	$(".allownumericwithdecimal").on("keypress keyup blur", function(event) {
		$(this).val($(this).val().replace(/[^0-9\.]/g, ''));
		if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
			event.preventDefault();
		}
	});
	$("#createProduct").on('submit', (function(e) {
		e.preventDefault();
		var formData = new FormData();
		formData.append("filePro", $('#filePro')[0].files[0]);
		formData.append("namePro", $("#namePro").val());
		formData.append("proDesc", $("#proDesc").val());
		formData.append("pricePro", $("#pricePro").val());
		formData.append("idVendor", $("#idVendor").val());
		formData.append("idCate", $("#idCategory").val());
		console.log(formData.get("filePro"));
		$.ajax({
			type: 'POST',
			url: "http://localhost:9799/api/product",
			data: formData,
			processData: false,
			contentType: false,
			success: function() {
				window.location.href = "http://localhost:8088/vendor/product/index";
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
	$("#updatePro").click(function() {
		var proname = $("#proname").text().trim();
		var catepro = $("#catepro").text().trim();
		var pricePro = $("#pricePro").text().trim();
		var descPro = $("#descPro").text().trim();
		var images = $('#imagePro').attr("src");
		imgold = images.slice(58, images.lenght)
		console.log(imgold)
		$("#updateNamePro").val(proname);
		$("#updateCatePro option").filter(function() {
			return $(this).text() == catepro;
		}).prop('selected', true);
		$("#updatePircePro").val(pricePro);
		$("#updateProDesc").val(descPro);
		$("#imageUpdatePro").attr("src", images);

	});
	$("#updateProduct").click(function() {
		var id = $("#updateidpro").val();
		var proname = $("#updateNamePro").val();
		var catepro = $("#updateCatePro").val();
		var pricePro = $("#updatePircePro").val();
		var descPro = $("#updateProDesc").val();
		$.ajax({
			type: "PUT",
			url: "http://localhost:9799/api/product/" + id,
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				"categoryId": catepro,
				"name": proname,
				"description": descPro,
				"priceMin": pricePro
			}),
			dataType: "json",
			success: function() {
				window.location.href = "http://localhost:8088/vendor/product/index";
			},
			error: function(xhr) {
				if (xhr.status === 401) {
					window.location.href = "http://localhost:8088/account/login";
				}
				else {
					window.location.href = "http://localhost:8088/error/400page";
				}
			}
		});

	});
	$("#updateImg").change(function() {
		const file = this.files[0];
		if (file) {
			let reader = new FileReader();
			reader.onload = function(event) {
				$("#imageUpdatePro")
					.attr("src", event.target.result);
			};
			reader.readAsDataURL(file);
		}
	});
	$("#updateImagePro").on('submit', (function(e) {
		e.preventDefault();
		var formData = new FormData();
		var id = $("#updateidpro").val();
		formData.append("fileImg", $('#updateImg')[0].files[0]);
		$.ajax({
			type: 'POST',
			url: "http://localhost:9799/api/product/changeImg/" + id + "/" + imgold,
			data: formData,
			processData: false,
			contentType: false,
			success: function() {
				window.location.href = "http://localhost:8088/vendor/product/index";
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

	$("#formAuction").on('submit', (function(e) {

		if ($("#priceCurent").val() === "") {
			alert("Enter price");
			return;
		}
		var priceMax = parseFloat($("#priceMax").text());
		var priceCurent = parseFloat($("#priceCurent").val());

		if (priceCurent <= priceMax) {
			alert("Please re-enter the price greater than the price!!!");
			return;
		}
	}));
})
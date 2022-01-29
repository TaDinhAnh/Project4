$(document).ready(function() {
	$("#tableOrders").on('click', '.btnPayment', function() {
		var currentRow = $(this).closest("tr");
		var idOrder = currentRow.find("td:eq(0)").text().trim();
		var namePro = currentRow.find("td:eq(1)").text().trim();
		var address = currentRow.find("td:eq(2)").text().trim();
		var date = currentRow.find("td:eq(3)").text().trim();
		var total = parseInt(currentRow.find("td:eq(4)").text().trim());
		var paid = parseInt(total) * 80 / 100;
		$("#namePro").val(namePro);
		$("#date").val(date);
		$("#total").val(total);
		$("#paid").val(paid);
		$("#address").val(address);
		$("#idOrders").val(idOrder);
	});
})
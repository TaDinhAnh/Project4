$(document).ready(function() {
	$(".replyFeedback").click(function() {
		var rs = $(this).val();
		var myarray = rs.split(",");
		var toemail = myarray[0];
		var id = myarray[1];
		$("#toEmailReply").val(toemail);
		$("#contentReply").val("");
		$("#idFeedback").val(id)
	});
	
	$("#btnReplyFeedback").click(function() {
		var id = $("#idFeedback").val();
		var toEmail = $("#toEmailReply").val();
		var subject = $("#subjectReply").val();
		var content = $("#contentReply").val();
		if (subject === "" || content ==="") {
			alert("Please enter full field!");
			return;
		}
		$.ajax({
			type: "POST",
			url: "http://localhost:9799/api/feedback/reply/"+id,
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				"content": content,
				"subject": subject,
				"toEmail": toEmail
			}),
			dataType: "json",
			success: function() {
				window.location.href = "http://localhost:8088/admin/dashboard";
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
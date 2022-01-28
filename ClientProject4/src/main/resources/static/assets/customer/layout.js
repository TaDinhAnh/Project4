$(document).ready(function() {
	var myVar = setInterval(myTimer, 1000);
	var my = setInterval(myDate, 1000);
	var win = navigator.platform.indexOf('Win') > -1;
	if (win && document.querySelector('#sidenav-scrollbar')) {
		var options = {
			damping: '0.5'
		}
		Scrollbar.init(document.querySelector('#sidenav-scrollbar'),
			options);
	}
	function myTimer() {
		var d = new Date();
		var t = d.toLocaleTimeString();
		$("#timeClock").html(t);
	}
	function myDate() {
		var date = new Date();
		var day = date.toDateString();
		$("#day").html(day);
	}
	function myTimer() {
		var d = new Date();
		var t = d.toLocaleTimeString();
		$("#timeClock").html(t);
	}
	function myDate() {
		var date = new Date();
		var day = date.toDateString();
		$("#day").html(day);
	}
})
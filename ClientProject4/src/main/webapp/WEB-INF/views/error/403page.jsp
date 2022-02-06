<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<title>403 Error</title>

	<link href="https://fonts.googleapis.com/css?family=Nunito:400,700" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/customer/css/styleEror404.css" />

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="access denied-403"></div>
			<h1>403</h1>
			<h2>Oops! Page Not Be Found</h2>
			<p>Sorry but the page you are looking for does not exist, have been removed. name changed or is temporarily unavailable</p>
			<a href="${pageContext.request.contextPath }/customer/view/home">Back to homepage</a>
		</div>
	</div>
</body>
</html>
<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>EstateAgency Bootstrap Template - Index</title>
<meta content="" name="description">
<meta content="" name="keywords">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/img/favicon.png"
	rel="icon">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/img/apple-touch-icon.png"
	rel="apple-touch-icon">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/css/style.css"
	rel="stylesheet">

<script>
	var myVar = setInterval(myTimer, 1000);
	var my = setInterval(myDate, 1000);
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
	function datepicker() {
		$("#datepicker").datepicker();
	};
</script>
</head>

<body>
	<div class="click-closed"></div>
	<div class="box-collapse">
		<div class="title-box-d">
			<h3 class="title-d">Search Property</h3>
		</div>
		<span class="close-box-collapse right-boxed bi bi-x"></span>
		<div class="box-collapse-wrap form">
			<form class="form-a">
				<div class="row">
					<div class="col-md-12 mb-2">
						<div class="form-group">
							<label class="pb-2" for="Type">Keyword</label> <input type="text"
								class="form-control form-control-lg form-control-a"
								placeholder="Keyword">
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="Type">Type</label> <select
								class="form-control form-select form-control-a" id="Type">
								<option>All Type</option>
								<option>For Rent</option>
								<option>For Sale</option>
								<option>Open House</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="city">City</label> <select
								class="form-control form-select form-control-a" id="city">
								<option>All City</option>
								<option>Alabama</option>
								<option>Arizona</option>
								<option>California</option>
								<option>Colorado</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="bedrooms">Bedrooms</label> <select
								class="form-control form-select form-control-a" id="bedrooms">
								<option>Any</option>
								<option>01</option>
								<option>02</option>
								<option>03</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="garages">Garages</label> <select
								class="form-control form-select form-control-a" id="garages">
								<option>Any</option>
								<option>01</option>
								<option>02</option>
								<option>03</option>
								<option>04</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="bathrooms">Bathrooms</label> <select
								class="form-control form-select form-control-a" id="bathrooms">
								<option>Any</option>
								<option>01</option>
								<option>02</option>
								<option>03</option>
							</select>
						</div>
					</div>
					<div class="col-md-6 mb-2">
						<div class="form-group mt-3">
							<label class="pb-2" for="price">Min Price</label> <select
								class="form-control form-select form-control-a" id="price">
								<option>Unlimite</option>
								<option>$50,000</option>
								<option>$100,000</option>
								<option>$150,000</option>
								<option>$200,000</option>
							</select>
						</div>
					</div>
					<div class="col-md-12">
						<button type="submit" class="btn btn-b">Search Property</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<nav
		class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
		<div class="container">
			<button class="navbar-toggler collapsed" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarDefault"
				aria-controls="navbarDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span></span> <span></span> <span></span>
			</button>
			<a class="navbar-brand text-brand"
				href="${pageContext.request.contextPath }/customer/view/home">Hy<span
				class="color-b">En</span></a>
			<div class="navbar-collapse collapse justify-content-center"
				id="navbarDefault">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						href="${pageContext.request.contextPath }/customer/view/home">Home</a></li>
					<!-- 					<li class="nav-item"><a class="nav-link " -->
					<%-- 						href="${pageContext.request.contextPath }/customer/about">About</a> --%>
					<!-- 					</li> -->
					<!-- 					<li class="nav-item"><a class="nav-link " -->
					<%-- 						href="${pageContext.request.contextPath }/customer/property">Property</a></li> --%>

					<!-- 					<li class="nav-item"><a class="nav-link " -->
					<%-- 						href="${pageContext.request.contextPath }/customer/blog">Blog</a></li> --%>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Auction</a>
						<div class="dropdown-menu">
							<a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/view/auction/comingsoon">The
								auction is about to begin </a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/view/auction/happenning"">The
								auction is ongoing. </a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/view/auction/happened">The
								auction is over.</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Vendor</a>
						<div class="dropdown-menu">
							<a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/view/auction/vendor">List Auctions By Vendor
								</a> 
								<a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pageBlogSingle"">Product
								</a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pageAgentsGrid"">Agents
								Grid</a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pageAgentSingle"">Agent
								Single</a>
						</div></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Account</a>
						<div class="dropdown-menu">
							<a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/account/changeInfor">Change
								Infor </a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/account/auctionhistory"">Auction
								History </a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/view/account/signIn"">Sign
								in </a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pageAgentSingle"">Sign
								out </a>
						</div></li>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath }/customer/view/contact"">Contact</a>
					</li>

				</ul>
			</div>
			<div class="nav-item;" style="padding-right: 10px">
				<button data-toggle="modal"
					style="border: none; background-color: #fff"
					data-target=".log-sign">Sign In/Register</button>
			</div>
			<div class="nav-item;"
				style="color: #6c757d; font-size: 16px; padding-right: 3px">
				<span id="day"> </span> <span id="timeClock"></span>
			</div>
			<button type="button"
				class="btn btn-b-n navbar-toggle-box navbar-toggle-box-collapse"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01">
				<i class="bi bi-search"></i>
			</button>
		</div>
	</nav>
	<main id="main">
		<jsp:invoke fragment="content"></jsp:invoke>
	</main>
	<section class="section-footer">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-4">
					<div class="widget-a">
						<div class="w-header-a">
							<h3 class="w-title-a text-brand">EstateAgency</h3>
						</div>
						<div class="w-body-a">
							<p class="w-text-a color-text-a">Enim minim veniam quis
								nostrud exercitation ullamco laboris nisi ut aliquip exea
								commodo consequat duis sed aute irure.</p>
						</div>
						<div class="w-footer-a">
							<ul class="list-unstyled">
								<li class="color-a"><span class="color-text-a">Phone
										.</span> contact@example.com</li>
								<li class="color-a"><span class="color-text-a">Email
										.</span> +54 356 945234</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-4 section-md-t3">
					<div class="widget-a">
						<div class="w-header-a">
							<h3 class="w-title-a text-brand">The Company</h3>
						</div>
						<div class="w-body-a">
							<div class="w-body-a">
								<ul class="list-unstyled">
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Site Map</a></li>
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Legal</a></li>
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Agent Admin</a></li>
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Careers</a></li>
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Affiliate</a></li>
									<li class="item-list-a"><i class="bi bi-chevron-right"></i>
										<a href="#">Privacy Policy</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-4 section-md-t3">
					<div class="widget-a">
						<div class="w-header-a">
							<h3 class="w-title-a text-brand">International sites</h3>
						</div>
						<div class="w-body-a">
							<ul class="list-unstyled">
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">Venezuela</a></li>
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">China</a></li>
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">Hong Kong</a></li>
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">Argentina</a></li>
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">Singapore</a></li>
								<li class="item-list-a"><i class="bi bi-chevron-right"></i>
									<a href="#">Philippines</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<nav class="nav-footer">
						<ul class="list-inline">
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/customer/home">Home</a></li>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/customer/about">About</a></li>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/customer/property">Property</a></li>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/customer/blog">Blog</a></li>
							<li class="list-inline-item"><a
								href="${pageContext.request.contextPath }/customer/contact">Contact</a></li>


						</ul>
					</nav>
					<div class="socials-a">
						<ul class="list-inline">
							<li class="list-inline-item"><a href="#"> <i
									class="bi bi-facebook" aria-hidden="true"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="bi bi-twitter" aria-hidden="true"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="bi bi-instagram" aria-hidden="true"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="bi bi-linkedin" aria-hidden="true"></i>
							</a></li>
						</ul>
					</div>
					<div class="copyright-footer">
						<p class="copyright color-text-a">
							&copy; Copyright <span class="color-a">EstateAgency</span> All
							Rights Reserved.
						</p>
					</div>
					<div class="credits">
						Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/vendor/php-email-form/validate.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/main.js"></script>

	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/jquery-3.6.0.min.js"></script>

	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/core/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/core/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/plugins/perfect-scrollbar.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/plugins/smooth-scrollbar.min.js"></script>
	<script>
		var win = navigator.platform.indexOf('Win') > -1;
		if (win && document.querySelector('#sidenav-scrollbar')) {
			var options = {
				damping : '0.5'
			}
			Scrollbar.init(document.querySelector('#sidenav-scrollbar'),
					options);
		}
	</script>
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/soft-ui-dashboard.min.js?v=1.0.3"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	
</body>

</html>

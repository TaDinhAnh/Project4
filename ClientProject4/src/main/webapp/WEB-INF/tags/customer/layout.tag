<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ attribute name="title" required="true" rtexprvalue="true"
	type="java.lang.String"%>
<%@ attribute name="content" fragment="true"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>EstateAgency Bootstrap Template - Index</title>
<meta content="" name="description">
<meta content="" name="keywords">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link
	href="${pageContext.request.contextPath }/resources/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/img/apple-touch-icon.png"
	rel="apple-touch-icon">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/vendor/animate.css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/css/style.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/customer/css/modalChangeInfor.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/customer/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/assets/customer/css/flaticon.css">



</head>
<body>
	<div class="click-closed"></div>

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

					<c:if test="${sessionScope.role != 'vendor' }">
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
					</c:if>

					<c:if test="${sessionScope.role == 'vendor' }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Vendor</a>
							<div class="dropdown-menu">
								<a class="dropdown-item "
									href="${pageContext.request.contextPath }/customer/view/auction/vendor">List
									Auctions By Vendor </a> <a class="dropdown-item "
									href="${pageContext.request.contextPath }/vendor/product/index">Product
								</a> <a class="dropdown-item "
									href="${pageContext.request.contextPath }/auctionproduct/index">List
									Auction Product</a>
							</div></li>
					</c:if>
					<c:if
						test="${sessionScope.role == 'customer' || sessionScope.role == 'vendor' }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Account</a>

							<div class="dropdown-menu">
								<a class="dropdown-item "
									href="${pageContext.request.contextPath }/customer/account/changeInfor">Change
									Infor </a>
								<c:if test="${sessionScope.role == 'customer' }">

									<a class="dropdown-item "
										href="${pageContext.request.contextPath }/customer/account/auctionhistory"">Auction
										History </a>
									<a class="dropdown-item "
										href="${pageContext.request.contextPath }/customer/orders/getByCus">
										Orders </a>
								</c:if>
							</div></li>
					</c:if>
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath }/customer/view/contact"">Contact</a>
					</li>
				</ul>
			</div>
			<div class="nav-item;" style="padding-right: 10px">

				<c:if test="${empty sessionScope.account }">

					<a class=""
						href="${pageContext.request.contextPath }/customer/account/signIn">Sign
						In/Register</a>
				</c:if>
				<c:if test="${sessionScope.account.fullname != null }">
					<span style="color: #6610f2"> Hello
						${sessionScope.account.fullname } </span>
					<a class=""
						href="${pageContext.request.contextPath }/customer/account/logout">Logout</a>
				</c:if>
			</div>

			<div class="nav-item;"
				style="color: #6c757d; font-size: 16px; padding-right: 3px">
				<span id="day"> </span> <span id="timeClock"></span>
			</div>

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
		src="${pageContext.request.contextPath }/resources/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/vendor/php-email-form/validate.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/main.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/jquery-3.6.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/account.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/core/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/orders.js"></script>
	<!-- modal -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/layout.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/account.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/vendor/js/product.js"></script>
</body>
</html>
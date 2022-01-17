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
						aria-expanded="false">Pages</a>
						<div class="dropdown-menu">
							<a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pagePropertySingle">Property
								Single</a> <a class="dropdown-item "
								href="${pageContext.request.contextPath }/customer/pageBlogSingle"">Blog
								Single</a> <a class="dropdown-item "
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

	<div class="modal fade bs-modal-sm log-sign" id="myModal" tabindex="-1"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="bs-example bs-example-tabs">
					<ul id="myTab" class="nav nav-tabs">
						<li id="tab1" class=" active tab-style login-shadow "><a
							href="#signin" data-toggle="tab">Log In</a></li>
						<li id="tab2" class=" tab-style "><a href="#signup"
							data-toggle="tab">Sign Up</a></li>

					</ul>
				</div>
				<div class="modal-body">
					<div id="myTabContent" class="tab-content">

						<div class="tab-pane fade active in" id="signin">
							<form class="form-horizontal">
								<section>
									<div class="page-header min-vh-75">

										<div class="row">
											<div
												class="col-xl-12 col-lg-12 col-md-12 d-flex flex-column mx-auto">
												<div class="card card-plain mt-8">
													<div
														class="card-header pb-0 text-left bg-transparent text-center">
														<h3 class="font-weight-bolder text-info text-gradient">Welcome
															back</h3>
														<p class="mb-0">Enter your email and password to sign
															in</p>
													</div>
													<div class="card-body">
														<form role="form">
															<label>Email</label>
															<div class="mb-3">
																<input type="email" class="form-control"
																	placeholder="Email" aria-label="Email"
																	aria-describedby="email-addon">
															</div>
															<label>Password</label>
															<div class="mb-3">
																<input type="email" class="form-control"
																	placeholder="Password" aria-label="Password"
																	aria-describedby="password-addon">
															</div>
															<div class="form-check form-switch">
																<input class="form-check-input" type="checkbox"
																	id="rememberMe" checked=""> <label
																	class="form-check-label" for="rememberMe">Remember
																	me</label>
															</div>
															<div class="text-center">
																<button type="button"
																	class="btn bg-gradient-info w-100 mt-4 mb-0"
																	style="background-image: linear-gradient(310deg, #2152ff 0%, #21d4fd 100%);">Sign
																	in</button>
															</div>
														</form>
													</div>

												</div>
											</div>
											<div class="col-md-6">
												<div
													class="oblique position-absolute top-0 h-100 d-md-block d-none me-n8">
													<div
														class="oblique-image bg-cover position-absolute fixed-top ms-auto h-100 z-index-0 ms-n6"
														style="background-image: url('${pageContext.request.contextPath }/resources/assets/customer/img/curved-images/curved6.jpg')"></div>
												</div>
											</div>
										</div>
									</div>
								</section>
							</form>
						</div>


						<div class="tab-pane fade" id="signup">
							<form class="form-horizontal">
								<section class="mb-8">
									<div
										class="page-header align-items-start min-vh-50 pt-5 pb-11 m-3 border-radius-lg"
										style="background-image: url('${pageContext.request.contextPath }/resources/assets/customer/img/curved-images/curved14.jpg');">
										<span class="mask bg-gradient-dark opacity-6"></span>

										<div class="row justify-content-center">
											<div class="col-lg-12 text-center mx-auto">
												<div
													class="card-header pb-0 text-left bg-transparent text-center">
													<h3 class="font-weight-bolder text-info text-gradient">Welcome!</h3>
													<p class="mb-0">Use these awesome forms to login or
														create new account in your project for free.</p>
												</div>

											</div>
										</div>

									</div>
									<div class="row mt-lg-n10 mt-md-n11 mt-n10">
										<div class="col-xl-12 col-lg-12 col-md-12 mx-auto">
											<div class="card z-index-0">
												<div class="card-header text-center pt-4">
													<h5>Register with</h5>
												</div>

												<div class="card-body">
													<form role="form text-left">
														<div class="mb-3">
															<input type="text" class="form-control"
																placeholder="Name" aria-label="Name"
																aria-describedby="email-addon">
														</div>
														<div class="mb-3">
															<input type="email" class="form-control"
																placeholder="Email" aria-label="Email"
																aria-describedby="email-addon">
														</div>
														<div class="mb-3">
															<input type="password" class="form-control"
																placeholder="Password" aria-label="Password"
																aria-describedby="password-addon">
														</div>
														<div class="mb-3">
															<input type="password" class="form-control"
																placeholder="Repeat Password"
																aria-label="Repeat Password"
																aria-describedby="password-addon">
														</div>
														<div class="mb-3">
															<input type="date" id="datepicker" class="form-control"
																placeholder="Password" aria-label="Password"
																aria-describedby="password-addon">
														</div>
														<div class="mb-3">
															<input type="text" class="form-control"
																placeholder="Phone" aria-label="Phone"
																aria-describedby="password-addon">
														</div>
														<div class="form-check form-check-info text-left">
															<div>
																<input type="radio" value="customer" name="role"
																	id="customer" checked="checked" />Customer
															</div>
															<div>
																<input type="radio" name="role" value="vendor"
																	id="vendor" />Vendor
															</div>
														</div>
														<div class="form-check form-check-info text-left">
															<input class="form-check-input" type="checkbox" value=""
																id="flexCheckDefault" checked> <label
																class="form-check-label" for="flexCheckDefault">
																I agree the <a href="javascript:;"
																class="text-dark font-weight-bolder">Terms and
																	Conditions</a>
															</label>
														</div>
														<div class="text-center">
															<button type="button"
																class="btn bg-gradient-info w-100 mt-4 mb-0"
																style="background-image: linear-gradient(310deg, #2152ff 0%, #21d4fd 100%);">Sign
																up</button>

														</div>
													</form>
												</div>
											</div>
										</div>
									</div>
								</section>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade bs-modal-sm" id="forgot-password" tabindex="0"
		role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Password will be
						sent to your email</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<fieldset>
							<div class="group">
								<input required="" class="input" type="text"><span
									class="highlight"></span><span class="bar"></span> <label
									class="label" for="date">Email address</label>
							</div>


							<div class="control-group">
								<label class="control-label" for="forpassword"></label>
								<div class="controls">
									<button id="forpasswodr" name="forpassword"
										class="btn btn-primary btn-block">Send</button>
								</div>
							</div>
						</fieldset>
					</form>

				</div>
			</div>

		</div>
	</div>

</body>

</html>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<script type="text/javascript">
	$(window, document, undefined).ready(function() {

		$('.input').blur(function() {
			var $this = $(this);
			if ($this.val())
				$this.addClass('used');
			else
				$this.removeClass('used');
		});

	});

	$('#tab1').on('click', function() {
		$('#tab1').addClass('login-shadow');
		$('#tab2').removeClass('signup-shadow');
	});

	$('#tab2').on('click', function() {
		$('#tab2').addClass('signup-shadow');
		$('#tab1').removeClass('login-shadow');

	});
</script>

<div class="container">
	<button class="btn btn-primary btn-lg" "
			data-toggle="modal"
		data-target=".log-sign">Sign In/Register</button>
</div>

<!-- Modal -->
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
																class="btn bg-gradient-info w-100 mt-4 mb-0">Sign
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
													style="background-image: url('../assets/img/curved-images/curved6.jpg')"></div>
											</div>
										</div>
									</div>
								</div>
							</section>
						</form>
					</div>


					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal">
							<section class="min-vh-100 mb-8">
								<div
									class="page-header align-items-start min-vh-50 pt-5 pb-11 m-3 border-radius-lg"
									style="background-image: url('../assets/img/curved-images/curved14.jpg');">
									<span class="mask bg-gradient-dark opacity-6"></span>
									
										<div class="row justify-content-center">
											<div class="col-lg-12 text-center mx-auto">
												<h1 class="text-white mb-2 mt-5">Welcome!</h1>
												<p class="text-lead text-white">Use these awesome forms
													to login or create new account in your project for free.</p>
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
														<input type="text" class="form-control" placeholder="Name"
															aria-label="Name" aria-describedby="email-addon">
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
															class="btn bg-gradient-dark w-100 my-4 mb-2">Sign
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
				<h4 class="modal-title" id="myModalLabel">Password will be sent
					to your email</h4>
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
		Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
	}
</script>
<script async defer src="https://buttons.github.io/buttons.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/assets/customer/js/soft-ui-dashboard.min.js?v=1.0.3"></script>


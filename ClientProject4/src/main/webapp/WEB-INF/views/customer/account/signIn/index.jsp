
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<
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

	<br>
	<center>

		<button class="btn btn-primary btn-lg" href="#signup"
			data-toggle="modal" data-target=".log-sign">Sign In/Register</button>
	</center>
	<br>


</div>

<!-- Modal -->
<div class="modal fade bs-modal-sm log-sign" id="myModal" tabindex="-1"
	role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
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
							<fieldset>
								<div class="group">
									<input required="" class="input" type="text"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Email address</label>
								</div>


								<!-- Password input-->
								<div class="group">
									<input required="" class="input" type="password"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Password</label>
								</div>
								<em>minimum 6 characters</em>

								<div class="forgot-link">
									<a href="#forgot" data-toggle="modal"
										data-target="#forgot-password"> I forgot my password</a>
								</div>


								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="signin"></label>
									<div class="controls">
										<button id="signin" name="signin"
											class="btn btn-primary btn-block">Log In</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>


					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal">
							<fieldset>
								<!-- Sign Up Form -->
								<!-- Text input-->
								<div class="group">
									<input required="" class="input" type="text"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">First Name</label>
								</div>

								<!-- Text input-->
								<div class="group">
									<input required="" class="input" type="text"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Last Name</label>
								</div>

								<!-- Password input-->
								<div class="group">
									<input required="" class="input" type="text"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Email</label>
								</div>

								<!-- Text input-->
								<div class="group">
									<input required="" class="input" type="password"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Password</label>
								</div>
								<em>1-8 Characters</em>

								<div class="group2">
									<input required="" class="input" type="text"><span
										class="highlight"></span><span class="bar"></span> <label
										class="label" for="date">Country</label>
								</div>



								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="confirmsignup"></label>
									<div class="controls">
										<button id="confirmsignup" name="confirmsignup"
											class="btn btn-primary btn-block">Sign Up</button>
									</div>
								</div>
							</fieldset>
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
  <script src="${pageContext.request.contextPath }/resources/assets/customer/js/core/popper.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/assets/customer/js/core/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/assets/customer/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="${pageContext.request.contextPath }/resources/assets/customer/js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <script src="${pageContext.request.contextPath }/resources/assets/customer/js/soft-ui-dashboard.min.js?v=1.0.3"></script>


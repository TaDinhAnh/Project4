<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/resources/assets/customer/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



</head>
<body>
	<section class="h-100 h-custom" style="background-color: #8fc4b7;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Registration
								Info</h3>

							<s:form class="px-md-2" method="post" id="register"
								modelAttribute="account">
								<div class="form-outline mb-4">
									<s:input path="fullname" class="form-control"
										placeholder="Full Name" />
									<s:errors path="fullname" style="color:red"></s:errors>
								</div>
								<div class="form-outline mb-4">
									<c:if test="${gmailExists  == true }">
										<label style="color: red"> Gmail already exists</label>
									</c:if>
									<c:if test="${gmailExists  != true }">
									<s:input path="gmail" class="form-control" placeholder="Gmail"
											id="gmail" />
										<s:errors path="gmail" style="color:red"></s:errors>
										
									</c:if>
								</div>
								<div class="row">
									<div class="col-md-6 mb-4">

										<s:password path="password" class="form-control"
											placeholder="Password" id="pass" />
										<s:errors path="password" style="color:red"></s:errors>
									</div>
									<div class="col-md-6 mb-4">
										<input type="password" class="form-control"
											placeholder="Repeat your password" id="rePass" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 mb-4">
										<div class="form-outline datepicker">
											<s:input path="dob" class="form-control"
												placeholder="Birthday" id="datepicker" />
											<span class="error" id="lblError"></span>

										</div>
									</div>
									<div class="col-md-6 mb-4">
										<s:select path="role" class="select; form-control" id="role">
											<option disabled>Role</option>
											<option value="vendor">Vendor</option>
											<option value="customer">Customer</option>
										</s:select>
									</div>
								</div>
								<div class="mb-4">
									<div class="form-outline mb-4">
										<s:input path="phone" class="form-control"
											placeholder="Your Phone" id="phone" />
										<s:errors path="phone" style="color:red"></s:errors>
									</div>
								</div>
								<button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
							</s:form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/register.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
			<script
		src="${pageContext.request.contextPath }/resources/assets/customer/js/register.js"></script>

</body>
</html>
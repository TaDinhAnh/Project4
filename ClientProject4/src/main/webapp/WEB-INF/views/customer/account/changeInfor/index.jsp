<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<mt:layout title="">
	<jsp:attribute name="content">
 <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">${account.fullname }</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="agent-single">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="row">
              <div class="col-md-6">
                <div class="agent-avatar-box">
                  <div class="card-box-d">
              <div class="card-img-d">
              <img src="${account.image}" alt=""
												class="agent-avatar img-fluid">
              
										</div>
              <div class="card-overlay card-overlay-hover">           
                <div class="card-footer-d">
                  <div
													class="socials-footer d-flex justify-content-center">
                    <ul class="list-inline">
                      <li class="list-inline-item">
                        <a href="#" class="link-one">
                          <i class="bi bi-instagram" aria-hidden="true"><input
																	type="file" name="file"></i>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
                </div>
              </div>
              </div>
                <div class="col-md-6 section-md-t3">
                <div class="agent-info-box">
                  <div class="agent-title">
                    <div class="title-box-d">
                      <h3 class="title-d">${account.fullname }
                      </h3>
                    </div>
                  </div>
                  <div class="agent-content mb-3">
                    <p class="content-d color-text-a">
                      Sed porttitor lectus nibh. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.
                      Vivamus suscipit tortor
                      eget felis porttitor volutpat. Vivamus suscipit tortor eget felis porttitor volutpat.
                    </p>
                    <div class="info-agents color-a">
                      <p>
                        <strong>Phone: </strong>
                        <span class="color-text-a"> ${account.phone }</span>
                      </p>
                      <p>
                        <strong>Email: </strong>
                        <span class="color-text-a"> ${account.gmail }</span>
                      </p>
                      <p>
                        <strong>DOB: </strong>
                        <d:formatDate value="${account.dob }"
													pattern="dd/MM/yyyy" var="date" />
                        <span class="color-text-a">${date }</span>
                      </p>
                    </div>
                  </div>
                  <div class="socials-footer">
                  <div class="list-inline">
                  <div class="row justify-content-center js-fullheight">
					<div class="col-md-6 text-center d-flex align-items-center">
						<div class="wrap w-100">
							<button type="button" class="btn btn-primary py-3 px-4"
															data-toggle="modal" data-target="#modalUpdateInfo">
										Change Information
							</button>
						</div>
					</div>
				</div>
					</div>                
                  </div>
                </div>
              </div>
                 </div>          
              </div>
            </div>
          </div>		
		</section>
		
		<div class="modal fade" id="modalUpdateInfo" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button"
							class="close d-flex align-items-center justify-content-center"
							data-dismiss="modal" aria-label="Close"
							value="${account.fullname},${account.phone},${account.dob}"
							id="closeModal">
					<span aria-hidden="true" class="ion-ios-close"></span>
				</button>
			</div>
			<div class="row no-gutters">
				<div class="col-md-6 d-flex">
					<div
								class="modal-body p-4 p-md-5 d-flex align-items-center color-1">
						<div class="text w-100 py-3">
							<span class="subheading">${account.fullname }</span>
							<h3 class="mb-4 heading">Update Information</h3>
							<form class="contact-form">
								<div class="form-group mb-3">
									<input type="text" class="form-control" placeholder="Full Name"
												value="${account.fullname }" id="name">
								</div>							
								<div class="form-group mb-3">
									<input type="text" class="form-control"
												placeholder="Email address" value="${account.gmail }"
												id="gmail" readonly="readonly">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Phone"
												value="${account.phone }" id="phone">
								</div>
								<div class="form-group">
								  <d:formatDate value="${account.dob }" pattern="dd/MM/yyyy"
												var="date" />
											<input type="text" class="form-control"
												placeholder="${date }" value="${date }" id="dob"> 
									
								</div>
								<div class="form-group">
									<button type="button"
												class="form-control btn btn-secondary rounded submit px-3"
												id="updateAccount">Change Information</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6 d-flex">
					<div class="modal-body p-4 p-md-5 d-flex align-items-center"
								style="background: #6c757d">
						<div class="text w-100 py-3">
							<span class="subheading">${account.fullname }</span>
							<h3 class="mb-4 heading">Update Password</h3>
							<form class="contact-form">
								<div class="form-group mb-3">
									<input type="password" class="form-control"
												placeholder="Old Pass" id="oldpass"> 
								</div>							
								<div class="form-group mb-3">
									<input type="password" class="form-control"
												placeholder="New Password" id="newpass">
								</div>
								<div class="form-group">
									<input type="password" class="form-control"
												placeholder="Repeat Your Password" id="repeatpass">
								</div>
								<div class="form-group">
									<button type="button"
												class="form-control btn btn-secondary rounded submit px-3"
												id="updatePassword">Change Password</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="id" value="${account.id }">
    </jsp:attribute>
</mt:layout>

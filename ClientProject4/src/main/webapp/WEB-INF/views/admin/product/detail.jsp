<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<mt:layout title="Product Detail">
	<jsp:attribute name="content">
       <div class="row">
        <div class="col-12 col-xl-4">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <h6 class="mb-0">Product</h6>
            </div>
			<div class="card card-blog card-plain">
                    <div class="position-relative" style="padding: 2%;">
                      <a class="d-block shadow-xl border-radius-xl">
                        <img
								src="${pageContext.request.contextPath }/resources/assets/admin/img/home-decor-1.jpg"
								alt="img-blur-shadow" class="img-fluid shadow border-radius-xl">
                      </a>
                    </div>
                    <div class="card-body px-1 pb-0">
                    <h5 style="padding-left: 2%;">
                          ${product.name }
                        </h5>
                     <ul class="list-group" style="padding-left: 3%;">
                        
                            <li
									class="list-group-item border-0 d-flex align-items-center px-0 mb-2">
                  <div
										class="d-flex align-items-start flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Price Min</h6>
                    <p class="mb-0 text-xs"> ${product.priceMin } $</p>
                  </div>
                </li>
                        <li
									class="list-group-item border-0 d-flex align-items-center px-0 mb-2">
                  <div
										class="d-flex align-items-start flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Category</h6>
                    <p class="mb-0 text-xs"> ${product.category }</p>
                  </div>
                </li>
                    <li
									class="list-group-item border-0 d-flex align-items-center px-0 mb-2">
                  <div
										class="d-flex align-items-start flex-column justify-content-center">
                    <h6 class="mb-0 text-sm">Description</h6>
                    <p class="mb-0 text-xs"> ${product.description }</p>
                  </div>
                </li>
                 <li
									class="list-group-item border-0 d-flex align-items-center px-0 mb-2">
                  	<c:if test="${!product.isAccept && !product.isDelete}">
            
            <a
											href="${pageContext.request.contextPath }/admin/product/accpet/${product.id}">
            	<button type="button"
												class="btn btn-outline-primary btn-sm mb-0">Accept</button>
					</a>
					
            
                    	<button type="button"
											class="btn btn-outline-primary btn-sm mb-0"
											data-toggle="modal" data-target="#modelCancelProduct">Cancel</button>
			
     </c:if>

                </li>
                      
                      </ul>
                    </div>
                  </div>
          </div>
        </div>
        <div class="col-12 col-xl-4">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <div class="row">
                <div class="col-md-8 d-flex align-items-center">
                  <h6 class="mb-0">Author</h6>
                </div>
                <div class="col-md-4 text-end"> 
                    <i class="fas fa-user-edit text-secondary text-sm"
									data-bs-toggle="tooltip" data-bs-placement="top"
									title="Profile"></i>
                </div>
              </div>
            </div>
               <div class="position-relative" style="padding: 2%;">
                      <a class="d-block shadow-xl border-radius-xl">
                        <img
							src="${pageContext.request.contextPath }/resources/assets/admin/img/home-decor-1.jpg"
							alt="img-blur-shadow" class="img-fluid shadow border-radius-xl">
                      </a>
                    </div>
            <div class="card-body">
              <ul class="list-group">
                <li class="list-group-item border-0 ps-0 pt-0 text-sm"><strong
								class="text-dark">Full Name:</strong> &nbsp;  ${product.vendor.fullname }</li>
                <li class="list-group-item border-0 ps-0 text-sm"><strong
								class="text-dark">Phone:</strong> &nbsp; ${product.vendor.phone }</li>
                <li class="list-group-item border-0 ps-0 text-sm"><strong
								class="text-dark">Email:</strong> &nbsp; ${product.vendor.gmail }</li>
                <li class="list-group-item border-0 ps-0 pb-0">
                  <strong class="text-dark text-sm">Social:</strong> &nbsp;
                  <a
								class="btn btn-facebook btn-simple mb-0 ps-1 pe-2 py-0"
								href="javascript:;">
                    <i class="fab fa-facebook fa-lg"></i>
                  </a>
                  <a
								class="btn btn-twitter btn-simple mb-0 ps-1 pe-2 py-0"
								href="javascript:;">
                    <i class="fab fa-twitter fa-lg"></i>
                  </a>
                  <a
								class="btn btn-instagram btn-simple mb-0 ps-1 pe-2 py-0"
								href="javascript:;">
                    <i class="fab fa-instagram fa-lg"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-12 col-xl-4">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <div class="row">
                <div class="col-md-8 d-flex align-items-center">
                  <h6 class="mb-0">Buyer</h6>
                </div>
                <div class="col-md-4 text-end"> 
                    <i class="fas fa-user-edit text-secondary text-sm"
									data-bs-toggle="tooltip" data-bs-placement="top"
									title="Profile"></i>
                </div>
              </div>
            </div>
            <c:if test="${product.orders != null }">
               <div class="position-relative" style="padding: 2%;">
                      <a class="d-block shadow-xl border-radius-xl">
                        <img
								src="${pageContext.request.contextPath }/resources/assets/admin/img/home-decor-1.jpg"
								alt="img-blur-shadow" class="img-fluid shadow border-radius-xl">
                      </a>
                    </div>
            <div class="card-body">
              <ul class="list-group">
                <li class="list-group-item border-0 ps-0 pt-0 text-sm"><strong
									class="text-dark">Full Name:</strong> &nbsp; ${product.orders.account.fullname }</li>
                <li class="list-group-item border-0 ps-0 text-sm"><strong
									class="text-dark">Phone:</strong> &nbsp; ${product.orders.account.phone }</li>
                <li class="list-group-item border-0 ps-0 text-sm"><strong
									class="text-dark">Email:</strong> &nbsp; ${product.orders.account.gmail }</li>
				<li class="list-group-item border-0 ps-0 text-sm"><strong
									class="text-dark">Price:</strong> &nbsp; ${product.orders.total }</li>
                <li class="list-group-item border-0 ps-0 text-sm"><strong
									class="text-dark">Date:</strong> &nbsp; <fmt:formatDate
										value="${product.orders.successDate}" type="date"
										pattern="dd-MM-yyyy" /></li>
                
                <li class="list-group-item border-0 ps-0 pb-0">
                  <strong class="text-dark text-sm">Social:</strong> &nbsp;
                  <a
									class="btn btn-facebook btn-simple mb-0 ps-1 pe-2 py-0"
									href="javascript:;">
                    <i class="fab fa-facebook fa-lg"></i>
                  </a>
                  <a
									class="btn btn-twitter btn-simple mb-0 ps-1 pe-2 py-0"
									href="javascript:;">
                    <i class="fab fa-twitter fa-lg"></i>
                  </a>
                  <a
									class="btn btn-instagram btn-simple mb-0 ps-1 pe-2 py-0"
									href="javascript:;">
                    <i class="fab fa-instagram fa-lg"></i>
                  </a>
                </li>
              </ul>
              </div>
					</c:if>
          </div>
        </div>
	</div>
  <div class="modal fade" id="modelCancelProduct" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Feedback</h5>
      </div>
      <s:form method="post" modelAttribute="sendMailInput"
						action="${pageContext.request.contextPath }/admin/product/cancel/${product.id}">
      <div class="modal-body">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Email</label>
				    <s:input path="toEmail" class="form-control" laceholder="email"
									readonly="readonly" />
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Subject</label>
				      <s:input path="subject" class="form-control"
									laceholder="subject" required="required"/>
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Content</label>
				    <textarea  name="content" class="form-control"
									id="content" rows="3" placeholder="content" required="required">
									</textarea>
				  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Send</button>
      </div>
      </s:form>
    </div>
  </div>
</div>
	</jsp:attribute>
</mt:layout>
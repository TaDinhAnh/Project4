<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<mt:layout title="order">
	<jsp:attribute name="content">
  <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">List Orders</h1>
              <span class="color-text-a">${sessionScope.fullname }</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="news-grid grid">
      <div class="container">
        <div class="row">
<table class="table align-items-center mb-0" id="tableOrders">
                  <thead>
                    <tr>
                      <th
									class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product</th>
                      <th
									class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Date
								
								
								
								
								
								
								<th
									class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Price						  
								
								
								
								
								
								
								
								<th
									class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Paid</th>
                      <th
									class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                      
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${orders }" var="item">
                  <tr>
                  	<td class="align-middle" hidden>
                        <span
										class="text-secondary text-xs font-weight-bold">${item.id }</span>
								
                      </td>
                  <td class="align-middle">
                  
								
                        <span
										class="text-secondary text-xs font-weight-bold">${item.productOutput.name }</span>
                      </td>
                       <td class="align-middle" hidden>
                        <span
										class="text-secondary text-xs font-weight-bold">${item.address }</span>
                      </td>
                      <td class="align-middle ">
                        <span
										class="text-secondary text-xs font-weight-bold"><fmt:formatDate
												value="${item.successDate}" type="date" pattern="dd-MM-yyyy" /></span>
                      </td>
                      <td class="align-middle ">
                        <span
										class="text-secondary text-xs font-weight-bold">${item.total } $</span>
                      </td>
                      <td class="align-middle text-center">
                        <span
										class="text-secondary text-xs font-weight-bold">${item.piad } $</span>
                      </td>
                      <td class="align-middle text-center">
                        <span
										class="text-secondary text-xs font-weight-bold">${item.status }</span>
                      </td>
                      <td>
                      <c:if test="${item.status == 'wait' }">
                    	<button type="button"
												class="btn btn-outline-primary btn-sm mb-0 btnPayment"
												data-toggle="modal" data-target="#modalPayment">Payment</button>                        </c:if>
                        </td>
                      </tr>
                  </c:forEach>
                  </tbody>
                </table>
          </div>
        
        <div class="row">
          <div class="col-sm-12">
           
          </div>
        </div>
      </div>
    </section>
    
    <!-- modal payment -->
     		<div class="modal fade" id="modalPayment" tabindex="-1"
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
				<div class="col-md-12 d-flex">
					<div
								class="modal-body p-4 p-md-5 d-flex align-items-center color-1">
						<div class="text w-100 py-3">
							<h3 class="mb-4 heading">Payment</h3>
							<form class="contact-form" method="post"
										action="${pageContext.request.contextPath }/paypal/pay">
							 <input type="email" class="form-control" id="idOrders"
											readonly="readonly" name="idOrders" hidden>
							 <div class="form-group">
							    <label for="exampleInputEmail1">Product</label>
							    <input type="email" class="form-control" id="namePro"
												readonly="readonly">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Date</label>
							    <input type="email" class="form-control" id="date"
												readonly="readonly">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Total</label>
							    <input type="email" class="form-control" id="total"
												readonly="readonly">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">Paid</label>
							    <input type="email" class="form-control" id="paid"
												readonly="readonly" name="price">
							  </div>
							    <div class="form-group">
							    <label for="exampleInputEmail1">Address</label>
							    <input type="text" class="form-control" id="address" name="address">
							  </div>
								
								<div class="form-group">
									<button type="submit"
												class="form-control btn btn-secondary rounded submit px-3">Payment</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

    </jsp:attribute>
</mt:layout>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<mt:layout title="">
	<jsp:attribute name="content">
	 <section class="section-testimonials section-t8 nav-arrow-a">
			
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">List auctionproducts</h2>
              </div>                        
              </div>
          </div>
        </div>
         <div class="row">
        <div class="col-12">
          <div class="card mb-4">
           
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0"
										id="tableAuction">
                  <thead>
                    <tr>
                      <th
													class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Product Name </th>
					  <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Category</th>
                                            <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Price Min</th>
                        <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Start Hour</th>
													 <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">End Hour</th>
													 <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">EventDate</th>
													 <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="ap" items="${auctionproducts }">
                  <input type="hidden" value="${ap.auctionOutput.id }" id="auid">
                   <input type="hidden" value="${ap.productOutput.id }" id="pid">
                  <input type="hidden" value="${ap.auctionOutput.id }"
													id="auid">
                   <input type="hidden" value="${ap.productOutput.id }"
													id="pid">
                    <tr>
                      <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0  "> ${ap.productOutput.name } </p>
                      </td>
                       <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0  "> ${ap.productOutput.category } </p>
                      </td>
                       <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0  "> ${ap.productOutput.priceMin }  $</p>
                      </td>
                     
                            <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0">  ${ap.auctionOutput.hourStart } </p>
                      </td>
                            <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0"> ${ap.auctionOutput.hourEnd } </p>
                      </td>
                       <td class="align-middle text-center">
                       <p class="text-xs font-weight-bold mb-0">
															<d:formatDate value="${ap.auctionOutput.eventdate }" var="dated"
																pattern="dd/MM/yyy" /> ${dated } </p> 
															<d:formatDate value="${ap.auctionOutput.eventdate }"
																var="dated" pattern="dd/MM/yyy" /> ${dated } </p> 
                      </td>
                        <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0"> ${ap.productOutput.status } </p>
                      </td>
                     
                    </tr>
                    </c:forEach>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>	

    </div>
		</section>
	<div class="modal fade" id="modalCreateInfo" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content" style="width: 65%">
			<div class="modal-header">
				<button type="button"
							class="close d-flex align-items-center justify-content-center"
							data-dismiss="modal" aria-label="Close" value="" id="closeModal">
					<span aria-hidden="true" class="ion-ios-close"></span>
				</button>
			</div>
			<div class="row ">
				<div class="d-flex">
					<div
								class="modal-body p-4 p-md-5 d-flex align-items-center color-1">
						<div class="text w-100 py-3">
							<h3 class="mb-4 heading">Create Auction</h3>
							<form class="contact-form">
								<div class="form-group mb-3">
								<p> Hour Start</p>
									<input value="00:00:00" type="time" class="form-control"
												id="hstart">
												
								</div>							
								<div class="form-group mb-3">
								<p> Hour End</p>
									<input value="00:00:00" type="time" class="form-control"
												id="hend">
												
								</div>
								<div class="form-group">
									<p> Event date</p>
									<input type="text" class="form-control"
												placeholder="dd/MM/yyyy" id="date">
								</div>
								<div class="form-group">
									<p>Description</p>
								  <input type="text" class="form-control" id="description">
									
								</div>
								<div class="form-group">
									<button type="button"
												class="form-control btn btn-secondary rounded submit px-3"
												id="createAuction">Save Information</button>
								</div>
								
							</form>
						</div>
					</div>
				</div>				
			</div>
		</div>
	</div>	
</div>	
   <input type="hidden" value="${sessionScope.accountid }"
			id="accountid">
   	<div class="modal fade" id="updateNewAuction" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content" style="width: 65%">
			<div class="modal-header">
				<button type="button"
							class="close d-flex align-items-center justify-content-center"
							data-dismiss="modal" aria-label="Close" value="" id="closeModal">
					<span aria-hidden="true" class="ion-ios-close"></span>
				</button>
			</div>
			<div class="row ">
				<div class="d-flex">
					<div
								class="modal-body p-4 p-md-5 d-flex align-items-center color-1">
						<div class="text w-100 py-3">
							<h3 class="mb-4 heading">Update AuctionProduct</h3>
							<form class="contact-form">
								<div class="form-group mb-3">
								<p> Hour Start</p>
									<input type="time" class="form-control" id="updateHstart">
												
								</div>							
								<div class="form-group mb-3">
								<p> Hour End</p>
									<input type="time" class="form-control" id="updateHend">
												
								</div>
								<div class="form-group">
									<p> Event date</p>
									<input type="text" class="form-control"
												placeholder="dd/MM/yyyy" id="updateDate">
								</div>
								<div class="form-group">
									<p>Description</p>
								  <input type="text" class="form-control" id="updateDescription">
									
								</div>
								<div class="form-group">
									<button type="button"
												class="form-control btn btn-secondary rounded submit px-3"
												id="updateAuction">Save Information</button>
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
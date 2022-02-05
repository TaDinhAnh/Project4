<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/assets/vendor/js/auction.js"></script>

<mt:layout title="Auction Vendor">
	<jsp:attribute name="content">
	 <section class="section-testimonials section-t8 nav-arrow-a">
			
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">List auctions</h2>
              </div>
                          <div class="title-link">
                <button type="button" class="btn btn-light"
									style="border: none; outline: 0 !important; color: #afa939;"
									data-toggle="modal" data-target="#modalCreateInfo">
										Create Auction
							</button>										                
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
										id="tableNAuction">
                  <thead>
                    <tr>
                      <th
													class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Auction Description</th>
					  <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Open Date</th>
                                            <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Hour Start</th>
                        <th
													class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Hour End</th>
                      <th class="text-secondary opacity-7"></th>
                       
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="auction" items="${auctions }">        
                    <tr>
                      <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0  "> ${auction.description } </p>
                      </td>
                      <td class="align-middle text-center">
                       <p class="text-xs font-weight-bold mb-0">
															<d:formatDate value="${auction.eventdate }" var="dated"
																pattern="dd/MM/yyy" /> ${dated } </p> 
                      </td>
                            <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0">  ${auction.hourStart } </p>
                      </td>
                            <td class="align-middle text-center">
                        <p class="text-xs font-weight-bold mb-0"> ${auction.hourEnd } </p>
                      </td>
                      <td class="align-middle text-center text-sm">
     
                        <a onclick="return confirm('Are you sure?');"
														href="${pageContext.request.contextPath }/customer/view/auction/delete?id=${auction.id}">Delete</a>    
								<button class="btn btn-link text-secondary mb-0 upAuction"
															data-toggle="modal" data-target="#updateNewAuction">
                         Update
                        </button>	
                        <button
															class="btn btn-link text-secondary mb-0 upAuction"
															data-toggle="modal" data-target="#createAuctionProduct">
                         Create AuctionProduct
                        </button>									
                      </td>
                       <td>
                       <span hidden>${auction.id }</span>                      
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
												placeholder="dd/MM/yyyy" id="createdate">
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
							<h3 class="mb-4 heading">Update Auction</h3>
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
									<input id="updateId" hidden>
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
   
      	<div class="modal fade" id="createAuctionProduct" tabindex="-1"
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
							<h3 class="mb-4 heading">Create Auction Product</h3>
							<form class="contact-form" id="createAuctionProduct">
								<div class="form-group mb-3">
								<p>Product Name</p>
									<select class="form-control" id="currentPro">
				      <option value="0">Option</option>
				      <c:forEach items="${productOutputs }" var="product">
				      <option value="${product.id}">${product.name}</option>
				      </c:forEach>
				    </select>
												
								</div>							
								
								<div class="form-group">
									<button type="submit"
												class="form-control btn btn-secondary rounded submit px-3">Create AuctionProduct</button>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/assets/vendor/js/auction.js"></script>
<script>
	$(document).ready(function() {
		$("#tableAuction").on('click', '.upAuction', function() {
			var currentRow = $(this).closest("tr");
			var des = currentRow.find("td:eq(1)").text().trim();
			var evdate = currentRow.find("td:eq(2)").text().trim();
			var hs = currentRow.find("td:eq(3)").text().trim();
			var he = currentRow.find("td:eq(4)").text().trim();
			$("#updateDate").val(evdate);
			$("#updateDescription").val(des);
			$("#updateHstart").val(hs);
			$("#updateHend").val(he);
			
		});
		
		$("#updateAuction").click(function() {
			var id = $("#id").val();
			var accountid = $("#accountid").val();
			var start = $("#updateHstart").val();
			var end = $("#updateHend").val();
			var date = $("#updateDate").val();
			var description = $("#updateDescription").val();
			if (start === "") {
				alert("Please enter start time!");
				return;
			} else if (end === "") {
				alert("Please enter end time !");
				return;
			} else if (date === "") {
				alert("Please enter date !");
				return;
			} else if (description === "") {
				alert("Please enter description !");
				return;
			}
			$.ajax({
				type: "PUT",
				url: "http://localhost:9799/api/auction/" +id,
				contentType: "application/json; charset=utf-8",
				data: JSON
					.stringify({
						"vendorId": accountid,
						"hourStart": start,
						"hourEnd": end,
						"eventdate": date,
						"description": description,
					}),
				dataType: "json",
				error: function(xhr) {
					if (xhr.status === 401) {
						window.location.href = "http://localhost:8088/account/login";
					} else {
						window.location.href = "http://localhost:8088/error/400page";
					}
				},
				success: function() {
					window.location.href = "http://localhost:8088/customer/view/auction/vendor";
				},
			});
		});
		$("#createAuctionProduct").click(function() {
			var id = $("#id").val();
			var productid = $('#presentPro').find(":selected").val();
			$.ajax({
				type: "POST",
				url: "http://localhost:9799/api/auctionProduct",
				contentType: "application/json; charset=utf-8",
				data: JSON
					.stringify({
						"auctionid": id,
						"proId": productid,
					}),
				dataType: "json",
				error: function(xhr) {
					if (xhr.status === 401) {
						window.location.href = "http://localhost:8088/account/login";
					} else {
						window.location.href = "http://localhost:8088/error/400page";
					}
				},
				success: function() {
					window.location.href = "http://localhost:8088/customer/view/auction/vendor";
				},
			});
		});
		
	});
</script>
<mt:layout title="">
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
										id="tableAuction">
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

                  <input type="hidden" value="${auction.id }" id="id">
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
								<button
															class="btn btn-link text-secondary mb-0 upAuction"
															data-toggle="modal" data-target="#updateNewAuction">
                         Update
                        </button>	
                        <button
															class="btn btn-link text-secondary mb-0 upAuction"
															data-toggle="modal" data-target="#createAuctionProduct">
                         Create AuctionProduct
                        </button>									
                      </td>
                       <td class="align-middle">
                        
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
							<form class="contact-form">
								<div class="form-group mb-3">
								<p>Product Name</p>
									<select class="form-control" id="presentPro">
				      <option value="0">Option</option>
				      <c:forEach items="${productOutputs }" var="product">
				      <option value="${product.id}">${product.name}</option>
				      </c:forEach>
				    </select>
												
								</div>							
								
								<div class="form-group">
									<button type="button"
												class="form-control btn btn-secondary rounded submit px-3"
												id="createAuctionProduct">Create AuctionProduct</button>
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
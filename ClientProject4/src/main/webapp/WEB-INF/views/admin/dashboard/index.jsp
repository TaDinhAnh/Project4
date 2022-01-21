<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="Dashboard">
	<jsp:attribute name="content">
      <div class="row">
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p
										class="text-sm mb-0 text-capitalize font-weight-bold">Today's Money</p>
                    <h5 class="font-weight-bolder mb-0">
                      $53,000
                      <span
											class="text-success text-sm font-weight-bolder">+55%</span>
                    </h5>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div
									class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                    <i class="ni ni-money-coins text-lg opacity-10"
										aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p
										class="text-sm mb-0 text-capitalize font-weight-bold">Today's Users</p>
                    <h5 class="font-weight-bolder mb-0">
                      2,300
                      <span
											class="text-success text-sm font-weight-bolder">+3%</span>
                    </h5>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div
									class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                    <i class="ni ni-world text-lg opacity-10"
										aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-xl-0 mb-4">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p
										class="text-sm mb-0 text-capitalize font-weight-bold">New Clients</p>
                    <h5 class="font-weight-bolder mb-0">
                      +3,462
                      <span
											class="text-danger text-sm font-weight-bolder">-2%</span>
                    </h5>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div
									class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                    <i class="ni ni-paper-diploma text-lg opacity-10"
										aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-sm-6">
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-8">
                  <div class="numbers">
                    <p
										class="text-sm mb-0 text-capitalize font-weight-bold">Sales</p>
                    <h5 class="font-weight-bolder mb-0">
                      $103,430
                      <span
											class="text-success text-sm font-weight-bolder">+5%</span>
                    </h5>
                  </div>
                </div>
                <div class="col-4 text-end">
                  <div
									class="icon icon-shape bg-gradient-primary shadow text-center border-radius-md">
                    <i class="ni ni-cart text-lg opacity-10"
										aria-hidden="true"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    
        <div class="col-lg-8" style="padding-top: 2%;">
        	<div class=row>
        	<c:forEach items="${rs.feedBackOutputs }" var="item">
        		<div class="col-md-3">
        			<div class="card">
                    <div class="card-header mx-4 p-3 text-center">
                      <div
										class="icon icon-shape icon-lg bg-gradient-primary shadow text-center border-radius-lg">
                        <i class="fas fa-landmark opacity-10"></i>
                      </div>
                    </div>
                    <div class="card-body pt-0 p-3 text-center">
                      <h6 class="text-center mb-0">${item.gmail }</h6>
                      <span class="text-xs">${item.content }</span>
                      <hr class="horizontal dark my-3">
                       <div class="col-5 text-end"
										style="margin-left: 20%;">
                 			<button class="btn btn-outline-primary btn-sm mb-0">Reply</button>
               			</div>
                    </div>
                  </div>
                 </div>		
                 </c:forEach>					                 
             </div>    
        </div>
        <div class="col-lg-4" style="padding-top: 2%;">
          <div class="card h-100">
            <div class="card-header pb-0 p-3">
              <div class="row">
                <div class="col-6 d-flex align-items-center">
                  <h6 class="mb-0">Invoices</h6>
                </div>
                <div class="col-6 text-end">
                  <button class="btn btn-outline-primary btn-sm mb-0">View All</button>
                </div>
              </div>
            </div>
            <div class="card-body p-3 pb-0">
              <ul class="list-group">
                <c:forEach items="${rs.ordersOutputs}" var="item">
                <li
									class="list-group-item border-0 d-flex justify-content-between ps-0 mb-2 border-radius-lg">
                  <div class="d-flex flex-column">
                    <h6 class="mb-1 text-dark font-weight-bold text-sm">
											<fmt:formatDate value="${item.successDate}" type="date"
												pattern="dd-MMM-yyyy" />
										</h6>
                    <span class="text-xs">${item.account.gmail}</span>
                  </div>
                  <div class="d-flex align-items-center text-sm">
                    $ ${item.total}
                    <button
											class="btn btn-link text-dark text-sm mb-0 px-0 ms-4">
													<i class="fas fa-file-pdf text-lg me-1"></i> PDF</button>
                  </div>
                </li>
				</c:forEach>
              </ul>
            </div>
          </div>
        </div>
    
      </div>
      
      <!-- Modal reply feedback -->
      <div class="modal fade" id="modalReply" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Feedback</h5>
      </div>
      <div class="modal-body">
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Email</label>
				    
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Subject</label>
				      
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Content</label>
				    <textarea name="content" class="form-control" id="content"
								rows="3" placeholder="content" required="required">
									</textarea>
				  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Send</button>
      </div>
    </div>
  </div>
</div>
	</jsp:attribute>
</mt:layout>
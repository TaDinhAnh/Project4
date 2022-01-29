<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<mt:layout title="">
	<jsp:attribute name="content">
  <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">List Auction History</h1>
              <span class="color-text-a">${sessionScope.fullname }</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="news-grid grid">
      <div class="container">
        <div class="row">
        <div id="accordion">
        <c:forEach items="${auctions}" var="item">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-link" data-toggle="collapse"
											data-target="#collapseOne${item.id}" aria-expanded="true"
											aria-controls="collapseOne">
         Auction code ${item.id }, Date <fmt:formatDate
												value="${item.eventdate}" type="date" pattern="dd-MM-yyyy" /> 
        </button>
      </h5>
    </div>

    <div id="collapseOne${item.id}" class="collapse"
									aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
		        <ul class="list-group">
		        	<c:forEach items="${item.auctionHistoryOutputs }" var="item2">
					  <li class="list-group-item">You bid on item ${item2.productname } for ${item2.price } on
					  <fmt:formatDate value="${item2.time }" type="date"
														pattern="dd-MM-yyyy" />
					   </li>
					</c:forEach>
				</ul>
      </div>
    </div>
  </div>
 </c:forEach>
 
</div>
          </div>
        
        <div class="row">
          <div class="col-sm-12">
           
          </div>
        </div>
      </div>
    </section>
    </jsp:attribute>
</mt:layout>
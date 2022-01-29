-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>

<mt:layout title="">
	<jsp:attribute name="content">	
		 <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">${productOutput.name }</h1>
              <span class="color-text-a">${productOutput.category }</span>
            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <nav aria-label="breadcrumb"
							class="breadcrumb-box d-flex justify-content-lg-end">
              <ol class="breadcrumb">
          <c:if
									test="${productOutput.status == 'unsold' and productOutput.isAccept == true}">
                <c:if test="${ not empty productlist}">
                <li class="breadcrumb-item">
                  <a
											href="${pageContext.request.contextPath }/customer/view/home">Home</a>
                </li>
                
                </c:if>
                 <c:if test="${empty productlist}">
                <li class="breadcrumb-item">
                  <a
											href="${pageContext.request.contextPath }/customer/view/home">Home</a>
                </li>
                <li class="breadcrumb-item">                								
                </li>
                </c:if>
                </c:if>
                 <c:if
									test="${productOutput.status == 'unsold' and productOutput.isAccept == false}">
                <li class="breadcrumb-item">
                  <a
										href="${pageContext.request.contextPath }/customer/view/home">Home</a>
                </li>
               <li class="breadcrumb-item">
                							<button type="button" class="btn btn-light"
											style="border: none; outline: 0 !important; color: #afa939;"
											data-toggle="modal" data-target="#modalUpdateInfo">
										Update Auction
							</button>              	
                </li>
                </c:if>
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </section>
    <section class="property-single nav-arrow-b">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-8">
            <div id="property-single-carousel" class="swiper">
              <div class="swiper-wrapper">
                <div class="carousel-item-b swiper-slide">
                  <img
										src="${pageContext.request.contextPath }/resources/assets/customer/img/slide-1.jpg"
										alt="">
                </div>             
              </div>
            </div>
            <div class="carousel-pagination"></div>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-12">

            <div class="row justify-content-between">
              <div class="col-md-5 col-lg-4">
                <div
									class="property-price d-flex justify-content-center foo">
                  <div class="card-header-c d-flex">
                    <div class="card-box-ico">
                      <span class="bi bi-cash">$</span>
                    </div>
                    <div class="card-title-c align-self-center">
                      <h5 class="title-c">${productOutput.priceMin }</h5>
                    </div>
                  </div>
                </div>
              
              </div>
              <div class="col-md-7 col-lg-7 section-md-t3">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="title-box-d">
                      <h3 class="title-d">Property Description</h3>
                    </div>
                  </div>
                </div>
                <div class="property-description">
                  <p class="description color-text-a">
                    ${productOutput.description }
                  </p>
               
                </div>

              </div>
            </div>
          </div>
        

          <div class="col-md-12">
            <div class="row section-t3">
              <div class="col-sm-12">
                <div class="title-box-d">
                  <h3 class="title-d">Details</h3>
                </div>
              </div>
            </div>
            <div class="row">
            <c:if test="${ not empty productlist}">
            <c:if
									test="${productlist.productOutput.isAccept == true and productlist.productOutput.status == 'sold' }">
              <div class="col-md-6 col-lg-4">
                <img
											src="${pageContext.request.contextPath }/resources/assets/customer/img/agent-4.jpg"
											alt="" class="img-fluid">
              </div>
              <div class="col-md-6 col-lg-8">
                <div class="property-agent">
                  <h4 class="title-agent" style="color: #20c997">  ${orders.account.fullname }</h4>
           
                  <ul class="list-unstyled">
                    <li class="d-flex justify-content-between">
                      <strong>Address:</strong>
                      <span class="color-text-a"> ${orders.address }</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>The amount paid:</strong>
                      <span class="color-text-a"> ${orders.piad } $</span>
                    </li>
                    <li class="d-flex justify-content-between">
                    <strong> Successful auction day:</strong>
                      <span class="color-text-a"> 
                      <d:formatDate value="${orders.successDate }"
															var="date" pattern="dd/MM/yyyyy" />${date } 
                      </span>
                    </li>  
                     <li class="d-flex justify-content-between">
                      <strong>Gmail:</strong>
                      <span class="color-text-a"> ${orders.account.gmail }</span>
                    </li>               
                  </ul>                
                </div>
              </div>  
              </c:if>
              </c:if>  
               <c:if test="${empty productlist}"> 
               </c:if>                 
            </div>
          </div>
        </div>
      </div>
    </section>
    	
<input type="hidden" value="${productOutput.id }">
	</jsp:attribute>
</mt:layout>
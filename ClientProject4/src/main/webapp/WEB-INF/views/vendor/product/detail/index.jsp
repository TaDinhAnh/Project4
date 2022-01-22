<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
              <h1 class="title-single">${productlist.productOutput.name }</h1>
              <span class="color-text-a">${productlist.productOutput.category }</span>
            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <nav aria-label="breadcrumb"
							class="breadcrumb-box d-flex justify-content-lg-end">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="index.html">Home</a>
                </li>
                <li class="breadcrumb-item">
                  <a href="property-grid.html">Properties</a>
                </li>
                
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
            <div
							class="carousel-pagination"></div>
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
                      <h5 class="title-c">${productlist.productOutput.priceMin }</h5>
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
                    ${productlist.productOutput.description }
                  </p>
               
                </div>

              </div>
            </div>
          </div>
        
          <div class="col-md-12">
            <div class="row section-t3">
              <div class="col-sm-12">
                <div class="title-box-d">
                  <h3 class="title-d">Auction details</h3>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 col-lg-4">
                <img
									src="${pageContext.request.contextPath }/resources/assets/customer/img/agent-4.jpg"
									alt="" class="img-fluid">
              </div>
              <div class="col-md-6 col-lg-8">
                <div class="property-agent">
                  <h4 class="title-agent">${productlist.auctionOutput.fullname }</h4>
                  <p class="color-text-a">
                   ${productlist.auctionOutput.description }
                  </p>
                  <ul class="list-unstyled">
                    <li class="d-flex justify-content-between">
                      <strong>HourStart:</strong>
                      <span class="color-text-a"> ${productlist.auctionOutput.hourStart }</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>HourEnd:</strong>
                      <span class="color-text-a"> ${productlist.auctionOutput.hourEnd }</span>
                    </li>
                    <li class="d-flex justify-content-between">
                      <strong>The day it takes place:</strong>
                      <span class="color-text-a">
                      <d:formatDate value="${productlist.auctionOutput.eventdate }" var="date" pattern="dd/MM/yyyyy"/>${date }
                      </span>
                    </li>                 
                  </ul>                
                </div>
              </div>                      
            </div>
          </div>
        </div>
      </div>
    </section>
	</jsp:attribute>
</mt:layout>
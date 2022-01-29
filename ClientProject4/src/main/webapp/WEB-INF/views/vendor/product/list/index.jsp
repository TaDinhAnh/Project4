<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<mt:layout title="">
	<jsp:attribute name="content">	
<section class="section-property section-t8">
 <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single" style="text-align: center">Products</h1>
            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <nav aria-label="breadcrumb"
							class="breadcrumb-box d-flex justify-content-lg-end">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                 <button type="button" class="btn btn-light"
										style="border: none; outline: 0 !important; color: #afa939;"
										data-toggle="modal" data-target="#createProduct">
										Create  Product
							</button>           
                </li>              
              </ol>
            </nav>
          </div>
        </div>
      </div> 
	  <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">List of unsold products</h2>
              </div>           
            </div>
          </div>
        </div>
        <div id="news-carousel" class="swiper">
          <div class="swiper-wrapper">
		                <c:forEach var="productunSold"
							items="${productOutputunSold }">
            <div class="carousel-item-c swiper-slide">
              <div class="card-box-b card-shadow news-box">
                <div class="img-box-b">
                  <img
											src="${pageContext.request.contextPath }/resources/assets/customer/img/post-2.jpg"
											alt="" class="img-b img-fluid">
                </div>
                <div class="card-overlay">
                  <div class="card-header-b">
                    <div class="card-category-b">
                      <a
													href="${pageContext.request.contextPath }/vendor/product/detail?id=${productunSold.id}"
													class="category-b">${productunSold.category}</a>
                    </div>
                    <div class="card-title-b">
                      <h2 class="title-2">
                        <a href="blog-single.html">${productunSold.name}</a>
                      </h2>
                    </div>
                    <div class="card-date">
                      <span class="date-b">${productunSold.priceMin}</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
           </c:forEach>
          </div>
        </div>
        <div class="news-carousel-pagination carousel-pagination"></div>     
      </div>	
	          <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">List of products sold</h2>
              </div>            
            </div>
          </div>
        </div>      
        <div id="property-carousel" class="swiper">                      
          <div class="swiper-wrapper">       
		                <c:forEach var="productSold"
							items="${productOutputSold }">
                      		
            <div class="carousel-item-b swiper-slide">
              <div class="card-box-a card-shadow">          
               <div>
                <div class="img-box-a">
                  <img
												src="${pageContext.request.contextPath }/resources/assets/customer/img/testimonial-1.jpg"
												alt="" class="img-a img-fluid">
												                </div>			
						</div>			
                <div class="card-overlay">
                  <div class="card-overlay-a-content">
                    <div class="card-header-a">
                      <h2 class="card-title-a">
                          <br /> ${productSold.name }
                      </h2>
                    </div>
                    <div class="card-body-a">
                      <div class="price-box d-flex">
                        <span class="price-a">Min Price: |  ${productSold.priceMin}</span>
                      </div>
                       <div class="price-box d-flex">
                        <span class="price-a">Category: |  ${productSold.category}</span>
                      </div>
                      <a
													href="${pageContext.request.contextPath }/vendor/product/detail?id=${productSold.id}"
													class="link-a">Click here to view
                        <span class="bi bi-chevron-right"></span>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>                                                                             </c:forEach>
             </div>           
        </div>
        <div class="propery-carousel-pagination carousel-pagination"></div>   
			</div> 	    
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">Product list waiting for approval</h2>
              </div>
              
            </div>
          </div>
        </div>
        <div class="row">
        <c:forEach var="product" items="${productOutputNotAccept }">
          <div class="col-md-4">
            <div class="card-box-d">
              <div class="card-img-d">
                <img
										src="${pageContext.request.contextPath }/resources/assets/customer/img/testimonial-1.jpg"
										alt="" class="img-d img-fluid">
              </div>
              <div class="card-overlay card-overlay-hover">
                <div class="card-header-d">
                  <div class="card-title-d align-self-center">
                    <h3 class="title-d">
                      <a href="agent-single.html" class="link-two">${product.name }</a>
                    </h3>
                  </div>
                </div>
                <div class="card-body-d">
                  <p class="content-d color-text-a">
                   ${product.category }
                  </p>
                  <div class="info-agents color-a">
                    <p>
                      <strong>Min price: </strong> ${product.priceMin }
                    </p>
                    <p>
                      <strong>Description: </strong> ${product.description }
                    </p>
                  </div>
                </div>
                <div class="card-footer-d">
                  <div
											class="socials-footer d-flex justify-content-center">
                    <ul class="list-inline">
                      <li class="list-inline-item">
                        <a
													href="${pageContext.request.contextPath }/vendor/product/detail?id=${product.id}"
													class="link-one">
                          <i class="bi bi-facebook" aria-hidden="true"></i>
                        </a>
                      </li>                 
                    </ul>
                  </div>
                </div>
              </div>    
            </div>
          </div>
        </c:forEach> 
        </div>
      </div>
		</section>
	</jsp:attribute>
</mt:layout>
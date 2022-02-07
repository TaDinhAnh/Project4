<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="">
	<jsp:attribute name="content">
	<div class="intro intro-carousel swiper position-relative">
		<div class="swiper-wrapper">
			      	  <c:forEach items="${products }" var="product">
		
			<div class="swiper-slide carousel-item-a intro-item bg-image"
						style="background-image: url(${product.image})">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-8">
									<div class="intro-body">
										<p class="intro-title-top">
											${product.category} <br>
										</p>
										<h1 class="intro-title mb-4 ">
											<span class="color-b">Name: </span>${product.name}
										</h1>
										<p class="intro-subtitle intro-price">
											<a href="#"><span class="price-a">rent |  ${product.priceMin}</span></a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
					        </c:forEach>			
		</div>
		<div class="swiper-pagination"></div>		        	
	</div>
	    <section class="section-property section-t8">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">Latest Auctions</h2>
              </div>
              <div class="title-link">
                <a									href="${pageContext.request.contextPath }/customer/view/auction/happenning">All Property
                  <span class="bi bi-chevron-right"></span>
                </a>
              </div>
            </div>
          </div>
        </div>       
        <div id="property-carousel" class="swiper">                    
          <div class="swiper-wrapper">       
		                <c:forEach var="auction" items="${auctions }">                     		
            <div class="carousel-item-b swiper-slide">
              <div class="card-box-a card-shadow">          
               <div>
                <div class="img-box-a">
                  <img												src="${auction.productOutputs[0].image}"
												alt="" class="img-a img-fluid">
												                </div>
						</div>			
                <div class="card-overlay">
                  <div class="card-overlay-a-content">
                    <div class="card-header-a">
                      <h2 class="card-title-a">
                          <br /> ${auction.fullname }
                      </h2>
                    </div>
                    <div class="card-body-a">
                      <div class="price-box d-flex">
                        <span class="price-a">hourStart |  ${auction.hourStart }</span>
                      </div>
                      <a
													href="${pageContext.request.contextPath }/customer/view/auction/start/${auction.id}"
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
                <h2 class="title-a">List Product</h2>
              </div>
             
            </div>
          </div>
        </div>
        <div class="row">
        <c:forEach var="product" items="${productlist }">
          <div class="col-md-4" style="margin-top: 15px">
            <div class="card-box-d">
              <div class="card-img-d">
                <img
										src="${product.image}"
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
               
              </div>    
            </div>
          </div>
        </c:forEach> 
        </div>
      </div>
    </section>
    </jsp:attribute>
</mt:layout>
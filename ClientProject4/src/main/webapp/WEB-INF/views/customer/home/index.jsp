<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="">
	<jsp:attribute name="content">
	<div class="intro intro-carousel swiper position-relative">
		<div class="swiper-wrapper">
			<div class="swiper-slide carousel-item-a intro-item bg-image"
					style="background-image: url(${pageContext.request.contextPath }/resources/assets/customer/img/slide-1.jpg)">
				<div class="overlay overlay-a"></div>
				<div class="intro-content display-table">
					<div class="table-cell">
						<div class="container">
							<div class="row">
								<div class="col-lg-8">
									<div class="intro-body">
										<p class="intro-title-top">
											Doral, Florida <br> 78345
										</p>
										<h1 class="intro-title mb-4 ">
											<span class="color-b">204 </span> Mount <br> Olive Road
											Two
										</h1>
										<p class="intro-subtitle intro-price">
											<a href="#"><span class="price-a">rent | $ 12.000</span></a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		<div class="swiper-pagination"></div>
	</div>
	    <section class="section-property section-t8">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="title-wrap d-flex justify-content-between">
              <div class="title-box">
                <h2 class="title-a">Latest Properties</h2>
              </div>
              <div class="title-link">
                <a href="property-grid.html">All Property
                  <span class="bi bi-chevron-right"></span>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div id="property-carousel" class="swiper">
          <div class="swiper-wrapper">
        <c:forEach items="${products }" var="product">
        
				
            <div class="carousel-item-b swiper-slide">
              <div class="card-box-a card-shadow">
                <div class="img-box-a">
               
                  <img
											src="${pageContext.request.contextPath }/resources/assets/customer/img/property-6.jpg"
											alt="" class="img-a img-fluid">
										
                </div>
                <div class="card-overlay">
                  <div class="card-overlay-a-content">
                    <div class="card-header-a">
                      <h2 class="card-title-a">
                        <a
														href="${pageContext.request.contextPath }/customer/property">
                          <br /> ${product.name }</a>
                      </h2>
                    </div>
                    <div class="card-body-a">
                      <div class="price-box d-flex">
                        <span class="price-a">rent | $ ${product.priceMin }</span>
                      </div>
                      <a
													href="${pageContext.request.contextPath }/customer/pagePropertySingle"
													class="link-a">Click here to view
                        <span class="bi bi-chevron-right"></span>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        
       
           </c:forEach>
             </div>
        </div>
        <div class="propery-carousel-pagination carousel-pagination"></div>

      </div>
    </section>
    </jsp:attribute>
</mt:layout>
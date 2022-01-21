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
                <h2 class="title-a">List of ongoing auctions</h2>
              </div>
            </div>
          </div>
        </div>
         <div class="swiper">
          <div class="swiper-wrapper">

            <div class="carousel-item-a swiper-slide">
              <div class="testimonials-box">
                <div class="row">
                  <c:forEach var="auction" items="${auctions }">
                  <div class="col-sm-12 col-md-3"
											style="padding-bottom: 2%;">
                    <div class="testimonial-img; card-box-a card-shadow">
                      <img
													src="${pageContext.request.contextPath }/resources/assets/customer/img/testimonial-1.jpg"
													alt="" class="img-a img-fluid">
                    </div>
                  </div>
                  <div class="col-sm-12 col-md-9"
											style="margin-bottom: 2%; background-color: #e9ecef;">
                    <div class="testimonial-ico">
                    </div>
                    <div class="testimonials-content">
                     <a	href="${pageContext.request.contextPath }/customer/auction/detailAuction?id=${auction.id}">
                      <p class="testimonial-text">
                         ${auction.description }
                      </p>
                      </a>
                    </div>
                    <div class="testimonial-author-box">
                      <h5 class="testimonial-author" style="color: red;">
														<d:formatDate value="${auction.eventdate }" var="dated"
														pattern="dd/MM/yyy" />Open date: ${dated }  ${auction.hourStart }</h5>
                    </div>
                  </div>
                  </c:forEach>
              </div>
            </div>
          </div>
        </div>
        <div class="testimonial-carousel-pagination carousel-pagination"></div>
      </div>
    </div>
		</section>	
	</jsp:attribute>
</mt:layout>
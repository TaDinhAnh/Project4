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
              <h1 class="title-single">List Auction History</h1>
              <span class="color-text-a">My Name</span>
            </div>
          </div>
          <div class="col-md-12 col-lg-4">
            <nav aria-label="breadcrumb"
							class="breadcrumb-box d-flex justify-content-lg-end">
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a
									href="${pageContext.request.contextPath }/customer/home">Home</a>
                </li>
                
              </ol>
            </nav>
          </div>
        </div>
      </div>
    </section>
    <section class="news-grid grid">
      <div class="container">
        <div class="row">
        <c:forEach var="auction" items="${auctions }">
          <div class="col-md-4">
            <div class="card-box-b card-shadow news-box">
              <div class="img-box-b">
                <img
										src="${pageContext.request.contextPath }/resources/assets/customer/img/post-1.jpg"
										alt="" class="img-b img-fluid">
              </div>
              <div class="card-overlay">
                <div class="card-header-b">
                  <div class="card-category-b">
                    <a
												href="${pageContext.request.contextPath }/customer/auction/detailAuction?id=${auction.id}"
												class="category-b">Loại sản phẩm</a>
                  </div>
                  <div class="card-title-b">
                    <h2 class="title-2">
                      <a
													href="${pageContext.request.contextPath }/customer/auction/detailAuction">tên
                        <br> Sản phẩm</a>
                    </h2>
                  </div>
                  <div class="card-date">
                    <span class="date-b">ngày giờ đấu giá </span>
                  </div>
                </div>
              </div>
            </div>
          </div>  
           <input type="hidden" value="${auction.id}"> 
         </c:forEach>
          </div>
        
        <div class="row">
          <div class="col-sm-12">
            <nav class="pagination-a">
              <ul class="pagination justify-content-end">
                <li class="page-item disabled">
                  <a class="page-link" href="#" tabindex="-1">
                    <span class="bi bi-chevron-left"></span>
                  </a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item active">
                  <a class="page-link" href="#">2</a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">3</a>
                </li>
                <li class="page-item next">
                  <a class="page-link" href="#">
                    <span class="bi bi-chevron-right"></span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </section>
    </jsp:attribute>
</mt:layout>
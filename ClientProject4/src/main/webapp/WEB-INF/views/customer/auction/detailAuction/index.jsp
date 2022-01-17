<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<mt:layout title="">
	<jsp:attribute name="content">
	  <section class="intro-single">
      <div class="container">
        <div class="row">
          <div class="col-md-12 col-lg-8">
            <div class="title-single-box">
              <h1 class="title-single">${getAuction.productname }</h1>
              <span class="color-text-a">News Single.</span>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="news-single nav-arrow-b">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="news-img-box">
              <img
								src="${pageContext.request.contextPath }/resources/assets/customer/img/slide-3.jpg"
								alt="" class="img-fluid">
            </div>
          </div>
          <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
            <div class="post-information">
              <ul class="list-inline text-center color-a">
                <li class="list-inline-item mr-2">
                  <strong>Author: </strong>
                  <span class="color-text-a">${getAuction.accountname }</span>
                </li>
                <li class="list-inline-item mr-2">
                  <strong>Category: </strong>
                  <span class="color-text-a">${getAuction.category }</span>
                  
                </li>
                <li class="list-inline-item">
                  <strong>Date: </strong>
                  <span class="color-text-a">
                 <d:formatDate value="${getAuction.eventdate }"
											var="dated" pattern="dd/MM/yyy" /> ${dated }            
                 
                  </span>
                </li>
              </ul>
            </div>
            <div class="post-content color-text-a">
              <p class="post-intro">
               ${getAuction.description}
              </p>
             
              <blockquote class="blockquote">
                <p class="mb-4">Starting price : ${getAuction.priceMin}</p>
              </blockquote>
               <p>
                Auction hour Start at : ${getAuction.hourEnd}
              </p>
              <p>
                Auction hour End at : ${getAuction.hourEnd}
              </p>
            </div>

          </div>
            <div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1">
              <div class="post-share">
                 <div class="title-box-d">
                 <div class="row">
                 <div class="col-lg-4">
                  <h5> The highest price at the moment: </h5>
                 </div>
                 <div class="col-lg-8">
                  <h1 class="title-single" style="color: red">${maxPriceATM } $</h1>
                 </div>
                 </div>
                
             
            </div>
               
              </div>
            </div>
          <div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1">
                     
            <div class="title-box-d">
              <h3 class="title-d">Comments (${count })</h3>
            </div>
             <c:forEach var="autionhistory" items="${auctionhistorys }">
          
            <div class="box-comments">
              <ul class="list-comments">
                <li>
                  <div class="comment-avatar">
                    <img
												src="${pageContext.request.contextPath }/resources/assets/customer/img/author-2.jpg"
												alt="">
                  </div>
                  <div class="comment-details">
                    <h4 class="comment-author">${autionhistory.accountname }</h4>
                    <span>${autionhistory.time }</span>
                    <p class="comment-description">
                      ${autionhistory.price } <strong>$</strong> 
                    </p>
                  
                  </div>
                </li>                          
              </ul>                         			            
            </div>
            	</c:forEach>
            <div class="form-comments">
              
              <c:if test="${auction.status == 'happened' }">
                      <input id="textMessage" type="hidden"
									class="form-control" placeholder="Comment *" name="message"
									required></input>                 
              </c:if>
              <c:if test="${auction.status == 'happening' }">  
              <div class="title-box-d">
                <h3 class="title-d"> Enter price:</h3>
              </div>
               <s:form class="form-a" modelAttribute="aucHis"
									method="post"
									action="${pageContext.request.contextPath}/customer/auction/detailAuction/sendPrice?id=${auction.id}">
                <div class="row">
                  <div class="col-md-12 mb-3">
                    <div class="form-group">
                      <label for="textMessage">Ten Nguoi Dang Nhap </label>   
                      <s:input path="price" class="form-control" />           
                       												</div>
                  </div>
                  <div class="col-md-12">
                    <button type="submit" class="btn btn-a">Send</button>
                  </div>
                </div>   
                  </s:form>                 
              </c:if>                    
            </div>
          </div>
        </div>
      </div>
    </section>
	</jsp:attribute>
</mt:layout>
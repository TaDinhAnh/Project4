<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<mt:layout title="">
	<jsp:attribute name="content">
	 <section class="news-single nav-arrow-b">
      <div class="container">
        <div class="row">
          <div class="col-sm-12">
            <div class="news-img-box">
              <img src="assets/img/slide-3.jpg" alt="" class="img-fluid">
            </div>
          </div>
          <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
            <div class="post-information">
              <ul class="list-inline text-center color-a">
                <li class="list-inline-item mr-2">
                  <strong>Author: </strong>
                  <span class="color-text-a">${auctionhistory.productname }</span>
                </li>
                <li class="list-inline-item mr-2">
                  <strong>Category: </strong>
<%--                   <span class="color-text-a">${auctionhistory.category }</span> --%>
                </li>
                <li class="list-inline-item">
                  <strong>Date: </strong>
<%--                   <span class="color-text-a">${auctionhistory.evendate }</span> --%>
                </li>
              </ul>
            </div>
            <div class="post-content color-text-a">
              <p class="post-intro">
                Sed porttitor lectus nibh. Lorem ipsum dolor sit amet, consectetur
                <strong>adipiscing</strong> elit. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui.
                Praesent sapien massa, convallis a pellentesque nec, egestas non nisi.
              </p>
              <p>
                Proin eget tortor risus. Donec sollicitudin molestie malesuada. Cras ultricies ligula sed magna dictum
                porta. Pellentesque
                in ipsum id orci porta dapibus. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet
                dui. Lorem ipsum dolor sit amet.
              </p>
              <p>
                Pellentesque in ipsum id orci porta dapibus. Curabitur non nulla sit amet nisl tempus convallis quis ac
                lectus. Curabitur
                non nulla sit amet nisl tempus convallis quis ac lectus. Proin eget tortor risus. Curabitur non
                nulla sit amet nisl tempus convallis quis ac lectus. Donec rutrum congue leo eget malesuada.
                Quisque velit nisi.
              </p>
              <blockquote class="blockquote">
                <p class="mb-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                <footer class="blockquote-footer">
                  <strong>Albert Vargas</strong>
                  <cite title="Source Title">Author</cite>
                </footer>
              </blockquote>
              <p>
                Donec rutrum congue leo eget malesuada. Curabitur aliquet quam id dui posuere blandit. Vivamus suscipit
                tortor eget felis
                porttitor volutpat. Quisque velit nisi, pretium ut lacinia in, elementum id enim.
              </p>
            </div>
            <div class="post-footer">
              <div class="post-share">
                <span>Share: </span>
                <ul class="list-inline socials">
                  <li class="list-inline-item">
                    <a href="#">
                      <i class="bi bi-facebook" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li class="list-inline-item">
                    <a href="#">
                      <i class="bi bi-twitter" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li class="list-inline-item">
                    <a href="#">
                      <i class="bi bi-instagram" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li class="list-inline-item">
                    <a href="#">
                      <i class="bi bi-linkedin" aria-hidden="true"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-10 offset-md-1 col-lg-10 offset-lg-1">
            <div class="title-box-d">
              <h3 class="title-d">Comments (4)</h3>
            </div>
            <div class="box-comments">
              <ul class="list-comments">
                <li>
                  <div class="comment-avatar">
                    <img src="assets/img/author-2.jpg" alt="">
                  </div>
                  <div class="comment-details">
                    <h4 class="comment-author">Emma Stone</h4>
                    <span>18 Sep 2017</span>
                    <p class="comment-description">
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores reprehenderit, provident cumque
                      ipsam temporibus maiores
                      quae natus libero optio, at qui beatae ducimus placeat debitis voluptates amet corporis.
                    </p>
                    <a href="3">Reply</a>
                  </div>
                </li>
                <li class="comment-children">
                  <div class="comment-avatar">
                    <img src="assets/img/author-1.jpg" alt="">
                  </div>
                  <div class="comment-details">
                    <h4 class="comment-author">Oliver Colmenares</h4>
                    <span>18 Sep 2017</span>
                    <p class="comment-description">
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores reprehenderit, provident cumque
                      ipsam temporibus maiores
                      quae.
                    </p>
                    <a href="3">Reply</a>
                  </div>
                </li>
                <li>
                  <div class="comment-avatar">
                    <img src="assets/img/author-2.jpg" alt="">
                  </div>
                  <div class="comment-details">
                    <h4 class="comment-author">Emma Stone</h4>
                    <span>18 Sep 2017</span>
                    <p class="comment-description">
                      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores reprehenderit, provident cumque
                      ipsam temporibus maiores
                      quae natus libero optio.
                    </p>
                    <a href="3">Reply</a>
                  </div>
                </li>
              </ul>
            </div>
            <div class="form-comments">
              <div class="title-box-d">
                <h3 class="title-d"> Leave a Reply</h3>
              </div>
              <form class="form-a">
                <div class="row">
                  <div class="col-md-12 mb-3">
                    <div class="form-group">
                      <label for="textMessage">Enter message</label>
                      <textarea id="textMessage" class="form-control"
												placeholder="Comment *" name="message" cols="45" rows="8"
												required></textarea>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <button type="submit" class="btn btn-a">Send </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>
	</jsp:attribute>
</mt:layout>
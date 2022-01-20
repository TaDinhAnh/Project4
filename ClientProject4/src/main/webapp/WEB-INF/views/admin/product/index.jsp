<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="Products">
	<jsp:attribute name="content">
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Product table</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table
								class="table align-items-center justify-content-center mb-0">
                  <thead>
                    <tr>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product</th>
					  <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Category</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">PriceMin</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Status</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder text-center opacity-7 ps-2">IsDelete</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder text-center opacity-7 ps-2">Accept</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${products }" var="item">
                    <tr>
                      <td>
                        <div class="d-flex px-2">
                          <div>
                            <img src="${item.image}"
															class="avatar avatar-sm rounded-circle me-2"
															alt="spotify">
                          </div>
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">${item.name}</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-bold mb-0">${item.category }</p>
                      </td>
                      <td>
                        <p class="text-sm font-weight-bold mb-0">$ ${item.priceMin }</p>
                      </td>
                      <td>
                        <span class="text-xs font-weight-bold">${item.status }</span>
                      </td>
                      <td class="align-middle text-center">
                        <span class="text-xs font-weight-bold">${item.isDelete }</span>
                      </td>
                      <td>
                        <c:if test="${!item.isAccept && !item.isDelete}">
                    	<span class="badge badge-sm bg-gradient-success">UnAccept</span>
                        </c:if>
                         </td>
                      <td class="align-middle">
                      <a
												href="${pageContext.request.contextPath }/admin/product/detail/${item.id}"
												class="text-secondary font-weight-bold text-xs">
                        <button class="btn btn-link text-secondary mb-0">
                          <i class="fa fa-ellipsis-v text-xs"></i>
                        </button>
                        
                        </a>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>	
	</jsp:attribute>
</mt:layout>
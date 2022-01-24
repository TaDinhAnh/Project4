<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="Accounts">
	<jsp:attribute name="content">
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Accounts table</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Author</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Function</th>
					  <th
											class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Birthday</th>
                      <th
											class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                      
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${accounts}" var="item">
                    <tr>
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div>
                            <img src="${item.image }"
															class="avatar avatar-sm me-3" alt="user1">
                          </div>
                          <div
														class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${item.fullname }</h6>
                            <p class="text-xs text-secondary mb-0">${item.gmail }</p>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.role }</p>
                      </td>
                       <td class="align-middle text-center">
                        <span
												class="text-secondary text-xs font-weight-bold"><fmt:formatDate
														value="${item.dob}" type="date" pattern="dd-MM-yyyy" /></span>
                      </td>
                      <td class="align-middle text-center text-sm">
                        <span
												class="${item.isDelete ? 'badge badge-sm bg-gradient-secondary':'badge badge-sm bg-gradient-success' }">${item.isDelete ? "inactive" : "active" }</span>
                      </td>
                     
                      <td class="align-middle">
                    	<c:if test="${item.isDelete }">
                        <a href="${pageContext.request.contextPath }/admin/account/del/${item.id}"
														class="text-secondary font-weight-bold text-xs"
														data-toggle="tooltip" data-original-title="Edit user">
                          <span class="badge badge-sm bg-gradient-success">Enable</span>
                        </a>
                        </c:if>
                        <c:if test="${!item.isDelete }">
                        <a href="${pageContext.request.contextPath }/admin/account/del/${item.id}"
														class="text-secondary font-weight-bold text-xs"
														data-toggle="tooltip" data-original-title="Edit user">
                    	<span class="badge badge-sm bg-gradient-secondary">Disable</span>
                         
                        </a>
                        </c:if>
                        
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
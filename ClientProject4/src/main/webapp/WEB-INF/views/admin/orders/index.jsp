<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="Orders">
	<jsp:attribute name="content">
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Invoice table</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table
								class="table align-items-center justify-content-center mb-0">
                  <thead>
                    <tr>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Fullname</th>
					  <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Date</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Total</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Paid</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Status</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${orders }" var="item">
                    <tr>
                    <td>
                        <p class="text-sm font-weight-bold mb-0">${item.account.fullname }</p>
                      </td>
                      <td>
                        <div class="d-flex px-2">
                          <div class="my-auto">
                            <h6 class="mb-0 text-sm">
															<fmt:formatDate value="${item.successDate}" type="date"
																pattern="dd-MM-yyyy" />
														</h6>
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-sm font-weight-bold mb-0">${item.total }$</p>
                      </td>
                      <td>
                        <p class="text-sm font-weight-bold mb-0">${item.piad }$</p>
                      </td>
                      <td>
                        <span class="text-xs font-weight-bold">${item.status }</span>
                      </td>
                     
                      <td class="align-middle">
                        <button class="btn btn-link text-secondary mb-0">
                          <i class="fa fa-ellipsis-v text-xs"></i>
                        </button>
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
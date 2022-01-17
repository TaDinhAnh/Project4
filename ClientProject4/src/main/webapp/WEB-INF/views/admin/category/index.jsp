<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<mt:layout title="Categories">
	<jsp:attribute name="content">
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Categories table</h6>
            </div>
            <div class="col-1 text-end">
            <button type="button"
							class="btn btn-outline-primary btn-sm mb-0" data-toggle="modal"
							data-target="#addCate">Add</button>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th
											class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Id</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Name</th>
                      <th
											class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">PresentName</th>
					  <th
											class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                      
                      
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${categories}" var="item">
                    <tr>
                      <td class="align-middle text-center">
                         <p class="text-xs font-weight-bold mb-0">${item.id }</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.name }</p>
                      </td>
                      <td>
                       <p class="text-xs font-weight-bold mb-0">${item.categoryOutput.name }</p>
                      </td>
                      <td class="align-middle text-center text-sm">
                        <span
												class="${item.isDelete ? 'badge badge-sm bg-gradient-secondary':'badge badge-sm bg-gradient-success' }">${item.isDelete ? "inactive" : "active" }</span>
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
      <div class="modal fade" id="addCate" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Add Category</h5>
      </div>
      <div class="modal-body">
			 <form>
				  <div class="form-group">
				    <label for="exampleFormControlInput1">Name Category</label>
				    <input type="text" class="form-control"
									id="nameCate" placeholder="name" required>
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlSelect1">PresentCategory</label>
				    <select class="form-control" id="presentCate">
				      <option value="0">Option</option>
				      <c:forEach items="${categories }" var="item">
				      <option value="${item.id}">${item.name}</option>
				      </c:forEach>
				    </select>
				  </div>
			</form>  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
        <button type="button" id="saveCate" class="btn btn-primary">Save</button>
      </div>
    </div>
  </div>
</div>
	</jsp:attribute>
</mt:layout>
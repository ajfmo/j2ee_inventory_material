<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="productNewContent">
   <h1 class="page-header">New Product</h1>
   <!-- <form> -->
   <label><b>Product Information</b> </label>
   <div class="row information">
		<div id="col4" class="col-lg-3">
		        <!-- Mã phiếu, ngày -->
		        <table class="table borderless">
		           <tbody>
		              <tr>
		                 <td>
		                 	<img class="img-thumbnail" src="resources/images/1.jpg" alt="some_text"  style="width:128px;height:128px;">
		              	 	<input id="input-4" type="file">
		                 </td>
		              </tr>
		           </tbody>
		        </table>
		     </div>
		<div id="col6" class="col-lg-8">
		   <!-- Thông tin nhập -->
		   <table class="table no-border striped3n table-resize">
		      <tbody>
		         <tr class="row_1">
		          <td><label>Product Name</label></td>
		          <td class="td-resize">
		               <div class="input-control select info-state">
		                  <select id="select_listProduct" class="form-control">
		                     <c:forEach var="item" items="${listProduct}">
		                        <option
		                        data-id="
		                        <c:out value="${item.productID}">
		                        </c:out>
		                        ">
		                        <c:out value="${item.providerName}">
		                        </c:out>
		                        </option>
		                     </c:forEach>
		                  </select>
		               </div>
		            </td> 
		            <td><label>Product Type</label></td>
		            <td class="td-resize">
		               <div class="input-control select info-state">
		                  <select id="select_listProductType" class="form-control">
		                     <c:forEach var="item" items="${listProvider}">
		                        <option
		                        data-id="
		                        <c:out value="${item.providerID}">
		                        </c:out>
		                        ">
		                        <c:out value="${item.providerName}">
		                        </c:out>
		                        </option>
		                     </c:forEach>
		                  </select>
		               </div>
		            </td>
		         </tr>
		         <tr>
		         <td><label>Manufacturer Name</label></td>
		            <td class="td-resize">
		               <div class="input-control select info-state">
		                  <select id="select_listManufacturerName" class="form-control">
		                     <c:forEach var="item" items="${listProvider}">
		                        <option
		                        data-id="
		                        <c:out value="${item.providerID}">
		                        </c:out>
		                        ">
		                        <c:out value="${item.providerName}">
		                        </c:out>
		                        </option>
		                     </c:forEach>
		                  </select>
		               </div>
		            </td>   
		            <td><label>Provider Name</label></td>
		            <td class="td-resize">
		               <div class="input-control select info-state">
		                  <select id="select_providerName" class="form-control">
		                     <c:forEach var="item" items="${listProvider}">
		                        <option
		                        data-id="
		                        <c:out value="${item.providerID}">
		                        </c:out>
		                        ">
		                        <c:out value="${item.providerName}">
		                        </c:out>
		                        </option>
		                     </c:forEach>
		                   </select>
		                </div>
		             </td>   
		          </tr>
		          <tr>
		             <td><label>Min Stock</label></td>
		             <td>
		                <div class="input-control text  info-state">
		                   <input class="form-control" id="minStock" placeholder="0" onkeypress="return IsNumeric(event);" ondrop="return false;" type="number">
		                </div>
		             </td>
		             <td><label>Max Stock</label></td>
		             <td><input class="form-control" id="maxStock" placeholder="0" onkeypress="return IsNumeric(event);" ondrop="return false;" type="number"></td>
		          </tr>
		          <tr>
		           <td><label>Price</label></td>
		           <td colspan="3">
		                <div class="input-control text  info-state">
		                  <input class="form-control" id="price" placeholder="0" onkeypress="return IsNumeric(event);" ondrop="return false;" type="number">
		                </div>
		             </td>
		          </tr>
		       </tbody>
		    </table>
		 </div>
		<div id="col10" class="col-lg-11">
			<textarea class="form-control" rows="5"></textarea>
		</div>
		<div class="col-lg-11">
		      <table class="table no-border dock-right">
		         <tbody>
		            <tr>
		               <td>
		                  <button id="saveData" type="submit" class="btn btn-primary">Save Data</button>
		               </td>
		               <td>
		                  <button id="createNew" type="submit" class="btn btn-success">Create New</button>
		               </td>
		               <td>
		                  <button id="cancel" type="submit" class="btn btn-danger">Cancel</button>
		               </td>
		            </tr>
		         </tbody>
		      </table>
   		</div>
   </div>
 </div>
 <script>
	 $("#input-4").fileinput({showCaption: false}); 
 </script>
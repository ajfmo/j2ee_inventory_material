<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="packing" >
	<div class=contain>
	<h1>Stock Adjustment</h1>
	
	<form class="form-inline">
		<div class="row">
            <select id="select_stockName" class="form-control">
               <c:forEach var="item" items="${listStock}">
                  <option
                  data-value="
                  <c:out value="${item.stockID}">
                  </c:out>
                  ">
                  <c:out value="${item.stockName}">
                  </c:out>
                  </option>
               </c:forEach>
            </select>
			<button id="searchInven" class="btn btn-primary" type="button">Search</button>
			<button id="saveInven" class="btn btn-success" type="button">Save Data</button>
			<button id="cancelInven" class="btn btn-danger" type="button">Cancel</button>
			<button id="printInven" class="btn btn-default" type="button">Print</button>
		</div>
		
		<div class="row" style="margin-top: 15px">
			<table id="tableInven" class="table table-striped table-bordered">
               <thead>
                  <tr>
                     <th width="10%">ID</th>
                     <th width="20%">Product Name</th>
                     <th width="20%">Real Quantity</th>
                     <th width="20%">Theoretical Quantity</th>
                     <th width="10%">Different</th>
                     <th width="15%">Unit Price</th>
                     <th width="5%">Sub Total</th>
                  </tr>
               </thead>
               <tbody>
               </tbody>
            </table>
		</div>
	</form>
</div>
</div>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Inventory And Material Management</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" type="text/css">
</head>
<body>
<h1>
	Hello world!  
</h1>

	<P>  The time on the server is ${serverTime}. </P>
	<p> ProductID:  ${product1.getProductID()}</p>
</body>
</html>

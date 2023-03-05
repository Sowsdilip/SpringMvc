<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BooksAvaialble</title>
</head>
<body>
	<h1 style="text-align: center; vertical-align: middle">Welcome to
		Mads Library !!!</h1>

	<div>
		<br>
		<table>
			<tr>
				<td style="align: center; vertical-align: middle;"><a
					href="home"><b>Home</b></a></td>
			</tr>
		</table>
	</div>
	<br>
	<br>

	<table>
	        <tr>
				<td style="align: center; vertical-align: middle;"><b><i>Book Name</i></b>&nbsp;&nbsp;&nbsp; </td>
                 
				<td style="align: center; vertical-align: middle;"><b><i>Quantity</i></b></td>
						
			</tr>
			<tr> </tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td style="align: center; vertical-align: middle;">${book.name}&nbsp;&nbsp; </td>
                 
				<td style="align: center; vertical-align: middle;">${book.quantity} </td>
						
			</tr>
		</c:forEach>

	</table>
</body>
</html>
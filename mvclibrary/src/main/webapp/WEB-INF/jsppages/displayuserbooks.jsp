<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 style="text-align: center; vertical-align: middle">Welcome to
		Mads Library !!!</h1>


	<br>
	<br>
	
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
	
	<form action="display-user-books-result">
		<table>
		
			<tr style="text-align: center; vertical-align: middle">
				<td style="text-align: center; vertical-align: middle">Enter User
					Name</td> 
			     
				<td style="text-align: center; vertical-align: middle"><input
					type="text" name="uname"></td>
			</tr>
			

			
			<tr>
				<td><input type="submit" name="id" value="showUserBooks" ></td>
			</tr>

		</table>

	</form>

</body>
</html>
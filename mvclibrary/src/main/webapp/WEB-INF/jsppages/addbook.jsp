<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Book</title>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
	
	<form action="addbooks">
		<table>
			<tr style="text-align: center; vertical-align: middle">
				<td style="text-align: center; vertical-align: middle">Book
					Name</td>
				<td style="text-align: center; vertical-align: middle"><input
					type="text" name="name"></td>
			</tr>
			<tr style="text-align: center; vertical-align: middle">
				<td style="text-align: center; vertical-align: middle">Quantity
				</td>
				<td style="text-align: center; vertical-align: middle"><input
					type="text" name="quantity"></td>

			</tr>
			<tr>
				<td><input type="submit" name="id" value="addBook" ></td>
			</tr>

		</table>

	</form>

</body>
</html>
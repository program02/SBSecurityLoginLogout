<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form action="login" method="post">
		<div class="form-group">
			<label for="name">UserName</label> <input
				type="text" class="form-control" id="name" name="username"
				aria-describedby="name" placeholder="Enter name">

		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1" name="password"
				placeholder="Password">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>
</body>
</html>
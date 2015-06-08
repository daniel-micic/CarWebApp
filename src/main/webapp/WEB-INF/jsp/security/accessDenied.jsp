<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<title>CarWebApp</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
</head>
<body>

	<nav id="myNavbar"
		class="navbar navbar-default navbar-inverse navbar-fixed-top">
		<div class="container">
			<ul class="nav navbar-nav">
				<li><a href="../cars.html">Cars</a></li>
				<li><a href="../admin/addForm.html">Admin</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row" id="carSection">
			Access is denied for this user
			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" method="post">
				<input type="submit" value="Log out and try again" /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</body>
</html>
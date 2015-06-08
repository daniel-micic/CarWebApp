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
				<li><a href="cars.html">Cars</a></li>
				<li><a href="admin/addForm.html">Admin</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row" id="picker">
			<form:form id="form" method="post" commandName="carSelect"
				action="cars.html">
				<div class=col-md-3></div>
				<div class=col-md-2>Pick Your Car</div>
				<div class=col-md-2>
					<form:select path="name" items="${cars}" />
				</div>
				<div class=col-md-2>
					<input type="submit" value="show">
				</div>
				<div class=col-md-3></div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}"/>
			</form:form>
		</div>


		<div class="row" id="carSection">
			<img src="<c:url value="${car.url}" />"/>
			<h2>
				<c:out value="${car.name}" />
			</h2>
			<table>
				<tbody>
					<tr>
						<td>Cylinders:</td>
						<td><c:out value="${car.cylinders}" /></td>
					</tr>
					<tr>
						<td>Capacity:</td>
						<td><c:out value="${car.capacity}" /> cc</td>
					</tr>
					<tr>
						<td>Wheel drive:</td>
						<td><c:out value="${car.drive}" /></td>
					</tr>
					<tr>
						<td>Total max power:</td>
						<td><c:out value="${car.power}" /> Kw</td>
					</tr>
					<tr>
						<td>Total max torque:</td>
						<td><c:out value="${car.torque}" /> Nm</td>
					</tr>
					<tr>
						<td>Empty mass:</td>
						<td><c:out value="${car.weight}" /> kg</td>
					</tr>
					<tr>
						<td>Dimensions:</td>
						<td><c:out value="${car.length}" /> mm x <c:out
								value="${car.width}" /> mm x <c:out value="${car.height}" /> mm
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
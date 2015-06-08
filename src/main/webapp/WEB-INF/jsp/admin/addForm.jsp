<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>CarWebApp</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
</head>
<body>

	<nav id="myNavbar"
		class="navbar navbar-default navbar-inverse navbar-fixed-top">
		<div class="container">
			<ul class="nav navbar-nav">
				<li><a href="../cars.html">Cars</a></li>
				<li><a href="addForm.html">Add</a></li>
				<li><a href="editForm.html">Edit</a></li>
				<li><a href="deleteForm.html">Delete</a></li>
				<li><a href="../security/logout.html">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row" id="carSection">
			<h2>Add a Car</h2>
			<form:form method="post" modelAttribute="carAdd"
				action="addForm.html">
				<table>
					<tbody>
						<tr>
							<td><form:errors path="name" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="cylinders" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="capacity" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="drive" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="power" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="torque" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="weight" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="length" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="width" cssClass="error"></form:errors></td>
						</tr>
						<tr>
							<td><form:errors path="height" cssClass="error"></form:errors></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td>Name:</td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td>Cylinders:</td>
							<td><form:input path="cylinders" /></td>
						</tr>
						<tr>
							<td>Capacity:</td>
							<td><form:input path="capacity" /> cc</td>
						</tr>
						<tr>
							<td>Wheel drive:</td>
							<td><form:input path="drive" /></td>
						</tr>
						<tr>
							<td>Total max power:</td>
							<td><form:input path="power" /> Kw</td>
						</tr>
						<tr>
							<td>Total max torque:</td>
							<td><form:input path="torque" /> Nm</td>
						</tr>
						<tr>
							<td>Empty mass:</td>
							<td><form:input path="weight" /> kg</td>
						</tr>
						<tr>
							<td>Length:</td>
							<td><form:input path="length" /> mm</td>
						</tr>
						<tr>
							<td>Width:</td>
							<td><form:input path="width" /> mm</td>
						</tr>
						<tr>
							<td>Height:</td>
							<td><form:input path="height" /> mm</td>
						</tr>
						<tr>
							<td><input type="submit" value="Add" /></td>
						</tr>

					</tbody>
				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>


</body>
</html>
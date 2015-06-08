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
			<h2>Add a Picture</h2>
			<form:form method="post" modelAttribute="imageFile"
				action="addPicForm.html" enctype="multipart/form-data">
				<table>
					<tbody>
						<tr>
							<td><form:errors path="name" cssClass="error"></form:errors></td>
						</tr>
						
					</tbody>
				</table>
				<table>
					<tbody>
						<tr>
							<td>File to upload: <input type="file" name="file"></td>
						</tr>
						<tr>
        					<td><input type="submit" value="Upload"> Press here to upload the file!</td>
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
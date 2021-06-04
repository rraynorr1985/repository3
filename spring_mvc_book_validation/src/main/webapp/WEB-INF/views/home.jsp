<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="container bg-light">
<h1>Books</h1>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Add Book</legend>
		<form:form action="addBook" method="POST" modelAttribute="book">
			<div>
				<label>Title</label><br>
				<form:input type="text" id="title" path="title" /><br>
				<form:errors class="text-danger" path="title" /><br>
			</div>
			<div>
				<label>Author</label><br>
				<form:input type="text" id="author" path="author" /><br>
				<form:errors class="text-danger" path="author" /><br>
			</div>	
			<div>		
				<input type="submit" name="submit" value="Add" />
			</div>
		</form:form>
	</fieldset>
</div>
<div>
	<fieldset class="border border-dark p-2">
		<legend class="w-auto">Book List</legend>
		<table class="table table-striped">
			<tr>
				<td class="font-weight-bold">Book ID</td>
				<td class="font-weight-bold">Title</td>
				<td class="font-weight-bold">Author</td>
				<td></td>
			</tr>
			<c:forEach items="${books }" var="b">
				<tr>
					<td>${b.bookId }</td>
					<td>${b.title }</td>
					<td>${b.author }</td>
					<td><a href="${pageContext.request.contextPath}/deleteBook?id=${b.bookId}">Remove Book</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</div>
</body>
</html>
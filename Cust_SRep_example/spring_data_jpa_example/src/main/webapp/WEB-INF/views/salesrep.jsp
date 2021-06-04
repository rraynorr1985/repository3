<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Representative</title>
</head>
<body>
<div align="center">
    <h2>Sales Representative</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="newsalesrep">New Sales Representative</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Office code</th>
        </tr>
        <c:forEach items="${listSalesRep}" var="salesrep">
        <tr>
            <td>${salesrep.id}</td>
            <td>${salesrep.name}</td>
            <td>${salesrep.officeCode}</td>
            <td>
                <a href="editsr?id=${salesrep.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="deletesrep?id=${salesrep.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <form action="${pageContext.request.contextPath}/"><input type="submit" value="Home"></form>
</div>   
</body>
</html>
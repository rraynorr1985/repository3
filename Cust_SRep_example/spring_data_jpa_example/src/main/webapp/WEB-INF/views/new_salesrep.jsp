<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Sales Representative</title>
</head>
<body>
    <div align="center">
        <h2>New Sales Representative</h2>
        <form:form action="saverep" method="post" modelAttribute="salesrep">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Office Code: </td>
                    <td><form:input path="officeCode" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                    
            </table>
        </form:form>
        <form action="${pageContext.request.contextPath}/salesrep"><input type="submit" value="Cancel"></form>
    </div>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<c:forEach items="${listProduct}" var="prduct">
    <p>${prduct.id}</p>
    <p>${prduct.name}</p>
    <p>${prduct.address}</p>
    <p>${prduct.subject}</p>
</c:forEach>
</body>
</html>
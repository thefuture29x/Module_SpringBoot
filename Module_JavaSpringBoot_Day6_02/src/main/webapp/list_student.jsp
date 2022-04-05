<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/5/2022 AD
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-striped" style="padding: 50px;">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Address</th>
        <th scope="col" colspan="2">Tools</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${listStudent}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.address}</td>
            <td>
                <form action="student" method="get">
                    <button type="submit" class="btn btn-primary" value="${student.id}" name="id_student" >Edit</button>
                </form>
            </td>
            <td>
                <form action="student" method="put">
                    <button type="submit" class="btn btn-primary" value="${student.id}" name="id_student" >Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>

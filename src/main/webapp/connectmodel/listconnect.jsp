<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/29/2021
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            text-align: center;
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th {
            background-color: #4CAF50;
            color: white;
        }
        button{
            border-radius: 8px;
            background: aqua;
        }
        body{
            text-align: center;
        }
    </style>
</head>
<body>

<h3>
    <a href="book?action=createBook">Thêm mới</a>
</h3>

<table>
    <tr>
        <th>ID</th>
        <th>Tên Sách</th>
        <th>Thể loại</th>
        <th>Giá bán</th>
        <th>Tác giả</th>
        <th colspan="2">Action</th>

    </tr>
    <c:forEach items='${requestScope["modelConnectionList"]}' var="m">
        <tr>
            <td>${m.getBook().getId()}</td>
<%--            <td><a href="/student?action=view&id=${s.getId()}">${s.getName()}</a></td>--%>
            <td>${m.getBook().getName()}</td>
            <td>${m.getBook().getCategory()}</td>
            <td>${m.getBook().getPrice()}</td>
            <td>${m.getAuthor().getName()}</td>
            <td><a href="/book?action=updateBook&id=${m.getBook().getId()}">Chỉnh sửa</a></td>
            <td><a href="/book?action=deleteBook&id=${m.getBook().getId()}">Xóa</a></td>
        </tr>
    </c:forEach>
</table>



</body>
</html>

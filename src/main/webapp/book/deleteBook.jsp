<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/29/2021
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .message{
            color: darkmagenta;
        }
    </style>
</head>
<body>
<h1>Xóa sách</h1>
<h3><a href="/connectmodel">Quay lại </a></h3>

<h4>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</h4>

<form action="" method="post">
    <h3>Bạn chắc chắn muốn xóa</h3>
    <fieldset>
        <table>
            <tr>
                <td>Tên sách:</td>
                <td>${requestScope["book"].getName()}</td>
            </tr>
            <tr>
                <td>Mô tả</td>
                <td>${requestScope["book"].getCategory()}</td>
            </tr>

            <tr>
                <td>Giá bán</td>
                <td>${requestScope["book"].getPrice()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Xóa"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TruongDubai
  Date: 5/29/2021
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1> Create New Book</h1>
<h2>
    <a href="/">Ve trang chu</a>
</h2>

<form  method="post">
    <c:if test='${requestScope["message"] != null}'>
        <h2 class="message">${requestScope["message"]}</h2>
    </c:if>
    <table>
        <tr>
            <td>Tên sách:</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>Thể loại:</td>
            <td><input type="text" name="category" id="category"></td>
        </tr>
        <tr>
            <td>Giá bán:</td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td>Tác giả</td>
            <td>
                <select name="listAuthor" id="" multiple>
                    <c:forEach var="l" items="${authorList}">
                        <option value="${l.getId()}">${l.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Thêm mới"></td>
        </tr>
    </table>
</form>


</body>
</html>

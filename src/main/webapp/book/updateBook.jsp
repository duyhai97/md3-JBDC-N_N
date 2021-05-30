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
<h1>Sửa thông tin hoc sinh</h1>
<h3><a href="/">Quay lại</a></h3>

<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>

<form  method="post">
    <table>
        <tr>
            <td>Tên sách:</td>
            <td><input type="text" name="name"  value="${requestScope["book"].getName()}"></td>
        </tr>
        <tr>
            <td>Thể loại:</td>
            <td><input type="text" name="category" value="${requestScope["book"].getCategory()}"></td>
        </tr>
        <tr>
            <td>Giá bán: </td>
            <td><input type="text" name="price"  value="${requestScope["book"].getPrice()}"></td>
        </tr>
        <tr>
            <td>Tác giả:</td>
            <td>
                <select name="authorId" >
                    <c:forEach items="${authorList}" var="a">
                        <option value="${a.getId()}">${a.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Nhấn đê :v"></td>
        </tr>
    </table>
</form>


</body>
</html>

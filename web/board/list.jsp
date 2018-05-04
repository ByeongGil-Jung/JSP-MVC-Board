<%--
  Created by IntelliJ IDEA.
  User: ByeongGil Jung
  Date: 2018-04-26
  Time: ¿ÀÀü 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
            <td>Order</td>
            <td>Name</td>
            <td>Title</td>
            <td>Date</td>
            <td>Hit</td>
        </tr>
        <c:forEach items="${requestScope['list']}" var="dto">
            <tr>
                <td>${dto['bId']}</td>
                <td>${dto['bName']}</td>
                <td>
                    <c:forEach begin="1" end="${dto['bIndent']}">-</c:forEach>
                    <a href="contentView.boardDo?bId=${dto['bId']}">${dto['bDate']}</a>
                </td>
                <td>${dto['bDate']}</td>
                <td>${dto['bHit']}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5">
                <a href="./write.jsp">Write</a>
            </td>
        </tr>
    </table>
</body>
</html>

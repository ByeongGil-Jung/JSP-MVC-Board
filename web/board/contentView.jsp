<%--
  Created by IntelliJ IDEA.
  User: ByeongGil Jung
  Date: 2018-05-04
  Time: ¿ÀÈÄ 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR"%>
<html>
<head>
    <title>ContentView</title>
</head>
<body>
    <form action="modify.boardDo" method="post">
        <input type="hidden" name="bId" value="${requestScope["contentView"]["bId"]}"/>
        <table width="500" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td>Order</td>
                <td>${requestScope["contentView"]["bId"]}</td>
            </tr>
            <tr>
                <td>Hit</td>
                <td>${requestScope["contentView"]["bHit"]}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td> <input type="text" name="bName" value="${requestScope["contentView"]["bName"]}"/> </td>
            </tr>
            <tr>
                <td>Title</td>
                <td> <input type="text" name="bTitle" value="${requestScope["contentView"]["bTitle"]}"/> </td>
            </tr>
            <tr>
                <td>Content</td>
                <td> <textarea name="bContent" rows="10">${requestScope["contentView"]["bContent"]}</textarea> </td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="Modify"/> &nbsp;&nbsp; <a href="/board/list.boardDo">Go List</a> &nbsp;&nbsp; <a href="">Delete</a> &nbsp;&nbsp; <a href="">Reply</a> </td>
            </tr>
        </table>
    </form>
</body>
</html>

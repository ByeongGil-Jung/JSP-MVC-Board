<%--
  Created by IntelliJ IDEA.
  User: ByeongGil Jung
  Date: 2018-05-06
  Time: ¿ÀÈÄ 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR"%>
<html>
<head>
    <title>ReplyView</title>
</head>
<body>
    <form action="/board/reply.boardDo" method="post">
        <table width="500" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td>Order</td>
                <td>${requestScope["replyView"]["bId"]}</td>
            </tr>
            <tr>
                <td>Hit</td>
                <td>${requestScope["replyView"]["bHit"]}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td> <input type="text" name="bName" value="${requestScope["replyView"]["bName"]}"/> </td>
            </tr>
            <tr>
                <td>Title</td>
                <td> <input type="text" name="bTitle" value="${requestScope["replyView"]["bTitle"]}"/> </td>
            </tr>
            <tr>
                <td>Content</td>
                <td> <textarea rows="10" name="bContent">${requestScope["replyView"]["bContent"]}</textarea> </td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="Write Reply"/> &nbsp;&nbsp; <a href="/board/list.boardDo">Go List</a> </td>
            </tr>
        </table>
    </form>
</body>
</html>

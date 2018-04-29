<%--
  Created by IntelliJ IDEA.
  User: ByeongGil Jung
  Date: 2018-04-29
  Time: ¿ÀÀü 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR"%>
<html>
<head>
    <title>Write</title>
</head>
<body>
    <form action="write.boardDo" method="post">
        <table width="500" cellpadding="0" cellspacing="0" border="1">
            <tr>
                <td>Name</td>
                <td> <input type="text" name="bName" size="50"/> </td>
            </tr>
            <tr>
                <td>Title</td>
                <td> <input type="text" name="bTitle" size="50"/> </td>
            </tr>
            <tr>
                <td>Content</td>
                <td> <textarea name="bContent" rows="10"></textarea> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Write"/> &nbsp;&nbsp; <a href="/board/list.boardDo">Go List</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

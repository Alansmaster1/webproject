<%--
  Created by IntelliJ IDEA.
  User: You
  Date: 2020/12/02
  Time: 下午 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="RegisterServlet" method="post">
        <table border="2">
            <tr>
                <th>用户名</th>
                <td>
                    <input type="text" name="username" />
                </td>
            </tr>
            <tr>
                <th>密码</th>
                <td>
                    <input type="text" name="passwd" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="注册" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

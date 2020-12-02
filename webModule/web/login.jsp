<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登录页面</title>
</head>
<body>
<form action="CheckServlet" method="post">
  <table>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="username" id="username"></td>
    </tr>

    <tr>
      <td>密码：</td>
      <td><input type="password" name="passwd" id="password"></td>
    </tr>
    <tr>
      <td><input type="submit" value=登录></td>
    </tr>
    <tr>
      <a href="register.jsp">注册</a>
    </tr>

  </table>
</form>
</body>
</html>
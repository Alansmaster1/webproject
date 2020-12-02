<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>列表</title>
</head>
<body onload="a()">
    <table>
        <c:forEach items="${items}" varStatus="itemStatus" var="item">
            <tr>
                <td>
                    <form action="AddToAccServlet" method="post">
                        <button name="item" type="submit">${item}</button>
                        <comment name="username">
                            <%= request.getAttribute("username") %>
                        </comment>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>

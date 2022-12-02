<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/12/1
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
    <body>
    <table>
        <tr><td>发票申请时间</td><td>发票抬头</td><td>发票金额</td><td>上联地址</td><td>处理状态</td><td>操作</td></tr>
        <c:forEach items="${list}" var="li">
            <tr>
                <td>${li.creatorTime}</td>
                <td>${li.enterpriseId}</td>
                <td>${li.amount}</td>
                <td>${li.uplinkAddress}</td>
                <td>${li.status}</td>
            </tr>
        </c:forEach>
    </table>

    </body>
</html>

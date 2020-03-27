<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/24
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
成功跳转了
name : ${requestScope.name}<br>
user : ${requestScope.user}<br>
userList : ${requestScope.userList}<br><br><br><br><br><br><br>


name2 : ${requestScope.name2}<br>
<%--map:${requestScope.map}<br><br><br><br><br>--%>

<c:forEach var="item" items="${map}">
    ${item.key} > ${item.value} <br>
</c:forEach><br><br><br><br><br><br>


session:${sessionScope.name2}<br>
session2:${sessionScope.user2}

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/24
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这里是首页
<form action="${pageContext.request.contextPath}/testjsp2mvcc2" method="post">
    用户名：<input type="text" value="" name="userName">
    <br/><br/>
    <%--密 码：<input type="text" value="" name="password">--%>
    <%--<br/><br/>--%>
    年 龄：<input type="text" value="" name="age">
    <br/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>

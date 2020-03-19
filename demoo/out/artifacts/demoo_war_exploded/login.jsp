<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/11
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%--<meta charset="utf-8"/>--%>
    <title>测试登录</title>
</head>
<body>
 ${param.msg}

<form action="<%=request.getContextPath()%>/userServlet" method="post">
    <input name="act" type="hidden" value="login">
    <input name="username" /><br/>
    <input name="userpwd" type="password"/><br/>
    <input type="submit" value="登录"/>
</form>

 <form action="<%=request.getContextPath()%>/userServlet" method="post">
     <input name="act" type="hidden" value="findall">
     <input type="submit" value="查询所有用户"/>
 </form>
</body>
</html>

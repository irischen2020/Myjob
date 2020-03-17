<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>测试网页</title>
</head>
<body>
欢迎你, ${param.username}

<br/>
<br/>
${requestScope.list}--EL表达式，从request值域取出所有用户
<br/>
<br/>
JSTL+EL表达式,循环取出所有用户
<br/>
<br/>
<c:forEach items="${requestScope.list}" var="user">
    ${user.userName} --${user.userPwd}
</c:forEach>

</body>
</html>

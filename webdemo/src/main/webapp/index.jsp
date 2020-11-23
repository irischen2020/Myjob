<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/23
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--如何从页面发起PUT,DELETE形式的请求？SPRING提供了对REST风格的支持
    1、web.xml 里面配置Filter,它可以把普通的请求转化为规定形式的请求
        <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    2、如何发起其它形式请求？
        第一：先创建一个POST类型的表单；第二：表单项中携带一个_method参数；第三：--%>

<a href="book/1" method="get">查询图书</a>

<form action="book" method="post">
    <input type="submit" value="添加1号图书"/>
</form><br/>

<form action="book/1" method="post">
    <input name="_method" value="delete"/>
    <input type="submit" value="删除1号图书"/>
</form>

<form action="book/1" method="post">
    <input name="_method" value="put"/>
    <input type="submit" value="更新1号图书"/>
</form>

</body>
</html>

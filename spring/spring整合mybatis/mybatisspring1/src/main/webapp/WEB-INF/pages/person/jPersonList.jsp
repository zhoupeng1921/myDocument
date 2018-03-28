<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
新增人员信息
<a href="${pageContext.request.contextPath}/person/tocreate.action" >新增</a>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>备注</td>
    </tr>
    <c:forEach items="${personList}" var="p" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${p.name}</td>
            <td>${p.age}</td>
            <td>${p.remark}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>

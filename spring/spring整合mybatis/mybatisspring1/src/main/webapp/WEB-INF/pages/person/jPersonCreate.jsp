<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">
        function formSubmit() {
            document.forms[0].action = "${pageContext.request.contextPath}/person/insert.action"
            document.forms[0].submit();
        }
    </script>
</head>
<body>
保存人员信息<br/>
<form action="#" method="post">
    <a href="#" onclick="formSubmit()">保存</a>
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age"></td>
        </tr>
        <tr>
            <td>备注</td>
            <td><input type="text" name="remark"></td>
        </tr>
    </table>

</form>
</body>
</html>

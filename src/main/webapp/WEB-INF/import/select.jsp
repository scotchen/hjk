<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<th width="10%">xx：</th>
<td width="40%">
    <select name="brand">
        <c:forEach items="${brands}" var="val">
            <option value="${val.key}">${val.value}</option>
        </c:forEach>
    </select>
</td>
</body>
</html>

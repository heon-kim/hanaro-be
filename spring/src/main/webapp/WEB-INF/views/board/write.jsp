<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/write" method="post">
    <label>
        제목:
        <input name="title"/>
    </label>
    <label>
        내용:
        <input name="content"/>
    </label><label>
        작성자:
        <input name="writer"/>
    </label>
    <input type="submit" value="추가">

</form>
</body>
</html>
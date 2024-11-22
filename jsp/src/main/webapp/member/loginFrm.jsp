<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/login.action" method="get">
    <label>
        아이디
        <input name="userId" />
    </label>
    <label>
        비밀번호
        <input name="userPwd" />
    </label>
    <input type="submit" value="로그인" />
</form>
</body>
</html>
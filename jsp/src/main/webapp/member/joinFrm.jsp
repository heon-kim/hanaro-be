<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Join</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/join.action" method="get">
    <table>
        <tr> 회원 가입 정보 </tr>
        <tr><th>아이디</th><td><input name="userId"/></td><th>비밀번호</th><td><input name="userPwd"/></td></tr>
        <tr><th>이름</th><td><input name="userName"/></td><th>이메일</th><td><input name="email"/></td></tr>
        <tr> <input type="submit" value="가입하기"><br /></tr>
    </table>
</form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member/update.action" method="get">
<table>
    <tr> 회원 가입 정보 </tr>
    <tr>
        <th>아이디</th><td><input name="userId" value=${member.userId} /></td>
        <th>비밀번호</th><td><input name="userPwd" value=${member.userPwd} /></td>
    </tr>
    <tr>
        <th>이름</th><td><input name="userName" value=${member.userName} /></td>
        <th>이메일</th><td><input name="email" value=${member.email} /></td>
    </tr>
    <tr> <input type="submit" value="수정하기"></tr>
</table>
</form>
</body>
</html>
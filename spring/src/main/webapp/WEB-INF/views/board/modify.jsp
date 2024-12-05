<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Write</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/modify?bno=${board.bno}" method="post">
    <ul>
        <li>게시글 번호: ${board.bno}</li>
        <li>제목: <input type="text" name="title" value="${board.title}" /></li>
        <li>내용: <input type="text" name="content" value="${board.content}" /></li>
        <li>작성자: <input type="text" name="writer" value="${board.writer}" /></li>
        <li>등록일: <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></li>
        <li>조회수: ${board.hit}</li>
    </ul>
    <input type="submit" value="수정">
</form>
</body>
</html>
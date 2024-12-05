<%--
  Created by IntelliJ IDEA.
  User: campus2H032
  Date: 24. 11. 26.
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Board</title>
</head>
<body>
    <ul>
        <li>게시글 번호: ${board.bno}</li>
        <li>제목: ${board.title}</li>
        <li>내용: ${board.content}</li>
        <li>작성자: ${board.writer}</li>
        <li>등록일: <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></li>
        <li>조회수: ${board.hit}</li>
    </ul>
    <a href="${pageContext.request.contextPath}/board/modify?bno=${board.bno}">수정하기→</a>

</body>
</html>

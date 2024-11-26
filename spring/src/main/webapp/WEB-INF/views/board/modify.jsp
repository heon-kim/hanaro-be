<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Write</title>
    <style>
        ul {
            list-style-type: none;
        }
        li {
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="text"] {
            padding: 8px;
            border: 1px solid #f4f4f4;
        }
        a, input[type=submit] {
            padding: 8px 15px;
            margin-right: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
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
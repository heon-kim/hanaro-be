<%--
  Created by IntelliJ IDEA.
  User: campus2H032
  Date: 24. 11. 26.
  Time: 오후 3:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Board</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        a {
            text-decoration: none;
            color: black;
        }
        a:hover {
            color: blue;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
    </tr>
    <c:forEach items="${bList}" var="item">
        <tr>
            <td><a href="${pageContext.request.contextPath}/board/read?bno=${item.bno}">${item.bno}</a> </td>
            <td>${item.title}</td>
            <td>${item.content}</td>
            <td>${item.writer}</td>
            <td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
            <td>${item.hit}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

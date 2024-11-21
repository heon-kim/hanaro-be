<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book" method="post">
    책 아이디: <input type="text" name="bookId"><br />
    책 제목: <input type="text" name="bookName"><br />
    출판사: <input type="text" name="publisher"><br />
    가격: <input type="number" name="price"><br />
    <input type="submit" value="전송"><br />
</form>
</body>
</html>
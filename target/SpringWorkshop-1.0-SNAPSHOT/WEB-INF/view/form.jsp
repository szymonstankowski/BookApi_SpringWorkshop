<%--
  Created by IntelliJ IDEA.
  User: szymon
  Date: 28.08.2021
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form action="/books" method="post">
    ID:
    <input type="number" name="id">
    ISBN:
    <input type="text" name="isbn">
    TITLE:
    <input type="text" name="title">
    AUTHOR:
    <input type="text" name="author">
    PUBLISHER:
    <input type="text" name="publisher">
    TYPE:
    <input type="text" name="type">
    ADD BOOK:
    <input type="submit">
</form>

</body>
</html>

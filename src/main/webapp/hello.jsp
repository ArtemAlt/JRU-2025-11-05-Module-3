<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Приветствие</title>
</head>
<body>
<h1>Результат работы сервлета</h1>

<%-- Получаем данные, переданные сервлетом --%>
<p>Сообщение: <strong><%= request.getAttribute("message") %></strong></p>
<p>Время: <%= request.getAttribute("time") %></p>

<a href="index.jsp">← На главную</a>
</body>
</html>
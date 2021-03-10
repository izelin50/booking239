<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Результат</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <h2>Результат: ${conclusion}</h2>
    <h3>${stolPoluchen}<br>В случае возникновения спорной ситуации
        предъявите web-версию этой страницы.</h3>
    <form method="post" action="cancel">
        <button name="cancel" value="cancel">Прошу отменить заказ</button>

</body>
</html>

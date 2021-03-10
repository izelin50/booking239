<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Продолжительность трапезы</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>

<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <h2>Выберите желаемую продолжительность трапезы</h2>
    <h2>${netStola}</h2>
    <form method="post" action="end">
        <button type="submit" name="duration" value="1">5 минут</button>
        <button type="submit" name="duration" value="2">10 минут</button>
        <button type="submit" name="duration" value="3">15 минут</button>
    </form>

</center>
</body>
</html>

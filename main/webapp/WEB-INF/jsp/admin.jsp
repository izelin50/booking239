<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>ADMIN</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>

<center>

   <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <h2>Привет! Что желаешь сделать?</h2><br>
    <form method="post" action="admin">
        <h3>
            Исследуемый стол <input name="table" placeholder="стол">
            Исследуемый юзер <input name="id" placeholder="юзер">
            Добавление ключа <input type="password" name="key" placeholder="ключ">
        </h3>
        <button type="submit">Ввести</button>
    </form>
    <h3><form method="post" action="clear"><button type="submit"name="clear">Очистить!</button></form></h3>

    <h3> ${writen}<br class="mobile"/> ${password}<br class="mobile"/> ${stol}<br class="mobile"/>${clear}</h3>

</center>
</body>
</html>
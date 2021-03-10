<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Место трапезы</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>

</head>
<body>
<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>

    <h2>Добро пожаловать, ${message}!<br/>
    <h3>Если вы желаете сидеть с кем-то из друзей, вы можете ввести их id здесь</h3>
    <form method="post" action="second">
        <h3>
            <input type="text" required name="id" placeholder="Введите id друга"/>
        </h3>

        <button type="submit">Ввести</button>
    </form>

    <form method="post" action="place">
        <button type="submit" name="place" value="1">Я не желаю выбирать друга</button>
    </form>


</center>
</body>
</html>

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Авторизация</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="icon" href="resources/icon.png">
</head>
<body>

<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <div class="subscribe">
        <h2>Авторизация</h2>
        <form method="post" action="login">
            <h3><label>Логин: <input type="text" name="login"><br class="mobile"/>
            </label>
                <label>Пароль: <input type="password" name="pass">
                </label></h3>
            <button type="submit">Ввести</button>
        </form>
        <form method="post" action="forget1">
            <button type="submit">Забыл пароль</button>

        </form>
        <form method="post" action="register">

            <button type="submit">Создать аккаунт</button>
        </form>
    </div>

</center>
</body>
</html>

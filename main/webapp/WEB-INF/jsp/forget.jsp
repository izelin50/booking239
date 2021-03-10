<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Восстановление аккаунта</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="icon" href="resources/icon.png">
</head>
<body>

<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <div class="subscribe">
        <h2>Введите логин</h2>
        <form method="post" action="forget">
            <h3>
                <label>Логин: <input type="text" name="login"></label> <br/>
            </h3>
            <button type="submit">Ввести</button>
        </form>

        <form method="post" action="register">
            <h3>Или нажмите</h3>
            <button type="submit">У меня нет аккаунта</button>
        </form>
    </div>

</center>
</body>
</html>

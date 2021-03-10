<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Авторизация</title>
    <link href="resources/project.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>

<center>
    <img class="header" src="resources/header.jpg" top="0" width="100%"/>
    <h2>Зарегистрируйтесь</h2>
    <h3>${forget}</h3>
    <form method="post" action="start">
        <h3>
            Логин не должен начинаться с "#"!
            <input type="text" name="login" placeholder="Придумайте логин" required><br class="mobile"/><br class="mobile"/>
            <input type="password" name="pass" placeholder="Придумайте пароль" required><br class="mobile"/><br class="mobile"/>
            <input type="password" name="key" placeholder="Введите ключ регистрации" required><br class="mobile"/><br class="mobile"/>
        </h3>
        <button type="submit">Ввести</button>


    </form>
    <h3>После нажатия этой кнопки вы будете перенаправлены на страницу входа.</h3>

</center>
</body>
</html>

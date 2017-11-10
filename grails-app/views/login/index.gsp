<!DOCTYPE html>

<html>
<head>
    <meta name="layout" content="session"/>
    <title>Proche Login</title>
</head>

<body>
    <div>Login to Proche</div>
    <form action="http://localhost:8080/Proche/login/authenticate" method="POST">
        <div>Email address <input id="emailAddressInput" type="text" name="emailAddress"/></div>
        <div>Password <input id="pwHidden" type="password" name="password"/></div>
        <div><input name="login" type="submit" value="Login"></div>
    </form>
</body>
</html>
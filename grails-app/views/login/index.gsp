<!DOCTYPE html>

<html>
<head>
    <meta name="layout" content="session"/>
    <title>Proche Login</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="shortcut icon" href="/ABCD/assets/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="/ABCD/assets/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/ABCD/assets/apple-touch-icon-retina.png">
    <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
    <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
    <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

    <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

    <meta name="layout" content="main">
</head>

<body>
    <br/>
    <h1>Login to Proche</h1>
    <br/>
    <form action="<g:createLink action='authenticate'/>" method="POST">
        <fieldset class="form">
            <div>Email address <input id="emailAddressInput" type="text" name="emailAddress"/></div>
            <div>Password <input id="pwHidden" type="password" name="password"/></div>
        </fieldset>

        <fieldset class="buttons">
            <input name="login" type="submit" value="Login">
        </fieldset>
    </form>
</body>
</html>
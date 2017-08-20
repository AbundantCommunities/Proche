<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

        <meta name="layout" content="main">
    </head>
    <body>
        <h1>Sample line</h1>
        <table>
        <g:each in="${assets}" var="asset">
            <tr><td>${asset.lname}</td><td>${assrt.organization}</td></tr>
        </g:each>
        </table>
    </body>
</html>

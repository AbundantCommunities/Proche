<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assets</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

        <meta name="layout" content="main">
    </head>

    <body>
        <h1>Assets</h1>

        <table>
        <g:each in="${countsByLetter}" var="letterCount">
            <g:link controller="Asset" action="listForLetter" firstLetter="${letterCount.letter}">
            <tr><td>${letterCount.letter}</td><td>${letterCount.count}</td></tr>
            </g:link>
        </g:each>
        </table>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suggested Asset List</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

        <meta name="layout" content="main">
    </head>

    <body>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="/ABCD/">Home</a></li>
            </ul>
        </div>

        <table>
        <g:each in="${sugs}" var="sug">
            <tr><td><g:link controller="AssetSuggestion" action="seeOne" id="${sug.id}">${sug.name}</g:link></td><td>${sug.organization}</td></tr>
        </g:each>
        </table>
    </body>
</html>

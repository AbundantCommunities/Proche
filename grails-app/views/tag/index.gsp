<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tagged Assets</title>
    </head>
    <body>
        <h1>Assets tagged with ${tagText}</h1>
        <g:each in="${assets}" var="asset">
            ${asset.name}<br/>
        </g:each>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Asset Class Hierarchy</title>

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
    <h1>The Asset Class Hierarchy</h1>
    <g:each in="${hierarchy}" var="majorNode" status="majorRow">
    <p>
        <g:link action="major" id="${majorNode.major.id}">
            <b>${majorNode.major.name}</b>
        </g:link>
        <br/>
        <g:each in="${majorNode.minors}" var="minor">
            &nbsp;&nbsp;&nbsp;&nbsp;<g:link action="minor" id="${minor.id}">${minor.name}</g:link>
            <br/>
        </g:each>
    </p>
    </g:each>
</body>
</html>

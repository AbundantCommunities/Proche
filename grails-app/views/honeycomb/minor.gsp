<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Assets of a Minor Class</title>

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
    <div id="edit-asset" class="content scaffold-edit" role="main">
        <h1>Assets of a Minor Class</h1>

        <p><g:link action="editMinor" id="${minor.id}">${minor.name}</g:link></p>
        <p><em>${minor.description}</em></p>
        <br/>
        <p>
        <g:each in="${pairs}" var="pair">
            <em>${pair.asset.name}</em> – ${pair.asset.shortDescription}
            <hr/>
        </g:each>
        </p>
    </div>
</body>
</html>

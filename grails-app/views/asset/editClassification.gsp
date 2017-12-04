<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Asset Classification</title>

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
    <h1>Edit Asset Classification</h1>
    <h2>${asset.name}</h2>

    <g:each in="${honeycomb}" var="augmentedMajor">
        <em>${augmentedMajor.major.name}</em>
        <br/>
        <g:each in="${augmentedMajor.augmentedMinors}" var="augmentedMinor">
            ${augmentedMinor.assetIsAssigned}
            <g:if test="${augmentedMinor.assetIsAssigned==Boolean.TRUE}">
                <a href='<g:createLink action="removeFromMinorClass" params="${[minorId:augmentedMinor.minor.id]}" id="${asset.id}"/>'>REMOVE</a>
            </g:if>
            <g:if test="${augmentedMinor.assetIsAssigned==Boolean.FALSE}">
                <a href='<g:createLink action="addToMinorClass" params="${[minorId:augmentedMinor.minor.id]}" id="${asset.id}"/>'>ADD</a>
            </g:if>
            ${augmentedMinor.minor.name}
            <br/>
        </g:each>
        <hr/>
    </g:each>

    </div>
</body>
</html>
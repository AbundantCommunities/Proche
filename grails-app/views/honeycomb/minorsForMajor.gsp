<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
</head>

<body>
    <h1>${major.name}</h1>
    <g:each in="${nodes}" var="node">
    <p>
        ${node.minorAssetClass.name}
    </p>
    </g:each>
</body>
</html>

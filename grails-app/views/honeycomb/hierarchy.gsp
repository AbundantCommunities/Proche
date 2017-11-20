<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sample title</title>
</head>

<body>
    <h1>The Asset Class Hierarchy</h1>
    <g:each in="${hierarchy}" var="majorNode" status="majorRow">
    <p>
        
        <g:link controller="majorAssetClass" action="${session.user?'edit':'view'}" id="${majorNode.major.id}">
            <b>${majorNode.major.name}</b>
        </g:link>
        <br/>
        <g:each in="${majorNode.minors}" var="minor">
            &nbsp;&nbsp;&nbsp;&nbsp;${minor.name}
            <br/>
        </g:each>
    </p>
    </g:each>
</body>
</html>

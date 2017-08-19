<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        <h1>The Asset Class Hierarchy</h1>
        <g:each in="${majorClasses}" var="major" status="majorRow">
            <p>
                <g:link controller="groupAsset" action="majorClass" id="$major.major.id">${major.major.name}</g:link><br/>
                <g:each in="${major.minors}" var="minor" status="minorRow">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <g:link controller="groupAsset" action="minorClass" id="$minor.id">${minor.name}</g:link><br/>
                </g:each>
            </p>
        </g:each>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Major Classifications</title>
</head>

<body>
    <h1>Major</h1>
    <g:each in="${majors}" var="major">
    <p>
        <g:link action="minorsForMajor" id="${major.id}">
            ${major.name}
        </g:link>
    </p>
    </g:each>
</body>
</html>

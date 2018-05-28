<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asset Categories</title>
    </head>
    <body>
        <h1>Asset Categories</h1>
        <table>
        <g:each in="${categories}" var="category">
            <tr>
                <td width="30%">
                    <g:link controller="category" action="${session.user?'edit':'view'}" id="${category.id}">
                    ${category.name}
                    </g:link>
                </td>
                <td width="70%">
                    <em>${category.description}</em>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>

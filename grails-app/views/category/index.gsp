<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asset Categories</title>
        <meta name="layout" content="main">
    </head>
    <body>
        <h1>Asset Categories</h1>
        <table>
            <tr>
                <td><g:link action="enter">ADD</g:link></td>
                <td>Add a new category</td>
            <tr>

        <g:each in="${categories}" var="category">
            <tr>
                <td width="30%">
                    ${category.name}
                    <g:link controller="category" action="get" id="${category.id}">REM</g:link>
                    <g:link controller="category" action="getOthers" id="${category.id}">ADD</g:link>
                </td>
                <td width="70%">
                    <em>${category.description}</em>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>

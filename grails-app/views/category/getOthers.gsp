<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Assets to Category</title>
        <meta name="layout" content="main">
    </head>
    <body>
        <h1>Add Assets to Category ${category.name}</h1>
        <table>
        <g:each in="${assets}" var="asset">
            <tr>
                <td width="30%">
                    <g:link controller="category" action="addAsset" id="${category.id}" params="${[assetId:asset.id]}">
                        ${asset.name}
                    </g:link>
                </td>
                <td width="70%">
                    <em>${asset.description}</em>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>

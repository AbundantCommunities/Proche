<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assets</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/ABCD/assets/application.js?compile=false" type="text/javascript" ></script>

        <meta name="layout" content="main">
    </head>

    <body>
        <h1>Assets containing "${q}"</h1>

        <table>
        <g:each in="${assets}" var="asset">
            <tr>
                <td>
                    <g:link controller="asset" action="edit" id="${asset.id}">
                    ${asset.name}
                    </g:link>
                </td>
                <td>
                    ${asset.organization}<br/>
                    <em>${asset.shortDescription}&hellip;</em>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>

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
        <h1>Found ${assets.size()} assets containing "${q}" in ${abcd.Community.get(communityId).name} Community</h1>
        <g:if test="${suggestionCount}">
            <p><em>We have ${suggestionCount} suggestions waiting for approval; they will not be found by search.</em></p>
            <br/>
        </g:if>

        <table>
        <g:each in="${assets}" var="asset">
            <tr>
                <td width="30%">
                    <g:link controller="asset" action="${session.user?'edit':'view'}" id="${asset.id}">
                    ${asset.name}
                    </g:link>
                </td>
                <td width="70%">
                    <g:if test="${!asset.active}"><div style="color: red">INACTIVE</div></g:if>
                    <b>${asset.organization}</b><br/>
                    <em>${asset.shortDescription}</em>
                </td>
            </tr>
        </g:each>
        </table>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suggested Assets</title>

        <link rel="stylesheet" href="/ABCD/assets/main.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/mobile.css?compile=false" />
        <link rel="stylesheet" href="/ABCD/assets/application.css?compile=false" />

        <script src="/Proche/assets/application.js?compile=false" type="text/javascript" ></script>
        <meta name="layout" content="main">

        <style>
        .step {
            padding: 10px;
            color: black;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .nextLink {
            padding: 10px;
            color: black;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .prevLink {
            padding: 10px;
            color: black;        
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .currentStep {
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        .step.gap {
            display: none;
        }

        .step:hover:not(.active) {
            background-color: #ddd;
        }
        </style>
    </head>

    <body>
        <table>
        <g:each in="${sugs}" var="sug">
            <tr>
                <td width="30%">
                    <g:link controller="assetSuggestion" action="edit" id="${sug.id}">
                    ${sug.name}
                    </g:link>
                </td>
                <td width="70%">
                    <b>${sug.organization}</b><br/>
                    <em>${sug.shortDescription}</em>
                </td>
            </tr>
        </g:each>
        </table>
        <br/>
        &nbsp;&nbsp;&nbsp;
        <g:paginate total="${sugCount}"/>
    </body>
</html>

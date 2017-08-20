<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Some TITLE</title>
    </head>
    <body>
        <h1>${majorClass.name}</h1>
        <p>${majorClass.description}</p>
        <g:each in="${minorClasses}" var="minorClass" status="row">
            <p>
                <g:link controller="Minor" action="index" id="${minorClass.id}">${minorClass.minorAssetClass.name}</g:link>
            </p>
        </g:each>
    </body>
</html>

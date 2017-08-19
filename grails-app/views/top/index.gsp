<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        <h1>What do you need help with?</h1>
        <g:each in="${majorClasses}" var="majorClass" status="row">
            <p>
                <g:link controller="Second" action="index" id="${majorClass.id}">${majorClass.name}</g:link>
            </p>
        </g:each>
    </body>
</html>

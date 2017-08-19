<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Major Asset Class</title>
    </head>
    <body>
        <h1>Major Asset Class</h1>
        <p><g:link controller="groupAsset" action="hierarchy">Back to hierarchy</g:link></p>
        <h2>${majorClass.name}</h2>
        ${majorClass.description}<br/>
        Sort order: ${majorClass.sortOrder}<br/>
        Keywords: ${majorClass.keywords}<br/>
    </body>
</html>

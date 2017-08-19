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
        <h2>${minorClass.name}</h2>
        <p><i>${minorClass.description}</i></p>
        <h3>Neighbours can help:</h3>
        <g:each in="${privateAssets}" var="privateAsset" status="row">
            <p>
                ${privateAsset.name}<br/>
                &nbsp;&nbsp;&nbsp;&nbsp;${privateAsset.walkingDistance} minutes away<br/>
                &nbsp;&nbsp;&nbsp;&nbsp;<b>Please connect me to this neighbour!</b>
            </p>
        </g:each>

        <br/>
        <h3>Groups can help:</h3>
        <g:each in="${groupAssets}" var="groupAsset" status="row">
            <p>
                ${groupAsset.name}<br/>
                &nbsp;&nbsp;&nbsp;&nbsp;12,345 minutes away<br/>
                &nbsp;&nbsp;&nbsp;&nbsp;<b>Show directions, hours, etc.</b>
            </p>
        </g:each>
    </body>
</html>

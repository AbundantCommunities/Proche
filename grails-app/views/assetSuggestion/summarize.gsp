<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Suggested Assets</title>
    </head>
    <body>
        <h1>Asset Suggestions</h1>
        <ul>
            <li>${all} on file</li>
            <li>${fresh} <g:link controller="AssetSuggestion" action="list">new, unresolved</g:link></li>
            <li>${accepted} accepted</li>
            <li>${rejected} rejected</li>
        </ul>

        <p></p>
    </body>
</html>

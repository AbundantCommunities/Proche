<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<title>View Public Asset</title>

<meta name="layout" content="basic">

<!-- On smaller displays prevent browser from simply scaling our content to teeny, tiny sized. -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
section {
    width: 100vw;
    max-width: 100ch;

    margin: 0 auto;
    padding: 1.5em 1em;
}<</style>

</head>
<body>

<div style="background-color:lightblue; padding-top: 10px; padding-left: 10px; padding-right: 00px; padding-bottom: 10px;">
<a href="http://cbc.ca"><img src="${resource(dir: 'images', file: 'back-button.png')}" alt="Back to previous page" onclick="window.history.go(-1); return false;"/></a>
&nbsp; &nbsp;
<a href="http://cuyeg.org"><img src="${resource(dir: 'images', file: 'CommunitiesUnited-COLOR-300dpi.png')}" alt="Communities United"/></a>
</div>

<div  style="font-family: Arial, Helvetica, sans-serif;">
<h2>${asset.name}</h2>

<div style="background-color:lightblue;">Run by</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">${asset.organization}</div>

<div style="background-color:lightblue;">They gave us this description</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">${asset.description}</div>

<div style="background-color:lightblue;">Cost</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">
    <g:if test="${asset.zeroCost == Boolean.TRUE}">
        Free
    </g:if>
    <g:else>
        Contact organizer for cost
    </g:else>
</div>

<div style="background-color:lightblue;">For more information</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">
    <g:if test="${asset.url}">
        <a href="${asset.url}" target="_blank">Go to website</a>
    </g:if>
    <g:elseif test="${asset.emailAddress}">
        Email <a href="mailto:${asset.emailAddress}?Subject=Information">${asset.emailAddress}<a>
    </g:elseif>
    <g:elseif test="${asset.phoneNumber}">
        Phone <a href="tel:+1${asset.phoneNumber}">${asset.phoneNumber}</a>
    </g:elseif>
</div>

<div style="background-color:lightblue;">Neighbourhood</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">${asset.community.name}</div>

<div style="background-color:lightblue;">Location</div>
<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">
    <g:if test="${asset.location == 'N/A'}">
        Address is not available; Here is a map of ${asset.community.name}
    </g:if>
    <g:else>
        ${asset.location}
    </g:else>
</div>

<div style="margin-left: 1em; margin-top: 0.2em; margin-bottom: 0.4em;">
<img src="${mapLink}"/>
</div>

</body>
</html>

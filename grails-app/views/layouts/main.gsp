<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <title><g:layoutTitle default="Grails"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">

    <g:layoutHead/>
    <g:javascript library="application"/>		
    <r:layoutResources />
</head>
<body>
    <div id="grailsLogo" role="banner"><a href="http://abundantcommunityinitiative.org"><img src="${resource(dir: 'images', file: 'CommunitiesUnited-COLOR-300dpi.png')}" alt="Communities United"/></a></div>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}">Home</a></li>
            <li><a class="list" href="${createLink(uri: '/asset/list')}">List</a></li>
            <li><a class="search" href="${createLink(uri: '/asset/initSearch')}">Search</a></li>
            <li><a class="suggest" href="${createLink(uri: '/assetSuggestion/list')}">Suggest</a></li>
        </ul>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>
    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
    <r:layoutResources />
</body>
</html>

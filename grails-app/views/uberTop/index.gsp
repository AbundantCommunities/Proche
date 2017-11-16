<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Communities United Public Assets</title>

    <meta name="layout" content="main">
</head>

<body>
    <h1>&nbsp;Public Assets for Residents of Bannerman, Clareview Campus, Fraser, Hairsine & Kirkness.</h1>
    <br/>
    <p>
        This website is not ready for general use.
        We are building up a list of public assets that anyone can take advantage of.
        [What are <a href="https://en.wikipedia.org/wiki/Asset-based_community_development" target="_blank">public assets</a>?]
    </p>
    <br/>
    <g:if test="${suggestionCount>0}">
        <p><em>We have ${suggestionCount} suggestion(s) waiting for approval.</em></p>
    </g:if>
    <br/>
    <p>
        We have ${assetCount} assets on file so far.
        Use the links above to have a look at them or to suggest an asset we don't have.
    </p>
    <br/>
    <p>
        Please write to Mark at
        <a href="mailto:mark@cognish.com?Subject=Communities%20United%20Database">mark@cognish.com</a>
        with questions, ideas, comments, favourite recipes, ...
    </p>
</body>
</html>
